public record Person(String name, int age) {
    public Person {
        if (age < 0) {
            throw new IllegalArgumentException("Age cannot be negative");
        }
        if (name == null) {
            throw new IllegalArgumentException("Name cannot be null");
        }
    }

    public static Person[] getPersons() {
        Person person = new Person("Alice", 30);
        Person person2 = new Person("Bob", 25);
        Person person3 = new Person("Charlie", 40);
        Person person4 = new Person("David", 35);
        Person person5 = new Person("Eve", 20);

        Person[] persons = {person, person2, person3, person4, person5};
        return persons;
    }

    public static void printPersons(Person[] persons) {
        for (Person p : persons) {
            System.out.println(p);
        }
    }

}
