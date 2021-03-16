/** An Integer tester created by Flik Enterprises.
 * @author Josh Hug
 * */
public class Flik {
    /** @param a Value 1
     *  @param b Value 2
     *  @return Whether a and b are the same */
//    Integer在装载时，内部的IntegerCache的static块即将开始执行，实例化并暂存数值在-128，127之间的Integer类型对象。
//    这些常用数值在自动装箱时直接返回，从而提高效率，不用每次都要new一个新的对象。
    public static boolean isSameNumber(Integer a, Integer b) {
        return a.equals(b);
    }
}
