package src;

public interface EntityMapper<T> {
    T fromString(String data);
    String getCpf(T obj);
}