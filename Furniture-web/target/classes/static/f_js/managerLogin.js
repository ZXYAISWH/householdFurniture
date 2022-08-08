$("#subLogin").click(function () {
    let account = $("#account").val();
    let password = $("#password").val();
    if("zhangsan" == account && "333" == password){
        location.href = "http://localhost:8080/showAllFurnitureToTable.html";
    }
})

$(function () {
    let language = $("#choose").val();
    $.get("/householdFurniture/backstageI18n/i18n/" + language,function (datas) {
        let data = datas.data;
        let account = data.account;
        let password = data.password;
        let submit = data.submit;
        let reset = data.reset;
        let info = data.info;
        $("#info").html(info);
        $("#accountInfo").html(account)
        $("#passwordInfo").html(password)
        $("#subLogin").val(submit)
        $("#reset").val(reset)
    },"json")
})

$("#choose").change(function () {
    $.get("/householdFurniture/backstageI18n/i18n/" + this.value,function (datas) {
        let data = datas.data;
        let account = data.account;
        let password = data.password;
        let submit = data.submit;
        let reset = data.reset;
        let info = data.info;
        $("#info").html(info);
        $("#accountInfo").html(account)
        $("#passwordInfo").html(password)
        $("#subLogin").val(submit)
        $("#reset").val(reset)
    },"json")
})
