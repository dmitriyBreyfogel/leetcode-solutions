package Easy;

public class ValidMountainArray {
    public boolean validMountainArray(int[] arr) {
        int n = arr.length;
        if (n < 3) return false;

        int i = 0;
        while (i + 1 < n && arr[i] < arr[i + 1]) i++;   // подъём

        if (i == 0 || i == n - 1) return false;         // пик на границе

        while (i + 1 < n && arr[i] > arr[i + 1]) i++;   // спуск

        return i == n - 1;
    }
}
