/**
 * @Auther: Vgbh
 *
 * Top Bar And Others
 */

element = function (str) {
    return document.getElementById(str);
}

elementVal = function (str) {
    return document.getElementById(str).value;
}

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

//前往Home页面
Home = function () {
    window.location.href = "/home";
}

//前往登陆页面
Log_In = function () {
    if (getCookie("token")) {
        alert("您已登录！");
    } else {
        window.location.href = "/login";
    }
}

//登出
Sign_Out = function () {
    setCookie("token", "");
    setCookie("userId", "");
    setCookie("userName", "");
    setCookie("role", "");
    alert("已退出登录！")
}

//用户信息页面分流
User_Info = function () {
    if (getCookie("token")) {
        window.location.href = "/userinfo";
    } else {
        alert("请先登录！");
        window.location.href = "/login";
    }
}

//请求
function requestData(url, method, data, cb) {
    var xhr = new XMLHttpRequest();
    xhr.open(method || 'get', url, true);
    xhr.setRequestHeader("Content-Type", "application/json");
    xhr.onreadystatechange = function () {
        if (xhr.readyState === 4) {
            var result = xhr.response;
            cb && cb({
                status: xhr.status,
                data: result
                // header_token: xhr.getResponseHeader("token"),
                // header_userId: xhr.getResponseHeader("userId")
            });
        }
    }
    if (typeof(data) === 'object') {
        data = JSON.stringify(data);
    }
    xhr.send(data);
}

//加载用户信息
loadUserInfo = function () {
    if (!getCookie("userId")) {
        return;
    }
    // console.log(getCookie("userId"));
    requestData("/userinfo/one/"+getCookie("userId"), 'get', {}, function (res) {
        // console.log(JSON.parse(res.data)["data"]);
        if (res.status === 200) {
            var json = JSON.parse(res.data)["data"];
            var email = document.getElementById("email");
            var card = document.getElementById("idCard");
            var phone = document.getElementById("phone");
            if (json["email"] != null) {
                email.value = json["email"];
            }
            if (json["idCard"] != null) {
                card.value = json["idCard"];
            }
            if (json["phone"] != null) {
                phone.value = json["phone"];
            }
        } else {
            alert("Error:" + res.data);
        }
    });
}

//检查邮箱地址格式
checkEmail = function () {
    var emailReg = /^[a-zA-Z0-9_-]+@([a-zA-Z0-9]+\.)+(com|cn|net|org)$/;
    var email = document.getElementById("email");
    var emailerror = document.getElementById("emailerror");
    if (email.value == "") {
        return;
    }
    if (emailReg.test(email.value)) {
        emailerror.style.display = "none";
    } else {
        emailerror.style.display = "inline";
    }
}

//检查身份证格式并检查是否重复
checkIdcard = function () {
    var cardReg = /^[1-9]{1}[0-9]{14}$|^[1-9]{1}[0-9]{16}([0-9]|[Xx])$/;
    var card = element("idCard");
    var carderror = element("idcarderror");
    if (card.value == "") {
        return;
    }
    if (cardReg.test(card.value)) {
        carderror.style.display = "none";
    } else {
        carderror.style.display = "inline";
        return;
    }
    requestData("/userinfo/checkcard/"+card.value, 'get', {}, function (res) {
        if (res.status === 200) {
            var json = JSON.parse(res.data);
            // console.log(json)
            if (json["data"]) {
                carderror.style.display = "inline";
            } else {
                carderror.style.display = "none";
            }
        } else {
            alert("Error:" + res.data);
        }
    });
}

//检查手机格式
checkPhone = function () {
    var phoneReg = /^1[3|4|5|7|8][0-9]\d{8,11}$/;
    var phone = document.getElementById("phone");
    var phoneerror = document.getElementById("phoneerror");
    if (phone.value == "") {
        return;
    }
    if (phoneReg.test(phone.value)) {
        phoneerror.style.display = "none";
    } else {
        phoneerror.style.display = "inline";
    }
}

//检查身份证号格式
checkIdcard2 = function () {
    var cardReg = /^[1-9]{1}[0-9]{14}$|^[1-9]{1}[0-9]{16}([0-9]|[Xx])$/;
    var card = element("idCard");
    var carderror = element("idcarderror");
    if (card.value == "") {
        return;
    }
    if (cardReg.test(card.value)) {
        carderror.style.display = "none";
    } else {
        carderror.style.display = "inline";
        return;
    }
}

//修改用户信息的提交
updateUserInfo = function () {
    var email = document.getElementById("email");
    var card = document.getElementById("idCard");
    var phone = document.getElementById("phone");
    if (getCookie("userId")) {
        requestData('/userinfo/update', 'post', {
            "userId": getCookie("userId"),
            "email": email.value,
            "idCard": card.value,
            "phone": phone.value
        }, function (res) {
            // console.log(JSON.parse(res.data));
            if (res.status === 200) {
                alert("Update Successfully!");
            } else {
                alert("Error:" + res.data);
            }
        });
    } else {
        alert("System Error!");
    }
}

function dayInnerHtml(i, x) {
    switch (parseInt(i)) {
        case 0:
            var one = document.getElementById("day_One");
            one.innerHTML = x;break;
        case 1:
            var two = document.getElementById("day_Two");
            two.innerHTML = x;break;
        case 2:
            var three = document.getElementById("day_Three");
            three.innerHTML = x;break;
        case 3:
            var four = document.getElementById("day_Four");
            four.innerHTML = x;break;
        case 4:
            var five = document.getElementById("day_Five");
            five.innerHTML = x;break;
        case 5:
            var six = document.getElementById("day_Six");
            six.innerHTML = x;break;
        case 6:
            var seven = document.getElementById("day_Seven");
            seven.innerHTML = x;break;
        default:
            console.log("error!");break;
    }
}

//修改用户密码
updatePassword = function () {
    var repeatPwd = element("repeatPwd")
    if (elementVal("password1") != elementVal("password2")) {
        repeatPwd.style.display = "inline";
        element("password2").value = "";
        return;
    }
    repeatPwd.style.display = "none";

    requestData('/userinfo/check', 'post', {
        "phone" : elementVal("phone"),
        "idCard" : elementVal("idCard")
    }, function (res) {
        if (res.status === 200) {
            // console.log(JSON.parse(res.data));
            var json = JSON.parse(res.data);
            if (json["code"] === 200) {
                // console.log(json["data"]["userId"]);
                requestData('/auth/updatepwd', 'post', {
                    "password" : elementVal("password1"),
                    "userId" : json["data"]["userId"]
                }, function (res) {
                    if (res.status === 200) {
                        // console.log(JSON.parse(res.data));
                        alert("修改密码成功！");
                        window.location.href = "/login"
                    } else {
                        alert("Error:" + res.data);
                    }
                });
            } else {
                alert("Error:" + json["errorMsg"]);
            }
        } else {
            alert("Error:" + res.data);
        }
    });
}

