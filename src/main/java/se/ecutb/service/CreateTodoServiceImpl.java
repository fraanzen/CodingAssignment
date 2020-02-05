package se.ecutb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import se.ecutb.data.IdSequencers;
import se.ecutb.data.PersonRepository;
import se.ecutb.data.TodoRepository;
import se.ecutb.model.AbstractPersonFactory;
import se.ecutb.model.AbstractTodoFactory;
import se.ecutb.model.Person;
import se.ecutb.model.Todo;

import java.time.LocalDate;
import java.util.List;

@Component
public class CreateTodoServiceImpl extends AbstractTodoFactory implements CreateTodoService {

    private TodoRepository todoRepository;
    private IdSequencers idSequencers;

    @Autowired
    public CreateTodoServiceImpl(TodoRepository todoRepository, IdSequencers idSequencers) {
        this.todoRepository = todoRepository;
        this.idSequencers = idSequencers;
    }

    @Override
    public Todo createTodo(String taskDescription, LocalDate deadLine, Person assignee) throws IllegalArgumentException {
        List<Todo> todos = todoRepository.findAll();
        for (Todo todo : todos){
            if (todo.getTaskDescription().equalsIgnoreCase(taskDescription)
                    && todo.getDeadLine().isEqual(deadLine) && todo.getAssignee().equals(assignee)){
            }
        }return createTodoItem(idSequencers.nextTodoId(),taskDescription, deadLine, assignee);
    }

    @Override
    public Todo createTodo(String taskDescription, LocalDate deadLine) throws IllegalArgumentException {
        List<Todo> todos = todoRepository.findAll();
        for (Todo todo : todos){
            if (todo.getDeadLine().isEqual(deadLine)){
            }
        }return createTodoItem(idSequencers.nextTodoId(),taskDescription, deadLine, null);
    }
}
