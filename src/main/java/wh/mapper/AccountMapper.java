package wh.mapper;

import org.apache.ibatis.annotations.Mapper;
import wh.req.GetAccountReq;
import wh.req.GetAccountRes;

import java.util.List;

/**
 * @author froid
 * @date 2020/8/25 21:33
 */
@Mapper
public interface AccountMapper {
    List<GetAccountRes> getAccounts(GetAccountReq req);
}
