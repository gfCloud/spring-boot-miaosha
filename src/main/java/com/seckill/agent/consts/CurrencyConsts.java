package com.seckill.agent.consts;

/**
 * 类：常量
 * 所有变量名必须大写
 * @author gaoFan
 * @date 2020-9-23 17:29:29
 */
public class CurrencyConsts {

    private CurrencyConsts() {}


    /** 整数的定义规范 0 */
    public static final int ZERO = 0 ;
    public static final String ZERO_STRING = "0" ;
    /** 整数的定义规范 1 */
    public static final int ONE = 1 ;
    public static final String ONE_STRING = "1" ;

    /** errcode **/
    public static final String ERRCODE = "errcode";
    public static final String ERRMSG = "errmsg";

    /** access_token **/
    public static final String ACCESS_TOKEN = "access_token";
    /** refresh_token **/
    public static final String REFRESH_TOKEN = "refresh_token";
    /** expires_in 有效时间 **/
    public static final String EXPIRES_IN = "expires_in";
    /** jsapi_ticket **/
    public static final String JSAPI_TICKET = "ticket";
    /** openid **/
    public static final String OPENID = "openid";

    /** 日期格式  yyyyMMdd  **/
    public static final String DATE_YYYYMMDD = "yyyyMMdd";

    /** EXCEL表格**/
    public static final String XLSX = ".xlsx";
    public static final String XLS = ".xls";

    /** 请求方式 **/
    public static final String HTTP_GET = "get";
    public static final String HTTP_POST = "post";

    /** true **/
    public static final String TRUE = "true";
    public static final Boolean TRUE_BOOLEAN = true;
    /** false **/
    public static final String FALSE = "false";
    public static final Boolean FALSE_BOOLEAN = false;

}
