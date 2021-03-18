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
public class PhatSinh {
    private String phieu ;
    private Date ngay ;
    private String loai ;
    private String hotenKH ;
    private float thanhtien ;
    private NhanVien nv =new NhanVien();

    public PhatSinh(String phieu, Date ngay, String loai, String hotenKH, float thanhtien) {
        this.phieu = phieu;
        this.ngay = ngay;
        this.loai = loai;
        this.hotenKH = hotenKH;
        this.thanhtien = thanhtien;
    }
    public PhatSinh(String phieu, Date ngay, String loai, String hotenKH, float thanhtien,NhanVien nv) {
        this.phieu = phieu;
        this.ngay = ngay;
        this.loai = loai;
        this.hotenKH = hotenKH;
        this.thanhtien = thanhtien;
        this.nv =nv;
    }

    public PhatSinh() {
    }

    public String getPhieu() {
        return phieu;
    }

    public void setPhieu(String phieu) {
        this.phieu = phieu;
    }

    public Date getNgay() {
        return ngay;
    }

    public void setNgay(Date ngay) {
        this.ngay = ngay;
    }

    public String getLoai() {
        return loai;
    }

    public void setLoai(String loai) {
        this.loai = loai;
    }

    public String getHotenKH() {
        return hotenKH;
    }

    public void setHotenKH(String hotenKH) {
        this.hotenKH = hotenKH;
    }

    public float getThanhtien() {
        return thanhtien;
    }

    public void setThanhtien(float thanhtien) {
        this.thanhtien = thanhtien;
    }

    public NhanVien getNv() {
        return nv;
    }

    public void setNv(NhanVien nv) {
        this.nv = nv;
    }

    @Override
    public String toString() {
        return "PhatSinh{" + "phieu=" + phieu + ", ngay=" + ngay + ", loai=" + loai + ", hotenKH=" + hotenKH + ", thanhtien=" + thanhtien + ", nv=" + nv + '}';
    }
    
    
    
    
}
