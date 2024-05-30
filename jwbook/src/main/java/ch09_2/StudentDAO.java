package ch09_2;

import java.sql.*;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO {
	Connection conn = null; //DB 연결 담당 객체
	PreparedStatement pstmt; //sql문장담기위한
	final String JDBC_DRIVER = "org.h2.Driver";
	final String JDBC_URL = "jdbc:h2:tcp://localhost/~/jwbookdb";
	
	public void open() {
		try {
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(JDBC_URL,"jwbook","1234");
			System.out.println("DB Connection is established!!");
		}catch(Exception e) {//ClassNotFonundException, SQL Exception처리
			e.printStackTrace();
		}
	}
	public void close() {
		try {
			pstmt.close();
			conn.close();
			System.out.println("DB Connection is Closed!!");
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	public void insert(Student s) {
		open();
		String sql = "INSERT INTO student(username, univ, birth, email) values(?,?,?,?)";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, s.getUsername());
			pstmt.setString(2, s.getUniv());
			pstmt.setDate(3, s.getBirth());
			pstmt.setString(4, s.getEmail());
			
			pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close();
		}
	}
	
	public List<Student> getAll(){
		open();
		List<Student> students = new ArrayList<>();
		
		try {
			pstmt = conn.prepareStatement("select * from student");
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				Student s = new Student();
				s.setId(rs.getInt("id"));
				s.setUsername(rs.getString("username"));
				s.setUniv(rs.getString("univ"));
				s.setBirth(rs.getDate("birth"));
				s.setEmail(rs.getString("email"));
		
				students.add(s);
			}
		}catch (Exception e) { e.printStackTrace();/*System.out.print("nononononnon\n\n\n\n\nnonnononn");*/ }
		finally {close();}
		return students;
	}
	public void delete(int id) throws SQLException{
		open();
		String sql = "DELETE FROM student where id=?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1,id);
		if(pstmt.executeUpdate()==0) {
			throw new SQLException("DB에러");
		}
		close();
	}
}
