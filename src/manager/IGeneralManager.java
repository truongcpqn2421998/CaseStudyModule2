package manager;

public interface IGeneralManager<E> {
    void save(E e);
    void remove(E e);
    void update(int index,E e);
    E search(String id);
}
