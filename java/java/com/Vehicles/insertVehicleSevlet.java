package com.Vehicles;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/insertVehicleSevlet")
public class insertVehicleSevlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public insertVehicleSevlet() {
        super();

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String type = request.getParameter("type");
        String model = request.getParameter("model");
        String number = request.getParameter("number");
        String color = request.getParameter("color");
        String enNumber = request.getParameter("enNumber");
        String Features = request.getParameter("Features");
        String year = request.getParameter("year");
        String Schedule = request.getParameter("Schedule");
        String rentalPrice = request.getParameter("rentalPrice");

        boolean isTrue;

        isTrue = VehicleDBUtil.vehicleInsert(type, model, color, enNumber, Features, number, year, Schedule, rentalPrice);

        if (isTrue == true) {
            RequestDispatcher dis = request.getRequestDispatcher("Home.jsp");
            dis.forward(request, response);
        }

        else {

            RequestDispatcher dis = request.getRequestDispatcher("Unsuccess.jsp");
            dis.forward(request, response);
        }

    }

}
