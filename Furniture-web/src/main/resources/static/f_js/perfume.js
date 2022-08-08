$(function () {
    $.get("/householdFurniture/show/getAllFurnitureToPerFume", function (datas) {
        let data = datas.data;
        let code = datas.code;
        if (code == 1000) {
            showFurniture(data);
        }
    }, "json");
})

function showFurniture(data) {
    for (let i = 0; i < data.length; i++) {
        let id = data[i].id;
        let name = data[i].name;
        let img = data[i].img;
        let price = data[i].price;
        let showFurniture = `<div class="img" hid=${id} style="float: left;margin-left: 20px;width: 350px;height: 400px;margin-top: 20px">
                                     <dl>
                                         <dt><img src="img/furniture/${img}" style="width: 350px;height: 350px"></dt>
                                         <dd style="text-align: center">${name}</dd>
                                         <dd style="font-size: 20px;color: #8c8c8c;text-align: center">￥ ${price}</dd>
                                     </dl>
                                 </div>`;
        $("#listFurniture").append(showFurniture)
    }
    $(".img").click(function () {
        let id = this.getAttribute("hid");
        location.href = "http://localhost:8080/proDetail.html?fid=" + id;
    })
}