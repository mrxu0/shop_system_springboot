package com.shop.system.common.resp;

/**
 * @author : luoshixin
 * @describe :
 * @create : 2019-05-08 19:01
 **/

public class ErrorCode {


//    /** 成功 */
//    public static final String OK = "OK";
//    /** 服务器内部错误 */
//    public static final String INTERNAL_ERROR = "E00000";
//    /** 获取验证码次数过多 */
//    public static final String TOOMUCH_CODE_ERROR = "E50000";
//

    // 请求成功。一般用于GET与POST请求
    public static final int HTTP_STATUS_200 = 200;
    // 传的参数有错误
    public static final int HTTP_STATUS_400 = 400;
    // Unauthorized	请求要求用户的身份认证
    public static final int HTTP_STATUS_401 = 401;
    // 服务器理解请求客户端的请求，但是拒绝执行此请, 客户端没有权限
    public static final int HTTP_STATUS_403 = 403;
    // 服务器无法根据客户端的请求找到资源（网页）。通过此代码，网站设计人员可设置"您所请求的资源无法找到"的个性页面
    public static final int HTTP_STATUS_404 = 404;
    // 服务器内部错误，无法完成请求
    public static final int HTTP_STATUS_500 = 500;


    /* 自定义的状态码从2000开始 */

    // 当前用户没有登录，即没有获取到登录信息
    public static final int NO_AUTHORIZATION = 2010;
    // 数据库主键重复
    public static final int DUPLICATE_KEY_CODE_ERROR = 2050;
    // 上传的文件和七牛上的文件名字重复，同名不同资源
    public static final int FILE_NAME_ALREADY_EXISTS_CODE_ERROR = 2100;
}
