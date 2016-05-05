$(function(){
    //登陆的提交事件
    $("#loginSumbit").click(function(){
      var username=$("#user").val();
      var password= $("#psw").val();
      var data={
                username:username,
                password:password
      }
      console.log(data);
        // $.ajax({
        //     url:,
        //     data:{
        //         username:username,
        //         password:password
        //     }
        //     type:"POST",
        //     contentType:"application/json",
        //     success:function(data){
            
        //     },
        //     error:function(){ console.log("发送ajax失败");}
        // });

    });
    //检查是否为空
    function checkNull(){
        for(var i=0;i<2;i++){
            $("input").eq(i).blur(function(){
                if($(this).val()==null || $(this).val()==""){
                    $(this).next().addClass("warning").css("color","#8a6d3b");
                    console.log("hello");
                    console.log($(this).next().val());  
                }
            })
        }
    }

});