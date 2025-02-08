public class Main {
    public static void main(String[] args) {

        Person[] persons = Person.getPersons();
        bubblePersons(persons);
        Person.printPersons(persons);

    }

    private static void bubblePersons(Person[] persons) {
        for (int i = 0; i < persons.length; i++) {
            for (int j = 1; j < persons.length - i; j++) {
                if (comparePersonByAge(persons[j], persons[j - 1]) < 0) {
                    swap(persons, j, j - 1);
                }

            }

        }
    }

    public static int comparePersonByAge(Person p1, Person p2) {
        return p1.age() - p2.age();
    }

    public static void swap(Person[] arr, int x, int y) {
        Person temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }

}