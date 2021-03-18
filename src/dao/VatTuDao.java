/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import connect.ConnectionUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.VatTu;

/**
 *
 * @author khain
 */
public class VatTuDao {
    public List<VatTu> findAll() {
        String sql = "SELECT * FROM VatTu";
        Connection connection = ConnectionUtil.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<VatTu> result = new ArrayList<>();
        try {
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                VatTu vattu = new VatTu();
                vattu.setMaVT(resultSet.getString("MaVT"));
                vattu.setTenVT(resultSet.getString("TenVT"));
                vattu.setDVT(resultSet.getString("DVT"));
                result.add(vattu);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            try {
                resultSet.close();
                preparedStatement.close();
                connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(VatTuDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return result;
    }

    public VatTu findByMaVT(String MaVT) {
        Connection connection = ConnectionUtil.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String sql = "SELECT * FROM VatTu WHERE MaVT = ?";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, MaVT);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                VatTu vattu = new VatTu();
                vattu.setMaVT(resultSet.getString("MaVT"));
                vattu.setTenVT(resultSet.getString("TenVT"));
                vattu.setDVT(resultSet.getString("DVT"));
                return vattu;
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            try {
                resultSet.close();
                preparedStatement.close();
                connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(VatTuDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }
    
    public VatTu findByTenVT(String TenVT) {
        Connection connection = ConnectionUtil.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String sql = "SELECT * FROM VatTu WHERE TenVT = ?";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, TenVT);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                VatTu vattu = new VatTu();
                vattu.setMaVT(resultSet.getString("MaVT"));
                vattu.setTenVT(resultSet.getString("TenVT"));
                vattu.setDVT(resultSet.getString("DVT"));
                return vattu;
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            try {
                resultSet.close();
                preparedStatement.close();
                connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(VatTuDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }

    public VatTu create(VatTu vattu) {
        String sql = "INSERT INTO VatTu(MaVT,TenVT,DVT) VALUES(?,?,?)";
        Connection connection = ConnectionUtil.getConnection();
        PreparedStatement preparedStatement = null;
        try {
            connection.setAutoCommit(false);
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, vattu.getMaVT());
            preparedStatement.setString(2, vattu.getTenVT());
            preparedStatement.setString(3, vattu.getDVT());
            int r = preparedStatement.executeUpdate();
            if (r == 1) {
                connection.commit();
                return vattu;
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            try {
                connection.rollback();
            } catch (SQLException ex1) {
                Logger.getLogger(VatTu.class.getName()).log(Level.SEVERE, null, ex1);
            }
        } finally {
            try {
                preparedStatement.close();
                connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(VatTuDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }

    public VatTu update(VatTu vattu,String s) {
        String sql = "UPDATE VatTu SET MaVT = ?, TenVT = ?, DVT = ? WHERE MaVT = ?";
        Connection connection = ConnectionUtil.getConnection();
        PreparedStatement preparedStatement = null;
        try {
            connection.setAutoCommit(false);
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, vattu.getMaVT());
            preparedStatement.setString(2, vattu.getTenVT());
            preparedStatement.setString(3, vattu.getDVT());
            preparedStatement.setString(4,s);
            int r = preparedStatement.executeUpdate();
            if (r == 1) {
                connection.commit();
                return vattu;
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            try {
                connection.rollback();
            } catch (SQLException ex1) {
                Logger.getLogger(VatTu.class.getName()).log(Level.SEVERE, null, ex1);
            }
        } finally {
            try {
                preparedStatement.close();
                connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(VatTuDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }

    public boolean delete(String MaVT) {
        String sql = "DELETE FROM VatTu WHERE MaVT = ?";
        Connection connection = ConnectionUtil.getConnection();
        PreparedStatement preparedStatement = null;
        try {
            connection.setAutoCommit(false);
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, MaVT);
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
                Logger.getLogger(VatTu.class.getName()).log(Level.SEVERE, null, ex1);
            }
        } finally {
            try {
                preparedStatement.close();
                connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(VatTuDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;
    }

    public List<VatTu> search(VatTu vattuSearch) {
        String sql = "SELECT * FROM VatTu WHERE 1 = 1 ";
        if (vattuSearch.getMaVT()!= null) {
            sql += "AND MaVT LIKE ? ";
        }
        if (vattuSearch.getTenVT()!= null) {
            sql += "AND TenVT LIKE ? ";
        }
        if (vattuSearch.getDVT()!= null) {
            sql += "AND DVT LIKE ? ";
        }
        int index = 1;
        Connection connection = ConnectionUtil.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<VatTu> result = new ArrayList<>();
        try {
            preparedStatement = connection.prepareStatement(sql);
            if (vattuSearch.getMaVT() != null) {
                preparedStatement.setString(index, "%" + vattuSearch.getMaVT() + "%");
                index++;
            }
            if (vattuSearch.getTenVT() != null) {
                preparedStatement.setString(index, "%" + vattuSearch.getTenVT() + "%");
                index++;
            }
            if (vattuSearch.getDVT() != null) {
                preparedStatement.setString(index, "%" + vattuSearch.getDVT() + "%");
                index++;
            }
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                VatTu vattu = new VatTu();
                vattu.setMaVT(resultSet.getString("MaVT"));
                vattu.setTenVT(resultSet.getString("TenVT"));
                vattu.setDVT(resultSet.getString("DVT"));
                result.add(vattu);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            try {
                resultSet.close();
                preparedStatement.close();
                connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(VatTuDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return result;
    }
}
