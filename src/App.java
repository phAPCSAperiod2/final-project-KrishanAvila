import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int age;
        while (true) {
            System.out.print("Enter your age: ");
            age = input.nextInt();
            if (age > 0) break;
            System.out.println("Invalid age. Try again.");
        }

        double height;
        while (true) {
            System.out.print("Enter your height: ");
            height = input.nextDouble();
            if (height > 0) break;
            System.out.println("Invalid height. Try again.");
        }

        double weight;
        while (true) {
            System.out.print("Enter your weight: ");
            weight = input.nextDouble();
            if (weight > 0) break;
            System.out.println("Invalid weight. Try again.");
        }

        User user = new User(age, height, weight);

        boolean running = true;

        int[] sleepTimes = new int[7];
        int[] wakeTimes = new int[7];
        int[] hoursSleptList = new int[7];
        int[] restRatings = new int[7];
        int count = 0;

        System.out.println("\nSleep Tracker App");

        while (running) {

            int choice;
            while (true) {
                System.out.println("\nMenu");
                System.out.println("1. Enter sleep data");
                System.out.println("2. View sleep history");
                System.out.println("3. Get sleep recommendation");
                System.out.println("4. View user info");
                System.out.println("5. Exit");
                System.out.print("Choose an option: ");

                choice = input.nextInt();
                if (choice >= 1 && choice <= 5) break;

                System.out.println("Invalid choice. Try again.");
            }

            if (choice == 1) {

                if (count >= 7) {
                    System.out.println("Storage full. Max 7 days.");
                    continue;
                }

                int sleepTime;
                while (true) {
                    System.out.print("Enter sleep time (0-23): ");
                    sleepTime = input.nextInt();
                    if (sleepTime >= 0 && sleepTime <= 23) break;
                    System.out.println("Invalid input. Try again.");
                }

                int wakeTime;
                while (true) {
                    System.out.print("Enter wake time (0-23): ");
                    wakeTime = input.nextInt();
                    if (wakeTime >= 0 && wakeTime <= 23) break;
                    System.out.println("Invalid input. Try again.");
                }

                int hoursSlept;
                if (wakeTime >= sleepTime) {
                    hoursSlept = wakeTime - sleepTime;
                } else {
                    hoursSlept = (24 - sleepTime) + wakeTime;
                }

                int restRating;
                while (true) {
                    System.out.print("How rested do you feel? (1-5): ");
                    restRating = input.nextInt();
                    if (restRating >= 1 && restRating <= 5) break;
                    System.out.println("Invalid input. Try again.");
                }

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
                System.out.println("Stored days: " + count + "/7");

                Suggestion.quickFeedback(hoursSlept, restRating, user.getAge());

            } else if (choice == 2) {

                if (count == 0) {
                    System.out.println("No sleep data yet. Add entries first.");
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
                    Suggestion.giveSuggestion(sleepTimes, hoursSleptList, restRatings, count, user.getAge());
                }

            } else if (choice == 4) {
                user.displayUserInfo();

            } else if (choice == 5) {
                running = false;
                System.out.println("Goodbye!");
            }
        }

        input.close();
    }
}
