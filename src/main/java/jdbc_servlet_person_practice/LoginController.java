package jdbc_servlet_person_practice;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
@WebServlet("/login")
public class LoginController extends GenericServlet{

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String email=req.getParameter("email");
		String password=req.getParameter("password");
		
		PersonCRUD crud=new PersonCRUD();
		
		try {
			String passwordDB=crud.getPassword(email);
			
			if(passwordDB!=null)
			{
				if(password.equals(passwordDB))
				{
					res.getWriter().print("Login Successfull!!!");
				}
				else {
					res.getWriter().print("Incorrect Password!!!");
				}
			}
			else {
				res.getWriter().print("Email is registered!!!");
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			res.getWriter().print("Exception in login!!!");
		}
	}

}
