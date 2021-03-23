import java.util.ArrayList;
import java.util.List;

/**
 * Class that collects timing information about SLList getLast method.
 */
public class TimeSLList {
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
        timeGetLast();
    }

    public static void timeGetLast() {
        int ops = 1;
        int M = 10000;
//        STEP1: CREATE AN SLList
        SLList<Integer> slList= new SLList<Integer>();
        List<Integer> col1 = new ArrayList<>();
        List<Double> col2 = new ArrayList<>();
        List<Integer> col3 = new ArrayList<>();
//        STEP2: ADD ITEMS TO SLList
        for(int n = 1000; n <= 128000; n *= 2){
            for (int j = 0; j < n; j++){
                slList.addLast(n);
            }
//            STEP3: STARTER TIMER
            Stopwatch tick = new Stopwatch();
//            STEP4: GETLAST FROM SLList
            for (int j = 0; j < M; j++){
                slList.getLast();
            }
//            STEP5: CHECK TIMER
            Double timeInSeconds = tick.elapsedTime();
            col1.add(n);
            col2.add(timeInSeconds);
            col3.add(M);
        }
        printTimingTable(col1, col2 , col3);
    }

}
