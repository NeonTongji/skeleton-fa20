import org.junit.Test;
import static org.junit.Assert.assertEquals;

/**
 * Created by hug.
 */
public class TestRedBlackFloorSet {
    @Test
    public void randomizedTest() {
        AListFloorSet aSet = new AListFloorSet();
        RedBlackFloorSet rSet = new RedBlackFloorSet();

        for(int i = 0; i < 100000; i++){
            double num = StdRandom.uniform(-5000, 5000);
            aSet.add(num);
            rSet.add(num);
        }

        for(int i = 0; i < 100000; i++){
            double num = StdRandom.uniform(-5000, 5000);
            aSet.floor(num);
            rSet.floor(num);
        }

        assertEquals(aSet, rSet);


    }
}
