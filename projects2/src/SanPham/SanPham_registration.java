/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SanPham;

/**
 *
 * @author Photocopy HoaQuan
 */
public class SanPham_registration {
    private int ID;
    private String TaiKhoan;
    private String MatKhau;
    private String SoDienThoai;

    public SanPham_registration() {
    }

    public SanPham_registration(int ID,String TaiKhoan, String MatKhau, String SoDienThoai) {
        this.ID = ID;
        this.TaiKhoan = TaiKhoan;
        this.MatKhau = MatKhau;
        this.SoDienThoai = SoDienThoai;
    }

    public String getTaiKhoan() {
        return TaiKhoan;
    }

    public void setTaiKhoan(String TaiKhoan) {
        this.TaiKhoan = TaiKhoan;
    }

    public String getMatKhau() {
        return MatKhau;
    }

    public void setMatKhau(String MatKhau) {
        this.MatKhau = MatKhau;
    }

    public String getSoDienThoai() {
        return SoDienThoai;
    }

    public void setSoDienThoai(String SoDienThoai) {
        this.SoDienThoai = SoDienThoai;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }
    
    
}
