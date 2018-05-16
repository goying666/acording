package com.renchaigao.dao;

import com.renchaigao.domain.user.User;
import com.renchaigao.domain.user.UserLogin;
import org.apache.ibatis.annotations.Param;

public interface UserDao {
    public Integer addUserinfo(User user);

    public Integer addUserLogin(UserLogin userlogin);

    public Integer updateUser(User user);

    public Integer updateUserAddressByID(@Param("id") Integer id, @Param("address") String address);

    public User findUserByID(Integer id);
    public User findUserByNikename(String nikename);

}
