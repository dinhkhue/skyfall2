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
public class ChiNhanhDao {
        public List<ChiNhanh> findAll(){
        String sql ="SELECT * FROM ChiNhanh";
        Connection connection = ConnectionUtil.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<ChiNhanh> result  =new ArrayList<>();
        try {
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                ChiNhanh chiNhanh =new ChiNhanh();
                chiNhanh.setMaCN(resultSet.getString("MaCN"));
                chiNhanh.setTen(resultSet.getString("ChiNhanh"));
                chiNhanh.setDiachi(resultSet.getString("DiaChi"));
                chiNhanh.setSdt(resultSet.getString("SoDienThoai"));
                result.add(chiNhanh);
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
            ChiNhanhDao chiNhanhDao = new ChiNhanhDao();
            ChiNhanh chiNhanh = new ChiNhanh();
            System.out.println(chiNhanhDao.findAll());
    }
        
    
}
