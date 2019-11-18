package com.xcgn.marry.business.controller.business;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
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

    @ApiOperation(value = "获取刮刮卡列表")
    @PostMapping("/selectCardList")
    protected ResponseEntity selectCardList() {
        return null;
    }

    @ApiOperation(value = "获取刮刮卡中奖信息")
    @PostMapping("/selectInfo")
    protected ResponseEntity selectInfo(@RequestParam Integer userId,@RequestParam Integer cardId) {
        return null;
    }

}
