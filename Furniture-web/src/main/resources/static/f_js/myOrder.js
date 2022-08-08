$(function () {
    account = localStorage.getItem("account");
    $.get("/householdFurniture/order/getAllUserOrder/" + account, function (datas) {
        let data = datas.data;
        let code = datas.code
        for (let i = 0; i < data.length; i++) {
            let isComment = data[i].isComment;
            let number = data[i].number;
            let orderNo = data[i].orderNo;
            let orderTime = data[i].orderTime;
            let payType = data[i].payType;
            let price = data[i].price;
            let ship = data[i].ship;
            let imgUrl = data[i].imgUrl;
            let orderId = data[i].orderId;
            let furnitureName = data[i].furnitureName;
            let pay = data[i].pay;
            if (pay == 0) {
                if (ship == 1) {
                    orderTwo(orderTime, orderNo, payType, price, furnitureName, number, imgUrl);
                } else {
                    orderOne(orderTime, orderNo, payType, price, furnitureName, number, imgUrl, orderId, isComment);
                }
            } else if (pay == 1) {
                orderThree(orderTime, orderNo, payType, price, furnitureName, number, imgUrl);
            }
            $(".choose:first").css({
                cursor: "pointer",
                color: "#A10000"
            })
        }
    }, "json");
})


$(".choose").click(function () {
    let choose = $(this).html();
    $(this).css({
        cursor: "pointer",
        color: "#A10000"
    })
    $(this).siblings().css({
        cursor: "pointer",
        color: "black"
    })
    if (choose == "待支付") {
        $.get("/householdFurniture/order/obligation/" + account, function (datas) {
            let data = datas.data;
            $("#order").empty()
            for (let i = 0; i < data.length; i++) {
                let number = data[i].number;
                let orderNo = data[i].orderNo;
                let orderTime = data[i].orderTime;
                let payType = data[i].payType;
                let price = data[i].price;
                let imgUrl = data[i].imgUrl;
                let orderId = data[i].orderId;
                let furnitureName = data[i].furnitureName;
                orderThree(orderTime, orderNo, payType, price, furnitureName, number, imgUrl)
            }
        }, "json")
    } else if (choose == "待收货") {
        $.get("/householdFurniture/order/waitReceive/" + account, function (datas) {
            let data = datas.data;
            $("#order").empty()
            for (let i = 0; i < data.length; i++) {
                let number = data[i].number;
                let orderNo = data[i].orderNo;
                let orderTime = data[i].orderTime;
                let payType = data[i].payType;
                let price = data[i].price;
                let imgUrl = data[i].imgUrl;
                let orderId = data[i].orderId;
                let furnitureName = data[i].furnitureName;
                orderTwo(orderTime, orderNo, payType, price, furnitureName, number, imgUrl)
            }
        }, "json")
    } else {
        $.get("/householdFurniture/order/getAllUserOrder/" + account, function (datas) {
            let data = datas.data;
            $("#order").empty()
            for (let i = 0; i < data.length; i++) {
                let isComment = data[i].isComment;
                let number = data[i].number;
                let orderNo = data[i].orderNo;
                let orderTime = data[i].orderTime;
                let payType = data[i].payType;
                let price = data[i].price;
                let ship = data[i].ship;
                let imgUrl = data[i].imgUrl;
                let orderId = data[i].orderId;
                let furnitureName = data[i].furnitureName;
                let pay = data[i].pay;
                if (pay == 0) {
                    if (ship == 1) {
                        orderTwo(orderTime, orderNo, payType, price, furnitureName, number, imgUrl);
                    } else {
                        orderOne(orderTime, orderNo, payType, price, furnitureName, number, imgUrl, orderId, isComment);
                    }
                } else if (pay == 1) {
                    orderThree(orderTime, orderNo, payType, price, furnitureName, number, imgUrl);
                }
                $(".choose:first").css({
                    cursor: "pointer",
                    color: "#A10000"
                })
            }
        }, "json");
    }
})

function orderOne(orderTime, orderNo, payType, price, furnitureName, number, imgUrl, orderId, isComment) {
    let timer = orderTime + '';
    let time = timer.split("T0")[0];
    if (payType == null) {
        payType = "";
    }
    let content = "待评价";
    if (isComment != null || isComment == 0) {
        content = "已评价";
    }
    let sumPrices = parseInt(price * number);
    let orderOne = `<div style="border: 2px solid #8c8c8c;margin-top: 20px">
                        <p style="height: 40px;line-height: 40px;margin-left: 20px;font-size: 20px;color: #A10000">已收货</p>
                        <div style="height: 50px;line-height: 50px;;border-bottom: 2px solid #8c8c8c">
                             <ul style="height: 30px;float: left;width: 710px">
                                 <li style="float: left;margin-left: 20px">${time}</li>
                                 <li style="float: left;margin-left: 20px">订单号:${orderNo}</li>
                                 <li style="float: left;margin-left: 20px">${payType}</li>
                             </ul>
                             <p>订单金额：<span style="color: #A10000;font-size: 20px;font-weight: 700">${sumPrices}</span>元</p>
                        </div>
                        <div style="height: 130px"> 
                            <p style="float: left;width: 150px"><img src="img/furniture/${imgUrl}" style="height: 50px;margin-left: 20px;margin-top: 20px;border: #8e8e8e 1px solid"></p>
                            <p style="height: 30px;width: 367px;padding-top: 20px"><a href="#">${furnitureName}</a><a href="#">¥ ${sumPrices}</a></p>
                            <p style="margin-left: 715px">
                                <button style="width: 100px;height: 35px;background-color: antiquewhite" class="waitComment" orderId=${orderNo}>${content}</button><br />
                                <p class="orderDetail" orderId=${orderId} style="margin-top: 5px;height: 33px;text-align:center;width:100px;margin-left: 715px;border: #90D7EC 1px solid;line-height: 33px">订单详情</p>
                            </p>
                        </div>
                     </div>`;
    $("#order").append(orderOne);
    $(".orderDetail").click(function () {
        let orderId = this.getAttribute("orderId");
        location.href = "http://localhost:8080/orderxq.html?orderId=" + orderId;
    })
    $(".waitComment").click(function () {
        let orderNo = this.getAttribute("orderId");
        location.href = "http://localhost:8080/myprod.html?orderId=" + orderNo;
    })
}


function orderTwo(orderTime, orderNo, payType, price, furnitureName, number, imgUrl) {
    let timer = orderTime + '';
    let time = timer.split("T0")[0];
    if (payType == null) {
        payType = "";
    }
    let sumPrices = parseInt(price * number);
    let orderOne = `<div style="border: 2px solid #8c8c8c;margin-top: 20px">
                        <p style="height: 40px;line-height: 40px;margin-left: 20px;font-size: 20px;color: #A10000">待收货</p>
                        <div style="height: 50px;line-height: 50px;;border-bottom: 2px solid #8c8c8c">
                             <ul style="height: 30px;float: left;width: 710px">
                                 <li style="float: left;margin-left: 20px">${time}</li>
                                 <li style="float: left;margin-left: 20px">订单号:${orderNo}</li>
                                 <li style="float: left;margin-left: 20px">${payType}</li>
                             </ul>
                             <p>订单金额：<span style="color: #A10000;font-size: 20px;font-weight: 700">${sumPrices}</span>元</p>
                        </div>
                        <div style="height: 120px">
                            <p style="float: left;width: 150px"><img src="img/furniture/${imgUrl}" style="height: 50px;margin-left: 20px;margin-top: 20px;border: #8e8e8e 1px solid"></p>
                            <p style="height: 30px;width: 367px;padding-top: 20px"><a href="#">${furnitureName}</a><a href="#">¥${sumPrices}</a></p>
                            <p style="margin-left: 715px">
                                <button style="width: 100px;height: 35px;background-color: antiquewhite" class="confirmReceipt" orderNo=${orderNo}>确认收货</button>
                            </p>
                        </div>
                    </div>`;
    $("#order").append(orderOne);
    $(".confirmReceipt").click(function () {
        let orderNo = this.getAttribute("orderNo");
        $.post("/householdFurniture/order/confirmReceipt", {orderNo}, function () {
            location.href = "http://localhost:8080/myorderq.html";
        }, "json");
    })
}


function orderThree(orderTime, orderNo, payType, price, furnitureName, number, imgUrl) {
    let timer = orderTime + '';
    let time = timer.split("T0")[0];
    if (payType == null) {
        payType = "";
    }
    let sumPrices = parseInt(price * number);
    let orderOne = `<div style="border: 2px solid #8c8c8c;margin-top: 20px">
						<p style="height: 40px;line-height: 40px;margin-left: 20px;font-size: 20px;color: #A10000">待支付</p>
                        <div style="height: 50px;line-height: 50px;;border-bottom: 2px solid #8c8c8c">
                             <ul style="height: 30px;float: left;width: 710px">
                                 <li style="float: left;margin-left: 20px">${time}</li>
                                 <li style="float: left;margin-left: 20px">订单号:${orderNo}</li>
                                 <li style="float: left;margin-left: 20px">${payType}</li>
                             </ul>
                             <p>订单金额：<span style="color: #A10000;font-size: 20px;font-weight: 700">${sumPrices}</span>元</p>
                        </div>
						<div style="height: 120px">
						    <p style="float: left;width: 150px"><img src="img/furniture/${imgUrl}" style="height: 50px;margin-left: 20px;margin-top: 20px;border: #8e8e8e 1px solid"></p>
                            <p style="height: 30px;width: 367px;padding-top: 20px"><a href="#">${furnitureName}</a><a href="#">¥${sumPrices}</a></p>
							<p style="margin-left: 715px">
								<button style="width: 100px;height: 35px;background-color: antiquewhite" class="nowPay" orderNo=${orderNo}>立即支付</button>
							</p>
						</div>
					</div>`;
    $("#order").append(orderOne);
    $(".nowPay").click(function () {
        let orderNo = this.getAttribute("orderNo");
        window.location.href = "http://localhost:8080/order.html?orderNo=" + orderNo;
    })
}