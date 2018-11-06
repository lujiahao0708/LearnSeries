package com.lujiahao.service;

import com.lujiahao.mq.RocketMqProducer;
import org.apache.commons.lang3.RandomStringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * 数据生成服务
 * @author lujiahao
 * @date 2018-11-03 15:28
 */
@Service
public class DataGeneService {
    private static final Logger LOGGER = LoggerFactory.getLogger(DataGeneService.class);

    @Resource(name = "dataProducer")
    private RocketMqProducer dataProducer;

    private volatile long count = 0;

    /**
     * 发送数据
     */
    public void sendData() {
        try {
            while (true) {
                String topic = "dataTopic";
                int[] statusArr = {10, 13, 15, 20, 25, 30, 40, 44, 45, 50 , 60};
                int status = statusArr[new Random().nextInt(11)];
                String tag = "1_" + status;
                String orderNo = "P" + generateOrderNo();
                String json = attachJson(orderNo, status);
                dataProducer.sendMessage(topic, tag, orderNo, json);
                ++count;
                LOGGER.info("发送count:{}", count);
                Thread.sleep(new Random().nextInt(500));
            }
        } catch (Exception e) {
            LOGGER.error("发送数据异常", e);
        }
    }

    private synchronized String generateOrderNo() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyMMddHHmmss");
        String date = sdf.format(new Date());
        //获取十位随机数
        String randomTen = RandomStringUtils.randomNumeric(6);
        return date + randomTen;
    }

    private String attachJson(String orderNo, int status) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = sdf.format(new Date());
        return "{\"agentIdStr\":\"0\",\"airlineArrCode\":\"\",\"airlineArrDateStr\":\"\",\"airlineDepCode\":\"\"," +
                "\"airlineNo\":\"\",\"airlinePlanDateStr\":\"\",\"airlineStatus\":\"\",\"airportIdStr\":\"\"," +
                "\"autoLevelUp\":\"0\",\"bookingCurrentAddr\":\"北京市朝阳区东三环北路辅路10号靠近长城饭店\"," +
                "\"bookingCurrentPoint\":\"116.46334,39.945194;116.469944,116.469944\",\"bookingDateStr\":\"2018-11-05 20:35:00\"," +
                "\"bookingDriverId\":\"0\",\"bookingEndAddr\":\"朝阳公园(地铁站)\",\"bookingEndPoint\":\"116.478291,39.933492;116.484841,39.939284\"," +
                "\"bookingGroupids\":\"35\",\"bookingIdNumber\":\"\",\"bookingStartAddr\":\"亮马桥长城饭店-会议厅\"," +
                "\"bookingStartPoint\":\"116.46334,39.945194;116.469944,39.950845\",\"bookingUserId\":\"30202013\"," +
                "\"bookingUserPhone\":\"16699999999\",\"business_id\":\"\",\"buyoutFlag\":\"0\",\"buyoutPrice\":\"0.0\"," +
                "\"cancelorderPenalty\":\"\",\"carGroupId\":\"35\",\"channelsNum\":\"shouqi_1\",\"charteredId\":\"25899\"," +
                "\"charteredOrderNo\":\"C181105193255134065\",\"cityId\":\"44\",\"createBy\":\"30202013\"," +
                "\"createDateStr\":\""+format+"\",\"doormanPayMethod\":\"\",\"driverId\":\"10101028\"," +
                "\"estimatedAmount\":\"122.0\",\"estimatedId\":\"\",\"eventCategory\":\"UPDATE\",\"factDateStr\":\"2018-11-05 19:43:01\"," +
                "\"factDriverId\":\"\",\"factEndAddr\":\"\",\"factEndDateStr\":\"\",\"factEndPoint\":\"\"," +
                "\"factStartAddr\":\"北京市朝阳区麦子店街道东三环北路8-4号楼北京亮马河大厦\",\"factStartPoint\":\"116.464570,39.945483;116.471173,39.951139\"," +
                "\"goHomeStatus\":\"\",\"imei\":\"865810037321730\",\"isOrderOthers\":\"0\",\"isOtherDrivers\":\"2\"," +
                "\"licensePlates\":\"测B15382\",\"memo\":\"{\\\"joinDriverSign\\\":\\\"true\\\"}\",\"mobelVersion\":\"vivo\"," +
                "\"orderIdStr\":\"139871278\",\"orderNo\":\""+orderNo+"\",\"orderType\":\"0\",\"payFlag\":\"0\"," +
                "\"platform\":\"ANDROID\",\"pushDriverType\":\"2\",\"receiveSms\":\"1\",\"riderName\":\"\"," +
                "\"riderPhone\":\"16699999999\",\"selectedPayFlag\":\"0\",\"serviceTypeId\":\"7\",\"status\":\""+status+"\"," +
                "\"sysVersion\":\"7.1.2\",\"type\":\"1\",\"updateBy\":\"30202013\",\"updateDateStr\":\""+format+"\"," +
                "\"version\":\"6.2.9\"}";

    }
}
