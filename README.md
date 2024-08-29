## Overview
This project provides a basic arithmetic calculator that supports addition, subtraction, multiplication, and division operations. 
It also allows for chained calculations where a series of operations can be applied sequentially.
It is also extensible so that new operations can be added without modifying the core Calculator class.

IoC is acheived here by delegating all logic to the `Operation` enum. This ensures that the `Calculator` class does not need to be modified while adding new operations.

To add a new operation to the calculator, a new enum and corresponding logic need to be added to `Operation` enum. For example
```java
.
.
.
DIVIDE {
  @Override
  public Number apply(Number num1, Number num2) {
    if (num2.doubleValue() == 0) {
        throw new ArithmeticException("Cannot divide by zero");
    }
    return num1.doubleValue() / num2.doubleValue();
  }
},
MODULO {
  @Override
  public Number apply(Number num1, Number num2) {
      return num1.doubleValue() % num2.doubleValue();
  }
};
```

## Usage

### Example: Basic Calculation
```java
Calculator calculator = new Calculator();
Number result = calculator.calculate(Operation.ADD, 5, 3);
System.out.println(result); // Output: 8
```

### Example: Chained Calculation
```java
Calculator calculator = new Calculator();

ArrayList<ChainOperationStep> steps = new ArrayList<>();
steps.add(new ChainOperationStep(Operation.ADD, 5));
steps.add(new ChainOperationStep(Operation.MULTIPLY, 2));

Number chainResult = calculator.chainCalculate(10, steps);
System.out.println(chainResult); // Output: 30
```

## Testing
JUnit test cases are in test/CalculatorTest.java. Please make sure you add the lib folder to your system path so you can run this file. 

## Assumptions
1. Since Operation is an enum, there can never be an invalid input to calculate(). So, not going to handle that. If the input could also be a string, then we can validate accordingly and throw an exception for illegal arguments
2. Using doubles as the default for precision
3. Chain operations will take a custom input as depicted in the above examples
