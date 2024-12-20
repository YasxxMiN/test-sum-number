package com.example.demo.controller;


import com.example.demo.dto.CalculateResultDTO;
import com.example.demo.dto.RestJsonData;
import com.example.demo.service.CalculateService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/customer-info")
@RequiredArgsConstructor

@Slf4j
public class CalculateController {
    private final CalculateService calculateService;
    @CrossOrigin(origins = "*")
    @PostMapping(value = "/calculate", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public RestJsonData<CalculateResultDTO>  getAllCustomerInfo(@RequestBody String myNumber) {

        return new RestJsonData<>(null,null,calculateService.getCalculateResult(myNumber.replace("\"", ""))) ;
    }
}
