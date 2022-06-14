package Controllers;

import java.util.ArrayList;

import models.Student;
import program.DAO;
import views.StudentView;

public class StudentController {
	
	DAO dao = new DAO();
	//Variable declaration
	private static Student model;
	private StudentView view;
		
	//Constructor
	public StudentController(Student model, StudentView view){
		this.model = model;
		this.view = view;
	}
	
	public ArrayList<Student> getAll() {
		
		return dao.getAll();
	}
	
	public void insert(Student s) {
		dao.save(s);
	}
	
	public void delete(String id) {
		dao.delete(id);
	}
	
	public void updateView(){                
        view.printStudentDetails(model.getId(), model.getName(), model.getDepartment());
    }
	
}
