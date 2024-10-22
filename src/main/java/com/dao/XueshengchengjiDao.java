package com.dao;

import com.entity.XueshengchengjiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.XueshengchengjiVO;
import com.entity.view.XueshengchengjiView;


/**
 * 学生成绩
 * 
 * @author 
 * @email 
 * @date 2023-04-03 16:15:19
 */
public interface XueshengchengjiDao extends BaseMapper<XueshengchengjiEntity> {
	
	List<XueshengchengjiVO> selectListVO(@Param("ew") Wrapper<XueshengchengjiEntity> wrapper);
	
	XueshengchengjiVO selectVO(@Param("ew") Wrapper<XueshengchengjiEntity> wrapper);
	
	List<XueshengchengjiView> selectListView(@Param("ew") Wrapper<XueshengchengjiEntity> wrapper);

	List<XueshengchengjiView> selectListView(Pagination page,@Param("ew") Wrapper<XueshengchengjiEntity> wrapper);
	
	XueshengchengjiView selectView(@Param("ew") Wrapper<XueshengchengjiEntity> wrapper);
	

    List<Map<String, Object>> selectValue(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<XueshengchengjiEntity> wrapper);

    List<Map<String, Object>> selectTimeStatValue(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<XueshengchengjiEntity> wrapper);

    List<Map<String, Object>> selectGroup(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<XueshengchengjiEntity> wrapper);



}
