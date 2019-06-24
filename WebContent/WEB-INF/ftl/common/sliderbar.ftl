<script type="text/javascript">
				try{ace.settings.check('main-container' , 'fixed')}catch(e){}
			</script>

			<div class="main-container-inner">
				<a class="menu-toggler" id="menu-toggler" href="#">
					<span class="menu-text"></span>
				</a>

				<div class="sidebar" id="sidebar">
					<script type="text/javascript">
						try{ace.settings.check('sidebar' , 'fixed')}catch(e){}
					</script>

					<div class="sidebar-shortcuts" id="sidebar-shortcuts">
						<div class="sidebar-shortcuts-large" id="sidebar-shortcuts-large">
							<button class="btn btn-success">
								<i class="icon-signal"></i>
							</button>

							<button class="btn btn-info">
								<i class="icon-pencil"></i>
							</button>

							<button class="btn btn-warning">
								<i class="icon-group"></i>
							</button>

							<button class="btn btn-danger">
								<i class="icon-cogs"></i>
							</button>
						</div>

						<div class="sidebar-shortcuts-mini" id="sidebar-shortcuts-mini">
							<span class="btn btn-success"></span>

							<span class="btn btn-info"></span>

							<span class="btn btn-warning"></span>

							<span class="btn btn-danger"></span>
						</div>
					</div><!-- #sidebar-shortcuts -->

					<ul class="nav nav-list">
						<li class="active">
							<a href="index.html">
								<i class="icon-dashboard"></i>
								<span class="menu-text"> 首页 </span>
							</a>
						</li>

						 

						<li>
							<a href="#" class="dropdown-toggle">
								<i class="icon-list"></i>
								<span class="menu-text">基础数据设定 </span>

								<b class="arrow icon-angle-down"></b>
							</a>

							<ul class="submenu">
								<li>
									<a href="${ctx}/role/search">
										<i class="icon-double-angle-right"></i>
										角色管理
									</a>
								</li>

								<li>
									<a href="${ctx}/city/search">
										<i class="icon-double-angle-right"></i>
										区域管理
									</a>
								</li>
								
								<li>
									<a href="${ctx}/cuslevel/search">
										<i class="icon-double-angle-right"></i>
										客户等级管理
									</a>
								</li>
								
								<li>
									<a href="${ctx}/dist/search">
										<i class="icon-double-angle-right"></i>
										数据字典
									</a>
								</li>
							</ul>
						</li>
						
						
						<!-- 客户管理 -->
                       <li>
							<a href="#" class="dropdown-toggle">
								<i class="icon-list"></i>
								<span class="menu-text">客户管理 </span>

								<b class="arrow icon-angle-down"></b>
							</a>

							<ul class="submenu">
								<li>
									<a href="${ctx}/customer/search">
										<i class="icon-double-angle-right"></i>
										客户信息
									</a>
								</li>
  
							</ul>
						</li>
					 
					</ul><!-- /.nav-list -->

					<div class="sidebar-collapse" id="sidebar-collapse">
						<i class="icon-double-angle-left" data-icon1="icon-double-angle-left" data-icon2="icon-double-angle-right"></i>
					</div>

					<script type="text/javascript">
						try{ace.settings.check('sidebar' , 'collapsed')}catch(e){}
					</script>
				</div>