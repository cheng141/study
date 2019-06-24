<html>
<head>  
  <meta charset="UTF-8">
   <meta name="viewport" content="width=device-width, initial-scale=1.0">
   <meta http-equiv="X-UA-Compatible" content="ie=edge">
  <title>首页</title>
  
  <#include "../common/css.ftl" >
  
  <style>
     .fixed-table-toolbar{
      height:60px;
     }
  </style>
</head>

<body> 
    
      <#include "../common/header.ftl">

		<div class="main-container" id="main-container"  data-height="460">
		  	
		  	<!--导航区-->
		  	<#include "../common/sliderbar.ftl">
		  	
			 <!-- 内容区-->
			 <div class="main-content">	
			     <!--导航-->
			     <div class="breadcrumbs" id="breadcrumbs">	
						<ul class="breadcrumb">
							<li>
								<i class="icon-home home-icon"></i>
								<a href="#">首页</a>
							</li>
							<li class="active">客户信息列表</li>
						</ul>  
					</div>
			 			
			 	 <div class="page-content">		
			 	    
			 	    <!--查询面板-->
			 	    <div class="panel panel-primary">
					  <div class="panel-heading">查询条件</div>
					  <div class="panel-body">
					    
					      <form class="form-inline">
						 	  <div class="form-group">
							    <label>客户名称</label>
							    <input type="text" class="form-control"  name="cusName" placeholder="请输入客户名称">
							  </div>
							  
							  <div class="form-group">
							    <label>客户类型</label>
							    <select class="form-control" name="typeId">
							       <option value="0">---全部---</option>
							       
							       <#list arrLevel as b>
							         <option value="${b.id}">${b.name}</option>
							       </#list>
							       
							    </select>							     
							  </div>
							  
							  <div class="form-group">
							    <label>联系电话</label>
							    <input type="text" class="form-control"  name="tel" placeholder="请输入联系电话">
							  </div>
							  
							  <div class="form-group">
							    <label>负责人</label>
							    <input type="text" class="form-control"  name="head" placeholder="请输入负责人名称">
							  </div>
							  
							  　 <button type="button" id="btnSearch" class="btn btn-primary">查询</button>
							  
							  
						   </form>
					    
					    </div>
					</div>
			 	 	 	 								 	 							
			          
			          <!--表格开始 bootstrap-table的格式 -->
			          
			          <table id="tb"  data-height="550"  data-toggle="tb" data-toolbar="#toolbar" > 
					  </table>
						    
			          <!--表格结束 -->
			          
			          <!-- 搜索工具条-->
			         
					     <div id="toolbar" class="btn-gro v]
					     sup">
				            <button id="btn_add" type="button" class="btn btn-primary">
				                <span class="icon-ok-circle " aria-hidden="true"></span>新增
				            </button>
				            <button id="btn_edit" type="button" class="btn btn-success">
				                <span class="icon-edit" aria-hidden="true"></span>修改
				            </button>
				            <button id="btn_delete" type="button" class="btn btn-danger">
				                <span class="icon-remove" aria-hidden="true"></span>删除
				            </button>
				        </div> 
			          
			     </div>
			 </div>				 
				
		 </div><!-- /.main-container-inner -->

			<a href="#" id="btn-scroll-up" class="btn-scroll-up btn btn-sm btn-inverse">
				<i class="icon-double-angle-up icon-only bigger-110"></i>
			</a>
		</div><!-- /.main-container -->
    
     
     
    
     
</body>
   <#include "../common/js.ftl" >
    
    
	   <script type="text/javascript">
	   
	        //当前主健的值，如果0代表新增，否则代表修改，公共变量
	        var primaryKey=0;  
	   
	   
		  $(function() {
			     
			   initData();
			    
			   
			});
		 
			
			//初始化表格配置
			function initData(){ 
			 
			   //设定请求地址
			   bstable.url="${ctx}/customer/search";
			  //配置列
			   bstable.columns=[
			       {  radio:true},
			       {field:"cusName", title:"客户名称"},
			       {field:"head", title:"负责人"},
			       {field:"tel", title:"联系电话"},
			       {field:"levelName", title:"客户等级" },
			       {field:"regionName", title:"区域" },
			       {field:"credit", title:"信誉度" },			       
			       {field:"fullness", title:"满意度" }
			   ]; 
			   
			   //调用表格
			   var tb=bstable.init_table("#tb"); 
			}
			
		 
		</script>
</html>