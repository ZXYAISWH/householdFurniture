package com.duing.login.controller;

import com.duing.annotation.SysLog;
import com.duing.login.service.CommentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

/**
 * 做家具评论模块的控制层
 *
 * @RestController 说明这是一个控制层对象, 并且方法返回json对象, 将这个控制层交给spring来管理, 底层实际用的是@Controller注解
 * @RequestMapping 处理请求地址映射的注解
 * @Api 表示标识这个类是swagger的资源, 并且说明接口的模块
 * @SuppressWarnings 不扫描本类规范
 */
@RestController
@RequestMapping("/householdFurniture/comment")
@Api(tags = "家具评论模块的接口")
@SuppressWarnings("all")
public class FurnitureCommentController {

    /**
     * 获取评论的业务层对象
     *
     * @Autowired自动注入对象
     */
    @Autowired
    private CommentService commentService;

    /**
     * 获取所有未评论的家具
     *
     * @param account 用户的账号
     * @return 家具的信息
     * @GetMapping 获取get请求的地址映射的注解
     * @ApiOperation 对某个方法/接口进行描述
     * @ApiImplicitParam 对接口的参数的描述
     * @SysLog 通过切面的方式打印日志信息
     */
    @GetMapping("/getUserAllWaitFurniture/{account}")
    @ApiOperation("用户家具未评论的接口")
    @ApiImplicitParam(name = "account", value = "用户的账号")
    @SysLog(BusinessName = "用户家具未评论的接口")
    public List<HashMap<String, Object>> getUserAllWaitFurniture(@PathVariable("account") String account) {
        //调用业务层未评论方法
        return commentService.getUserAllWaitFurniture(account);
    }

    /**
     * 家具评论
     *
     * @param score          评论的分数
     * @param commentContent 评论的内容
     * @param orderCode      家具的编号
     * @param account        用户的账号
     */
    @PostMapping("/furnitureComment")
    @ApiOperation("家具评论的接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "score", value = "评论的分数"),
            @ApiImplicitParam(name = "commentContent", value = "评论的内容"),
            @ApiImplicitParam(name = "orderCode", value = "家具的编号"),
            @ApiImplicitParam(name = "account", value = "用户的账号")
    })
    @SysLog(BusinessName = "家具评论的接口")
    public void furnitureComment(Integer score, String commentContent, String orderCode, String account) {
        //调用业务层家具评论的方法
        commentService.furnitureComment(score, commentContent, orderCode, account);
    }

    /**
     * 获取所有已评论的家具
     *
     * @param account 用户的账号
     * @return 家具的信息
     * @GetMapping 获取get请求的地址映射的注解
     * @ApiOperation 对某个方法/接口进行描述
     * @ApiImplicitParam 对接口的参数的描述
     * @SysLog 通过切面的方式打印日志信息
     */
    @GetMapping("/getUserAllYetFurniture/{account}")
    @ApiOperation("用户家具已评论的接口")
    @ApiImplicitParam(name = "account", value = "用户的账号")
    @SysLog(BusinessName = "用户家具已评论的接口")
    public List<HashMap<String, Object>> getUserAllYetFurniture(@PathVariable("account") String account) {
        //调用业务层已评论的方法
        return commentService.getUserAllYetFurniture(account);
    }

}
