package com.ReqVehicle;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/deleteReqSevlet")
public class deleteReqSevlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public deleteReqSevlet() {
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String reqId = request.getParameter("id");

            boolean isTrue;

            isTrue = reqVehicleDBUtil.deleteReqVehicle(reqId);

            if(isTrue == true) {
                RequestDispatcher dis = request.getRequestDispatcher("Home.jsp");
                dis.forward(request, response);
            } else {
                RequestDispatcher dis2 = request.getRequestDispatcher("Unsuccess.jsp");
                dis2.forward(request, response);
            }

        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
