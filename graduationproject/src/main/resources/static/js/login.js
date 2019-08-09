/**
 * @Auther: Vgbh
 * Login.html
 */

elementVal = function (str) {
    return document.getElementById(str).value;
}

//一周过期
function setCookie(name, value) {
    var exp = new Date();
    exp.setTime(exp.getTime() + 60 * 60 * 1000 * 24 * 7);
    document.cookie = name + "=" + value + ";expires=" + exp.toGMTString() + ";path=/";
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
                data: result,
                header_token: xhr.getResponseHeader("token"),
                header_userId: xhr.getResponseHeader("userId"),
                header_userName: xhr.getResponseHeader("userName"),
                header_role: xhr.getResponseHeader("role")
            });
        }
    }
    if (typeof(data) === 'object') {
        data = JSON.stringify(data);
    }
    xhr.send(data);
}

//Login
signIn = function (event) {
    event.preventDefault();
    var checked = 0;
    document.querySelector('.form-check-input:checked') === null ? checked = 0  : checked = 1;
    if (elementVal("username") === "" || elementVal("password") === "") {
        return;
    }

    requestData('/auth/login', 'post', {
        "username": elementVal("username"),
        "password": elementVal("password"),
        "rememberMe": checked
    }, function (res) {
        if (res.status === 200) {
            // console.log(res);
            setCookie("token", res.header_token);
            setCookie("userId", res.header_userId);
            setCookie("userName", res.header_userName);
            // setCookie("role", res.header_role);
            // console.log(document.cookie);
            // console.log(getCookie("token"));
            // console.log(getCookie("userId"))
            // console.log(getCookie("userName"));
            alert("登陆成功！");
            window.location.href = "/home";
        } else {
            alert('请求失败: ' + res.data);
        }
    });
    return false;
}

//FindBack
find_Back = function () {
    window.location.href = "/back";
}

//Logon
Log_On = function () {
    var username = document.getElementById("username");
    var pwd1 = document.getElementById("password1");
    var pwd2 = document.getElementById("password2");
    // console.log(username.value);
    // console.log(pwd1.value);
    // console.log(pwd2.value);

    if (pwd1.value != pwd2.value) {
        document.getElementById("showError").style.display = "inline";
        pwd2.value = "";
    } else {
        document.getElementById("showError").style.display = "none";
        //console.log("两次密码一致！");
        requestData('/auth/register', 'post', {
            "username": username.value,
            "password": pwd1.value
        }, function (res) {
            if (res.status === 200) {
                //console.log(JSON.stringify(res.data, "", "   "));
                window.location.href = "/login";
            } else {
                alert('Error' + res.data);
            }
        });
    }
}

//RepeatUsername
repeat = function () {
    var username = document.getElementById("username").value;
    if (username === "") {
        alert("用户名为空！");
        return;
    } else {
        requestData("/userinfo/" + username, 'get',{}, function (res) {
            if (res.status === 200) {
                if (res.data[19] === 't') {
                    document.getElementById("usernameError").style.display = "inline";
                } else {
                    document.getElementById("usernameError").style.display = "none";
                }
                // console.log(JSON.stringify(res.data, "", "   "));
            } else {
                alert('Error' + res.data);
            }
        });
    }
}

//register
register_Box = function () {
    window.location.href = "/register";
}