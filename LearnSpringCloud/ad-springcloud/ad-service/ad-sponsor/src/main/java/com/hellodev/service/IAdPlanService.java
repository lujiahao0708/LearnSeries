package com.hellodev.service;

import com.hellodev.entity.AdPlan;
import com.hellodev.exception.AdException;
import com.hellodev.vo.AdPlanGetRequest;
import com.hellodev.vo.AdPlanRequest;
import com.hellodev.vo.AdPlanResponse;

import java.util.List;

/**
 *
 * @author lujiahao
 * @date 2019-09-02
 */
public interface IAdPlanService {

    /**
     * <h2>创建推广计划</h2>
     * */
    AdPlanResponse createAdPlan(AdPlanRequest request) throws AdException;

    /**
     * <h2>获取推广计划</h2>
     * */
    List<AdPlan> getAdPlanByIds(AdPlanGetRequest request) throws AdException;

    /**
     * <h2>更新推广计划</h2>
     * */
    AdPlanResponse updateAdPlan(AdPlanRequest request) throws AdException;

    /**
     * <h2>删除推广计划</h2>
     * */
    void deleteAdPlan(AdPlanRequest request) throws AdException;
}
