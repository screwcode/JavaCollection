import java.util.Comparator;
import java.util.Objects;

public class User implements Comparable<User> {

    /**
     * 用户ID，数据库主键，全局唯一
     */
    private final Integer id;

    /**
     * 用户名
     */
    private final String name;

    public User(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        User person = (User) o;

        return Objects.equals(id, person.id);
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    /**
     * 老板说让我按照用户名排序
     */
    @Override
    public int compareTo(User o) {
        return Comparator.comparing(User::getName)
                .thenComparing(User::getId).compare(this, o);
    }
}
