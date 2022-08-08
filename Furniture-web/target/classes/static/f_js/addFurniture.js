$("#choose").change(function () {
    if (this.value == "类型") {
        $(".addFurniture").hide();
        $(".addFurnitureType").show();
    } else {
        $(".addFurniture").show();
        $(".addFurnitureType").hide();
        $.get("/householdFurniture/backstage/getAllFurnitureType", function (datas) {
            let data = datas.data;
            let code = datas.code
            if (code == 1000) {
                for (let i = 0; i < data.length; i++) {
                    let type = data[i];
                    let op = `<option value="${type}">${type}</option>`
                    $("#types").append(op);
                }
            }
        }, "json")
    }
})

$("#sub").click(function () {
    $("#uploadFurnitureForm").submit();
})
