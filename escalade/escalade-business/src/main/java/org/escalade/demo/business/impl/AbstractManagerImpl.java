package org.escalade.demo.business.impl;

import org.escalade.demo.consumer.impl.DaoFactoryImpl;

public abstract class AbstractManagerImpl {
	
	private static DaoFactoryImpl daoFactory;
	
	protected static DaoFactoryImpl getDaoFactory() {
		return daoFactory;
	}
	
	public static void setDaoFactory(DaoFactoryImpl daoFactory) {
		AbstractManagerImpl.daoFactory=daoFactory;
	}

}
