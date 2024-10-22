package com.dao;

import com.entity.BiyezigeEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.BiyezigeVO;
import com.entity.view.BiyezigeView;


/**
 * 毕业资格
 * 
 * @author 
 * @email 
 * @date 2023-04-03 16:15:19
 */
public interface BiyezigeDao extends BaseMapper<BiyezigeEntity> {
	
	List<BiyezigeVO> selectListVO(@Param("ew") Wrapper<BiyezigeEntity> wrapper);
	
	BiyezigeVO selectVO(@Param("ew") Wrapper<BiyezigeEntity> wrapper);
	
	List<BiyezigeView> selectListView(@Param("ew") Wrapper<BiyezigeEntity> wrapper);

	List<BiyezigeView> selectListView(Pagination page,@Param("ew") Wrapper<BiyezigeEntity> wrapper);
	
	BiyezigeView selectView(@Param("ew") Wrapper<BiyezigeEntity> wrapper);
	

    List<Map<String, Object>> selectValue(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<BiyezigeEntity> wrapper);

    List<Map<String, Object>> selectTimeStatValue(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<BiyezigeEntity> wrapper);

    List<Map<String, Object>> selectGroup(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<BiyezigeEntity> wrapper);



}
