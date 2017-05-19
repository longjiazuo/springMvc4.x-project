package org.light4j.springMvc4.web;

import org.light4j.springMvc4.service.PushService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.async.DeferredResult;

@Controller
public class AysncController {
    @Autowired
    PushService pushService; //①

    @RequestMapping("/defer")
    @ResponseBody
    public DeferredResult<String> deferredCall() { //②
        return pushService.getAsyncUpdate();
    }
}

