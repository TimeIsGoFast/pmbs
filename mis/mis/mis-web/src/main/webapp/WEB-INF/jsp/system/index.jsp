<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
	<meta content="" name="description" />
    <meta content="webthemez" name="author" />
    <title>首页</title>
    <link href="${pageContext.request.contextPath}/static/assets/js/morris/morris-0.4.3.min.css" rel="stylesheet" />
    <!-- Custom Styles-->
    <link href='https://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet' type='text/css' />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/assets/js/Lightweight-Chart/cssCharts.css"> 
</head>

<body>

		  <div class="header"> 
                        <h1 class="page-header">
                                 首页<small>Welcome to pmbs</small>
                        </h1>
									
		</div>
            <div id="page-inner">

                <!-- /. ROW  -->
	
                <div class="row">
                    <div class="col-md-3 col-sm-12 col-xs-12">
					<div class="board">
                        <div class="panel panel-primary">
						<div class="number">
							<h3>
								<h3>44,023</h3>
								<small>测试计划数</small>
							</h3> 
						</div>
						<div class="icon">
						   <i class="fa fa-eye fa-5x red"></i>
						</div>
		 
                        </div>
						</div>
                    </div>
					
					       <div class="col-md-3 col-sm-12 col-xs-12">
					<div class="board">
                        <div class="panel panel-primary">
						<div class="number">
							<h3>
								<h3>32,850</h3>
								<small>缺陷总数</small>
							</h3> 
						</div>
						<div class="icon">
						   <i class="fa fa-shopping-cart fa-5x blue"></i>
						</div>
		 
                        </div>
						</div>
                    </div>
					
					       <div class="col-md-3 col-sm-12 col-xs-12">
					<div class="board">
                        <div class="panel panel-primary">
						<div class="number">
							<h3>
								<h3>56,150</h3>
								<small>解决缺陷数</small>
							</h3> 
						</div>
						<div class="icon">
						   <i class="fa fa-comments fa-5x green"></i>
						</div>
		 
                        </div>
						</div>
                    </div>
					
					       <div class="col-md-3 col-sm-12 col-xs-12">
					<div class="board">
                        <div class="panel panel-primary">
						<div class="number">
							<h3>
								<h3>12</h3>
								<small>完成测试数</small>
							</h3> 
						</div>
						<div class="icon">
						   <i class="fa fa-user fa-5x yellow"></i>
						</div>
		 
                        </div>
						</div>
                    </div>
				   
                </div>
				     <div class="row">
                        <div class="col-sm-6 col-xs-12">  
                            <div class="panel panel-default chartJs">
                                <div class="panel-heading">
                                    <div class="card-title">
                                        <div class="title">Line Chart</div>
                                    </div>
                                </div>
                                <div class="panel-body">
                                    <canvas id="line-chart" class="chart"></canvas>
                                </div>
                            </div>
                        </div>
                        <div class="col-sm-6 col-xs-12">
                            <div class="panel panel-default chartJs">
                                <div class="panel-heading">
                                    <div class="card-title">
                                        <div class="title">Bar Chart</div>
                                    </div>
                                </div>
                                <div class="panel-body">
                                    <canvas id="bar-chart" class="chart"></canvas>
                                </div>
                            </div>
                        </div>
                    </div>
				
		<div class="row">
			<div class="col-xs-6 col-md-3">
				<div class="panel panel-default">
					<div class="panel-body easypiechart-panel">
						<h4>Profit</h4>
						<div class="easypiechart" id="easypiechart-blue" data-percent="82" ><span class="percent">82%</span>
						</div>
					</div>
				</div>
			</div>
			<div class="col-xs-6 col-md-3">
				<div class="panel panel-default">
					<div class="panel-body easypiechart-panel">
						<h4>Sales</h4>
						<div class="easypiechart" id="easypiechart-orange" data-percent="55" ><span class="percent">55%</span>
						</div>
					</div>
				</div>
			</div>
			<div class="col-xs-6 col-md-3">
				<div class="panel panel-default">
					<div class="panel-body easypiechart-panel">
						<h4>Customers</h4>
						<div class="easypiechart" id="easypiechart-teal" data-percent="84" ><span class="percent">84%</span>
						</div>
					</div>
				</div>
			</div>
			<div class="col-xs-6 col-md-3">
				<div class="panel panel-default">
					<div class="panel-body easypiechart-panel">
						<h4>No. of Visits</h4>
						<div class="easypiechart" id="easypiechart-red" data-percent="46" ><span class="percent">46%</span>
						</div>
					</div>
				</div>
			</div>
		</div><!--/.row-->
        
			<div class="copyrights">Collect from <a href="http://www.cssmoban.com/" >企业网站模板</a></div>
		
				<div class="row">
				<div class="col-md-5">
						<div class="panel panel-default">
						<div class="panel-heading">
							Line Chart
						</div>
						<div class="panel-body">
							<div id="morris-line-chart"></div>
						</div>						
					</div>   
					</div>		
					
						<div class="col-md-7">
					<div class="panel panel-default">
					<div class="panel-heading">
                                Bar Chart Example
                            </div>
                            <div class="panel-body">
                                <div id="morris-bar-chart"></div>
                            </div>
						
					</div>  
					</div>
					
				</div> 
			 
				
				
                <div class="row">
                    <div class="col-md-9 col-sm-12 col-xs-12">
                        <div class="panel panel-default">                            
							<div class="panel-heading">
							Area Chart
						</div>
						<div class="panel-body">
							<div id="morris-area-chart"></div>
						</div>
                        </div>
                    </div>
                    <div class="col-md-3 col-sm-12 col-xs-12">
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                Donut Chart Example
                            </div>
                            <div class="panel-body">
                                <div id="morris-donut-chart"></div>
                            </div>
                        </div>
                    </div>

                </div>
				<div class="row">
				<div class="col-md-12">
				
					</div>		
				</div> 	
                <!-- /. ROW  -->
               
            <!-- /. PAGE INNER  -->
     <script src="${pageContext.request.contextPath}/static/js/jquery-2.1.1.min.js"></script>
    <script src="${pageContext.request.contextPath}/static/assets/js/morris/raphael-2.1.0.min.js"></script>
    <script src="${pageContext.request.contextPath}/static/assets/js/morris/morris.js"></script>
	
	<script src="${pageContext.request.contextPath}/static/assets/js/easypiechart.js"></script>
	<script src="${pageContext.request.contextPath}/static/assets/js/easypiechart-data.js"></script>
	
	 <script src="${pageContext.request.contextPath}/static/assets/js/Lightweight-Chart/jquery.chart.js"></script>
	  <script src="${pageContext.request.contextPath}/static/js/index.js"></script>
    <!-- Custom Js -->
    <script src="${pageContext.request.contextPath}/static/assets/js/custom-scripts.js"></script>

      
    <!-- Chart Js -->
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/assets/js/chart.min.js"></script>  
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/assets/js/chartjs.js"></script> 
   <script type="text/javascript">

</script>
</body>

</html>