package kr.co.fastcampus.web;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Slf4j
public class SimpleFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest,
                         ServletResponse servletResponse,
                         FilterChain chain) throws IOException, ServletException {
        log.info("Filter -- Hello World : Simple");
        var request = (HttpServletRequest) servletRequest;
        HttpSession session = request.getSession();
        Object userNameObj = session.getAttribute("userName");
        var userName = (String) userNameObj;
        if (userName == null) {
            log.info("NEW user");
            session.setAttribute("userName", "mkim");
        } else {
            log.info("user : " + userName);
        }

        chain.doFilter(servletRequest, servletResponse);
        var writer = servletResponse.getWriter();
        writer.println("filter - Hello World!!");
    }
}
