package br.com.scheduling.BO;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.apache.log4j.Logger;
import br.com.scheduling.DAO.ClienteDAO;
import br.com.scheduling.VO.ClienteVO;
import br.com.scheduling.VO.UsuarioVO;

@ManagedBean
@ViewScoped
public class ClienteBO implements java.io.Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L; 
	private static Logger log = Logger.getLogger(ClienteBO.class);
	private ClienteVO cliente = new ClienteVO();
	private List<ClienteBO> clientes;
	
	public ClienteVO getCliente() {
		return cliente;
	}
	public void setCliente(ClienteVO cliente) {
		this.cliente = cliente;
	}
	public List<ClienteBO> getClientes() {
		return clientes;
	}
	public void setClientes(List<ClienteBO> clientes) {
		this.clientes = clientes;
	}
	
	public String createCliente() {
		String str = "lista_cliente";
		Set<UsuarioVO> usuarios = new HashSet<UsuarioVO>();;
		UsuarioVO usuario;
		Date date = new Date();
		try {
			ClienteDAO clienteDAO = new ClienteDAO();
			
			//this.cliente.setDtCadastro(date);
			this.cliente.setNmCliente("Cliente");
			this.cliente.setStCliente("A");
			
			
			usuario = new UsuarioVO();
			//usuario.setDtCadastro(date);
			usuario.setNmUsuario("user 1");
			usuario.setStUsuario("A");
			usuario.setCliente(this.cliente);
			usuarios.add(usuario);
			usuario = null;
			usuario = new UsuarioVO();
			//usuario.setDtCadastro(date);
			usuario.setNmUsuario("user 2");
			usuario.setStUsuario("A");
			usuario.setCliente(this.cliente);
			usuarios.add(usuario);
			
			this.cliente.setUsuarios(usuarios);
			clienteDAO.createCliente(this.cliente);
		} catch (Exception e) {
			str = "insert";
			log.error(e);
		}
		return str;
	}
	
}
