package com.lujiahao.service;

import com.alibaba.fastjson.JSONObject;
import com.lujiahao.dao.ESRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @author lujiahao
 * @date 2018-11-01 13:55
 */
@Service
public class ESSearchService {
    @Autowired
    private ESRepository eSRepository;

    public boolean buildIndex(String index) {
        return eSRepository.buildIndex(index);
    }

    public boolean delIndex(String index) {
        return eSRepository.deleteIndex(index);
    }

    public Map<String, Object> searchDataByParam(String index, String type, String id) {
        return eSRepository.searchDataByParam(index, type, id);
    }

    public void updateDataById(JSONObject data, String index, String type, String id) {
        eSRepository.updateDataById(data, index, type, id);
    }

    public String addTargetDataALL(JSONObject data, String index, String type, String id) {
        return eSRepository.addTargetDataALL(data, index, type, id);
    }

    public void delDataById(String index, String type, String id) {
        eSRepository.delDataById(index, type, id);
    }

    public boolean isIndexExist(String index) {
        return eSRepository.isIndexExist(index);
    }
}
