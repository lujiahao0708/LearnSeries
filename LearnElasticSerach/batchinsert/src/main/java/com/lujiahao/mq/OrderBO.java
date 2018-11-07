package com.lujiahao.mq;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.util.Date;

/**
 * 订单数据
 * @author lujiahao
 * @date 2018/11/5
 */
@Data
public class OrderBO {
    private String orderNo;
    @JSONField(name = "orderIdStr")
    private Integer orderId;
    private String airlineNo;
    private String airlineStatus;
    private String airlineDepCode;
    @JSONField(name = "agentIdStr")
    private Integer agentId;
    private String airlineArrCode;
    @JSONField(name = "airportIdStr")
    private Integer airportId;
    private String  bookingCurrentAddr;
    private String  bookingEndAddr;
    private String bookingStartAddr;
    private String bookingIdNumber;
    private String bookingUserPhone;
    private Integer bookingUserId;
    private String channelsNum;
    private Integer charteredId;
    private String charteredOrderNo;
    private Integer cityId;
    private Integer driverId;
    private Integer estimatedId;
    private Integer factDriverId;
    private String factEndAddr;
    private String factStartAddr;
    private String licensePlates;
    private String mobelVersion;
    private Integer orderType;
    private String riderPhone;
    private Integer serviceTypeId;
    private Integer status;
    private Integer type;
    private String version;
    private Integer pushDriverType;
    @JSONField(name = "business_id")
    private Integer businessId;
    @JSONField(name = "createDateStr", format = "yyyy-MM-dd HH:mm:ss")
    private Date createDate;
    @JSONField(name = "bookingDateStr", format = "yyyy-MM-dd HH:mm:ss")
    private Date bookingDate;
    @JSONField(name = "factDateStr", format = "yyyy-MM-dd HH:mm:ss")
    private Date factDate;
    @JSONField(name = "factEndDateStr", format = "yyyy-MM-dd HH:mm:ss")
    private Date factEndDate;
    @JSONField(name = "updateDateStr", format = "yyyy-MM-dd HH:mm:ss")
    private Date updateDate;
    @JSONField(name = "airlineArrDateStr", format = "yyyy-MM-dd HH:mm:ss")
    private Date airlineArrDate;
    @JSONField(name = "airlinePlanDateStr", format = "yyyy-MM-dd HH:mm:ss")
    private Date airlinePlanDate;
    private String platform;
    private Integer buyoutFlag;
    private Integer payFlag;
    private Integer carGroupId;
    private String memo;
    /**预定上车坐标点*/
    private String bookingStartPoint;
    /**预定下车坐标点*/
    private String bookingEndPoint;
    /**实际上车坐标点*/
    private String factStartPoint;
    /**实际下车坐标点*/
    private String factEndPoint;
    /**乘车人*/
    private String riderName;
}
