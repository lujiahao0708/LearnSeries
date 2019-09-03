package com.hellodev.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 分页
 * @author lujiahao
 * @date 2019-09-03 18:37
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PageResult<T> {
    // 总页数
    @JsonProperty("total")
    private Long totalPage;
    // 查询的数据
    @JsonProperty("rows")
    private List<T> data;
}
