package program;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Controllers.StudentController;
import models.Student;
import views.StudentView; 

public class Main {
	
	public static ArrayList list = new ArrayList<Student>();
	public static Student model = new Student();
	public static StudentView view = new StudentView();
	public static StudentController scl = new StudentController(model, view);
	
	public static void insertData() {
		String[] s = view.studentInsertForm();
		scl.insert(new Student(s[0],s[1],s[2]));
	}
	
	public static void deleteData() {
		String s = view.studentDeleteTextField(); 
		scl.delete(s);
	}
	
	public static void main(String[] args) throws SQLException { 
		
		Scanner sc = new Scanner(System.in);
		boolean loop = true;
		
		while(loop) {
			//initiate list
			list = scl.getAll();
			
			view.printList(list);
			view.menu();
			switch(sc.nextInt()) {
				case 1: insertData(); break;
				case 2: deleteData(); break;
				default: loop = false; break;
			}
		}
		
	}
}
