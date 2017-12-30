package com.zj.zsite.modules.sys.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.zj.zsite.common.persistence.DataEntity;

/**   
*    
* 项目名称：filmSystem   
* 类名称：Log   
* 类描述：   日志类
* 创建人：edwarder   
* 创建时间：2017年11月2日 下午2:01:02   
*       
*/
@Entity
@Table(name="sys_log")
public class Log extends DataEntity<Log>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String host;
	private String ip;
	
	public Log() {
		super();
	}
	public Log(Integer id) {
		super(id);
	}
	
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator="logStrategy")
	@SequenceGenerator(name="logStrategy", sequenceName="log_seq")
	@Column(insertable=false,updatable=false)
	public Integer getId(){
		return super.getId();
	}
	
	@Column
	public String getHost() {
		return host;
	}
	
	public void setHost(String host) {
		this.host = host;
	}
	
	@Column
	public String getIp() {
		return ip;
	}
	
	public void setIp(String ip) {
		this.ip = ip;
	}
	
	@Override
	public String toString() {
		return "Log [host=" + host + ", ip=" + ip + "]";
	}
	
}
