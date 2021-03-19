
/** This class outputs all palindromes in the words file in the current directory. */
public class PalindromeFinder {
    public static void main(String[] args) {
        int minLength = 4;
        In in = new In("../library-fa20/data/words.txt");
        Palindrome palindrome = new Palindrome();


//        一个接口可以被多个类实现，从而拥有不同的功能。
        int n = 4;
        OffByN o = new OffByN(n);

        while (!in.isEmpty()) {
            String word = in.readString();
            if (word.length() >= minLength && palindrome.isPalindrome(word, o)) {
                System.out.println(word);
            }
        }
    }
}
//Uncomment this class once you've written isPalindrome.
