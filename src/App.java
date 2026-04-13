import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);

        System.out.println("Sleep Tracker App");

        System.out.print("Enter the hour you went to sleep (0-23): ");
        int sleepTime = input.nextInt();

        System.out.print("Enter the hour you woke up (0-23): ");
        int wakeTime = input.nextInt();

        int hoursSlept;

        if (wakeTime >= sleepTime) {
            hoursSlept = wakeTime - sleepTime;
        } else {
            hoursSlept = (24 - sleepTime) + wakeTime;
        }

        System.out.println("You slept for " + hoursSlept + " hours.");

        if (hoursSlept < 7) {
            System.out.println("You should try to get more sleep.");
        } else if (hoursSlept <= 9) {
            System.out.println("Good amount of sleep.");
        } else {
            System.out.println("You might be oversleeping.");
        }

        input.close();
    }
}
