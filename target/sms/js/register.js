$(function(){
    checkNull();
    register();     //提交注册信息

});
//注册
function register(){
	$("#btn").click(function(){
        var staff = {
            name:$("#username").val(),
            password:$("#password").val(),
            email:$("#box").val(),
            birthday:$("#birthday").val(),
            sex:$("#gender").val()
        };
        console.log(staff);
        JSON.stringify(staff);
        $.ajax({
            url:"http://localhost:8080/member/register.do",
            type:"POST",
            contentType:"application/json",
            data:JSON.stringify(staff),
            success:function(data){
                // 5成功,6失败,8用户名已存在
                console.log(data);
                if(data.status == 5){
                    location.href = ""
                }
                if(data.status == 6){
                    alert("注册失败");
                }
                if(data.status == 8){
                    alert("用户已存在");
                }
            
            },
            error:function(){ console.log("ajax失败");console.log(staff)}
        });
	});
}
//判空
function checkNull(){
        for(var i=0;i<5;i++){
            $("input").eq(i).blur(function(){
                if($(this).val()==null || $(this).val()==""){
                    $(this).next("span").removeClass("tip").addClass("warning");
                }else{
                    $(this).next("span").css("display","none");
                }
            })
        }
    }