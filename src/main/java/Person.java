import java.util.Objects;

public class Person {
    private String name;

    public Person(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        Person person = (Person) o;
        return Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        if(name == null) {
            return 0;
        }
        return name.hashCode();
    }
}
