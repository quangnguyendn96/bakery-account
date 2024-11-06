package com.bakery.service;

import lombok.extern.log4j.Log4j2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;

import java.net.InetAddress;
import java.net.UnknownHostException;

@SpringBootApplication
@Log4j2
public class AccountServiceApplication {

    public static void main(String[] args) throws UnknownHostException {
        Environment env = SpringApplication.run(AccountServiceApplication.class, args).getEnvironment();

        final String application = env.getRequiredProperty("spring.application.name");
        final String port = env.getRequiredProperty("server.port");
        final String portGrpc = env.getRequiredProperty("grpc.server.port");

        log.info("\n\n----------------------------------------------------------\n" +
                        "\tApplication '{}' is running! Access URLs:\n" +
                        "\tLocal address: \t\tlocalhost:{}\n" +
                        "\tExternal address: \t{}:{}\n" +
                        "\tExternal grpc: \t{}\n" +
                        "----------------------------------------------------------\n",
                application, port, InetAddress.getLocalHost().getHostAddress(), port, portGrpc);
    }

}
