/*解决ie8中js数组没有indexOf方法*/

jQuery.extend({
    exportResport : function(url, method, params){
        var paramControl = '<form action="'+url+'" method="'+(method||'post')+'">' ;
        $.each(params,function(name,value){
            paramControl += '<input type="text" name="'+name+'" value="'+value+'"/>';
        });
        paramControl += '</form>';
        jQuery(paramControl).appendTo('body').submit().remove();
    },//下载文件，主要用于导出报表
    getJSONNoCache: function (url,type, data,dataType,traditional, callback,failCallback) {
        $.ajax({
            url: url,
            type:type ||"GET",          
            dataType: dataType||'json',
            data: data,
            cache: false,
            traditional:traditional,   //发送数组时该属性设为ture,否则服务端接收不到
            success: callback,
            error:failCallback
        });
    },    //一般ajax请求，不用设置contentType
    getJSONAsync: function (url,type, data,dataType,traditional, callback,failCallback) {
        $.ajax({
            url: url,
            type:type ||"GET",    
            async: false,
            dataType: dataType||'json',
            data: data,
            cache: false,
            traditional:traditional,   //发送数组时该属性设为ture,否则服务端接收不到
            success: callback,
            error:failCallback
        });
    },    //发送同步ajax请求
    getWithContentType: function (url,type, data,contentType,dataType,traditional, callback,failCallback) {
        $.ajax({
            url: url,
            type:type ||"GET",          
            dataType: dataType||'json',
            contentType:contentType,
            data: data,
            cache: false,
            traditional:traditional,   //发送数组时该属性设为ture,否则服务端接收不到
            success: callback,
            error:failCallback
        });  //需要设置contentType,且一般为application/json
    },
    getWithTimeOut: function (url,type, data,dataType,timeout, callback,failCallback) {
        $.ajax({
            url: url,
            type:type ||"GET",          
            dataType: dataType||'json',         
            data: data,
            cache: false,
            timeout:timeout,
            success: callback,
            error:failCallback
        });  //  带有timeout超时控制的ajax请求
    },
    /// totalCount:总记录数 ;  current_page：当前索引 （从0开始); items_per_page：每页显示多少条;callback：回调函数   
    pagination:function(totalCount,current_page,items_per_page,callback){
        $("#pagination").pagination(totalCount, {
            num_edge_entries: 3, //边缘页数
            num_display_entries: 4, //主体页数
            current_page:current_page,
            items_per_page:items_per_page, //每页显示10项
            prev_text: "<<",
            next_text: ">>",
            callback:callback         
                    
        });
        
    } ,//分页  
    isValid:function(valControl){        
        var inputVal=$.trim(valControl.value);
        if($(valControl).is(".txt-required") && inputVal=="" )
            {                
                return false;
            }
        if($(valControl).is(".num"))
            {
                if(!window.formValidate.matchNum(inputVal))
                {                    
                    return false;
                }
            }
        if($(valControl).is('.floatNum'))
            {
                if(window.formValidate.matchNum(inputVal))
                    {
                        return true;
                    }
                if(!window.formValidate.matchFloat(inputVal))
                    {
                        return false;
                    }
            }     
        if($(valControl).is(".txtEmail"))  //邮箱输入框
        {
            if(!window.formValidate.matchEmail(inputVal))
                {                    
                    return false;
                }                        
        }
       if($(valControl).is(".txtTel"))  //联系电话输入框
        {
            if(!window.formValidate.matchTel(inputVal))
            {                
                return false;
            }                        
        }
       if($(valControl).is(".txtPhone"))  //联系电话输入框
        {
            if(!window.formValidate.matchPhone(inputVal))
            {                
                return false;
            }                        
        }
        if($(valControl).is(".txtQQ"))  //qq输入框
        {
            if(!window.formValidate.matchQQ(inputVal))
            {                
                return false;
            }                        
        }
      if($(valControl).is(".txtPostCode"))  //邮政编码输入框
        {
            if(!window.formValidate.matchPostCode(inputVal))
            {                
                return false;
            }                        
        }
      if($(valControl).is(".txCheckColumn"))  //用户名输入框
        {
            if(!window.formValidate.matchCheckColumn(inputVal))
            {                
                return false;
            }                        
        }
    
    return true;    
    }  //表单元素验证
});
var formValidate={
        emailReg:/\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*/,  //邮箱
        postCodeRegex: /^[0-9][0-9]{5}$/,   //邮政编码
        qqRegex: /^[1-9]*[1-9][0-9]*$/,   //qq
        telRegex: /^[\\(\\)-.0-9\u0020\u3000]*$/,      //电话号码
        phoneRegex: /^[0-9]{11}$/,   //手机号
        telAndPhoneRegex:/^((0\d{2,3}-\d{7,8})|(1[34578]\d{9}))$/, //手机或固话
        numRegex:/^\d*$/,  //正整数
        floatNumRegex:/^\d+\.\d+$/,   //正小数
        userNameRegex:/^[\u4E00-\u9FA5A-Za-z0-9_]+$/, //中文、英文、数字包括下划线
        isEmpty:function(val)
        {
            return val=="" || val==null || $.trim(val)=="";
        }, //是否为空
        matchEmail:function(val)
        {
            return  this.emailReg.test(val);
        },  //是否符合邮箱格式
        isEqual:function(val1, val2)
        {
            return val1==val2;
        }, //两个值是否相等
        matchQQ:function(val)
        {
            return this.qqRegex.test(val);
        } ,  //是否符合qq格式
        matchTel:function(val)
        {
            return this.telAndPhoneRegex.test(val);
        } ,  //是否符合电话号码格式
        matchPhone:function(val)
        {
            return this.telAndPhoneRegex.test(val);
        } ,  //是否符合手机号格式
        matchPostCode:function(val)
        {
            return  this.postCodeRegex.test(val);
        },   //是否符合邮政编码格式
        matchCheckColumn:function(val)
        {
            return  this.userNameRegex.test(val);
        },   //是否符合用户名格式
        matchNum:function(val)
        {
            return this.numRegex.test(val);
        } , //验证数字
        matchFloat:function(val)
        {
            return  this.numRegex.test(val)==true || this.floatNumRegex.test(val)==true;
        }  , //验证浮点数
        matchFileName:function(val)
        {
            return  /^\./.test(val)==false && /[/\:*?"<>|]/g.test(val)==false
        }  //匹配文件名

};   //form验证
//日期比较  
function dateCompare(startdate,enddate)   
{   
    var arr=startdate.split("-");    
    var starttime=new Date(arr[0],arr[1],arr[2]);    
    var starttimes=starttime.getTime();   
      
    var arrs=enddate.split("-");    
    var lktime=new Date(arrs[0],arrs[1],arrs[2]);    
    var lktimes=lktime.getTime();   
      
    if(starttimes>lktimes)    
    {   
        return false;   
    }   
    else  
        return true;   
  
}  
/* 获取某月天数*/
function getMonthDays(myMonth){ 
    var now=new Date();
    var nowYear=now.getYear();
    var monthStartDate = new Date(nowYear, myMonth, 1); 
    var monthEndDate = new Date(nowYear, myMonth + 1, 1); 
    var days = (monthEndDate - monthStartDate)/(1000 * 60 * 60 * 24); 
    return days; 
} 
/*获得本天  */
function getToday() {    
    return formatDate(new Date()); 
}
//获得本周的开端日期   (周一)
function getWeekStartDate() {
    var now=new Date();
    var nowYear=now.getFullYear();
    var nowMonth = now.getMonth(); //当前月 
    var nowDay = now.getDate(); //当前日
    var nowDayOfWeek = now.getDay(); //今天本周的第几天 
    var weekStartDate = new Date(nowYear, nowMonth, nowDay - nowDayOfWeek+1); 
    return formatDate(weekStartDate); 
}
//获得本周的停止日期   （周日）
function getWeekEndDate() { 
    var now=new Date();
    var nowYear=now.getFullYear();
    var nowMonth = now.getMonth(); //当前月 
    var nowDay = now.getDate(); //当前日
    var nowDayOfWeek = now.getDay(); //今天本周的第几天     
    var weekEndDate = new Date(nowYear, nowMonth, nowDay + (7 - nowDayOfWeek)); 
    return formatDate(weekEndDate); 
} 
//获得本月的开端日期 
function getMonthStartDate(){ 
    var now=new Date();
    var nowYear=now.getFullYear();
    var nowMonth = now.getMonth(); //当前月     
    var monthStartDate = new Date(nowYear, nowMonth,1); 
    return formatDate(monthStartDate); 
} 
//获得本月的停止日期 
function getMonthEndDate(){ 
    var now=new Date();
    var nowYear=now.getFullYear();
    var nowMonth = now.getMonth(); //当前月
    var monthEndDate = new Date(nowYear, nowMonth, getMonthDays(nowMonth)); 
    return formatDate(monthEndDate); 
} 
//获得本季度的开端日期
function getSeasonStartDate()
{
    var now=new Date();
    var nowYear=now.getFullYear();
    return formatDate(new Date(nowYear,getQuarterStartMonth(now.getMonth()),1));
}
//获得本季度的停止日期
function getSeasonEndDate()
{
    var now=new Date();
    var nowYear=now.getFullYear();
    var month=getQuarterStartMonth(now.getMonth())+2;
    return formatDate(new Date(nowYear,month,getMonthDays(month)));
}
function getQuarterStartMonth(nowMonth)
{
    var quarterStartMonth = 0;     
    if(nowMonth<3){     
       quarterStartMonth = 0;     
    }     
    if(2<nowMonth && nowMonth<6){     
       quarterStartMonth = 3;     
    }     
    if(5<nowMonth && nowMonth<9){     
       quarterStartMonth = 6;     
    }     
    if(nowMonth>8){     
       quarterStartMonth = 9;     
    }     
    return quarterStartMonth;  
}
//获得本年的开端日期
function getYearStartDate()
{
    var now=new Date();
    var nowYear=now.getFullYear();
    return formatDate(new Date(nowYear,0,1));
}
//获得本年的停止日期
function getYearEndDate()
{
    var now=new Date();
    var nowYear=now.getFullYear();    
    return formatDate(new Date(nowYear,11,31));
}
//获得前n天的日期
function getBeforeDate(n){
    var n = n;
    var d = new Date();
    var year = d.getFullYear();
    var mon=d.getMonth()+1;
    var day=d.getDate();
    if(day <= n){
            if(mon>1) {
               mon=mon-1;
            }
           else {
             year = year-1;
             mon = 12;
             }
           }
          d.setDate(d.getDate()-n);
          year = d.getFullYear();
          mon=d.getMonth()+1;
          day=d.getDate();
     s = year+"-"+(mon<10?('0'+mon):mon)+"-"+(day<10?('0'+day):day);
     return s;
}
/*格式化日期  yyyy-MM-dd */
function formatDate(date)
{
    return date.getFullYear()+'-'+(date.getMonth()+1)+'-'+date.getDate();
}
/*返回昨天日期   yyyy-MM-dd   */
function formatYesterday()
{
    var now=new Date();
    now.setTime(now.getTime()-1000* 60 * 60 * 24);
    return now.getFullYear()+'-'+(now.getMonth()+1)+'-'+now.getDate();
}

/*返回日期差   yyyy-MM-dd   */
function calculateDays(fromStr,toStr,isWorkDay){ 
    var from = new Date(); 
    var to = new Date(); 
    var fromTime = Date.parse(fromStr.replace(/\-/g,"/")); 
    var toTime = Date.parse(toStr.replace(/\-/g,"/"));

    from.setTime(fromTime); 
    from.setHours(0); 
    from.setMinutes(0); 
    from.setSeconds(0);

    to.setTime(toTime); 
    to.setHours(0); 
    to.setMinutes(0); 
    to.setSeconds(0); 
    if(from.getTime() > to.getTime()){ 
        return 0; 
    }

    // 把起始日都修正到星期六 javascript的星期从0开始，所以+1来处理
    var sDayofWeek = from.getDay()+1; 
    var workdays=0;

    // 修正到星期六之后，再修正多出来的非假日
    if(sDayofWeek > 1 && sDayofWeek < 7)
    {
        from.setDate(from.getDate()-(sDayofWeek%7)); 
        workdays-=((sDayofWeek-2)>0)?sDayofWeek-2:0; 
    }

    // 计算两个日期之间的天数
    var totalDays = (to.getTime()-from.getTime())/(1000*60*60*24)+1; 
    if(!isWorkDay){
        return totalDays;
    }
    workdays+=Math.floor(totalDays/7)*5;

    // 修正最后剩余天数
    if((totalDays%7-2)>0){ 
        workdays+=(totalDays%7-2); 
    } 
    return workdays
}



/* 显示弹出框中的错误信息 */
function setCookie(name,value,expires)
{
    document.cookie=name+'='+value+';expires='+expires;
}
function showErrorMsg(container,msg)
{
    var  scroller=container.parent(), error,firstBtn;
    if(scroller.is('.slimScrollDiv'))
        {
            error=scroller.next().find('#sp-error');
            firstBtn=scroller.next().children('.ui-dialog-buttonset').children('button:first');
        }
    else
        {
            error=container.next().find('#sp-error');
            firstBtn=container.next().children('.ui-dialog-buttonset').children('button:first');
        }
    if(error.length==0)
        {
            firstBtn.before("<span id='sp-error' class='sp-error'>"+msg+"</span>");
        }
    else
        {
             error.text(msg);
        }
}
/* 公共的信息提示框*/
var commonInfoDialog=function(){
    return {
        infoDialog:null,
        init:function(options){
            var defaultOptions={
                closeHandler:null,
                okHandler:null
            };
            $.extend(defaultOptions,options);
            this.infoDialog=$('#common-info-dialog');
            if(this.infoDialog.length==0)
                {
                    this.infoDialog=$('<div></div>');
                }
            this.infoDialog.dialog({                    
                autoOpen:false,
                title:'提示',
                dialogClass:'ui-dialog-blue  ui-dialog-boxshadow',
                modal:true,        
                resizable:false,
                close:function(){
                    $(this).dialog('destroy');
                    if(defaultOptions.closeHandler)
                        {
                            defaultOptions.closeHandler();    
                        }
                },
                buttons:[{
                    'class':'btn blue',
                    'id':'commonInfo',
                    'text':'确定',
                    'click':function(){
                        $(this).dialog('close');
                        if(defaultOptions.okHandler)
                            {
                                defaultOptions.okHandler();    
                            }
                    }
                    
                }]
            });
            return this.infoDialog;
        },
        show:function(){
            this.infoDialog.dialog('open');
        }        
    };
}();
/* 公共的信息确认框*/
var commonConfirmDialog=function(){
    return {
        infoDialog:null,
        init:function(options){
            var defaultOptions={
                closeHandler:null,
                okHandler:null,
                cancelHandler:null
            };
            $.extend(defaultOptions,options);
            this.infoDialog=$('#common-info-dialog');
            if(this.infoDialog.length==0)
                {
                    this.infoDialog=$('<div></div>');
                }
            this.infoDialog.dialog({
                autoOpen:false,
                title:'确认',
                dialogClass:'ui-dialog-blue  ui-dialog-boxshadow',
                resizable:false,
                modal:true,        
                close:function(){
                    $(this).dialog('destroy');
                    if(defaultOptions.closeHandler)
                        {
                            defaultOptions.closeHandler();    
                        }
                },
                buttons:[{
                    'class':'btn blue',
                    'text':'确定',
                    'click':function(){
                        $(this).dialog('close');
                        if(defaultOptions.okHandler)
                            {
                                defaultOptions.okHandler();    
                            }
                    }
                    
                },{
                    'class':'btn',
                    'text':'取消',
                    'click':function(){
                        $(this).dialog('close');
                        if(defaultOptions.cancelHandler)
                            {
                                defaultOptions.cancelHandler();    
                            }
                    }
                    
                }]
            });
            return this.infoDialog;
        },
        show:function(){
            this.infoDialog.dialog('open');
        }    
    };
}();
var App=function(){
    return {
        //收缩、展开
        handlePortletTools:function () {   
            jQuery('body').on('click', '.portlet .tools .collapse, .portlet .tools .expand', function (e) {
                e.preventDefault();
                    var el = jQuery(this).closest(".portlet").children(".portlet-body");
                    if (jQuery(this).hasClass("collapse")) {
                        jQuery(this).removeClass("collapse").addClass("expand");
                        el.slideUp(200);
                    } else {
                        jQuery(this).removeClass("expand").addClass("collapse");
                        el.slideDown(200);
                    }
            });
        },
          // wrapper function to  block element(indicate loading)
        blockUI: function (el, centerY) {
            var el = jQuery(el); 
            el.block({
                    message: '<img src="../resources/images/loading.gif" align="">',
                    centerY: centerY != undefined ? centerY : true,
                    css: {
                        top: '10%',
                        border: 'none',
                        padding: '2px',
                        backgroundColor: 'none'
                    },
                    overlayCSS: {
                        backgroundColor: '#000',
                        opacity: 0.05,
                        cursor: 'wait'
                    }
                });
        },
        blockUINoMsg:function (el, centerY) {
            var el = jQuery(el); 
            el.block({
                    message: '',
                    centerY: centerY != undefined ? centerY : true,
                    css: {
                        top: '10%',
                        border: 'none',
                        padding: '2px',
                        backgroundColor: 'none'
                    },
                    overlayCSS: {
                        backgroundColor: '#000',
                        opacity: 0.05,
                        cursor: 'normal'
                    }
                });
        },

        // wrapper function to  un-block element(finish loading)
        unblockUI: function (el) {
            jQuery(el).unblock({
                    onUnblock: function () {
                        jQuery(el).removeAttr("style");
                    }
                });
        }        
    };
}();

//为IE8增加数组的indexOf方法
if (!Array.prototype.indexOf)
{
  Array.prototype.indexOf = function(elt /*, from*/)
  {
    var len = this.length >>> 0;  
     var from = Number(arguments[1]) || 0;
    from = (from < 0)
         ? Math.ceil(from)
         : Math.floor(from);
    if (from < 0)
      from += len; 
     for (; from < len; from++)
    {
      if (from in this &&
          this[from] === elt)
        return from;
    }
    return -1;
  };
}
 

//替换URL参数中可能会出现的特殊字符
var replaceSpeciChaInReq=function(key){
    var replacedArr=[
                ['%','%25'],
                 ['\\+','%2B'],
                 [' ','%20'],
                 ['/','%2F'],
                 ['\\?','%3F'],
                 ['#','%23'],
                 ['&','%26'],
                 ['=','%3D'],
                 ['<','&lt;'],
                 ['>','&gt;']
             ],reg='';
    for(var i=0;i<replacedArr.length;i++){
         reg=new RegExp(replacedArr[i][0],"g");
        key=key.replace(reg,replacedArr[i][1]);
    }
    return key;
}

//替换json参数中可能会出现的特殊字符 只处理尖括号防止script脚本
var replaceJsonChaInReq=function(key){
    var replacedArr=[                
                 ['<','&lt;'],
                 ['>','&gt;']
             ],reg='';
    for(var i=0;i<replacedArr.length;i++){
         reg=new RegExp(replacedArr[i][0],"g");
        key=key.replace(reg,replacedArr[i][1]);
    }
    return key;
}

//获取Cookie
function getCookie(name) 
{ 
    var arr,reg=new RegExp("(^| )"+name+"=([^;]*)(;|$)");
    if(arr=document.cookie.match(reg))
        return unescape(arr[2]); 
    else 
        return null; 
}



//部门员工选择的工具  
$.fn.orgUserChooser=function(){
    var dom=this;
    //添加人员    checkboxes:待添加的；   choosen:已被添加的;  unChosenOrgId:待添加的授权人机构Id;  isCheckedAll:是否全选
    var addAuthorizer=function(checkboxes,choosen,unChosenOrgId, isCheckedAll){
        
        var chosenArea=dom.find(".chosenAuthorizers");
        var chooseArea=dom.find(".orgUserchooseArea");
        var str='',
        userTemp=chosenArea.find('li').eq(0).get(0).outerHTML,//用户被选中的HTML模板
        classifyTemp=chosenArea.find('li').eq(1).get(0).outerHTML,//机构被选中的HTML模板
        unChosenUserId,//
        isChoosen=false;//
        if(isCheckedAll){//如果是全选的话加入部门
            var depart=chooseArea.find(".customDropdown.department .dropdown-menu span[data-orgid="+unChosenOrgId+"]");
            str +=classifyTemp.replace(/{classifyId}/,unChosenOrgId).replace(/hide/,'').replace(/{classifyName}/,$.trim(depart.html())+'全部用户');
            if(choosen.length>0){
                for(var j=0,k=choosen.length-1;j<=k;j++)
                {                                            
                    if(($(choosen[j]).data('type')=="user"&&$(choosen[j]).data('orgid')==unChosenOrgId)||($(choosen[j]).data('type')=="classify"&&$(choosen[j]).data('classifyid')==unChosenOrgId))
                        {            
                            $(choosen[j]).remove();
                        }
                }
            }
        }else{
            for(var i=0, l=checkboxes.length;i<l;i++)
                {
                    unChosenUserId=$(checkboxes[i]).data('userid');
                    isChoosen=false;
                    if(choosen.length>0)
                        {                
                            for(var j=0,k=choosen.length-1;j<=k;j++)
                                {                                            
                                    if($(choosen[j]).data('type')=="user"&&$(choosen[j]).data('userid')==unChosenUserId)
                                        {                                                    
                                            isChoosen=true;
                                            break;                                            
                                        }
                                }
                            if(!isChoosen)    //未被选中时
                            {
                                str+=userTemp.replace(/{orgId}/,unChosenOrgId).replace(/{userId}/,unChosenUserId).replace(/hide/,'').replace(/{userName}/,$.trim($(checkboxes[i]).parents('label').text()));
                            }
                        }
                    else
                        {
                            str+=userTemp.replace(/{orgId}/,unChosenOrgId).replace(/{userId}/,unChosenUserId).replace(/hide/,'').replace(/{userName}/,$.trim($(checkboxes[i]).parents('label').text()));
                        }
                    
                }
        }
        chosenArea.children('ul').append(str);
    };   //添加授权人员   
    
     //删除授权人员    checkboxes:待删除的；   choosen:已被添加的;    unChosenOrgId:已被添加的
    var removeAuthorizer=function(checkboxes,choosen, unChosenOrgId,otherCheckbox){
        
        var chosenArea=dom.find(".chosenAuthorizers");
        var chooseArea=dom.find(".orgUserchooseArea");
        var unChosenUserId;
        var haveToRemove=true;
        for(var i=choosen.length-1;i>=0;i--)
        {
            if($(choosen[i]).data('type')=="classify" && $(choosen[i]).data('classifyid')==unChosenOrgId)
                {                                                    //查看是否有classifyid为unChosenOrgId的部门 有就去掉 加入所有otherCheckbox里边选中的
                    haveToRemove=false;
                    $(choosen[i]).remove();
                    var str='',userTemp=chosenArea.find('li').eq(0).get(0).outerHTML;
                    for (var j = 0; j < otherCheckbox.length; j++) {
                        var curCheck=$(otherCheckbox[j]).find(":checkbox");
                        if(curCheck.is(':checked')){
                            chosenArea.children('ul').append(userTemp.replace(/{orgId}/,unChosenOrgId).replace(/{userId}/,curCheck.data('userid')).replace(/hide/,'').replace(/{userName}/,$.trim(curCheck.parents('label').text())));
                        }
                    }
                    break;
                }
        }
        if(haveToRemove){
            for(var i=checkboxes.length-1;i>=0;i--)
            {
                unChosenUserId=$(checkboxes[i]).data('userid');
                for(var j=choosen.length-1;j>=0;j--)
                    {                                        
                        if($(choosen[j]).data('userid')==unChosenUserId)
                            {                                                    
                                $(choosen[j]).remove();
                                break;
                            }
                    }
                
            }
        }
    };  //删除授权人员    checkboxes:待删除的；   choosen:已被添加的;
    var init=function(){
        
        //点击选择按钮，将选择控件打开
        dom.on('click','#chooseCateHref',function(e){
            dom.find(".orgUserchooseArea").toggle();
            e.stopPropagation ?e.stopPropagation():(e.cancelBubble=true);
        });
        
        //点击顶部自定义下拉框区域的下拉按钮显示选择区域
        dom.on('click','.dropdown-top',function(e){
            var customDropdown=$(this).parent();
            customDropdown.toggleClass('active');
            customDropdown.is('.department.active') && (customDropdown.next().addClass('active')); 
            e.stopPropagation ?e.stopPropagation():(e.cancelBubble=true);
        });   
        
        //点击部门下拉框的区域，显示其用户
        dom.on('click','.department>.dropdown-menu span',function(e){
            $(this).parents('.dropdown-menu').find('span').removeClass('curr');
            $(this).addClass('curr').parents('.department').children('.dropdown-top').children('.sp-txt').text($(this).text());
            $('.people').addClass('active');
            var orgId=$(this).data('orgid');
            $('.people>.dropdown-menu>ul').filter('[data-orgid='+orgId+']').removeClass('hide').siblings().addClass('hide');
            e.stopPropagation ?e.stopPropagation():(e.cancelBubble=true);
        });   
        
        //点击人选选择复选框
        dom.on('change','.people :checkbox',function(){
            var chosenArea=dom.find(".chosenAuthorizers");
            var chosen=chosenArea.find('li').not('.hide'),unChosenOrgId=$(this).parents('ul').data('orgid'),checkboxes=$(this);
            $(this).is('.checkAll') && (checkboxes=$(this).parents('ul').find('.checkboxes').prop('checked',$(this).prop('checked')).uniform());        
            var checkAll=$($(this).closest('li').siblings()[0]).find(':checkbox');    
            var otherCheckbox=$(this).closest('li').siblings().not(':first');
            if($(this).is(':checked'))   //添加
                {
                    !checkAll.is(':checked')&& !$(this).is('.checkAll') && otherCheckbox.find(':checkbox').length==otherCheckbox.find(':checked').length && (checkAll.prop('checked',true).uniform());
                    addAuthorizer(checkboxes,chosen,unChosenOrgId,checkAll.is(':checked'));

                }
            else                   //移除
                {
                    
                    checkAll.is(':checked')&& !$(this).is('.checkAll') && checkAll.removeAttr('checked').uniform();
                    removeAuthorizer(checkboxes,chosen,unChosenOrgId,otherCheckbox);
                }
        });   //部门-人员级联
        
        //点击已选的删除按钮
        dom.on('click','.chosenAuthorizers .choice-close',function(e){
            var userId=$(this).parent().data('userid');
            if(userId){//删除的是一个用户
                $('.people :checked').each(function(){
                    if($(this).data('userid')==userId)
                        {
                            $($(this).removeAttr('checked').uniform().parents('.fl').children()[0]).find('input').removeAttr('checked').uniform();
                            return;
                        }
                });
            }else{//删除的是一个部门的所有用户
                var classifyid=$(this).parent().data('classifyid');
                $('.people ul').each(function(){
                    if($(this).data('orgid')==classifyid)
                        {
                            $(this).find(":checked").removeAttr('checked').uniform();
                            return;
                        }
                });
                
            }
            $(this).parent().remove();
            e.stopPropagation ?e.stopPropagation():(e.cancelBubble=true);
        });
        $(document).bind('click',function(e){
             var e = e || window.event; //浏览器兼容性
                var elem = e.target || e.srcElement;
                while (elem) { //循环判断至跟节点，防止点击的是div子元素
                    if ($(elem).is('.customDropdown') || $(elem).is('.chosenAuthorizers')) {
                        return;
                    }
                    elem = elem.parentNode;
                }
                dom.find('.choose').hide().children().removeClass('active');                     
       });
    }();
}