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
                               <div class="table-responsive">
                                <table class="table table-striped table-bordered table-hover" id="dataTables-example">
                                    <thead>
                                        <tr>
                                            <th>用户名</th>
                                            <th>姓名</th>
                                            <th>邮箱</th>
                                            <th>性别</th>
                                            <th>联系方式</th>
                                            <th>是否启用</th>
                                            <th>操作</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                         <c:forEach items="${list}" var="User">
                                            <tr class="danger">
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
                                            <td class="center">${User.enabled}</td>
                                            <td align="center">
                                            <button class="btn btn-primary" title='编辑' data-toggle="modal" data-target="#myModal"><i class="fa fa-edit "></i></button>
                                            <button class="btn btn-danger" title='删除' onclick="deleteUser('${User.id}')"><i class="fa fa-trash-o" aria-hidden="true"></i></button>
                                  
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
    <script src="${pageContext.request.contextPath}/static/assets/js/jquery.metisMenu.js"></script>
     <!-- DATA TABLE SCRIPTS -->
    <script src="${pageContext.request.contextPath}/static/assets/js/dataTables/jquery.dataTables.js"></script>
    <script src="${pageContext.request.contextPath}/static/assets/js/dataTables/dataTables.bootstrap.js"></script>
    <script src="${pageContext.request.contextPath}/static/js/project/project_users.js"></script>
</html>