/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Date;

/**
 *
 * @author mhieu
 */
public class NhanVien {
    private int maNV ;
    private String ho ;
    private String ten;
    private String diachi ;
    private Date ngaysinh ;
    private float luong ;
    private String ghichu ;
    private ChiNhanh chinhanh =new ChiNhanh();

    public NhanVien(int maNV, String ho, String ten, String diachi, Date ngaysinh, float luong, String ghichu) {
        this.maNV = maNV;
        this.ho = ho;
        this.ten = ten;
        this.diachi = diachi;
        this.ngaysinh = ngaysinh;
        this.luong = luong;
        this.ghichu = ghichu;
    }
    public NhanVien(int maNV, String ho, String ten, String diachi, Date ngaysinh, float luong, String ghichu,ChiNhanh chinhanh) {
        this.maNV = maNV;
        this.ho = ho;
        this.ten = ten;
        this.diachi = diachi;
        this.ngaysinh = ngaysinh;
        this.luong = luong;
        this.ghichu = ghichu;
        this.chinhanh =chinhanh;
    }

    public NhanVien() {
    }
    

    public int getMaNV() {
        return maNV;
    }

    public void setMaNV(int maNV) {
        this.maNV = maNV;
    }

    public String getHo() {
        return ho;
    }

    public void setHo(String ho) {
        this.ho = ho;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    public Date getNgaysinh() {
        return ngaysinh;
    }

    public void setNgaysinh(Date ngaysinh) {
        this.ngaysinh = ngaysinh;
    }

    public float getLuong() {
        return luong;
    }

    public void setLuong(float luong) {
        this.luong = luong;
    }

    public String getGhichu() {
        return ghichu;
    }

    public void setGhichu(String ghichu) {
        this.ghichu = ghichu;
    }

    public ChiNhanh getChinhanh() {
        return chinhanh;
    }

    public void setChinhanh(ChiNhanh chinhanh) {
        this.chinhanh = chinhanh;
    }

    @Override
    public String toString() {
        return "NhanVien{" + "maNV=" + maNV + ", ho=" + ho + ", ten=" + ten + ", diachi=" + diachi + ", ngaysinh=" + ngaysinh + ", luong=" + luong + ", ghichu=" + ghichu + ", chinhanh=" + chinhanh.getMaCN() + '}';
    }

    
    
    
}
