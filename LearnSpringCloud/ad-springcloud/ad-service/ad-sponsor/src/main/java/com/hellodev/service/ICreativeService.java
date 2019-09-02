package com.hellodev.service;

import com.hellodev.vo.CreativeRequest;
import com.hellodev.vo.CreativeResponse;

/**
 *
 * @author lujiahao
 * @date 2019-09-02
 */
public interface ICreativeService {

    CreativeResponse createCreative(CreativeRequest request);
}
