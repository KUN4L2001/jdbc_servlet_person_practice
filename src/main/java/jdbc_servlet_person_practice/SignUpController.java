package jdbc_servlet_person_practice;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
@WebServlet("/signup")
public class SignUpController extends GenericServlet{

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Person person=new Person();
		person.setId(Integer.parseInt(req.getParameter("id")));
		person.setName(req.getParameter("name"));
		person.setPhone(Long.parseLong(req.getParameter("phone")));
		person.setEmail(req.getParameter("email"));
		person.setPassword(req.getParameter("password"));
		person.setAddress(req.getParameter("address"));
		
		PersonCRUD crud=new PersonCRUD();
		try {
			int result=crud.signUp(person);
			if(result!=0)
			{
				res.getWriter().print("SignUp Successfull!!!");
			}
			else {
				res.getWriter().print("SignUp Failed!!!");
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			res.getWriter().print("Exception in signup");
		}
	}

}
