

import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.util.Objects;
@EqualsAndHashCode
@Getter
public class Person {
    private final String name;

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
