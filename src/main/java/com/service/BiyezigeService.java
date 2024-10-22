package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.BiyezigeEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.BiyezigeVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.BiyezigeView;


/**
 * 毕业资格
 *
 * @author 
 * @email 
 * @date 2023-04-03 16:15:19
 */
public interface BiyezigeService extends IService<BiyezigeEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<BiyezigeVO> selectListVO(Wrapper<BiyezigeEntity> wrapper);
   	
   	BiyezigeVO selectVO(@Param("ew") Wrapper<BiyezigeEntity> wrapper);
   	
   	List<BiyezigeView> selectListView(Wrapper<BiyezigeEntity> wrapper);
   	
   	BiyezigeView selectView(@Param("ew") Wrapper<BiyezigeEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<BiyezigeEntity> wrapper);
   	

    List<Map<String, Object>> selectValue(Map<String, Object> params,Wrapper<BiyezigeEntity> wrapper);

    List<Map<String, Object>> selectTimeStatValue(Map<String, Object> params,Wrapper<BiyezigeEntity> wrapper);

    List<Map<String, Object>> selectGroup(Map<String, Object> params,Wrapper<BiyezigeEntity> wrapper);



}

