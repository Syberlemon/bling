package com.wh.bling.mapper;

import com.wh.bling.req.GetAccountReq;
import com.wh.bling.req.GetAccountRes;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author froid
 * @date 2020/8/25 21:33
 */
@Mapper
public interface AccountMapper {
    List<GetAccountRes> getAccounts(GetAccountReq req);
}
