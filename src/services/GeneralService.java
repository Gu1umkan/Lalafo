package services;

public interface GeneralService<T> {
    String add(T t);
    String removeById(long id);
    String updateById(long id, T t);
}
