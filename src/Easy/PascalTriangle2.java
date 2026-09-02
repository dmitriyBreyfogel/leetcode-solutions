package Easy;

import java.util.List;

public class PascalTriangle2 {
    private PascalTriangle triangle;

    public List<Integer> getRow(int rowIndex) {
        List<List<Integer>> rect = triangle.generate(rowIndex + 1);
        return rect.get(rowIndex);
    }
}
