package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/newBook")
public class NewBook extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		String bookName = request.getParameter("book_name");
		String bookLoc = request.getParameter("book_loc");
		
		//데이터베이스를 사용하기 위한 코드 
		String driver = "oracle.jdbc.driver.OracleDriver"; 	//드라이버 이름에 해당 
		String url = "jdbc:oracle:thin:@localhost:1521:xe";	//현재 localhost이므로 Ip주소대신 localhost 넣는
		String id = "scott";
		String pw = "tiger";
		
		Connection con = null;
		Statement stmt = null;
		
		try {
			Class.forName(driver);	//driver loading : 메모리에 드라이버 로딩 
			
			con = DriverManager.getConnection(url, id, pw);
			stmt = con.createStatement();			//통신하는 객체 생성 
			
			String sql = "INSERT INTO book(book_id, book_name, book_loc)";
			sql += " VALUES (BOOK_SEQ.NEXTVAL, '"+bookName+"', '"+bookLoc+"');";
			
			int result = stmt.executeUpdate(sql);	//들어간 데이터의 행 수를 return함 
			
			if(result == 1)
				out.print("INSERT success!!");
			else
				out.print("INSERT fail..");
			
		}catch(Exception e)
		{
			e.printStackTrace();
		} finally {
			try {
				//할당한 리소스 해제 
				if(stmt != null)	stmt.close();
				if(con != null)		con.close();
			}catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
