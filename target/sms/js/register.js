$(function(){
    register();     //提交注册信息
});
function register(){
	$("#btn").click(function(){
        var staff = {
            userName:$("#username").val(),
            password:$("#password").val(),
            box:$("#box").val(),
            birthday:$("#birthday").val(),
            gender:$("#gender")
        };
        // console.log(staff);
        $.ajax({
            url:,
            type:"POST",
            contentType:"application/json",
            data:JSON.stringify(staff),
            success:function(data){

            
            },
            error:function(){ console.log("发送ajax失败");}
        });
	});
}