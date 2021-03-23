import java.util.ArrayList;
import java.util.List;

/**
 * Class that collects timing information about AList construction.
 */
public class TimeAList {
    private static void printTimingTable(List<Integer> Ns, List<Double> times, List<Integer> opCounts) {
        System.out.printf("%12s %12s %12s %12s\n", "N", "time (s)", "# ops", "microsec/op");
        System.out.printf("------------------------------------------------------------\n");
        for (int i = 0; i < Ns.size(); i += 1) {
            int N = Ns.get(i);
            double time = times.get(i);
            int opCount = opCounts.get(i);
            double timePerOp = time / opCount * 1e6;
            System.out.printf("%12d %12.2f %12d %12.2f\n", N, time, opCount, timePerOp);
        }
    }

    public static void main(String[] args) {
        System.out.println("Timing table for addLast");
        timeAListConstruction();
    }

    public static void timeAListConstruction() {
        List<Integer> col1 = new ArrayList<>();
        List<Double> col2 = new ArrayList<>();
        List<Integer> col3 = new ArrayList<>();
        for(int n = 1000; n <= 128000; n *= 2) {
            Stopwatch tick = new Stopwatch();
            AList aList = new AList();
            int ops = 0;
            for(int i = 0; i < n; i++){
                aList.addLast(i);
                ops++;
            }
            double timeInSeconds = tick.elapsedTime();
            col1.add(n);
            col2.add(timeInSeconds);
            col3.add(ops);
        }
        printTimingTable(col1, col2, col3);
    }


}
