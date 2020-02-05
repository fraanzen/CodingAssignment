package se.ecutb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import se.ecutb.data.TodoRepository;
import se.ecutb.dto.PersonDto;
import se.ecutb.dto.PersonDtoWithTodo;
import se.ecutb.model.Person;
import se.ecutb.model.Todo;

import java.util.List;

@Component
public class PersonDtoConversionServiceImpl implements PersonDtoConversionService {

    private TodoRepository todoRepository;
    private TodoDtoConversionService todoDtoConversionService;

    @Autowired
    public PersonDtoConversionServiceImpl(TodoRepository todoRepository, TodoDtoConversionService todoDtoConversionService) {
        this.todoRepository = todoRepository;
        this.todoDtoConversionService = todoDtoConversionService;
    }

    @Override
    public PersonDto convertToPersonDto(Person person) {
        return new PersonDto(person.getPersonId(),person.getFirstName(),person.getLastName());
    }

    @Override
    public PersonDtoWithTodo convertToPersonDtoWithTodo(Person person, List<Todo> assignedTodos) {
        return null;
    }
}
