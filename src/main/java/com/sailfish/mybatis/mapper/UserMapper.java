/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2021 All Rights Reserved.
 */
package com.sailfish.mybatis.mapper;

import com.sailfish.mybatis.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * @author chengyi
 * @version : UserMapper.java, v 0.1 2021年01月09日 10:31 上午 chengyi Exp $
 */
public interface UserMapper {


    @Select("SELECT id, user_id as userId, name FROM users WHERE id = #{id}")
    User getUser(@Param("id") String id);

    @Insert("insert into users (user_id, name) values (#{userId}, #{name})")
    int addUser(@Param("userId") String userId, @Param("name") String name);
}