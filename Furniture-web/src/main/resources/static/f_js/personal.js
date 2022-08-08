let account;
$(function () {
    account = localStorage.getItem("account");
    $("#account").val(account);
    $.get("/householdFurniture/personal/getUserInfo/" + account, function (datas) {
        let data = datas.data;
        let code = datas.code
        if (code == 1000) {
            $("#name").html(data.nickName);
            $("#birthday").html(data.birthday);
            $("#sex").html(data.sex);
            $("#accountRegion").html(data.accountRegion);
            $("#imgUrl").prop("src", "img/picture/" + data.imgUrl);
        }
    }, "json");
})


$("#save").click(function () {
    let nickName = $("#compileUserName").val();
    let birthday = $("#compileBirthday").val();
    let sex = $("input[name=sex]:checked").val();
    let user = {
        account,
        nickName,
        birthday,
        sex
    }
    $.ajax({
        url: "/householdFurniture/personal/changeUserInfo",
        type: "put",
        data: user,
        dataType: "json",
        async: true,
        success: function (datas) {
            let code = datas.code;
            if (code == 1000) {
                location.href = "http://localhost:8080/mygrxx.html";
            }
        }
    })
})

$("#saveArea").click(function () {
    let country = $("#chooseArea").val();
    if (country == '0') {

    } else {
        $.ajax({
            url: "/householdFurniture/personal/changeUserRegion",
            type: "put",
            data: {country, account},
            dataType: "json",
            async: true,
            success: function (datas) {
                let code = datas.code;
                if (code == 1000) {
                    location.href = "http://localhost:8080/mygrxx.html";
                }
            }
        })
    }
})