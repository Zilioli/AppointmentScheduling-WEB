package br.com.scheduling.VO;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tbpaciente", catalog = "scheduling")
public class PacienteVO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int idPaciente;
	private String nmPaciente;
	private String telPaciente1;
	private String telPaciente2;
	private String codPaciente;
	private String stPaciente;
	private ClienteVO cliente;
	
	@Id
	@GeneratedValue	
	public int getIdPaciente() {
		return idPaciente;
	}
	public void setIdPaciente(int idPaciente) {
		this.idPaciente = idPaciente;
	}
	public String getNmPaciente() {
		return nmPaciente;
	}
	public void setNmPaciente(String nmPaciente) {
		this.nmPaciente = nmPaciente;
	}
	public String getTelPaciente1() {
		return telPaciente1;
	}
	public void setTelPaciente1(String telPaciente1) {
		this.telPaciente1 = telPaciente1;
	}
	public String getTelPaciente2() {
		return telPaciente2;
	}
	public void setTelPaciente2(String telPaciente2) {
		this.telPaciente2 = telPaciente2;
	}
	
	public String getCodPaciente() {
		return codPaciente;
	}
	public void setCodPaciente(String codPaciente) {
		this.codPaciente = codPaciente;
	}
	public String getStPaciente() {
		return stPaciente;
	}
	public void setStPaciente(String stPaciente) {
		this.stPaciente = stPaciente;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idCliente", nullable = false)	
	public ClienteVO getCliente() {
		return cliente;
	}
	public void setCliente(ClienteVO cliente) {
		this.cliente = cliente;
	}
}
