package com.renchaigao.controller;


import com.renchaigao.domain.response.ResponseEntity;
import com.renchaigao.service.impl.AcordingServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/acording/")
public class AcordingController {

    @Autowired
    private AcordingServiceImpl acordingServiceImpl;

    @PostMapping(value = "/add" , consumes = "application/json")
    @ResponseBody
    public ResponseEntity addTerm(@RequestBody ReqTerm reqterm){
        return termserviceimpl.addTerm(reqterm);
    }

    @PostMapping(value = "/info" , consumes = "application/json")
    @ResponseBody
    public ResponseEntity getTermInfo(@RequestBody ReqTerm reqterm){
        return termserviceimpl.getTermInfo(reqterm);
    }


}
