
/** 单元保费和保额 */
var amount = 500000;
var premium = 20;

function savePolicy() {
    if (requiredInputValidate()) {
		disableButton();
		
		$("amount").enable();
		$("premium").enable();
		
		var form = document.getElementById("policyEntry");
		form.action = "save.jspa";
		form.target="_self";
		form.submit();
	}
}

function backToSearch() {

	var form = document.getElementById("policyDetail");
	form.action = "back.jspa";
	form.submit();
}

function fillLength() {
	var voucherCode = $("voucherCode").value.strip();

	if ((voucherCode.length == 0) 
		|| (voucherCode.length == 8)) {
	
		return;
	} else if (voucherCode.length == 15) {
		var typeCode = voucherCode.substring(12, 15);
		if (typeCode != "006") {
			alert("凭证号码错误！");
			$('voucherCode').focus();
			return;
		}
	} else {
		alert("凭证号码长度错误！");
		$('voucherCode').focus();
		return;
	}
}

function beneficiaryInfoDisabled() {
	$("beneficiaryName").value = "";
	$("beneficiaryName").disable();
	$("beneficiaryName").addClassName('disabled');
	
	$("relationshipId").value = "";
	$("relationshipId").disable();
	$("relationshipId").addClassName('disabled');
}

function beneficiaryInfoEnabled() {
	$("beneficiaryName").enable();
	$("beneficiaryName").removeClassName('disabled');
	
	$("relationshipId").enable();
	$("relationshipId").removeClassName('disabled');
}

function adjustAmountAndPremium() {

	var count = $("count").value;
	
	if (count == "") {
		count = 1;
	}

	$("amount").value = amount * count;
	$("premium").value = premium * count;
	$("amount").value = formatCurrency($("amount").value);
	$("premium").value = formatCurrency($("premium").value);
	
	if ($("legalBeneficiary1").checked) {
		$("beneficiaryName").disable();
		$("beneficiaryName").value = "";
		$("beneficiaryName").addClassName('disabled');
		
		$("relationshipId").disable();
		$("relationshipId").value = "";
		$("relationshipId").addClassName('disabled');
	}

	if ($("saved").value == 'true') {
		print();
	}
}

function formatCurrency(num) {
	num = num.toString().replace(/\$|\,/g,'');
	
	if(isNaN(num))
		num = "0";
	
	num = Math.floor(num*100+0.50000000001);
	num = Math.floor(num/100).toString();
	
	for (var i = 0; i < Math.floor((num.length-(1+i))/3); i++)
		num = num.substring(0,num.length-(4*i+3))+','+num.substring(num.length-(4*i+3));
		
	return (num);
}

function formatMoney() {

	$("amount").value = formatCurrency($("amount").value);
	$("premium").value = formatCurrency($("premium").value);
}

function print() {
	$("saved").value = 'false';
	
	resetForm();

	var form = document.getElementById("policyEntry");
	form.action = "print.jspa";
	form.target="__blank";
	form.submit();
}

function checkAndFormatDate(date1, date2) {

	if (($(date1).value != "") && ($(date2).value != "") 
		&& ($(date1).value > $(date2).value)) {
	
		alert("起始日期必须小于等于终止日期！");
	}

	formatDate(date1);
	formatDate(date2);
}

function resetForm() {

	$("voucherCode").value = "";
	$("insuredName").value = "";
	$("flightNumber").value = "";
	$("boardingTime").value = "";
	$("count").value = "1";
	$("insuredTelephone").value = "";
	$("insuredCertiType").value = "";
	$("insuredCertiCode").value = "";
	
	if ($("legalBeneficiary2").checked) {
		$("beneficiaryName").value = "";
		$("relationshipId").value = "";
	}
	
	adjustAmountAndPremium();
}

function requiredInputValidate() {
	var map = new Array(
		new Array("voucherCode", '凭证号码是必录项'), 
		new Array("insuredName", '被保险人姓名是必录项'), 
		new Array("flightNumber", '航班号是必录项'), 
		new Array("boardingTime", '登机日期是必录项'), 
		new Array("count", '份数是必录项'), 
		new Array("insuredCertiType", '被保险人证件类型是必录项'), 
		new Array("insuredCertiCode", '被保险人证件号码是必录项'));
		
	if ($("legalBeneficiary2").checked) {
		map.push(new Array("beneficiaryName", '受益人姓名是必录项'));
		map.push(new Array("relationshipId", '受益人与被保险人关系是必录项'));
	}
	
	var form = document.getElementById("policyEntry");
	return isFormValid(form, map);
}