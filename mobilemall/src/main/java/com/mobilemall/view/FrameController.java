package com.mobilemall.view;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.mobilemall.constants.Constants;
import com.mobilemall.entity.FrameUrl;
import com.mobilemall.service.FrameUrlService;
/**
 * 首页部分功能
 * @author zhoudong
 *
 */
@Controller
@RequestMapping("pre")
public class FrameController {
	private static Logger logger = Logger.getLogger(FrameController.class);
	@Resource
	private FrameUrlService frameUrlService;
	/**
	 * 首页9.9特卖
	 * @return
	 */
	@RequestMapping("/index")
	public ModelAndView index(@RequestParam int type,HttpServletRequest request){
		ModelAndView mav = new ModelAndView("/prefecture/index");
		List<FrameUrl> list = frameUrlService.selectAllUrl(type);
		String userAgent = request.getHeader("user-agent");  //请求从哪来的
		
		if(userAgent.contains("Android") || userAgent.contains("iPhone")){
			mav.addObject("codeStyle","display:none;");
		}
		
		mav.addObject("frameUrls",getHeight(list,userAgent) );
		mav.addObject("url",Constants.config.getString("BASE_URL"));
		return mav;
	}
	
	/**
	 * 解析HTML检测有多少个窗口计算高度，每一个为312px
	 * @param list
	 * @param userAgent 
	 * @return
	 */
	private List<FrameUrl> getHeight(List<FrameUrl> list, String userAgent){
		int size = 0;
		List<FrameUrl> frameUrls = new ArrayList<FrameUrl>();
		for(FrameUrl frameUrl : list){
			try {
				Document doc = Jsoup.connect(frameUrl.gettUrl()).get();
				size = doc.select("li").size();
				
				if(userAgent.contains("Android") || userAgent.contains("iPhone")){
					frameUrl.setHeight((size % 2 == 0 ? size/2 : size / 2 + 1)*232+120); //手机端每行显示两个
				}else {
					/*if(doc.select(".item-list-col5").size() == 1){
						frameUrl.setHeight((size % 5 == 0 ? size/5 : size / 5 + 1)*292); //PC每行显示5个
					}else if(doc.select(".item-list-col4").size() == 1){
						frameUrl.setHeight((size % 4 == 0 ? size/4 : size / 4 + 1)*354); //PC每行显示4个
					}else {
						frameUrl.setHeight((size % 3 == 0 ? size/3 : size / 3 + 1)*432); //PC每行显示3个
					}*/
					
					frameUrl.setHeight((size % 3 == 0 ? size/3 : size / 3 + 1)*415); //PC每行显示4个
				}
				frameUrls.add(frameUrl);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return frameUrls;
	}
	
	/**
	 * 按类型查找
	 * @return
	 */
	@RequestMapping(value = "/type")
	public @ResponseBody Map<String, Object> type(@RequestParam int type,HttpServletRequest request){
		Map<String, Object> map = new HashMap<String, Object>();
		List<FrameUrl> list = frameUrlService.selectAllUrl(type);
		String userAgent = request.getHeader("user-agent");  //请求从哪来的
		getHeight(list,userAgent);
		map.put("frameUrls", list);
		return map;
	}
}
