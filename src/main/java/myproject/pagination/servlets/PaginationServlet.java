package myproject.pagination.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import myproject.pagination.entity.Employee;
import myproject.pagination.service.EmployeeService;


@WebServlet("/pagination")
public class PaginationServlet extends HttpServlet {
	
EmployeeService employeeService = null;
	
	@Override
	public void init() throws ServletException {
		employeeService = new EmployeeService();
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String label = request.getParameter("button");
		
		List<Employee> empsList =  employeeService.getEmployees(label);
		out.print("<html>");
		out.print("<body>");
		out.print("<h2 style='color:red;' align='center'>Employee Details</h2>");

		out.print("<center>");
		out.print("<table border='1'>");
		out.print("<tr><th>ENO</th><th>ENAME</th><th>ESAL</th><th>EADDR</th></tr>");
		for(Employee emp : empsList) {
			out.print("<tr>");
			out.print("<td>"+emp.getEno()+"</td>");
			out.print("<td>"+emp.getEname()+"</td>");
			out.print("<td>"+emp.getEsal()+"</td>");
			out.print("<td>"+emp.getEaddr()+"</td>");
			out.print("</tr>");
		}
		out.print("</table>");
		out.print("</center>");
		out.print("<body>");
		out.print("<html>");
//		RequestDispatcher requestDispatcher = request.getRequestDispatcher("form.html");
//		requestDispatcher.forward(request, response); 
	}

}
