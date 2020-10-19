package com.lujiahao.sentinel.base.controller;

import com.alibaba.csp.sentinel.Entry;
import com.alibaba.csp.sentinel.SphU;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.csp.sentinel.slots.block.RuleConstant;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRule;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRuleManager;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

/**
 * 自定义规则
 * @author lujiahao
 * @date 2020-10-08
 */
@RestController
public class CustomFlowRuleController {

    @PostConstruct
    public void initFlowRules() {
        List<FlowRule> ruleList = new ArrayList<>();
        FlowRule flowRule = new FlowRule();
        flowRule.setResource("custom");
        flowRule.setGrade(RuleConstant.FLOW_GRADE_QPS);
        // 限制 qps 最大值为 2
        flowRule.setCount(2);
        ruleList.add(flowRule);
        // 加载规则
        FlowRuleManager.loadRules(ruleList);
    }

    @GetMapping("/custom")
    public String custom() {
        try (Entry entry = SphU.entry("custom")){
            // 被保护的逻辑代码
            return "Hello Sentinel!";
        } catch (BlockException e) {
            e.printStackTrace();
            // 被流控的逻辑代码
            return "System busy!";
        }
    }
}
