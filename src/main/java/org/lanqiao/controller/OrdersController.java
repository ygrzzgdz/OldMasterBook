package org.lanqiao.controller;

import org.lanqiao.service.OrdersService;
import org.lanqiao.service.impl.OrdersServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@WebServlet("/orders")
public class OrdersController extends HttpServlet {
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

    private void findAll(HttpServletRequest req,HttpServletResponse resp)throws  Exception{
        //获取当前页
        String currentPage = req.getParameter("currentPage");

        //获取当前用户
        String username = (String) req.getSession().getAttribute("username");
        //查询当前用户的订单总数
        OrdersService ordersService = new OrdersServiceImpl();
        int count = ordersService.findAllCount(username);


    }

}
