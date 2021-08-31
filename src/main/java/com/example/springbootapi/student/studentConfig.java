package com.example.springbootapi.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

@Configuration
public class studentConfig {
    @Bean
    CommandLineRunner commandLineRunner(studentRepository repository){
        return args ->{

              Student test = new Student( "test",
                           LocalDate.of(2004,01,01),"test@email.com");
              Student John = new Student( "John Lastname",
                    LocalDate.of(1999,01,01),"John@email.com");

              repository.saveAll(List.of(test,John));
        };
    }
}
