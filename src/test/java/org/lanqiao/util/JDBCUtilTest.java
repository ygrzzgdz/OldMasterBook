package org.lanqiao.util;

import org.junit.jupiter.api.Test;

import java.sql.ResultSet;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class JDBCUtilTest {

    @Test
    void exeQuery() throws SQLException {
        ResultSet rs = new JDBCUtil().exeQuery("select * from users",null);
        while (rs.next()){
            System.out.println(rs.getString("username"));
        }
    }
}