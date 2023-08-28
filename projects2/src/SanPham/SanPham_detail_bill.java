/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SanPham;

/**
 *
 * @author Photocopy HoaQuan
 */
public class SanPham_detail_bill {
    private String SoHoaDon;
    private String MaSanPham;
    private String TenSanPham;
    private int DonGia;
    private int SoLuong;
    private String ThanhTien;
    private int TienKhachCha;
    private int TienChaKhach;

    public SanPham_detail_bill() {
    }

    public SanPham_detail_bill(String SoHoaDon, String MaSanPham, String TenSanPham, int DonGia, int SoLuong, String ThanhTien,int TienKhachCha,int TienChaKhach) {
        this.SoHoaDon = SoHoaDon;
        this.MaSanPham = MaSanPham;
        this.TenSanPham = TenSanPham;
        this.DonGia = DonGia;
        this.SoLuong = SoLuong;
        this.ThanhTien = ThanhTien;
        this.TienKhachCha = TienKhachCha;
        this.TienChaKhach = TienChaKhach;
    }

    public String getSoHoaDon() {
        return SoHoaDon;
    }

    public int getTienKhachCha() {
        return TienKhachCha;
    }

    public void setTienKhachCha(int TienKhachCha) {
        this.TienKhachCha = TienKhachCha;
    }

    public int getTienChaKhach() {
        return TienChaKhach;
    }

    public void setTienChaKhach(int TienChaKhach) {
        this.TienChaKhach = TienChaKhach;
    }

    public void setSoHoaDon(String SoHoaDon) {
        this.SoHoaDon = SoHoaDon;
    }

    public String getMaSanPham() {
        return MaSanPham;
    }

    public void setMaSanPham(String MaSanPham) {
        this.MaSanPham = MaSanPham;
    }

    public String getTenSanPham() {
        return TenSanPham;
    }

    public void setTenSanPham(String TenSanPham) {
        this.TenSanPham = TenSanPham;
    }

    public int getDonGia() {
        return DonGia;
    }

    public void setDonGia(int DonGia) {
        this.DonGia = DonGia;
    }

    public int getSoLuong() {
        return SoLuong;
    }

    public void setSoLuong(int SoLuong) {
        this.SoLuong = SoLuong;
    }

    public String getThanhTien() {
        return ThanhTien;
    }

    public void setThanhTien(String ThanhTien) {
        this.ThanhTien = ThanhTien;
    }
    
    
}
