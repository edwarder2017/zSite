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
* 类名称：Dict   
* 类描述：   
* 创建人：edwarder   
* 创建时间：2017年11月2日 下午1:48:13   
*       
*/
@Entity
@Table(name="sys_dict")
public class Dict extends DataEntity<Dict>{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String label;
	private String descrition;
	
	
	public Dict() {
		super();
	}

	public Dict(Integer id) {
		super(id);
	}
	
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator="dictStrategy")
	@SequenceGenerator(name="dictStrategy", sequenceName="dict_seq")
	@Column(insertable=false,updatable=false)
	public Integer getId(){
		return super.getId();
	}
	
	@Column
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	@Column
	public String getDescrition() {
		return descrition;
	}
	public void setDescrition(String descrition) {
		this.descrition = descrition;
	}
	
	
}
