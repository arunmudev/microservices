package com.service.product.feign;

//import com.service.order.config.LoadBalancerConfig;
///import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import feign.RequestLine;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "productMicroService",url = "http://localhost:8005")
//@LoadBalancerClient(name="productMicroService",configuration = LoadBalancerConfig.class)
public interface OrderClient {


   // @RequestLine("GET")
    @GetMapping("/getData")
    public String getData(@RequestParam("s") String s);
}
