package com.wh.bling.req;

import lombok.Data;

/**
 * @author froid
 * @date: 2020/8/26 0:04
 */
@Data
public class GetAccountRes{
    private String name;
    private String account;
    private String upwd;
    private String remark;
}
