import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        boolean running = true;

        // Arrays to store up to 7 days
        int[] sleepTimes = new int[7];
        int[] wakeTimes = new int[7];
        int[] hoursSleptList = new int[7];
        int[] restRatings = new int[7];
        int count = 0;

        System.out.println("Sleep Tracker App");

        while (running) {
            System.out.println("\n1. Enter sleep data");
            System.out.println("2. View sleep history");
            System.out.println("3. Exit");
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
                running = false;
                System.out.println("Goodbye!");
            } else {
                System.out.println("Invalid choice.");
            }
        }

        input.close();
    }
}
