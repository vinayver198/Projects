package testing;

import services.EmpServiceImpl;
import dao.EmpDao;
import dao.EmpDaoImpl;
import dao.EmpDaoImplNew;


public class TestServices {

	public static void main(String[] args) 
	{
		//EmpDao dao = new EmpDaoImpl();
		EmpDao dao = new EmpDaoImplNew();
		//EmpServiceImpl services = new EmpServiceImpl(dao);
		EmpServiceImpl services = new EmpServiceImpl();
		services.setDao(dao);
		services.bringDataSet1();
		services.bringDataSet2();

	}

}
