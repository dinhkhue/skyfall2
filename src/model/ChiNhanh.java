/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author mhieu
 */
public class ChiNhanh {
    private String maCN;
    private String ten;
    private String diachi ;
    private String sdt ;
    public ChiNhanh(String maCN, String chinhanh, String diachi, String sdt) {
        this.maCN = maCN;
        this.ten = ten;
        this.diachi = diachi;
        this.sdt = sdt;
    }

    public ChiNhanh() {
    }


    public String getMaCN() {
        return maCN;
    }

    public void setMaCN(String maCN) {
        this.maCN = maCN;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String chinhanh) {
        this.ten = chinhanh;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    @Override
    public String toString() {
        return "ChiNhanh{" + "maCN=" + maCN + ", chinhanh=" + ten + ", diachi=" + diachi + ", sdt=" + sdt + '}';
    }
    
    
}
