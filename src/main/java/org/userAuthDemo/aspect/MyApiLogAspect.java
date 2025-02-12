package org.userAuthDemo.aspect;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletRequest;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.example.demo.service.DemoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.lang.reflect.Method;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.*;


@Aspect
@Component
public class MyApiLogAspect {
    Logger logger = LoggerFactory.getLogger(MyApiLogAspect.class);



    /** 以 controller 包下定义的所有请求为切入点
    @Pointcut("execution(public * org.userAuthDemo.controller..*.*(..))")
     */
    @Pointcut("@annotation(org.userAuthDemo.aspect.ApiLog)") //有ApiLog注解的方法
    public void pointcut(){
        //do nothing just for filtering
    }

    @Before("pointcut()")
    public void printRequestDatagram(JoinPoint joinPoint) throws JsonProcessingException {
        logger.info("========================================== Start ==========================================");
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();

        Enumeration<String> headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String name = headerNames.nextElement();
            logger.info(MessageFormat.format("{0}: {1} ", name, request.getHeader(name)));
        }

        Enumeration<String> params = request.getParameterNames();
        Map<String, String> paramsMap = new HashMap<>();
        while (params.hasMoreElements()) {
            String name = params.nextElement();
            paramsMap.put(name, request.getParameter(name));
        }
        ObjectMapper objectMapper = new ObjectMapper();
        // throws JsonProcessingException
        logger.info("HttpServletRequest paramsMap:{}", objectMapper.writeValueAsString(paramsMap));

    }

    @Around("pointcut()")
    public Object printResponseDatagram(ProceedingJoinPoint joinPoint) throws Throwable {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        String ip = getIpAddress(request);

        logger.info(MessageFormat.format(">>> {0} around pointcut start", getIpAddress(request)));
        Object result = joinPoint.proceed();
        logger.info("around pointcut end <<<");
        return result;
    }

    @After("pointcut()")
    public void doAfter() throws Throwable {
        logger.info("=========================================== End ===========================================");
        logger.info("");
    }

    /**
     * @param: [request]
     * @return: java.lang.String
     * @desc: 获取IP地址
     * @see
     * @since
     */
    private String getIpAddress(HttpServletRequest request){
        final String UNKNOWN = "unknown";
        String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0 || UNKNOWN.equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || UNKNOWN.equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || UNKNOWN.equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_CLIENT_IP");
        }
        if (ip == null || ip.length() == 0 || UNKNOWN.equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_X_FORWARDED_FOR");
        }
        if (ip == null || ip.length() == 0 || UNKNOWN.equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        return ip;
    }

}
