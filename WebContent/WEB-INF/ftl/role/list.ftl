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
							<li class="active">角色列表</li>
						</ul>  
					</div>
			 			
			 	 <div class="page-content">			 	 							
			          
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
    
     
     
    <!-- 新增、修改模态框 -->
	<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
	  <div class="modal-dialog" role="document">
	    <div class="modal-content">
	      <div class="modal-header">
	        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
	        <h4 class="modal-title" id="myModalLabel">标题内容</h4>
	      </div>
	      <div class="modal-body">
	           <!-- form表单开始-->                    
	            <form id="editForm" class="form-horizontal">
					  <div class="form-group">
					    <label   class="col-sm-2 control-label">角色名称</label>
					    <div class="col-sm-10">
					      <input type="text" class="form-control" id="edit_roleName" name="roleName" placeholder="请输入角色名称">
					    </div>
					  </div> 
					  
					   <div class="form-group">
					    <label   class="col-sm-2 control-label">角色标识</label>
					    <div class="col-sm-10">
					      <input type="text" class="form-control" id="edit_roleCode" name="roleCode" placeholder="请输入角色唯一标识">
					    </div>
					  </div> 
					  
					  <div class="form-group">
					    <label   class="col-sm-2 control-label">状态</label>
					    <div class="col-sm-10">
					      <div class="radio">
						      <input type="radio"    name="state" value="1"  > 启用
							  <input type="radio"    name="state" value="0" > 禁用
						  </div>
					    </div>
					</div> 	
					
					  		  
				</form>               
	           <!-- form表单结束 -->                       
	      </div>
	      <div class="modal-footer">
	        <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
	        <button type="button" class="btn btn-primary" id="btn_save">保存</button>
	      </div>
	    </div>
	  </div>
	</div>
     
     
</body>
   <#include "../common/js.ftl" >
    
    
	   <script type="text/javascript">
	   
	        //当前主健的值，如果0代表新增，否则代表修改，公共变量
	        var primaryKey=0;  
	   
	   
		  $(function() {
			     
			   initData();
			   
			   //初始化icheck样式
			   initCheckBoxStyle();
			   
			   //icheck如果发生变化，就要自动手动的触发验证事件
			   $("#editForm input[name='state']").on('ifClicked', function(event){
                   $("#editForm").data("bootstrapValidator").updateStatus("state",  "VALID",  null );
				});
			   
			   //初始化表单验证规则
			   initValidator();
			   
			   //新增按钮
			   $("#btn_add").click(addForm); 
			   
			    //修改按钮
			   $("#btn_edit").click(editForm); 
			   
			   //点击保存按钮
			   $("#btn_save").click(saveForm);
			   
			});
			
			//显示新增模态框
			function addForm(){	 
			     //这是新增操作
			     primaryKey=0;
			      
			     $("#myModalLabel").text("新增数据");
			      //重置表单
			      resetForm("#editForm");	
			      
			       //关闭模态框之前， 重置验证规则
			      $('#myModal').on('hide.bs.modal', function () { 					    
			           $("#editForm").data('bootstrapValidator').resetForm(true); 
				 });		   	   
			   	   
			      //显示			      
			      $('#myModal').modal({
					  keyboard: true,   // esc关闭
					  show: true,       //显示
					  backdrop:'static'  //只能点击关闭按钮，才关闭
				  }); 
				   
				  
			 }
			 
			 //显示修改模态框
			function editForm(){	
			   
			      //判断是否选中了行
			    var arr= $("#tb").bootstrapTable('getSelections');
			    
			    if(arr.length !=1){
			       //提示请选择要修改的数据
			       BootstrapDialog.show({
			            title: '警告',
			            message: '请选择要修改的数据!',
			            type:'type-warning'
			        });
        
			       return;
			    } 
			     
			      
			     $("#myModalLabel").text("编辑数据");
			     
			     //重置表单
			     resetForm("#editForm");
			     
			     //关闭模态框之前， 重置验证规则
			      $('#myModal').on('hide.bs.modal', function () {  
			           $("#editForm").data('bootstrapValidator').resetForm(true);
				 });
			     
			     var jsonObj=arr[0];
			     console.log(jsonObj);
			   	 //还原你要修改数据  			  
			     primaryKey=jsonObj.roleId;
			     
			     $("#edit_roleName").val( jsonObj.roleName);
			     $("#edit_roleCode").val(jsonObj.roleCode);
			     //状态  $(选择器).iCheck('check');
			     $("input[name='state'][value='"+jsonObj.state+"']").iCheck('check');
			      
			     
			      //显示			      
			      $('#myModal').modal({
					  keyboard: true,   // esc关闭
					  show: true,       //显示
					  backdrop:'static'  //只能点击关闭按钮，才关闭
				  }); 
				  
			 }
			
			//初始化表格配置
			function initData(){ 
			 
			   //设定请求地址
			   bstable.url="${ctx}/role/search";
			  //配置列
			   bstable.columns=[
			       {  radio:true},
			       {field:"roleId", title:"角色编号"},
			       {field:"roleName", title:"角色名称"},
			       {field:"roleCode", title:"角色标识"},
			       {field:"state", title:"状态" , formatter:normalStateFunc}
			   ]; 
			   
			   //调用表格
			   var tb=bstable.init_table("#tb"); 
			}
			
			
			//初始化表单验证规则
			function initValidator(){
			
			   $('#editForm').bootstrapValidator({
				        message: '请输入值',
				        feedbackIcons: {
				            valid: 'glyphicon glyphicon-ok',   // 验证通过的图标，可以自己改
				            invalid: 'glyphicon glyphicon-remove',  //验证不通过的图标，可以自己改
				            validating: 'glyphicon glyphicon-refresh' //验证中的图标,可以自己改
				        },
						//验证字段，验证表单里面的  <input  name="字段名" >
				        fields: { 
							  roleName: {
			                      message: '内容不能为空',
			                      validators: {
			                         notEmpty: {
					                     message: '该值不能为空'
					                  },
					                  stringLength: {
					                        min: 2,
					                        max: 30,
					                        message: '该值的长度必须在2到30个字符串之间'
					                  },
			                      }
			                 },
				             roleCode: {
			                      message: '内容不能为空',
			                      validators: {
			                         notEmpty: {
					                      message: '该值不能为空'
					                  } 
			                      }
			                 },
			                 state: {
			                      message: '请选择值',
			                      validators: {
			                         notEmpty: {
					                      message: '请选择值'
					                  } 
			                      }
			                 },
				       }//fields结束
				});	 
			
			}
			
			//保存表单提交
			function saveForm(){ 
			   //判断是否验证通过
			   var bv=$("#editForm").data('bootstrapValidator'); 
		        //手动触发验证
		        bv.validate(); 
		        if(bv.isValid()){ 
		             //真正的保存数据		               
		              ajaxSaveData();
		        } 			
			}
			
			//真正的保存数据	
			function ajaxSaveData(){
			  //序列化数据
			  var dataStr= $("#editForm").serialize(); 
			  
			  //拼接主键
			  dataStr+="&roleId="+primaryKey;
			  
			  //写ajax语法
			  $.ajax({
				   type: "POST",
				   url: "${ctx}/role/save",
				   data: dataStr,
				   dataType:"json",
				   success: function(resp){				       
				       //{"code":0,"message":"保存数据成功"}
				       
				       if(resp.code===0){
				           //隐藏模态框
				            $('#myModal').modal('hide');
				            
				           //成功了，加载数据
				           $("#tb").bootstrapTable('refresh');
				           
				       }else{
				           //失败了要提示
				            BootstrapDialog.show({
						            title: '操作失败',
						            message:  resp.message,
						            type:'type-danger'
						     });        
				       }
				       
				   }
			   });
			   
			}
		 
		</script>
</html>