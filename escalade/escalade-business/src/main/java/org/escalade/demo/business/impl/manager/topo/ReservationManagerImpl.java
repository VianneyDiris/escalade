package org.escalade.demo.business.impl.manager.topo;

import java.util.List;

//import javax.inject.Inject;
//import javax.inject.Named;

import org.escalade.demo.business.contract.manager.topo.ReservationManager;
import org.escalade.demo.business.impl.AbstractManagerImpl;
import org.escalade.demo.model.bean.topo.Reservation;
import org.escalade.demo.model.exception.NotFoundException;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class ReservationManagerImpl extends AbstractManagerImpl implements ReservationManager {
	static final Log logger = LogFactory.getLog(ReservationManagerImpl.class);
	
    private PlatformTransactionManager transactionManager;
    public void setTransactionManager(PlatformTransactionManager transactionManager) {
        this.transactionManager = transactionManager;
     }

	@Override
	public List<Reservation> getListReservation() {
		logger.debug("ReservationManagerImpl méthode getListReservation()");
		// TODO Auto-generated method stub
		return getDaoFactory().getReservationDao().listReservation();
	}

	@Override
	public Reservation getReservation(Integer id) throws NotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteReservationByTopo(Integer id) throws NotFoundException {
		logger.debug("ReservationManagerImpl méthode deleteReservationByTopo(Integer id) id = "+id);
		// TODO Auto-generated method stub
		getDaoFactory().getReservationDao().deleteReservationByTopo(id);
	}

	@Override
	public void deleteReservationByUser(Integer id) throws NotFoundException {
		logger.debug("ReservationManagerImpl méthode deleteReservationByUser(Integer id) id = "+id);
		// TODO Auto-generated method stub
		getDaoFactory().getReservationDao().deleteReservationByUser(id);
		
	}

	@Override
	public List<Reservation> listReservationByTopo(Integer id) throws NotFoundException {
		// TODO Auto-generated method stub
		return getDaoFactory().getReservationDao().listReservationByTopo(id);
	}

	@Override
	public void addReservation(Reservation reservation) {
		// TODO Auto-generated method stub
		logger.info(transactionManager);
        TransactionStatus vTransactionStatus = transactionManager.getTransaction(new DefaultTransactionDefinition());
    try {
    	getDaoFactory().getReservationDao().addReservation(reservation);
    } catch (Throwable vEx) {
        transactionManager.rollback(vTransactionStatus);
        throw vEx;
    }
    transactionManager.commit(vTransactionStatus);
	}

}
