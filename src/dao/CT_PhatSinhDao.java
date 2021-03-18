/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import connect.ConnectionUtil;
import connect.DateUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.CTPhatSinh;
import model.Kho;
import model.PhatSinh;
import model.VatTu;

/**
 *
 * @author khue
 */





public class CT_PhatSinhDao {
    public List<CTPhatSinh> findAll() {
        String sql = "SELECT  ps.Ngay,ps.ThanhTien, ps.HoTenKH ,vt.TenVT, k.TenKho, d.* FROM CT_PhatSinh d "
                + "INNER JOIN Kho k ON d.MaKho = k.MaKho "
                + "INNER JOIN VatTu vt ON d.MaVT = vt.MaVT "
                + "INNER JOIN PhatSinh ps ON d.Phieu = ps.Phieu "
                + "ORDER BY SoLuong ";
//         String sql = "SELECT ps.HoTenKH ,vt.TenVT, k.TenKho, d.* FROM CT_PhatSinh d "
//                + "INNER JOIN Kho k ON d.MaKho = k.MaKho "
//                + "INNER JOIN VatTu vt ON d.MaVT = vt.MaVT "
//                + "INNER JOIN PhatSinh ps ON d.Phieu = ps.Phieu "
//                + "ORDER BY SoLuong ";
        Connection connection = ConnectionUtil.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<CTPhatSinh> result = new ArrayList<>();
        try {
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                
                //    private int soluong ;
//    private float dongia;
//    private String lydo ;
//    private PhatSinh phatsinh =new PhatSinh();
//    private VatTu vatTu=new VatTu();
//    private Kho kho =new Kho();
                
                CTPhatSinh ctps = new CTPhatSinh();
                ctps.setSoluong(resultSet.getInt("SoLuong"));
                ctps.setDongia(resultSet.getFloat("DonGia"));
                ctps.setLydo(resultSet.getString("LyDo"));
                PhatSinh phatSinh = new PhatSinh();
                phatSinh.setPhieu(resultSet.getString("Phieu"));
                
                phatSinh.setThanhtien(Float.parseFloat(resultSet.getString("ThanhTien")));
                phatSinh.setNgay(resultSet.getDate("Ngay"));
           //     phatSinh.setHotenKH(resultSet.getString("HoTenKH"));
                ctps.setPhatsinh(phatSinh);
                VatTu vatTu = new VatTu();
                vatTu.setMaVT(resultSet.getString("MaVT"));
           //     vatTu.setTenVT(resultSet.getString("TenVT"));
                ctps.setVatTu(vatTu);
                Kho kho=new Kho();
                kho.setMaKho(resultSet.getString("MaKho"));
            //    kho.setTenKho(resultSet.getString("TenKho"));
                ctps.setKho(kho);
                
                result.add(ctps);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            try {
                resultSet.close();
                preparedStatement.close();
                connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(ChiNhanhDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return result;
    }
    
    //           (<Phieu, char(8),>
//           ,<MaVT, char(4),>
//           ,<SoLuong, int,>
//           ,<DonGia, float,>
//           ,<MaKho, char(2),>
//           ,<LyDo, varchar(30),>
//           ,<rowguid, uniqueidentifier,>)
//

    public CTPhatSinh create(CTPhatSinh ctps) {
        String sql = "INSERT INTO CT_PhatSinh(Phieu,MaVT, SoLuong, DonGia,MaKho, LyDo) VALUES(?,?,?,?,?,?)";
        Connection connection = ConnectionUtil.getConnection();
        PreparedStatement preparedStatement = null;
        try {
            connection.setAutoCommit(false);
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, ctps.getPhatsinh().getPhieu());
            preparedStatement.setString(2, ctps.getVatTu().getMaVT());
            preparedStatement.setInt(3, ctps.getSoluong());
            preparedStatement.setFloat(4, ctps.getDongia());
            preparedStatement.setString(5, ctps.getKho().getMaKho());
            preparedStatement.setString(6, ctps.getLydo());
            int r = preparedStatement.executeUpdate();
            if (r == 1) {
                connection.commit();
                return ctps;
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            try {
                connection.rollback();
            } catch (SQLException ex1) {
                Logger.getLogger(ChiNhanhDao.class.getName()).log(Level.SEVERE, null, ex1);
            }
        } finally {
            try {
                preparedStatement.close();
                connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(ChiNhanhDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }

    public CTPhatSinh update(CTPhatSinh ctps, String s) {
        String sql = "UPDATE CT_PhatSinh SET SoLuong = ?, DonGia = ?, LyDo = ?,Phieu = ? ,MaVT = ?,MaKho = ? WHERE Phieu = ?  ";
        Connection connection = ConnectionUtil.getConnection();
        PreparedStatement preparedStatement = null;
        try {
            connection.setAutoCommit(false);
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, ctps.getSoluong());
            preparedStatement.setFloat(2, ctps.getDongia());
            preparedStatement.setString(3, ctps.getLydo());
            preparedStatement.setString(4, ctps.getPhatsinh().getPhieu());
            preparedStatement.setString(5, ctps.getVatTu().getMaVT());
            preparedStatement.setString(6, ctps.getKho().getMaKho());
            
            preparedStatement.setString(7, s);
            int r = preparedStatement.executeUpdate();
            if (r == 1) {
                connection.commit();
                return ctps;
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            try {
                connection.rollback();
            } catch (SQLException ex1) {
                Logger.getLogger(ChiNhanhDao.class.getName()).log(Level.SEVERE, null, ex1);
            }
        } finally {
            try {
                preparedStatement.close();
                connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(ChiNhanhDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }

    public List<CTPhatSinh> search(CTPhatSinh ctpsSearch) {
//        String sql = "SELECT  d.* FROM CT_PhatSinh d "
//                + "INNER JOIN Kho k ON d.MaKho = k.MaKho "
//                + "INNER JOIN VatTu vt ON d.MaVT = vt.MaVT "
//                + "INNER JOIN PhatSinh ps ON d.Phieu = ps.Phieu "
//                + "WHERE 1 = 1 ";
        String sql = "SELECT ps.Ngay,ps.ThanhTien,ps.HoTenKH ,vt.TenVT, k.TenKho, d.* FROM CT_PhatSinh d "
                + "INNER JOIN Kho k ON d.MaKho = k.MaKho "
                + "INNER JOIN VatTu vt ON d.MaVT = vt.MaVT "
                + "INNER JOIN PhatSinh ps ON d.Phieu = ps.Phieu "
                + "WHERE 1 = 1 "
                ;
        if (ctpsSearch.getSoluong() != 0) {
            sql += "AND SoLuong LIKE ? ";
        }
//        if (ctpsSearch.getPhatsinh().getHotenKH()!= null) {
//            sql += "AND ps.HoTenKH LIKE ? ";
//        }
//        if (ctpsSearch.getPhatsinh().getPhieu()!= null) {
//            sql += "AND ps.Phieu LIKE ? ";
//        }
        if (ctpsSearch.getPhatsinh().getNv().getMaNV()!= 0) {
            sql += "AND ps.MaNV LIKE ? ";
        }
        
//        if (ctpsSearch.getKho().getTenKho()!= null) {
//            sql += "AND k.TenKho LIKE ? ";
//        }
        if (ctpsSearch.getKho().getMaKho()!= null) {
            sql += "AND k.MaKho LIKE ? ";
        }
//        if (ctpsSearch.getVatTu().getTenVT()!= null) {
//            sql += "AND vt.TenVT LIKE ? ";
//        }
        if (ctpsSearch.getVatTu().getMaVT()!= null) {
            sql += "AND vt.MaVT LIKE ? ";
        }
        if (ctpsSearch.getDongia()!= 0) {
            sql += "AND DonGia = ? ";
        }
        
        sql += " ORDER BY d.SoLuong ";
        int index = 1;
        Connection connection = ConnectionUtil.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<CTPhatSinh> result = new ArrayList<>();
        try {
            preparedStatement = connection.prepareStatement(sql);

//            if (ctpsSearch.getSoluong()!= 0) {
//                preparedStatement.setString(index, "%" + ctpsSearch.getSoluong() + "%");
//                index++;
//            }
//            if (ctpsSearch.getPhatsinh().getHotenKH()!= null) {
//                preparedStatement.setString(index, "%" + ctpsSearch.getPhatsinh().getHotenKH()+ "%");
//                index++;
//            }
//            if (ctpsSearch.getPhatsinh().getPhieu()!= null) {
//                preparedStatement.setString(index, "%" + ctpsSearch.getPhatsinh().getPhieu()+ "%");
//                index++;
//            }
            if (ctpsSearch.getPhatsinh().getNv().getMaNV()!= 0) {
                preparedStatement.setString(index, "%" + ctpsSearch.getPhatsinh().getNv().getMaNV()+ "%");
                index++;
            }
//            if (ctpsSearch.getKho().getTenKho()!= null) {
//                preparedStatement.setString(index, "%" + ctpsSearch.getKho().getTenKho()+ "%");
//                index++;
//            }
            if (ctpsSearch.getKho().getMaKho()!= null) {
                preparedStatement.setString(index, "%" + ctpsSearch.getKho().getMaKho() + "%");
                index++;
            }
//            if (ctpsSearch.getVatTu().getMaVT()!= null) {
//                preparedStatement.setString(index,  "%" +ctpsSearch.getVatTu().getMaVT()+ "%");
//                index++;
//            }
//            if (ctpsSearch.getVatTu().getTenVT()!= null) {
//                preparedStatement.setString(index,  "%" +ctpsSearch.getVatTu().getTenVT()+ "%");
//                index++;
//            }
//            if (ctpsSearch.getDongia()!= 0) {
//                preparedStatement.setString(index,  "%" +ctpsSearch.getDongia()+ "%");
//                index++;
//            }
            
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                CTPhatSinh ctps = new CTPhatSinh();
                ctps.setSoluong(resultSet.getInt("SoLuong"));
                ctps.setDongia(resultSet.getFloat("DonGia"));
                ctps.setLydo(resultSet.getString("LyDo"));
                PhatSinh phatSinh = new PhatSinh();
                phatSinh.setPhieu(resultSet.getString("Phieu"));
                phatSinh.setHotenKH(resultSet.getString("HoTenKH"));
                phatSinh.setNgay(resultSet.getDate("Ngay"));
                phatSinh.setThanhtien(Float.parseFloat(resultSet.getString("ThanhTien")));
                ctps.setPhatsinh(phatSinh);
                VatTu vatTu = new VatTu();
                vatTu.setMaVT(resultSet.getString("MaVT"));
                vatTu.setTenVT(resultSet.getString("TenVT"));
                ctps.setVatTu(vatTu);
                Kho kho=new Kho();
                kho.setMaKho(resultSet.getString("MaKho"));
                kho.setTenKho(resultSet.getString("TenKho"));
                ctps.setKho(kho);
                result.add(ctps);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            try {
                resultSet.close();
                preparedStatement.close();
                connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(ChiNhanhDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return result;
    }
    
    public CTPhatSinh findByMaKho(String maKho) {
        Connection connection = ConnectionUtil.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String sql = "SELECT * FROM CT_PhatSinh WHERE MaKho = ?";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, maKho);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                CTPhatSinh ctps = new CTPhatSinh();
                ctps.setSoluong(resultSet.getInt("SoLuong"));
                ctps.setDongia(resultSet.getFloat("DonGia"));
                ctps.setLydo(resultSet.getString("LyDo"));
                PhatSinh phatSinh = new PhatSinh();
                phatSinh.setPhieu(resultSet.getString("Phieu"));
           //     phatSinh.setHotenKH(resultSet.getString("HoTenKH"));
                ctps.setPhatsinh(phatSinh);
                VatTu vatTu = new VatTu();
                vatTu.setMaVT(resultSet.getString("MaVT"));
           //     vatTu.setTenVT(resultSet.getString("TenVT"));
                ctps.setVatTu(vatTu);
                Kho kho=new Kho();
                kho.setMaKho(resultSet.getString("MaKho"));
            //    kho.setTenKho(resultSet.getString("TenKho"));
                ctps.setKho(kho);
                return ctps;
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            try {
                resultSet.close();
                preparedStatement.close();
                connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(KhoDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }
    
    public CTPhatSinh findByMaVT(String maVT) {
        Connection connection = ConnectionUtil.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String sql = "SELECT * FROM CT_PhatSinh WHERE MaVT = ?";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, maVT);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                CTPhatSinh ctps = new CTPhatSinh();
                ctps.setSoluong(resultSet.getInt("SoLuong"));
                ctps.setDongia(resultSet.getFloat("DonGia"));
                ctps.setLydo(resultSet.getString("LyDo"));
                PhatSinh phatSinh = new PhatSinh();
                phatSinh.setPhieu(resultSet.getString("Phieu"));
           //     phatSinh.setHotenKH(resultSet.getString("HoTenKH"));
                ctps.setPhatsinh(phatSinh);
                VatTu vatTu = new VatTu();
                vatTu.setMaVT(resultSet.getString("MaVT"));
           //     vatTu.setTenVT(resultSet.getString("TenVT"));
                ctps.setVatTu(vatTu);
                Kho kho=new Kho();
                kho.setMaKho(resultSet.getString("MaKho"));
            //    kho.setTenKho(resultSet.getString("TenKho"));
                ctps.setKho(kho);
                return ctps;
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            try {
                resultSet.close();
                preparedStatement.close();
                connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(KhoDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }
    
    public CTPhatSinh findByPhieu(String phieu) {
        Connection connection = ConnectionUtil.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String sql = "SELECT * FROM CT_PhatSinh WHERE Phieu = ?";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, phieu);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                CTPhatSinh ctps = new CTPhatSinh();
                ctps.setSoluong(resultSet.getInt("SoLuong"));
                ctps.setDongia(resultSet.getFloat("DonGia"));
                ctps.setLydo(resultSet.getString("LyDo"));
                PhatSinh phatSinh = new PhatSinh();
                phatSinh.setPhieu(resultSet.getString("Phieu"));
           //     phatSinh.setHotenKH(resultSet.getString("HoTenKH"));
                ctps.setPhatsinh(phatSinh);
                VatTu vatTu = new VatTu();
                vatTu.setMaVT(resultSet.getString("MaVT"));
           //     vatTu.setTenVT(resultSet.getString("TenVT"));
                ctps.setVatTu(vatTu);
                Kho kho=new Kho();
                kho.setMaKho(resultSet.getString("MaKho"));
            //    kho.setTenKho(resultSet.getString("TenKho"));
                ctps.setKho(kho);
                return ctps;
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            try {
                resultSet.close();
                preparedStatement.close();
                connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(KhoDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }
//    public boolean deleteByMaKho(String maKho) {
//        String sql = "DELETE FROM CT_PhatSinh WHERE MaKho = ?";
//        Connection connection = ConnectionUtil.getConnection();
//        PreparedStatement preparedStatement = null;
//        try {
//            connection.setAutoCommit(false);
//            preparedStatement = connection.prepareStatement(sql);
//            preparedStatement.setString(1, maKho);
//            int r = preparedStatement.executeUpdate();
//            if (r == 1) {
//                connection.commit();
//                return true;
//            }
//        } catch (SQLException ex) {
//            System.out.println(ex.getMessage());
//            try {
//                connection.rollback();
//            } catch (SQLException ex1) {
//                Logger.getLogger(KhoDao.class.getName()).log(Level.SEVERE, null, ex1);
//            }
//        } finally {
//            try {
//                preparedStatement.close();
//                connection.close();
//            } catch (SQLException ex) {
//                Logger.getLogger(KhoDao.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        }
//        return false;
//    }
    
//    public boolean deleteByMaVT(String maVT) {
//        String sql = "DELETE FROM CT_PhatSinh WHERE MaVT = ?";
//        Connection connection = ConnectionUtil.getConnection();
//        PreparedStatement preparedStatement = null;
//        try {
//            connection.setAutoCommit(false);
//            preparedStatement = connection.prepareStatement(sql);
//            preparedStatement.setString(1, maVT);
//            int r = preparedStatement.executeUpdate();
//            if (r == 1) {
//                connection.commit();
//                return true;
//            }
//        } catch (SQLException ex) {
//            System.out.println(ex.getMessage());
//            try {
//                connection.rollback();
//            } catch (SQLException ex1) {
//                Logger.getLogger(KhoDao.class.getName()).log(Level.SEVERE, null, ex1);
//            }
//        } finally {
//            try {
//                preparedStatement.close();
//                connection.close();
//            } catch (SQLException ex) {
//                Logger.getLogger(KhoDao.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        }
//        return false;
//    }
    
    public boolean deleteByPhieu(String phieu) {
        String sql = "DELETE FROM CT_PhatSinh WHERE Phieu = ?";
        Connection connection = ConnectionUtil.getConnection();
        PreparedStatement preparedStatement = null;
        try {
            connection.setAutoCommit(false);
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, phieu);
            int r = preparedStatement.executeUpdate();
            if (r == 1) {
                connection.commit();
                return true;
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            try {
                connection.rollback();
            } catch (SQLException ex1) {
                Logger.getLogger(KhoDao.class.getName()).log(Level.SEVERE, null, ex1);
            }
        } finally {
            try {
                preparedStatement.close();
                connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(KhoDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;
    }
    
    
    
}
