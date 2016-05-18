$(function(){
    // 获取当前员工信息

    var userId = parseInt(sessionStorage.Id);
    var userRank = sessionStorage.userRank;//字符串
    var loginName =sessionStorage.loginName;
    var password =sessionStorage.password;
    var email=sessionStorage.email;
    var birthday=sessionStorage.birthday;
    var sex=sessionStorage.sex;

    $("#username").val(loginName);
    $("#password").val(password);
    $("#box").val(email);
    $("#birthday").val(birthday);
    $("#gender").val(sex);

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
            success:function(){
                alert("修改成功！");
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