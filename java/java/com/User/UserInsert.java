package com.User;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/UserInsert")
public class UserInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public UserInsert() {
        super();
       
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String DOB = request.getParameter("dob");
		String Gender = request.getParameter("gender");
		String Country = request.getParameter("country");
		
		
		boolean isTrue;
		
	    isTrue = UserDBUtil.insertUser (name,email, password, DOB, Gender,Country);
	    
	    if (isTrue == true) {
	    	RequestDispatcher dis = request.getRequestDispatcher("UserLogin.jsp");
	    	dis.forward(request, response);
	    }else {
	    	
	    	RequestDispatcher dis2 = request.getRequestDispatcher("Unsuccess.jsp");
	    	dis2.forward(request, response);
	    }
	
		
		
	}

}
