$(function(){
    checkNull();
    //登陆的提交事件
    $("#loginSumbit").click(function(){
      
      var username=$("#user").val();
      var password= $("#psw").val();
      var user={
                name:username,
                password:password
      }
        $.ajax({
            url:"http://localhost:8080/member/login.do?name="+username +"&password="+ password,
            type:"POST",
            contentType:"application/json",
            success:function(data){

                var message = eval(data.body);

                 //0管理员 1老板 2客户经理 3用户 7用户不存在 9密码不正确
                if(data.status == 0){
                     sessionStorage.userRank = "管理员";// 用户身份
                     sessionStorage.Id = message.id;
                     sessionStorage.loginName = message.Name;
                     sessionStorage.password = message.password;
                     sessionStorage.sex=message.sex;
                     sessionStorage.email=message.email;
                     sessionStorage.birthday=message.birthday;
                     
                     location.href = "Test_manager.html"
                }
                if(data.status== 1){
                    sessionStorage.userRank = "老板";// 用户身份
                    sessionStorage.Id = message.id;
                     sessionStorage.loginName = message.Name;
                     sessionStorage.password = message.password;
                     sessionStorage.sex=message.sex;
                     sessionStorage.email=message.email;
                     sessionStorage.birthday=message.birthday;
                     
                     location.href = "http://localhost:8080/html/Test_boss.html"
                }
                if(data.status== 2){
                    sessionStorage.userRank = "客户经理";// 用户身份
                    sessionStorage.Id = message.id;
                     sessionStorage.loginName = message.Name;
                     sessionStorage.password = message.password;
                     sessionStorage.sex=message.sex;
                     sessionStorage.email=message.email;
                     sessionStorage.birthday=message.birthday;
                     
                     location.href = "Test_CustomerManager.html"
                }
                if(data.status== 3){
                    sessionStorage.userRank = "用户";// 用户身份
                    sessionStorage.Id = message.id;
                     sessionStorage.loginName = message.Name;
                     sessionStorage.password = message.password;
                     sessionStorage.sex=message.sex;
                     sessionStorage.email=message.email;
                     sessionStorage.birthday=message.birthday;
                     
                     location.href = "Test_user.html"
                }
                if(data.status == 7){
                    alert("用户不存在");
                }
                if(data.status == 9){
                    alert("密码不正确");
                }
                else{
                    location.href = "Test_user.html"
                }


            },
            error:function(){ console.log("发送ajax失败");}
        });

    });
    //检查是否为空
    function checkNull(){
        for(var i=0;i<2;i++){
            $("input").eq(i).blur(function(){
                if($(this).val()==null || $(this).val()==""){
                    $(this).next("span").removeClass("tip").addClass("warning");
                }else{
                    $(this).next("span").css("display","none");
                }
            })
        }
    }

});