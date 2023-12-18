package com.example.devops.services;

import com.example.devops.exceptions.DivisionByZeroException;
import com.example.devops.exceptions.InvalidOperationException;

public interface MathOperator {
   public double doMath(double a, double b, String operator) throws InvalidOperationException, DivisionByZeroException;
}
