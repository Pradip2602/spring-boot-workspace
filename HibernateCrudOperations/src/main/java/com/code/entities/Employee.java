package com.code.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private long empId;
	@Column
	private String empName;
	@Column
	private String empDepartment;
	@Column
	private String empRole;

	public Employee() {
		super();
	}

	public Employee(String empName, String empDepartment, String empRole) {
		super();
		this.empName = empName;
		this.empDepartment = empDepartment;
		this.empRole = empRole;
	}

	public Employee(long empId, String empName, String empDepartment, String empRole) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.empDepartment = empDepartment;
		this.empRole = empRole;
	}

	public long getEmpId() {
		return empId;
	}

	public void setEmpId(long empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getEmpDepartment() {
		return empDepartment;
	}

	public void setEmpDepartment(String empDepartment) {
		this.empDepartment = empDepartment;
	}

	public String getEmpRole() {
		return empRole;
	}

	public void setEmpRole(String empRole) {
		this.empRole = empRole;
	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + ", empDepartment=" + empDepartment + ", empRole="
				+ empRole + "]";
	}
}
