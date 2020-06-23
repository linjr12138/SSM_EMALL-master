package com.hunter.ssm_emall.dao;

import com.hunter.ssm_emall.bean.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;


public interface UserMapper {

    User getUser(@Param("username") String username, @Param("password") String password);

    @Insert("INSERT INTO person(userName ,password ,nickName ,userType) " +
            "VALUE (#{userName}, #{password}, #{nickName},0)")
    int Save(@Param("userName") String username, @Param("password") String password,@Param("nickName") String nickName);
}
