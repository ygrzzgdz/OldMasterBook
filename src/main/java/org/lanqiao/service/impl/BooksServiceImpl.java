package org.lanqiao.service.impl;

import org.lanqiao.dao.BooksDao;
import org.lanqiao.dao.impl.BooksDaoImpl;
import org.lanqiao.pojo.Books;
import org.lanqiao.pojo.Category;
import org.lanqiao.service.BooksService;

import java.util.List;

public class BooksServiceImpl implements BooksService {
    //查询所有图书类别
    @Override
    public List<Category> findAllType() {
        BooksDao booksDao = new BooksDaoImpl();

        return booksDao.findAllType();
    }

    @Override
    public List<Books> findAllBooks(String currentPage) {
        BooksDao booksDao = new BooksDaoImpl();
        //计算分页查询时候的起始值
        int startNum = (Integer.parseInt(currentPage)-1)*3;

        return booksDao.findAllBooks(startNum);
    }

    @Override
    public List<Books> findByCid(String cid) {
        BooksDao booksDao = new BooksDaoImpl();
        return booksDao.findByCid(cid);
    }

    @Override
    public int count() {
        BooksDao booksDao = new BooksDaoImpl();
        //计算页数
        int count = booksDao.count();
        count = count%3==0?count/3:count/3+1;
        return count;
    }


}
