package services;

import dao.EmpDao;
import dao.EmpDaoImpl;
import dao.EmpDaoImplNew;

public class EmpServiceImpl 
{
	private EmpDao dao;
	
	//constructor injection
public EmpServiceImpl(EmpDao dao)
{
	//dao = new EmpDaoImpl();
	//dao = new EmpDaoImplNew();
	this.dao = dao;
}


//setter injection
public void setDao(EmpDao dao) {
	this.dao = dao;
}



public EmpServiceImpl() {
	super();
	// TODO Auto-generated constructor stub
}



public void bringDataSet1()
{
	dao.bringDataSet1();
}

public void bringDataSet2()
{
	dao.bringDataSet2();
}


}
