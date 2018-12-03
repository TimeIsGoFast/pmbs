<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>任务管理</title>
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
                          <span><i class="fa fa-book" aria-hidden="true"></i>&nbsp;&nbsp;我的任务</span>
                        </div>
                        <div class="panel-body">
                                   
                 <c:forEach items="${defects}" var="Defect">
                  <div class="row">
                     <div class="col-md-12 col-sm-12 col-xs-12">
                        <div class="panel panel-default">
                            <div class="panel-heading">
                              	   解决缺陷： ${Defect.name}<a href="#" class="btn btn-default" style="margin:20px 20px;" data-toggle="modal" ><i class="fa fa-check-square-o"></i>&nbsp;点击关闭</a>
                            </div>
                            <div class="panel-body">
                            <div class="col-sm-12">
                                   	摘要：<a href="${pageContext.request.contextPath}/defect/getDetail.do?defectId=${Defect.id}">${Defect.summary }</a>
                              </div> 
                              <br>
                              
                            </div>
                        </div>

                    </div>
                </div>
                 </c:forEach>
                  <c:forEach items="${testplans}" var="TestPlan">
                  <div class="row">
                     <div class="col-md-12 col-sm-12 col-xs-12">
                        <div class="panel panel-default">
                            <div class="panel-heading">
                              	  完成:  ${TestPlan.name}
                            </div>
                            <div class="panel-body">
                            <div class="col-sm-12">
                                  <div class="col-sm-12">
                                   	描述：<a href="${pageContext.request.contextPath}/defect/getDetail.do?defectId=${Defect.id}">${TestPlan.descr }</a>
                              </div> 
                              <br>
                              
                              </div> 
                            </div>
                        </div>

                    </div>
                </div>
                 </c:forEach>
          
         
                
                        </div>
                    </div>
                    <!--End Advanced Tables -->
                </div>
            </div>                       
    <script src="${pageContext.request.contextPath}/static/js/bootstrap-select.js"></script>

   <script src="${pageContext.request.contextPath}/static/js/task.js"></script>
