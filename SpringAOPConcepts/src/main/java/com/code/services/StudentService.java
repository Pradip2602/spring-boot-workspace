package com.code.services;


import java.util.List;
import java.util.Optional;

import com.code.entities.Student;


public interface StudentService {
	
	public boolean addStudent(Student student);
	
	public boolean addStudent(List<Student> students);
	
	public Optional<Student> getStudentById(long id);
	
	public boolean updateStudent(long id,Student student);
	
	public List<Student> getAllStudents();
	
	public boolean deleteStudentById(long id);
	

}
