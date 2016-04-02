package br.com.scheduling.DAO;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import br.com.scheduling.Util.HibernateUtil;
import br.com.scheduling.VO.FuncionarioVO;

public class FuncionarioDAO {

	public void createFuncionario(FuncionarioVO funcionario) throws Exception{ 
		Transaction trns = null; 
		Session session = HibernateUtil.getSessionFactory().openSession(); 
		
		try { 
			trns = session.beginTransaction(); 
			session.save(funcionario); 
			session.getTransaction().commit(); 
		} 
		catch (RuntimeException e) { 
			if (trns != null) { 
				trns.rollback(); 
			} 
			e.printStackTrace(); 
			throw new Exception("Error ao criar funcionario"); 
		} 
		finally { 
			session.flush(); 
			session.close(); 
		} 
	}
	
	@SuppressWarnings("unchecked") 
	public List<FuncionarioVO> listFuncionario(){ 
		List<FuncionarioVO> funcionarios = new ArrayList<FuncionarioVO>(); 
		Session session = HibernateUtil.getSessionFactory().openSession(); 

		try { 
			funcionarios = session.createQuery("from FuncionarioVO").list(); 
		} 
		catch (RuntimeException e) { 
			e.printStackTrace(); 
		} 
		finally { 
			session.flush(); 
			session.close(); 
		} 

		return funcionarios; 
	} 
	
	public void updateFuncionario(FuncionarioVO funcionario) throws Exception{ 
		Transaction trns = null; 
		Session session = HibernateUtil.getSessionFactory().openSession(); 

		try { 
			trns = session.beginTransaction(); 
			session.update(funcionario); session.getTransaction().commit(); 
		} 
		catch (RuntimeException e) { 
			if (trns != null) { 
				trns.rollback(); 
			} 
			e.printStackTrace(); 

			throw new Exception("Error ao atualizar Funcionario"); 
		} 
		finally { 
			session.flush(); session.close(); 
		} 
	}
	
}
