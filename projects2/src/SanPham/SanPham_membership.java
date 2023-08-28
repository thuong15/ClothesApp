/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SanPham;

/**
 *
 * @author Photocopy HoaQuan
 */
public class SanPham_membership {
    private String MaNhanVien;
    private String TenNhanVien;
    private String Luong;
    private String NgayGiaNhap;
    private String DiaChi;
    private String SoDienThoai;

    public SanPham_membership() {
    }

    public SanPham_membership(String MaNhanVien, String TenNhanVien, String Luong, String NgayGiaNhap, String DiaChi, String SoDienThoai) {
        this.MaNhanVien = MaNhanVien;
        this.TenNhanVien = TenNhanVien;
        this.Luong = Luong;
        this.NgayGiaNhap = NgayGiaNhap;
        this.DiaChi = DiaChi;
        this.SoDienThoai = SoDienThoai;
    }

    public String getMaNhanVien() {
        return MaNhanVien;
    }

    public void setMaNhanVien(String MaNhanVien) {
        this.MaNhanVien = MaNhanVien;
    }

    public String getTenNhanVien() {
        return TenNhanVien;
    }

    public void setTenNhanVien(String TenNhanVien) {
        this.TenNhanVien = TenNhanVien;
    }

    public String getLuong() {
        return Luong;
    }

    public void setLuong(String Luong) {
        this.Luong = Luong;
    }

    public String getNgayGiaNhap() {
        return NgayGiaNhap;
    }

    public void setNgayGiaNhap(String NgayGiaNhap) {
        this.NgayGiaNhap = NgayGiaNhap;
    }

    public String getDiaChi() {
        return DiaChi;
    }

    public void setDiaChi(String DiaChi) {
        this.DiaChi = DiaChi;
    }

    public String getSoDienThoai() {
        return SoDienThoai;
    }

    public void setSoDienThoai(String SoDienThoai) {
        this.SoDienThoai = SoDienThoai;
    }
    
    
}
