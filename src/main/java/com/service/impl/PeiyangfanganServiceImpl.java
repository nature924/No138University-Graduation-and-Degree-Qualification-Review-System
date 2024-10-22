package com.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.utils.PageUtils;
import com.utils.Query;


import com.dao.PeiyangfanganDao;
import com.entity.PeiyangfanganEntity;
import com.service.PeiyangfanganService;
import com.entity.vo.PeiyangfanganVO;
import com.entity.view.PeiyangfanganView;

@Service("peiyangfanganService")
public class PeiyangfanganServiceImpl extends ServiceImpl<PeiyangfanganDao, PeiyangfanganEntity> implements PeiyangfanganService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<PeiyangfanganEntity> page = this.selectPage(
                new Query<PeiyangfanganEntity>(params).getPage(),
                new EntityWrapper<PeiyangfanganEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<PeiyangfanganEntity> wrapper) {
		  Page<PeiyangfanganView> page =new Query<PeiyangfanganView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<PeiyangfanganVO> selectListVO(Wrapper<PeiyangfanganEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public PeiyangfanganVO selectVO(Wrapper<PeiyangfanganEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<PeiyangfanganView> selectListView(Wrapper<PeiyangfanganEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public PeiyangfanganView selectView(Wrapper<PeiyangfanganEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
