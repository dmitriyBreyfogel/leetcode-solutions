from __future__ import annotations

import os
import subprocess
from collections import Counter
from datetime import datetime, timezone
from pathlib import Path


ROOT = Path(__file__).resolve().parents[1]
SRC = ROOT / "src"
README = ROOT / "README.md"

DIFFICULTIES = {
    "Easy": {
        "color": "00B8A3",
        "description": "Warm-up tasks and fundamentals",
    },
    "Medium": {
        "color": "FFC01E",
        "description": "Core algorithms and data structures",
    },
    "Hard": {
        "color": "FF375F",
        "description": "Deep dives and tougher problems",
    },
}

SOLUTION_EXTENSIONS = {
    ".java",
    ".kt",
    ".py",
    ".js",
    ".ts",
    ".cpp",
    ".c",
    ".cs",
    ".go",
    ".rs",
    ".swift",
}


def solution_files(difficulty: str) -> list[Path]:
    directory = SRC / difficulty
    if not directory.exists():
        return []

    return sorted(
        path
        for path in directory.rglob("*")
        if path.is_file() and path.suffix.lower() in SOLUTION_EXTENSIONS
    )


def badge(label: str, value: int | str, color: str) -> str:
    label = label.replace("-", "--").replace("_", "__").replace(" ", "%20")
    value = str(value).replace("-", "--").replace("_", "__").replace(" ", "%20")
    return f"https://img.shields.io/badge/{label}-{value}-{color}?style=for-the-badge"


def git_recent_solution_paths(limit: int = 6) -> list[Path]:
    tracked_dirs = [str((SRC / difficulty).relative_to(ROOT)) for difficulty in DIFFICULTIES]
    command = [
        "git",
        "log",
        "--name-only",
        "--pretty=format:",
        "--diff-filter=AM",
        "--",
        *tracked_dirs,
    ]

    try:
        result = subprocess.run(
            command,
            cwd=ROOT,
            check=True,
            capture_output=True,
            text=True,
            encoding="utf-8",
        )
    except (OSError, subprocess.CalledProcessError):
        return []

    seen: set[Path] = set()
    recent: list[Path] = []

    for raw_line in result.stdout.splitlines():
        if not raw_line.strip():
            continue

        path = ROOT / raw_line.strip()
        try:
            relative_parts = path.relative_to(SRC).parts
        except ValueError:
            continue

        if (
            len(relative_parts) >= 2
            and relative_parts[0] in DIFFICULTIES
            and path.suffix.lower() in SOLUTION_EXTENSIONS
            and path.exists()
            and path not in seen
        ):
            seen.add(path)
            recent.append(path)

        if len(recent) >= limit:
            break

    return recent


def human_title(path: Path) -> str:
    stem = path.stem
    title = []

    for index, char in enumerate(stem):
        previous = stem[index - 1] if index else ""
        next_char = stem[index + 1] if index + 1 < len(stem) else ""

        should_split = (
            index > 0
            and char.isupper()
            and (
                previous.islower()
                or previous.isdigit()
                or (previous.isupper() and next_char.islower())
            )
        )
        if should_split:
            title.append(" ")
        title.append(char)

    return "".join(title)


def language_summary(files: list[Path]) -> str:
    counts = Counter(path.suffix.lower().lstrip(".") for path in files)
    if not counts:
        return "No solution files yet"

    return ", ".join(
        f"{language.upper() if language in {'kt', 'ts', 'js'} else language.title()} {count}"
        for language, count in sorted(counts.items(), key=lambda item: (-item[1], item[0]))
    )


def directory_link(difficulty: str, count: int) -> str:
    directory = SRC / difficulty
    if count == 0 or not directory.exists():
        return "Coming soon"

    return f"[`src/{difficulty}`](src/{difficulty})"


def percentage(count: int, total: int) -> str:
    if total == 0:
        return "0.0%"

    return f"{count / total * 100:.1f}%"


def build_readme() -> str:
    grouped = {difficulty: solution_files(difficulty) for difficulty in DIFFICULTIES}
    all_solutions = [path for paths in grouped.values() for path in paths]
    total = len(all_solutions)
    updated_at = datetime.now(timezone.utc).strftime("%Y-%m-%d %H:%M UTC")

    badge_lines = [
        f'<img alt="{difficulty} solved" src="{badge(difficulty, len(files), meta["color"])}">'
        for difficulty, (meta, files) in (
            (difficulty, (DIFFICULTIES[difficulty], grouped[difficulty]))
            for difficulty in DIFFICULTIES
        )
    ]

    table_rows = []
    for difficulty, meta in DIFFICULTIES.items():
        count = len(grouped[difficulty])
        table_rows.append(
            "| "
            f"**{difficulty}** | "
            f"{count} | "
            f"{percentage(count, total)} | "
            f"{directory_link(difficulty, count)} | "
            f'{meta["description"]} |'
        )

    recent_paths = git_recent_solution_paths()
    if recent_paths:
        recent_section = "\n".join(
            f"- [{human_title(path)}]({path.relative_to(ROOT).as_posix()})"
            for path in recent_paths
        )
    else:
        recent_section = "- Recent solutions will appear here after the next commits."

    readme = f"""# LeetCode Solutions

<p align="center">
  <img alt="Total solved" src="{badge("Solved", total, "2F80ED")}">
  {" ".join(badge_lines)}
</p>

This repository contains my LeetCode solutions. The stats below are generated automatically from the solution folders, so the README stays up to date after every push.

## Current Progress

| Difficulty | Solved | Share | Folder | Focus |
| --- | ---: | ---: | --- | --- |
{os.linesep.join(table_rows)}

## Snapshot

- **Total solved:** {total}
- **Languages:** {language_summary(all_solutions)}
- **Last updated:** {updated_at}

## Recently Touched

{recent_section}

## How It Updates

GitHub Actions runs [`scripts/update_readme.py`](scripts/update_readme.py) on every push. It recounts the solutions in `src/Easy`, `src/Medium`, and `src/Hard`, rewrites this file, and commits the refreshed README when something changed.
"""

    return readme.replace("\r\n", "\n")


def main() -> None:
    README.write_text(build_readme(), encoding="utf-8")


if __name__ == "__main__":
    main()
