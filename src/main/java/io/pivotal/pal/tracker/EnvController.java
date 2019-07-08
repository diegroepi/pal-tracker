package io.pivotal.pal.tracker;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class EnvController {

    private Map<String, String> cfEnvVariables;


    public EnvController(@Value("${PORT:NOT SET}") String port,
                         @Value("${MEMORY.LIMIT:NOT SET}") String memoryLimit,
                         @Value("${CF.INSTANCE.INDEX:NOT SET}") String cfInstanceIndex,
                         @Value("${CF.INSTANCE.ADDR:NOT SET}") String cfInstanceAddr) {

        cfEnvVariables = new HashMap<>();
        cfEnvVariables.put("PORT", port);
        cfEnvVariables.put("MEMORY_LIMIT", memoryLimit);
        cfEnvVariables.put("CF_INSTANCE_INDEX", cfInstanceIndex);
        cfEnvVariables.put("CF_INSTANCE_ADDR", cfInstanceAddr);

    }

    @GetMapping("/env")
    public Map<String, String> getEnv() {
        return cfEnvVariables;
    }
}
