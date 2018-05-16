package com.renchaigao.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.renchaigao.dao.TermDao;
import com.renchaigao.dao.UserDao;
import com.renchaigao.domain.user.User;
import com.renchaigao.domain.response.RespCode;
import com.renchaigao.domain.response.ResponseEntity;
import com.renchaigao.domain.term.Term;
import com.renchaigao.function.dateUse;
import com.renchaigao.service.TermService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class TermServiceImpl implements TermService {

    private static Logger logger = Logger.getLogger(TermServiceImpl.class);
    @Autowired
    TermDao termDao;

    @Autowired
    UserDao userdao;

//    @Autowired
//    dateUse dateuse;

    public ResponseEntity addTerm(Term term) {
        JSONObject ret = termIsOn(term);
        if (ret.get("msg") == "yes") {   // 判断是否已存在
            return new ResponseEntity(RespCode.OHTER, ret.get("data"));
        } else {
            term.setAddTime(new Date());//小程序端没有添加创建时间，由后台填写该字段；
            if (termDao.addTerm(term) != 0) {
                return new ResponseEntity(RespCode.SUCCESS, term);
            }
            return new ResponseEntity(RespCode.WARN);
        }
    }

    public ResponseEntity getTermInfo(Term term) {
        long startTime = System.currentTimeMillis(); //程序开始记录时间

        JSONObject ret = termIsOn(term);
        Term termUse = (Term) ret.get("data");
        JSONObject data = new JSONObject();
        JSONObject info = new JSONObject();

        User ownerUser = userdao.findUserByID(termUse.getOwnerId());
        info.put("ownerNickname", ownerUser.getNickName());
        info.put("ownerAvatarUrl", ownerUser.getAvatarUrl());
        info.put("ownerAddress", ownerUser.getAddress());
        info.put("ownerAddTime", dateUse.DateToString(termUse.getAddTime()));
        data.put("term", ret.get("data"));
        data.put("info", info);
        logger.info("info is " + info.toJSONString());

        if (ret.get("msg") == "yes") {   // 判断是否已存在
            try {
                term = (Term) ret.get("data");
                logger.info("term : " + term.getId()
                        + "getAcordingIds is : " + term.getAcordingIds());
            } catch (Exception e) {
                logger.info(e);
            }
            logger.info("getTermInfo endTime - startTime is : " + (System.currentTimeMillis() - startTime));
            return new ResponseEntity(RespCode.OHTER, data);
        } else {
            logger.info("getTermInfo endTime - startTime is : " + (System.currentTimeMillis() - startTime));
            return new ResponseEntity(RespCode.NONE, null);
        }
    }


    private JSONObject termIsOn(Term term) {
        JSONObject ret = new JSONObject();
        Term termRet;
        try {
            termRet = termDao.getTermById(term.getId());
            if (termRet.getId() != null) {
                ret.put("msg", "yes");
                ret.put("data", termRet);
            } else {
                ret.put("msg", "no");
                ret.put("data", null);
            }
        } catch (Exception e) {
            ret.put("msg", "no");
            ret.put("data", e);
            logger.info(e);
        }
        return ret;
    }

    public ResponseEntity updateTerm(Term term) {

        return new ResponseEntity(RespCode.SUCCESS);
    }



    public ResponseEntity deleteTerm(Term term) {

        return new ResponseEntity(RespCode.SUCCESS);
    }

    ;


}
