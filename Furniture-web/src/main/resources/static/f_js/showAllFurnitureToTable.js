$(function () {
    $("#updateFurniture").hide();
    $.get("/householdFurniture/backstage/getAllFurniture", function (datas) {
        let data = datas.data;
        furnitureInfo(data);
    }, "json")
    $.get("/householdFurniture/backstage/getSumFurnitureType",function (datas) {
        let data = datas.data;
        for(let i = 0;i < data.length;i++){
            let type = data[i];
            let option = `<option value=${type}>${type}</option>`
            $("#selectFurnitureType").append(option)
        }
    },"json");
})


$("#sure").click(function () {
    alert("修改家具成功!")
    $("#updateFurniture").hide();
    let furnitureName = $("input[name=furnitureName]").val();
    let furnitureInventory = $("input[name=furnitureInventory]").val();
    let furniturePrice = $("input[name=furniturePrice]").val();
    let description = $("input[name=furnitureDescription]").val();
    let keyWord = $("input[name=furnitureKeyWord]").val();
    let furnitureId = $("input[name=furnitureId]").val();
    let furnitureInfo = {
        furnitureName,
        furnitureInventory,
        furniturePrice,
        description,
        keyWord,
        furnitureId,
    }
    $.ajax({
        url: "/householdFurniture/backstage/updateFurnitureInfo",
        type: "put",
        data: furnitureInfo,
        dataType: "json",
        async: true,
        success: function (datas) {
            location.href = "http://localhost:8080/showAllFurnitureToTable.html";
        }
    })

})

$("#unHide").click(function () {
    alert("取消修改家具!")
    $("#updateFurniture").hide();
})

$("#selectFurnitureType").change(function () {
    let type = this.value;
    $.get("/householdFurniture/backstage/getFurnitureByType/" + type,function (datas) {
        let data = datas.data;
        furnitureInfo(data);
    },"json")
})

function furnitureInfo(data) {
    $("#furnitureData").empty();
    for (let i = 0; i < data.length; i++) {
        let furnitureId = data[i].furnitureId;
        let furnitureName = data[i].furnitureName;
        let addTime = data[i].addTime;
        let clicks = data[i].clicks;
        let status = data[i].status;
        if(clicks == null){
            clicks = 0;
        }
        let furniturePrice = data[i].furniturePrice;
        let inventory = data[i].inventory;
        let times = addTime.split(".")[0];
        let timeOne = times.split("T")[0];
        let timeTwo = times.split("T")[1];
        let inputValue = "";
        let inputName = "";
        let inputClass = "";
        if(status == 0){
            status = "上架中";
            inputValue = "下架";
            inputName = "soldOutFurniture";
            inputClass = "btn-warning";
        }else {
            status = "下架中";
            inputValue = "上架";
            inputName = "soldInFurniture";
            inputClass = "btn-success";
        }
        let t = `<tr>
                          <td>${furnitureId}</td>
                          <td>${furnitureName}</td>
                          <td>${clicks}</td>
                          <td>${inventory}</td>
                          <td>${furniturePrice}</td>
                          <td>${status}</td>
                          <td>${timeOne} ${timeTwo}</td>
                          <td>
                              <input type="button" value="修改" fid=${furnitureId} name="updateFurniture" class="btn btn-info">
                              <input type="button" value=${inputValue} fid=${furnitureId} name=${inputName} class="btn ${inputClass}">
                              <input type="button" value="删除" fid=${furnitureId} name="deleteFurniture" class="btn btn-danger">
                          </td>
                    </tr>`;
        $("#furnitureData").append(t);
    }
    $("input[name=updateFurniture]").click(function () {
        let fid = this.getAttribute("fid");
        $.ajax({
            url: "/householdFurniture/backstage/getFurnitureInfo/" + fid,
            async: true,
            dataType: "json",
            type: "get",
            success: function (datas) {
                $("#updateFurniture").show();
                let data = datas.data;
                let furnitureName = data.furnitureName;
                let furniturePrice = data.furniturePrice;
                let inventory = data.inventory;
                let keyWord = data.keyWord;
                let description = data.description;
                $("input[name=furnitureId]").val(fid);
                $("input[name=furnitureName]").prop("placeholder",furnitureName)
                $("input[name=furnitureInventory]").prop("placeholder",inventory)
                $("input[name=furniturePrice]").prop("placeholder",furniturePrice)
                $("input[name=furnitureDescription]").prop("placeholder",description)
                $("input[name=furnitureKeyWord]").prop("placeholder",keyWord)
            }
        })
    })
    $("input[name=soldOutFurniture]").click(function () {
        let id = this.getAttribute("fid");
        $.ajax({
            url: "/householdFurniture/backstage/soldOutFurniture",
            type: "put",
            dataType: "json",
            data: {id},
            async: true,
            success: function (datas) {
                setTimeout(function () {
                    alert("家具下架成功!")
                },0)
                location.href = "http://localhost:8080/showAllFurnitureToTable.html";
            }
        })
    })
    $("input[name=soldInFurniture]").click(function () {
        let id = this.getAttribute("fid");
        $.ajax({
            url: "/householdFurniture/backstage/soldInFurniture",
            type: "put",
            data: {id},
            dataType: "json",
            async: true,
            success: function (datas) {
                setTimeout(function () {
                    alert("家具上架成功!")
                },0)
                location.href = "http://localhost:8080/showAllFurnitureToTable.html";
            }
        })
    })
    $("input[name=deleteFurniture]").click(function () {
        let fid = this.getAttribute("fid");
        $.ajax({
            url: "/householdFurniture/backstage/deleteFurniture/" + fid,
            type: "delete",
            dataType: "json",
            async: true,
            success: function (datas) {
                setTimeout(function () {
                    alert("家具删除成功!")
                },0)
                location.href = "http://localhost:8080/showAllFurnitureToTable.html";
            }
        })
    })
}

$("#addFurniture").click(function () {
    location.href = "http://localhost:8080/uploadFurniture.html";
})

