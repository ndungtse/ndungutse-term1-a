package com.example.devops.services;
import com.example.devops.exceptions.InvalidOperationException;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(MockitoExtension.class)
public class MathOperatorImplTest {

    @InjectMocks
    private MathOperatorImpl mathOperator;

    @Test
    public void testDoMathMultiplication() throws InvalidOperationException {
        double result = mathOperator.doMath(3.0, 4.0, "*");
        assertEquals(12.0, result, 0.001); // Using a delta for double comparison
    }

    @Test
    public void testDoMathDivision() throws InvalidOperationException {
        double result = mathOperator.doMath(8.0, 4.0, "/");
        assertEquals(2.0, result, 0.001); // Using a delta for double comparison
    }

    @Test
    public void testDoMathAddition() throws InvalidOperationException {
        double result = mathOperator.doMath(5.0, 3.0, "+");
        assertEquals(8.0, result, 0.001); // Using a delta for double comparison
    }

    @Test
    public void testDoMathSubtraction() throws InvalidOperationException {
        double result = mathOperator.doMath(7.0, 2.0, "-");
        assertEquals(5.0, result, 0.001); // Using a delta for double comparison
    }

    @Test
    public void testDoMathDivisionByZero() {
        assertThrows(InvalidOperationException.class, () -> mathOperator.doMath(10.0, 0.0, "/"));
    }

    @Test
    public void testDoMathUnknownOperation() {
        assertThrows(RuntimeException.class, () -> mathOperator.doMath(10.0, 5.0, "%"));
    }
}
