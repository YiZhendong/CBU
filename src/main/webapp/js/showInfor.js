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
});