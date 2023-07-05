package com.javafullstack.springbootdemo.model;

import com.fasterxml.jackson.annotation.JsonBackReference;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "students")
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "firstName")
	private String firstName;
	@Column(name = "lastName")
	private String lastName;
	@Column(name = "tel")
	private int tel;
	@Column(name = "hindi")
	private int hindi;
	@Column(name = "eng")
	private int eng;
	@Column(name = "maths")
	private int maths;
	@Column(name = "sci")
	private int sci;
	@Column(name = "social")
	private int social;
	@Column(name = "total")
	private int total;
	
	@JsonBackReference
	
	 @JoinColumn(name = "professorId")
	 @ManyToOne
	 private Professor professor;
		
	public Student() {

	}

	public Student(String firstName,String lastName, int tel, int hindi, int eng, int maths, int sci, int social,Professor professor
			) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.tel = tel;
		this.hindi = hindi;
		this.eng = eng;
		this.maths = maths;
		this.sci = sci;
		this.social = social;
		this.total=tel + hindi + eng + maths + sci + social;
		this.professor=professor;
		
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getTel() {
		return tel;
	}

	public void setTel(int tel) {
		this.tel = tel;
	}

	public int getHindi() {
		return hindi;
	}

	public void setHindi(int hindi) {
		this.hindi = hindi;
	}

	public int getEng() {
		return eng;
	}

	public void setEng(int eng) {
		this.eng = eng;
	}

	public int getMaths() {
		return maths;
	}

	public void setMaths(int maths) {
		this.maths = maths;
	}

	public int getSci() {
		return sci;
	}

	public void setSci(int sci) {
		this.sci = sci;
	}

	public int getSocial() {
		return social;
	}

	public void setSocial(int social) {
		this.social = social;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}
	
	 public Professor getProfessor() {
		return professor;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
	}

	@Override
	 public String toString() {
	  return "Student [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName
	    + ", total=" + total + "]";
	 }
	public interface StudentDTOIntf {

		/*
		* select c.first_name,c.address,c.mobile_number,o.order_id,
		* o.price,o.quantity,p.product_name,ct.category_name from customers c,
		* orders o, categories ct, products p where ct.category_id=p.category_id
		* and c.customer_id=o.customer_id", nativeQuery = true)
	
	
		select s.id,s.first_name as firstName,s.total,p.professor_id,p.professor_name
		from students s,professors p
		where s.professor_id=p.professor_id)
		
		*/

		public String getFirstName() ;
		public Integer getTotal() ;
		public Long getProfessorId() ;
		public String getProfessorName() ;
		public Long getId() ;
		

		}

}