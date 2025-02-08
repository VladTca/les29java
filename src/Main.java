import java.nio.file.Path;

public class Main {
    public static void main(String[] args) {

        Person[] persons = Person.getPersons();
        bubble(persons);
        Person.printPersons(persons);
        System.out.println();
        Human[] humans = Human.getHumans();
        bubble(humans);
        Human.printHumans(humans);
        System.out.println();
        Path path = Path.of("src/people.txt");
        Path newPath = Path.of("src/peopleSort.txt");
        Human[] humansFromFile = Human.readHumansFromFile(path);
        bubble(humansFromFile);
        Human.printHumans(humansFromFile);
        Human.writeHumansToFile(newPath, humansFromFile);
    }

    private static <T extends Comparable<T>> void bubble(T[] people) {
        for (int i = 0; i < people.length - 1; i++) {
            for (int j = 1; j < people.length - i; j++) {
                if (people[j].compareTo(people[j - 1]) < 0) {
                    swap(people, j, j - 1);
                }
            }
        }
    }

    private static <T> void swap(T[] array, int i, int j) {
        T temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

}