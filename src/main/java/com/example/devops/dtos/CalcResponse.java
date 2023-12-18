package com.example.devops.dtos;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CalcResponse {
    private double calcResponse;

    public CalcResponse(double calcResponse) {
        this.calcResponse = calcResponse;
    }

    public double getResult() {
        return calcResponse;
    }
}