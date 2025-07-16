package com.vedant.feedback_service.feign;

import com.vedant.feedback_service.dto.UserDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "user-service")
public interface UserClient {


    @GetMapping("/api/users/get/{id}")
    UserDto getUserById(@PathVariable("id") Long id);

}
