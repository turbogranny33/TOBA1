package com.toba.filters;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginFilter implements Filter {
    
    private FilterConfig filterConfig = null;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.filterConfig = filterConfig;
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest)request;
        HttpServletResponse httpResponse = (HttpServletResponse)response;
        ServletContext sc = filterConfig.getServletContext();
        
        String filterName = filterConfig.getFilterName();
        String servletPath = "Servlet path: " + httpRequest.getServletPath();
        
        PrintWriter pw = new PrintWriter(new FileWriter("LoginFilter.log", true));
 
        String logLine = filterName + " | " + servletPath + " | before request";
        sc.log(logLine);
        pw.println(logLine); 
        
        chain.doFilter(httpRequest, httpResponse);
        
        logLine = filterName + " | " + servletPath + " | after request";
        sc.log(logLine);
        pw.println(logLine);

        pw.close();        
    }

    @Override
    public void destroy() {
        filterConfig = null;
    }   
}