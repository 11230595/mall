package com.mobilemall.service;

import java.util.Map;

import com.framework.core.page.Page;
import com.mobilemall.entity.User;
/**
 * 用户
 * @author zhoudong
 *
 */
public interface UserService {
    int deleteByPrimaryKey(String userId);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(String userId);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

	User findUserByUserCode(String userCode);

	User findUserByEmail(String email);
	
	User findUserByUserId(String userId);

	User login(String userCode, String password);

	Page<User> findUserByPage(String sqlId, Map<String, Object> param, int pageNo,
			int pageSize);
}
