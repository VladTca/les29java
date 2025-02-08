import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class Human implements Comparable<Human> {
    private final String name;
    private final int age;

    public Human(String name, int age) {
        if (age < 0) {
            throw new IllegalArgumentException("Age cannot be negative");
        }
        if (name == null) {
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
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;

        Human human = (Human) o;
        return age == human.age && name.equals(human.name);
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + age;
        return result;
    }

    @Override
    public int compareTo(Human o) {
        return age - o.age;
    }

    public static Human[] getHumans() {
        return new Human[]{
                new Human("Alice", 30),
                new Human("Bob", 25),
                new Human("Charlie", 40),
                new Human("David", 35),
                new Human("Eve", 20)
        };

    }


    public static Human[] readHumansFromFile(Path path) {
        try {
            List<String> lines = Files.readAllLines(path);
            Human[] humans = new Human[lines.size()];
            for (int i = 0; i < lines.size(); i++) {
                String[] parts = lines.get(i).split(" ");
                humans[i] = new Human(parts[0], Integer.parseInt(parts[1]));
            }
            return humans;
        } catch (IOException e) {
            throw new RuntimeException("Ошибка при чтении файла", e);
        }
    }

    public static void writeHumansToFile(Path path, Human[] humans) {
        try (BufferedWriter writer = Files.newBufferedWriter(path)) {
            for (Human h : humans) {
                writer.write(h.name + " " + h.age);
                writer.newLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Ошибка при записи файла", e);
        }
    }

    public static void printHumans(Human[] humans) {
        for (Human h : humans) {
            System.out.println(h);
        }
    }
}
