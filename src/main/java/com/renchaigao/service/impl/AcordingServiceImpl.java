package com.renchaigao.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.renchaigao.dao.AcordingDao;
import com.renchaigao.domain.acording.Acording;
import com.renchaigao.domain.request.ReqAcording;
import com.renchaigao.domain.response.RespCode;
import com.renchaigao.domain.response.ResponseEntity;
import com.renchaigao.domain.term.Term;
import com.renchaigao.service.AcordingService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.Date;

@Service
public class AcordingServiceImpl implements AcordingService {

    private static Logger logger = Logger.getLogger(AcordingServiceImpl.class);

    @Autowired
    AcordingDao acordingdao;

    public ResponseEntity addAcording(ReqAcording reqacording) {
        JSONObject ret = acordingIsOn(reqacording);
        if (ret.get("msg") == "yes") {   // 判断是否已存在
            return new ResponseEntity(RespCode.ACORDING3, ret.get("data"));
        } else {
            reqacording.setAddtime(new Date());//小程序端没有添加创建时间，由后台填写该字段；
            if (acordingdao.addAcroding(reqacording) != 0)
                return new ResponseEntity(RespCode.SUCCESS, reqacording);
            return new ResponseEntity(RespCode.WARN);
        }
    }

    public ResponseEntity addAcordingFile(MultipartFile file) {
        String filePathOnService = creatRecodingPathOnservice(acordingdao.findUserIdByFileName(file.getOriginalFilename()));
        if (!file.isEmpty()) {
            try {
                BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(
                        new File(filePathOnService + file.getOriginalFilename())));
                out.write(file.getBytes());
                out.flush();
                out.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                return new ResponseEntity(RespCode.WARN,e.getMessage());
            } catch (IOException e) {
                e.printStackTrace();
                return new ResponseEntity(RespCode.WARN,e.getMessage());
            }
            return new ResponseEntity(RespCode.SUCCESS,filePathOnService);
        } else {
            return new ResponseEntity(RespCode.WARN,"上传文件为空");
        }
    }

    /**********************************************
     * 功能：生成系统下 各用户对应的recording 目录
     * 入参：用户id  userId
     **********************************************/
    public String creatRecodingPathOnservice(Integer userId) {
        File file = new File("/fpfolder/recording/users/" + userId.toString());
        if (!file.exists())
            file.mkdirs();
        return "/fpfolder/recording/users/" + userId.toString() + "/";
    }

    public ResponseEntity getAcordingInfo(ReqAcording reqacording) {

        return new ResponseEntity(RespCode.ACORDING3);
    }

    private JSONObject acordingIsOn(ReqAcording reqacording) {
        JSONObject ret = new JSONObject();
        Acording acordingRet;
        try {
            acordingRet = acordingdao.findAcordingById(reqacording.getId());
            if (acordingRet.getId() != null) {
                ret.put("msg", "yes");
                ret.put("data", acordingRet);
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
}
