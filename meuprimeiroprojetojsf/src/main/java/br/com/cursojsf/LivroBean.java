package br.com.cursojsf;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;

import br.com.dao.DaoGeneric;
import br.com.entidades.Livro;

@SessionScoped
@ManagedBean(name = "livroBean")
public class LivroBean {
	
	private Livro livro = new Livro();
	
	private DaoGeneric<Livro> daoGeneric = new DaoGeneric<Livro>();
	private List<Livro> livros = new ArrayList<Livro>();
	private List<Livro> filtroLivros = new ArrayList<>();
	
	public LivroBean() {
		carregarLivros();
	}
	
	public String salvar() {
		livro = daoGeneric.merge(livro);
		carregarLivros();
		return "";
	}
	
	public String novo() {
		livro = new Livro();
		return "";
	}
	
	public String remove() {
		daoGeneric.deletePorId(livro);
		livro = new Livro();
		carregarLivros();
		return "";
	}

	public String retornar() {
		remove();
		return "";
	}
	
	@PostConstruct
	public void carregarLivros() {
		livros = daoGeneric.getListEntity(Livro.class);
	}

	public Livro getLivro() {
		return livro;
	}

	public void setLivro(Livro livro) {
		this.livro = livro;
	}

	public List<Livro> getLivros() {
		return livros;
	}

	public void setLivros(List<Livro> livros) {
		this.livros = livros;
	}

	public DaoGeneric<Livro> getDaoGeneric() {
		return daoGeneric;
	}

	public void setDaoGeneric(DaoGeneric<Livro> daoGeneric) {
		this.daoGeneric = daoGeneric;
	}

	public List<Livro> getFiltroLivros() {
		return filtroLivros;
	}

	public void setFiltroLivros(List<Livro> filtroLivros) {
		this.filtroLivros = filtroLivros;
	}
	
	

}
