package org.userAuthDemo.realm;

import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import java.util.HashSet;
import java.util.Set;

public class MyRealm2 extends AuthorizingRealm {

    /**
     *      获取身份信息，我们可以在这个方法中，从数据库获取该用户的权限和角色信息
     *      当调用权限验证时，就会调用此方法
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        String code = (String) getAvailablePrincipal(principalCollection);

        //通过用户名从数据库获取角色权限集
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        Set<String> roles = new HashSet<>();
        roles.add("superadmin");
        roles.add("admin");
        roles.add("guest");

        info.setRoles(roles);
        return info;
    }

    /**
     * 在这个方法中，进行身份验证
     * login时调用
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        // 用户名
        String username = (String) authenticationToken.getPrincipal();
        //密码
        String password = new String((char[])authenticationToken.getCredentials());

        if(!"zhang".equals(username)) {
            throw new UnknownAccountException(); //如果用户名错误
        }
        if(!"123456".equals(password)) {
            throw new IncorrectCredentialsException(); //如果密码错误
        }
        //身份验证通过,返回一个身份信息
        AuthenticationInfo aInfo = new SimpleAuthenticationInfo(username, password, getName());

        return aInfo;
    }
}
