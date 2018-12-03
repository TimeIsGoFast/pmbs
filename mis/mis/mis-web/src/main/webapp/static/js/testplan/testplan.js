 $(document).ready(function () {
   /* $('#dataTables-example').dataTable();*/
    $("#dataTables-example").dataTable().fnDraw(false);  
    $("#main-menu li a").removeClass("active-menu");
	$("#testplanInfo").addClass("active-menu");

	 $('#addEditForm').bootstrapValidator({
	//   live: 'disabled',
	   message: 'This value is not valid',
	   feedbackIcons: {
	       valid: 'glyphicon glyphicon-ok',
	       invalid: 'glyphicon glyphicon-remove',
	       validating: 'glyphicon glyphicon-refresh'
	   },
	   fields: {
	
		   name: {
	           container: '#nameMessage',
	           validators: {
	               notEmpty: {
	                   message: '项目名不能为空'
	               }
	           }
	       }

	   }
	});
	   
 });
 
 $(function(){
	$("#addEditButton").on("click",function(){
		$.ajax({
			url:path+'/testplan/addTestPlan.do',
			type:'post',
			dataType:'json',
			data:$("#addEditForm").serialize(),
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
	 
	
	$("#deleteProject").on("click",function(){
		var projectId = $("#delete_project_id").val();
		console.log(projectId);
		$.ajax({
			url:path+'/testplan/deleteplan.do',
			type:'post',
			dataType:'json',
			data:{'planId':projectId},
			success:function(data){
				console.log(data);
				if(data.code==1){
					$("#addEditModal").modal('hide');
					layer.msg('删除成功！', {time: 2000, icon:6});
					window.location.reload();
				}else{
					$("#addEditModal").modal('hide');
					layer.msg('删除失败了！', {time: 2000, icon:5});
					window.location.reload();
				}
			}
		});
	});
	
	$(".editProjectBtn").on("click",function(){
		var projectId = $(this).attr("data-id");
		$.ajax({
			url:path+'/testplan/getPlanInfo.do',
			type:'post',
			dataType:'json',
			data:{'planId':projectId},
			success:function(data){
				console.log(data);
			    $("#project_id").val(data.id);
			    $("#projectName").val(data.name);
			    $("#descr").val(data.descr);
			    $('#assignerId').selectpicker('val', data.assignerId);
			    $("#addEditModal").modal('show');
			}
		});
		
	});
 });
 
 function deleteProjectBtn(id){
	   $("#delete_project_id").val(id)
		$('#deleteModal').modal('show');
}
