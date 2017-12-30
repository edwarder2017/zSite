package com.zj.zsite.common.realm;

import java.io.Serializable;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zj.zsite.modules.sys.entity.User;
import com.zj.zsite.modules.sys.service.UserService;

/**   
*    
* 项目名称：filmSystem   
* 类名称：CustomRealm   
* 类描述：   
* 创建人：edwarder   
* 创建时间：2017年11月1日 上午11:58:55   
*       
*/
@Service
public class CustomRealm extends AuthorizingRealm{
	private static final Logger logger = LoggerFactory.getLogger(CustomRealm.class);
	
	@Autowired
	private UserService userSerice;
	
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
		logger.info("======用户授权认证======");
        String userName = principalCollection.getPrimaryPrincipal().toString();
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        simpleAuthorizationInfo.setRoles(userSerice.queryRolesByName(userName));
        return simpleAuthorizationInfo;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
		logger.info("======用户登陆认证======");
        String userName = authenticationToken.getPrincipal().toString();
        User user = userSerice.queryUserByName(userName);
        if (user!=null) {
            AuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(user.getUsername(), user.getPassword(), "jack");
            return authenticationInfo;
        }
		return null;
	}
	
	/**
	 * 用户授权信息
	 */
	public static class Principal implements Serializable{

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		
		private Integer id;
		private String  loginName;
		
		
		public Principal(User user) {
			this.id = user.getId();
			this.loginName = user.getUsername();
		}
		public Integer getId() {
			return id;
		}
		public void setId(Integer id) {
			this.id = id;
		}
		public String getLoginName() {
			return loginName;
		}
		public void setLoginName(String loginName) {
			this.loginName = loginName;
		}
		
	}
	
}
