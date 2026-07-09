package com.telusko.src;

import com.telusko.src.model.Student;
import com.telusko.src.service.StudentService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.List;

@SpringBootApplication
public class SpringJdbcExApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SpringJdbcExApplication.class, args);
		Student s = context.getBean(Student.class);
		StudentService service = context.getBean(StudentService.class);

		//Creating and saving a student
		s.setName("Raghavendra S");
		s.setRollno(103);
		s.setMarks(70);
		service.addStudent(s);

		List<Student> students = service.getStudents();
		System.out.println(students);
	}

}
