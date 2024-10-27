package demoSpPsql.TutorialSpringPsql;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication

public class TutorialSpringPsqlApplication {

	/*Presentation Layer เป็นชั้นที่ผู้ใช้ (Client) สื่อสารกับ API */
	/*Business Logic Layer ประมวลผลข้อมูลที่ได้รับจาก Presentation Laye*/
	/*Data Layer ทำหน้าที่จัดการการเข้าถึงฐานข้อมูล*/
	/*Database Layer ใช้ฐานข้อมูล SQL เช่น MySQL, PostgreSQL หรือ NoSQL เช่น MongoDB*/ 
	/*API Layer จัดการ endpoint ของ API เช่น GET, POST, PUT, DELETE*/
	public static void main(String[] args) {
		SpringApplication.run(TutorialSpringPsqlApplication.class, args);
	}

}
