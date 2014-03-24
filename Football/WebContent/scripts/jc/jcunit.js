function tdrowadd() {
	var tb = document.getElementById("tbunit");
	var insert = tb.insertRow(tb.rows.length);
	var mynewcell = insert.insertCell(0);
	mynewcell.innerHTML = " <td><input type='text' name='unittype' value='' /></td>";
	mynewcell = insert.insertCell(1);
	mynewcell.innerHTML = " <td><input type='text' name='unitlevel' value='' /></td>";
	mynewcell = insert.insertCell(2);
	mynewcell.innerHTML = " <td><input type='text' name='unitname'  value='' /></td>";
	mynewcell = insert.insertCell(3);
	mynewcell.innerHTML = " <td><input type='text' name='unitaddress' value='' /></td>";
	mynewcell = insert.insertCell(4);
	mynewcell.innerHTML = " <td><input type='button' name='btnrowdel' id='btnrowdel' value='删除' onclick='delrow(this)'/></td>";

	// var selectobj = document.getElementsByName("drpcourse");
	// var curselect = selectobj[selectobj.length - 1];
	// var arrtype = eval('arrtype_' + id);
	// for (var i = 0; i < arrtype.length; i++) {
	// curselect.options.add(new Option(arrtype[i].split('_')[1],
	// arrtype[i].split('_')[0]));
	// }
}
function delrow(btn) {
	var tb = document.getElementById("tbunit");
	tb.deleteRow(btn.parentNode.parentNode.rowIndex);
}
function checkdata() {
	savedata();
	//return checktb('tb1');
}
function savedata() {
	var strtb = '';
	strtb += getelementsvaluestr('unittype');
	strtb += '&' + getelementsvaluestr('unitlevel');
	strtb += '&' + getelementsvaluestr('unitname');
	strtb += '&' + getelementsvaluestr('unitaddress');
	document.getElementById("strtb2").value=strtb;
}
function getelementsvaluestr(ename) {
	var obj = document.getElementsByName(ename);
	var strobj = ename + '=';
	for (var i = 0; i < obj.length; i++) {
		strobj += obj[i].value + ",";
	}
	strobj = strobj.substring(0, strobj.length - 1);
	return strobj;
}