package com.dqcer.platform;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * 启动类
 * @Author dongqin
 * @Description
 * @Date 9:50 2019/7/26
 */
@Slf4j
@SpringBootApplication
public class PlatformSystemApplication {

    public static void main(String[] args) throws UnknownHostException {
        ConfigurableApplicationContext applicationContext = SpringApplication.run(PlatformSystemApplication.class, args);
        ConfigurableEnvironment environment = applicationContext.getEnvironment();
        String ip = InetAddress.getLocalHost().getHostAddress();
        String port = environment.getProperty("server.port");
        String path = environment.getProperty("server.servlet.context-path");
        log.info("\n----------------------------------------------------------\n\t" +
                "Application platform system is running! Access URLs:\n\t" +
                "Local: \t\thttp://localhost:" + port + path + "/\n\t" +
                "External: \thttp://" + ip + ":" + port + path + "/\n\t" +
                "swagger-ui: \thttp://" + ip + ":" + port + path + "/swagger-ui.html\n\t" +
                "Doc: \t\thttp://" + ip + ":" + port + path + "/doc.html\n" +
                "----------------------------------------------------------");
    }
}
