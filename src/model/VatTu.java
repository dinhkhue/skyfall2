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
public class VatTu {
    private String maVT;
    private String tenVT ;
    private String DVT;

    public VatTu(String maVT, String tenVT, String DVT) {
        this.maVT = maVT;
        this.tenVT = tenVT;
        this.DVT = DVT;
    }

    public VatTu() {
    }

    public String getMaVT() {
        return maVT;
    }

    public void setMaVT(String maVT) {
        this.maVT = maVT;
    }

    public String getTenVT() {
        return tenVT;
    }

    public void setTenVT(String tenVT) {
        this.tenVT = tenVT;
    }

    public String getDVT() {
        return DVT;
    }

    public void setDVT(String DVT) {
        this.DVT = DVT;
    }

    @Override
    public String toString() {
        return "VatTu{" + "maVT=" + maVT + ", tenVT=" + tenVT + ", dVT=" + DVT + '}';
    }
    
}
