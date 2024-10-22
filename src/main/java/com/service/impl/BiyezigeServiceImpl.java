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


import com.dao.BiyezigeDao;
import com.entity.BiyezigeEntity;
import com.service.BiyezigeService;
import com.entity.vo.BiyezigeVO;
import com.entity.view.BiyezigeView;

@Service("biyezigeService")
public class BiyezigeServiceImpl extends ServiceImpl<BiyezigeDao, BiyezigeEntity> implements BiyezigeService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<BiyezigeEntity> page = this.selectPage(
                new Query<BiyezigeEntity>(params).getPage(),
                new EntityWrapper<BiyezigeEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<BiyezigeEntity> wrapper) {
		  Page<BiyezigeView> page =new Query<BiyezigeView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<BiyezigeVO> selectListVO(Wrapper<BiyezigeEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public BiyezigeVO selectVO(Wrapper<BiyezigeEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<BiyezigeView> selectListView(Wrapper<BiyezigeEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public BiyezigeView selectView(Wrapper<BiyezigeEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

    @Override
    public List<Map<String, Object>> selectValue(Map<String, Object> params, Wrapper<BiyezigeEntity> wrapper) {
        return baseMapper.selectValue(params, wrapper);
    }

    @Override
    public List<Map<String, Object>> selectTimeStatValue(Map<String, Object> params, Wrapper<BiyezigeEntity> wrapper) {
        return baseMapper.selectTimeStatValue(params, wrapper);
    }

    @Override
    public List<Map<String, Object>> selectGroup(Map<String, Object> params, Wrapper<BiyezigeEntity> wrapper) {
        return baseMapper.selectGroup(params, wrapper);
    }




}
