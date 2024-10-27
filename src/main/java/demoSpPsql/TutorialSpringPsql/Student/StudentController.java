package demoSpPsql.TutorialSpringPsql.Student;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;



@RestController // RESTful controller และจะส่ง response เป็น JSON หรือ XML
@RequestMapping("/api/v1/student") //กำหนดเส้นทางหลักให้กับ controller
public class StudentController {

    /* private: ข้าถึงได้เฉพาะภายในคลาสเท่านั้น
     * final : จะไม่สามารถเปลี่ยนแปลงค่า (reassign) ได้ ทำให้ studentService กำหนดค่าใน constructor เท่านั้น 
     * StudentService studentService;: นี่คือการประกาศตัวแปรที่ใช้เพื่อเก็บข้อมูลของคลาส
    */
    
    /*รับพารามิเตอร์StudentService studentService
     เพื่อกำหนดค่าตัวแปร studentService ในคลาส StudentController 
     ใช้ this อ้างถึงตัวแปรของคลาสแทนที่จะเป็นพารามิเตอร์
     */

    private final StudentService studentService ;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }
    
    @GetMapping // HTTP GET requests
    public List<Student> getStudents(){
        return studentService.getStudents();
    }

    @PostMapping("/students") // HTTP post requests
    public Student createStudent(@RequestBody Student student) {
        if(student.getName() == null || student.getName().isEmpty()){
            throw new InvalidStudentException("Name is required.");
        }
        if (student.getEmail() == null || student.getEmail().isEmpty()) {
            throw new InvalidStudentException("Email is required.");
        }

        //ตัวอย่างตรวจสอบรูปแบบ email use Regular Expression
        if (student.getEmail().matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$")) {
            throw new InvalidStudentException("Invalid email format.");
        }
        return studentService.saveStudent(student);
    }

    @DeleteMapping("/students/{id}")
    public void deleteStudent(@PathVariable Long id){
        studentService.deleteStudentByID(id);
    }

    @PutMapping("path/{id}")
    public Student updateStudents(@PathVariable Long id, @RequestBody Student updatedStudent) {
        return studentService.updateStudent(id, updatedStudent);
    }
    

}
