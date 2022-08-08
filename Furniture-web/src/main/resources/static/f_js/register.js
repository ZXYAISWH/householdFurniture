//注册页面的js

//验证手机号的正则表达式
phoneRex = /^1([38][0-9]|4[579]|5[0-3,5-9]|6[6]|7[0135678]|9[89])\d{8}$/;
passwordRex = /^(?=.*[A-Za-z])(?=.*\d)[A-Za-z\d]{6,18}$/;

let verificationCode;

//处理账号

$("input[name=phone]").blur(function () {
    if (phoneRex.test(this.value)) {
        $.ajax({
            url: "/householdFurniture/login/selectPhoneExist/" + this.value,
            type: "get",
            dataType: "json",
            async: true,
            success: function (datas) {
                let data = datas.data;
                let code = datas.code;
                if (code = 1000) {
                    if (data == "手机号已被注册") {
                        rulesCellPhone("red", "×")
                    } else {
                        rulesCellPhone("green", "√")
                    }
                }
            }
        })
    } else {
        rulesCellPhone("red", "×")
    }
})

function rulesCellPhone(color, result) {
    $("#rulesCellPhone").html(result).css({
        marginLeft: 10,
        fontSize: 25,
        color: color
    })
}

//处理密码

$("input[name=password]").blur(function () {
    if (passwordRex.test(this.value)) {
        rulesCellPass("green", "√")
    } else {
        rulesCellPass("red", "×")
    }
})

function rulesCellPass(color, result) {
    $("#rulesCellPass").html(result).css({
        marginLeft: 10,
        fontSize: 25,
        color: color
    })
}

//处理确认密码

$("input[name=confirm-password]").blur(function () {
    if (passwordRex.test(this.value) && $("input[name=password]").val() == this.value) {
        confirmRulesCellPass("green", "√")
    } else {
        confirmRulesCellPass("red", "×")
    }
})

function confirmRulesCellPass(color, result) {
    $("#confirmRulesCellPass").html(result).css({
        marginLeft: 10,
        fontSize: 25,
        color: color
    })
}

//处理验证码

$("#verification-code").on("click", function () {
    let value = $("input[name=phone]").val();
    if (phoneRex.test(value)) {
        $.ajax({
            url: "/householdFurniture/login/getVerificationCode/" + value,
            type: "get",
            dataType: "json",
            async: true,
            success: function (datas) {
                let data = datas.data;
                let code = datas.code
                if (code = 1000) {
                    verificationCode = data;
                }
            }
        })
    }
})

$("#verification").blur(function () {
    if (this.value == verificationCode) {
        verificationCodes("green", "√");
    } else {
        verificationCodes("red", "×");
    }
})

function verificationCodes(color, result) {
    $("#verificationCode").html(result).css({
        marginLeft: 6,
        fontSize: 25,
        color: color
    })
    $("#verification").css({
        marginLeft: -8
    })
}

//点击注册

$("#register").click(function () {
    let phone = $("input[name=phone]").val();
    let pass = $("input[name=password]").val();
    let confirmPassword = $("input[name=confirm-password]").val();
    let verification = $("#verification").val();
    if (phone != null && phone != "" && pass != null && pass != "" && confirmPassword != null && confirmPassword != "" && verification != null && verification != "" && pass == confirmPassword) {
        let user = {
            phone: $("input[name=phone]").val(),
            password: $("input[name=password]").val()
        }
        $.post("/householdFurniture/login/userRegister", user, function (datas) {
            let data = datas.data;
            let code = datas.code
            if (data == "注册成功") {
                location.href = "login.html";
            }
        }, "json");
    }
})

