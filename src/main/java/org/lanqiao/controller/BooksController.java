package org.lanqiao.controller;

import org.lanqiao.pojo.Books;
import org.lanqiao.pojo.Category;
import org.lanqiao.service.BooksService;
import org.lanqiao.service.impl.BooksServiceImpl;

import javax.jws.WebService;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

@WebServlet("/books")
public class BooksController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            //获取到action的值
            String action = req.getParameter("action");
            //使用反射，获取到方法
            Method method = this.getClass().getDeclaredMethod(action,
                    HttpServletRequest.class, HttpServletResponse.class);
            //方法执行
            method.invoke(this, req, resp);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }


    //查询所有图书类别
    private void findAllType(HttpServletRequest req,HttpServletResponse resp) throws Exception{
        //调用service层查询所有图书类别的信息
        BooksService booksService = new BooksServiceImpl();
        List<Category> list = booksService.findAllType();
        if(list.size()>0){
            //集合存到session
            req.getSession().setAttribute("types",list);
            resp.getWriter().write("true");
            resp.getWriter().close();
        }else{
            req.getSession().setAttribute("types_fail","网络异常");
            resp.getWriter().write("false");
            resp.getWriter().close();
        }
    }

    //查询全部图书、查询所有的图书类型
//    private void findAll(HttpServletRequest req,HttpServletResponse resp)throws Exception{
//        //调用service层
//        BooksService booksService = new BooksServiceImpl();
//        //调用service层的查询全部图书方法
//        List<Books> list = booksService.findAllBooks();
//        //调用service层的查询全部图书类别的方法
//        List<Category> list1 = booksService.findAllType();
//        if (list.size()>0 && list1.size()>0){
//            //计算总页数
//            int i = list.size()%3==0?list.size()/3:list.size()/3+1;
//            //总也数存session
//            req.getSession().setAttribute("count",1);
//
//            req.getSession().setAttribute("types",list1);
//            req.getSession().setAttribute("books",list);
//            resp.sendRedirect("/front/main.jsp");
//        }
//    }

    private void findByCid(HttpServletRequest req,HttpServletResponse resp)throws Exception {
        //接收前端传来的值
        String c = req.getParameter("cid");

        //调用service层
        BooksService booksService = new BooksServiceImpl();
        //调用service层的查询全部图书方法
        List<Books> list = booksService.findByCid(c);
        if (list.size()>0){
            req.getSession().setAttribute("books",list);
            resp.sendRedirect("/front/main.jsp");
        }
    }

    private void findAllPage(HttpServletRequest req,HttpServletResponse resp)throws Exception{
        //获取当前页
        String currentPage = req.getParameter("currentPage");
        //登录时候没有currentPage 设置初始值为1 其他情况的值
        currentPage = currentPage==null?"1":currentPage;
        //调用service层
        BooksService booksService = new BooksServiceImpl();
        //调用service层的查询全部图书的方法
        List<Books> list = booksService.findAllBooks(currentPage);
        //调用service层的查询全部图书类别的方法
        List<Category> list1 = booksService.findAllType();
        //调用service层查询总个数的方法
        int count = booksService.count();
        if (list.size()>0 && list1.size()>0){
            req.getSession().setAttribute("currentPage",currentPage);
            req.getSession().setAttribute("types",list1);
            req.getSession().setAttribute("books",list);
            resp.sendRedirect("front/main.jsp");
        }
    }



}