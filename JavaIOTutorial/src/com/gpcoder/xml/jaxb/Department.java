package com.gpcoder.xml.jaxb;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(namespace = "http://gpcoder.com/jaxb")
@XmlAccessorType(XmlAccessType.FIELD)
public class Department {

	@XmlElement(name = "no")
	private String deptNo;
	
	@XmlElement(name = "name")
	private String deptName;

	@XmlElementWrapper(name = "employees")
	@XmlElement(name = "employee")
	private List<Employee> employees;

	/**
	 * Bắt buộc phải có hàm khởi tạo không tham số
	 */
	public Department() {

	}

	public Department(String deptNo, String deptName) {
		this.deptNo = deptNo;
		this.deptName = deptName;
	}

	public String getDeptNo() {
		return deptNo;
	}

	public void setDeptNo(String deptNo) {
		this.deptNo = deptNo;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

	@Override
	public String toString() {
		return "Department [deptNo=" + deptNo + ", deptName=" + deptName + ", employees=" + employees + "]";
	}

}