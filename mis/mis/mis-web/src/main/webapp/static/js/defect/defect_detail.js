$(document).ready(function () {
   /* $('#dataTables-example').dataTable();*/
    /*$("#dataTables-example").dataTable().fnDraw(false); */ 
    $("#main-menu li a").removeClass("active-menu");
	$("#defectInfo").addClass("active-menu");
	 $('#addEditForm').bootstrapValidator({
	//   live: 'disabled',
	   message: 'This value is not valid',
	   feedbackIcons: {
	       valid: 'glyphicon glyphicon-ok',
	       invalid: 'glyphicon glyphicon-remove',
	       validating: 'glyphicon glyphicon-refresh'
	   },
	   fields: {
		   shortname: {
	           container: '#shortnameMessage',
	           validators: {
	               notEmpty: {
	                   message: '简称不能为空'
	               }
	           }
	       },
		   name: {
	           container: '#nameMessage',
	           validators: {
	               notEmpty: {
	                   message: '项目名不能为空'
	               }
	           }
	       },
	       department: {
	           container: '#departmentMessage',
	           validators: {
	               notEmpty: {
	                   message: '部门不能为空'
	               }
	           }
	       }
	      
	   }
	});
	   
 });
 
 $(function(){
	$("#zhuanpaiBtn").on("click",function(){
		var code = 2;
		var defectId = $("#defect_id").val();
		var resolution = $("#assigneeUidmodel").val();
		$.ajax({
			url:path+'/defect/updateStatus.do',
			type:'post',
			dataType:'json',
			data:{'defectId':defectId,'code':code,'resolution':resolution},
			success:function(data){
				console.log(data);
				if(data.code==1){
					$("#addEditModal").modal('hide');
					layer.msg('成功了！', {time: 2000, icon:6});
					window.location.reload();
				}else{
					$("#addEditModal").modal('hide');
					layer.msg('请检查项目名是否重复！', {time: 2000, icon:5});
				}
			}
		});
		
	}); 
	 
	
	$("#resolutionBtn").on("click",function(){
		var defectId = $("#defect_id").val();
		var code=1;
		var resolution = $("#reolution").val();
		$.ajax({
			url:path+'/defect/updateStatus.do',
			type:'post',
			dataType:'json',
			data:{'defectId':defectId,'code':code,'resolution':resolution},
			success:function(data){
				console.log(data);
				if(data.code==1){
					layer.msg('删除成功！', {time: 2000, icon:6});
					window.location.reload();
				}else{
					layer.msg('删除失败了！', {time: 2000, icon:5});
					window.location.reload();
				}
			}
		});
	});
	
	$(".editProjectBtn").on("click",function(){
		var projectId = $(this).attr("data-id");
		$.ajax({
			url:path+'/project/getProjectInfo.do',
			type:'post',
			dataType:'json',
			data:{'projectId':projectId},
			success:function(data){
				console.log(data);
			    $("#project_id").val(data.id);
			    $("#projectName").val(data.name);
			    $("#shortname").val(data.shortname);
			    $("#descr").val(data.descr);
			    $('#ownerId').selectpicker('val', data.ownerId);
			    $("#department").val(data.department);
			    $("#addEditModal").modal('show');
			}
		});
		
	});
 });
 
 function deleteProjectBtn(id){
	   $("#delete_project_id").val(id)
		$('#deleteModal').modal('show');
}