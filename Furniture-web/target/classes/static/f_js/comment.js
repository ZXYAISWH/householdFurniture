let url;
let orderCode;
$(function () {
    account = localStorage.getItem("account");
    url = location.href;
    $(".choose:first").css({
        cursor: "pointer",
        color: "#A10000"
    })
    if (url.indexOf("?") != -1) {
        orderCode = url.split("=")[1];
        $(".pj").show();
    } else {
        $.get("/householdFurniture/comment/getUserAllWaitFurniture/" + account, function (datas) {
            let data = datas.data;
            let code = datas.code
            $("#commentContext").empty()
            for (let i = 0; i < data.length; i++) {
                let price = data[i].price;
                let imgUrl = data[i].imgUrl;
                let name = data[i].name;
                let orderNo = data[i].orderNo;
                commentContent(price, imgUrl, name, orderNo);
            }
        }, "json");
    }
})

$(".choose").click(function () {
        let choose = $(this).html();
        $(this).css({
            cursor: "pointer",
            color: "#A10000"
        });
        $(this).siblings().css({
            cursor: "pointer",
            color: "black"
        })
        let chooseName = $(this).html();
        console.log(chooseName)
        if (chooseName == "待评价商品") {
            $.get("/householdFurniture/comment/getUserAllWaitFurniture/" + account, function (datas) {
                let data = datas.data;
                let code = datas.code
                $("#commentContext").empty()
                for (let i = 0; i < data.length; i++) {
                    let price = data[i].price;
                    let imgUrl = data[i].imgUrl;
                    let name = data[i].name;
                    let orderNo = data[i].orderNo;
                    commentContent(price, imgUrl, name, orderNo);
                }
            }, "json");
        } else {
            $.get("/householdFurniture/comment/getUserAllYetFurniture/" + account, function (datas) {
                let data = datas.data;
                let code = datas.code
                $("#commentContext").empty()
                for (let i = 0; i < data.length; i++) {
                    let price = data[i].price;
                    let imgUrl = data[i].imgUrl;
                    let name = data[i].name;
                    let orderNo = data[i].orderNo;
                    commentYetContent(price, imgUrl, name, orderNo);
                }
            }, "json");
        }
    }
)


function commentContent(price, imgUrl, name, orderNo) {
    let comment = `<div style="float: left;margin-left: 20px;margin-top: 20px;width: 220px">
                        <dl style="width: 220px">
                            <dt><a href="#"><img src="img/furniture/${imgUrl}" style="width: 220px"/></a></dt>
                            <dd><a href="#">${name}</a></dd>
                            <dd>¥ ${price}</dd>
                            <dd or=${orderNo} class="comment" style="background-color: #90D7EC;width: 100px;height: 30px;line-height: 30px;margin: auto">评价</dd>
                        </dl>
                   </div>`;
    $("#commentContext").append(comment)
    $(".comment").click(function () {
        orderCode = this.getAttribute("or");
        $(".pj").show();
    })
}

function commentYetContent(price, imgUrl, name, orderNo) {
    let comment = `<div style="float: left;margin-left: 20px;margin-top: 20px;width: 220px">
                        <dl style="width: 220px">
                            <dt><a href="#"><img src="img/furniture/${imgUrl}" style="width: 220px"/></a></dt>
                            <dd><a href="#">${name}</a></dd>
                            <dd>¥ ${price}</dd>
                            <dd  or=${orderNo} class="comment" style="background-color: #90D7EC;width: 100px;height: 30px;line-height: 30px;margin: auto">已评价</dd>
                        </dl>
                   </div>`;
    $("#commentContext").append(comment)
}

$("#save").click(function () {
    let score = $("#score").html();
    let commentContent = $("#commentContent").val();
    let comment = {
        account,
        score,
        commentContent,
        orderCode
    }
    $.post("/householdFurniture/comment/furnitureComment", comment, function () {
        location.href = "http://localhost:8080/myprod.html";
    })
})

$("#range").change(function () {
    $("#score").html(this.value)
})

