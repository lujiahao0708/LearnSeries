package com.lujiahao.trade.dao.mapper;

import com.lujiahao.trade.dao.model.TradePay;
import com.lujiahao.trade.dao.model.TradePayExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TradePayMapper {
    int countByExample(TradePayExample example);

    int deleteByExample(TradePayExample example);

    int insert(TradePay record);

    int insertSelective(TradePay record);

    List<TradePay> selectByExample(TradePayExample example);

    int updateByExampleSelective(@Param("record") TradePay record, @Param("example") TradePayExample example);

    int updateByExample(@Param("record") TradePay record, @Param("example") TradePayExample example);
}