let img = [];
let account;
let phoneRex = /^1([38][0-9]|4[579]|5[0-3,5-9]|6[6]|7[0135678]|9[89])\d{8}$/;
let emailRex = /^\w{5,}@[a-z0-9]{2,3}\.[a-z]+$|\,$/
let codes;
//获取所有验证码的路径
$(function () {
    $("#accountResult").hide();
    hideErrorCode();
    $.get("/householdFurniture/login/getAllImgCodeUrl", function (datas) {
        let data = datas.data;
        let code = datas.code;
        if (code == 1000) {
            for (let i = 0; i < data.length; i++) {
                img.unshift(data[i]);
            }
        }
    }, "json")
})

//切换验证码
$("#code-img").click(function () {
    let random = Math.abs(Math.floor(Math.random() * img.length - 1));
    let imgUrl = img[random];
    let chooseImgUrl = $("#code-img").prop("src");
    chooseImgUrl = chooseImgUrl + "";
    if (chooseImgUrl.indexOf(imgUrl) != -1) {
        random = Math.abs(Math.floor(Math.random() * img.length - 1));
        imgUrl = img[random];
    }
    $("#code-img").prop("src", "img/code/" + imgUrl);
})

//下一步
$("#next").click(function () {
    let account = $("#account").val();
    let imgUrl = $("#code-img").prop("src");
    let code = $("#code").val();
    if (imgUrl.includes("one")) {
        if (equalIgnoreCase(code, "oaqr")) {
            hideErrorCode();
            ajax(account, "json");
        } else {
            showErrorCode();
        }
    } else if (imgUrl.includes("two")) {
        if (equalIgnoreCase(code, "oaqr")) {
            hideErrorCode();
            ajax(account, "json");
        } else {
            showErrorCode();
        }
    } else if (imgUrl.includes("three")) {
        if (equalIgnoreCase(code, "oasa")) {
            hideErrorCode();
            ajax(account, "json")
        } else {
            showErrorCode();
        }
    } else if (imgUrl.includes("four")) {
        if (equalIgnoreCase(code, "obdb")) {
            hideErrorCode();
            ajax(account, "json")
        } else {
            showErrorCode();
        }
    } else if (imgUrl.includes("five")) {
        if (equalIgnoreCase(code, "obdp")) {
            hideErrorCode();
            ajax(account, "json")
        } else {
            showErrorCode();
        }
    }
    if (phoneRex.test(account)) {
        $("#next1").prop("value", "手机验证")
        $("#emailText").hide();
        $("#promptEmail").hide();
        $("#phoneText").show();
        $("#promptPhone").show();
        $.get("/householdFurniture/login/sendPhoneCode/" + account, function (datas) {
            let data = datas.data;
            let code = datas.code;
            if (code == 1000) {
                codes = data;
            }
            $("#phone").html(account.replace(account.substring(3, 7), "****"));
        }, "json");
    } else if (emailRex.test(account)) {
        $("#emailText").show();
        $("#promptEmail").show();
        $("#phoneText").hide();
        $("#promptPhone").hide();
        $("#email").html(account.replace(account.substring(5, account.indexOf("@")), "*****"));
        $.get("/householdFurniture/login/sendEmailCode/" + account, function (datas) {
            let data = datas.data;
            let code = datas.code;
            if (code == 1000) {
                codes = data;
            }
        }, "json");
    }
})

function equalIgnoreCase(key, value) {
    if (key.toLowerCase() == value.toLowerCase()) {
        return true;
    } else {
        return false;
    }
}

function ajax(value, type) {
    account = value;
    $.ajax({
        url: "/householdFurniture/login/selectAccountIfExist/" + value,
        type: "get",
        async: true,
        dataType: type,
        success: function (datas) {
            $("#accountResult").hide();
            let data = datas.data;
            let code = datas.code;
            if (code == 1000) {
                if (data == "账号存在") {
                    $(".two").show();
                    $(".one").hide();
                    $(".forCon ul li").eq(1).addClass("on").siblings("li").removeClass("on");
                } else {
                    $("#accountResult").show().css({
                        fontSize: 20,
                        color: "red"
                    });
                }
            }
        }
    })
}

function showErrorCode() {
    $("#errorCode").show().css({
        fontSize: 20,
        color: "red"
    });
}

function hideErrorCode() {
    $("#errorCode").hide();
}

$("#next1").click(function () {
    if (codes == $("#accountCode").val()) {
        $(".three").show();
        $(".two").hide();
        $(".forCon ul li").eq(2).addClass("on").siblings("li").removeClass("on");
        $("#passResult").hide();
    }
})


$("#complete").click(function () {
    let password = $("#password").val();
    let surePassword = $("#surePassword").val();
    if (password == surePassword) {
        let pass = {
            password,
            account
        }
        $.ajax({
            url: "/householdFurniture/login/changePass",
            type: "put",
            async: true,
            dataType: "json",
            data: pass,
            success: function (datas) {
                let data = datas.data;
                let code = datas.code;
                if (code == 1000) {
                    location.href = "login.html";
                }
            }
        })
    } else {
        $("#passResult").show();
    }
})



