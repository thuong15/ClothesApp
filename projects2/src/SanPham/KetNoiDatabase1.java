/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SanPham;


import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Photocopy HoaQuan
 */
public class KetNoiDatabase1 {
    public Connection con = null;
    public KetNoiDatabase1(){
        try{
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/project2","root","");
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
}
