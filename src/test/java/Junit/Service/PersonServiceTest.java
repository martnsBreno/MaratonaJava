package Junit.Service;

import Junit.Person;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class PersonServiceTest {
    private Person adult;
    private Person notAnAdult;

    @BeforeEach
    public void setUp() {
        adult = new Person(18);
        notAnAdult = new Person(15);
    }

    @Test
    @DisplayName("A person should not be an adult if the age is below 18")
    void isAdult_ReturnFalseIfAgeBelow18() {
        Assertions.assertEquals(false, PersonService.isAdult(notAnAdult));
    }

    @Test
    @DisplayName("A person should be an adult if the age is above or equal to 18")
    void isAdult_ReturnTrueIfAgeAboveOrEqual18() {
        Assertions.assertEquals(true, PersonService.isAdult(adult));
    }

    @Test
    @DisplayName("Should throw a NullPointerException when person is null")
    void isAdult_ThrowNullPointerEx() {
        Assertions.assertThrows(NullPointerException.class, () -> PersonService.isAdult(null));
    }
}