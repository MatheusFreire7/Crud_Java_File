package src;
import java.util.List;

public interface CRUD<T> {
    void criar(T obj);
    List<T> ler();
    void atualizar(String cpf, T obj);
    void deletar(String cpf);
}