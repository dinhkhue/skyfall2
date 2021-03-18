/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;
import model.*;
import connect.*;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mhieu
 */
public class NhanVienDao {
    public List<NhanVien> findAll(){
        String sql ="SELECT cn.ChiNhanh, * FROM NhanVien "
                + "INNER JOIN ChiNhanh cn ON cn.MaCN = NhanVien.MaCN";
        Connection connection = ConnectionUtil.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<NhanVien> result  =new ArrayList<>();
        try {
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                NhanVien nhanVien = new NhanVien();
                nhanVien.setMaNV(resultSet.getInt("MaNV"));
                nhanVien.setHo(resultSet.getString("Ho"));
                nhanVien.setTen(resultSet.getString("Ten"));
                nhanVien.setDiachi(resultSet.getString("DiaChi"));
                nhanVien.setNgaysinh(resultSet.getDate("NgaySinh"));
                nhanVien.setLuong(resultSet.getFloat("Luong"));
                nhanVien.setGhichu(resultSet.getString("GhiChu"));
                ChiNhanh chiNhanh =new ChiNhanh();
                chiNhanh.setMaCN(resultSet.getString("MaCN"));
                chiNhanh.setTen(resultSet.getString("ChiNhanh"));
                nhanVien.setChinhanh(chiNhanh);
                result.add(nhanVien);
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
        return result;
    
    }
    public NhanVien findByMaNv(String maNv) {
        Connection connection = ConnectionUtil.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String sql = "SELECT * FROM NhanVien WHERE MaNV = ?";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, maNv);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                NhanVien nhanVien = new NhanVien();
                nhanVien.setMaNV(resultSet.getInt("MaNV"));
                nhanVien.setHo(resultSet.getString("Ho"));
                nhanVien.setTen(resultSet.getString("Ten"));
                nhanVien.setDiachi(resultSet.getString("DiaChi"));
                nhanVien.setNgaysinh(resultSet.getDate("NgaySinh"));
                nhanVien.setLuong(resultSet.getFloat("Luong"));
                nhanVien.setGhichu(resultSet.getString("GhiChu"));
                ChiNhanh chiNhanh =new ChiNhanh();
                chiNhanh.setMaCN(resultSet.getString("MaCN"));
                nhanVien.setChinhanh(chiNhanh);
                return nhanVien;
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
    public NhanVien findByTenKho(String tenNv) {
        Connection connection = ConnectionUtil.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String sql = "SELECT * FROM NhanVien WHERE Ten = ?";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, tenNv);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                NhanVien nhanVien = new NhanVien();
                nhanVien.setMaNV(resultSet.getInt("MaNV"));
                nhanVien.setHo(resultSet.getString("Ho"));
                nhanVien.setTen(resultSet.getString("Ten"));
                nhanVien.setDiachi(resultSet.getString("DiaChi"));
                nhanVien.setNgaysinh(resultSet.getDate("NgaySinh"));
                nhanVien.setLuong(resultSet.getFloat("Luong"));
                nhanVien.setGhichu(resultSet.getString("GhiChu"));
                ChiNhanh chiNhanh =new ChiNhanh();
                chiNhanh.setMaCN(resultSet.getString("MaCN"));
                nhanVien.setChinhanh(chiNhanh);
                return nhanVien;
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
    public NhanVien create(NhanVien nhanVien) {
        String sql = "INSERT INTO NhanVien(MaNV,Ho,Ten,DiaChi,NgaySinh,Luong,GhiChu,MaCN) VALUES(?,?,?,?,?,?,?,?)";
        Connection connection = ConnectionUtil.getConnection();
        PreparedStatement preparedStatement = null;
        try {
            connection.setAutoCommit(false);
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, nhanVien.getMaNV());
            preparedStatement.setString(2, nhanVien.getHo());
            preparedStatement.setString(3, nhanVien.getTen());
            preparedStatement.setString(4, nhanVien.getDiachi());
            preparedStatement.setDate(5, (Date) nhanVien.getNgaysinh());
            preparedStatement.setFloat(6, nhanVien.getLuong());
            preparedStatement.setString(7, nhanVien.getGhichu());
            preparedStatement.setString(8, nhanVien.getChinhanh().getMaCN());
            int r = preparedStatement.executeUpdate();
            if (r == 1) {
                connection.commit();
                return nhanVien;
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
        return null;
    }
    public NhanVien update(NhanVien nhanVien,int s) {
        String sql = "UPDATE NhanVien SET MaNV = ? ,Ho = ?,Ten = ?, DiaChi = ?, NgaySinh= ?, Luong = ?, GhiChu= ?, MACN = ? WHERE MANV = ?";
        Connection connection = ConnectionUtil.getConnection();
        PreparedStatement preparedStatement = null;
        try {
            connection.setAutoCommit(false);
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, nhanVien.getMaNV());
            preparedStatement.setString(2, nhanVien.getHo());
            preparedStatement.setString(3, nhanVien.getTen());
            preparedStatement.setString(4, nhanVien.getDiachi());
            preparedStatement.setDate(5, (Date) nhanVien.getNgaysinh());
            preparedStatement.setFloat(6, nhanVien.getLuong());
            preparedStatement.setString(7, nhanVien.getGhichu());
            preparedStatement.setString(8, nhanVien.getChinhanh().getMaCN());
            preparedStatement.setInt(9,s);
            int r = preparedStatement.executeUpdate();
            if (r == 1) {
                connection.commit();
                return nhanVien;
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
        return null;
    }
    public boolean delete(String maNV) {
        String sql = "DELETE FROM NhanVien WHERE MaNV = ?";
        Connection connection = ConnectionUtil.getConnection();
        PreparedStatement preparedStatement = null;
        try {
            connection.setAutoCommit(false);
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, maNV);
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
    public List<NhanVien> search(NhanVien nhanVienSearch) {
        String sql = "SELECT * FROM NhanVien WHERE 1 = 1 ";
//        if (Integer.toString(nhanVienSearch.getMaNV()) != null) {
//            sql += "AND MaNV LIKE ? ";
//        }
        if (nhanVienSearch.getTen()!= null) {
            sql += "AND Ten LIKE ? ";
        }
        if (nhanVienSearch.getChinhanh().getMaCN() != null) {
            sql += "AND MaCN = ? ";
        }
        int index = 1;
        Connection connection = ConnectionUtil.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<NhanVien> result = new ArrayList<>();
        try {
            preparedStatement = connection.prepareStatement(sql);
//            if (Integer.toString(nhanVienSearch.getMaNV()) != null) {
//                preparedStatement.setString(index, "%" + nhanVienSearch.getMaNV()+ "%");
//                index++;
//            }
             if (nhanVienSearch.getTen()!= null) {
                preparedStatement.setString(index, "%" + nhanVienSearch.getTen()+ "%");
                index++;
            }
            if (nhanVienSearch.getChinhanh().getMaCN() != null) {
                preparedStatement.setString(index, nhanVienSearch.getChinhanh().getMaCN());
                index++;
            }
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                NhanVien nhanVien = new NhanVien();
                nhanVien.setMaNV(resultSet.getInt("MaNV"));
                nhanVien.setHo(resultSet.getString("Ho"));
                nhanVien.setTen(resultSet.getString("Ten"));
                nhanVien.setDiachi(resultSet.getString("DiaChi"));
                nhanVien.setNgaysinh(resultSet.getDate("NgaySinh"));
                nhanVien.setLuong(resultSet.getFloat("Luong"));
                nhanVien.setGhichu(resultSet.getString("GhiChu"));
                ChiNhanh chiNhanh =new ChiNhanh();
                chiNhanh.setMaCN(resultSet.getString("MaCN"));
                nhanVien.setChinhanh(chiNhanh);
                result.add(nhanVien);
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
        return result;
    }
    public static void main(String[] args) {
        NhanVienDao nhanVienDao = new NhanVienDao();
        NhanVien nvSearch = new NhanVien();
        System.out.println(nhanVienDao.search(nvSearch));
    }
}
