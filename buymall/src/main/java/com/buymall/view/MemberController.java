package com.buymall.view;

import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.buymall.constants.Constants;
import com.buymall.entity.LoginLog;
import com.buymall.entity.Member;
import com.buymall.entity.User;
import com.buymall.service.LoginLogService;
import com.buymall.service.MemberService;
import com.buymall.service.UserService;
/**
 * 后台管理部分
 * @author zhoudong
 *
 */
@Controller
@RequestMapping("member")
public class MemberController {
	private static Logger logger = Logger.getLogger(MemberController.class);
	@Resource
	private MemberService memberService;
	/**
	 * 商户首页
	 * @return
	 */
	@RequestMapping(value="index",method={RequestMethod.GET,RequestMethod.POST})
	public ModelAndView index(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("member/index");
		mav.addObject("url", Constants.config.getString("BASE_URL"));
		return mav;
	}
	
	/**
	 * 商户中间页
	 * 是否已经开通商户
	 * @return
	 */
	@RequestMapping(value="exist",method={RequestMethod.GET,RequestMethod.POST})
	public ModelAndView exist(HttpServletRequest request) {
		User user = (User) request.getSession().getAttribute("user");
		Member member = memberService.findMemberByUserId(user.getUserId(),0);
		
		if(member == null){
			//跳转到创建会员ftl
			return new ModelAndView("member/create","url",Constants.config.getString("BASE_URL"));
		}
		//跳转到首页
		redirect:return new ModelAndView("redirect:/member/index");
	}
	
	/**
	 * 开通商户
	 * @return
	 */
	@RequestMapping(value="create",method={RequestMethod.GET,RequestMethod.POST})
	public String createMember(HttpServletRequest request,@RequestParam String userId,@RequestParam String phoneNum) {
		Member member = memberService.findMemberByUserId(userId,1);
		if(member == null)
			memberService.insert(new Member(UUID.randomUUID().toString(),userId,0,0,phoneNum));
		else {
			memberService.updateMemberStatus(new Member(userId,0,phoneNum));
		}
		return "redirect:/member/index";
	}
	
	/**
	 * 关闭商户
	 * @return
	 */
	@RequestMapping(value="close/{userId}",method={RequestMethod.GET,RequestMethod.POST})
	public String closeMember(HttpServletRequest request,@PathVariable String userId) {
		memberService.updateMemberStatus(new Member(userId,1));
		return "redirect:" + Constants.config.getString("BASE_URL");
	}
}
