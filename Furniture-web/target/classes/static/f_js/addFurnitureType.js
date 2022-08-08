$("#addFurnitureSubmit").click(function () {
    let furnitureTypeName = $("#furnitureTypeName").val();
    if (furnitureTypeName != null && furnitureTypeName != "") {
        $.post("/householdFurniture/backstage/addFurnitureType", {furnitureTypeName}, function (datas) {
            let code = datas.code;
            if (code == 1000) {
                location.href = "http://localhost:8080/uploadFurniture.html";
            }
        }, "json");
    } else {
        alert("添加的家具类型不能为空")
    }
})