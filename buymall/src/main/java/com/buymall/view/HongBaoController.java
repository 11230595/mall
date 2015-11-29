package com.buymall.view;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.buymall.entity.HongBao;
import com.buymall.service.HongBaoService;
import com.framework.core.utils.IDUtils;
/**
 * 红包
 * @author zhoudong
 *
 */
@Controller
@RequestMapping("hb")
public class HongBaoController {
	private static Logger logger = Logger.getLogger(HongBaoController.class);
	@Resource
	private HongBaoService hongBaoService;
	
	/**
	 * 添加
	 * @return
	 */
	@RequestMapping(value="add",method={RequestMethod.GET,RequestMethod.POST})
	public @ResponseBody Map<String, Object> add(@RequestParam String key, @RequestParam String value,
			@RequestParam(required=false) String desc) {
		Map<String, Object> map = new HashMap<String, Object>();
		HongBao hongBao = new HongBao();
		hongBao.setId(IDUtils.getId());
		hongBao.settKey(key);
		hongBao.settValue(value);
		hongBao.settDesc(desc);
		hongBao.setCreateTime(new Date());
		try {
			hongBaoService.insert(hongBao);
			map.put("respCode", 0);
			map.put("respMsg", "添加成功");
		} catch (Exception e) {
			e.printStackTrace();
			map.put("respCode", 1);
			map.put("respMsg", "添加失败");
		}
		return map;
	}
}
