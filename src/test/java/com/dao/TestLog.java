package com.dao;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.zj.zsite.common.persistence.BaseDao;
import com.zj.zsite.modules.sys.entity.Log;
import com.zj.zsite.modules.sys.entity.User;

/**   
*    
* 项目名称：filmSystem   
* 类名称：TestLog   
* 类描述：   
* 创建人：edwarder   
* 创建时间：2017年11月3日 上午9:48:39   
*       
*/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"/spring-mvc.xml","/spring-context.xml"})
public class TestLog {
	
	@Autowired(required=true)
	private BaseDao<Log> logDao;
	
	@Test
	public void saveLog(){
		Log log = new Log();
		User user = new User(1, "jack", "123");
		//log.setId(1);
		log.setHost("127.0.0.1");
		log.setIp("127.0.0.1");
		log.setCreateBy(user);
		log.setUpdateBy(user);
		log.setCreateDate(new Date());
		log.setUpdateDate(new Date());
		logDao.save(log);
	}
}
