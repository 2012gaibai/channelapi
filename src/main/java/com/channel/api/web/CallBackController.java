package com.channel.api.web;

import com.channel.api.dto.BaseResult;
import com.channel.api.form.EleBackForm;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;

/**
 * Created by gq on 2018/4/11.
 */
@Controller
@RequestMapping("/callback")
public class CallBackController {

    @RequestMapping(value = "/{app}", produces = { "application/json;charset=UTF-8" })
    @ResponseBody
    public BaseResult callBackEle(@PathVariable String app, @Valid EleBackForm form){


        BaseResult result=new BaseResult();
        return result;
    }

}
