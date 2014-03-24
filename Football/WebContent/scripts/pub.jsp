<script type="text/javascript">
function getstr(str) {
    var s = str.replace(/&/g, "");
    s = s.replace(/#/g, "");
    return s;
}
function GetQueryString(name) {
    var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)");
    var r = window.location.search.substr(1).match(reg);
    if (r != null) return unescape(r[2]); return null;
}
function showmsg(str) {
    art.dialog({
        lock: true,
        content: str,
        ok: function () {
            return true;
        }
    });
}
function showmsg2(str)
{
    showmsg2('提示',str);
}
function showmsg2(title,str) {
    art.dialog({
        lock: false,
        width: 320,
        title:title,
        content: str,
        ok: function () {
            return true;
        }
    });
}
function showtip(str) {
    art.dialog.tips(str, 1.5);
}
function showtip(str, time) {
    art.dialog.tips(str, time);
}
function showtip2(str) {
    art.dialog.tips(str, 1.5);
    setTimeout('originreload()', 1000);
}
function showtip3(str) {
    art.dialog.tips(str, 1);
    art.dialog.close();
}
function delqr(cnt) {
    return confirm('您确定删除"' + cnt + '"吗？');
}
function openviewpage(url, strtitle, wid, hei) {
    art.dialog.open(url, {
        id: 'pgv123',
        title: strtitle, lock: false, width: wid, height: hei,
        ok: function () {
            this.close();
            return false;
        }
    });
}

function isInt(str) {
    var reg = /^(-|\+)?\d+$/;
    return !isNaN(str);
}
function isFloat(ch) {
    var re = /^\d+(\.\d+)?$/;
    return re.test(ch)
}
function isEmail(tstr) {
    re1 = /([\w\-\.])+[@]{1}([\w\-])+(\.[\w\-])+/;
    rp1 = tstr.search(re1);
    re2 = /[^a-zA-Z0-9_\.\-\@]/;
    rp2 = tstr.search(re2);
    if (rp1 == -1 || rp2 != -1)
        return false;
    else
        return true;
}
function checkctl(ctlid) {
    var msg = '';
    var m1 = ckctlmsg($("#" + ctlid));
    if (m1.length > 0)
        msg += $("#" + ctlid).prev().html() + m1 + "<br/>";
    if (msg.length > 0) {
        showtip(msg, 2);
        return false;
    }
    else
        return true;
}
function ckctlmsg(ctl) {
    var ck = ctl.attr("ck");//ck为检查控件的标识，rq为必须项，int为数字,flt为浮点。
    if (ck != null) {
        var ss = new Array()
        ss = ck.split(" ");
        var m1 = '';
        var tv = ctl.val();
        for (x in ss) {
            if (ss[x] == "rq") {
                if (tv.length == 0) {
                    m1 += "不能为空！";
                }
            }
            else if (ss[x] == "int") {
                if (tv.length > 0 && !isInt(tv)) {
                    m1 += "必须为数字！";
                }
            }
            else if (ss[x] == "flt") {
                if (tv.length > 0 && !isFloat(tv)) {
                    m1 += "必须为浮点型！";
                }
            }
        }
        return m1;
    }
    else
        return '';
}
function checkctls(ctlid) {
    var msg = '';//ck为检查控件的标识，rq为必须项，int为数字。flt为浮点。
    $("#" + ctlid + " input").each(
             function () {
                 m1 = ckctlmsg($(this));
                 if (m1.length > 0)
                     msg += $(this).prev().html() + m1 + "<br/>";
             }
          );
    if (msg.length > 0) {
        showtip(msg, 2);
        return false;
    }
    else
        return true;
}
function checktb(tableid) {
    var msg = '';
    $("#" + tableid + " input").each(
             function () {
                 m1 = ckctlmsg($(this));
                 if (m1.length > 0)
                     msg += $(this).parent().prev().html() + m1 + "<br/>";
             }
          );
    $("#" + tableid + " textarea").each(
             function () {
                 m1 = ckctlmsg($(this));
                 if (m1.length > 0)
                     msg += $(this).parent().prev().html() + m1 + "<br/>";
             }
          );
    if (msg.length > 0) {
        showtip(msg, 2);
        return false;
    }
    else
        return true;
}

//对Date的扩展，将 Date 转化为指定格式的String   
//月(M)、日(d)、小时(h)、分(m)、秒(s)、季度(q) 可以用 1-2 个占位符，   
//年(y)可以用 1-4 个占位符，毫秒(S)只能用 1 个占位符(是 1-3 位的数字)   
//例子：   
//(new Date()).Format("yyyy-MM-dd hh:mm:ss.S") ==> 2006-07-02 08:09:04.423   
//(new Date()).Format("yyyy-M-d h:m:s.S")      ==> 2006-7-2 8:9:4.18   
Date.prototype.Format = function(fmt)   
{ //author: meizz   
var o = {   
"M+" : this.getMonth()+1,                 //月份   
"d+" : this.getDate(),                    //日   
"h+" : this.getHours(),                   //小时   
"m+" : this.getMinutes(),                 //分   
"s+" : this.getSeconds(),                 //秒   
"q+" : Math.floor((this.getMonth()+3)/3), //季度   
"S"  : this.getMilliseconds()             //毫秒   
};   
if(/(y+)/.test(fmt))   
fmt=fmt.replace(RegExp.$1, (this.getFullYear()+"").substr(4 - RegExp.$1.length));   
for(var k in o)   
if(new RegExp("("+ k +")").test(fmt))   
fmt = fmt.replace(RegExp.$1, (RegExp.$1.length==1) ? (o[k]) : (("00"+ o[k]).substr((""+ o[k]).length)));   
return fmt;   
}  


</script>