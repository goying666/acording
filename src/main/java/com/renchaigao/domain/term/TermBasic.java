package com.renchaigao.domain.term;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class TermBasic {
    private Integer id;
    private Integer ownerId;//创建人id
    private String content;//内容
    private String address;//方言地址
    private String introduce;//备注
    private Integer zanNum;
    private Integer tingNum;
    private Integer acordingNum;
    private String termClass;
}
