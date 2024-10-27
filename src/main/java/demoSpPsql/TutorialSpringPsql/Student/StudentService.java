package demoSpPsql.TutorialSpringPsql.Student;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class StudentService {

/*Business Logic Layer ประมวลผลข้อมูลที่ได้รับจาก Presentation Laye*/

private final StudentRepository studentRepository;

    @Autowired
	public StudentService(StudentRepository studentRepository) {
    this.studentRepository = studentRepository;
}

    public List<Student> getStudents() { 
	// return Array of Objects
	//return List.of(new Student(1L,"Marie",20,"Marie@email.com",LocalDate.of(2000, Month.JANUARY, 10))); 
    return studentRepository.findAll();
	}

    public Student saveStudent(Student student){
        return studentRepository.save(student);
    }

    public void deleteStudentByID(Long id){
        studentRepository.deleteById(id);
    }

    public Student updateStudent(Long id, Student updatedStudent){
        Optional<Student> existingStudent = studentRepository.findById(id);
        if (existingStudent.isPresent()) {
            Student studentToUpdate = existingStudent.get();
            studentToUpdate.setName(updatedStudent.getName());
            studentToUpdate.setAge(updatedStudent.getAge());
            studentToUpdate.setEmail(updatedStudent.getEmail());
            studentToUpdate.setDob(updatedStudent.getDob());
            return studentRepository.save(studentToUpdate);
        } else {
            throw new InvalidStudentException("student not found");
        }
    }

}
