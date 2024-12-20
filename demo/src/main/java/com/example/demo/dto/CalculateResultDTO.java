package com.example.demo.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class CalculateResultDTO {
    private List<Integer> oddNumbers;
    private List<Integer> evenNumbers;
    private Float oddAverage;
    private Float evenAverage;
    private Float result;


}
