package utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import dto.ConfigDto;
import org.junit.Assert;


import java.io.File;

public class Config {

    private static ObjectMapper mapper = new ObjectMapper();
    private static File configFile;

    public static ConfigDto getConfiguration() {
        ConfigDto config = new ConfigDto();
        try {
            configFile = new File(Config.class
                    .getClassLoader()
                    .getResource("config.json")
                    .getFile());
            config = mapper.readValue(configFile, ConfigDto.class);
        } catch (Exception e) {
            Assert.fail(e.getMessage());
        }
        return config;
    }
}
