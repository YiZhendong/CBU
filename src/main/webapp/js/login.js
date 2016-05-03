$(function(){
    //登陆的提交事件
    $("#loginSumbit").click(function(){
      var username=$("#user").val();
      var password= $("#psw").val();
      var data={
                username:username,
                password:password
      }
      // console.log(data);
        $.ajax({
            url:,
            data:{
                username:username,
                password:password
            }
            type:"POST",
            contentType:"application/json",
            success:function(data){
            
            },
            error:function(){ console.log("发送ajax失败");}
        });

    });
});