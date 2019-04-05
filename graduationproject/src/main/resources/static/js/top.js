/**
 * @Auther: Vgbh
 *
 * Top Bar
 */

//一周过期
function setCookie(name, value) {
    var exp = new Date();
    exp.setTime(exp.getTime() + 60 * 60 * 1000 * 24 * 7);
    document.cookie = name + "=" + value + ";expires=" + exp.toGMTString() + ";path=/";
}

//读取cookies
function getCookie(name) {
    var arr, reg = new RegExp("(^| )" + name + "=([^;]*)(;|$)");

    if (arr = document.cookie.match(reg))

        return unescape(arr[2]);
    else
        return null;
}

Home = function () {
    window.location.href = "http://localhost:8080/home";
}

Log_In = function () {
    if (getCookie("token")) {
        alert("您已登录！");
    } else {
        window.location.href = "http://localhost:8080/login";
    }
}

Sign_Out = function () {
    //console.log("已删除Token!");
    setCookie("token", "");
}

User_Info = function () {
    if (getCookie("token")) {
        window.location.href = "http://localhost:8080/userinfo";
    } else {T
        alert("请先登录！");
        window.location.href = "http://localhost:8080/login";
    }
}

loadUserInfo = function () {
    console.log(getCookie("userId"));
}