package util;

import java.util.List;

import org.junit.Test;

import dao.DaoGeneric;
import model.UsuarioPessoa;

public class TesteHibernate {

	@Test
	public void testeHibernateUtil() {
		HibernateUtil.getEntityManager();
	}

	@Test
	public void testeSalvar() {
		DaoGeneric<UsuarioPessoa> daoGeneric = new DaoGeneric<UsuarioPessoa>();

		UsuarioPessoa pessoa = new UsuarioPessoa();

		pessoa.setIdade(28L);
		pessoa.setNome("Constantino");
		pessoa.setSobrenome("Barreto2");
		pessoa.setEmail("constantino@email.com2");
		pessoa.setLogin("constantino2");
		pessoa.setSenha("12312");

		daoGeneric.salvar(pessoa);
	}

	@Test
	public void testeUpdate() {
		DaoGeneric<UsuarioPessoa> daoGeneric = new DaoGeneric<UsuarioPessoa>();

		UsuarioPessoa pessoa = daoGeneric.pesquisar2(3l, UsuarioPessoa.class);

		pessoa.setSenha("225");

		pessoa = daoGeneric.update(pessoa);

		System.out.println(pessoa);
	}

	@Test
	public void TestePesquisar() {
		DaoGeneric<UsuarioPessoa> daoGeneric = new DaoGeneric<UsuarioPessoa>();

		UsuarioPessoa pessoa = new UsuarioPessoa();

		pessoa.setId(2L);

		pessoa = daoGeneric.pesquisar(pessoa);

		System.out.println(pessoa);
	}

	@Test
	public void TestePesquisar2() {
		DaoGeneric<UsuarioPessoa> daoGeneric = new DaoGeneric<UsuarioPessoa>();
		UsuarioPessoa pessoa = new UsuarioPessoa();

		pessoa = daoGeneric.pesquisar2(2L, UsuarioPessoa.class);

		System.out.println("pesquisar 2 :");
		System.out.println(pessoa);
	}

	@Test
	public void TesteDeletar() {
		DaoGeneric<UsuarioPessoa> daoGeneric = new DaoGeneric<UsuarioPessoa>();
		UsuarioPessoa pessoa = new UsuarioPessoa();

		pessoa = daoGeneric.pesquisar2(2L, UsuarioPessoa.class);

		daoGeneric.deletar(pessoa);

		System.out.println("deletou");

	}

	@Test
	public void TesteConsultar() {
		DaoGeneric<UsuarioPessoa> daoGeneric = new DaoGeneric<UsuarioPessoa>();
		List<UsuarioPessoa> pessoa = daoGeneric.listar(UsuarioPessoa.class);

		for (UsuarioPessoa usuarioPessoa : pessoa) {
			System.out.println(usuarioPessoa);
			System.out.println();
		}

	}

	@Test
	public void TesteQueryList() {
		DaoGeneric<UsuarioPessoa> daoGeneric = new DaoGeneric<UsuarioPessoa>();
		List<UsuarioPessoa> pessoa = daoGeneric.getEm().createQuery(" from UsuarioPessoa WHERE nome = 'Constantino'")
				.getResultList();

		for (UsuarioPessoa usuarioPessoa : pessoa) {
			System.out.println(usuarioPessoa);
			System.out.println();
		}

	}

	@Test
	public void TesteQueryListMaxResult() {
		DaoGeneric<UsuarioPessoa> daoGeneric = new DaoGeneric<UsuarioPessoa>();
		List<UsuarioPessoa> pessoa = daoGeneric.getEm().createQuery(" from UsuarioPessoa ORDER BY nome ")
				.setMaxResults(3).getResultList();

		for (UsuarioPessoa usuarioPessoa : pessoa) {
			System.out.println(usuarioPessoa);
			System.out.println();
		}

	}

	@Test
	public void TesteQueryListParameter() {
		DaoGeneric<UsuarioPessoa> daoGeneric = new DaoGeneric<UsuarioPessoa>();
		List<UsuarioPessoa> list = daoGeneric.getEm().createQuery("from UsuarioPessoa where nome =:nome")
				.setParameter("nome", "Constantino").getResultList();

		for (UsuarioPessoa usuarioPessoa : list) {
			System.out.println(usuarioPessoa);
			System.out.println();
		}

	}

	@Test
	public void TesteQueryListSomaIdade() {
		DaoGeneric<UsuarioPessoa> daoGeneric = new DaoGeneric<UsuarioPessoa>();
		Long somaIdade = (Long) daoGeneric.getEm().createQuery("select sum(u.idade) from UsuarioPessoa u ")
				.getSingleResult();

		System.out.println("Soma de todas as idade : " + somaIdade);
		System.out.println();

	}
}
