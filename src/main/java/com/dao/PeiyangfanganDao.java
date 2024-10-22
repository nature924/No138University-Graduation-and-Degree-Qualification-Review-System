package com.dao;

import com.entity.PeiyangfanganEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.PeiyangfanganVO;
import com.entity.view.PeiyangfanganView;


/**
 * 培养方案
 * 
 * @author 
 * @email 
 * @date 2023-04-03 16:15:19
 */
public interface PeiyangfanganDao extends BaseMapper<PeiyangfanganEntity> {
	
	List<PeiyangfanganVO> selectListVO(@Param("ew") Wrapper<PeiyangfanganEntity> wrapper);
	
	PeiyangfanganVO selectVO(@Param("ew") Wrapper<PeiyangfanganEntity> wrapper);
	
	List<PeiyangfanganView> selectListView(@Param("ew") Wrapper<PeiyangfanganEntity> wrapper);

	List<PeiyangfanganView> selectListView(Pagination page,@Param("ew") Wrapper<PeiyangfanganEntity> wrapper);
	
	PeiyangfanganView selectView(@Param("ew") Wrapper<PeiyangfanganEntity> wrapper);
	

}
