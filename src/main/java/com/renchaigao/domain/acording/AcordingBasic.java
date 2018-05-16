package com.renchaigao.domain.acording;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Setter
@Getter
@ToString
public class AcordingBasic {
    private Integer id;
    private Integer termId;
    private String termInfo;
    private Integer userId;
    private Integer path;
    private String address;
    private String fileName;
}
