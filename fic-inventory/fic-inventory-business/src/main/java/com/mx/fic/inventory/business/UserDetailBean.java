package com.mx.fic.inventory.business;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;

import com.mx.fic.inventory.dto.UserDetailDTO;
import com.mx.fic.inventory.persistent.UserDetail;

//@Local
@Stateless (mappedName= "UserDetailBean")
@TransactionManagement (TransactionManagementType.CONTAINER)
public class UserDetailBean implements UserDetailBeanLocal {
	
	private EntityManager entityManager;
	
	/* (non-Javadoc)
	 * @see com.mx.fic.inventory.business.UserDetailBeanLocal#save(com.mx.fic.inventory.dto.UserDetailDTO)
	 */
	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void save(final UserDetailDTO userDetailDTO){
		final UserDetail userDetail= new UserDetail();
		
		if((userDetailDTO.getLastName()!=null && !userDetailDTO.getLastName().equals("")) &&
				(userDetailDTO.getName()!=null && !userDetailDTO.getName().equals("")) &&
					(userDetailDTO.getShortName()!=null && !userDetailDTO.getShortName().equals(""))){
			
			userDetail.setAddress(userDetailDTO.getAddress());
			userDetail.setCurp(userDetailDTO.getCurp());
			userDetail.setEmail(userDetailDTO.getEmail());
			userDetail.setLastAccess(userDetail.getLastAccess());
			userDetail.setLastName(userDetailDTO.getLastName());
			userDetail.setName(userDetailDTO.getName());
			userDetail.setShortName(userDetailDTO.getShortName());
			userDetail.setRfc(userDetailDTO.getRfc());
			userDetail.setSurName(userDetailDTO.getSurName());
			userDetail.setTelephone(userDetailDTO.getTelephone());
			entityManager.persist(userDetail);
			
		}
		
	}

}
