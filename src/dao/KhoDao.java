/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;
import model.*;
import connect.*;
import java.sql.Connection;
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
public class KhoDao {
    public List<Kho> findAll(){
        String sql ="SELECT * FROM Kho";
        Connection connection = ConnectionUtil.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Kho> result  =new ArrayList<>();
        try {
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Kho kho = new Kho();
                kho.setMaKho(resultSet.getString("MaKho"));
                kho.setTenKho(resultSet.getString("TenKho"));
                kho.setDiacchi(resultSet.getString("DiaChi"));
                ChiNhanh chiNhanh =new ChiNhanh();
                chiNhanh.setMaCN(resultSet.getString("MaCN"));
                kho.setChinhanh(chiNhanh);
                result.add(kho);
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
    public Kho findByMaKho(String maKho) {
        Connection connection = ConnectionUtil.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String sql = "SELECT * FROM Kho WHERE MaKho = ?";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, maKho);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                Kho kho = new Kho();
                kho.setMaKho(resultSet.getString("maKho"));
                kho.setTenKho(resultSet.getString("tenKho"));
                kho.setDiacchi(resultSet.getString("diachi"));
                ChiNhanh chinhanh =new ChiNhanh();
                chinhanh.setMaCN(resultSet.getString("maCN"));
                kho.setChinhanh(chinhanh);
                return kho;
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
    public Kho findByTenKho(String tenKho) {
        Connection connection = ConnectionUtil.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String sql = "SELECT * FROM Kho WHERE TenKho = ?";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, tenKho);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                Kho kho = new Kho();
                kho.setMaKho(resultSet.getString("maKho"));
                kho.setTenKho(resultSet.getString("tenKho"));
                kho.setDiacchi(resultSet.getString("diachi"));
                ChiNhanh chinhanh =new ChiNhanh();
                chinhanh.setMaCN(resultSet.getString("maCN"));
                kho.setChinhanh(chinhanh);
                return kho;
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
    public Kho create(Kho kho) {
        String sql = "INSERT INTO Kho(MaKho,TenKho,DiaChi,MaCN) VALUES(?,?,?,?)";
        Connection connection = ConnectionUtil.getConnection();
        PreparedStatement preparedStatement = null;
        try {
            connection.setAutoCommit(false);
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, kho.getMaKho());
            preparedStatement.setString(2, kho.getTenKho());
            preparedStatement.setString(3, kho.getDiacchi());
            preparedStatement.setString(4, kho.getChinhanh().getMaCN());
            int r = preparedStatement.executeUpdate();
            if (r == 1) {
                connection.commit();
                return kho;
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
    public Kho update(Kho kho,String s) {
        String sql = "UPDATE Kho SET MaKho= ?,TenKho= ?,DiaChi= ?,MaCN= ? WHERE MaKho = ?";
        Connection connection = ConnectionUtil.getConnection();
        PreparedStatement preparedStatement = null;
        try {
              connection.setAutoCommit(false);
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, kho.getMaKho());
            preparedStatement.setString(2, kho.getTenKho());
            preparedStatement.setString(3, kho.getDiacchi());
            preparedStatement.setString(4, kho.getChinhanh().getMaCN());
             preparedStatement.setString(5,s);
            int r = preparedStatement.executeUpdate();
            if (r == 1) {
                connection.commit();
                return kho;
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
    public boolean delete(String maKho) {
        String sql = "DELETE FROM Kho WHERE MaKho = ?";
        Connection connection = ConnectionUtil.getConnection();
        PreparedStatement preparedStatement = null;
        try {
            connection.setAutoCommit(false);
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, maKho);
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
    public List<Kho> search(Kho khoSearch) {
        String sql = "SELECT * FROM Kho WHERE 1 = 1 ";
        if (khoSearch.getMaKho()!= null) {
            sql += "AND MaKho LIKE ? ";
        }
        if (khoSearch.getTenKho()!= null) {
            sql += "AND TenKho LIKE ? ";
        }
        if (khoSearch.getDiacchi() != null) {
            sql += "AND DiaChi LIKE ? ";
        }
        if (khoSearch.getChinhanh().getMaCN() != null) {
            sql += "AND MaCN = ? ";
        }
        int index = 1;
        Connection connection = ConnectionUtil.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Kho> result = new ArrayList<>();
        try {
            preparedStatement = connection.prepareStatement(sql);
            if (khoSearch.getMaKho()!= null) {
                preparedStatement.setString(index, "%" + khoSearch.getMaKho()+ "%");
                index++;
            }
             if (khoSearch.getTenKho()!= null) {
                preparedStatement.setString(index, "%" + khoSearch.getTenKho()+ "%");
                index++;
            }
             if (khoSearch.getDiacchi()!= null) {
                preparedStatement.setString(index, "%" + khoSearch.getDiacchi()+ "%");
                index++;
            }
            if (khoSearch.getChinhanh().getMaCN() != null) {
                preparedStatement.setString(index, khoSearch.getChinhanh().getMaCN());
                index++;
            }
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Kho kho = new Kho();
                kho.setMaKho(resultSet.getString("maKho"));
                kho.setTenKho(resultSet.getString("tenKho"));
                kho.setDiacchi(resultSet.getString("diachi"));
                ChiNhanh chinhanh =new ChiNhanh();
                chinhanh.setMaCN(resultSet.getString("maCN"));
                kho.setChinhanh(chinhanh);
                result.add(kho);
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
        KhoDao khoDao = new KhoDao();
        Kho khoSearch = new Kho();
        System.out.println(khoDao.search(khoSearch));
    }
}
