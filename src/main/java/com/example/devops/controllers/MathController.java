package com.example.devops.controllers;

import com.example.devops.dtos.CalcResponse;
import com.example.devops.dtos.DoMathRequest;
import com.example.devops.exceptions.DivisionByZeroException;
import com.example.devops.exceptions.InvalidOperationException;
import com.example.devops.services.MathOperator;
import com.example.devops.services.MathOperatorImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/math")
public class MathController {
    @Autowired
    private MathOperatorImpl mathOperator;

    public MathController(MathOperatorImpl mathOperator) {
        this.mathOperator = mathOperator;
    }

    @PostMapping("/doMath")
    public ResponseEntity<CalcResponse> doMath(@RequestBody DoMathRequest request) throws InvalidOperationException, DivisionByZeroException {
        try {
            if (request.getOperand2() == 0 && request.getOperation().equals("/")) {
                throw new DivisionByZeroException("Cannot divide by zero");
            }
            double result = mathOperator.doMath(request.getOperand1(), request.getOperand2(), request.getOperation());
            return ResponseEntity.ok(new CalcResponse(result));
        } catch (InvalidOperationException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new CalcResponse("Invalid operation"));
        } catch (DivisionByZeroException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new CalcResponse("Division by zero"));
        }
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
    public ResponseEntity<CalcResponse> divide(@RequestBody DoMathRequest request) throws InvalidOperationException, DivisionByZeroException {
        try {
            if (request.getOperand2() == 0) {
                throw new DivisionByZeroException("Cannot divide by zero");
            }
            double result = mathOperator.doMath(request.getOperand1(), request.getOperand2(), request.getOperation());
            return ResponseEntity.ok(new CalcResponse(result));
        } catch (InvalidOperationException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new CalcResponse("Invalid operation"));
        } catch (DivisionByZeroException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new CalcResponse("Division by zero"));
        }
    }
}
