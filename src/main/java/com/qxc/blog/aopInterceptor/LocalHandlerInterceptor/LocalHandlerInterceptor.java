package com.qxc.blog.aopInterceptor.LocalHandlerInterceptor;

import com.qxc.blog.configuration.BaseConfiguration;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.annotation.Resource;
import java.net.InetAddress;
import java.util.Objects;

/**
 * @Author qxc
 * @Date 2024 2024/6/3 下午10:56
 * @Version 1.0
 * @PACKAGE com.qxc.blog.aopInterceptor.LocalHandlerInterceptor
 */
@Component
@Slf4j
public class LocalHandlerInterceptor implements HandlerInterceptor {

    @Resource
    private BaseConfiguration baseConfiguration;

    @Override
    public boolean preHandle(@NotNull HttpServletRequest request, @NotNull HttpServletResponse response, @NotNull Object handler) throws Exception {
        if (!(handler instanceof HandlerMethod handlerMethod)) {
            return true;
        }

        // 获取注解
        final OnlyLocalHost methodAnnotation = handlerMethod.getMethodAnnotation(OnlyLocalHost.class);
        if (Objects.isNull(methodAnnotation) || !methodAnnotation.value()) {
            return true;
        }

        // 查询IP
        String hostAddress = InetAddress.getLocalHost().getHostAddress();
        String remoteAddress = getRemoteAddr(request);
        String servletPath = request.getServletPath();
        if (hostAddress.equals(remoteAddress) || remoteAddress.equals(baseConfiguration.getIpv4Url()) || remoteAddress.equals(baseConfiguration.getIpv6Url())) {
            return true;
        } else {
            log.warn("{remoteAddress:{},Code:500,Msg:紧允许服务器本机查看}", remoteAddress);
            response.getWriter().write("permission");
            return false;
        }
    }

    /**
     * 获取IP地址
     *
     * @param request
     * @return
     */
    public String getRemoteAddr(@NotNull HttpServletRequest request) {
        String remoteAddress = request.getHeader("x-forwarded-for");
        if (remoteAddress == null || remoteAddress.isEmpty() || "unknown".equalsIgnoreCase(remoteAddress)) {
            remoteAddress = request.getHeader("Proxy-Client-IP");
        }
        if (remoteAddress == null || remoteAddress.isEmpty() || "unknown".equalsIgnoreCase(remoteAddress)) {
            remoteAddress = request.getHeader("WL-Proxy-Client-IP");
        }
        if (remoteAddress == null || remoteAddress.isEmpty() || "unknown".equalsIgnoreCase(remoteAddress)) {
            remoteAddress = request.getHeader("HTTP_CLIENT_IP");
        }
        if (remoteAddress == null || remoteAddress.isEmpty() || "unknown".equalsIgnoreCase(remoteAddress)) {
            remoteAddress = request.getHeader("HTTP_X_FORWARDED_FOR");
        }
        if (remoteAddress == null || remoteAddress.isEmpty() || "unknown".equalsIgnoreCase(remoteAddress)) {
            remoteAddress = request.getRemoteAddr();
        }
        return remoteAddress;
    }
}
