package org.light4j.springMvc4.web;

import org.light4j.springMvc4.domain.DemoObj;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // ①
@RequestMapping("/rest")
public class DemoRestController {

    @RequestMapping(value = "/getjson",produces={"application/json;charset=UTF-8"}) // ②
    public DemoObj getjson (DemoObj obj){
        return new DemoObj(obj.getId()+1, obj.getName()+"yy");//③
    }
    @RequestMapping(value = "/getxml", produces={"application/xml;charset=UTF-8"})//④
    public DemoObj getxml(DemoObj obj){
        return new DemoObj(obj.getId()+1, obj.getName()+"yy");
    }
}
