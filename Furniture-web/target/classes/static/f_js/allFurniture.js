$(function () {
    $.get("/householdFurniture/show/getAllFurniture", function (data) {
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
    }, "json");
})


$(".orderBy").click(function () {
    let value = $(this).html();
    $.get("/householdFurniture/show/getAllFurnitureOrderBy/" + value, function (data) {
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
            $(".img").click(function () {
                let id = this.getAttribute("hid");
                location.href = "http://localhost:8080/proDetail.html?fid=" + id;
            })
        })
    }, "json");
})