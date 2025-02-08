public class Main {
    public static void main(String[] args) {

        Person[] persons = Person.getPersons();
        bubble(persons);
        Person.printPersons(persons);
        System.out.println();
        Human[] humans = Human.getHumans();
        bubble(humans);
        Human.printHumans(humans);

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