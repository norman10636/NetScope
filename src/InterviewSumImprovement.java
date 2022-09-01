import java.util.ArrayList;
import java.util.List;

public class InterviewSumImprovement {

    private static final List<Integer> inputs = new ArrayList<>();

    static {
        inputs.add(1);
        inputs.add(2);
        inputs.add(3);
        inputs.add(4);
        inputs.add(5);
        inputs.add(6);
        inputs.add(7);
    }

    public static void main(String[] args) {
        List<SumResult> results = threeSumTo10(inputs);
        for (SumResult result : results) {
            System.out.println(result.headNum + " " + result.interNum + " " + result.tailNum);
        }
    }

    public static List<SumResult> threeSumTo10(List<Integer> inputs) {
        List<SumResult> results = new ArrayList<>();
        int headIndex = 0;
        int interIndex = inputs.size() - 2;
        int tailIndex = inputs.size() - 1;
        while (tailIndex > 1) {
            if (inputs.get(tailIndex) < 10) {
                int tmpSum = 10 - inputs.get(tailIndex);
                findTheTmpSum(headIndex, interIndex, tailIndex, tmpSum, results);
                tailIndex--;
                interIndex--;
            } else {
                tailIndex --;
                interIndex--;
            }
        }

        return results;
    }

    private static void findTheTmpSum(int headIndex, int interIndex, int tailIndex, int tmpSum, List<SumResult> results) {
        while (headIndex < interIndex) {
            int sum = inputs.get(headIndex) + inputs.get(interIndex);
            if (sum == tmpSum) {
               SumResult result = new SumResult();
                result.headNum = inputs.get(headIndex);
                result.interNum = inputs.get(interIndex);
                result.tailNum = inputs.get(tailIndex);
                results.add(result);
                headIndex++;
                interIndex--;
            } else if(sum > tmpSum) {
                interIndex--;
            }  else if(sum < tmpSum) {
                headIndex++;
            }
        }
    }

    static class SumResult {
        public Integer headNum;
        public Integer interNum;
        public Integer tailNum;
    }
}
