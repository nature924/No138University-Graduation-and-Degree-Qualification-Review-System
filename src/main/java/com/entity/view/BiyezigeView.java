package com.entity.view;

import com.entity.BiyezigeEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 毕业资格
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2023-04-03 16:15:19
 */
@TableName("biyezige")
public class BiyezigeView  extends BiyezigeEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public BiyezigeView(){
	}
 
 	public BiyezigeView(BiyezigeEntity biyezigeEntity){
 	try {
			BeanUtils.copyProperties(this, biyezigeEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
