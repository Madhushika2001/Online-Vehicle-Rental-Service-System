package com.Payment;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class PaymentDBUtil {

    private static Connection con = null;
    private static Statement stmt = null;
    private static ResultSet rs = null;

    public static boolean paymentInsert(String cardId, String userId, String vehicleId, String rentalId, String date, String amount){
        
        boolean isSuccess = false;
        
        try{
            con = DBConnection.getConnection();
            stmt = con.createStatement();
            String sql = "insert into payments values ( 0 ,'"+cardId+"','"+userId+"','"+vehicleId+"','"+rentalId+"','"+date+"','"+amount+"')";
            
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
