package PadroesDeProjeto.test;

import PadroesDeProjeto.dominio.Person;

public class BuilderPattern01 {
    public static void main(String[] args) {
        Person person1 = Person.personBuilder.builder()
                .firstName("Breno")
                .lastName("Oliveira")
                .username("olivBreno")
                .email("breno@devdojo.com").build();

        System.out.println(person1);
    }

}
