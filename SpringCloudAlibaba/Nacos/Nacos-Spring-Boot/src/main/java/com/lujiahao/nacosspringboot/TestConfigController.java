package com.lujiahao.nacosspringboot;

import com.alibaba.nacos.api.config.annotation.NacosValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 测试配置管理
 * @author lujiahao
 * @date 2020-10-10
 */
@RestController
public class TestConfigController {

    /** @NacosValue 注解设置属性值 **/
    @NacosValue(value = "${configSwitch:false}", autoRefreshed = true)
    private boolean configSwitch;

    @GetMapping(value = "getConfig")
    public boolean get() {
        return configSwitch;
    }
}