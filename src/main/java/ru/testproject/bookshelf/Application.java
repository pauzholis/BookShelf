package ru.testproject.bookshelf;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import ru.testproject.bookshelf.config.MailConfiguration;
import ru.testproject.bookshelf.config.SecurityConfig;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan
@Import({SecurityConfig.class, MailConfiguration.class})
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}