package dbAccess;

import java.util.List;

import dtos.IEntity;

public interface ICrudOperators<T extends IEntity, F extends Filters> {

	boolean create(T t);

	List<T> read(F filter, Object value);

	T readOne(F filter, Object value);
	
	T readOneById(int id);

	boolean update(T t);

	boolean delete(T t);
}