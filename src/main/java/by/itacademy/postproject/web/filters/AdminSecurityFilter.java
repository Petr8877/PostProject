package by.itacademy.postproject.web.filters;


import by.itacademy.postproject.dto.ClientType;
import by.itacademy.postproject.dto.UserDTO;
import by.itacademy.postproject.dto.UserSessionDTO;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
@WebFilter(urlPatterns = {"/ui/admin/*", "/api/admin/*"})
public class AdminSecurityFilter implements Filter {
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
            UserSessionDTO user = (UserSessionDTO) session.getAttribute("user");

            if (user.getClientType().equals(ClientType.ADMINISTRATOR)){
                filterChain.doFilter(request,response);
            }else {
                response.sendRedirect(contextPath+"/ui/signIn");
            }

        }else {
            response.sendRedirect(contextPath+"/ui/signIn");
        }
    }


    @Override
    public void destroy() {

    }
}
