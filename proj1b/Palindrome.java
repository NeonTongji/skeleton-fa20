public class Palindrome{
    public Deque<Character> wordToDeque(String word){
        /*return a Deque where the characters appear in the same order as in the String.*/
        ArrayDeque<Character> wordDeque = new ArrayDeque<>();
        for(int i = 0; i < word.length(); i++){
           wordDeque.addLast(word.charAt(i));
        }
        return wordDeque;
    }

    public boolean isPalindrome(String word){
        /*he isPalindrome method should return true if the given word is a palindrome,
        and false otherwise. */
        if (word.length() < 2){
            return true;
        }
        if(word.equals("null")){
            return false;
        }
        Deque<Character> wordDeque = wordToDeque(word);

//      numTurn:  要判断的回合数
        int numTurn = word.length() / 2;
        for(int i = 0; i < numTurn; i++){
            if(!wordDeque.get(i).equals(wordDeque.get(word.length() - 1 - i))) {
                return false;
            }
        }
        return true;
    }

    public boolean isPalindrome(String word, CharacterComparator cc){
        if (word.length() < 2){
            return true;
        }
        if(word.equals("null")){
            return false;
        }
        Deque<Character> wordDeque = wordToDeque(word);

//      numTurn:  要判断的回合数
        int numTurn = word.length() / 2;
        for(int i = 0; i < numTurn; i++){
            if(!cc.equalChars(wordDeque.get(i), wordDeque.get(word.length() - 1 - i))){
                return false;
            }
        }
        return true;
    }





}