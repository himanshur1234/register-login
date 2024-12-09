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

@WebServlet("/register")
public class RegisterServlet extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
		String Fname = req.getParameter("fname");
		String Lname = req.getParameter("lname");
		String Email = req.getParameter("email");
		String Pass = req.getParameter("pass");
		String Gender = req.getParameter("gender");
		
		registerDTO dto = new registerDTO();
		dto.setEmail(Email);
		dto.setFname(Fname);
		dto.setGender(Gender);
		dto.setLname(Lname);
		dto.setPass(Pass);
		
		boolean status = DaoClass.saveRegistration(dto);
		resp.setContentType("text/html");

		PrintWriter writer = resp.getWriter();
		String responce=null;
		if(status) {
			responce="Record Inserted.<a href='login.html'>Click here to go to the login page</a>";
		}else {
			responce="Record not Inserted";
		}
		writer.append(responce);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

	
}
