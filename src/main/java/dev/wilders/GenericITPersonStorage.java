package dev.wilders;

import java.util.ArrayList;
import java.util.List;

public class GenericITPersonStorage <T extends ITPerson> {

    List<T> persons = new ArrayList<>();

    public boolean storePerson(T person) {
        return persons.add(person);
    }

    public T getLastStoredPerson() {
        return persons.get(persons.size()-1);
    }

    public T getFirstStoredPerson() {
        return persons.get(0);
    }

}
