package com.renchaigao.controller;

import com.renchaigao.domain.request.ReqTerm;
import com.renchaigao.domain.response.ResponseEntity;
import com.renchaigao.service.impl.TermServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/term/")
public class TermController {

    @Autowired
    private TermServiceImpl termserviceimpl;

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
