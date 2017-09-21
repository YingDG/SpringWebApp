package yingdg.exercise.springwebapp.config.shiro;

import com.google.common.collect.Sets;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import yingdg.exercise.springwebapp.model.User;
import yingdg.exercise.springwebapp.repository.UserMapper;

import javax.annotation.Resource;
import java.beans.Beans;
import java.util.Objects;

/**
 * Created by yingdg on 2017/9/21 0021.
 */
public class UserRealm extends AuthorizingRealm {
    /*
    如果只进行认证，则继承AuthenticatingRealm
     */

    // 临时用userMapper代替登录
    @Resource
    private UserMapper userMapper;

    /*
     授权(验证权限时调用)
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        // 获取授权体
        User user = (User) principals.getPrimaryPrincipal();
        if (Objects.isNull(user)) {
            return null;
        }

        // 添加授权信息
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        info.setRoles(Sets.newHashSet("admin"));
        info.setStringPermissions(Sets.newHashSet("visit", "create", "delete", "update"));

        return info;
    }

    /*
    认证(登录时调用)
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String username = (String) token.getPrincipal();
        String password = new String((char[]) token.getCredentials());

        // 查找user
        User user = userMapper.findUserByUsername(username);

        // 账号不存在
        if (Objects.isNull(user)) {
            throw new UnknownAccountException("账号或密码不正确");
        }

        // 密码错误
        if (!password.equals(user.getAge().toString())) {
            throw new IncorrectCredentialsException("账号或密码不正确");
        }

        // 账号锁定
//        if (user.getStatus() == 0) {
//            throw new LockedAccountException("账号已被锁定,请联系管理员");
//        }

        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(user, password, getName());
        // 加盐验证
        // info.setCredentialsSalt(ByteSource.Util.bytes("salt"));

        return info;
    }

    /*
    Realm名字
     */
    @Override
    public String getName() {
        return "用户验证";
    }

    /*
    支持类型
     */
    @Override
    public boolean supports(AuthenticationToken authenticationToken) {
        return Beans.isInstanceOf(authenticationToken, UsernamePasswordToken.class);
    }

}
