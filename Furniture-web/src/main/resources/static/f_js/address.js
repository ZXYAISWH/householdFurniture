let account;
$(function () {
    account = localStorage.getItem("account");
    $.ajax({
        url: "/householdFurniture/address/getAllUserAddress/" + account,
        async: true,
        type: "get",
        dataType: "json",
        success: function (datas) {
            let data = datas.data;
            let code = datas.code
            if (code == 1000) {
                for (let i = 0; i < data.length; i++) {
                    addressName = data[i].addressName;
                    addressPhone = data[i].addressPhone;
                    addressProvince = data[i].addressProvince;
                    addressCity = data[i].addressCity;
                    addressCounty = data[i].addressCounty;
                    addressDetail = data[i].addressDetail;
                    addressId = data[i].addressId;
                    if (addressCounty == null || addressCounty == "") {
                        addressCounty = "";
                    }
                    let add = `<div style="border: 1px #8c8c8c solid;float: left;width: 268px;height: 178px;margin-right: 10px;margin-top: 15px">
                                <p id="${addressId}" hidden>${addressId}</p>
                                <p style="margin: 10px 15px">${addressName}</p>
                                <p style="margin: 10px 15px">${addressPhone}</p>
                                <p style="margin: 10px 15px">${addressProvince} ${addressCity} ${addressCounty}</p>
                                <p style="margin: 10px 15px">${addressDetail}</p>
                                <p><span style="margin-left: 200px;font-size: 20px;color: black" class="removeAddress" aid=${addressId}>删除</span></p>
                            </div>`;
                    $("#addAddress").append(add);
                }
            }

            $(".removeAddress").click(function () {
                let aid = this.getAttribute("aid");
                console.log(aid)
                $.ajax({
                    url: "/householdFurniture/address/deleteUserAddress/" + aid,
                    async: true,
                    type: "delete",
                    dataType: "json",
                    success: function (datas) {

                    }
                })
                $(this).parent().parent().remove();
            })
        }
    })
})

phoneRex = /^1([38][0-9]|4[579]|5[0-3,5-9]|6[6]|7[0135678]|9[89])\d{8}$/;

$("#savaAddAddressInfo").click(function () {
    let addressName = $("#addressName").val();
    let addressPhone = $("#addressPhone").val();
    let addressProvince = $("#province").val();
    let addressCity = $("#city").val();
    let addressCounty = $("#area").val();
    let addressDetail = $("#addressDetail").val();
    let addressZipCode = $("#zipCode").val();
    let address = {
        account,
        addressName,
        addressPhone,
        addressProvince,
        addressCity,
        addressCounty,
        addressDetail,
        addressZipCode,
    }

    if (phoneRex.test(addressPhone)) {
        $.post("/householdFurniture/address/addAddress", address, function (datas) {
            let code = datas.code
            if (code == 1000) {
                if (addressCounty == null || addressCounty == "") {
                    addressCounty = "";
                }
                let add = `<div style="border: 1px #8c8c8c solid;float: left;width: 268px;height: 178px;margin-right: 10px;margin-top: 15px">
                            <p style="margin: 10px 15px">${addressName}</p>
                            <p style="margin: 10px 15px">${addressPhone}</p>
                            <p style="margin: 10px 15px">${addressProvince} ${addressCity} ${addressCounty}</p>
                            <p style="margin: 10px 15px">${addressDetail}</p>
                            <p><span style="margin-left: 200px;font-size: 20px;color: black" class="removeAddress">删除</span></p>
                            </div>`;
                $("#addAddress").append(add);
                location.href = "http://localhost:8080/address.html";
            }
        }, "json");
    } else {
        alert("请输入正确的手机号码")
    }
})


