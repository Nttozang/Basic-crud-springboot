package demoSpPsql.TutorialSpringPsql;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import demoSpPsql.TutorialSpringPsql.Student.Student;
import demoSpPsql.TutorialSpringPsql.Student.StudentService;

@SpringBootTest
class TutorialSpringPsqlApplicationTests {

	@Autowired
	private StudentService studentService;

	@Test
	void testUpdateStudent() {
		Long id = 1L;
		Student updatedStudent = new Student("UpdatedName", 25, "updated@example.com", LocalDate.of(2000, 1, 1));

		Student result = studentService.updateStudent(id,updatedStudent);

		assertEquals("UpdatedName", result.getName());
        assertEquals(25, result.getAge());
	}

}
