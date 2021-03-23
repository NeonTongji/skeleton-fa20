/**
 * Created by hug.
 */
public interface Lab5FloorSet {
//    adds x to the set. If x is already present, it has no effect.
    void add(double x);
//    gives the largest value in the set that is less than or equal to x.
//    If no values are smaller than x, it should return negative infinity
    double floor(double x);
}
