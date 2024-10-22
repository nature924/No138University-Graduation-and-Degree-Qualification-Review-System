package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.XueshengchengjiEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.XueshengchengjiVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.XueshengchengjiView;


/**
 * 学生成绩
 *
 * @author 
 * @email 
 * @date 2023-04-03 16:15:19
 */
public interface XueshengchengjiService extends IService<XueshengchengjiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<XueshengchengjiVO> selectListVO(Wrapper<XueshengchengjiEntity> wrapper);
   	
   	XueshengchengjiVO selectVO(@Param("ew") Wrapper<XueshengchengjiEntity> wrapper);
   	
   	List<XueshengchengjiView> selectListView(Wrapper<XueshengchengjiEntity> wrapper);
   	
   	XueshengchengjiView selectView(@Param("ew") Wrapper<XueshengchengjiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<XueshengchengjiEntity> wrapper);
   	

    List<Map<String, Object>> selectValue(Map<String, Object> params,Wrapper<XueshengchengjiEntity> wrapper);

    List<Map<String, Object>> selectTimeStatValue(Map<String, Object> params,Wrapper<XueshengchengjiEntity> wrapper);

    List<Map<String, Object>> selectGroup(Map<String, Object> params,Wrapper<XueshengchengjiEntity> wrapper);



}

