$(function () {
    $.get("/householdFurniture/show/getAllFurnitureToBzProList", function (datas) {
        let data = datas.data;
        let code = datas.code;
        if (code == 1000) {
            showFurniture(data);
        }
    }, "json");
})


$(".orderBy").click(function () {
    let value = $(this).html();
    $.get("/householdFurniture/show/getAllFurnitureToBzProListOrderBy/" + value, function (datas) {
        let data = datas.data;
        let code = datas.code;
        if (code == 1000) {
            showFurniture(data);
        }
    }, "json");
})

function showFurniture(data) {
    $("#listFurniture").empty();
    for (let i = 0; i < data.length; i++) {
        let id = data[i].id;
        let name = data[i].name;
        let img = data[i].img;
        let price = data[i].price;
        let showFurniture = `<li class="img" hid=${id}>
                                        <dl>
                                            <dt><img src="img/furniture/${img}"></dt>
                                            <dd>${name}</dd>
                                            <dd>￥ ${price}</dd>
                                         </dl>
                                </li>`;
        $("#listFurniture").append(showFurniture)
    }
    $(".img").click(function () {
        let id = this.getAttribute("hid");
        location.href = "http://localhost:8080/proDetail.html?fid=" + id;
    })
}