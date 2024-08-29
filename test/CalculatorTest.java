import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CalculatorTest {
    Calculator calculator = new Calculator();

    @Test
    public void testBasicOperations() {
        assertEquals(5, calculator.calculate(Operation.ADD, 2, 3));
        assertEquals(1, calculator.calculate(Operation.SUBTRACT, 3, 2));
        assertEquals(6, calculator.calculate(Operation.MULTIPLY, 2, 3));
        assertEquals(2, calculator.calculate(Operation.DIVIDE, 6, 3));
    }

    @Test
    public void testChainingOperations() {
        ArrayList<ChainOperationStep> chainOperationSteps = new ArrayList<ChainOperationStep>();
        chainOperationSteps.add(new ChainOperationStep(Operation.ADD, 3));
        chainOperationSteps.add(new ChainOperationStep(Operation.MULTIPLY, 2));
        assertEquals(16, calculator.chainCalculate(5, chainOperationSteps));
    }

    @Test
    public void testDivisionByZero() {
        Calculator calculator = new Calculator();
        assertThrows(ArithmeticException.class, () -> calculator.calculate(Operation.DIVIDE, 10, 0));
    }
}