let code;
let url;
$(function () {
    account = localStorage.getItem("account");
    orderCode = localStorage.getItem("orderCode");
    $.get("/householdFurniture/order/getUserAllAddress/" + account, function (datas) {
        let data = datas.data;
        let code = datas.code
        if (code == 1000) {
            for (let i = 0; i < data.length; i++) {
                let id = data[i].addressId;
                let addressProvince = data[i].addressProvince;
                let addressCity = data[i].addressCity;
                let addressCounty = data[i].addressCounty;
                let addressDetail = data[i].addressDetail;
                let addressName = data[i].addressName;
                let addressPhone = data[i].addressPhone;
                let address = `<div class="chooseAddress" hid="${id}" style="width: 325px;margin: 20px 20px 20px 0;border: 2px solid #dbdbdb;cursor: pointer;float: left" isChoose="false">
                                <div class="tit clearfix">
                                    <p class="fl" style="height: 40px;line-height: 40px;font-size: 20px">${addressName}</p>
                                </div>
                                <div class="addCon">
                                    <p style="background-color: #f5f5f5;height: 50px;line-height: 50px;font-size: 15px">${addressProvince}&nbsp;${addressCity}&nbsp;${addressCounty}&nbsp;${addressDetail}</p>
                                    <p style="background-color: #f5f5f5;height: 30px;line-height: 30px;font-size: 15px">${addressPhone}</p>
                                </div>
                           </div>`;
                $("#userAddressChoose").append(address);
            }
            $(".chooseAddress").click(function () {
                $(this).prop("isChoose", "true");
                $(this).siblings().prop("isChoose", "false");
                $(this).css({
                    borderWidth: 2,
                    borderStyle: "dashed",
                    borderColor: "orange"
                })
                $(this).siblings().css({
                    borderWidth: 2,
                    borderStyle: "solid",
                    borderColor: "#dbdbdb"
                })
            })
        }
    }, "json")
    url = window.location.href;
    if (url.indexOf("?") != -1) {
        let orderNo = url.split("=")[1];
        $.get("/householdFurniture/order/nowPay/" + orderNo, function (datas) {
            let data = datas.data;
            let code = datas.code
            if (code == 1000) {
                orderInfo(data);
            }
        }, "json");
    } else {
        $.get("/householdFurniture/order/getOrderDetail/" + orderCode, function (datas) {
            let data = datas.data;
            let code = datas.code
            if (code == 1000) {
                orderInfo(data);
            }
        }, "json");
    }
})

function orderInfo(data) {
    let furnitureName = data.furnitureName;
    let imgUrl = data.imgUrl;
    let number = data.number;
    let price = data.price;
    let propertyKey = data.propertyKey;
    let propertyValue = data.propertyValue;
    let orderCode = data.orderCode;
    let sumPrice = number * price;
    code = orderCode;
    let order = `<ul class="clearfix" code=${orderCode}>
                        <li class="fl">
                            <img src="img/furniture/${imgUrl}" style="width: 100px;height: 100px">
                        </li>
                        <li class="fl">
                            <p>${furnitureName}</p>
                            <p>${propertyKey} ：${propertyValue}</p>
                            <p>数量 ：${number}</p>
                        </li>
                        <li class="fr">￥ ${price}</li>
                      </ul>`;
    $("#orderInfo").append(order);
    $("#furniturePrice").html(price);
    $("#sumPrice").html(sumPrice)
}

$("#pay").click(function () {
    let addressIndex = 0;
    let addressCount = 0;
    let payIndex = 0;
    let payCount = 0;
    let payType;
    let addressId;
    $(".chooseAddress").each(function () {
        addressIndex++;
        let isTure = $(this).prop("isChoose");
        if (isTure == "true") {
            addressId = this.getAttribute("hid")
            return false;
        } else {
            addressCount++;
            return true;
        }
    })

    $(".payType").each(function () {
        payIndex++;
        let isTure = $(this).prop("is");
        if (isTure == "true") {
            payType = this.getAttribute("pay")
            return false;
        } else {
            payCount++;
            return true;
        }
    })

    if (addressIndex == addressCount) {
        alert("请选择您的收货地址");
    } else {
        if (payIndex == payCount) {
            alert("请选择您的支付方式")
        } else {
            if (url.indexOf("?") != -1) {
                let payInfo = {
                    is: 1,
                    code: code,
                    addressId: addressId,
                    payType: payType,
                    price: $("#sumPrice").html()
                }
                console.log(payInfo)
                $.post("/householdFurniture/order/orderNowPay", payInfo, function (datas) {
                    let data = datas.data;
                    localStorage.setItem("payHtml",data)
                    location.href = "http://localhost:8080/ok.html";
                },"json");
            } else {
                let payInfo = {
                    is: 2,
                    code: code,
                    addressId: addressId,
                    payType: payType,
                    price: $("#sumPrice").html()
                }
                console.log(payInfo)
                $.post("/householdFurniture/order/orderNowPay", payInfo, function (datas) {
                    let data = datas.data;
                    localStorage.setItem("payHtml",data)
                    location.href = "http://localhost:8080/ok.html";
                },"json");
            }
        }
    }

})

$(".payType").click(function () {
    $(this).css({
        borderColor: "red",
        borderStyle: "solid",
        borderWidth: 2
    })
    $(this).siblings().css({
        borderColor: "while",
        borderStyle: "solid",
        borderWidth: 0
    })
    $(this).prop("is", "true");
    $(this).siblings().prop("is", "false");
})