 $(document).ready(function () {
   /* $('#dataTables-example').dataTable();*/
    $("#main-menu li a").removeClass("active-menu");
	$("#taskInfo").addClass("active-menu");
 
	 
	   
 });
 
 $(function(){
	$("#addEditButton").on("click",function(){
		$.ajax({
			url:path+'/project/addEditPro.do',
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
			url:path+'/project/deletePro.do',
			type:'post',
			dataType:'json',
			data:{'projectId':projectId},
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

