package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.CheckMethod;

@WebServlet (urlPatterns= {"/check-login"})
public class CheckLogin extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		CheckMethod check = new CheckMethod();
		
		String username = req.getParameter("username")  ;
		String password = req.getParameter("password")  ;
		if(check.checkLogin(username, password)) {
			resp.sendRedirect("/PicturesSharing/picture.jsp");
		} else {
			resp.sendRedirect("/PicturesSharing/login.jsp");
		}
	}
}
