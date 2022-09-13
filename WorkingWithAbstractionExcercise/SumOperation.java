package WorkingWithAbstractionExcercise;

public class SumOperation implements Operation{
    @Override
    public int operation(int a, int b){
        return a + b;
    }
}
