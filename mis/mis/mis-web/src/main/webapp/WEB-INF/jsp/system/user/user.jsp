<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户管理</title>
     <!-- Google Fonts-->
   <link href='https://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet' type='text/css' />
     <!-- TABLE STYLES-->
    <link href="${pageContext.request.contextPath}/static/assets/js/dataTables/dataTables.bootstrap.css" rel="stylesheet" />
</head>


		  <div class="header"> 
                    <h1 class="page-header">
                    </h1>
                    
		 </div>
  
            <div class="row">
                <div class="col-md-12">
                    <!-- Advanced Tables -->
                    <div class="panel panel-default">
                    <div class="panel-heading">
                          <span><i class="fa fa-users" aria-hidden="true"></i>&nbsp;&nbsp;用户管理</span>
                        </div>
                        <div class="panel-body">
                         <a href="#" class="btn btn-success" style="margin: 0px 0px 20px;" data-toggle="modal" data-target="#addEditModal"><i class="fa fa-plus"></i>&nbsp;增加</a>
                            <div class="table-responsive">
                                <table class="table table-striped table-bordered table-hover" id="dataTables-example">
                                    <thead>
                                        <tr>
                                            <th>账号</th>
                                            <th>用户名</th>
                                            <th>邮箱</th>
                                            <th>性别</th>
                                            <th>联系方式</th>
                                            <th>人员类别</th>
                                            <th>操作</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                         <c:forEach items="${list}" var="User">
                                            <tr class="odd gradeX">
                                            <td>${User.uid }</td>
                                            <td>${User.name }</td>
                                            <td>${User.mail }</td>
                                             <c:if test="${User.sex=='1'}">
                                             <td>女</td>
                                             </c:if>
                                             <c:if test="${User.sex=='0'}">
                                             <td>男</td>
                                             </c:if>
                                             <c:if test="${User.sex==null}">
                                             <td></td>
                                             </c:if>
                                            <td class="center">${User.tel }</td>
                                            <td class="center">${User.remark}</td>
                                            <td align="center">
                                            <button class="btn btn-primary" title='编辑' onclick="editUserBtn('${User.id}')" id="editUserBtn"><i class="fa fa-edit "></i></button>
                                            <button class="btn btn-danger" title='删除' onclick="deleteUser('${User.id}')"><i class="fa fa-trash-o" aria-hidden="true"></i></button>
                                  
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
                                            <button type="button" class="btn btn-primary" id="deleteUser2">确认</button>
                                        </div>
                                    </div>
                                </div>
              </div>       
              <div class="modal fade" id="addEditModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" style="display: none;">
                  <div class="modal-dialog">
                      <div class="modal-content">
                          <div class="modal-header">
                              <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                              <h4 class="modal-title" id="myModalLabel">添加人员</h4>
                          </div>
                          <div class="modal-body">
                         <form class="form-horizontal" id="addEditForm">
                            <div class="form-group">
                                 <input type="hidden" value="" id="user_id"  name="id"> 
                                <label for="inputEmail3" class="col-sm-2 control-label">账号</label>
                                <div class="col-sm-9">
                                    <input type="text" class="form-control" id="userId" name="uid" placeholder="填写手机号或者工号">
                                    <span class="help-block" id="userIdMessage" />
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="inputPassword3" class="col-sm-2 control-label">昵称</label>
                                <div class="col-sm-9">
                                    <input type="text" class="form-control" id="name" name="name" placeholder="填写姓名或昵称">
                                    <span class="help-block" id="nameMessage" />
                                </div>
                            </div>
                             <div class="form-group">
                                <label for="inputPassword3" class="col-sm-2 control-label">邮箱</label>
                                <div class="col-sm-9">
                                   <input type="text" class="form-control" id="mail" name="mail" placeholder="填写姓名或昵称">
                                   <span class="help-block" id="emailMessage" />
                                </div>
                            </div>
                             <div class="form-group">
                                <label for="inputPassword3" class="col-sm-2 control-label">密码</label>
                                <div class="col-sm-9">
                                   <input type="password" class="form-control" id="password" name="password" placeholder="填写姓名或昵称">
                                    <span class="help-block" id="passwordMessage" />
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="inputPassword3" class="col-sm-2 control-label">性别</label>
                                <div class="col-sm-6">
                                   <div>
                     		   <select class="form-control" id="sex" name="sex" data-live-search="true">
                     		    <option value="0">男</option>
                     		    <option value="1">女</option>
	                           </select>
                           </div>
                                </div>
                            </div>
                             <div class="form-group">
                                <label for="inputPassword3" class="col-sm-2 control-label">人员类型</label>
                                <div class="col-sm-6">
                                   <div>
                     		   <select class="form-control" id="remark" name="remark" data-live-search="true">
                     		    <option value="开发人员">开发人员</option>
                     		    <option value="测试人员">测试人员</option>
	                           </select>
                           </div>
                                </div>
                            </div>
                              <div class="form-group">
                                <label for="inputPassword3" class="col-sm-2 control-label">联系方式</label>
                                <div class="col-sm-9">
                                   <input type="text" class="form-control" id="tel" name="tel" placeholder="填写联系方式">
                                   <span class="help-block" id="telMessage" />
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
    <script src="${pageContext.request.contextPath}/static/assets/js/jquery.metisMenu.js"></script>
     <!-- DATA TABLE SCRIPTS -->
    <script src="${pageContext.request.contextPath}/static/assets/js/dataTables/jquery.dataTables.js"></script>
    <script src="${pageContext.request.contextPath}/static/assets/js/dataTables/dataTables.bootstrap.js"></script>
    <script src="${pageContext.request.contextPath}/static/js/user.js"></script>
    

