/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import view.chinhanh.QLChiNhanh;

/**
 *
 * @author mhieu
 */
public class Kho {
    private String maKho ;
    private String tenKho ;
    private String diacchi ;
    private ChiNhanh chinhanh =new ChiNhanh();

    public Kho() {
    }

    public Kho(String maKho, String tenKho, String diacchi) {
        this.maKho = maKho;
        this.tenKho = tenKho;
        this.diacchi = diacchi;
    }
     public Kho(String maKho, String tenKho, String diacchi,ChiNhanh chinhanh) {
        this.maKho = maKho;
        this.tenKho = tenKho;
        this.diacchi = diacchi;
        this.chinhanh = chinhanh;
    } 




    public String getMaKho() {
        return maKho;
    }

    public void setMaKho(String maKho) {
        this.maKho = maKho;
    }

    public String getTenKho() {
        return tenKho;
    }

    public void setTenKho(String tenKho) {
        this.tenKho = tenKho;
    }

    public String getDiacchi() {
        return diacchi;
    }

    public void setDiacchi(String diacchi) {
        this.diacchi = diacchi;
    }

    public ChiNhanh getChinhanh() {
        return chinhanh;
    }

    public void setChinhanh(ChiNhanh chinhanh) {
        this.chinhanh = chinhanh;
    }

    @Override
    public String toString() {
        return "Kho{" + "maKho=" + maKho + ", tenKho=" + tenKho + ", diacchi=" + diacchi + ", chinhanh=" + chinhanh.getMaCN() + '}';
    }
    
    
    
}
