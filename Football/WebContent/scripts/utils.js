/*
 * Copyright (C) 2008 Great Eastern Life Assurance (China) Co. Ltd. 
 * All rights reserved.
 *
 * 2007-6-11 下午02:46:03
 */

/**
 * @author <a href="mailto: chenshibing@lifeisgreat.com.cn">Shibing Chen</a>
 */


/**
 * 将格式为yyyyMMdd或yyyy<C>MM<C>dd(<C>为分隔符, 如'-'或'/'等)的日期
 * 转化为标准的日期格式yyyy-MM-dd.
 */
function formatDate(/*Element*/field) {
	var sDate = field.value;
	
	if (!sDate || (sDate == "")) {//undefined or length of zero
		return "";
	}
	
	//date format: yyyyMMdd or yyyy-MM-dd or yyyy/MM/dd
	if ((sDate.length != 6) && (sDate.length != 7) && (sDate.length != 8) && (sDate.length != 10)) {
		alert("日期长度非法！");
		field.focus();
		return;
	}
	
	var year;
	var month;
	var date;
	
	if (sDate.length == 7 || sDate.length == 6) {
//		year = sDate.substring(0, 2);
//		month = sDate.substring(3, 4);
//		date = sDate.substring(5);
		var  str = sDate.split("-");
		if(str.length == 3)
		{
			year = str[0];
			month = str[1];
			date = str[2];
		}
	}
	
	if (sDate.length == 8) {
		var  str = sDate.split("-");
		if(str.length == 3)
		{
			year = str[0];
			month = str[1];
			date = str[2];
		}
		else
		{
			year = sDate.substring(0, 4);
			month = sDate.substring(4, 6);
			date = sDate.substring(6, 8);
		}
	}

	if (sDate.length == 10) {
		year = sDate.substring(0, 4);
		month = sDate.substring(5, 7);
		date = sDate.substring(8);
	}
	
	if (!isValidDate(year, month, date)) {
		alert("日期非法!");
		return;
	}
	
	var full = year + "-" + month + "-" + date;
	field.value = full;
}

/**
 * Need test. 
 */
function isValidDate(year, month, date) {
	if (month < 1 || month > 12 ) {
		return false;
	}
	
	if (date < 1 || date >31) {
		return false;
	}
	
  	// 闰年的条件: 
  	//    1. 能被4整除, 但不能被100整除; 
 	//    2. 能被400整除.
  	var leapyear = (year % 4 == 0 && (year % 100 != 0 || year % 400 == 0));
  
  	// 30天的月份但有31天
  	if (date == 31 && (month == 4 || month == 6 || month == 9 || month == 11)) {
  		return false; 
  	}
  	
  	// 二月份有30天或者31天
  	if (date >= 30 && month == 2) {
  		return false; 
  	}
  	
  	// 平年二月份有29天
  	if (date == 29 && month == 2 && !leapyear) {
  		return false; 
  	}
  
  	return true;
}

/**
 * 检查字符串是否是空白.
 */
function isBlank(/*String*/sValue) {
	if ( (sValue == "") || (!sValue) ) {
		return true;
	} else {
		return false;
	}
}

/**
 * 判断传入的值是否是数字. 是数字返回<tt>true</tt>, 否则返回<tt>false</tt>.
 *
 * @param it 待判断的参数.
 */
function isNumber(it) {
	return (it instanceof Number || typeof it == 'number');
}

/**
 * 表单验证的通用函数. 函数依赖prototype来获取表单元素和域元素.
 *
 * @param id 表单的ID属性.
 * @param map 定义需要校验的字段. 其结构形如: 
 *            new Array(
 *            	new Array('field1', 'message1'),
 *              new Array('field2', 'message2'),
 *              ....
 *            )
 *            其中field*指需要进行验证的域的id属性值, 而message*指当验证未通过展现的错误信息.
 */
function checkForm(/*String*/id, /*Array*/map) {
	var form = $(id);

	var eVictim; // 第一个出错域
	var sMessage = ''; // 错误消息
	var bError = false;
	var count = 0;
	for (var i = 0; i < map.length; i += 1) {
		var aItem = map[i];
		var eField = $(aItem[0]);
		if (isBlank(eField.value)) {
			count = count + 1;
			if (!bError) { // 第一个错误
				eVictim = eField;
				bError = true;
			}
			var sTemp = count + '. ' + aItem[1] + '\n';
			sMessage = sMessage + sTemp;
		}
	}
	
	if (bError) { // 存在错误
		alert(sMessage);
		eVictim.focus();
		
		return;
	}
	
	Form.enable(form);	
	form.submit();	
}

function isFormValid(/*String*/id, /*Array*/map) {
	var form = $(id);

	var eVictim; // 第一个出错域
	var sMessage = ''; // 错误消息
	var bError = false;
	var count = 0;
	for (var i = 0; i < map.length; i += 1) {
		var aItem = map[i];
		var eField = $(aItem[0]);
		if (isBlank(eField.value)) {
			count = count + 1;
			if (!bError) { // 第一个错误
				eVictim = eField;
				bError = true;
			}
			var sTemp = count + '. ' + aItem[1] + '\n';
			sMessage = sMessage + sTemp;
		}
	}
	
	if (bError) { // 存在错误
		alert(sMessage);
		eVictim.focus();
		
		return false;
	}
	
	return true;
}

/**
 * 校验邮政编码.
 */
function checkPostCode(/*Element*/field) {
	var length = 6;
	var message = '邮政编码长度错误';
	var value = field.value;
	if (value.length != length) {
		alert(message);
		field.focus();
	}
	
	return;
}

/**
 * Email合法性校验.
 */
function checkEmail(/*Element*/field) {
	var email = field.value;
	if (email == "") {
		return;
	}
	
	var filter = /^([\w-]+(?:\.[\w-]+)*)@((?:[\w-]+\.)*\w[\w-]{0,66})\.([a-z]{2,6}(?:\.[a-z]{2})?)$/i
	var message = "电子邮件地址非法";
	
	if (!(filter.test(email))) {
		alert(message);
		field.focus();
	}
	
	return;
}


/**
 * 修复<a href="xxx"><input type="button"/></a>不能在IE下工作的情况.
 * 其方法是在<a></a>标签上加一个id, 在button上附加一个onclick事件. 如:
 * <a id="url" href="xxx"><input type="button" onclick="derect('url')"/>
 */
function direct(/*String*/url) {
	var e = $(url);
	var href = e.getAttribute('href');
	location.href = href;
}

/**
 * 用于验证radio button，checkbox是否至少有一个被选中
 * element: radio或checkbox元素
**/
function hasChecked(element) {
   if (element == null) {
     return false;
   }  
   
   if (element != null && element.length > 1) {
	   for (var i = 0; i < element.length; i++) {//多个checkbox或radio button
	       var checked = element[i].checked;
	       if (checked == true) {
	         return true;
	       }
	   }
   }   
   else if (element != null) {//只有一个checkbox或radio button时，element就不再是一个数组      
      return element.checked;
   }
   return false;
}

/**
 * disable all buttons
 **/
function disableButton() {
	var input = document.body.getElementsByTagName("INPUT");
	for (var i = 0; i < input.length; i++) {
		if (input[i].type == "button") {
			input[i].disabled = "true";
		}
	}
	return false;
}

/**function Option(key, value) {
	this.key = key;
	this.value = value;
}

Option.prototype = {
	getKey : function() {
		return this.key;
	}, 
	setKey : function(key) {
		this.key = key;
	}, 
	
	getValue : function() {
		return this.value;
	}, 
	setValue : function(value) {
		this.value = value;
	}
};*/

var utils = new Object();

utils.addOption = function(dest, value, text) {
	var element = $(dest);
	var option = document.createElement('option');
	option.setAttribute('value', value);
	var eText = document.createTextNode(text);
	option.appendChild(eText);
	element.appendChild(option);
}

utils.enable = function(id, className) {
	$(id).enable();
	$(id).removeClassName(className);
}

utils.disable = function(id, className) {
	$(id).addClassName(className);
	$(id).disable();
	//$(id).value = '';
}

/**
 * 检查表单中是否已经有单选按钮已经选中.
 *
 * @param formId 表示的id属性值.
 * @return 有选择返回<tt>true</tt>, 否则返回<tt>false</tt>.
 */
utils.hasRadioChecked = function(/*String*/formId) {
	var form = $(formId);
	
	var bSelect = false;
	var aRadio = form.getInputs('radio');
	for (var i = 0; i < aRadio.length; i++) {
		if (aRadio[i].checked) {
			bSelect = true;
		}
		
		if (bSelect) {
			return true;
		}
	}
	
	return false;
}

/**
 * 设置select的值.
 */
utils.setValue = function(id, value) {
	var select = $(id);
	var aOption = select.getElementsByTagName('option');
	for (var i = 0; i < aOption.length; i++) {
		var entry = aOption[i];
		var k = entry.getAttribute('value');
		var node = entry.firstChild;
		if (node == null) {
			continue;
		}
		var v = node.nodeValue;
		if (v == value) {
			select.value = k;
		}
	}
}

utils.getCheckedRadio = function(/**/formId) {
	var form = $(formId);
	
	var aRadio = form.getInputs('radio');
	var result = null;
	for (var i = 0; i < aRadio.length; i++) {
		var entry = aRadio[i];
		if (entry.checked) {
			result = entry;
			break;
		}
	}
	
	return result;
}

/**
　* 判断<code>sText</code>是否是数字串.
 */
utils.isNumber = function(sText) {
	if (isNaN(sText)) {
		return false;
	} else {
		return true;
	}
}


/**
 * 判断是否为数字
 * @param file
 * @returns {Boolean}
 */
function checkNumber(file) {
	if (isNaN(file.value)) {
		alert("请输入数字！");
		file.focus();
		return false;
	} else {
		return true;
	}
}

/**
 * 判断是否为空
 * @param file
 * @returns {Boolean}
 */
function checkEmpty(file) {
	if (file.value == "") {
		alert("姓名不能为空！");
		file.focus();
		return false;
	}
	return true;
}
