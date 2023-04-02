package com.example.companyservice.service.client;

import com.example.companyservice.domain.dto.ApiOutputResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "insee-sirene-api", url = "${spring.feign.client.config.url}")
public interface CompanyFeignClient {

    @RequestMapping(method = RequestMethod.GET, value = "/siret/{siret}", produces = "application/json")
    ApiOutputResult findBySiret(@PathVariable("siret") String siret,
                                                @RequestHeader("Authorization") String authorizationHeader);
}
