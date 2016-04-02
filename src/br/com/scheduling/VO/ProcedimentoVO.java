package br.com.scheduling.VO;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tbprocedimento", catalog = "scheduling")
public class ProcedimentoVO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int idProcedimento;
	private String nmProcedimento;
	private double vlProcedimento;
	private String codProcedimento;
	private ClienteVO cliente;
	private Set<AgendamentoVO> agendamentos = new HashSet<AgendamentoVO>(); 
	
	@Id
	@GeneratedValue	
	public int getIdProcedimento() {
		return idProcedimento;
	}
	public void setIdProcedimento(int idProcedimento) {
		this.idProcedimento = idProcedimento;
	}
	public String getNmProcedimento() {
		return nmProcedimento;
	}
	public void setNmProcedimento(String nmProcedimento) {
		this.nmProcedimento = nmProcedimento;
	}
	public double getVlProcedimento() {
		return vlProcedimento;
	}
	public void setVlProcedimento(double vlProcedimento) {
		this.vlProcedimento = vlProcedimento;
	}
	public String getCodProcedimento() {
		return codProcedimento;
	}
	public void setCodProcedimento(String codProcedimento) {
		this.codProcedimento = codProcedimento;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idCliente", nullable = false)
	public ClienteVO getCliente() {
		return cliente;
	}
	public void setCliente(ClienteVO cliente) {
		this.cliente = cliente;
	}
	
	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "procedimentos")
	public Set<AgendamentoVO> getAgendamentos() {
		return agendamentos;
	}
	public void setAgendamentos(Set<AgendamentoVO> agendamentos) {
		this.agendamentos = agendamentos;
	}

}