package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import util.HibernateUtil;

public class DaoGeneric<E> {
	private EntityManager em = HibernateUtil.getEntityManager();

	public void salvar(E entidade) {
		EntityTransaction transacao = em.getTransaction();
		transacao.begin();
		em.persist(entidade);
		transacao.commit();
	}

	public E update(E entidade) {// salva ou atualiza
		EntityTransaction transacao = em.getTransaction();
		transacao.begin();
		E entidadeSalva = em.merge(entidade);
		transacao.commit();

		return entidadeSalva;
	}

	public E pesquisar(E entidade) {
		Object id = HibernateUtil.getPrimaryKey(entidade);

		E e = (E) em.find(entidade.getClass(), id);

		return e;
	}

	public E pesquisar2(Long id, Class<E> entidade) {

		E e = (E) em.find(entidade, id);

		return e;
	}

	public void deletar(E entidade) {
		Object id = HibernateUtil.getPrimaryKey(entidade);
		EntityTransaction transacao = em.getTransaction();
		transacao.begin();
		em.createNativeQuery("delete from " + entidade.getClass().getSimpleName().toLowerCase() + " WHERE id =" + id)
				.executeUpdate();// faz o delete

		transacao.commit();// grava alteracao no banco
	}

	public List<E> listar(Class<E> entidade) {
		EntityTransaction t = em.getTransaction();

		t.begin();

		List<E> lista = em.createQuery("FROM " + entidade.getName()).getResultList();

		t.commit();

		return lista;
	}

}
