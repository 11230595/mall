package com.buymall.view;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.buymall.constants.Constants;
import com.buymall.entity.FrameUrl;
import com.buymall.entity.LoginLog;
import com.buymall.entity.Member;
import com.buymall.entity.Product;
import com.buymall.entity.User;
import com.buymall.service.LoginLogService;
import com.buymall.service.MemProductService;
import com.buymall.service.MemberService;
import com.buymall.service.ProductService;
import com.buymall.service.UserService;
import com.buymall.utils.GetProduct;
import com.buymall.vo.ProductVO;
import com.framework.core.page.Page;
import com.framework.core.utils.DateUtils;
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
	@Resource
	private MemProductService memProductService;
	@Resource
	private ProductService productService;
	/**
	 * 商户首页
	 * @return
	 */
	@RequestMapping(value="index",method={RequestMethod.GET,RequestMethod.POST})
	public ModelAndView index(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("member/index");
		Member member = (Member) request.getSession().getAttribute("member");
		Page<Product> page = findProductByMemberId(member.getId());
		
		mav.addObject("url", Constants.config.getString("BASE_URL"));
		mav.addObject("page", page);
		return mav;
	}
	/**
	 * 根据商户ID查询商户推广的产品
	 * @param id
	 * @return
	 */
	private Page<Product> findProductByMemberId(String memberId) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("memberId", memberId);
		param.put("expireTime", DateUtils.DateToString(new Date(), "yyyy-MM-dd HH:mm:ss"));
		Page<Product> page = productService.findProductByMemberId(param,1,10);
		return page;
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
		request.getSession().setAttribute("member", member);
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
	
	/**
	 * 商户删除推广的产品
	 * @return
	 */
	@RequestMapping(value="/delete",method={RequestMethod.GET,RequestMethod.POST})
	public @ResponseBody Map<String, Object> isCode(@RequestParam String productId) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			memProductService.deleteByProductId(productId);
			productService.deleteByPrimaryKey(productId);
			map.put("respCode", 0);
		} catch (Exception e) {
			map.put("respCode", 1);
		}
		return map;
	}
	
	/**
	 * 跳转到新加推广产品页面
	 * @return
	 */
	@RequestMapping(value="add",method={RequestMethod.GET,RequestMethod.POST})
	public ModelAndView saveProduct(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("member/save_product");
		mav.addObject("url", Constants.config.getString("BASE_URL"));
		
		return mav;
	}
	
	/**
	 * 保存产品，商家推广
	 * @return
	 */
	@RequestMapping(value="add_member_product",method={RequestMethod.GET,RequestMethod.POST})
	public @ResponseBody Map<String, Object> saveMemberProduct(HttpServletRequest request,
			@RequestParam String url, @RequestParam String type,
			@RequestParam Integer userType) {
		Member member = (Member) request.getSession().getAttribute("member");
		//TODO 商户关关联表未保存，下一步写这里
		
		Map<String, Object> map = GetProduct.autoSaveProduct(url,userType);
		ProductVO productVO = new ProductVO();
		try {
			BeanUtils.populate(productVO, map);
		} catch (Exception e) {
			e.printStackTrace();
		}
		productVO.setId(UUID.randomUUID().toString());
		productVO.setType(Integer.parseInt(type));
		productVO.setStatus(0);
		productVO.setExpireTime(DateUtils.addDay(new Date(), 3));
		productVO.setStartTime(new Date());
		productVO.setScore(String.valueOf(map.get("scoreCount")));
		
		return new ProductController().addTkProduct(productVO);
	}
}
