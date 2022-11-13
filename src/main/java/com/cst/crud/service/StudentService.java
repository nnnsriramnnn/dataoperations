package com.cst.crud.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cst.crud.entity.Student;
import com.cst.crud.model.StudentModel;
import com.cst.crud.repository.StudentRepo;

@Service
public class StudentService {
	
	@Autowired
	StudentRepo srepo;
	
	public void saveStudent(StudentModel model) {
		
		Student student = new Student(model.getSname(), model.getBranch());
		
		srepo.save(student);
	}
	
	public void deleteStudnet(Long sid) {
		
		srepo.deleteById(sid);
		
	}
	
       public void updateStudent(StudentModel model) {
		
		Student student = srepo.getById(model.getSid());
		
		student.setSname(model.getSname());
		
		student.setBranch(model.getBranch());
		
		srepo.save(student);
	}

}
