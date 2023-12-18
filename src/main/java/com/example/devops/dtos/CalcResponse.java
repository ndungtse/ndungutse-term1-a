package com.example.devops.dtos;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CalcResponse {
    private double calcResponse;
    private String error;

    public CalcResponse(double calcResponse) {
        this.calcResponse = calcResponse;
    }

    public CalcResponse(String error) {
        this.error = error;
    }

    public double getResult() {
        return calcResponse;
    }
}