public class Person {
    private final Integer id;

    public Person(Integer id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        Person p = (Person) o;
        return (id.equals(p.id)) && (this.getClass() == o.getClass());
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
