package in.ashok.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.ashok.dao.DaoClass;
import in.ashok.dto.registerDTO;

@WebServlet("/login")
public class LoginServlet extends HttpServlet{
	 
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
		String Email = req.getParameter("email");
		String Password = req.getParameter("pass");
		
		registerDTO dto2 = new registerDTO();
		dto2.setEmail(Email);
		dto2.setPass(Password);
		
		boolean status2 = DaoClass.checkdata(dto2);
		resp.setContentType("text/html");
		
		PrintWriter writer = resp.getWriter();

		if(status2) {
			resp.sendRedirect("dashboad.html");
		}else {
			writer.append("Record not found. <a href='register.html'>Click here to register</a> ");
		}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
