package org.userAuthDemo.shiroConfig;

import jakarta.servlet.Filter;
import org.apache.shiro.session.mgt.SessionManager;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.spring.web.config.DefaultShiroFilterChainDefinition;
import org.apache.shiro.spring.web.config.ShiroFilterChainDefinition;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.userAuthDemo.realm.MyRealm2;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class ShiroConfig {

//    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean(DefaultWebSecurityManager securityManager,
                                                         ShiroFilterChainDefinition shiroFilterChainDefinition,
                                                         JwtFilter jwtFilter) {
        // ShiroFilterFactoryBean 用于配置 Shiro 的拦截器链，并与 SecurityManager 关联。
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(securityManager);

        // 并将 JwtFilter 实例与之("jwt")关联。相当于给这个拦截器起了个名字
        // JwtFilter 负责处理所有请求的 JWT 认证。
        Map<String, Filter> filters = new HashMap<>();
        filters.put("jwt", jwtFilter);
        shiroFilterFactoryBean.setFilters(filters);

        // setFilterChainDefinitionMap 用来定义 URL 路径与过滤器的映射关系。所有请求都会通过 jwt 过滤器进行身份验证。
        shiroFilterFactoryBean.setFilterChainDefinitionMap(shiroFilterChainDefinition.getFilterChainMap());
        return shiroFilterFactoryBean;
    }

    // shiroFilterChainDefinition 定义了 URL 路径与过滤器的映射规则。
    // 在这个例子中，所有的请求 (/**) 都必须通过 jwt 过滤器进行身份验证
    // 如果有其他请求需要不同的权限控制，可以在这个方法中进一步调整或添加不同的过滤规则。
//    @Bean
    public ShiroFilterChainDefinition shiroFilterChainDefinition() {
        DefaultShiroFilterChainDefinition chainDefinition = new DefaultShiroFilterChainDefinition();
        chainDefinition.addPathDefinition("/**", "jwt");
        return chainDefinition;
    }

    @Bean(name ="securityManager")
    public DefaultWebSecurityManager getDefaultWebSecurityManager(SessionManager sessionManager) {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(myRealm2());
        securityManager.setSessionManager(sessionManager);
        return securityManager;
    }

    @Bean
    public MyRealm2 myRealm2(){
        return new MyRealm2();
    }
}
