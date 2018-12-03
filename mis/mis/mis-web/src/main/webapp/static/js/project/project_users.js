$(function(){
	$('#dataTables-example').dataTable();
	$("#main-menu li a").removeClass("active-menu");
    $("#projectInfo").addClass("active-menu");
});

$(function(){
	$("#addEditButton").on("click",function(){ 
		var userId = $("#userId").val();
		var roleId = $("#roleId").val();
	  var projectId = $("#projectId_").val();
		$.ajax({
			url:path+'/project/addProjectUserRole.do',
			type:'post',
			dataType:'json',
			data:{'userId':userId,'roleId':roleId,'projectId':projectId},
			success:function(data){
				console.log(data);
				if(data.code==1){
					$("#addEditModal").modal('hide');
					layer.msg('成功了！', {time: 2000, icon:6});
					window.location.href=path+'/project/projectUserRender.do?projectId='+projectId;
				}else{
					$("#addEditModal").modal('hide');
					layer.msg('失败了！', {time: 2000, icon:5});
				}
			}
		});
		
	}); 
	 
	
	$(".editProjectBtn").on("click",function(){
		var projectId = $("#proejct_delete").attr("data-id");
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
 
 function deleteUser(userId,roleId){
	 var projectId = $("#projectId_").val();
	 $.ajax({
			url:path+'/project/deleteProjectUserRole.do',
			type:'post',
			dataType:'json',
			data:{'userId':userId,'roleId':roleId,'projectId':projectId},
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
}
