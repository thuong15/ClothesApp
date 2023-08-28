/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SanPham;

import java.util.Date;

/**
 *
 * @author Photocopy HoaQuan
 */
public class SanPham_supplier {
    private String MaNhaCungCap;
    private String TenNhaCungCap;
    private Date NgayKiHopDong;
    private String DiaChi;
    private String LienHe;

    public SanPham_supplier() {
    }

    public SanPham_supplier(String MaNhaCungCap, String TenNhaCungCap, Date NgayKiHopDong, String DiaChi, String LienHe) {
        this.MaNhaCungCap = MaNhaCungCap;
        this.TenNhaCungCap = TenNhaCungCap;
        this.NgayKiHopDong = NgayKiHopDong;
        this.DiaChi = DiaChi;
        this.LienHe = LienHe;
    }

    public String getMaNhaCungCap() {
        return MaNhaCungCap;
    }

    public void setMaNhaCungCap(String MaNhaCungCap) {
        this.MaNhaCungCap = MaNhaCungCap;
    }

    public String getTenNhaCungCap() {
        return TenNhaCungCap;
    }

    public void setTenNhaCungCap(String TenNhaCungCap) {
        this.TenNhaCungCap = TenNhaCungCap;
    }

    public Date getNgayKiHopDong() {
        return NgayKiHopDong;
    }

    public void setNgayKiHopDong(Date NgayKiHopDong) {
        this.NgayKiHopDong = NgayKiHopDong;
    }

    
    

    public String getDiaChi() {
        return DiaChi;
    }

    public void setDiaChi(String DiaChi) {
        this.DiaChi = DiaChi;
    }

    public String getLienHe() {
        return LienHe;
    }

    public void setLienHe(String LienHe) {
        this.LienHe = LienHe;
    }
    
    
}
