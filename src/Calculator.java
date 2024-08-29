import java.util.ArrayList;

public class Calculator {
    public Number calculate(Operation op, Number num1, Number num2) {
        return op.apply(num1, num2);
    }

    public Number chainCalculate(Number initial, ArrayList<ChainOperationStep> chainOperationSteps) {
        Number result = initial;
        for(ChainOperationStep chainOperationStep: chainOperationSteps){
            result = calculate(chainOperationStep.operation(), result, chainOperationStep.num());
        }
        return result;
    }
}
