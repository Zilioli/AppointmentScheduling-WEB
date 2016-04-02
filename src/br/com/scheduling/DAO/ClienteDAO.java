package br.com.scheduling.DAO;

import org.hibernate.Session;
import org.hibernate.Transaction;
import br.com.scheduling.VO.ClienteVO;
import br.com.scheduling.Util.HibernateUtil;

public class ClienteDAO {

	public void createCliente(ClienteVO cliente) throws Exception{ 
		Transaction trns = null; 
		Session session = HibernateUtil.getSessionFactory().openSession(); 
		
		try { 
			trns = session.beginTransaction(); 
			session.save(cliente); 
			session.getTransaction().commit(); 
		} 
		catch (RuntimeException e) { 
			if (trns != null) { 
				trns.rollback(); 
			} 
			e.printStackTrace(); 
			throw new Exception("Error ao criar cliente"); 
		} 
		finally { 
			session.flush(); 
			session.close(); 
		} 
	}
	
}
