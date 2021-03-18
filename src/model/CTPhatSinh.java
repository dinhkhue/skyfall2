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
public class CTPhatSinh {
    private int soluong ;
    private float dongia;
    private String lydo ;
    private PhatSinh phatsinh =new PhatSinh();
    private VatTu vatTu=new VatTu();
    private Kho kho =new Kho();

    public CTPhatSinh(int soluong, float dongia, String lydo) {
        this.soluong = soluong;
        this.dongia = dongia;
        this.lydo = lydo;
    }
    public CTPhatSinh(int soluong, float dongia, String lydo,PhatSinh phatSinh,VatTu vatTu,Kho kho ) {
        this.soluong = soluong;
        this.dongia = dongia;
        this.lydo = lydo;
        this.phatsinh = phatSinh;
        this.vatTu = vatTu;
        this.kho = kho;
    }

    public CTPhatSinh() {
    }
    

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }

    public float getDongia() {
        return dongia;
    }

    public void setDongia(float dongia) {
        this.dongia = dongia;
    }

    public String getLydo() {
        return lydo;
    }

    public void setLydo(String lydo) {
        this.lydo = lydo;
    }

    public PhatSinh getPhatsinh() {
        return phatsinh;
    }

    public void setPhatsinh(PhatSinh phatsinh) {
        this.phatsinh = phatsinh;
    }

    public VatTu getVatTu() {
        return vatTu;
    }

    public void setVatTu(VatTu vatTu) {
        this.vatTu = vatTu;
    }

    public Kho getKho() {
        return kho;
    }

    public void setKho(Kho kho) {
        this.kho = kho;
    }

    @Override
    public String toString() {
        return "CTPhatSinh{" + "soluong=" + soluong + ", dongia=" + dongia + ", lydo=" + lydo + ", phatsinh=" + phatsinh + ", vatTu=" + vatTu + ", kho=" + kho + '}';
    }
    
    
    
}
