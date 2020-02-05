package se.ecutb;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import se.ecutb.config.AppConfig;
import se.ecutb.data.PersonRepository;
import se.ecutb.service.CreatePersonService;

import java.util.Arrays;


public class App {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out ::println);

    }
}
