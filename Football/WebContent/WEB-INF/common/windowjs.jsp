<script type="text/javascript">
  var win = null;
  var index = 1;
	function openDialog(id) {
	  Dialog.alert($(id).innerHTML, {className: "alphacube",  width:250, id: "d" + index})
	  index++;
  }
  
  function lastDialog(id) {
	  Dialog.confirm($(id).innerHTML, {className: "alphacube",  width:250, okLabel: "Close All", ok: closeAllModalWindows})
  }
  
  function closeAllModalWindows() {
    Windows.closeAllModalWindows();
    return true;
  }
</script>