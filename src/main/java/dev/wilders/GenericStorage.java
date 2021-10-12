package dev.wilders;

import java.util.ArrayList;
import java.util.List;

public class GenericStorage<ITPerson> {

    List<ITPerson> persons = new ArrayList<>();

    public boolean storePerson(ITPerson person) {
        return persons.add(person);
    }

    public ITPerson getLastStoredPerson() {
        return persons.get(persons.size()-1);
    }

    public ITPerson getFirstStoredPerson() {
        return persons.get(0);
    }
}
