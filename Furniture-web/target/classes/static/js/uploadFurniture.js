$(function () {
    $(".addFurniture").hide();
})

$("#choose").change(function () {
    if (this.value == "类型") {
        $(".addFurniture").hide();
        $(".addFurnitureType").show();
    } else if(this.value == "家具"){
        $(".addFurniture").show();
        $(".addFurnitureType").hide();
    }else {
        location.href = "http://localhost:8080/showAllFurnitureToTable.html";
    }
})