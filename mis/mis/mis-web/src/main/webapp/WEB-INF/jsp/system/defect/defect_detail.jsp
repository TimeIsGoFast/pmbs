<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>缺陷管理</title>
     <!-- TABLE STYLES-->
    <link href="${pageContext.request.contextPath}/static/css/bootstrap-select.css" rel="stylesheet">

</head>
		  <div class="header" style="height:50px;"> 
		 </div>
            <div class="row">
                <div class="col-md-12">
                    <!-- Advanced Tables -->
                    <div class="panel panel-default">
                      <div class="panel-heading">
                          <span><i class="fa fa-book" aria-hidden="true"></i>&nbsp;&nbsp;缺陷管理</span>
                        </div>
                        <div class="panel-body">
                        <a href="#" class="btn btn-success" style="margin: 0px 0px 20px;" data-toggle="modal" data-target="#addEditModal"><i class="fa fa-edit"></i>&nbsp;编辑</a>
                        <!-- <a href="#" class="btn btn-default" style="margin: 0px 0px 20px;" data-toggle="modal" data-target="#addEditModal"><i class="fa fa-book"></i>&nbsp;分析</a>    -->
                        <a href="#" class="btn btn-default" style="margin: 0px 0px 20px;" data-toggle="modal" data-target="#fixModal"><i class="fa fa-check-square-o"></i>&nbsp;修复</a>   
                        <a href="#" class="btn btn-default" style="margin: 0px 0px 20px;" data-toggle="modal" data-target="#zhuanpai"><i class="fa  fa-mail-forward"></i>&nbsp;转派</a>   
                        <a href="${pageContext.request.contextPath}/defect/render.do" class="btn btn-default btn-sm" style="float:right;"><i class="fa fa-mail-reply"></i>&nbsp;返回</a>                         
                            <div class="row">
                    <div class="col-md-4 col-sm-12 col-xs-12">
                        <div class="panel panel-default">
                          
                            <div class="panel-body">
                                <div class="list-group">

                                    <a href="#" class="list-group-item">
                                        <span class="badge">${defect.name}</span>
                                        	缺陷名称
                                    </a>
                                    <a href="#" class="list-group-item">
                                        <span class="badge">${testPlan.name}</span>
                                      	  所属计划
                                    </a>
                                    <a href="#" class="list-group-item">
                                        <span class="badge">${defect.creatorName}</span>
                                        	创建者
                                    </a>
                                    <a href="#" class="list-group-item">
                                        <span class="badge">${defect.createdDate}</span>
                                        	创建时间
                                    </a>
                                    
                                   
                                </div>
                               
                            </div>
                        </div>

                    </div>
                   <div class="col-md-4 col-sm-12 col-xs-12">
                        <div class="panel panel-default">
                            <div class="panel-body">
                                <div class="list-group">

                                    <a href="#" class="list-group-item">
                                        <span class="badge">${defect.resolution}</span>
                                        	解决
                                    </a>
                                    <a href="#" class="list-group-item">
                                        <span class="badge">${defect.severity}</span>
                                        	等级
                                    </a>
                                    <a href="#" class="list-group-item">
                                        <span class="badge">${defect.reason}</span>
                                        	原因
                                    </a>
                                    <a href="#" class="list-group-item">
                                        <span class="badge">${defect.priority}</span>
                                       	           优先级
                                    </a>
                                  
                                </div>
                               
                            </div>
                        </div>

                    </div>
                    <div class="col-md-4 col-sm-12 col-xs-12">
                        <div class="panel panel-default">
                            <div class="panel-body">
                                <div class="list-group">

                                    <a href="#" class="list-group-item">
                                        <span class="badge">${defect.assigneeName}</span>
                                      	  分配给
                                    </a>
                                    <a href="#" class="list-group-item">
                                        <span class="badge">${defect.updateDate}</span>
                                     	   更新时间
                                    </a>
                                   
                                  
                                </div>
                               
                            </div>
                        </div>

                    </div>
                </div>
                 <div class="row">
                     <div class="col-md-12 col-sm-12 col-xs-12">
                        <div class="panel panel-default">
                            <div class="panel-heading">
                              	   摘要
                            </div>
                            <div class="panel-body">
                            <div class="col-sm-12">
                                 <input type="text" class="form-control" id="summary" name="summary" value="${defect.summary}" placeholder="填写摘要">
                              </div> 
                            </div>
                        </div>

                    </div>
                </div>
                <div class="row">
                     <div class="col-md-12 col-sm-12 col-xs-12">
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                	描述
                            </div>
                            <div class="panel-body">
                                 <div class="col-sm-12">
		                             <textarea class="form-control" id="descr" name="descr" rows="5" >${defect.descr}</textarea>
		                         </div>
                               
                            </div>
                        </div>

                    </div>
                </div>
                 <div class="row">
                     <div class="col-md-12 col-sm-12 col-xs-12">
                        <div class="panel panel-default">
                            <div class="panel-heading">
                              	  附件
                            </div>
                            <div class="panel-body">
                                  <div class="col-xs-6 col-md-3">
					    <a href="${pageContext.request.contextPath}/output/${defect.picUrl}" target="_blank" class="thumbnail">
					      <img src="${pageContext.request.contextPath}/output/${defect.picUrl}" alt="...">
					    </a>
					  </div>
                               
                            </div>
                        </div>

                    </div>
                </div>
                
                        </div>
                    </div>
                    <!--End Advanced Tables -->
                </div>
            </div> 
            <input type="hidden" value="" id="delete_project_id">
            <div class="modal fade" id="deleteModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" style="display: none;">
                                <div class="modal-dialog">
                                    <div class="modal-content">
                                        <div class="modal-header">
                                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                                            <h4 class="modal-title" id="myModalLabel">删除记录</h4>
                                        </div>
                                        <div class="modal-body">
                                           <input type="hidden" value="" id="deleteUserId">
                                                                                                           确认删除这条记录？
                                        </div>
                                        <div class="modal-footer">
                                            <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                                            <button type="button" class="btn btn-primary" id="deleteProject">确认</button>
                                        </div>
                                    </div>
                                </div>
              </div>
              
                          <div class="modal fade" id="zhuanpai" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" style="display: none;">
                                <div class="modal-dialog">
                                    <div class="modal-content">
                                        <div class="modal-header">
                                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                                            <h4 class="modal-title" id="myModalLabel">转派</h4>
                                        </div>
                                        <div class="modal-body">
                                        <div class="row">
                                           <label for="inputPassword3" class="col-sm-2 control-label">分配给</label>
		                                            <div class="col-sm-3">
		                                               <div>
					                              		   <select class="selectpicker" id="assigneeUidmodel" name="assigneeUid" data-live-search="true">
					                              		   <c:forEach items="${users}" var="User">
					                              		    <option value="${User.id}">${User.name}</option>
					                              		   </c:forEach>
															</select>
					                                    </div>
		                                          </div>
                                          </div>
                                          </div>
                                        <div class="modal-footer">
                                            <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                                            <button type="button" class="btn btn-primary" id="zhuanpaiBtn">确认</button>
                                        </div>
                                    </div>
                                </div>
              </div>
              <input type="hidden" value="${defect.id}"  id="defect_id">
                        <div class="modal fade" id="fixModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" style="display: none;">
                                <div class="modal-dialog">
                                    <div class="modal-content">
                                        <div class="modal-header">
                                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                                            <h4 class="modal-title" id="myModalLabel">解决</h4>
                                        </div>
                                        <div class="modal-body">
                                          <div class="row">
                                             	<label for="inputEmail3" class="col-lg-2 control-label">解决</label>
												   <div class="col-sm-7">
		                                               <div>
					                              		   <select class="selectpicker" id="reolution" name="reolution" data-live-search="true">
					                              		    <option value="已修复">已修复</option>
					                              		    <option value="无效的">无效的</option>
					                              		    <option value="延迟">延迟</option>
					                              		    <option value="未解决">未解决</option>
					                              		    <option value="已解决">已解决</option>
															</select>
					                                    </div>
		                                            </div>
		                                    </div>
		                                    </div>
                                        <div class="modal-footer">
                                            <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                                            <button type="button" class="btn btn-primary" id="resolutionBtn">确认</button>
                                        </div>
                                    </div>
                                </div>
              </div>
              <div class="modal fade" id="addEditModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" style="display: none;">
                                <div class="modal-dialog">
                                    <div class="modal-content" style="width:1000px;height:650px;margin-left:-169px">
                                        <div class="modal-header">
                                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                                            <h4 class="modal-title" id="myModalLabel">创建缺陷</h4>
                                        </div>
                                         <form class="form-horizontal" method="post" action="${pageContext.request.contextPath}/defect/addDefect.do"  enctype="multipart/form-data">
                                        <div class="modal-body" style="height:500px;">
		                                    
		                                        <div class="form-group">
		                                             <input type="hidden" value="" id="project_id"  name="id"> 
		                                            <label for="inputEmail3" class="col-lg-1 control-label">摘要</label>
		                                            <div class="col-sm-10">
		                                                <input type="text" class="form-control" id="summary" name="summary" placeholder="填写摘要">
		                                                <span class="help-block" id="nameMessage" />
		                                            </div>
		                                        </div>
		                                         <div class="row"> 
		                                           	<label for="inputEmail3" class="col-lg-1 control-label">计划</label>
												     <div class="col-sm-3">
		                                               <div>
					                              		   <select class="selectpicker" id="planId" name="planId" data-live-search="true">
					                              		   <c:forEach items="${testPlans}" var="TestPlan">
					                              		    <option value="${TestPlan.id}">${TestPlan.name}</option>
					                              		   </c:forEach>
															</select>
					                                    </div>
		                                            </div>
												       <label for="inputPassword3" class="col-sm-1 control-label">等级</label>
		                                            <div class="col-sm-3">
		                                               <div>
					                              		   <select class="selectpicker" id="severity" name="severity" data-live-search="true">
					                              		    <option value="主要">主要</option>
					                              		    <option value="严重">严重</option>
					                              		    <option value="一般">一般</option>
					                              		     <option value="次要">次要</option>
					                              		    <option value="致命">致命</option>
					                              		    <option value="轻微">轻微</option>
															</select>
					                                    </div>
		                                            </div>
												   
												  
												  </div>
												   
												   <br>
												     <div class="row"> 
		                                           	<label for="inputEmail3" class="col-lg-1 control-label">原因</label>
												   <div class="col-sm-3">
		                                               <div>
					                              		   <select class="selectpicker" id="reason" name="reason" data-live-search="true">
					                              		    <option value="需求问题">需求问题</option>
					                              		    <option value="设计错误">设计错误</option>
					                              		    <option value="代码错误">代码错误</option>
					                              		    <option value="配置问题">配置问题</option>
					                              		    <option value="部署问题">部署问题</option>
					                              		    <option value="遗留缺陷">遗留缺陷</option>
															</select>
					                                    </div>
		                                            </div>
												
												     <label for="inputPassword3" class="col-sm-1 control-label">分配给</label>
		                                            <div class="col-sm-3">
		                                               <div>
					                              		   <select class="selectpicker" id="assigneeUid" name="assigneeUid" data-live-search="true">
					                              		   <c:forEach items="${users}" var="User">
					                              		    <option value="${User.id}">${User.name}</option>
					                              		   </c:forEach>
															</select>
					                                    </div>
		                                            </div>

												  </div>
												  <br>
												  <div class="row">
												    <label for="inputEmail3" class="col-lg-1 control-label">优先级</label>
												     <div class="col-sm-3">
		                                               <div>
					                              		   <select class="selectpicker" id="priority" name="priority" data-live-search="true">
					                              		   <option value="高">高</option>
					                              		    <option value="中">中</option>
					                              		    <option value="低">低</option>
															</select>
					                                    </div>
		                                            </div>
												  </div>
		                                      <br>
		                                         <div class="form-group">
		                                            <label for="inputPassword3" class="col-sm-1 control-label">描述</label>
		                                            <div class="col-sm-10">
		                                               <textarea class="form-control" id="descr" name="descr" rows="5"></textarea>
		                                            </div>
		                                        </div>

		                                         <div class="form-group">
													    <label for="inputfile" class="col-sm-1">图片</label>
													    <input type="file" id="defect_pic" name="defect_pic">
												</div>
		                                    
                                        </div>
                                        <div class="modal-footer">
                                            <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                                            <button type="submit" class="btn btn-primary">确认</button>
                                        </div>
                                        </form>
                                    </div>
                                </div>
              </div>    
    
    <script src="${pageContext.request.contextPath}/static/js/bootstrap-select.js"></script>

    <script src="${pageContext.request.contextPath}/static/js/defect/defect_detail.js"></script>
