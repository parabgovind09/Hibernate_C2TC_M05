package nmfc.services;

import javax.persistence.EntityManager;

import nmfc.services.JPAUtil;
import nmfc.services.StudentDaoImpl;
import nmfc.services.StudentsDao;
import nmfc.entities.Students;

public class StudentsServiceImpl implements StudentsService {
	
	private StudentsDao dao; 
    private EntityManager entityManager; 
	
	
	public StudentsServiceImpl() {
		dao = new StudentDaoImpl(); 
		entityManager = JPAUtil.getEntityManager(); 
	}


	@Override
	public Students findStudentByBarcode(String barcode_number) {
		// TODO Auto-generated method stub
		Students student = dao.findStudentByBarcode(barcode_number); 
	    return student; 
	}
}
