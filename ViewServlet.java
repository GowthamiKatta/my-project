package demo;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.time.*;
import java.sql.*;
import java.util.Calendar;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/ViewServlet")
public class ViewServlet extends HttpServlet {
	/**
	 * 
	 */
	  public static void main(String[] args) throws Exception
	  {
	    String myDriver = "com.mysql.jdbc.Driver";
	    String myUrl = "jdbc:mysql://localhost/emp";
	    Class.forName(myDriver);
	    Connection connection = DriverManager.getConnection(myUrl, "root", "");
	    Calendar calendar = Calendar.getInstance();
	    java.sql.Timestamp ourJavaTimestampObject = new java.sql.Timestamp(calendar.getTime().getTime());
	    String sqlTimestampInsertStatement = "INSERT INTO emp2 (create_at) VALUES (?)";
	    PreparedStatement preparedStatement = connection.prepareStatement(sqlTimestampInsertStatement);
	    preparedStatement.setTimestamp(1, ourJavaTimestampObject);
	    preparedStatement.executeUpdate();
	    preparedStatement.close();
	   	  }
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		out.println("<a href='index.html'>Add New Employee</a>");
		out.println("<h1>Employees List</h1>");
		
		List<Emp> list=EmpDao.getAllEmployees();
		
		out.print("<table border='1' width='100%'");
		out.print("<tr><th>Id</th><th>Name</th><th>Password</th><th>Email</th><th>Country</th><th>update_at</th><th>create_at</th><th>Edit</th><th>Delete</th></tr>");
		for(Emp e:list){
			out.print("<tr><td>"+e.getId()+"</td><td>"+e.getName()+"</td><td>"+e.getPassword()+"</td><td>"+e.getEmail()+"</td><td>"+e.getCountry()+"</td><td>"+e.getUpdate_at()+"</td><td>"+e.getCreate_at()+"</td><td><a href='EditServlet?id="+e.getId()+"'>edit</a></td><td><a href='DeleteServlet?id="+e.getId()+"'>delete</a></td></tr>");
		}
		LocalDate today=LocalDate.now();
		LocalTime time=LocalTime.now();
		out.println(today);
		out.println(time);
		out.print("</table>");
		
		out.close();
	}
}