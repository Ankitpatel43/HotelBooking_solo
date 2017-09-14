package dbAccess;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import dtos.IEntity;

public abstract class AbstractJPACrudOperator<T extends IEntity, F extends JPAFilters> implements ICrudOperators<T, F> {
	private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("HotelBooking_Project");
	private static final EntityManager em = emf.createEntityManager();

	private Class<T> clz;

	protected AbstractJPACrudOperator(Class<T> clz) {
		this.clz = clz;
	}

	@Override
	public boolean create(T t) {
		em.getTransaction().begin();
		em.persist(t);
		em.getTransaction().commit();
		return true;
	}

	@Override
	public List<T> read(F filter, Object value) {
		TypedQuery<T> query = em.createNamedQuery(filter.getFilter(), clz);
		if (filter.getParamName() != null)
			query.setParameter(filter.getParamName(), value);
		return query.getResultList();
	}

	@Override
	public T readOne(F filter, Object value) {
		List<T> read = read(filter, value);
		return read.size() == 1 ? read.get(0) : null;
	}

	@Override
	public T readOneById(int id) {
		return em.find(clz, id);
	}

	@Override
	public boolean update(T t) {
		em.getTransaction().begin();
		em.getTransaction().commit();
		return true;
	}

	@Override
	public boolean delete(T t) {
		T b = readOneById(t.getId());
		if (b == null)
			return false;
		else {
			em.getTransaction().begin();
			em.remove(b);
			em.getTransaction().commit();
			return true;
		}
	}
	
	public static void closeResources(){
		em.close();
		emf.close();
	}

}
