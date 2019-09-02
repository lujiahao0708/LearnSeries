package com.hellodev.client;

import com.hellodev.client.vo.AdPlan;
import com.hellodev.client.vo.AdPlanGetRequest;
import com.hellodev.vo.CommonResponse;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 *
 * @author lujiahao
 * @date 2019-09-02
 */
@Component
public class SponsorClientHystrix implements SponsorClient {

    @Override
    public CommonResponse<List<AdPlan>> getAdPlans(AdPlanGetRequest request) {
        return new CommonResponse<>(-1, "eureka-client-ad-sponsor error");
    }
}
