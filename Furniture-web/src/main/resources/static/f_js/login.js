//登录页面的js

//获取cookie
$(function () {
    $("#prompt").hide()
    $("#accountOrPasswordError").hide()
    $.ajax({
        url: "/householdFurniture/login/getAllCookie",
        type: "get",
        async: true,
        dataType: "json",
        success: function (datas) {
            console.log(datas)
            let data = datas.data;
            let code = datas.code;
            if (code == 1000) {
                let account = data.account;
                let password = data.password;
                let auto_login = data.auto_login;
                if (account != null && account != '' && password != null && password != '') {
                    $("input[name=account]").val(account);
                    $("input[name=password]").val(password);
                    $("#rememberPass").prop("checked", "checked");
                    if (auto_login == true) {
                        $("#auto_login").prop("checked", "checked");
                    }
                    if (auto_login == "true") {
                        let timer = setTimeout(function () {
                            alert("自动登录")
                            login();
                            clearTimeout(timer);
                        }, 2000)
                    }
                }
            }
        }

    })
})


//点击登录
$("#login").click(function () {
    login();
})

function login() {
    let auto_login = $("#auto_login").prop("checked")
    let rememberPass = $("#rememberPass").prop("checked");
    let account = $("input[name=account]").val();
    let password = $("input[name=password]").val();

    let loginInfo = {
        auto_login,
        rememberPass,
        account,
        password
    }

    if (account == "" || account == null || password == "" || password == null) {
        $("#prompt").show().css({
            color: "red"
        })
    } else {
        $("#prompt").hide()
        $.ajax({
            url: "/householdFurniture/login/userLogin",
            data: loginInfo,
            type: "post",
            async: true,
            dataType: "json",
            success: function (datas) {
                let data = datas.data;
                let code = datas.code;
                if (code == 1000) {
                    if (data == "登录成功") {
                        localStorage.setItem("account",account);
                        sessionStorage.setItem("isLogin","true")
                        location.href = "http://localhost:8080/index.html";
                    } else {
                        $("#accountOrPasswordError").show()
                        $("#accountOrPasswordError").hide(3000)
                    }
                }
            }
        })
    }
}
