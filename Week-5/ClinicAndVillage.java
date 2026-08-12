import java.util.*;

public class ClinicAndVillage {

    public static double findMinimumLoad(int[] population, int k) {

    double low = 0;
    double high = 0;

    for (int people : population) {
        high = Math.max(high, people);
    }

    for (int i = 0; i < 100; i++) {

        double mid = (low + high) / 2;
        long clinicsNeeded = 0;

        for(int people : population) {
            clinicsNeeded += (long) Math.ceil(people / mid);

            if(clinicsNeeded > k) {
                break;
            }
        }

        if(clinicsNeeded <= k) {
            high = mid;
        } else {
            low = mid;
        }
    }

    return high;
}

    public static void main(String[] args) {

        int[] population = {200, 20, 50};
        int k = 5;

        double answer = findMinimumLoad(population, k);

        System.out.printf("Minimum maximum load = %.2f%n", answer);
    }
}