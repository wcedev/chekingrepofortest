<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="demo1Servlet" method="post">

Date: <input type="date" name="date"><br>
<br>
<input type="date" name="date"><!-- created by dev -->
Name: <input type="text" name="name"><br>
<br>
Address: <textarea rows="3" cols="30" name="address">
</textarea>
<br>
<br>
ContactNo: <input type="text" name="contact"><br>
<br>
<br>
Email: <input type="text" name="email"><br>
<br>
Gender: <input type="radio" name="gender" value="Male">Male
<input type="radio" name="gender" value="Female">Female
<input type="radio" name="gender" value="Other">Other<br>
<br>
City: <select type="text" name="city">
<option>Pune</option>
<option>Mumbai</option>
<option>Bangalore</option>
</select>
<br>
<br>
Languages: <input type="checkbox" name="language" value="English">English
<input type="checkbox" name="language" value="Hindi">Hindi
<input type="checkbox" name="language" value="Marathi">Marathi<br>

<input type="submit" value="submit">
</form>
 <% ResultSet rs=(ResultSet)request.getAttribute("dada");
	if(rs!= null)
	{
		%><table border="1"><th>Date</th><th>Name </th><th>Address</th><th>Contact</th><th>Email</th><th>Gender</th><th>City</th><th>Language</th><th>Action</th><% 
	while(rs.next())
	{
		
		%>
		<tr><td><%=rs.getString(1) %></td><td><%=rs.getString(2) %></td><td><%=rs.getString(3) %></td><td><%=rs.getString(4) %></td><td><%=rs.getString(5) %></td><td><%=rs.getString(6) %></td><td><%=rs.getString(7) %></td><td><%=rs.getString(8) %></td><td>Update/Delete</td></tr>
		
		  
		<%
	}
		%></table><% 
	}
	else
	{
		out.print("No Data Avalable!!!!");
	}
	%>
    	  
</body>
</html>