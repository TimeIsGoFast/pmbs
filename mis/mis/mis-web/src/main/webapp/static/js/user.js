 $(document).ready(function () {
   /* $('#dataTables-example').dataTable();*/
    $("#dataTables-example").dataTable().fnDraw(false);  
    $("#main-menu li a").removeClass("active-menu");
	$("#userManage").addClass("active-menu");
	
	 $('#addEditForm').bootstrapValidator({
			//   live: 'disabled',
			   message: 'This value is not valid',
			   feedbackIcons: {
			       valid: 'glyphicon glyphicon-ok',
			       invalid: 'glyphicon glyphicon-remove',
			       validating: 'glyphicon glyphicon-refresh'
			   },
			   fields: {
				   uid: {
			           container: '#userIdMessage',
			           validators: {
			               notEmpty: {
			                   message: '账号不能为空'
			               }
			           }
			       },
				   name: {
			           container: '#nameMessage',
			           validators: {
			               notEmpty: {
			                   message: '姓名或昵称不能为空'
			               }
			           }
			       },
			       password: {
			           container: '#passwordMessage',
			           validators: {
			               notEmpty: {
			                   message: '密码不能为空'
			               }
			           }
			       },
			       mail: {
			           container: '#emailMessage',
			           validators: {
			        	   emailAddress: {
		                        message: '不是email地址'
		                    }
			           }
			       },
			       tel: {
			           container: '#telMessage',
			           validators: {
			        	   regexp: {
		                        regexp: /^1[3|4|5|8][0-9]\d{4,8}$/,
		                        message: '不是一个电话号'
		                    },
			           }
			       }
			      
			      
			   }
			});
	
	
});
 function deleteUser(id){
	    $("#deleteUserId").val(id);
		$('#deleteModal').modal('show');
}
 $(function(){
	$("#deleteUser2").click(function(){
		var id = $("#deleteUserId").val();
		$.ajax({
			type:'post',
			url:path+'/user/deleteUser.do',
			data:{'id':id},
			dataType:'json',
			success:function(data){
				if(data==1){
					$('#deleteModal').modal('hide');
					window.location.reload();
				}
			},
		});
			
			
	}); 
	
	$("#addEditButton").on("click",function(){
		$.ajax({
			url:path+'/user/addEditUser.do',
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
	
/*	$("#editUserBtn").on("click",function(){
		var userId = $("#editUserBtn").attr("data-id");
		$.ajax({
			url:path+'/user/getUserInfo.do',
			type:'post',
			dataType:'json',
			data:{'id':userId},
			success:function(data){
				console.log(data);
			    $("#user_id").val(data.id);
			    $("#userId").val(data.uid);
			    $("#name").val(data.name);
			    $("#mail").val(data.mail);
			    $('#password').val(data.password);
			    $("#sex").val(data.sex);
			    $("#tel").val(data.tel);
			    $("#addEditModal").modal('show');
			}
		});
		
	});*/
 });
 
 function editUserBtn(id){
		$.ajax({
			url:path+'/user/getUserInfo.do',
			type:'post',
			dataType:'json',
			data:{'id':id},
			success:function(data){
				console.log(data);
			    $("#user_id").val(data.id);
			    $("#userId").val(data.uid);
			    $("#name").val(data.name);
			    $("#mail").val(data.mail);
			    $('#password').val(data.password);
			    $("#sex").val(data.sex);
			    $("#remark").val(data.remark);
			    $("#tel").val(data.tel);
			    $("#addEditModal").modal('show');
			}
		});
 }