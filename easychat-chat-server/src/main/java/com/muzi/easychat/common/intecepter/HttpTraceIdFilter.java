package com.muzi.easychat.common.intecepter;

import com.muzi.easychat.common.constant.MDCKey;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
import java.util.UUID;

/**
 * Description: 设置链路追踪的值，初期单体项目先简单用
 * Author: <a href="https://github.com/MuziGeek">Muzi</a>
 * Date: 2023-04-05
 */
@Slf4j
@WebFilter(urlPatterns = "/*")
public class HttpTraceIdFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        String tid = UUID.randomUUID().toString();
        MDC.put(MDCKey.TID, tid);
        chain.doFilter(request, response);
        MDC.remove(MDCKey.TID);
    }

}
