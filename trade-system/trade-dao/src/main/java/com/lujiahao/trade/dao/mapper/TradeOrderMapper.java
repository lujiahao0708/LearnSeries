package com.lujiahao.trade.dao.mapper;

import com.lujiahao.trade.dao.model.TradeOrder;
import com.lujiahao.trade.dao.model.TradeOrderExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TradeOrderMapper {
    int countByExample(TradeOrderExample example);

    int deleteByExample(TradeOrderExample example);

    int insert(TradeOrder record);

    int insertSelective(TradeOrder record);

    List<TradeOrder> selectByExample(TradeOrderExample example);

    int updateByExampleSelective(@Param("record") TradeOrder record, @Param("example") TradeOrderExample example);

    int updateByExample(@Param("record") TradeOrder record, @Param("example") TradeOrderExample example);
}