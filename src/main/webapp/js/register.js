$(function(){
    checkNull();
    register();     //提交注册信息

});
//注册
function register(){
	$("#btn").click(function(){
        var staff = {
            userName:$("#username").val(),
            password:$("#password").val(),
            box:$("#box").val(),
            birthday:$("#birthday").val(),
            gender:$("#gender")
        };
        $.ajax({
            url:/member/register.do,
            type:"POST",
            contentType:"application/json",
            data:JSON.stringify(staff),
            success:function(data){
                // 5成功,6失败,8用户名已存在
                if(data.status == 5){
                    location.href = ""
                }
                if(data.status == 6){
                    alert("注册失败")；
                }
                if(data.status == 8){
                    alert("用户已存在")；
                }
            
            },
            error:function(){ console.log("发送ajax失败");}
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