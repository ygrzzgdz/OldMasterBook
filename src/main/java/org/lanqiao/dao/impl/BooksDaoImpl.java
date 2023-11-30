package org.lanqiao.dao.impl;

import org.lanqiao.dao.BooksDao;
import org.lanqiao.pojo.Books;
import org.lanqiao.pojo.Category;
import org.lanqiao.util.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class BooksDaoImpl implements BooksDao {
    private Connection conn;
    private PreparedStatement pst;
    private ResultSet rs;

    @Override
    public List<Category> findAllType() {
        List<Category> list = new ArrayList<Category>();
        try {
            //编写sql语句
            String sql ="select * from category";
            rs = JDBCUtil.exeQuery(sql,null);
            while (rs.next()){
                Category category = new Category(rs.getLong("cid"),
                        rs.getString("name"),
                        rs.getString("description"));
                list.add(category);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            JDBCUtil.close(conn,pst,rs);
        }
        return list;
    }

    @Override
    public List<Books> findAllBooks(int startNum) {
        List<Books> list = new ArrayList<>();
        //编写sql
        String sql = "select * from books b,category c where b.cid = c.cid limit ?,3";
        Object[] obj = {startNum};
        //调用工具类里查询的方法
        rs = JDBCUtil.exeQuery(sql,obj);
        //处理结果集
        try {
            while(rs.next()){
                //从数据库查到的数据存到实体类
                Books book = new Books(rs.getLong("bid"),
                        rs.getString("name"),
                        rs.getString("author"),
                        rs.getInt("price"),
                        rs.getString("image"),
                        rs.getString("description"),
                        rs.getInt("stock"),
                        new Category(rs.getLong("cid"),
                                rs.getString("name"),
                                rs.getString("description"))
                );
                //实体类存集合
                list.add(book);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            JDBCUtil.close(conn,pst,rs);
        }
        return list;
    }

    @Override
    public List<Books> findByCid(String cid) {
        List<Books> list = new ArrayList<Books>();
        try {
            Object[] obj = {cid};
            //编写sql语句
            String sql = "select * from books b,category c where b.cid = c.cid and c.cid=?";
            rs = JDBCUtil.exeQuery(sql,obj);
            while (rs.next()){
                Books books = new Books(
                        rs.getLong("bid"),
                        rs.getString("name"),
                        rs.getString("author"),
                        rs.getDouble("price"),
                        rs.getString("image"),
                        rs.getString("description"),
                        rs.getInt("stock"),
                        new Category(rs.getLong("cid")
                        ));
                list.add(books);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            JDBCUtil.close(conn,pst,rs);
        }
        return list;
    }

    public int count(){
        int count = 0;
        try {
            //编写sql
            String sql = "select count(cid) countNum from books";
            rs = JDBCUtil.exeQuery(sql,null);
        }catch (Exception e){
            e.printStackTrace();
        }
        return count;
    }




}

