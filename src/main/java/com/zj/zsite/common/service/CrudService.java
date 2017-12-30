package com.zj.zsite.common.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;

import com.zj.zsite.common.persistence.CrudDao;
import com.zj.zsite.common.persistence.DataEntity;

/**   
*    
* 项目名称：filmSystem   
* 类名称：CrudService   
* 类描述：   
* 创建人：edwarder   
* 创建时间：2017年11月3日 上午11:57:47   
*       
*/
@Transactional
public abstract class CrudService<D extends CrudDao<T>, T extends DataEntity<T>> extends BaseService{
	/**
	 * 持久层对象
	 */
	@Autowired
	protected D dao;
	
	/**
	 * 获取单条记录
	 */
	public T get(Integer id){
		return dao.get(id);
	}
	
	/**
	 * 保存实体
	 */
	public int save(T entity){
		return dao.save(entity);
		
	}
	
	/**
	 * 更新实体
	 */
	public void update(T entity){
		dao.update(entity);
	}
	
	/**
	 * 删除数据（一般为逻辑删除，更新del_flag字段为1）
	 * @param entity
	 * @return
	 */
	public void delete(T entity){
		dao.delete(entity);
	}
	
}
