package fr.badgers.model.dao;

import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import fr.badgers.model.dao.DAO;

public class DAOGeneriqueJPA<T, ID> implements DAO<T, ID> {

	private Class<T> entityClass;
	private String entityName = "";

	protected EntityManager entityManager;

	@SuppressWarnings("unchecked")
	public DAOGeneriqueJPA(EntityManager entityManager) {
		this.entityManager = entityManager;
		this.entityClass = ((Class<T>) ((ParameterizedType) getClass()
				.getGenericSuperclass()).getActualTypeArguments()[0]);

		Annotation[] annotations = entityClass.getAnnotations();
		for (Annotation annotation : annotations) {
			if (annotation instanceof Entity) {
				entityName = ((Entity) annotation).name();
				break;
			}
		}

		if (entityName.equals("")) {
			entityName = entityClass.getSimpleName();
		}
	}

	@Override
	public boolean delete(T obj) {
		try {
			EntityTransaction tx = entityManager.getTransaction();
			tx.begin();
			entityManager.remove(obj);
			tx.commit();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public List<T> FindAll() {
		TypedQuery<T> query = entityManager.createQuery("select E from "
				+ entityName + " E where 1 = 1", entityClass);
		return query.getResultList();
	}

	@Override
	public T getById(ID id) {
		return entityManager.find(entityClass, id);
	}

	@Override
	public T insert(T obj) {
		EntityTransaction tx = entityManager.getTransaction();
		tx.begin();
		entityManager.persist(obj);
		tx.commit();
		return obj;
	}

	@Override
	public boolean update(T obj) {
		try {
			EntityTransaction tx = entityManager.getTransaction();
			tx.begin();
			entityManager.merge(obj);
			tx.commit();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

}