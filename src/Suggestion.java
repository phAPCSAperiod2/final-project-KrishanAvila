public class Suggestion {

    public static void giveSuggestion(int[] sleepTimes, int[] hoursSleptList, int[] restRatings, int count, int age) {

        System.out.println("\n--- Personalized Recommendation ---");

        int totalSleep = 0;
        int totalRating = 0;

        for (int i = 0; i < count; i++) {
            totalSleep += hoursSleptList[i];
            totalRating += restRatings[i];
        }

        int avgSleep = totalSleep / count;
        int avgRating = totalRating / count;

        System.out.println("Average sleep: " + avgSleep + " hours");
        System.out.println("Average rest rating: " + avgRating + "/5");

        int recommendedMin;
        int recommendedMax;

        if (age <= 17) {
            recommendedMin = 8;
            recommendedMax = 10;
        } else if (age <= 25) {
            recommendedMin = 7;
            recommendedMax = 9;
        } else {
            recommendedMin = 7;
            recommendedMax = 8;
        }

        System.out.println("Recommended sleep: " + recommendedMin + "-" + recommendedMax + " hours");

        // Sleep amount feedback
        if (avgSleep < recommendedMin) {
            System.out.println("You need more sleep. Try going to bed earlier.");
        } else if (avgSleep > recommendedMax) {
            System.out.println("You may be oversleeping. Try waking up earlier.");
        } else {
            System.out.println("Your sleep amount is in a good range.");
        }

        // Rest rating feedback
        if (avgRating <= 2) {
            System.out.println("You often feel tired. Improve your sleep habits.");
        } else if (avgRating >= 4) {
            System.out.println("You usually feel well rested.");
        }

        // Consistency check
        if (count > 1) {
            int variation = 0;

            for (int i = 1; i < count; i++) {
                variation += Math.abs(sleepTimes[i] - sleepTimes[i - 1]);
            }

            int avgVariation = variation / (count - 1);

            if (avgVariation > 3) {
                System.out.println("Your sleep schedule is inconsistent. Try sleeping at the same time each night.");
            } else {
                System.out.println("Your sleep schedule is fairly consistent.");
            }
        }

        // Best and worst days
        int best = 0;
        int worst = 5;

        for (int i = 0; i < count; i++) {
            if (restRatings[i] > best) best = restRatings[i];
            if (restRatings[i] < worst) worst = restRatings[i];
        }

        System.out.println("Best rest rating: " + best + "/5");
        System.out.println("Worst rest rating: " + worst + "/5");
    }
}
