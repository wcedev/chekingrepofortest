package com.cookiejar;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class demo1Servlet
 */
@WebServlet("/demo1Servlet")
public class demo1Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public demo1Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String date=request.getParameter("date");
		String nm=request.getParameter("name");
		String add=request.getParameter("address");
		String contact=request.getParameter("contact");
		String email=request.getParameter("email");
		String gender=request.getParameter("gender");
		String city=request.getParameter("city");
		String lang=request.getParameter("language");
		
		System.out.println(date+""+nm+""+gender);
		
		try{
	    Class.forName("com.mysql.jdbc.Driver");
	    Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/demo1db","root","");
		Statement st=(Statement) con.createStatement();
			   
		String sql = "insert into demo1_table(Date,Name,Address,Contact,Email,Gender,City,Language) values('" + date
					   + "','" + nm + "','" + add + "','" + contact + "','" + email + "','" + gender + "','" + city + "','" + lang + "')";
			   st.executeUpdate(sql);
			   
			ResultSet rs=st.executeQuery("select *from demo1_table");
			request.setAttribute("data", rs);
			RequestDispatcher rd= request.getRequestDispatcher("Demo1.jsp");
			rd.forward(request, response);
			
	
		} catch (Exception e) {
             System.out.println(e);
		
		
		
		
	}

 }
}
