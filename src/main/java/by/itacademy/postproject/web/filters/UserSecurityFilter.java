package by.itacademy.postproject.web.filters;


import by.itacademy.postproject.dto.ClientType;
import by.itacademy.postproject.dto.UserSessionDTO;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(urlPatterns = {"/ui/user/*", "/api/message"})
public class UserSecurityFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        String contextPath = request.getContextPath();
        HttpSession session = request.getSession();
        if (session != null && session.getAttribute("user") != null){
            filterChain.doFilter(request,response);

        }else {
            response.sendRedirect(contextPath+"/signIn");
        }
    }


    @Override
    public void destroy() {

    }
}
