package se.ecutb.data;

import org.springframework.stereotype.Component;
import se.ecutb.model.Address;
import se.ecutb.model.Person;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class PersonRepositoryImpl implements PersonRepository {


    private List<Person> persons = new ArrayList<>();

    @Override
    public Optional<Person> findById(int personId) {
        return persons.stream()
                .filter(person -> person.getPersonId() == personId)
                .findFirst();
    }

    @Override
    public Person persist(Person person) throws IllegalArgumentException {
        if (!persons.contains(person)) {
            persons.add(person);
        }
        return person;
    }

    @Override
    public Optional<Person> findByEmail(String email) {
        return persons.stream()
                .filter(person -> person.getEmail().equalsIgnoreCase(email))
                .findFirst();
    }

    @Override
    public List<Person> findByAddress(Address address) {
        return null;

    }

    @Override
    public List<Person> findByCity(String city) {
        List<Person> newPersons = new ArrayList<>();
        for (Person person : persons){
            if (person.getAddress() != null && person.getAddress().getCity().equalsIgnoreCase(city)) {
                newPersons.add(person);
            }
        }return newPersons;
    }



    @Override
    public List<Person> findByLastName(String lastName) {
        return persons.stream()
                .filter(person -> person.getLastName().equalsIgnoreCase(lastName))
                .collect(Collectors.toList());
    }

    @Override
    public List<Person> findByFullName(String fullName) {
        return persons.stream()
                .filter(person -> (person.getFirstName() + " " + person.getLastName()).equalsIgnoreCase(fullName))
                .collect(Collectors.toList());
    }

    @Override
    public List<Person> findAll() {
        return persons;
    }

    @Override
    public boolean delete(int personId) throws IllegalArgumentException {
        return false;
    }

    @Override
    public void clear() {
        persons.clear();
    }
}
