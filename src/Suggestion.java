public class Suggestion {

    public static void giveSuggestion(int avgSleep, int avgRating, int age) {

        System.out.println("\n--- Personalized Recommendation ---");

        System.out.println("Average sleep: " + avgSleep + " hours");
        System.out.println("Average rest rating: " + avgRating + "/5");
        System.out.println("User age: " + age);

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

        if (avgSleep < recommendedMin || avgRating <= 2) {
            System.out.println("You need more sleep. Try going to bed earlier.");
        } else if (avgSleep > recommendedMax) {
            System.out.println("You may be oversleeping. Try waking up earlier.");
        } else {
            System.out.println("Your sleep schedule looks good. Stay consistent.");
        }
    }
}
