public class OffByOne implements CharacterComparator {
    /*returns true for characters that are off by one from each other*/
    @Override
    public boolean equalChars(char x, char y){
        return Math.abs(x - y) == 1;
    }
}