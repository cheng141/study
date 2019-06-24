/**
 * 公用的js文件， 不要重复写代码
 */

// 初始化icheck表单样式
function initCheckBoxStyle() {
	$('input:not(table input)').iCheck({
		checkboxClass : 'icheckbox_square-blue', // checkbox样式
		radioClass : 'iradio_square-blue', // radio样式
		increaseArea : '20%' // optional
	}); 

}

//重置表单
function resetForm(selected){
	 
	//  http://www.bootcss.com/p/icheck/ 
	 $(selected +' input').iCheck('uncheck');  //  icheck 移除 checked 状态
	 
	// jquery-->dom    表单自带的reset()方法  https://blog.csdn.net/w410589502/article/details/55259780
	$(selected)[0].reset(); 
	 
}

//表格的简单的格式化操作  value值，row当前json,index下标
function normalStateFunc(value,row,index){ 
	if(value== 1){
		return '<span   class="label-lg label-primary">正常</span>';
	}else{
		return '<span   class="label-lg label-danger">禁用</span>';		
	}
}