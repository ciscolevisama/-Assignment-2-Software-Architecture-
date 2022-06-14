package views;

import java.util.ArrayList;
import java.util.Scanner;

import models.Student;

public class StudentView {
	
	public void printList(ArrayList<Student> list) {
		for(int i=0; i < list.size(); i++) {
			printStudentDetails(list.get(i).getId(),
					list.get(i).getName(),
					list.get(i).getDepartment());
		}
	}
	
	public void menu() {
		System.out.println("MENU");
		System.out.println("1.INSERT NEW DATA");
		System.out.println("2.DELETE DATA");
		System.out.println("0.EXIT");
		System.out.print("CHOICE: ");
	}
	
	public String[] studentInsertForm() {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("\nInsert student data");
		System.out.print("Student ID: ");
		String id = sc.next();
		
		System.out.print("Name: ");
		String name = sc.next();
		
		System.out.print("Department: ");
		String department = sc.next();
		
		String[] s = {id,name,department};
		
		return s;
	}
	
	public String studentDeleteTextField() {
		Scanner sc = new Scanner(System.in);
		System.out.println("\nDelete student data");
		System.out.print("Student ID: ");
		String id = sc.next();
		return id;
	}
	
	public void printStudentDetails(String id, 
			String name, 
			String department){
		System.out.println("id: " + id);
		System.out.println("Name: " + name);
		System.out.println("department: " + department);
		System.out.println("******************************");
	}
}