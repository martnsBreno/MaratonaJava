package Junit;

import lombok.Data;

@Data
public class Person {
    int age;

    public Person(int age) {
        this.age = age;
    }
}
