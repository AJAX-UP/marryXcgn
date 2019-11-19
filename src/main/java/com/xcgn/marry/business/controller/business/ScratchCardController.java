package com.xcgn.marry.business.controller.business;

import com.xcgn.marry.business.service.buiness.ScratchCardService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * create by ajaxgo on 2019/11/18
 **/
@Api(tags ="刮刮卡相关接口")
@RestController
@RequestMapping("app/card")
public class ScratchCardController {

    @Autowired
    private ScratchCardService scratchCardService;

    @ApiOperation(value = "获取刮刮卡列表")
    @PostMapping("/selectCardList")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "userId",example = "-1", value = "用户的Id", required = true, dataType = "Int")
    })
    protected ResponseEntity selectCardList(@RequestParam Integer userId) {
        return scratchCardService.selectCardList(userId);
    }

    @ApiOperation(value = "获取刮刮卡中奖信息")
    @PostMapping("/selectInfo")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "userId",example = "-1", value = "用户的Id", required = true, dataType = "Int"),
            @ApiImplicitParam(paramType = "query", name = "cardId",example = "-1", value = "卡片的Id", required = true, dataType = "Int")
    })
    protected ResponseEntity selectInfo(@RequestParam Integer userId,@RequestParam Integer cardId) {
        return scratchCardService.selectInfo(userId,cardId);
    }

    @ApiOperation(value = "增加中奖现金豆")
    @PostMapping("/addCashBean")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "userId",example = "-1", value = "用户的Id", required = true, dataType = "Int"),
            @ApiImplicitParam(paramType = "query", name = "cardId",example = "-1", value = "卡片的Id", required = true, dataType = "Int"),
            @ApiImplicitParam(paramType = "query", name = "level",example = "-1", value = "中奖等级", required = true, dataType = "Int"),
            @ApiImplicitParam(paramType = "query", name = "isDouble", value = "是否翻倍", required = true, dataType = "boolean"),
            @ApiImplicitParam(paramType = "query", name = "key", value = "验证key", required = true, dataType = "String"),
    })
    protected ResponseEntity addCashBean(@RequestParam Integer userId,@RequestParam Integer cardId
    ,@RequestParam Integer level,@RequestParam boolean isDouble,@RequestParam String key) {
        //return scratchCardService.selectInfo(userId,cardId);
        return scratchCardService.addCashBean(userId,cardId,level,isDouble,key);
    }

}
