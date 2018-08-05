package fairy.dataconcealer.concealer;

public interface Concealer<T> {

    T conceal(T objectToConceal);
}
