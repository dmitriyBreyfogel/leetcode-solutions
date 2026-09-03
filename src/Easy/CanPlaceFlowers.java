package Easy;

public class CanPlaceFlowers {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int countPlaces = countFreePlaces(flowerbed, n);

        return countPlaces >= n;
    }

    private int countFreePlaces(int[] flowerbed, int n) {
        int countPlaces = 0;
        for (int i = 0; i < flowerbed.length; i++) {
            if (flowerbed[i] == 0) {
                boolean leftIsEmpty = i == 0 || flowerbed[i - 1] == 0;
                boolean rightIsEmpty = i == flowerbed.length - 1 || flowerbed[i + 1] == 0;

                if (leftIsEmpty && rightIsEmpty) {
                    flowerbed[i] = 1;
                    countPlaces++;
                    i++;
                }
            }
        }

        return countPlaces;
    }
}
