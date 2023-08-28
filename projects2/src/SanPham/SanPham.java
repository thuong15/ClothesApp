package SanPham;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */




/**
 *
 * @author Photocopy HoaQuan
 */
public class SanPham {
    private String MaSanPham;
    private String TenSanPham;
    private String KichCo;
    private String SoLuong;
    private String NgayNhap;
    private String NhaCungCap;
    private String GiaNhap;
    private String GiaBan;

    public SanPham() {
    }

    public SanPham(String MaSanPham, String TenSanPham, String KichCo, String SoLuong, String NgayNhap, String NhaCungCap, String GiaNhap, String GiaBan) {
        this.MaSanPham = MaSanPham;
        this.TenSanPham = TenSanPham;
        this.KichCo = KichCo;
        this.SoLuong = SoLuong;
        this.NgayNhap = NgayNhap;
        this.NhaCungCap = NhaCungCap;
        this.GiaNhap = GiaNhap;
        this.GiaBan = GiaBan;
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

    public String getKichCo() {
        return KichCo;
    }

    public void setKichCo(String KichCo) {
        this.KichCo = KichCo;
    }

    public String getSoLuong() {
        return SoLuong;
    }

    public void setSoLuong(String SoLuong) {
        this.SoLuong = SoLuong;
    }

    public String getNgayNhap() {
        return NgayNhap;
    }

    public void setNgayNhap(String NgayNhap) {
        this.NgayNhap = NgayNhap;
    }

    public String getNhaCungCap() {
        return NhaCungCap;
    }

    public void setNhaCungCap(String NhaCungCap) {
        this.NhaCungCap = NhaCungCap;
    }

    public String getGiaNhap() {
        return GiaNhap;
    }

    public void setGiaNhap(String GiaNhap) {
        this.GiaNhap = GiaNhap;
    }

    public String getGiaBan() {
        return GiaBan;
    }

    public void setGiaBan(String GiaBan) {
        this.GiaBan = GiaBan;
    }

    
}
