package io.pivotal.pal.tracker;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class EnvController {

    private String port;

    private String memoryLimit;
    private String cfInstanceIndex;
    private String cfInstanceaddr;

    public EnvController(@Value("${env.port:NOT SET}") String port,@Value("${memory.limit:NOT SET}") String memoryLimit,
                         @Value("${cf.instance.index:NOT SET}")String cfInstanceIndex,
                         @Value("${cf.instance.index:NOT SET}") String cfInstanceaddr) {
        this.port = port;
        this.memoryLimit = memoryLimit;
        this.cfInstanceaddr = cfInstanceaddr;
        this.cfInstanceIndex = cfInstanceIndex;
    }

    @RequestMapping("/env")
    public Map<String,String> getEnv() {
        Map<String,String> paramaters= new HashMap<>();
        paramaters.put("PORT",port);
        paramaters.put("MEMORY_LIMIT",memoryLimit);
        paramaters.put("CF_INSTANCE_INDEX",cfInstanceIndex);
        paramaters.put("CF_INSTANCE_ADDR",cfInstanceaddr);
        return paramaters;
    }


}
