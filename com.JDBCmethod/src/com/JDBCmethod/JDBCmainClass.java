package com.JDBCmethod;


import java.sql.*;

public class JDBCmainClass {
	Connection con;
	
	boolean ConnectionStringMethod()
	{
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");  
			  con=DriverManager.getConnection(  
			"jdbc:mysql://localhost:3306/db_student","root","1234"); 
			  
			  return true;
			
		} catch (Exception e) {
			
			 System.out.println("Exception at ConnectionString Method WIth Error Msg : "+e);
			 return false;
		}
	
	}
	
	
	void InsertDataMethod(int id,String S_firstname,String S_lastname,long S_phno)
	{
		
		try{  
			 
			 ConnectionStringMethod();
			//here test_schema is database name, root is username and password is 1234 
			//Ref URL :https://www.javatpoint.com/example-to-connect-to-the-mysql-database 
			 
 		
		 	String query="insert into tb_studentdetails values(?,?,?,?)";
		//	String query="delete from   tb_studentdetails  where id=(?)";
			//String query="update     tb_studentdetails set S_firstname=(?)  where id=(?)";
			PreparedStatement stmt= con.prepareStatement(query); 
			
 		stmt.setInt(1,id);
 		stmt.setString(2,S_firstname);
 			stmt.setString(3,S_lastname);
 			stmt.setLong(4,S_phno);
			int count =stmt.executeUpdate();  
			 
			System.out.println(count+" rows Affected");  
			 con.close();  
			}catch(Exception e){ System.out.println(e);}  
		 


	
	}
	
	
	void UpdateDataMethod(String S_firstname,int id)
	{
		
		try{  
			 
			 
			//here test_schema is database name, root is username and password is 1234 
			//Ref URL :https://www.javatpoint.com/example-to-connect-to-the-mysql-database 
		 
 
			String query="update     tb_studentdetails set S_firstname=(?)  where id=(?)";
			PreparedStatement stmt=con.prepareStatement(query); 
			
		stmt.setString(1,S_firstname);
		stmt.setInt(2,id);
 
			int count =stmt.executeUpdate();  
			 
			System.out.println(count+" rows Affected");  
			con.close();  
			}catch(Exception e){ System.out.println(e);}  
		 

	
	}
	
	void DeleteDataMethod(int id)
	{
		
		try{  
			 
			  
			//here test_schema is database name, root is username and password is 1234 
			//Ref URL :https://www.javatpoint.com/example-to-connect-to-the-mysql-database 
			  
			String query="delete from   tb_studentdetails  where id=(?)";
			 
			PreparedStatement stmt= con.prepareStatement(query); 
			
 		stmt.setInt(1,id);
 	  
			int count =stmt.executeUpdate();  
			 
			System.out.println(count+" rows Affected");  
			 con.close();  
			}catch(Exception e){ System.out.println(e);}  
		 


	
	}

	public static void main(String[] args) {
		
		try {
			JDBCmainClass JC=new JDBCmainClass();
			
			boolean isConnection=JC. ConnectionStringMethod();
			if(isConnection==true)
			{
			 JC. UpdateDataMethod("Guddu Bad",6);
			//JC. DeleteDataMethod(7);
			//JC. InsertDataMethod(7,"Patel","Sin",998822);
			}
			
			else
			{
				System.out.println("Connection String Problem.Check Once");	
			}
		} catch (Exception e) {
			System.out.println("Exception at Main Method with error MSG : "+e);
		}

		
	 	  
				 




	}

}
