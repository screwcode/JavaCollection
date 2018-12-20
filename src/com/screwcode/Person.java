package com.screwcode;

import java.util.Objects;

// 修改Person的实现，使得CommonElementsInObjectListTest测试通过
public class Person {
    private final String name;

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) return true;
        if (o != null && o instanceof Person) {
            Person person = (Person) o;
            return Objects.equals(this.name, person.name);
        }
        return false;
    }


    @Override
    public int hashCode() {
        return Objects.hashCode(this.name);
    }
}
