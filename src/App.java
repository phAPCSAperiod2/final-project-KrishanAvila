import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        boolean running = true;

        System.out.println("Sleep Tracker App");

        while (running) {
            System.out.println("\n1. Enter sleep data");
            System.out.println("2. Exit");
            System.out.print("Choose an option: ");
            int choice = input.nextInt();

            if (choice == 1) {

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

                System.out.println("\n--- Sleep Summary ---");
                System.out.println("Sleep time: " + sleepTime);
                System.out.println("Wake time: " + wakeTime);
                System.out.println("Hours slept: " + hoursSlept);
                System.out.println("Rest rating: " + restRating + "/5");

                if (restRating <= 2) {
                    System.out.println("You are not well rested.");
                } else if (restRating == 3) {
                    System.out.println("You are somewhat rested.");
                } else {
                    System.out.println("You feel well rested.");
                }

            } else if (choice == 2) {
                running = false;
                System.out.println("Goodbye!");
            } else {
                System.out.println("Invalid choice.");
            }
        }

        input.close();
    }
}
