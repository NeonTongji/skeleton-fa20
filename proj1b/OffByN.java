public class OffByN implements CharacterComparator {
    private final int step;

    public OffByN(int step){
        this.step = step;
    }

    @Override
    public boolean equalChars(char x, char y){
        return (Math.abs(x - y) == step);
    }
}
