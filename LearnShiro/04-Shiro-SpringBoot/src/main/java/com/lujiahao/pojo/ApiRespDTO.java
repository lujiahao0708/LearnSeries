package com.lujiahao.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 接口统一返回实体
 * @author lujiahao
 * @date 2019-09-15 16:29
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApiRespDTO<T> {
    private int code;
    private String msg;
    private T data;

    public static int SUCCESS_CODE = 0;
    public static int ERROR_CODE = 1;

    public static String SUCCESS_MSG = "success";
    public static String ERROR_MSG = "error";

    public boolean isSuccess() {
        return SUCCESS_CODE == code;
    }


    public static <T> ApiRespDTO buildSuccess(T data) {
        return new ApiRespDTO(SUCCESS_CODE, SUCCESS_MSG, data);
    }
    public static <T> ApiRespDTO buildSuccess() {
        return new ApiRespDTO(SUCCESS_CODE, SUCCESS_MSG, null);
    }

    public static <T> ApiRespDTO buildError(int errorCode) {
        return new ApiRespDTO(errorCode, ERROR_MSG, null);
    }

    public static <T> ApiRespDTO buildError(String msg) {
        return new ApiRespDTO(ERROR_CODE, msg, null);
    }

    public static <T> ApiRespDTO buildError(int errorCode, String errorMsg) {
        return new ApiRespDTO(errorCode, errorMsg, null);
    }
}
