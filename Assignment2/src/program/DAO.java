package program;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import models.Student;

public class DAO {
	
	Connection conn = null;
	
	public ResultSet connDBReturn(String sql) {
		try {
			
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db1?" +
		    	                                   "user=root&password=password");	
		
			// Create a statement to retrieve objects
			Statement s = conn.createStatement();        

			// Retrieve results from the table
			ResultSet rs = s.executeQuery (sql); 
			
//			rs.close();
			
			return rs;
			
		}catch(Exception e) {
			
			e.printStackTrace();
			
			return null;
			
		}
		
	}
	
	public void connDBNoReturn(String sql) {
		try {
			
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db1?" +
		    	                                   "user=root&password=password");	
		
			// Create a statement to retrieve objects
			Statement s = conn.createStatement();        

			// Retrieve results from the table
			s.executeUpdate(sql); 
			
		}catch(Exception e) {
			
			e.printStackTrace();
			
		}
		
	}
	
	public ArrayList<Student> getAll(){    
	    String sql="Select * from Student";    
	    ResultSet rs = connDBReturn(sql);
	    
	    ArrayList<Student> list = new ArrayList<Student>();
	    
		try {
			while(rs.next()) {
				String id = rs.getString("id");
				String name = rs.getString("name");
				String department = rs.getString("department");
				
//				System.out.println("ID: " + id);
//				System.out.println("NAME: " + name);
//				System.out.println("DEPARTMENT: " + department);
				
				list.add(new Student(id, name, department));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
		
	} 
	public void save(Student s){    
	    String sql="insert into `student`(`id`,`name`,`department`) values('"+s.getId()+"','"+s.getName()+"','"+s.getDepartment()+"')";    
	    System.out.println(sql);
	    connDBNoReturn(sql);
	}    
	public void update(Student s){    
	    String sql="update Student set id='"+s.getId()+"', name='"+s.getName()+"',department='"+s.getDepartment()+"' where id="+s.getId()+"";    
	    connDBNoReturn(sql);
	}    
	public void delete(String id){    
	    String sql="delete from Student where id='"+id+"'";    
	    connDBNoReturn(sql);
	}     
}
