package org.neryadom.notes.utils.filters;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class Timer implements Filter {

    private final Logger log = LoggerFactory.getLogger(Timer.class);

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        long startTime = System.currentTimeMillis();

        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;
        String method = httpServletRequest.getMethod();
        String uri = httpServletRequest.getRequestURI();

        filterChain.doFilter(servletRequest, servletResponse);

        int status = httpServletResponse.getStatus();
        long endTime = System.currentTimeMillis();
        log.info("status: {} method: {}, uri: {}, timeTaken: {}ms", status, method, uri, endTime - startTime);
    }
}
