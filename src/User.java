public class User {
    private int age;
    private double height;
    private double weight;

    public User(int age, double height, double weight) {
        this.age = age;
        this.height = height;
        this.weight = weight;
    }

    public int getAge() {
        return age;
    }

    public double getHeight() {
        return height;
    }

    public double getWeight() {
        return weight;
    }

    public void displayUserInfo() {
        System.out.println("\n--- User Info ---");
        System.out.println("Age: " + age);
        System.out.println("Height: " + height);
        System.out.println("Weight: " + weight);
    }
}
