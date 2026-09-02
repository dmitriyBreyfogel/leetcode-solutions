package Easy;

public class TeemoAttacking {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        if (timeSeries.length == 0) return 0;
        if (timeSeries.length == 1) return duration;
        if (duration == 0) return 0;

        int sum = 0;

        for (int i = 1; i < timeSeries.length; i++) {
            int diff = timeSeries[i] - timeSeries[i - 1];
            sum += Math.min(diff, duration);
        }

        return sum + duration;
    }
}
