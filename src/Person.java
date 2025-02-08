public record Person(String name, int age) implements Comparable<Person> {
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

        return new Person[]{person, person2, person3, person4, person5};
    }

    public static void printPersons(Person[] persons) {
        for (Person p : persons) {
            System.out.println(p);
        }
    }

    @Override
    public int compareTo(Person other) {
        return Integer.compare(this.age, other.age);
    }
}
