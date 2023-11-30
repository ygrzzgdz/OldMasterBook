package org.lanqiao.dao.impl;

import org.lanqiao.dao.OrdersDao;
import org.lanqiao.util.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class OrdersDaoImpl implements OrdersDao {
    private Connection conn;
    private PreparedStatement pst;
    private ResultSet rs;
    @Override
    public int findAllCount(String username) {
        int count = 0;
        try{
            String sql = "select count(*) count from orders o,users u where o.uid = u.uid and username = ?";
            Object[] obj = {username};
            rs = JDBCUtil.exeQuery(sql,obj);
            while (rs.next()){
                count = rs.getInt("count");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return 0;
    }
}
