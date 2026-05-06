import java.util.Scanner;

public class App {

    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {

        int age = getValidInt("Enter your age: ", 1, 120);
        double height = getValidDouble("Enter your height: ");
        double weight = getValidDouble("Enter your weight: ");

        User user = new User(age, height, weight);

        int[] sleepTimes = new int[7];
        int[] wakeTimes = new int[7];
        int[] hoursSleptList = new int[7];
        int[] restRatings = new int[7];
        int count = 0;

        boolean running = true;

        System.out.println("\nSleep Tracker App");

        while (running) {

            int choice = getValidInt("\n1. Enter sleep data\n2. View sleep history\n3. Get sleep recommendation\n4. View user info\n5. Exit\nChoose: ", 1, 5);

            if (choice == 1) {

                if (count >= 7) {
                    System.out.println("Storage full. Max 7 days.");
                    continue;
                }

                int sleepTime = getValidInt("Enter sleep time (0-23): ", 0, 23);
                int wakeTime = getValidInt("Enter wake time (0-23): ", 0, 23);
                int restRating = getValidInt("How rested do you feel (1-5): ", 1, 5);

                int hoursSlept = calculateHours(sleepTime, wakeTime);

                sleepTimes[count] = sleepTime;
                wakeTimes[count] = wakeTime;
                hoursSleptList[count] = hoursSlept;
                restRatings[count] = restRating;
                count++;

                printSummary(sleepTime, wakeTime, hoursSlept, restRating, count);

                Suggestion.quickFeedback(hoursSlept, restRating, user.getAge());

            } else if (choice == 2) {

                printHistory(sleepTimes, wakeTimes, hoursSleptList, restRatings, count);

            } else if (choice == 3) {

                if (count == 0) {
                    System.out.println("No data to analyze.");
                } else {
                    Suggestion.giveSuggestion(sleepTimes, hoursSleptList, restRatings, count, user.getAge());
                }

            } else if (choice == 4) {

                user.displayUserInfo();

            } else if (choice == 5) {

                running = false;
                System.out.println("Goodbye!");
            }
        }
    }

    public static int getValidInt(String prompt, int min, int max) {
        int value;
        while (true) {
            System.out.print(prompt);
            value = input.nextInt();
            if (value >= min && value <= max) break;
            System.out.println("Invalid input. Try again.");
        }
        return value;
    }

    public static double getValidDouble(String prompt) {
        double value;
        while (true) {
            System.out.print(prompt);
            value = input.nextDouble();
            if (value > 0) break;
            System.out.println("Invalid input. Try again.");
        }
        return value;
    }

    public static int calculateHours(int sleepTime, int wakeTime) {
        if (wakeTime >= sleepTime) {
            return wakeTime - sleepTime;
        } else {
            return (24 - sleepTime) + wakeTime;
        }
    }

    public static void printSummary(int sleepTime, int wakeTime, int hours, int rating, int count) {
        System.out.println("\n--- Sleep Summary ---");
        System.out.println("Sleep time: " + sleepTime);
        System.out.println("Wake time: " + wakeTime);
        System.out.println("Hours slept: " + hours);
        System.out.println("Rest rating: " + rating + "/5");
        System.out.println("Stored days: " + count + "/7");
    }

    public static void printHistory(int[] sleepTimes, int[] wakeTimes, int[] hours, int[] ratings, int count) {

        if (count == 0) {
            System.out.println("No sleep data yet.");
            return;
        }

        int total = 0;

        for (int i = 0; i < count; i++) {
            System.out.println("\nDay " + (i + 1));
            System.out.println("Sleep: " + sleepTimes[i]);
            System.out.println("Wake: " + wakeTimes[i]);
            System.out.println("Hours: " + hours[i]);
            System.out.println("Rest: " + ratings[i] + "/5");
            total += hours[i];
        }

        System.out.println("\nAverage sleep: " + (total / count) + " hours");
    }
}
