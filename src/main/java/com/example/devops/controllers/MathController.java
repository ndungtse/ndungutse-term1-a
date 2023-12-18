package com.example.devops.controllers;

import com.example.devops.dtos.CalcResponse;
import com.example.devops.dtos.DoMathRequest;
import com.example.devops.exceptions.InvalidOperationException;
import com.example.devops.services.MathOperator;
import com.example.devops.services.MathOperatorImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/math")
public class MathController {
    @Autowired
    private MathOperatorImpl mathOperator;

    public MathController(MathOperatorImpl mathOperator) {
        this.mathOperator = mathOperator;
    }

    @PostMapping("/add")
    public ResponseEntity<CalcResponse> add(@RequestBody DoMathRequest request) throws InvalidOperationException {
        double result = mathOperator.doMath(request.getOperand1(), request.getOperand2(), request.getOperation());
        return ResponseEntity.ok(new CalcResponse(result));
    }

    @PostMapping("/subtract")
    public ResponseEntity<CalcResponse> subtract(@RequestBody DoMathRequest request) throws InvalidOperationException {
        double result = mathOperator.doMath(request.getOperand1(), request.getOperand2(), request.getOperation());
        return ResponseEntity.ok(new CalcResponse(result));
    }

    @PostMapping("/multiply")
    public ResponseEntity<CalcResponse> multiply(@RequestBody DoMathRequest request) throws InvalidOperationException {
        double result = mathOperator.doMath(request.getOperand1(), request.getOperand2(), request.getOperation());
        return ResponseEntity.ok(new CalcResponse(result));
    }

    @PostMapping("/divide")
    public ResponseEntity<CalcResponse> divide(@RequestBody DoMathRequest request) throws InvalidOperationException {
        double result = mathOperator.doMath(request.getOperand1(), request.getOperand2(), request.getOperation());
        return ResponseEntity.ok(new CalcResponse(result));
    }
}
