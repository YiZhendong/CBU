$(function(){

    alert（'i am ok'）
    //登陆的提交事件
    $("#search_btn").click(function(){

        var search=$("#search").val();

        var user={
            name:search,

        };
        $.ajax({
            url:"http://localhost:8080//member/movie/searchByName.do?name="+search,
            type:"POST",
            contentType:"application/json",
            success:function(data){
                var search = eval(data.body);


                sessionStorage.filmName = message.name;
                sessionStorage.filmId = message.id;
                sessionStorage.score=message.score;

                location.href = "http://localhost:8080/html/search_page.html"
            },
            error:function(){ console.log("发送ajax失败");}
        });

    });
});