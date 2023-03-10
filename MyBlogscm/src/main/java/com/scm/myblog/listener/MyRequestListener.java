//package com.scm.myblog.listener;
//
//import org.springframework.context.annotation.Configuration;
//
//import javax.servlet.*;
//import javax.servlet.annotation.WebListener;
//import javax.servlet.http.*;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Map;
//
//
//@Configuration
//@WebListener
//public class MyRequestListener implements ServletRequestListener{
//
//    private HttpServletRequest sr;
//    private String clientIp;
//    private ServletContext sc;
//    private HttpSession currentSession;
//    private Map<String,List<HttpSession>> map;
//    private List<HttpSession> sessions;
//
//    /*
//    每次请求都会被监视
//    */
//    @Override
//    //请求被初始化 Request
//    public void requestInitialized(ServletRequestEvent sre) {
//        //从请求域中获取IP
//        sr = (HttpServletRequest) sre.getServletRequest();
//        clientIp = sr.getRemoteAddr();
//        currentSession  = sr.getSession();
//        //将当前Session 对象存放到List中， List在Map中，Map在全局域中，
//        sc = sre.getServletContext();
//        map = (Map<String, List<HttpSession>>) sc.getAttribute("map");
//        //从Map中获取由当前IP所发出的所有Session的组成的List
//        sessions = map.get(clientIp);
//        //判断当前的List是否为NULL，若为NULL，则创建List，否则，将当前Session放入List
//        if (sessions == null){
//            sessions = new ArrayList<>();
//        }
//        //遍历List的session 对象，若有则不添加，若没有则添加
//        for (HttpSession session : sessions) {
//            if (session == currentSession)
//                return;
//        }
//        sessions.add(currentSession);
//
//
//        //将变化过的List重新写回到Map
//        map.put(clientIp,sessions);
//        //再将变化的Map写回到全局域中
//        sc.setAttribute("map",map);
//
//        //将当前IP放入到当前Session
//        currentSession.setAttribute("clientIp",clientIp);
//    }
//
//}