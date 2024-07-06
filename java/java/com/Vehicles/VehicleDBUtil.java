package com.Vehicles;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import com.Vehicles.DBConnection;

public class VehicleDBUtil {

    private static Connection con = null;
    private static Statement stmt = null;
    private static ResultSet rs = null;

    public static boolean vehicleInsert(String vehicleType, String vehicleModel,
            String vehicleColor, String vehicleEnNumber,
            String vehicleDescription, String vehicleNumber, String vehicleDate, String vehicleSchedule, String rentalPrice ) {

        boolean isSuccess = false;

        try{
                
                con = DBConnection.getConnection();
                stmt = con.createStatement();
    
                String sql = "insert into vehicles values "
                + "(0,'"+vehicleType+"', '"+vehicleModel+"', '"+vehicleNumber+"', '"+vehicleColor+"', '"+vehicleEnNumber+"', '"+vehicleDescription+"', '"+vehicleDate+"','null', '"+vehicleSchedule+"', '"+rentalPrice+"'')";
    
                int rs = stmt.executeUpdate(sql);
    
                if(rs > 0){
                    isSuccess = true;
                }else{
    
                    isSuccess = false;
    
                    }

        }catch(Exception e){
            e.printStackTrace();
        }




        return isSuccess;
    }

}
