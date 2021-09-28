package com.servlet.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.servlet.dto.BookDTO;

public class BookDAO {
	
	DataSource datasource;
	
//	String driver = "oracle.jdbc.driver.OracleDriver";
//	String url = "jdbc:oracle:thin@localhost:1521:xe";
//	String id = "scott";
//	String pw = "tiger";
	
	//클래스가 생성되면 드라이버가 메모리에 올라감 
	public BookDAO() {
		try {
//			Class.forName(driver);
			Context context = new InitialContext();
			datasource = (DataSource)context.lookup("java:comp/env/jdbc/Oracle11g");
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	//OBJECT - DTO에 해당하는 클래스를 만들어야 함
	public ArrayList<BookDTO> select(){
		
		ArrayList<BookDTO> list = new ArrayList<BookDTO>();
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet res = null;
		
		try {
//			con = DriverManager.getConnection(url, id, pw);
			con = datasource.getConnection();
			String sql = "SELECT * FROM book";
			pstmt = con.prepareStatement(sql);
			res = pstmt.executeQuery();
			
			while(res.next()) {
				int bookId = res.getInt("book_id");
				String book_name = res.getString("book_name");
				String book_loc = res.getString("book_loc");
				
				BookDTO bookdto = new BookDTO(bookId, book_name, book_loc);
				list.add(bookdto);
			}
		}catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				//커넥션 풀을 사용하더라도 자원 해제는 동일하게 이루어져야 한다. 
				if(res != null)		res.close();
				if(pstmt != null)	pstmt.close();
				if(con != null)		con.close();
		}catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
		return list;
	}
}
