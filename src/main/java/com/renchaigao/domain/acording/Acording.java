package com.renchaigao.domain.acording;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Setter
@Getter
@ToString
public class Acording extends AcordingBasic{
    private Integer tingNum;
    private Integer zanNum;
    private Integer badNum;
    private Date addtime;
    private Integer shoucangNum;
    private Integer shareNum;
}
