package Medium;

public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int size = height.length;
        int left = 0, right = size - 1;
        int maxArea = 0;

        while (left < right) {
            int tmp = Math.min(height[left], height[right]) * (right - left);
            if (tmp > maxArea) maxArea = tmp;

            if (height[left] < height[right]) left++;
            else right--;
        }

        return maxArea;
    }
}
