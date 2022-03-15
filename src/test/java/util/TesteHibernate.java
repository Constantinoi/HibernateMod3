package util;

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

		pessoa.setIdade("28");
		pessoa.setNome("Jess");
		pessoa.setSobrenome("Barreto");
		pessoa.setEmail("jess@email.com");
		pessoa.setLogin("jess");
		pessoa.setSenha("123");

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

}
