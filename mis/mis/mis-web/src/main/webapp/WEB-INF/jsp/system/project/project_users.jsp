<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href='https://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet' type='text/css' />
 <link href="${pageContext.request.contextPath}/static/css/bootstrap-select.css" rel="stylesheet">
<title>图书详情</title>
</head>
  <div class="header"> 
         <h1 class="page-header">
           </h1>
    
  </div>
   <div class="row">
           <div class="col-xs-12">
               <div class="panel panel-default">
                   <div class="panel-body">
                       <span style="margin-top:5px;float:left;">当前项目：${project.name}</span>
                       <a href="${pageContext.request.contextPath}/project/render.do" class="btn btn-default btn-sm" style="float:right;"><i class="fa fa-mail-reply"></i>&nbsp;返回</a>
                   </div>
               </div>
           </div>
       </div>
         <div class="row">
             <div class="col-xs-12">					
                 <div class="panel panel-default">
                     <div class="panel-heading">
                         <div class="card-title">
                             <div class="title">用户信息</div>
                         </div>
                     </div>
                     <div class="panel-body">
                     <a href="#" class="btn btn-success" style="margin: 0px 0px 20px;" data-toggle="modal" data-target="#addEditModal"><i class="fa fa-plus"></i>&nbsp;增加</a>
                               <div class="table-responsive">
                                <table class="table table-striped table-bordered table-hover" id="dataTables-example">
                                    <thead>
                                        <tr>
                                            <th>用户名</th>
                                            <th>姓名</th>
                                            <th>邮箱</th>
                                            <th>用户角色</th>
                                            <th>操作</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                         <c:forEach items="${users}" var="User">
                                            <tr class="danger">
                                            <td>${User.uid }</td>
                                            <td>${User.name }</td>
                                            <td>${User.mail }</td>
                                            <td class="center">${User.rolename }</td>
                                            <td align="center">
                                            <button class="btn btn-primary" title='编辑' data-toggle="modal" data-target="#myModal"><i class="fa fa-edit "></i></button>
                                            <button class="btn btn-danger" title='删除' onclick="deleteUser('${User.userid}','${User.roid}')"><i class="fa fa-trash-o" aria-hidden="true"></i></button>
                                  
                                            </td>
                                        </tr>
                                         </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                     </div>
                 </div>
             </div>
        </div>
                   <div class="modal fade" id="addEditModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" style="display: none;">
                                <div class="modal-dialog">
                                    <div class="modal-content">
                                        <div class="modal-header">
                                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                                            <h4 class="modal-title" id="myModalLabel">创建项目</h4>
                                        </div>
                                        <div class="modal-body">
		                                     <form class="form-horizontal" id="addEditForm">
		                                        <div class="form-group">
		                                            <label for="inputPassword3" class="col-sm-2 control-label">选择用户</label>
		                                            <div class="col-sm-10">
		                                               <div>
					                              		   <select class="selectpicker" id="userId" name="ownerId" data-live-search="true">
					                              		   <c:forEach items="${users2}" var="User">
					                              		    <option value="${User.id}">${User.name}</option>
					                              		   </c:forEach>
															</select>
					                                    </div>
		                                            </div>
		                                        </div>
		                                         <div class="form-group">
		                                            <label for="inputPassword3" class="col-sm-2 control-label">选择角色</label>
		                                            <div class="col-sm-10">
		                                               <div>
					                              		   <select class="selectpicker" id="roleId"  data-live-search="true">
					                              		   <c:forEach items="${roles}" var="Role">
					                              		    <option value="${Role.id}">${Role.name}</option>
					                              		   </c:forEach>
															</select>
					                                    </div>
		                                            </div>
		                                        </div>
                                        </div>
                                        <div class="modal-footer">
                                            <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                                            <button type="submit" class="btn btn-primary" id="addEditButton">确认</button>
                                        </div>
                                        </form>
                                    </div>
                                </div>
              </div>   
              <script>
             var projectId= ${project.id};
             </script> 
             <script src="${pageContext.request.contextPath}/static/js/bootstrap-select.js"></script>   
    <script src="${pageContext.request.contextPath}/static/assets/js/jquery.metisMenu.js"></script>
     <!-- DATA TABLE SCRIPTS -->
    <script src="${pageContext.request.contextPath}/static/assets/js/dataTables/jquery.dataTables.js"></script>
    <script src="${pageContext.request.contextPath}/static/assets/js/dataTables/dataTables.bootstrap.js"></script>
    <script src="${pageContext.request.contextPath}/static/js/project/project_users.js"></script>
</html>