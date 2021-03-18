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
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.NhanVien;
import model.PhatSinh;
import java.sql.Date;

/**
 *
 * @author khue
 */
public class PhatSinhDao {
     public List<PhatSinh> findAll() {
        String sql = "SELECT * FROM PhatSinh";
        Connection connection = ConnectionUtil.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<PhatSinh> result = new ArrayList<>();
        try {
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                

                
                PhatSinh phatSinh = new PhatSinh();
                phatSinh.setPhieu(resultSet.getString("Phieu"));
                phatSinh.setNgay(resultSet.getDate("Ngay"));
                phatSinh.setLoai(resultSet.getString("Loai"));
                phatSinh.setHotenKH(resultSet.getString("HoTenKH"));
                phatSinh.setThanhtien(Float.parseFloat(resultSet.getString("ThanhTien")));
                NhanVien nv=new NhanVien();
                nv.setMaNV(Integer.parseInt(resultSet.getString("MaNV")));
                phatSinh.setNv(nv);
                result.add(phatSinh);
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

    public PhatSinh findByPhieu(String phieu) {
        String sql = "SELECT * FROM PhatSinh WHERE Phieu = ?";
        Connection connection = ConnectionUtil.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, phieu);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                PhatSinh phatSinh = new PhatSinh();
                phatSinh.setPhieu(resultSet.getString("Phieu"));
                phatSinh.setNgay(resultSet.getDate("Ngay"));
                phatSinh.setLoai(resultSet.getString("Loai"));
                phatSinh.setHotenKH(resultSet.getString("HoTenKH"));
                phatSinh.setThanhtien(Float.parseFloat(resultSet.getString("ThanhTien")));
                NhanVien nv=new NhanVien();
                nv.setMaNV(Integer.parseInt(resultSet.getString("MaNV")));
                phatSinh.setNv(nv);
                return phatSinh;
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
        return null;
    }

    public PhatSinh create(PhatSinh phatSinh) {
        String sql = "INSERT INTO PhatSinh(Phieu,Ngay,Loai ,HoTenKH,ThanhTien,MaNV) VALUES(?,?,?,?,?,?)";
        Connection connection = ConnectionUtil.getConnection();
        PreparedStatement preparedStatement = null;
        try {
            
           
            connection.setAutoCommit(false);
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, phatSinh.getPhieu());
            preparedStatement.setDate(2, (Date)phatSinh.getNgay());
            preparedStatement.setString(3, phatSinh.getLoai());
            preparedStatement.setString(4, phatSinh.getHotenKH());
            preparedStatement.setString(5, phatSinh.getThanhtien()+" ");
            preparedStatement.setString(6, phatSinh.getNv().getMaNV()+"");
            int r = preparedStatement.executeUpdate();
            if (r == 1) {
                connection.commit();
                return phatSinh;
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


    
    public PhatSinh update(PhatSinh phatSinh, String s) {
        String sql = "UPDATE PhatSinh SET Phieu=?, Ngay = ?, Loai = ?, HoTenKH=?,ThanhTien=?,MaNV=? WHERE Phieu = ?";
        Connection connection = ConnectionUtil.getConnection();
        PreparedStatement preparedStatement = null;
        try {
            connection.setAutoCommit(false);
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, phatSinh.getPhieu());
            preparedStatement.setDate(2, (Date) phatSinh.getNgay());
            preparedStatement.setString(3, phatSinh.getLoai());
            preparedStatement.setString(4, phatSinh.getHotenKH());
            preparedStatement.setString(5, phatSinh.getThanhtien()+" ");
            preparedStatement.setString(6, phatSinh.getNv().getMaNV()+"");
            preparedStatement.setString(7,s);
            
            int r = preparedStatement.executeUpdate();
            if (r == 1) {
                connection.commit();
                return phatSinh;
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

    public boolean delete(String phieu) {
        String sql = "DELETE FROM PhatSinh WHERE Phieu = ?";
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
        return false;
    }

    public List<PhatSinh> search(PhatSinh psSearch) {
        String sql = "SELECT * FROM PhatSinh WHERE 1 = 1 ";
        if (psSearch.getPhieu()!= null) {
            sql += "AND Phieu LIKE ? ";
        }
        if (psSearch.getNgay()!= null) {
            sql += "AND Ngay LIKE ? ";
        }
        if (psSearch.getLoai() != null) {
            sql += "AND Loai = ? ";
        }
        if (psSearch.getHotenKH()!= null) {
            sql += "AND HoTenKH = ? ";
        }
        if (psSearch.getThanhtien()!= 0) {
            sql += "AND ThanhTien = ? ";
        }
        if (psSearch.getNv().getMaNV()!= 0) {
            sql += "AND MaNV = ? ";
        }
        int index = 1;
        Connection connection = ConnectionUtil.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<PhatSinh> result = new ArrayList<>();
        try {
            preparedStatement = connection.prepareStatement(sql);
            if (psSearch.getPhieu()!= null) {
                preparedStatement.setString(index, "%" + psSearch.getPhieu()+ "%");
                index++;
            }
            if (psSearch.getNgay()!= null) {
                preparedStatement.setString(index, "%" + psSearch.getNgay()+ "%");
                index++;
            }
            if (psSearch.getLoai() != null) {
                preparedStatement.setString(index, "%" + psSearch.getLoai() + "%");
                index++;
            }
            if (psSearch.getHotenKH()!= null) {
                preparedStatement.setString(index, "%" + psSearch.getHotenKH()+ "%");
                index++;
            }
            if (psSearch.getThanhtien()!= 0) {
                preparedStatement.setString(index, "%" + psSearch.getThanhtien()+ "%");
                index++;
            }
            if (psSearch.getNv().getMaNV()!= 0) {
                preparedStatement.setString(index, "%" + psSearch.getNv().getMaNV()+ "%");
                index++;
            }


            
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                PhatSinh phatSinh = new PhatSinh();
                phatSinh.setPhieu(resultSet.getString("Phieu"));
                phatSinh.setNgay(DateUtil.convertDate(resultSet.getString("Ngay")));
                phatSinh.setLoai(resultSet.getString("Loai"));
                phatSinh.setHotenKH(resultSet.getString("HoTenKH"));
                phatSinh.setThanhtien(Float.parseFloat(resultSet.getString("ThanhTien")));
                NhanVien nv=new NhanVien();
                nv.setMaNV(Integer.parseInt(resultSet.getString("MaNV")));
                phatSinh.setNv(nv);
                result.add(phatSinh);
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
}
