package com.testjavaweb.filter;

import com.testjavaweb.constant.SystemConstant;
import com.testjavaweb.model.UserModel;
import com.testjavaweb.utils.SessionUtil;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AuthorizationFilter implements Filter {

    private ServletContext context;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.context = filterConfig.getServletContext();
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        String url = request.getRequestURI();
        if(url.startsWith(request.getContextPath()+"/admin")){
            UserModel model = (UserModel) SessionUtil.getInstance().getValue(request, "USERMODEL");
            if(model != null){
                if(model.getRole().getCode().equals(SystemConstant.ADMIN)){
                    filterChain.doFilter(request, response);
                } else if (model.getRole().getCode().equals(SystemConstant.USER)) {
                    response.sendRedirect(request.getContextPath()+"/dang-nhap?action=login&message=not_permission&alert=danger");
                }
            }
            else {
                response.sendRedirect(request.getContextPath()+"/dang-nhap?action=login&message=not_login&alert=danger");
            }
        }
        else {
            filterChain.doFilter(request, response);
        }
    }

    @Override
    public void destroy() {

    }
}
