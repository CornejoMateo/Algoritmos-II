
public class Pair<F,S> {

    private F first;
    private S second;

    /**
     * Default Constructor.
     */
    public Pair() {
        this.first = null;
        this.second = null;
    }

    /**
     * Constructor Parametrizado.
     */
    public Pair(F first, S second) {
        this.first = first;
        this.second = second;
    }

    public F getFirst(){
        return first;
    }

    public void setFirst(F first){
        this.first = first;
    }

    public S getSecond(){
        return second;
    }

    public void setSecond(S second){
        this.second = second;
    }

    /**
     *Overriding toString() to convert Pair objects to String.
     */
    @Override
    public String toString() {
        return ("(" + first.toString() + "," + second.toString() + ")");
    }

    /**
     * Overriding equals() to compare two Pair objects.
     */
    @Override
    public boolean equals(Object other) {
        if (other == null) {
            return false;
        }
        if (!(other instanceof Pair)) {
            return false;
        }
        Pair<F,S> actualOther = (Pair<F,S>) other;
        boolean equals = actualOther.getFirst().equals(this.first);
        equals &= actualOther.getSecond().equals(this.second);
        return equals;
    }

}