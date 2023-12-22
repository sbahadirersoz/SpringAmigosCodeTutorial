package amigoscode.tutorial.amigoscodetutorial.Student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import static java.time.Month.APRIL;
import static java.time.Month.JUNE;

@Configuration
public class studentConfig
{
    @Bean
    CommandLineRunner commandLineRunner(studentRepos repos)
    {
        return args ->
        {

                     student Ali =   new student
                    ("Ali",
                    "ali.email@gmail.com",
                    LocalDate.of(2000, JUNE,15),
                    22);

                     student Damlasu =   new student
                    ("Damlasu",
                    "damlasuAciker@gmail.com",
                    LocalDate.of(2002, APRIL,04),
                    21);

                     repos.saveAll(List.of(Ali,Damlasu));



        };
    }
}
