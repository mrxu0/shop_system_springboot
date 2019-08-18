package com.shop.system.common.exception;

import com.shop.system.common.resp.ErrorCode;
import com.shop.system.common.resp.Response;
import org.apache.shiro.ShiroException;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class GlobalExceptionHandler {

    // 捕捉shiro的异常
//    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ExceptionHandler(ShiroException.class)
    public Response handle403(ShiroException e) {
        return new Response().setError(ErrorCode.HTTP_STATUS_403, "对不起，没有权限访问");
    }

    // 捕捉UnauthorizedException
//    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ExceptionHandler(UnauthorizedException.class)
    public Response handle403() {
        return new Response().setError(ErrorCode.HTTP_STATUS_403, "对不起，没有权限访问");
    }

    //    校验参数
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Response methodArgumentNotValidException(MethodArgumentNotValidException ex) {
        Response errorResult = new Response();
        BindingResult bindingResult = ex.getBindingResult();
        String errorMesssage = bindingResult.getFieldErrors().get(0).getDefaultMessage();
//        for (FieldError fieldError : bindingResult.getFieldErrors()) {
//            errorMesssage += fieldError.getDefaultMessage();
//        }
        errorResult.setError(ErrorCode.HTTP_STATUS_400, errorMesssage);
        return errorResult;
    }


    //  校验请求的资源是否存在
    @ExceptionHandler(value = NoHandlerFoundException.class)
    public Response NoHandlerFoundException(HttpServletRequest req, NoHandlerFoundException e) throws Exception {
        Response res = new Response();
        res.setError(ErrorCode.HTTP_STATUS_404, "访问的资源不存在");
        return res;
    }


    @ExceptionHandler(value = Exception.class)
    public Response defaultErrorHandler(HttpServletRequest req, Exception e) throws Exception {
        Response res = new Response();
        res.setError(e.getMessage());
        return res;
    }
}
