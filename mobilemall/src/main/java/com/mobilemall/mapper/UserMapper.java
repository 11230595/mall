package com.mobilemall.mapper;

import org.apache.ibatis.annotations.Param;

import com.mobilemall.entity.User;

public interface UserMapper {
    int deleteByPrimaryKey(String userId);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(String userId);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

	User findUserByUserCode(String userCode);

	User findUserByEmail(String email);

	User login(@Param("userCode") String userCode, @Param("password") String password);
}