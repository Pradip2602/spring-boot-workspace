package com.code;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.code.entities.Student;
import com.code.services.StudentServiceImpl;

@SpringBootApplication
public class SpringDataJpaOperationsApplication {

	private final StudentServiceImpl studentServiceImpl;

	SpringDataJpaOperationsApplication(StudentServiceImpl studentServiceImpl) {
		this.studentServiceImpl = studentServiceImpl;
	}

	public static void main(String[] args) {

		ApplicationContext context = SpringApplication.run(SpringDataJpaOperationsApplication.class, args);
		StudentServiceImpl studentServiceImpl = context.getBean(StudentServiceImpl.class);

		// ---------- Insert Opertaion -------------------
		// methods --> save(Student std) & saveAll(List<Student> stdList)
//		Student std1 = new Student("Sham Jadhav", 101, 105.20f);
//		boolean status = studentServiceImpl.addStudent(std1);
//		
//		if (status) {
//			System.out.println("Student details added sucessfully into DB");
//		} else {
//
//			System.out.println("Error occured while adding student details into DB.....!!!!");
//
//		}

//		List<Student> studentList = new ArrayList<Student>();
//		studentList.add(new Student("Avinash Mishra", 104, 96.45f));
//		studentList.add(new Student("Karan Mehra", 105, 65.30f));
//		studentList.add(new Student("Vivian Dsena", 106, 90.12f));
//
//		boolean status = studentServiceImpl.addStudent(studentList);
//
//		if (status) {
//			System.out.println("Student list details added sucessfully into DB");
//		} else {
//
//			System.out.println("Error occured while adding student list details into DB.....!!!!");
//
//		}

		// ----------- Select Operation (Get all students) ---------------

//		List<Student> students = studentServiceImpl.getAllStudents();
//
//		if (!students.isEmpty()) {
//			for (Student student: students) {
//				System.out.println(student);
//			}
//		}else {
//			System.out.println("No Student found in DB");
//		}

		// ----------- Select Operation (Student By Id) ---------------
//
//		long id = 21;
//
//		if (!studentServiceImpl.getStudentById(id).isEmpty()) {
//			System.out.println("-----------------Students Details : -------------------");
//			System.out.println(studentServiceImpl.getStudentById(id));
//		} else {
//			System.out.println("No Student details found with given ID...!!");
//		}

		// ---------- Update Opertaion -------------------
		// Method --> save(Student student)

//		long id = 1000;
//		Student std1 = new Student("chahat Pandey", 103, 55.23f);
//
//		boolean status = studentServiceImpl.updateStudent(id, std1);
//		if (status) {
//
//			System.out.println("Student details Updated sucessfully into DB");
//
//		} else {
//
//			System.out.println("Error occured while updating student list details into DB.....!!!!");
//
//		}

		// ---------- DELETE BY ID Operaion -------------------
		// Method --> delete(long id)

		long id = 23;
		studentServiceImpl.deleteStudentById(id);

	}

}
