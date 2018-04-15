package com.channel.api.handler;

import com.channel.api.constants.Constants;
import com.channel.api.dto.CallBackDto;
import com.channel.api.util.GsonUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 *
 * Created by gq on 2018/4/15.
 */

@Component
public class CallBackHandler {

    private final Logger logger = Logger.getLogger(getClass());

    @Autowired
    private RestTemplate template;

    public String callBack(String url) {
        ResponseEntity<String> result;
        try {
            result=template.getForEntity(url,String.class);
        }catch (Exception e){
            logger.error("回调失败,url:"+url,e);
            return Constants.CALL_BACK_FAIL;
        }

        if(result==null|| !HttpStatus.OK.equals(result.getStatusCode())){
            logger.warn("回调失败,url:"+url);
            return Constants.CALL_BACK_FAIL;
        }

        CallBackDto rsp;
        try {
            rsp= GsonUtils.jsonToPojo(result.getBody(),CallBackDto.class);

        }catch (Exception e){
            logger.warn("json解析失败:"+result.getBody(),e);
            return Constants.CALL_BACK_FAIL;
        }

        return rsp.getStatus()==1?Constants.CALL_BACK_SUC:Constants.CALL_BACK_FAIL;
    }

}
