package com.User;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/deleteUserSevlet")
public class deleteUserSevlet extends HttpServlet{
    private static final long serialVersionUID = 1L;

    public deleteUserSevlet() {
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
			String id = request.getParameter("id");
			boolean isTrue;
			
			isTrue = UserDBUtil.deleleUser(id);
			
			if (isTrue == true) {
				RequestDispatcher dis = request.getRequestDispatcher("Home.jsp");
				dis.forward(request, response);
			}
			
			else {
				
				
				RequestDispatcher dis =request.getRequestDispatcher("Unsuccess.jsp");
				dis.forward(request, response);
			}
    }

}
