package com.hellodev.controller;

import com.alibaba.fastjson.JSON;
import com.hellodev.annotation.IgnoreResponseAdvice;
import com.hellodev.client.SponsorClient;
import com.hellodev.client.vo.AdPlan;
import com.hellodev.client.vo.AdPlanGetRequest;
import com.hellodev.vo.CommonResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @author lujiahao
 * @date 2019-09-02 17:31
 */
@Slf4j
@RestController
public class SearchController {
    private final RestTemplate restTemplate;

    private final SponsorClient sponsorClient;

    @Autowired
    public SearchController(RestTemplate restTemplate, SponsorClient sponsorClient) {
        this.restTemplate = restTemplate;
        this.sponsorClient = sponsorClient;
    }

    @SuppressWarnings("all")
    @IgnoreResponseAdvice
    @PostMapping("/getAdPlanByRibbon")
    public CommonResponse<List<AdPlan>> getAdPlanByRibbon(@RequestBody AdPlanGetRequest request) {
        log.info("ad-search: getAdPlanByRibbon -> {}", JSON.toJSONString(request));
        return restTemplate.postForEntity(
                "http://eureka-client-ad-sponsor/ad-sponsor/get/adPlan",
                request,
                CommonResponse.class
        ).getBody();
    }


    @IgnoreResponseAdvice
    @PostMapping("/getAdPlanByFeign")
    public CommonResponse<List<AdPlan>> getAdPlanByFeign(@RequestBody AdPlanGetRequest request) {
        log.info("ad-search: getAdPlanByFeign -> {}", JSON.toJSONString(request));
        return sponsorClient.getAdPlans(request);
    }
}
