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
