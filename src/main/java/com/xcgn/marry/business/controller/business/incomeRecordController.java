package com.xcgn.marry.business.controller.business;

import com.xcgn.marry.business.service.buiness.IncomeRecordService;
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
 * create by ajaxgo on 2019/11/19
 **/
@Api(tags ="收入相关接口")
@RestController
@RequestMapping("app/income")
public class incomeRecordController {

    @Autowired
    private IncomeRecordService incomeRecordService;

    @ApiOperation(value = "兑换现金")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query",example = "-1", name = "userId", value = "userId", required = true, dataType = "Int"),
            @ApiImplicitParam(paramType = "query",example = "-1", name = "cashBean", value = "需要兑换的现金豆数量", required = true, dataType = "Int")})
    @PostMapping("/exchangeCash")
    protected ResponseEntity exchangeCash(@RequestParam Integer userId,@RequestParam Integer cashBean) {
        return incomeRecordService.exchangeCash(userId,cashBean);
    }

    @ApiOperation(value = "兑换明细")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query",example = "-1", name = "userId", value = "userId", required = true, dataType = "Int")})
    @PostMapping("/exchangeDetail")
    protected ResponseEntity exchangeDetail(@RequestParam Integer userId) {
        return incomeRecordService.exchangeDetail(userId);
    }
}
