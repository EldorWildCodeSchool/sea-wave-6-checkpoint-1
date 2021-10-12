package dev.wilders;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StoringTheCrowdTest {

    @Test
    public void storeTheCrowdTestInNonGenericList() {
        // Arrange (Create a list of wrongly imported ITPersons)
        ITPerson person1 = new Admin("Super_Admin", LocalDate.now().minusMonths(3));
        ITPerson person2 = new Developer("Best_Developer", LocalDate.now().minusYears(2));
        ITPerson person3 = new Support("Mega_Support", 2);

        ITPersonStorage itPersonStorage = new ITPersonStorage();
        itPersonStorage.storePerson(person1);
        itPersonStorage.storePerson(person2);
        itPersonStorage.storePerson(person3);

        // Act
        ITPerson firstStoredPerson = (ITPerson) itPersonStorage.getFirstStoredPerson();
        ITPerson lastStoredPerson = (ITPerson) itPersonStorage.getLastStoredPerson();

        // Assert
        assertEquals("Super_Admin", firstStoredPerson.getName());
        assertEquals("Mega_Support", lastStoredPerson.getName());
    }

    @Test
    public void storeTheCrowdTestInGenericList() {
        // Arrange (Create a list of wrongly imported ITPersons)
        ITPerson person1 = new Admin("Super_Admin", LocalDate.now().minusMonths(3));
        ITPerson person2 = new Developer("Best_Developer", LocalDate.now().minusYears(2));
        ITPerson person3 = new Support("Mega_Support", 2);

        //Uncomment this section once you implemented the GenericStorage
        GenericStorage<ITPerson> itPersonStorage = new GenericStorage<>();
        itPersonStorage.storePerson(person1);
        itPersonStorage.storePerson(person2);
        itPersonStorage.storePerson(person3);

        // Act
        ITPerson firstStoredPerson = itPersonStorage.getFirstStoredPerson();
        ITPerson lastStoredPerson = itPersonStorage.getLastStoredPerson();

        // Assert
        assertEquals("Super_Admin", firstStoredPerson.getName());
        assertEquals("Mega_Support", lastStoredPerson.getName());
    }
}
