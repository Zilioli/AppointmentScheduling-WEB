package br.com.scheduling.VO;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

@Entity
@Table(name = "tbcliente", catalog = "scheduling")
public class ClienteVO  implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int idCliente; 
	private String nmCliente; 
	private String stCliente; 
	private Date dtCancelamento;
	private Date dtCadastro;
	private Set < UsuarioVO > usuarios = new HashSet<UsuarioVO>();
	private Set < StatusVO > status = new HashSet<StatusVO>();
	private Set < FuncionarioVO > funcionarios = new HashSet<FuncionarioVO>();
	private Set < ProcedimentoVO > procedimentos = new HashSet<ProcedimentoVO>();
	private Set < PacienteVO > pacientes = new HashSet<PacienteVO>();
	private Set < AgendamentoVO > agendamentos = new HashSet<AgendamentoVO>();	
	
	@Id
	@GeneratedValue	
	public int getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}
	public String getNmCliente() {
		return nmCliente;
	}
	public void setNmCliente(String nmCliente) {
		this.nmCliente = nmCliente;
	}
	public String getStCliente() {
		return stCliente;
	}
	public void setStCliente(String stCliente) {
		this.stCliente = stCliente;
	}
	public Date getDtCancelamento() {
		return dtCancelamento;
	}
	public void setDtCancelamento(Date dtCancelamento) {
		this.dtCancelamento = dtCancelamento;
	}
	public Date getDtCadastro() {
		return dtCadastro;
	}
	public void setDtCadastro(Date dtCadastro) {
		this.dtCadastro = dtCadastro;
	}
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "cliente", cascade = CascadeType.ALL)
	public Set < UsuarioVO > getUsuarios() {
		return usuarios;
	}
	public void setUsuarios(Set < UsuarioVO > usuarios) {
		this.usuarios = usuarios;
	}
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "cliente", cascade = CascadeType.ALL)
	public Set < StatusVO > getStatus() {
		return status;
	}
	public void setStatus(Set < StatusVO > status) {
		this.status = status;
	}
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "cliente", cascade = CascadeType.ALL)
	public Set < FuncionarioVO > getFuncionarios() {
		return funcionarios;
	}
	public void setFuncionarios(Set < FuncionarioVO > funcionarios) {
		this.funcionarios = funcionarios;
	}
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "cliente", cascade = CascadeType.ALL)
	public Set < ProcedimentoVO > getProcedimentos() {
		return procedimentos;
	}
	public void setProcedimentos(Set < ProcedimentoVO > procedimentos) {
		this.procedimentos = procedimentos;
	}
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "cliente", cascade = CascadeType.ALL)	
	public Set < PacienteVO > getPacientes() {
		return pacientes;
	}
	public void setPacientes(Set < PacienteVO > pacientes) {
		this.pacientes = pacientes;
	}
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "cliente", cascade = CascadeType.ALL)
	public Set < AgendamentoVO > getAgendamentos() {
		return agendamentos;
	}
	public void setAgendamentos(Set < AgendamentoVO > agendamentos) {
		this.agendamentos = agendamentos;
	}
}
