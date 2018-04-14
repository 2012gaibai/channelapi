package com.channel.api.web;

import com.channel.api.dto.BaseResult;
import com.channel.api.entity.ReportLog;
import com.channel.api.enums.ErrorCode;
import com.channel.api.form.ReportLogForm;
import com.channel.api.service.ReportLogService;
import org.springframework.stereotype.Controller;
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
public class ReportLogController {

    @Resource
    private ReportLogService logService;

    @RequestMapping("/idfa")
    @ResponseBody
    public BaseResult upReport(@Valid ReportLogForm form){
        ReportLog log=new ReportLog();
        log.setIdfa(form.getIdfa());
        log.setAppCode(form.getAppid());
        log.setAdverterCode(form.getRef());
        log.setReportTime(new Date());
        int i=logService.insert(log);

        BaseResult result=new BaseResult();
        if(i>0){
            result.setCode(ErrorCode.E200.getCode());
            result.setMsg(ErrorCode.E200.getMsg());
        }else {
            result.setCode(ErrorCode.E500.getCode());
            result.setMsg(ErrorCode.E500.getMsg());
        }
        return result;
    }
}
