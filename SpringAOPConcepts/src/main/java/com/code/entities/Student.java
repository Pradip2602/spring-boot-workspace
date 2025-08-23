package com.code.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private long id;

	@Column
	private String name;

	@Column
	private int rollNo;

	@Column
	private float marks;

	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Student(String name, int rollNo, float marks) {
		super();
		this.name = name;
		this.rollNo = rollNo;
		this.marks = marks;
	}

	public Student(long id, String name, int rollNo, float marks) {
		super();
		this.id = id;
		this.name = name;
		this.rollNo = rollNo;
		this.marks = marks;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getRollNo() {
		return rollNo;
	}

	public void setRollNo(int rollNo) {
		this.rollNo = rollNo;
	}

	public float getMarks() {
		return marks;
	}

	public void setMarks(float marks) {
		this.marks = marks;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", rollNo=" + rollNo + ", marks=" + marks + "]";
	}

}
