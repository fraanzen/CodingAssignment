package se.ecutb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import se.ecutb.data.IdSequencers;
import se.ecutb.data.TodoRepository;
import se.ecutb.dto.PersonDto;
import se.ecutb.dto.TodoDto;
import se.ecutb.model.Person;
import se.ecutb.model.Todo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class TodoServiceImpl implements TodoService {

    private CreateTodoService createTodoService;
    private CreatePersonService createPersonService;
    private TodoDtoConversionService todoDtoConversionService;
    private TodoRepository todoRepository;

    @Autowired
    public TodoServiceImpl(CreateTodoService createTodoService, CreatePersonService createPersonService, TodoDtoConversionService todoDtoConversionService, TodoRepository todoRepository) {
        this.createTodoService = createTodoService;
        this.createPersonService = createPersonService;
        this.todoDtoConversionService = todoDtoConversionService;
        this.todoRepository = todoRepository;
    }

    List<TodoDto> todoDtos = new ArrayList<>();

    @Override
    public Todo createTodo(String taskDescription, LocalDate deadLine, Person assignee) {
        return null;
    }

    @Override
    public TodoDto findById(int todoId) throws IllegalArgumentException {
        return null;

    }

    @Override
    public List<TodoDto> findByTaskDescription(String taskDescription) {
        return null;
    }

    @Override
    public List<TodoDto> findByDeadLineBefore(LocalDate endDate) {
        return null;
    }

    @Override
    public List<TodoDto> findByDeadLineAfter(LocalDate startDate) {
        return null;
    }

    @Override
    public List<TodoDto> findByDeadLineBetween(LocalDate startDate, LocalDate endDate) {
        return null;
    }

    @Override
    public List<TodoDto> findAssignedTasksByPersonId(int personId) {
        return null;
    }

    @Override
    public List<TodoDto> findUnassignedTasks() {
        return null;
    }

    @Override
    public List<TodoDto> findAssignedTasks() {
        return null;
    }

    @Override
    public List<TodoDto> findByDoneStatus(boolean done) {
        return null;
    }

    @Override
    public List<TodoDto> findAll() {
        return null;
    }

    @Override
    public boolean delete(int todoId) throws IllegalArgumentException {
        return false;
    }
}
