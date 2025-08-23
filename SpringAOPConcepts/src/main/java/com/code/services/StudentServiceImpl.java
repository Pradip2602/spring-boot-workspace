package com.code.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import com.code.entities.Student;
import com.code.repositories.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentRepository studentRepository;

	@Autowired
	@Lazy
	private StudentServiceImpl studentServiceImpl;

	@Override
	public boolean addStudent(Student student) {

		boolean status = false;

		try {

			studentRepository.save(student);
			status = true;

		} catch (Exception e) {

			e.printStackTrace();
			status = false;
		}

		return status;
	}

	@Override
	public Optional<Student> getStudentById(long id) {
		return studentRepository.findById(id);
	}

	@Override
	public List<Student> getAllStudents() {
		return studentRepository.findAll();
	}

	@Override
	public boolean addStudent(List<Student> students) {
		boolean status = false;

		try {

			studentRepository.saveAll(students);
			status = true;
		} catch (Exception e) {
			e.printStackTrace();
			status = false;
		}

		return status;
	}

	@Override
	public boolean updateStudent(long id, Student std) {
		boolean status = false;

		try {
			Optional<Student> result = studentServiceImpl.getStudentById(id);

			if (!result.isEmpty()) {
				Student student = result.get();
				student.setName(std.getName());
				student.setMarks(std.getMarks());
				student.setRollNo(std.getRollNo());

				studentRepository.save(student);
				status = true;
			} else {
				System.out.println("Student with given id not found...");
				status = false;
			}
		} catch (Exception e) {
			e.printStackTrace();
			status = false;
		}

		return status;
	}

	@Override
	public boolean deleteStudentById(long id) {

		boolean isDeleted = false;

		try {
			Optional<Student> student = studentServiceImpl.getStudentById(id);

			if (!student.isEmpty()) {
				studentRepository.deleteById(id);
				System.out.println("Student with given ID is deleted from DB...");
				isDeleted = true;
			} else {
				System.out.println("Student with given ID not found in DB........!!");
				isDeleted = false;
			}

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error occured while deleting student by ID ........!!");
			isDeleted = false;
		}

		return isDeleted;
	}

}
