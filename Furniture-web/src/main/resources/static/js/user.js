$(function () {

//	订单页面  修改地址
    $(".edit").click(function () {
        $(".mask").show();
        $(".adddz").show();
    });

    $(".bc>input").click(function () {
        if ($(this).val() == "保存") {
            $(".mask").hide();
            $(".adddz").hide();
            $(".bj").hide();
            $(".xg").hide();
            $(".remima").hide();
            $(".pj").hide();
            $(".chak").hide();
        } else {
            $(".mask").hide();
            $(".adddz").hide();
            $(".bj").hide();
            $(".xg").hide();
            $(".remima").hide();
            $(".pj").hide();
            $(".chak").hide();
        }
    });
//	个人信息 编辑
    $("#edit1").click(function () {
        $(".mask").show();
        $(".bj").show();
    });
    $("#edit2").click(function () {
        $(".mask").show();
        $(".xg").show();
    });

//修改头像
    $("#avatar").click(function () {
        $(".mask").show();
        $(".avatar").show();
    });

//	弹框关闭按钮
    $(".gb").click(function () {
        $(".mask").hide();
        $(".bj").hide();
        $(".xg").hide();
        $(".remima").hide();
        $(".avatar").hide();
        $(".pj").hide();
        $(".chak").hide();
    });

//	address
    $("#addxad").click(function () {
        $(".mask").show();
        $(".adddz").show();
    });
    $("#dizhi").hover(function () {
        var txt = "";
        txt = '<p class="addp"><a href="#"  id="readd">修改</a><a href="#" id="deladd">删除</a></p>'
        $(this).append(txt);
        $("#readd").click(function () {
            $(".mask").show();
            $(".readd").show();
        });
        $("#deladd").click(function () {
            $(this).parents("#dizhi").remove();
        });
    }, function () {
        $(".bc>input").click(function () {
            if ($(this).val() == "保存") {
                $(".mask").hide();
                $(".readd").hide();
            } else {
                $(".mask").hide();
                $(".readd").hide();
            }
        });
        $(".addp").remove();
    });

//	查看物流
    $(".vewwl").hover(function () {
        $(this).children(".wuliu").fadeIn(100);
    }, function () {
        $(this).children(".wuliu").fadeOut(100);
    });

})
