package Junit.Service;

import Junit.Person;

import java.util.Objects;

public class PersonService {

    public static boolean isAdult(Person person) {
        Objects.requireNonNull(person, "Person cannot be null");
        return person.getAge() >= 18;
    }
}
