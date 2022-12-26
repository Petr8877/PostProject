package by.itacademy.postproject.controllers.web.filters;

import by.itacademy.postproject.dto.UserSessionDTO;
import by.itacademy.postproject.entity.ClientType;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(urlPatterns = {"/ui/admin/*", "/api/admin/*"})
public class AdminSecurityFilter implements Filter {
    @Override

    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        String contextPath = req.getContextPath();
        HttpSession session = req.getSession();
        if ((session != null) && (session.getAttribute("user") != null)) {
            UserSessionDTO user = (UserSessionDTO) session.getAttribute("user");

            if (user.getClientType().equals(ClientType.ADMINISTRATOR)){
                chain.doFilter(request,response);
            }else {
                res.sendRedirect(contextPath+"/ui/signIn");
            }

        }else {
            res.sendRedirect(contextPath + "/ui/signIn");
        }

    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void destroy() {
    }
}