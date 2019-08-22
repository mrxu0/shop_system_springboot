package com.shop.system.utils;
import com.shop.system.common.exception.CheckException;
import org.springframework.stereotype.Component;

/**
 * @describe: 参数校验的util
 * @author: luoshixin
 * @create: 2018/10/14 上午9:45
 **/
@Component
public class Arguments {

    /**
     * 检查表达式是否成立
     *
     * @param expression: true 放行，false 抛出异常
     * @param errMsgKey:  国际化key
     * @author: luoshixin
     */
    public static void check(boolean expression, String errMsgKey) {
        if (!expression) {
            fail(errMsgKey);
        }
    }
    private static void fail(String errMsgKey) {
       throw new CheckException(errMsgKey);
    }
}
