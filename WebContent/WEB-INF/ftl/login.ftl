<html>
<head>  
  <meta charset="UTF-8">
   <meta name="viewport" content="width=device-width, initial-scale=1.0">
   <meta http-equiv="X-UA-Compatible" content="ie=edge">
  <title>CRM后台登录</title>
  
   <!-- basic styles -->
   <link type="text/css" href="${ctx}/assets/css/bootstrap.min.css" rel="stylesheet" />
   <link type="text/css" rel="stylesheet" href="${ctx}/assets/css/font-awesome.min.css" />
  <!-- bootstrap-validator-->
   <link type="text/css" rel="stylesheet" href="${ctx}/assets/bootstrapvalidator/css/bootstrapValidator.css" />
    <!-- bootstrap-dialog-->
        <link type="text/css" rel="stylesheet" href="${ctx}/assets/dialog/css/bootstrap-dialog.css" />
              
        
   <link type="text/css" rel="stylesheet" href="${ctx}/assets/css/login.css" />
 
   
   <!--[if lt IE 9]>
	 <script type="text/javascript" src="${ctx}/assets/js/html5shiv.js"></script>
	 <script type="text/javascript" src="${ctx}/assets/js/respond.min.js"></script>
	<![endif]-->
   
</head>

<body style="background:#eee"> 
      
<div class="main-container">
	  <div class="loginform clearfix">
	    <div class="logo"> 
				 <a href="#">
						<img src="${ctx}/assets/images/logo.jpg" width="330" height="60" >
				 </a>  
	    </div>  	
	  </div>
	  
	  <div class="login">
	     <div class="loginbg"></div>
	     
	     <form class="loginbox form-horizontal" id="loginForm">
	        <div class="form-group">					
				<div class="col-sm-11 col-sm-offset-1">
					 <input type="text" class="form-control inputbox" id="userName" name="userName" placeholder="请输入用户名"   autocomplete="off">
				</div>
			</div> 
					  
			 <div class="form-group">					
				<div class="col-sm-11 col-sm-offset-1">
					 <input type="password" class="form-control passinput" id="userPwd" name="userPwd" placeholder="请输入密码"  autocomplete="off">
				</div>
			</div> 
			
			 <div class="form-group">
			 <div class="col-sm-11 col-sm-offset-1">
			     <div class="slideunlock-wrapper">
				        <input type="hidden" id="slidelock" value="" class="slideunlock-lockable"/>
				        <div class="slideunlock-slider defaultbg">
				            <span class="slideunlock-label"></span>
				            <span class="slideunlock-lable-tip">请按住滑块，拖动到最右边</span>
				        </div>
				  </div>
							     
			     </div>
			  </div> 
				 
               <div class="line"></div>
			    
			 <div class="form-group btns"> 
				    <input type="button" id="btnLogin" class="btn btn-primary" value="登 录">
			  </div>
		</form>
	     
	  </div>
	  
	  
	  <div class="loginfooter">
	  
	               版权所有©深圳南网投资发展合伙企业（有限合伙）&nbsp;
	
	  </div>
	  
	  		  			  	
 </div> 
		 
    
     
</body>
 
    <!-- basic scripts --> 
	 
   <script src="${ctx}/assets/js/jquery-1.10.2.min.js"></script>
	<script src="${ctx}/assets/js/bootstrap.min.js"></script>
    <!-- bootstrap-validator-->
	<script src="${ctx}/assets/bootstrapvalidator/js/bootstrapValidator.js"></script>
	<script src="${ctx}/assets/bootstrapvalidator/js/language/zh_CN.js"></script>
	<!-- bootstrap-dialog-->
	<script src="${ctx}/assets/dialog/js/bootstrap-dialog.min.js"></script>
	
	<!--滑动拖块-->
	<script src="${ctx}/assets/js/jquery.slideunlock.js"></script>
	 
	 
    <script type="text/javascript">
	    var slider;  //滑动插件对象
		  
		 $(function() {
			   
			   //初始化验证
			   initValidator();
			   
			   //登录
			   $("#btnLogin").click(loginCheck);
				
				
				//滑动
			   slider = new SliderUnlock(".slideunlock-slider", {
		            labelTip: "滑动解锁",
		            successLabelTip: "解锁成功",
		            duration: 200   // 动画效果执行时间，默认200ms
		        }, function(){
		            //成功点击登录按钮
		            setTimeout(function(){
		            
		               //自动触发登录事件
		               $("#btnLogin").trigger("click");
		               
		            },500); 
		            
		        }, function(){
		            //这里是做滑动的效果用，不需写代码
		        });
		        slider.init();
   
		 });
		 

		 
		 //初始化验证
		 function initValidator(){
		   
		    $('#loginForm').bootstrapValidator({
				        message: '请输入值',
				        feedbackIcons: {
				            valid: 'glyphicon glyphicon-ok',   // 验证通过的图标，可以自己改
				            invalid: 'glyphicon glyphicon-remove',  //验证不通过的图标，可以自己改
				            validating: 'glyphicon glyphicon-refresh' //验证中的图标,可以自己改
				        },
						//验证字段，验证表单里面的  <input  name="字段名" >
				        fields: { 
							  userName: {
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
				             userPwd: {
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
			                 
				       }//fields结束
				});	 
		 
		 }
		 
		 
		 function loginCheck(){
		     //判断是否验证通过
			   var bv=$("#loginForm").data('bootstrapValidator'); 
		        //手动触发验证
		        bv.validate(); 
		         //滑块的值
		         var value=$("#slidelock").val();
		         
		        if(bv.isValid()){
		           //如果滑块还没有拖动过，提示错误  
		           if(value==0){
		                 BootstrapDialog.show({
				            title: '警告',
				            message: '拖动滑动进行验证',
				            type:"type-danger"
				        }); 
				        return; 
		           }
		           
		           //使用ajax登录
		           sendAjaxLogin(); 
		           
		        }else{
		           //滑块重置 		          
		           slider.reset();		           
		             
		        }	 
		 }
		 
		 //ajax登录
		 function sendAjaxLogin(){
		     var dataForm=$("#loginForm").serialize();
		     
		     //ajax
		     $.ajax({
		         type:"post",
		         url:"${ctx}/login",
		         data:dataForm,
		         dataType:"json",
		         success:function(resp){
		            if(resp.code==0){
		               window.location.href="${ctx}/"+resp.message;
		            }else{
		               errorValidate(resp);
		            }
		         } 
		     });
		     
		 }
		 
		 function errorValidate(resp){ 
		   //提示错误消息
		     BootstrapDialog.show({
				            title: '错误',
				            message:resp.message,
				            type:"type-danger"
			  }); 
				       
              //滑块还原
			 slider.reset();	
		     //验证还原 
	        $("#loginForm").data('bootstrapValidator').resetForm(true);
				   
		 }
		 
		</script>
</html>