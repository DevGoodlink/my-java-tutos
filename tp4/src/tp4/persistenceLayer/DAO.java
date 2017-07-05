package tp4.persistenceLayer;
import java.util.List;

public abstract class DAO<T> {
	public abstract boolean create(T t);
	public abstract boolean delete(T t);
	public abstract boolean update(T t,T t1);
	public abstract T getById(int id);
	public abstract List<T> getAll();
}
