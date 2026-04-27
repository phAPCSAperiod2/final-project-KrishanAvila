import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        boolean running = true;

        // Store up to 7 days
        int[] sleepTimes = new int[7];
        int[] wakeTimes = new int[7];
        int[] hoursSleptList = new int[7];
        int[] restRatings = new int[7];
        int count = 0;

        System.out.println("Sleep Tracker App");

        while (running) {
            System.out.println("\n1. Enter sleep data");
            System.out.println("2. View sleep history");
            System.out.println("3. Get sleep recommendation");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int choice = input.nextInt();

            if (choice == 1) {

                if (count >= 7) {
                    System.out.println("Storage full. Max 7 days.");
                    continue;
                }

                System.out.print("Enter sleep time (0-23): ");
                int sleepTime = input.nextInt();

                System.out.print("Enter wake time (0-23): ");
                int wakeTime = input.nextInt();

                int hoursSlept;

                if (wakeTime >= sleepTime) {
                    hoursSlept = wakeTime - sleepTime;
                } else {
                    hoursSlept = (24 - sleepTime) + wakeTime;
                }

                System.out.print("How rested do you feel? (1-5): ");
                int restRating = input.nextInt();

                // Store data
                sleepTimes[count] = sleepTime;
                wakeTimes[count] = wakeTime;
                hoursSleptList[count] = hoursSlept;
                restRatings[count] = restRating;
                count++;

                System.out.println("\n--- Sleep Summary ---");
                System.out.println("Sleep time: " + sleepTime);
                System.out.println("Wake time: " + wakeTime);
                System.out.println("Hours slept: " + hoursSlept);
                System.out.println("Rest rating: " + restRating + "/5");

            } else if (choice == 2) {

                if (count == 0) {
                    System.out.println("No data yet.");
                } else {
                    int total = 0;

                    for (int i = 0; i < count; i++) {
                        System.out.println("\nDay " + (i + 1));
                        System.out.println("Sleep: " + sleepTimes[i]);
                        System.out.println("Wake: " + wakeTimes[i]);
                        System.out.println("Hours: " + hoursSleptList[i]);
                        System.out.println("Rest: " + restRatings[i] + "/5");

                        total += hoursSleptList[i];
                    }

                    System.out.println("\nAverage sleep: " + (total / count) + " hours");
                }

            } else if (choice == 3) {

                if (count == 0) {
                    System.out.println("No data to analyze.");
                } else {
                    int totalSleep = 0;
                    int totalRating = 0;

                    for (int i = 0; i < count; i++) {
                        totalSleep += hoursSleptList[i];
                        totalRating += restRatings[i];
                    }

                    int avgSleep = totalSleep / count;
                    int avgRating = totalRating / count;

                    System.out.println("\n--- Recommendation ---");
                    System.out.println("Average sleep: " + avgSleep + " hours");
                    System.out.println("Average rest rating: " + avgRating + "/5");

                    if (avgSleep < 7 || avgRating <= 2) {
                        System.out.println("Go to bed earlier. Aim for 7-9 hours of sleep.");
                    } else if (avgSleep <= 9 && avgRating >= 3) {
                        System.out.println("Your sleep schedule looks good. Stay consistent.");
                    } else {
                        System.out.println("You may be oversleeping. Try waking up a bit earlier.");
                    }
                }

            } else if (choice == 4) {
                running = false;
                System.out.println("Goodbye!");
            } else {
                System.out.println("Invalid choice.");
            }
        }

        input.close();
    }
}
