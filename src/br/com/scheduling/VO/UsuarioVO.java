package br.com.scheduling.VO;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Id;
import javax.persistence.Table;;

@Entity
@Table(name = "tbusuario", catalog = "scheduling")
public class UsuarioVO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int idUsuario; 
	private String nmUsuario; 
	private String stUsuario; 
	private Date dtCadastro;
	private Date dtCancelamento;
	private String login;
	private String senha;
	private ClienteVO cliente;

	@Id
	@GeneratedValue
	public int getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}
	public String getNmUsuario() {
		return nmUsuario;
	}
	public void setNmUsuario(String nmUsuario) {
		this.nmUsuario = nmUsuario;
	}
	public String getStUsuario() {
		return stUsuario;
	}
	public void setStUsuario(String stUsuario) {
		this.stUsuario = stUsuario;
	}
	public Date getDtCadastro() {
		return dtCadastro;
	}
	public void setDtCadastro(java.util.Date date) {
		this.dtCadastro = date;
	}
	public Date getDtCancelamento() {
		return dtCancelamento;
	}
	public void setDtCancelamento(Date dtCancelamento) {
		this.dtCancelamento = dtCancelamento;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idCliente", nullable = false)
	public ClienteVO getCliente() {
		return cliente;
	}
	public void setCliente(ClienteVO cliente) {
		this.cliente = cliente;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
}