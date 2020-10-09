package com.miaosha.agent.until;

import java.util.HashMap;
import java.util.List;

/**
 * Layui工具类
 *
 * @author gaoFan
 * @version V1.0
 * @date 2020/9/25 14:45
 */


public class Layui  extends HashMap<String, Object> {

    public static Layui data(Integer count, List<?> data){
        Layui r = new Layui();
        r.put("code", 0);
        r.put("msg", "");
        r.put("count", count);
        r.put("data", data);
        return r;
    }
}
