package Easy;

public class RobotReturnToOrigin {
    public boolean judgeCircle(String moves) {
        int[] position = {0, 0};
        for (char c : moves.toCharArray()) {
            move(position, c);
        }

        return position[0] == 0 && position[1] == 0;
    }

    private void move(int[] position, char direction) {
        switch (direction) {
            case 'U': position[1]++; break;
            case 'D': position[1]--; break;
            case 'L': position[0]--; break;
            case 'R': position[0]++; break;
        }
    }
}
