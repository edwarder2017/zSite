package com.zj.zsite.modules.sys.dao;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.zj.zsite.common.persistence.CrudDao;
import com.zj.zsite.modules.sys.entity.Log;

/**   
*    
* 项目名称：filmSystem   
* 类名称：LogDao   
* 类描述：   日志接口
* 创建人：edwarder   
* 创建时间：2017年11月2日 下午4:57:51   
*       
*/
@Repository
@Transactional
public class LogDao extends CrudDao<Log>{
	
}
