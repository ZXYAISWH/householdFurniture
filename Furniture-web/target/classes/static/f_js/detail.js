let url;
$(function () {
    $("#promptInfo").hide()
    account = localStorage.getItem("account")
    url = location.href;
    let furnitureId = url.split("=")[1];
    $.get("/householdFurniture/show/getFurnitureDetail/" + furnitureId, function (datas) {
        let data = datas.data;
        let code = datas.code;
        if (code == 1000) {
            showFurniture(data);
        }
    }, "json")

    $.get("/householdFurniture/show/getFurnitureComment/" + furnitureId,function (datas) {
        let data = datas.data;
        let code = datas.code;
        for(let i = 0;i < data.length;i++){
            let commentContent = data[i].commentContent;
            let commentScore = data[i].commentScore;
            let commentTime = data[i].commentTime;
            let imgUrl = data[i].imgUrl;
            let nickName = data[i].nickName;
            let times = commentTime.split(".")[0];
            let timeOne = times.split("T")[0];
            let timeTwo = times.split("T")[1];
            nickName = nickName.replace(nickName.substring(1,nickName.length - 1),"**");
            let comment = `<div className="per clearfix">
                                    <div style="margin-bottom: 20px">
                                        <img src="img/picture/${imgUrl}" style="width: 50px;height: 50px;border-radius: 50%"> 
                                        <span style="font-size: 20px">${nickName}</span>
                                    </div>
                                    <div className="perR fl">
                                        <p style="height: 40px"><span>评论内容:</span>${commentContent} <span style="color:#90D7EC;font-size: 20px">${commentScore}</span>分</p>
                                        <p style="height: 40px"><span>评论时间:</span><span>${timeOne} ${timeTwo}</span></p>
                                    </div>
                             </div>`
            $("#eva").append(comment);
        }
    },"json")
})


function showFurniture(data) {
    let id = data.id;
    let name = data.name;
    let inventory = data.inventory;
    let mainImgUrl = data.mainImgUrl;
    let price = data.price;
    let viceImgUrl = data.viceImgUrl;
    $("#productName").html(name)
    $("#mainImg").prop("src", "img/furniture/" + mainImgUrl)
    $("#name").html(name)
    $("#price").html(price)
    $("#inventory").html(inventory)
    $("#viewImg").prop("src", "img/furniture/" + mainImgUrl)
    for (let i = 0; i < viceImgUrl.length; i++) {
        let smallImgUrl = viceImgUrl[i];
        let img = `<p id=${id} style="float: left" is="false" class="smallP" src="img/furniture/${smallImgUrl}"><img style="width: 45px;height: 45px" class="smallImgUrl" src="img/furniture/${smallImgUrl}"></p>`;
        $("#smallImg").append(img)
    }
    $("#viewImg").click(function () {
        $("#mainImg").prop("src", this.getAttribute("src"))
    })
    $(".smallP").click(function () {
        $(this).siblings().prop("is", "false")
        $(this).siblings().css({
            borderWidth: 0
        })
        $(this).prop("is", "true")
        $(this).css({
            borderStyle: "dashed",
            borderWidth: 3,
            borderColor: "#5bc0de"
        })
        let imgUrlName = this.getAttribute("src");
        $("#mainImg").prop("src", imgUrlName)
    })
}


$("#buyNow").click(function () {
    let count = 0;
    let p = 0;
    let id;
    let price;
    let number;
    $(".smallP").each(function () {
        p++;
        let is = $(this).prop("is");
        if (is == "true") {
            id = $(this).prop("id");
            price = $("#price").html();
            number = $("#number").text();
            return false;
        } else {
            count++;
            return true;
        }
    })
    if (count == p) {
        let timer = setTimeout(function () {
            $("#prompt").css({
                borderColor: "red",
                borderWidth: 3,
                borderStyle: "solid"
            })
            $("#promptInfo").show()
            let ms = 0;
            let timers = setInterval(function () {
                ms++;
                if (ms == 2) {
                    $("#prompt").css({
                        borderColor: "red",
                        borderWidth: 0,
                        borderStyle: "solid"
                    })
                    $("#promptInfo").hide()
                    clearTimeout(timer)
                    clearInterval(timers)
                }
            }, 1000)
        }, 0)
    } else {
        var orderProperty = {
            account,
            id: id,
            price: price,
            number: number,
        }
        $.post("/householdFurniture/order/orderFurnitureDetailInfo", orderProperty, function (datas) {
            let data = datas.data;
            let code = datas.code;
            if (code == 1000) {
                localStorage.setItem("orderCode", data);
                location.href = "order.html";
            }
        }, "json");
    }
})


$("#addCart").click(function () {
    let count = 0;
    let p = 0;
    let id;
    let price;
    let number;
    $(".smallP").each(function () {
        p++;
        let is = $(this).prop("is");
        if (is == "true") {
            id = $(this).prop("id");
            price = $("#price").html();
            number = $("#number").text();
            return false;
        } else {
            count++;
            return true;
        }
    })
    if (count == p) {
        let timer = setTimeout(function () {
            $("#prompt").css({
                borderColor: "red",
                borderWidth: 3,
                borderStyle: "solid"
            })
            $("#promptInfo").show()
            let ms = 0;
            let timers = setInterval(function () {
                ms++;
                if (ms == 2) {
                    $("#prompt").css({
                        borderColor: "red",
                        borderWidth: 0,
                        borderStyle: "solid"
                    })
                    $("#promptInfo").hide()
                    clearTimeout(timer)
                    clearInterval(timers)
                }
            }, 1000)
        }, 0)
    } else {
        var orderProperty = {
            account,
            id: id,
            number: number
        }
        $.post("/householdFurniture/cart/addCart", orderProperty, function () {
            location.href = "http://localhost:8080/cart.html";
        }, "json");
    }
})