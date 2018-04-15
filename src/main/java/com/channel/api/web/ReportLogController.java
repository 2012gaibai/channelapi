package com.channel.api.web;

import com.channel.api.base.BaseController;
import com.channel.api.constants.ConstantMaps;
import com.channel.api.dto.BaseResult;
import com.channel.api.entity.ReportLog;
import com.channel.api.enums.ErrorCode;
import com.channel.api.exception.ApiException;
import com.channel.api.form.ReportLogForm;
import com.channel.api.service.ReportLogService;
import com.channel.api.util.GsonUtils;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.Date;


/**
 * Created by gq on 2018/4/13.
 *
 */
@Controller
@RequestMapping("/click")
public class ReportLogController extends BaseController{

    @Resource
    private ReportLogService logService;

    @RequestMapping("/idfa")
    @ResponseBody
    public BaseResult upReport(@Valid ReportLogForm form){

        logger.info("req:["+GsonUtils.pojoToJson(form)+"]");

        ReportLog log=new ReportLog();
        log.setIdfa(form.getIdfa());
        String appCode= ConstantMaps.getAppCode(form.getAppid());

        if(StringUtils.isEmpty(appCode)){
            throw new ApiException(ErrorCode.E601.getCode()+"");
        }
        log.setAppCode(appCode);

        if(!ConstantMaps.advertSets.contains(form.getRef())){
            throw new ApiException(ErrorCode.E602.getCode()+"");
        }
        log.setAdverterCode(form.getRef());
        log.setCallback(form.getCallback());
        log.setReportTime(new Date());

        int i=logService.insert(log);

        if(i<1){
            throw new ApiException(ErrorCode.E500.getCode()+"");
        }

        return new BaseResult(ErrorCode.E200);
    }
}
