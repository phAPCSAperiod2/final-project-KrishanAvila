import java.util.Scanner;

/**
 * The App class runs the Sleep Tracker program.
 * Users can enter sleep data, view history,
 * and receive personalized sleep recommendations.
 *
 * Author: Krishan Avila
 * Course: AP Computer Science A
 */
public class App {

    static Scanner input = new Scanner(System.in);

    /**
     * Main method that starts the program.
     *
     * @param args Command line arguments
     */
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

            int choice = getValidInt(
                "\n1. Enter sleep data\n"
              + "2. View sleep history\n"
              + "3. Get sleep recommendation\n"
              + "4. View user info\n"
              + "5. Exit\n"
              + "Choose: ", 1, 5
            );

            if (choice == 1) {

                if (count >= 7) {
                    System.out.println("Storage full. Max 7 days.");
                    continue;
                }

                int sleepTime =
                        getValidInt("Enter sleep time (0-23): ", 0, 23);

                int wakeTime =
                        getValidInt("Enter wake time (0-23): ", 0, 23);

                int restRating =
                        getValidInt("How rested do you feel (1-5): ", 1, 5);

                int hoursSlept =
                        calculateHours(sleepTime, wakeTime);

                sleepTimes[count] = sleepTime;
                wakeTimes[count] = wakeTime;
                hoursSleptList[count] = hoursSlept;
                restRatings[count] = restRating;

                count++;

                printSummary(
                        sleepTime,
                        wakeTime,
                        hoursSlept,
                        restRating,
                        count
                );

                Suggestion.quickFeedback(
                        hoursSlept,
                        restRating,
                        user.getAge()
                );

            } else if (choice == 2) {

                printHistory(
                        sleepTimes,
                        wakeTimes,
                        hoursSleptList,
                        restRatings,
                        count
                );

            } else if (choice == 3) {

                if (count == 0) {
                    System.out.println("No data to analyze.");
                } else {

                    Suggestion.giveSuggestion(
                            sleepTimes,
                            hoursSleptList,
                            restRatings,
                            count,
                            user.getAge()
                    );
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

    /**
     * Gets a validated integer from the user.
     *
     * @param prompt Message shown to user
     * @param min Minimum valid value
     * @param max Maximum valid value
     * @return validated integer
     */
    public static int getValidInt(String prompt, int min, int max) {

        int value;

        while (true) {

            System.out.print(prompt);
            value = input.nextInt();

            if (value >= min && value <= max) {
                break;
            }

            System.out.println("Invalid input. Try again.");
        }

        return value;
    }

    /**
     * Gets a validated positive decimal number.
     *
     * @param prompt Message shown to user
     * @return validated double
     */
    public static double getValidDouble(String prompt) {

        double value;

        while (true) {

            System.out.print(prompt);
            value = input.nextDouble();

            if (value > 0) {
                break;
            }

            System.out.println("Invalid input. Try again.");
        }

        return value;
    }

    /**
     * Calculates total hours slept.
     *
     * @param sleepTime Time user went to sleep
     * @param wakeTime Time user woke up
     * @return hours slept
     */
    public static int calculateHours(int sleepTime, int wakeTime) {

        if (wakeTime >= sleepTime) {
            return wakeTime - sleepTime;
        } else {
            return (24 - sleepTime) + wakeTime;
        }
    }

    /**
     * Prints a summary of the latest sleep entry.
     *
     * @param sleepTime Sleep time
     * @param wakeTime Wake time
     * @param hours Hours slept
     * @param rating Rest rating
     * @param count Number of entries stored
     */
    public static void printSummary(int sleepTime, int wakeTime,
                                    int hours, int rating, int count) {

        System.out.println("\n--- Sleep Summary ---");
        System.out.println("Sleep time: " + sleepTime);
        System.out.println("Wake time: " + wakeTime);
        System.out.println("Hours slept: " + hours);
        System.out.println("Rest rating: " + rating + "/5");
        System.out.println("Stored days: " + count + "/7");
    }

    /**
     * Displays stored sleep history.
     *
     * @param sleepTimes Array of sleep times
     * @param wakeTimes Array of wake times
     * @param hours Array of hours slept
     * @param ratings Array of rest ratings
     * @param count Number of entries stored
     */
    public static void printHistory(int[] sleepTimes,
                                    int[] wakeTimes,
                                    int[] hours,
                                    int[] ratings,
                                    int count) {

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

        System.out.println(
                "\nAverage sleep: " + (total / count) + " hours"
        );
    }
}
