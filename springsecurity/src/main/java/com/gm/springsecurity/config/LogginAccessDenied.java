package com.gm.springsecurity.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class LogginAccessDenied implements AccessDeniedHandler {

    private static Logger log = LoggerFactory.getLogger(LogginAccessDenied.class);

    @Override
    public void handle(HttpServletRequest httpServletRequest,
                       HttpServletResponse httpServletResponse,
                       AccessDeniedException e) throws IOException, ServletException {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication != null){
            log.info(authentication.getName()
                +"was trying to access protected resource: "
                    +httpServletRequest.getRequestURI());

        }

        httpServletResponse.sendRedirect(httpServletRequest.getContextPath() + "/access-denied");
    }
}
