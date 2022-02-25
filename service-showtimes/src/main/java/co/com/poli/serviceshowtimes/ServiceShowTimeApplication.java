package co.com.poli.serviceshowtimes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableEurekaClient
@SpringBootApplication
@EnableFeignClients
public class ServiceShowTimeApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceShowTimeApplication.class, args);
    }

}
