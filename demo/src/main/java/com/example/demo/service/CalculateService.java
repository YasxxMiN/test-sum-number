package com.example.demo.service;

import com.example.demo.dto.CalculateResultDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class CalculateService {

    public CalculateResultDTO getCalculateResult(String number) {
        //9;8;7;6;12;14
        String[] numbers = number.split(";");

        List<Integer> oddNumbers = filterNumbers(numbers,true);
        List<Integer> evenNumbers = filterNumbers(numbers,false);
        Float oddAverage = averageNumber(oddNumbers);
        Float evenAverage = averageNumber(evenNumbers);
        Float average = newAverage(oddAverage,evenAverage);


        return new CalculateResultDTO(oddNumbers,evenNumbers, oddAverage,evenAverage,average);
    }

    private List<Integer> filterNumbers(String[] numbersList,boolean isOdd){
        //number[] = Integer.valueOf(numbers)
        List<Integer> myNumOdd = new ArrayList<>();
        List<Integer> myNumEven = new ArrayList<>();
        int indexOdd = 0;
        int indexEven = 0;
        //String myNumber = "9;8;7;6;12;14";
        for (String s : numbersList) {
            int number = Integer.parseInt(s);
            if ((number % 2 != 0)){
                myNumOdd.add(indexOdd, number);
                indexOdd++;
            }else {
                myNumEven.add(indexEven, number);
                indexEven++;
            }

        }

        if (isOdd){
            return myNumOdd;
        }else {
            return myNumEven;
        }
    }

    private Float averageNumber(List<Integer> evenNumbers){
        float sum = 0;
        for (Integer number : evenNumbers){
            sum += number;
        }
        return sum/evenNumbers.size();
    }

    private Float newAverage(Float oddNumber,Float evenNumber){
        Float average;
        average = oddNumber/evenNumber;
        return average;
    }



}
