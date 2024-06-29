package ynu.edu.controller;

import io.github.resilience4j.bulkhead.annotation.Bulkhead;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import jakarta.annotation.Resource;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import ynu.edu.entity.CommonResult;
import ynu.edu.entity.User;
import ynu.edu.feign.ServiceProviderService;

import java.sql.SQLDataException;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/cart")
public class CartController {
    @Resource
    private  ServiceProviderService  serviceProviderService;

    @GetMapping("/getCartById/{userId}")
    @LoadBalanced
    public CommonResult<User> getCartById(@PathVariable("userId") Integer userId){
        String message="进入方法";
        System.out.println(message);
        return  serviceProviderService.getUserById(userId);
    }




}
