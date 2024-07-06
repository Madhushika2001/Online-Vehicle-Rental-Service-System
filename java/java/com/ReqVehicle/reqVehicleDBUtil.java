package com.ReqVehicle;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class reqVehicleDBUtil {
    private static Connection con = null;
    private static Statement stmt = null;
    private static ResultSet rs = null;

    public static boolean insertReqVehicle( String vehicleId, String vehicleType, String NoOfDays, String ScheduleDate) {
        boolean isSuccess = false;

        try {
            con = DBConnection.getConnection();
            stmt = con.createStatement();
            String sql = "insert into rental values (0 ,'"+vehicleId+"','"+vehicleType+"','"+NoOfDays+"','"+ScheduleDate+"')";
            int rs = stmt.executeUpdate(sql);

            if(rs > 0) {
                isSuccess = true;
            } else {
                isSuccess = false;
            }
        } catch(Exception e) {
            e.printStackTrace();
        }

        return isSuccess;
    }

    public static boolean updateReq(String Rid,String vehicleId,String vehicleType,String noOfDays,String schduledate){
		boolean isSuccess = false;
		
		int id = Integer.parseInt(Rid);
		
		try {
			
			con = DBConnection.getConnection();
			stmt = con.createStatement();
			
			String sql = "update rental set vehicleid='"+vehicleId+"', vehicleType='"+vehicleType+"',NoFoDays='"+noOfDays+"',scheduleDate='"+schduledate+"' where idRental='"+id+"'";
			
            int rs = stmt.executeUpdate(sql);
			
			if(rs > 0) {
				isSuccess = true;
			}else {
				
			    isSuccess = false;
			    
				}
			}
		catch(Exception e) {
			
			e.printStackTrace();
		}
		
		return isSuccess;
		
	}

    public static boolean deleteReqVehicle(String reqId) {
        boolean isSuccess = false;
        
        int reID = Integer.parseInt(reqId);

        try {
            con = DBConnection.getConnection();
            stmt = con.createStatement();
            String sql = "delete from rental where  idRental = '"+reID+"'";
            int rs = stmt.executeUpdate(sql);

            if(rs > 0) {
                isSuccess = true;
            } else {
                isSuccess = false;
            }
        } catch(Exception e) {
            e.printStackTrace();
        }

        return isSuccess;
    }
}
