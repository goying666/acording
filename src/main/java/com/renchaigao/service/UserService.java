package com.renchaigao.service;


import com.renchaigao.domain.user.User;
import com.renchaigao.domain.request.ReqUser;
import com.renchaigao.domain.response.ResponseEntity;


public interface UserService {

//    用户登录
    public String addUser(User user);

    public ResponseEntity userLogin(ReqUser requser);

    public ResponseEntity userAddressAdd(ReqUser requser);

    public ResponseEntity userAddressUpdate(ReqUser requser);

    public String searchUserByNickname(String nickName);

    public String searchUserById(Integer userId);



}
