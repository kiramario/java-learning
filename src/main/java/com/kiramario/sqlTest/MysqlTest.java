package com.kiramario.sqlTest;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import  java.sql.Statement;

import com.kiramario.seriutil.Person;

class Connect{
	
}

public class MysqlTest {
	
	public static void main(String[] arg){
		Connection con;
		PreparedStatement pres;
		String driver = "com.mysql.jdbc.Driver";
		
		String url = "jdbc:mysql://localhost:3306/test";
		
		String user = "root";
		String password = "root";
		
		try{
			Class.forName(driver);
			con = DriverManager.getConnection(url,user,password);
			if(!con.isClosed()){
				System.out.println("Succeeded connecting to the Database!");
			}
			Statement statement = con.createStatement();
			
			/*String sql = "select * from book";
			ResultSet res = statement.executeQuery(sql);
			while(res.next()){
				System.out.println(res.getString("num"));
			}*/
			
			/*String insertSql = "insert into book (num,name) values (10,'fly2')";
			int res = statement.executeUpdate(insertSql,20);
			System.out.println(res);*/
			
			/*String sql = "insert into t_objects(name,object) values (?,?)";
			pres = con.prepareStatement(sql);
			
			Person p=new Person();  
	        p.setName("¸£¹ú");  
	        p.setYear(30);  
	        p.setCity("¼ªÁÖ");  
	        p.setBirth(new Date(95,4,23));  
	        
	        pres.setString(1, "person1");
	        pres.setObject(2, p);
	        int res = pres.executeUpdate();
	        System.out.println(res);*/
			
			String sql = "select object from t_objects where name='person1'";
			pres=con.prepareStatement(sql);
			
			ResultSet res = pres.executeQuery();
			while(res.next()){
				Blob inblob = res.getBlob("object");
				InputStream inp = inblob.getBinaryStream();
				BufferedInputStream bis = new BufferedInputStream(inp);
				
				byte[] buff = new byte[(int) inblob.length()];
				
				while(-1!=(bis.read(buff,0,buff.length))){
					ObjectInputStream in = new ObjectInputStream(new ByteArrayInputStream(buff));
					Person p = (Person)in.readObject();
					System.out.println("good: " + p);
				}
			}
			
	        
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
