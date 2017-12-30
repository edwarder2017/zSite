package com.zj.zsite.common.persistence;
/**   
*    
* 项目名称：filmSystem   
* 类名称：BaseDao   
* 类描述：   基类dao
* 创建人：edwarder   
* 创建时间：2017年11月3日 上午10:18:49   
*       
*/
public interface BaseDao<T> {
	/**
	 * 获取单条记录
	 */
	public T get(Integer id);
	
	/**
	 * 保存实体
	 */
	public int save(T entity);
	
	/**
	 * 更新实体
	 */
	public void update(T entity);
	
	/**
	 * 删除数据（一般为逻辑删除，更新del_flag字段为1）
	 * @param entity
	 * @return
	 */
	public void delete(T entity);
}
