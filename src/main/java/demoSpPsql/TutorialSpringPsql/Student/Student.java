package demoSpPsql.TutorialSpringPsql.Student;
import java.time.LocalDate;



import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity //annotation ที่มาจาก JPA หน้าที่บอกว่า class Student นี้เป็น entity (หรือก็คือ object ที่สามารถเชื่อมต่อกับฐานข้อมูล)
@Table //หากไม่ระบุ @Table และ name ไว้ Spring จะตั้งชื่อตารางตามชื่อ class
public class Student {

    @Id//ใช้เพื่อบอกว่าฟิลด์นั้นเป็น primary key ของตารางในฐานข้อมูล
    @SequenceGenerator(//สร้างค่า Primary Key อัตโนมัติโดยใช้ Sequence ในฐานข้อมูล
        name = "student_sequence", //name = อ้างอิงเมื่อสร้าง Primary Key , name สำหรับ generator
        sequenceName = "student_sequence", //ชื่อ Sequence ที่จะใช้ในการสร้างค่า Primary Key ,name สำหรับ save ชื่อนี้ใน database
        allocationSize = 1 //จะเพิ่มค่าใน Sequence ในแต่ละครั้งที่มีการสร้าง Primary Key = 1
    ) 
    @GeneratedValue(//ใช้เพื่อกำหนดว่าค่าของ primary key จะถูกสร้างโดยอัตโนมัติ
        strategy =  GenerationType.SEQUENCE, //จะใช้ Sequence ในการสร้างค่าของ Primary Key , ,เมื่อเจอ ชื่อ gen ที่สร้าง(student_sequence)จะ สร้าง database auto ref from line20 
        generator = "student_sequence" //ะบุชื่อของ Sequence Generator ที่ใช้สร้าง Primary Key, ref from line19 : name สำหรับ generator 
        ) 
    private Long id;
    private String name;
    private Integer age ;
    private String email;
    private LocalDate dob;

    // Default constructor (จำเป็นสำหรับ Hibernate/JPA)
    public Student() {
    }

    public Student(Long id,String name,Integer age,String email,LocalDate dob){
        //คอนสตรัคเตอร์ที่มี id ใช้เมื่อเรามี id อยู่แล้ว (เช่น ตอนที่ดึงข้อมูลจากฐานข้อมูล)
        this.id = id;
        this.name = name;
        this.age = age;
        this.email = email;
        this.dob = dob;   
    }

    public Student(String name,Integer age,String email,LocalDate dob){
        //คอนสตรัคเตอร์ที่ไม่มี id ใช้เมื่อเรากำลังจะสร้าง Student ใหม่และให้ระบบสร้าง id ให้โดยอัตโนมัติ
        this.name = name;
        this.age = age;
        this.email = email;
        this.dob = dob;   
    }

    public Long getID(){
        return id;
    }

    public void setId(Long id){
        this.id = id;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name= name;
    }


    public Integer getAge(){
        return age;
    }

    public void setAge(Integer age){
        this.age = age;
    }


    public String getEmail(){
        return email;
    }

    public void setEmail(String email){
        this.email = email;
    }


    public LocalDate getDob(){
        return dob;
    }

    public void setDob(LocalDate dob){
        this.dob = dob;
    }

    @Override
    public String toString() {
        return "Student [id=" + id + ", name=" + name + ", age=" + age + ", email=" + email + ", dob=" + dob + "]";
    }

    


}
