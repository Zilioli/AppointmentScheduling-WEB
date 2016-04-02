package br.com.scheduling.BO;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import br.com.scheduling.DAO.ClienteDAO;
import br.com.scheduling.DAO.FuncionarioDAO;
import br.com.scheduling.VO.FuncionarioVO;
import br.com.scheduling.VO.UsuarioVO;

@ManagedBean
@ViewScoped
public class FuncionarioBO implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<FuncionarioBO> funcionarios;
	private FuncionarioVO funcionario;
	private int selectedID;
	
	@PostConstruct
	public void init() {
		funcionario=new FuncionarioVO();
	}
	
	public List<FuncionarioBO> getFuncionarios() {
		return funcionarios;
	}
	public void setFuncionarios(List<FuncionarioBO> funcionarios) {
		this.funcionarios = funcionarios;
	}
	
	public FuncionarioVO getFuncionario() {
		return funcionario;
	}
	public void setFuncionario(FuncionarioVO funcionario) {
		this.funcionario = funcionario;
	}
	
    public void destroyWorld() {
        addMessage("System Error", "Please try again later.");
    }
     
    public void addMessage(String summary, String detail) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, detail);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

	public int getSelectedID() {
		return selectedID;
	}
	
	
	
	
	@SuppressWarnings("unused")
	public List < FuncionarioBO > getListaFuncionarios() {
		
		List < FuncionarioBO > funcionarios = new ArrayList < FuncionarioBO > ();
		FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
		FuncionarioBO bo;
		try {
			
			for (FuncionarioVO funcionario: funcionarioDAO.listFuncionario()){
				bo = new FuncionarioBO();
				bo.setFuncionario(funcionario);
				funcionarios.add(bo);
				bo = null;
			}
		} catch (Exception e) {
			//log.error(e);
		}
		return funcionarios;
	}
	
	public String ExcluirFunionario(){
		
		String str = "index";
		FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
		
	
		return str;
	}
	
	public String createFuncionario() {
		String str = "lista_cliente";

		try {
			
			FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
			funcionarioDAO.createFuncionario(this.funcionario);
		} catch (Exception e) {
			str = "insert";
		}
		return str;
	}
}
