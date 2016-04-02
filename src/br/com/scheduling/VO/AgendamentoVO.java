package br.com.scheduling.VO;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tbagendamento", catalog = "scheduling")
public class AgendamentoVO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int idAgendamento;
	private Date dtAgendamento;
	private ClienteVO cliente;
	private StatusVO status;
	private FuncionarioVO funcionario;
	private Set<ProcedimentoVO> procedimentos = new HashSet<ProcedimentoVO>();
	
	@Id
	@GeneratedValue		
	public int getIdAgendamento() {
		return idAgendamento;
	}
	public void setIdAgendamento(int idAgendamento) {
		this.idAgendamento = idAgendamento;
	}
	public Date getDtAgendamento() {
		return dtAgendamento;
	}
	public void setDtAgendamento(Date dtAgendamento) {
		this.dtAgendamento = dtAgendamento;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idCliente", nullable = false)
	public ClienteVO getCliente() {
		return cliente;
	}
	public void setCliente(ClienteVO cliente) {
		this.cliente = cliente;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idStatus", nullable = false)
	public StatusVO getStatus() {
		return status;
	}
	public void setStatus(StatusVO status) {
		this.status = status;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idFuncionario", nullable = true)
	public FuncionarioVO getFuncionario() {
		return funcionario;
	}
	public void setFuncionario(FuncionarioVO funcionario) {
		this.funcionario = funcionario;
	}
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "tbprocedimentoagendamento", catalog = "scheduling", joinColumns = { 
			@JoinColumn(name = "idAgendamento", nullable = false, updatable = false) }, 
			inverseJoinColumns = { @JoinColumn(name = "idProcedimento", 
					nullable = false, updatable = false) })
	public Set<ProcedimentoVO> getProcedimentos() {
		return procedimentos;
	}
	public void setProcedimentos(Set<ProcedimentoVO> procedimentos) {
		this.procedimentos = procedimentos;
	}
}
