$(function () {
    account = localStorage.getItem("account");
    $.get("/householdFurniture/cart/getAllCarFurniture/" + account, function (datas) {
        let data = datas.data;
        for (let i = 0; i < data.length; i++) {
            let imgUrl = data[i].imgUrl;
            let name = data[i].name;
            let number = data[i].number;
            let propertyKey = data[i].propertyKey;
            let propertyValue = data[i].propertyValue;
            let price = data[i].price;
            let carId = data[i].carId;
            let furnitureId = data[i].furnitureId;
            cart(imgUrl, name, number, propertyKey, propertyValue, price, carId, furnitureId)
        }
        $(".deleteFurniture").click(function () {
            $(this).parent().remove();
            let cardId = this.getAttribute("cardId")
            $.ajax({
                url: "/householdFurniture/cart/deleteCartFurniture/" + cardId,
                type: "delete",
                async: true,
                dataType: "text",
                success: function () {
                    location.href = "http://localhost:8080/cart.html"
                }
            })
        })
        $(".toFurniture").click(function () {
            let fid = this.getAttribute("fid");
            location.href = "http://localhost:8080/proDetail.html?fid=" + fid;
        })
    }, "json")
})


function cart(imgUrl, name, number, propertyKey, propertyValue, price, carId, furnitureId) {
    let th = `<div style="height: 200px;position: relative">
                    <div style="float: left">
                        <a style="float: left">
                            <dl>
                                <dt><img src="img/furniture/${imgUrl}" class="toFurniture" fid=${furnitureId} style="width: 120px;margin-top: 20px"></dt>
                                <dd style="position:absolute;left: 205px;top: 25px">
                                    <p>${name}</p>
                                    <p style="margin-top: 20px">${propertyKey}:${propertyValue}</p>
                                </dd>
                            </dl>
                        </a>
                    </div>
                    <div style="position:absolute;left: 490px;top: 25px">￥ ${price}</div>
                    <div style="position:absolute;left: 720px;top: 25px">
                        <p class="num clearfix">
                            <span>${number}</span>
                        </p>
                    </div>
                    <div style="position:absolute;left: 925px;top: 25px">￥ ${price * number}</div>
                    <div style="position:absolute;left: 1075px;top: 25px" cardId=${carId} class="deleteFurniture">删除<div>
                </div>`;
    $("#furnitureCar").append(th);

}





