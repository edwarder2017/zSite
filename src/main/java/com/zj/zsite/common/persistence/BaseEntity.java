package com.zj.zsite.common.persistence;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.SequenceGenerator;
import javax.persistence.Transient;

import com.zj.zsite.modules.sys.entity.User;
import com.zj.zsite.modules.sys.utils.UserUtils;

/**   
*    
* 项目名称：filmSystem   
* 类名称：BaseEntity   
* 类描述：   
* 创建人：edwarder   
* 创建时间：2017年11月2日 上午11:50:10   
*       
*/
@Entity
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
public abstract class BaseEntity<T> implements Serializable{

	private static final long serialVersionUID = 1L;
	
	/**
	 * 实体编号（唯一标识）
	 */
	private Integer id;
	
	/**
	 * 当前用户
	 */
	private User currentUser;
	
	public BaseEntity() {
		
	}
	
	public BaseEntity(Integer id) {
		this();
		this.id = id;
	}

	@Id
	@GeneratedValue(generator = "idStrategy")
	@SequenceGenerator(name = "idStrategy", sequenceName = "HIBERNATE_SEQUENCE") 
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	//该字段不需要在表中创建
	@Transient
	public User getCurrentUser() {
		if(currentUser == null){
			currentUser = UserUtils.getUser();
		}
		return currentUser;
	}

	public void setCurrentUser(User currentUser) {
		this.currentUser = currentUser;
	}
	
	/**
	 * 插入之前执行方法，子类实现
	 */
	public abstract void preInsert();
	
	/**
	 * 更新之前执行方法，子类实现
	 */
	public abstract void preUpdate();
	

	/**
	 * 删除标记（0：正常；1：删除；2：审核；）
	 */
	public static final String DEL_FLAG_NORMAL = "0";
	public static final String DEL_FLAG_DELETE = "1";
	public static final String DEL_FLAG_AUDIT = "2";
}
