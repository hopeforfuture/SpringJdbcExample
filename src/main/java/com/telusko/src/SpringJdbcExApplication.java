package com.telusko.src;

import com.telusko.src.model.Student;
import com.telusko.src.service.StudentService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class SpringJdbcExApplication {

	public static void main(String[] args) {

		ApplicationContext context =
				SpringApplication.run(SpringJdbcExApplication.class, args);

		StudentService service = context.getBean(StudentService.class);
		Student student = context.getBean(Student.class);

		try (Scanner sc = new Scanner(System.in)) {

			// Roll Number
			while (true) {
				System.out.print("Enter Roll Number: ");

				if (sc.hasNextInt()) {
					int rollNo = sc.nextInt();

					if (rollNo > 0) {
						student.setRollno(rollNo);
						break;
					}

					System.out.println("Roll number must be greater than 0.");
				} else {
					System.out.println("Please enter a valid integer.");
					sc.next(); // discard invalid input
				}
			}

			sc.nextLine(); // consume newline

			// Name
			while (true) {
				System.out.print("Enter Name: ");
				String name = sc.nextLine().trim();

				if (name.isEmpty()) {
					System.out.println("Name cannot be empty.");
				} else if (!name.matches("[a-zA-Z ]+")) {
					System.out.println("Name should contain only letters and spaces.");
				} else {
					student.setName(name);
					break;
				}
			}

			// Marks
			while (true) {
				System.out.print("Enter Marks (0-100): ");

				if (sc.hasNextInt()) {
					int marks = sc.nextInt();

					if (marks >= 0 && marks <= 100) {
						student.setMarks(marks);
						break;
					}

					System.out.println("Marks must be between 0 and 100.");
				} else {
					System.out.println("Please enter a valid integer.");
					sc.next(); // discard invalid input
				}
			}

			service.addStudent(student);

			System.out.println("\n===== Student Records =====");

			for (Student s : service.getStudents()) {
				System.out.printf("Roll No : %d%n", s.getRollno());
				System.out.printf("Name    : %s%n", s.getName());
				System.out.printf("Marks   : %d%n", s.getMarks());
				System.out.println("---------------------------");
			}
		}
	}
}