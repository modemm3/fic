package com.mx.fic.inventory.business;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.mx.fic.inventory.business.builder.config.TransferObjectAssembler;
import com.mx.fic.inventory.dto.SecretQuestionDTO;
import com.mx.fic.inventory.persistent.SecretQuestion;

//@Local
@Stateless (mappedName= "SecretQuestionBean")
@TransactionManagement (TransactionManagementType.CONTAINER)
public class SecretQuestionBean implements SecretQuestionBeanLocal  {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	/* (non-Javadoc)
	 * @see com.mx.fic.inventory.business.SecretQuestionBeanLocal#getAll()
	 */
	@Override
	public List<SecretQuestionDTO> getAll(){
		
		List<SecretQuestion> secretQuestionLst= new ArrayList<SecretQuestion>();
		List<SecretQuestionDTO> secretQuestionDTOLst= null;
		SecretQuestionDTO secretQuestionDTO= null;

		TypedQuery<SecretQuestion> query= entityManager.createNamedQuery("SecretQuestion.getAll", SecretQuestion.class);
		secretQuestionLst= query.getResultList();
		
		if(secretQuestionLst!=null && secretQuestionLst.size()>0){
			secretQuestionDTOLst= new ArrayList<SecretQuestionDTO>();
			for(SecretQuestion sq : secretQuestionLst){
				secretQuestionDTO= TransferObjectAssembler.getInstance().assembleTO(SecretQuestionDTO.class, sq);
				secretQuestionDTOLst.add(secretQuestionDTO);
			}
		}
		
		return secretQuestionDTOLst;
	}

}
