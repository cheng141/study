// 全局的bootstrap-table的定义
var bstable={
     url:'',
	 method:'POST',
	 pageSize:5,
	 pageList:[5,10, 25, 50, 100],
	 clickToSelect:true,      //默认点击选择
	 singleSelect:false,      //默认只能选中一行，true可以选择多行
	 queryParams:function(params){ return params;},  //查询参数
	 columns: [],   //自定义列
     init_table:function(selector){
          var $table=$(selector).bootstrapTable({
		     url: bstable.url,                                   //请求后台的URL（*）
		     
		     method: bstable.method,                             //请求方式（*）
			 contentType:'application/x-www-form-urlencoded',    //POST提交的格式
			 striped: true,                                      //是否显示行间隔色
			 cache: false,                       //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
			 pagination: true,                   //是否显示分页（*）
			 sortable: true,                     //是否启用排序
			 sortOrder: "asc",                   //排序方式
			 sidePagination: "server",           //分页方式：client客户端分页，server服务端分页（*）
			 pageNumber: 1,                      //初始化加载第一页，默认第一页,并记录
			 pageSize: bstable.pageSize,           //每页的记录行数 10
			 pageList: bstable.pageList,           //可供选择的每页的行数（*）			 
			 queryParams : bstable.queryParams,   //得到查询的参数
			 columns: bstable.columns,           //自定义列
			 queryParamsType:'page',             //只要不为limit就行
			 clickToSelect:bstable.clickToSelect,  //默认点击选中
			 singleSelect:bstable.singleSelect,    //单行还是多行选择
			 
		  });
          return $table;		  
	 } 
 };

