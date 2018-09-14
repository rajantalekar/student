package com.student.dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.student.entity.Student;

@Repository
public class StudentDaoImpl implements StudentDao{

	/*@PersistenceContext
	private EntityManager entityManager;*/
	
	@Autowired
	private SessionFactory sf;

	@Override
	@Transactional
	public void saveStudent(Student student) {
		//entityManager.merge(student);
		sf.getCurrentSession().save(student);
	}

	@Override
	@Transactional
	public java.util.List<Student> getStudents(String name) {
		List<Student> list =null;
		if(name.isEmpty() || name == null || name.equals("*")){
			list =  sf.getCurrentSession().createQuery("FROM Student").list();
		}else{
			list =  sf.getCurrentSession().createQuery("FROM Student where name like '%"+name+"%'").list();
		}
		
		return list;
	}
	
	@Override
	@Transactional
	public Student getStudent(String usn) {
		return (Student) sf.getCurrentSession().createQuery("FROM Student where usn='"+usn+"'" ).uniqueResult();
	}
}
