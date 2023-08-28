/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SanPham;

/**
 *
 * @author Photocopy HoaQuan
 */
public class SanPham_bill {
    private String SoHoaDon;
    private String NgayLap;
    private int MaNhanVien;
    private String MaSanPham;
    private String TenKhach;
    private String SoDienThoai;
    private String Tong;
    private String GhiChu;

    public SanPham_bill() {
    }

    public SanPham_bill(String SoHoaDon, String NgayLap, int MaNhanVien,String MaSanPham, String TenKhach,String SoDienThoai, String Tong,String GhiChu) {
        this.SoHoaDon = SoHoaDon;
        this.NgayLap = NgayLap;
        this.MaNhanVien = MaNhanVien;
        this.MaSanPham = MaSanPham;
        this.TenKhach = TenKhach;
        this.SoDienThoai = SoDienThoai;
        this.Tong = Tong;
        this.GhiChu = GhiChu;
    }

    public String getSoHoaDon() {
        return SoHoaDon;
    }

    public String getMaSanPham() {
        return MaSanPham;
    }

    public void setMaSanPham(String MaSanPham) {
        this.MaSanPham = MaSanPham;
    }

    

    public void setSoHoaDon(String SoHoaDon) {
        this.SoHoaDon = SoHoaDon;
    }

    public String getNgayLap() {
        return NgayLap;
    }

    public void setNgayLap(String NgayLap) {
        this.NgayLap = NgayLap;
    }

    public int getMaNhanVien() {
        return MaNhanVien;
    }

    public void setMaNhanVien(int MaNhanVien) {
        this.MaNhanVien = MaNhanVien;
    }

    public String getTenKhach() {
        return TenKhach;
    }

    public void setTenKhach(String TenKhach) {
        this.TenKhach = TenKhach;
    }

    public String getTong() {
        return Tong;
    }

    public void setTong(String Tong) {
        this.Tong = Tong;
    }

    public String getSoDienThoai() {
        return SoDienThoai;
    }

    public void setSoDienThoai(String SoDienThoai) {
        this.SoDienThoai = SoDienThoai;
    }

    public String getGhiChu() {
        return GhiChu;
    }

    public void setGhiChu(String GhiChu) {
        this.GhiChu = GhiChu;
    }
    
    
}
