package demoSpPsql.TutorialSpringPsql.Student;

public class InvalidStudentException extends RuntimeException {

    public InvalidStudentException(String message){
        super(message);
    }

    //ตรวจสอบข้อมูล in service layer หากไม่ครบให้ throw exception 
}
