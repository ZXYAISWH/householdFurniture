let account;
$(function () {
    account = localStorage.getItem("account");
    let value = sessionStorage.getItem("isLogin");
    if(value == null){
        localStorage.clear();
    }else {
        $("#loginAndRegister").hide();
    }
    $.get("/householdFurniture/show/getSomeFurnitureToIndex", function (datas) {
        let data = datas.data;
        let code = datas.code;
        if (code == 1000) {
            dataFurniture(data);
        }
    }, "json");
    $.get("/householdFurniture/show/getSomeFurnitureToIndex", function (datas) {
        let data = datas.data;
        let code = datas.code;
        if (code == 1000) {
            dataFurniture(data);
        }
    }, "json");
})
function dataFurniture(data) {
    for (let i = 0; i < data.length; i++) {
        let id = data[i].id;
        let name = data[i].name;
        let img = data[i].img;
        let price = data[i].price;
        let showFurniture = `<div style="float: left;margin: 20px 20px 20px 0px">
                                   <dl>
                                         <dt>
                                             <img class="img" src="img/furniture/${img}" hid=${id} style="height: 360px;width: 360px"/>
                                         </dt>
                                         <dd>${name}</dd>
                                         <dd><span>¥ ${price}</span></dd>
                                   </dl>
                             </div>`;
        $("#showTwo").append(showFurniture)
    }
    $(".img").click(function () {
        let id = this.getAttribute("hid");
        location.href = "http://localhost:8080/proDetail.html?fid=" + id;
    })
}

$("#searchFurniture").click(function () {
    let value = $("#searchText").val();
    $.get("/householdFurniture/show/getFurnitureByKeyWord/" + value,function (datas) {
        $("#showTwo").empty();
        let data = datas.data;
        dataFurniture(data)
    },"json")
})
