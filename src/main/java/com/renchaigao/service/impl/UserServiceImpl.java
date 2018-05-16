package com.renchaigao.service.impl;

import com.renchaigao.dao.UserDao;
import com.renchaigao.domain.user.User;
import com.renchaigao.domain.request.ReqUser;
import com.renchaigao.domain.response.RespCode;
import com.renchaigao.domain.response.ResponseEntity;
import com.renchaigao.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
//@Transactional
public class UserServiceImpl implements UserService {

    private static Logger logger = Logger.getLogger(UserServiceImpl.class);

    @Autowired
    private UserDao userdao;

    @Override
    //    用户登录
    public String addUser(User user) {
        String ret = "";
        return ret;
    }

    public ResponseEntity userLogin(ReqUser requser) {
        User userUse = null;
        ResponseEntity userLoginRet = new ResponseEntity(RespCode.WARN, null);
        try {
            userUse = userdao.findUserByNikename(requser.getNickName());
//            判断用户是否是新用户，并添加
            if (userUse != null) {
                userLoginRet = new ResponseEntity(RespCode.SUCCESS, userUse);
                logger.info("SUCCESS: user nickname:" + requser.getNickName() + "is find in system!");
            } else {
                if (userdao.addUserinfo(requser) != null) {
                    logger.info("SUCCESS: add user : " + requser.getNickName() + " in system");
                    userLoginRet = new ResponseEntity(RespCode.SUCCESS, userUse);
                } else {
                    logger.info("fail ：add user : " + requser.getNickName() + " in system fail！");
                }
            }
//            添加用户登陆信息
            userdao.addUserLogin(requser);
        } catch (Exception e) {
            logger.info("Exception e : " + e);
        }
        return userLoginRet;
    }


    public ResponseEntity userAddressAdd(ReqUser requser){
        User userUse = null;
        ResponseEntity userLoginRet = new ResponseEntity(RespCode.WARN, null);
        try {
            logger.info("run here : 1 ");
            userUse = userdao.findUserByNikename(requser.getNickName());
            if (userUse != null) {
                userLoginRet = new ResponseEntity(RespCode.SUCCESS, userUse);
                logger.info("SUCCESS: user nickname:" + requser.getNickName() + "is find in system!");

                if (userUse.getAddress() == null) {
                    logger.info("user.address is empty and updateUserAddressByID : " +
                            userdao.updateUserAddressByID(userUse.getId(),requser.getAddress()));
                    userLoginRet = new ResponseEntity(RespCode.SUCCESS,
                            userdao.findUserByNikename(requser.getNickName()));
                } else {
                    userLoginRet = new ResponseEntity(RespCode.SUCCESS,userUse);
                    logger.info("user address is on ：" + userUse.getAddress());
                }
            } else {
               logger.info("user "+ requser.getNickName() +" is not in system!");
            }
        } catch (Exception e) {
            logger.info("Exception e : " + e);
            userLoginRet.setData(e);
        }
        return userLoginRet;
    };


    public ResponseEntity userAddressUpdate(ReqUser requser){
        User userUse = null;
        ResponseEntity userLoginRet = new ResponseEntity(RespCode.WARN, null);
        try {
            userUse = userdao.findUserByNikename(requser.getNickName());
            if (userUse != null) {
                userdao.updateUserAddressByID(userUse.getId(),requser.getAddress());
                userUse.setAddress(requser.getAddress());
                userLoginRet = new ResponseEntity(RespCode.SUCCESS, userUse);
                logger.info("userAddressUpdate finish : user nickname:"
                        + requser.getNickName() + " !");
            } else {
                logger.info("user "+ requser.getNickName() +" is not in system!");
            }
        } catch (Exception e) {
            logger.info("Exception e : " + e);
            userLoginRet.setData(e);
        }
        return userLoginRet;
    };

    public ResponseEntity userLoginTest(ReqUser requser) {
        User userUse = null;
        Integer i = null ,j = null;

        i = userdao.addUserinfo(requser);
        j = userdao.addUserLogin(requser);
        logger.info("info i is : " + i);
        logger.info("info j is : " + j);
        ResponseEntity userLoginRet = new ResponseEntity(RespCode.WARN, null);
        try {
            userUse = userdao.findUserByNikename(requser.getNickName());
            if (userUse != null) {
                userLoginRet = new ResponseEntity(RespCode.SUCCESS, userUse);
                logger.info("SUCCESS: user nickname:" + requser.getNickName() + "is find in system!");
            } else {
//                i = userdao.addUserinfo(requser);
//                j = userdao.addUserLogin(requser);
//                logger.info("i is : " + i);
//                logger.info("j is : " + j);
                if (i != null &&  j != null) {
                    logger.info("SUCCESS: add user : " + requser.getNickName() + " in system");
                    userLoginRet = new ResponseEntity(RespCode.SUCCESS, requser);
                } else {
                    logger.info("fail ：add user : " + requser.getNickName() + " in system fail！");
                }
            }
        } catch (Exception e) {
            logger.info("Exception e : " + e);
        }
        return userLoginRet;
    }

    public String searchUserByNickname(String nickName) {
        String ret = "";
        try {
            ret = userdao.findUserByNikename(nickName).getId().toString();
        } catch (Exception e) {
            logger.info(e);
        }
        logger.info("searchUserByNickname ret is : " + ret);
        return ret;
    }

    ;

    public String searchUserById(Integer userId) {
        String ret = "";

        return ret;
    }

    ;
}
