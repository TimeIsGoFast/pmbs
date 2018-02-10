<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>项目管理</title>
     <!-- Google Fonts-->
    
  
     <!-- TABLE STYLES-->
    <link href="${pageContext.request.contextPath}/static/css/bootstrap-select.css" rel="stylesheet">

</head>
		  <div class="header" style="height:50px;"> 
		 </div>
            <div class="row">
                <div class="col-md-12">
                    <!-- Advanced Tables -->
                    <div class="panel panel-default">
                        <div class="panel-body">
                        <a href="#" class="btn btn-success" style="margin: 10px 0px 20px;" data-toggle="modal" data-target="#addEditModal"><i class="fa fa-plus"></i>&nbsp;增加</a>
                            <div class="table-responsive">
                                <table class="table table-striped table-bordered table-hover" id="dataTables-example">
                                    <thead>
                                        <tr>
                                            <th>项目名</th>
                                            <th>简称</th>
                                            <th>描述</th>
                                            <th>创建者</th>
                                            <th>创建时间</th>
                                            <th>项目经理</th>
                                            <th>操作</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                         <c:forEach items="${projects}" var="Project">
                                         <tr>
                                            <td>${Project.name }</td>
                                            <td>${Project.shortname }</td>
                                            <td>${Project.descr }</td>
                                            <td>${Project.createdUser }</td>
                                            <td>${Project.createdDt }</td>
                                            <td>${Project.ownerName }</td>
                                            <td align="center">
                                            <button class="btn btn-primary" title='编辑' data-id="${Project.id}" id="editProjectBtn"><i class="fa fa-edit "></i></button>
                                            <button class="btn btn-danger" title='删除' data-id="${Project.id}" id="proejct_delete" onclick="deleteProjectBtn()"><i class="fa fa-trash-o" aria-hidden="true"></i></button>
                                            <button class="btn btn-success" title='人员管理' data-id="${Project.id}"><i class="fa fa-users" aria-hidden="true"></i></button>
                                            </td>
                                        </tr>
                                         </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                            
                        </div>
                    </div>
                    <!--End Advanced Tables -->
                </div>
            </div> 
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
		                                             <input type="hidden" value="" id="project_id"  name="id"> 
		                                            <label for="inputEmail3" class="col-sm-2 control-label">项目名称</label>
		                                            <div class="col-sm-9">
		                                                <input type="text" class="form-control" id="projectName" name="name" placeholder="填写项目名称">
		                                                <span class="help-block" id="nameMessage" />
		                                            </div>
		                                        </div>
		                                        <div class="form-group">
		                                            <label for="inputPassword3" class="col-sm-2 control-label">项目简称</label>
		                                            <div class="col-sm-9">
		                                                <input type="text" class="form-control" id="shortname" name="shortname" placeholder="填写项目简称">
		                                                <span class="help-block" id="shortnameMessage" />
		                                            </div>
		                                        </div>
		                                         <div class="form-group">
		                                            <label for="inputPassword3" class="col-sm-2 control-label">项目描述</label>
		                                            <div class="col-sm-10">
		                                               <textarea class="form-control" id="descr" name="descr" rows="3"></textarea>
		                                            </div>
		                                        </div>
		                                        <div class="form-group">
		                                            <label for="inputPassword3" class="col-sm-2 control-label">项目经理</label>
		                                            <div class="col-sm-10">
		                                               <div>
					                              		   <select class="selectpicker" id="ownerId" name="ownerId" data-live-search="true">
					                              		   <c:forEach items="${users}" var="User">
					                              		    <option value="${User.id}">${User.name}</option>
					                              		   </c:forEach>
															</select>
					                                    </div>
		                                            </div>
		                                        </div>
		                                          <div class="form-group">
		                                            <label for="inputPassword3" class="col-sm-2 control-label">所属部门</label>
		                                            <div class="col-sm-9">
		                                               <input type="text" class="form-control" id="department" name="department" placeholder="填写部门名称">
		                                               <span class="help-block" id="departmentMessage" />
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
    
    <script src="${pageContext.request.contextPath}/static/js/bootstrap-select.js"></script>

    <script src="${pageContext.request.contextPath}/static/js/project.js"></script>
