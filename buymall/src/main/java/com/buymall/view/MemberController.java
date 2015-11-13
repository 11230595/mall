package com.buymall.view;

import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
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
	 * 后台首页
	 * @return
	 */
	@RequestMapping(value="index",method={RequestMethod.GET,RequestMethod.POST})
	public ModelAndView index(HttpServletRequest request) {
		
		return new ModelAndView("member/index");
	}
	
	/**
	 * 开通商户
	 * @return
	 */
	@RequestMapping(value="create",method={RequestMethod.GET,RequestMethod.POST})
	public String createMember(HttpServletRequest request,@RequestParam String userId) {
		memberService.insert(new Member(UUID.randomUUID().toString(),userId));
		return "redirect:member/index";
	}
}
