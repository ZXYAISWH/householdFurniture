passwordRex = /^(?=.*[A-Za-z])(?=.*\d)[A-Za-z\d]{6,16}$/;
let img = [];
$(function () {
    account = localStorage.getItem("account")
    $.get("/householdFurniture/login/getAllImgCodeUrl", function (datas) {
        let data = datas.data;
        let code = datas.code
        if (code == 1000) {
            for (let i = 0; i < data.length; i++) {
                img.unshift(data[i]);
            }
        }
    }, "json")
})

function equalIgnoreCase(key, value) {
    if (key.toLowerCase() == value.toLowerCase()) {
        return true;
    } else {
        return false;
    }
}

$("#codeImg").click(function () {
    let random = Math.abs(Math.floor(Math.random() * img.length - 1));
    $("#codeImg").prop("src", "img/code/" + img[random]);
})

$("#newPassword").blur(function () {
    if (passwordRex.test(this.value)) {
        $("#newPasswordResult").html("√").css({
            fontSize: 25,
            color: "green",
            marginLeft: -115
        })
    } else {
        $("#newPasswordResult").html("×").css({
            fontSize: 25,
            color: "red",
            marginLeft: -115
        })
    }
})

$("#repeatNewPassword").blur(function () {
    if (passwordRex.test(this.value) && this.value == $("#newPassword").val()) {
        $("#repeatNewPasswordResult").html("√").css({
            fontSize: 25,
            color: "green",
            marginLeft: -115
        })
    } else {
        $("#repeatNewPasswordResult").html("×").css({
            fontSize: 25,
            color: "red",
            marginLeft: -115
        })
    }
})


$("#code").blur(function () {
    let codeImg = $("#codeImg").prop("src")
    if (codeImg.includes("one")) {
        if (equalIgnoreCase(this.value, "oaqr")) {
            green()
        } else {
            red()
        }
    } else if (codeImg.includes("two")) {
        if (equalIgnoreCase(this.value, "oaqr")) {
            green()
        } else {
            red()
        }
    } else if (codeImg.includes("three")) {
        if (equalIgnoreCase(this.value, "oasa")) {
            green()
        } else {
            red()
        }
    } else if (codeImg.includes("four")) {
        if (equalIgnoreCase(this.value, "obdb")) {
            green()
        } else {
            red()
        }
    } else if (codeImg.includes("five")) {
        if (equalIgnoreCase(this.value, "obdp")) {
            green()
        } else {
            red()
        }
    }
})

$("#submit").click(function () {
    let pass = $("#newPasswordResult").html();
    let p = $("#repeatNewPasswordResult").html();
    let code = $("#codeResult").html();
    let oldPass = $("#oldPassword").val()
    let newPass = $("#newPassword").val()
    if (pass == "√" && p == "√" && code == "√" && oldPass != null && oldPass != "") {
        var pwd = {
            oldPass,
            newPass,
            account
        }
        $.post("/householdFurniture/personal/changePassword", pwd, function (datas) {
            let data = datas.data;
            let code = datas.code
            if (code == 1000) {
                if ("密码正确" == data) {
                    location.href = "login.html";
                }
            }
        }, "json");
    }


})

function green() {
    $("#codeResult").html("√").css({
        fontSize: 25,
        color: "green",
        marginLeft: -115
    })
}

function red() {
    $("#codeResult").html("×").css({
        fontSize: 25,
        color: "red",
        marginLeft: -115
    })
}

