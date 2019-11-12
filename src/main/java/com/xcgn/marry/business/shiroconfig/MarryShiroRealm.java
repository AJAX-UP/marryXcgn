package com.xcgn.marry.business.shiroconfig;

import com.xcgn.marry.business.model.Permission;
import com.xcgn.marry.business.model.Role;
import com.xcgn.marry.business.model.User;
import com.xcgn.marry.business.service.UserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

import javax.annotation.Resource;

public class MarryShiroRealm extends AuthorizingRealm {
    @Resource
    private UserService userService;

    /**
     * description: 授权 
     * version: 1.0 
     * date: 2019/11/12 10:12 
     * author: ajaxgo
     * 
     * @param principals
     * @return org.apache.shiro.authz.AuthorizationInfo
     */ 
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
//        System.out.println("权限配置-->MyShiroRealm.doGetAuthorizationInfo()");
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        User User = (User) principals.getPrimaryPrincipal();
        for (Role role : User.getRoleList()) {
            authorizationInfo.addRole(role.getName());
            for (Permission p : role.getPermissions()) {
                authorizationInfo.addStringPermission(p.getPerms());
            }
        }
        return authorizationInfo;
    }

    /**
     * description: 验证身份(鉴权)
     * version: 1.0 
     * date: 2019/11/12 10:13 
     * author: ajaxgo
     * 
     * @param token
     * @return org.apache.shiro.authc.AuthenticationInfo
     */ 
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token)
            throws AuthenticationException {
        //获取用户的输入的账号.
        String username = (String) token.getPrincipal();
        User user = userService.findByUsername(username);
        if (user == null) {
            return null;
        }
        ByteSource salt = ByteSource.Util.bytes(username);
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
                user, //用户名
                user.getPassword(), //密码
                salt,
                getName()  //realm name
        );
        return authenticationInfo;
    }

    public static void main(String[] args) {
       ByteSource salt = ByteSource.Util.bytes("admin");
       String result = new Md5Hash("123456",salt,2).toString();
       System.out.println(result);
    }

}
