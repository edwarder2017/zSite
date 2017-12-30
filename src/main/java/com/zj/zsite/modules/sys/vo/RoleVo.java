package com.zj.zsite.modules.sys.vo;

import com.zj.zsite.modules.sys.entity.Role;

/**   
*    
* 项目名称：filmSystem   
* 类名称：RoleVo   
* 类描述：   
* 创建人：edwarder   
* 创建时间：2017年10月26日 下午3:20:46   
*       
*/


public class RoleVo {
	private Role role;
	private String menuIds;//菜单id

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public String getMenuIds() {
		return menuIds;
	}

	public void setMenuIds(String menuIds) {
		this.menuIds = menuIds;
	}

}
