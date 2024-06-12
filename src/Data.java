package repository;

import java.io.Serializable;

public class Data<T> implements Serializable {
    private static final long serialVersionUID = 1L;
    private T value;

    public Data(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Dado [valor=" + value + "]";
    }

    
}
