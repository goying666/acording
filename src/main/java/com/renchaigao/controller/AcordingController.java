package com.renchaigao.controller;


import com.renchaigao.domain.request.ReqAcording;
import com.renchaigao.domain.response.ResponseEntity;
import com.renchaigao.service.impl.AcordingServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping(value = "/acording/")
public class AcordingController {

    @Autowired
    private AcordingServiceImpl acordingServiceImpl;

    @PostMapping(value = "/add/info" , consumes = "application/json")
    @ResponseBody
    public ResponseEntity addAcordingInfo(@RequestBody ReqAcording reqacording){
        return acordingServiceImpl.addAcording(reqacording);
    }

    @PostMapping(value = "/add/file" , consumes = "multipart/form-data")
    @ResponseBody
    public ResponseEntity addAcordingFile(@RequestParam("file") MultipartFile file){
        return acordingServiceImpl.addAcordingFile(file);
    }





    @PostMapping(value = "/info" , consumes = "application/json")
    @ResponseBody
    public ResponseEntity getAcordingInfo(@RequestBody ReqAcording reqacording){
        return acordingServiceImpl.getAcordingInfo(reqacording);
    }


}
