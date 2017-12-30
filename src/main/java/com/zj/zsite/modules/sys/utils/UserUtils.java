package com.zj.zsite.modules.sys.utils;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.UnavailableSecurityManagerException;
import org.apache.shiro.session.InvalidSessionException;
import org.apache.shiro.subject.Subject;

import com.zj.zsite.common.realm.CustomRealm.Principal;
import com.zj.zsite.common.util.SpringContextHolder;
import com.zj.zsite.modules.sys.dao.UserDao;
import com.zj.zsite.modules.sys.entity.User;

/**   
*    
* 项目名称：filmSystem   
* 类名称：UserUtils   
* 类描述：   用户工具类
* 创建人：edwarder   
* 创建时间：2017年11月2日 上午11:20:08   
*       
*/
public class UserUtils {
	private static UserDao userDao = SpringContextHolder.getBean(UserDao.class);
	
	/**
	 * 工具id获取用户
	 */
	public static User get(Integer id){
		return userDao.selectUserByPrimaryKey(id);
	}
	
	/**
	 * 获取当前用户
	 * @return 取不到返回 new User()
	 */
	public static User getUser(){
		Principal principal = getPrincipal();
		if (principal!=null){
			User user = get(principal.getId());
			if (user != null){
				return user;
			}
			return new User();
		}
		// 如果没有登录，则返回实例化空的User对象。
		return new User();
	}
	
	/**
	 * 获取当前登录者对象
	 */
	public static Principal getPrincipal(){
		try{
			Subject subject = SecurityUtils.getSubject();
			Principal principal = (Principal)subject.getPrincipal();
			if (principal != null){
				return principal;
			}
		}catch (UnavailableSecurityManagerException e) {
			
		}catch (InvalidSessionException e){
			
		}
		return null;
	}
}
