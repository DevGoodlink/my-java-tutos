package tp3.businessLogicLayer;
import java.util.List;

public abstract class DAO<T> {
	public abstract boolean create(T t);
	public abstract boolean delete(T t);
	public abstract boolean update(T t);
	public abstract T getById(int id);
	public abstract List<T> getAll();
}
