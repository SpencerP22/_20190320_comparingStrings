import java.util.Objects;

public class Person implements Comparable<Person> {
    private String name;
    private int age;

    //constructors
    public Person(String name, int age) {
        setName(name);
        setAge(age);
    }
    public Person(String name) {
        this(name, 0);
    }
    public Person(int age) {
        this("ANONYMOUS", age);
    }
    public Person() {
        this("ANONYMOUS",0);
    }

    //setters
    public void setName(String name) {
        this.name = name;
    }
    public void setAge(int age) {
        if(age > 120)
            this.age = 120;
        else
            this.age = age;
    }

    //getters
    //no parameters means that we do not need 'this.'
    public String getName() {
        return name;
    }
    public int getAge() {
        return age;
    }

    //toString method   @Override for documentation
    @Override
    public String toString() {
        //any of these methods work and do the same thing
        String result = String.format("Name: %s, Age: %d", name, age);
        //String result = String.format("Name: %s, Age: %d", this.name, this.age);
        //String result = String.format("Name: %s, Age: %d", getName(), getAge());
        //String result = String.format("Name: %s, Age: %d", this.getName(), this.getAge());

        return result;
    }

    public int compareTo(Person other) {
        int result = this.name.compareToIgnoreCase(other.name);
        //If the same name, break the tie on age.
        if(result == 0)
            result = this.age - other.age;
        return result;
    }
    //equals method
    //if you have a equals method, you must also have a hashcode method.
    //hashcodes are an object's id in the form of a single number.

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age &&
                Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }
}
