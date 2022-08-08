$(function () {

    orderId = location.href.split("=")[1];
    $.get("/householdFurniture/order/getOrderDetailByOrderId/" + orderId, function (datas) {
        let data = datas.data;
        let code = datas.code
        let name = data.name;
        let province = data.province;
        let county = data.county;
        let city = data.city;
        let phone = data.phone;
        let detail = data.detail;
        let furnitureName = data.furnitureName;
        let imgUrl = data.imgUrl;
        let orderNo = data.orderNo;
        let payType = data.payType;
        let number = data.number;
        let price = data.price;
        phone = phone + "";
        phone = phone.replace(phone.substring(3, 7), "****");
        let orderDetail = `<div class="my clearfix">
                                <h2>订单详情</h2>
                                <h3>订单号：<span>${orderNo}</span></h3>
                           </div>
                           <div class="orderList">
                                <div class="orderList1">
                                    <h3>已收货</h3>
                                    <div class="clearfix">
                                        <a href="#" class="fl"><img src="img/furniture/${imgUrl}" style="width: 50px"/></a>
                                        <p class="fl"><a href="#">${furnitureName}</a><a href="#">¥ ${price}×${number}</a></p>
                                    </div>
                                </div>
                                <div class="orderList1">
                                    <h3>收货信息</h3>
                                    <p>姓 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;名：<span>${name}</span></p>
                                    <p>联系电话：<span>${phone}</span></p>
                                    <p>收货地址：<span>${province} ${city} ${county} ${detail}</span></p>
                                </div>
                                <div class="orderList1">
                                    <h3>支付方式及送货时间</h3>
                                    <p>支付方式：<span>${payType}</span></p>
                                    <p>送货时间：<span>不限送货时间</span></p>
                                </div>
                                <div class="orderList1 hei">
                                    <h3><strong>商品总价：</strong><span>¥ ${number * price}</span></h3>
                                    <p><strong>运费：</strong><span>¥ 0</span></p>
                                    <p><strong>订单金额：</strong><span>¥ ${number * price}</span></p>
                                    <p><strong>实付金额：</strong><span>¥ ${number * price}</span></p>
                                </div>
                           </div>`;
        $("#orderInfo").append(orderDetail);
    }, "json");
})

