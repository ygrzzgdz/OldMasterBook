package org.lanqiao.controller;

import cn.hutool.captcha.LineCaptcha;
import org.lanqiao.pojo.Users;
import org.lanqiao.service.UsersService;
import org.lanqiao.service.impl.UsersServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URLEncoder;
import java.util.List;
import java.util.function.Consumer;

@WebServlet("/users")
public class UsersController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            //获取到action的值
            String action = req.getParameter("action");
            //使用反射，获取到方法
            Method method = this.getClass().getDeclaredMethod(action,
                    HttpServletRequest.class,HttpServletResponse.class);
            //方法执行
            method.invoke(this,req,resp);
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
        doGet(req,resp);
    }

    //登录方法
    private void login(HttpServletRequest req, HttpServletResponse resp)throws Exception{
        //获取页面的用户名
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        //参数存实体类
        Users users = new Users(username,password);
        //调用service层的登录方法
        UsersService usersService = new UsersServiceImpl();
        List<Users> list = usersService.login(users);

        //判断集合大小   集合大于0 说明查到了数据>>登陆成功  否则登录失败
        if(list.size()>0){
            //从list里面拿出实体类>>获取用户名，存到session
            //方式一
            //存session
            req.getSession().setAttribute("username",list.get(0).getUsername());


           /*
            //方式二
           String user_name=null;
            for (Users u:list) {
                user_name = u.getUsername();
            }
            //存session
            req.getSession().setAttribute("username",user_name);
            */
            /*
            //方式三
            list.stream().forEach(u-> req.getSession().setAttribute("username",u.getUsername()));
             */
            //跳转到查询全部图书的功能
//            req.getRequestDispatcher("books?action=findAll").forward(req,resp);
//        }else{
//            //cookie存失败的提示信息
//            Cookie cookie = new Cookie("login_err_msg","账号密码错误，请重新登录");
//            //回到登录页面
//            resp.sendRedirect("login.jsp");
//        }
            resp.getWriter().write("true");
            resp.getWriter().close();

        }else{
            resp.getWriter().write("false");
            resp.getWriter().close();


        }

    }
    //注册
    private void reg(HttpServletRequest req,HttpServletResponse resp) throws Exception{
        //获取表单里的数据
        String  username = req.getParameter("username");
        String  password = req.getParameter("password");
        String  contact = req.getParameter("contact");
        String  mobilephone = req.getParameter("mobilephone");
        String  address = req.getParameter("address");
        String  email = req.getParameter("email");
        //数据存实体类
        Users users = new Users(0L,username,password,contact,mobilephone,address,email,0);
        //调用service层的注册方法
        UsersService usersService = new UsersServiceImpl();
        boolean boo = usersService.reg(users);
        //判断
        if(boo){//注册成功
            //跳转到登录页面
            resp.sendRedirect("login.jsp");
        }else{
            Cookie cookie = new Cookie("reg_err_msg", URLEncoder.encode("服务器繁忙，请稍后再试","UTF-8"));
            resp.addCookie(cookie);
            resp.sendRedirect("reg.jsp");
        }
    }

    //根据名字查询 ajax
    private void findByName(HttpServletRequest req,HttpServletResponse resp)throws  Exception{
        //获取名字
        String username = req.getParameter("username");
        //调用service层根据名字查询的方法
        UsersService usersService = new UsersServiceImpl();
        List<Users> list = usersService.findByName(username);
        //判断  页面响应true 代表用户名存在  false 代表用户名不存在
        boolean boo = false;
        if(list.size()>0){
            boo = true;
        }

        PrintWriter out = resp.getWriter();
        out.write(String.valueOf(boo));
        out.flush();
        out.close();

    }

    //获取验证码
    private void getCode(HttpServletRequest req,HttpServletResponse resp)throws  Exception{
        //实例化工具类
        LineCaptcha lineCaptcha = new LineCaptcha(120,40,5,25);
        //获取生成验证码的值
        String code = lineCaptcha.getCode();
        //code存到session,方便验证
        req.getSession().setAttribute("code",code);
        //设置输出格式
        resp.setContentType("images/jpeg");
        //清除浏览器缓存
        resp.setHeader("Pragma","No-cache");
        //输出到页面
        lineCaptcha.write(resp.getOutputStream());
        //关闭资源
        resp.getOutputStream().close();
    }
    //验证验证码
    private void checkCode(HttpServletRequest req,HttpServletResponse resp)throws Exception{
        //获取文本框的验证码
        String code_text = req.getParameter("code");
        //获取session里的验证码
        String code_session = (String) req.getSession().getAttribute("code");

        //判断
        boolean boo = false;
        //equalsIgnoreCase  忽略大小写（String里的一个方法）
        if(code_session.equalsIgnoreCase(code_text)){
            boo = true;
        }

        PrintWriter out =  resp.getWriter();
        out.write(String.valueOf(boo));
        out.close();
    }

    private void loginout(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        //清除指定的session
        req.getSession().removeAttribute("username");
        resp.sendRedirect(req.getContextPath()+"front/login.jsp");

    }

}
