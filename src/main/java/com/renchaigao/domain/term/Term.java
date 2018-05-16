package com.renchaigao.domain.term;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Setter
@Getter
@ToString
public class Term extends TermBasic{

    private Date addTime;
    private String acordingIds;

}
