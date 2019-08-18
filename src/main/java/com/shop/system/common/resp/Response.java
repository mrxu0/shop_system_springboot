package com.shop.system.common.resp;

import com.shop.system.utils.FastJsonUtil;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

public class Response<T> implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty("true：请求成功；false：请求失败")
    private boolean success;

    @ApiModelProperty("请求状态码")
    private Integer code;

    @ApiModelProperty("返回地提示信息")
    private String message;

    @ApiModelProperty("请求处理成功之后返回的结果")
    private T data;


    public Response() {
        success(null);
    }

    public Response(T t) {
        success(t);
    }

    public boolean isSuccess() {
        return this.success;
    }

    public Integer getCode() {
        return this.code;
    }

    public String getMessage() {
        return this.message;
    }

    public T getData() {
        return this.data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public void success(T data) {
        this.success = true;
        this.data = data;
        this.code = ErrorCode.HTTP_STATUS_200;
    }


    /**
     * 设置错误消息，并将调用结果设置为失败
     * @param error 错误消息
     */
    public void setError(String error) {
        this.success = false;
        this.code = ErrorCode.HTTP_STATUS_500;
        this.message = error;
    }

    /**
     * 设置错误消息，并将调用结果设置为失败
     * @param error 错误消息
     */
    public Response setError(Integer code, String error) {
        this.success = false;
        this.code = code;
        this.message = error;
        return this;
    }

    /**
     * 设置返回消息
     * @param message 返回消息
     */
    public Response setMessage(String message) {
        this.message = message;
        return this;
    }

    /**
     * 转换为json string
     *
     * @return json string
     */
    public String toString() {
        return FastJsonUtil.bean2Json(this);
    }

}