package br.com.scheduling.VO;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tbstatus", catalog = "scheduling")
public class StatusVO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int idStatus;
	private String nmStatus;
	private ClienteVO cliente;
	private Set < AgendamentoVO > agendamentos = new HashSet<AgendamentoVO>();
	
	@Id
	@GeneratedValue		
	public int getIdStatus() {
		return idStatus;
	}
	public void setIdStatus(int idStatus) {
		this.idStatus = idStatus;
	}
	public String getNmStatus() {
		return nmStatus;
	}
	public void setNmStatus(String nmStatus) {
		this.nmStatus = nmStatus;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idCliente", nullable = false)	
	public ClienteVO getCliente() {
		return cliente;
	}
	public void setCliente(ClienteVO cliente) {
		this.cliente = cliente;
	}
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "status", cascade = CascadeType.ALL)
	public Set < AgendamentoVO > getAgendamentos() {
		return agendamentos;
	}
	public void setAgendamentos(Set < AgendamentoVO > agendamentos) {
		this.agendamentos = agendamentos;
	}

}
