/**
 * The User class stores personal information about the user.
 * This information is used to create personalized sleep recommendations.
 *
 * Author: Krishan Avila
 * Course: AP Computer Science A
 */
public class User {

    private int age;
    private double height;
    private double weight;

    /**
     * Creates a new User object.
     *
     * @param age User age
     * @param height User height
     * @param weight User weight
     */
    public User(int age, double height, double weight) {
        this.age = age;
        this.height = height;
        this.weight = weight;
    }

    /**
     * Returns the user's age.
     *
     * @return age
     */
    public int getAge() {
        return age;
    }

    /**
     * Returns the user's height.
     *
     * @return height
     */
    public double getHeight() {
        return height;
    }

    /**
     * Returns the user's weight.
     *
     * @return weight
     */
    public double getWeight() {
        return weight;
    }

    /**
     * Displays user information.
     */
    public void displayUserInfo() {
        System.out.println("\n--- User Info ---");
        System.out.println("Age: " + age);
        System.out.println("Height: " + height);
        System.out.println("Weight: " + weight);
    }
}
