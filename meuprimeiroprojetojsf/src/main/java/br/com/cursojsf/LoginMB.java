package br.com.cursojsf;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import br.com.entidades.Pessoa;

@ManagedBean(name = "loginMB")
public class LoginMB {
  private Pessoa pessoa = new Pessoa();

  public String doEfetuarLogin() {
    if("a".equals(pessoa.getNome())
            && "123".equals(pessoa.getSenha())) {
      return "a";
    } else {
      /* Cria uma mensagem. */
      FacesMessage msg = new FacesMessage("Usuário ou senha inválido!");
      /* Obtém a instancia atual do FacesContext e adiciona a mensagem de erro nele. */
      FacesContext.getCurrentInstance().addMessage("erro", msg);
      return null;
    }
  }

  public Pessoa getPessoa() {
    return pessoa;
  }

  public void setPessoa(Pessoa pessoa) {
    this.pessoa = pessoa;
  }
}
