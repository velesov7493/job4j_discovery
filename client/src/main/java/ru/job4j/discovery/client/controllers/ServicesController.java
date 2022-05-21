package ru.job4j.discovery.client.controllers;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/services")
public class ServicesController {

    private final DiscoveryClient discoveryClient;

    public ServicesController(DiscoveryClient discoveryClient) {
        this.discoveryClient = discoveryClient;
    }

    @GetMapping
    public List<String> getServices() {
        return discoveryClient.getServices();
    }

    @GetMapping("/{serviceId}")
    public List<ServiceInstance> getInstances(@PathVariable String serviceId) {
        return discoveryClient.getInstances(serviceId);
    }
}
