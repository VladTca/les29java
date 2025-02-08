public class Human implements Comparable<Human> {
    private String name;
    private int age;

    public Human(String name, int age) {
        if (age < 0) {
            throw new IllegalArgumentException("Age cannot be negative");
        }
        if(name == null) {
            throw new IllegalArgumentException("Name cannot be null");
        }
        this.name = name;
        this.age = age;
    }


    @Override
    public String toString() {
        return name + " " + age;
    }

    @Override
    public int compareTo(Human o) {
        return age - o.age;
    }

    public static Human[] getHumans() {
        Human human = new Human("Alice", 30);
        Human human2 = new Human("Bob", 25);
        Human human3 = new Human("Charlie", 40);
        Human human4 = new Human("David", 35);
        Human human5 = new Human("Eve", 20);

        Human[] humans = {human, human2, human3, human4, human5};
        return humans;
    }
}
