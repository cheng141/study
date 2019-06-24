<html>
<head>  
  <meta charset="UTF-8">
   <meta name="viewport" content="width=device-width, initial-scale=1.0">
   <meta http-equiv="X-UA-Compatible" content="ie=edge">
  <title>首页</title>
  
  <#include "common/css.ftl" >
   
</head>

<body> 
    
      <#include "common/header.ftl">

		<div class="main-container" id="main-container">
		  	
		  	<!--导航区-->
		  	<#include "common/sliderbar.ftl">
		  	
			 <!-- 内容区-->
			 <div class="main-content">	
			     <!--导航-->
			     <div class="breadcrumbs" id="breadcrumbs">	
						<ul class="breadcrumb">
							<li>
								<i class="icon-home home-icon"></i>
								<a href="#">首页</a>
							</li>
							<li class="active">控制台</li>
						</ul>  
					</div>
			 			
			 	 <div class="page-content">			 	 							
			          <h1>内容放在这里面  </h1> 
			     </div>
			 </div>				 
				
		 </div><!-- /.main-container-inner -->

			<a href="#" id="btn-scroll-up" class="btn-scroll-up btn btn-sm btn-inverse">
				<i class="icon-double-angle-up icon-only bigger-110"></i>
			</a>
		</div><!-- /.main-container -->
    
     
</body>
   <#include "common/js.ftl" >
    
    
		<script type="text/javascript">
			 $(function() {
			  
			
			});
		</script>
</html>