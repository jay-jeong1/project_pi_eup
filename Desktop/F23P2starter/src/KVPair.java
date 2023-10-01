/**
 * KVPair class
 * 
 * @author kevinc97
 * @param <K> Generic value of the key
 * @param <E> Generic value of the value
 */
public class KVPair<K extends Comparable<K>, E> implements Comparable<KVPair<K,
        E>>
{
    private K theKey; // The key
    private E theVal; // The value
    private Seminar seminar;

    /**
     * Generic constructor
     * 
     * @param k key
     * @param v value
     */
    KVPair(K k, E v) {
        this.theKey = k;
        this.theVal = v;
    }

    /**
     * Compare KVPairs
     */
    @Override
    public int compareTo(KVPair<K, E> obj) {
        return theKey.compareTo(obj.getKey());
    }

    /**
     * Compare against the key
     * 
     * @param it The key that is being compared
     * @return 0, -1, 1 depending on the result
     */
    public int compareTo(K obj) {
        return theKey.compareTo(obj);
    }

    /**
     * Getters for the key
     * 
     * @return the key
     */
    public K getKey() {
        return theKey;
    }

    /**
     * Getter for the value
     * 
     * @return the value
     */
    public E getValue() {
        return theVal;
    }

}