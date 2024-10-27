package demoSpPsql.TutorialSpringPsql.Student;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration//
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository){
        return args -> {
            Student marie = new Student(1L,"Marie",20,"Marie@email.com",LocalDate.of(2000, Month.JANUARY, 10));
            Student alex = new Student("Alex", 22, "Alex@com", LocalDate.of(1998, Month.MARCH, 14));
            Student nucity = new Student("Nucity", 26, "Nucity@com", LocalDate.of(1999, Month.OCTOBER, 17));
            Student orio = new Student("Orio", 17, "Orio@com", LocalDate.of(2005, Month.SEPTEMBER, 29));
            Student choco = new Student("Choco", 19, "Choco@email.com", LocalDate.of(2004, Month.APRIL, 1));
            Student meow = new Student("Meow", 25, "Meow@com", LocalDate.of(1978, Month.MARCH, 11));

            repository.saveAll(List.of(marie,alex,nucity,orio,choco,meow));
        };
        
    }
}
