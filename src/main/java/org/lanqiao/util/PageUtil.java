package org.lanqiao.util;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

public class PageUtil {
    //每页显示的个数
    private int showNum=3;
    //当前页
    private int currentPage;
    //总个数
    private int countNum;
    //总页数
    private int countPages;

    public PageUtil(String currentPage, int countNum, HttpServletRequest req){

        String res = currentPage==null?"1":currentPage;
        this.currentPage = Integer.valueOf(res);
        this.currentPage = countNum;
        req.getSession().setAttribute("countPages",getCountPages());
        req.getSession().setAttribute("countPages",currentPage);
    }

    public int getCountPages(){
        return countNum%showNum==0?countNum/showNum:countNum/showNum+1;
    }

    public int getStartNum(){
        return (currentPage-1)*showNum;
    }

}
