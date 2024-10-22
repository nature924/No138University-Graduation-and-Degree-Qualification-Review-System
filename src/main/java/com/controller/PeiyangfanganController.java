package com.controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import com.utils.ValidatorUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.annotation.IgnoreAuth;

import com.entity.PeiyangfanganEntity;
import com.entity.view.PeiyangfanganView;

import com.service.PeiyangfanganService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;
import java.io.IOException;
import java.io.InputStream;
import org.springframework.web.multipart.MultipartFile;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * 培养方案
 * 后端接口
 * @author 
 * @email 
 * @date 2023-04-03 16:15:19
 */
@RestController
@RequestMapping("/peiyangfangan")
public class PeiyangfanganController {
    @Autowired
    private PeiyangfanganService peiyangfanganService;


    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,PeiyangfanganEntity peiyangfangan,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("xuesheng")) {
			peiyangfangan.setXuehao((String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("jiaoshi")) {
			peiyangfangan.setJiaoshigonghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<PeiyangfanganEntity> ew = new EntityWrapper<PeiyangfanganEntity>();

		PageUtils page = peiyangfanganService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, peiyangfangan), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,PeiyangfanganEntity peiyangfangan, 
		HttpServletRequest request){
        EntityWrapper<PeiyangfanganEntity> ew = new EntityWrapper<PeiyangfanganEntity>();

		PageUtils page = peiyangfanganService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, peiyangfangan), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( PeiyangfanganEntity peiyangfangan){
       	EntityWrapper<PeiyangfanganEntity> ew = new EntityWrapper<PeiyangfanganEntity>();
      	ew.allEq(MPUtil.allEQMapPre( peiyangfangan, "peiyangfangan")); 
        return R.ok().put("data", peiyangfanganService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(PeiyangfanganEntity peiyangfangan){
        EntityWrapper< PeiyangfanganEntity> ew = new EntityWrapper< PeiyangfanganEntity>();
 		ew.allEq(MPUtil.allEQMapPre( peiyangfangan, "peiyangfangan")); 
		PeiyangfanganView peiyangfanganView =  peiyangfanganService.selectView(ew);
		return R.ok("查询培养方案成功").put("data", peiyangfanganView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        PeiyangfanganEntity peiyangfangan = peiyangfanganService.selectById(id);
        return R.ok().put("data", peiyangfangan);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        PeiyangfanganEntity peiyangfangan = peiyangfanganService.selectById(id);
        return R.ok().put("data", peiyangfangan);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody PeiyangfanganEntity peiyangfangan, HttpServletRequest request){
    	peiyangfangan.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(peiyangfangan);
        peiyangfanganService.insert(peiyangfangan);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody PeiyangfanganEntity peiyangfangan, HttpServletRequest request){
    	peiyangfangan.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(peiyangfangan);
        peiyangfanganService.insert(peiyangfangan);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody PeiyangfanganEntity peiyangfangan, HttpServletRequest request){
        //ValidatorUtils.validateEntity(peiyangfangan);
        peiyangfanganService.updateById(peiyangfangan);//全部更新
        return R.ok();
    }


    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        peiyangfanganService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
    /**
     * 提醒接口
     */
	@RequestMapping("/remind/{columnName}/{type}")
	public R remindCount(@PathVariable("columnName") String columnName, HttpServletRequest request, 
						 @PathVariable("type") String type,@RequestParam Map<String, Object> map) {
		map.put("column", columnName);
		map.put("type", type);
		
		if(type.equals("2")) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Calendar c = Calendar.getInstance();
			Date remindStartDate = null;
			Date remindEndDate = null;
			if(map.get("remindstart")!=null) {
				Integer remindStart = Integer.parseInt(map.get("remindstart").toString());
				c.setTime(new Date()); 
				c.add(Calendar.DAY_OF_MONTH,remindStart);
				remindStartDate = c.getTime();
				map.put("remindstart", sdf.format(remindStartDate));
			}
			if(map.get("remindend")!=null) {
				Integer remindEnd = Integer.parseInt(map.get("remindend").toString());
				c.setTime(new Date());
				c.add(Calendar.DAY_OF_MONTH,remindEnd);
				remindEndDate = c.getTime();
				map.put("remindend", sdf.format(remindEndDate));
			}
		}
		
		Wrapper<PeiyangfanganEntity> wrapper = new EntityWrapper<PeiyangfanganEntity>();
		if(map.get("remindstart")!=null) {
			wrapper.ge(columnName, map.get("remindstart"));
		}
		if(map.get("remindend")!=null) {
			wrapper.le(columnName, map.get("remindend"));
		}

		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("xuesheng")) {
			wrapper.eq("xuehao", (String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("jiaoshi")) {
			wrapper.eq("jiaoshigonghao", (String)request.getSession().getAttribute("username"));
		}

		int count = peiyangfanganService.selectCount(wrapper);
		return R.ok().put("count", count);
	}
	





    @RequestMapping("/importExcel")
    public R importExcel(@RequestParam("file") MultipartFile file){
        try {
            //获取输入流
            InputStream inputStream = file.getInputStream();
            //创建读取工作簿
            Workbook workbook = WorkbookFactory.create(inputStream);
            //获取工作表
            Sheet sheet = workbook.getSheetAt(0);
            //获取总行
            int rows=sheet.getPhysicalNumberOfRows();
            if(rows>1){
                //获取单元格
                for (int i = 1; i < rows; i++) {
                    Row row = sheet.getRow(i);
                    PeiyangfanganEntity peiyangfanganEntity =new PeiyangfanganEntity();
                    peiyangfanganEntity.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
                    String fanganbianhao = CommonUtil.getCellValue(row.getCell(0));
                    peiyangfanganEntity.setFanganbianhao(fanganbianhao);
                    String yuanxi = CommonUtil.getCellValue(row.getCell(1));
                    peiyangfanganEntity.setYuanxi(yuanxi);
                    String zhuanye = CommonUtil.getCellValue(row.getCell(2));
                    peiyangfanganEntity.setZhuanye(zhuanye);
                    String banji = CommonUtil.getCellValue(row.getCell(3));
                    peiyangfanganEntity.setBanji(banji);
                    String peiyangleixing = CommonUtil.getCellValue(row.getCell(4));
                    peiyangfanganEntity.setPeiyangleixing(peiyangleixing);
                    String xuehao = CommonUtil.getCellValue(row.getCell(5));
                    peiyangfanganEntity.setXuehao(xuehao);
                    String xingming = CommonUtil.getCellValue(row.getCell(6));
                    peiyangfanganEntity.setXingming(xingming);
                    String kechengmingcheng = CommonUtil.getCellValue(row.getCell(7));
                    peiyangfanganEntity.setKechengmingcheng(kechengmingcheng);
                    String kechengleibie = CommonUtil.getCellValue(row.getCell(8));
                    peiyangfanganEntity.setKechengleibie(kechengleibie);
                    String xuefen = CommonUtil.getCellValue(row.getCell(9));
                    peiyangfanganEntity.setXuefen(xuefen);
                    String zongxueshi = CommonUtil.getCellValue(row.getCell(10));
                    peiyangfanganEntity.setZongxueshi(zongxueshi);
                    String kaohefangshi = CommonUtil.getCellValue(row.getCell(11));
                    peiyangfanganEntity.setKaohefangshi(kaohefangshi);
                    String xueqi = CommonUtil.getCellValue(row.getCell(12));
                    peiyangfanganEntity.setXueqi(xueqi);
                    String nianfen = CommonUtil.getCellValue(row.getCell(13));
                    peiyangfanganEntity.setNianfen(nianfen);
                    String jiaoshigonghao = CommonUtil.getCellValue(row.getCell(14));
                    peiyangfanganEntity.setJiaoshigonghao(jiaoshigonghao);
                    String jiaoshixingming = CommonUtil.getCellValue(row.getCell(15));
                    peiyangfanganEntity.setJiaoshixingming(jiaoshixingming);
                     
                    //想数据库中添加新对象
                    peiyangfanganService.insert(peiyangfanganEntity);//方法
                }
            }
            inputStream.close();
        } catch (InvalidFormatException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return R.ok("导入成功");
    }




}
