package com.zj.zsite.common.persistence;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**   
*    
* 项目名称：filmSystem   
* 类名称：CrudDao   
* 类描述：   
* 创建人：edwarder   
* 创建时间：2017年11月3日 上午10:19:29   
*       
*/
public abstract class CrudDao<T> implements BaseDao<T>{
	//获取sessionfactory
	@Autowired
	protected SessionFactory sessionFactory;
	
	//获得和当前线程绑定的session
	protected Session getSession(){
		return sessionFactory.getCurrentSession();
	}
	
	private Class<T> entityClass;
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public CrudDao(){
		//初始化 entityClass, 利用反射
	    //就是获得超类的泛型参数的实际类型
		this.entityClass = null;
		Class c = getClass();
		Type t = c.getGenericSuperclass();
		if(t instanceof ParameterizedType){
			Type[] p = ((ParameterizedType)t).getActualTypeArguments();
			entityClass = (Class<T>) p[0];
		}
		
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public T get(Integer id) {
		return (T) getSession().get(entityClass, id);
	}

	@Override
	public int save(T entity) {
		return (int) getSession().save(entity);
	}

	@Override
	public void update(T entity) {
		getSession().update(entity);
	}

	//根据del_Flag标识位
	public void delete(T entity) {
		getSession().update(entity);
	}

}
