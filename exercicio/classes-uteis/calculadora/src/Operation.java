import java.util.stream.IntStream;

public enum Operation {
    SUM(n -> IntStream.of(n).reduce(0, Integer::sum)),
    SUBTRACTION(n -> IntStream.of(n).reduce(0, (a, b) -> a - b));

    private final Calc operationBack;

    Operation(Calc operationBack) {
        this.operationBack = operationBack;
    }

    public Calc getOperationBack() {
        return operationBack;
    }
}
