package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import database.CheckMethod;

@WebServlet (urlPatterns= {"/check-login"})
public class CheckLogin extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		CheckMethod check = new CheckMethod();
		
		String username = req.getParameter("username")  ;
		String password = req.getParameter("password")  ;
		if(check.checkLogin(username, password)) {
			HttpSession session = req.getSession();
			session.setAttribute("name", username);
			session.setMaxInactiveInterval(20);
			resp.sendRedirect("/PicturesSharing/check-session");
		} else {
			resp.sendRedirect("/PicturesSharing/login.jsp");
		}
	}
}
