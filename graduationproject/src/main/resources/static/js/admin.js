/**
 * @Auther: Vgbh
 *
 * Admin.html
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
                header_token: xhr.getResponseHeader("token")
            });
        }
    }
    if (typeof(data) === 'object') {
        data = JSON.stringify(data);
    }
    xhr.send(data);
}

//Admin login
adminLogin = function () {

}

//添加Financial信息
insertFinancial = function () {
    
}

//添加Loan信息
insertLoan = function () {

}