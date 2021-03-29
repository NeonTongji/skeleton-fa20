/** A client that uses the synthesizer package to replicate a plucked guitar string sound */

import es.datastructur.synthesizer.ArrayRingBuffer;
import es.datastructur.synthesizer.BoundedQueue;
import es.datastructur.synthesizer.GuitarString;

public class GuitarHero {

    static String keyboard = "q2we4r5ty7u8i9op-[=zxdcfvgbnjmk,.;/' ";
    private static char[] key = keyboard.toCharArray();
    static BoundedQueue<GuitarString> CONCERT_KEY;
    static double frequency;
    static double sample;
    static GuitarString stringCur;

    public static void main(String[] args) {
        /* 先建一个doundedQueue类的数组 */
        CONCERT_KEY = new ArrayRingBuffer<>(37);

        /* 把音符加入到CONCERT_KEY */
        for(int i = 0; i < 37; i++){
            frequency = 440 * Math.pow(2, (i - 24) / 12);
            GuitarString string = new GuitarString(frequency);
            CONCERT_KEY.enqueue(string);
        }

        for(int i = 0; i < 37; i ++){
            /*检查用户是否按了这个键，按了的话就加载*/
            if(StdDraw.hasNextKeyTyped()) {
                char key = StdDraw.nextKeyTyped();
                if(key == keyboard.indexOf(i)){
                    stringCur = CONCERT_KEY.dequeue();
                    stringCur.pluck();
                }
            }
            sample = sample + stringCur.sample();

            StdAudio.play(sample);
            stringCur.tic();

        }

    }




}

