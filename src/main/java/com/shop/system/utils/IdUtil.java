package com.shop.system.utils;

/**
 * id工具类
 */
public class IdUtil {

    public static  SnowflakeIdWorker idWorker = new SnowflakeIdWorker(0, 0);

    /**
     * 数据库id生成方法
     *
     * @author : luoshixin
     * @date : 2019-07-26 17:48
     */
    public static long generatorId(){
        return idWorker.nextId();
    }


}
