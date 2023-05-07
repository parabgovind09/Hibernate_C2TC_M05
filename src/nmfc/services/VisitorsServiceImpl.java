package nmfc.services;

import java.util.List;

import javax.persistence.EntityManager;

import nmfc.entities.Visitors;

public class VisitorsServiceImpl implements VisitorsService{
	
	private VisitorsDao dao; 
    private EntityManager entityManager; 
	
	
	public VisitorsServiceImpl() {
		dao = new VisitorsDaoImpl(); 
		entityManager = JPAUtil.getEntityManager(); 
	}

	@Override
	public void addVisitors(Visitors visitor) {
		// TODO Auto-generated method stub		
		dao.addVisitors(visitor);
	}

	@Override
	public List getAllVisitorsTime() {
		// TODO Auto-generated method stub
		return dao.getAllVisitorsTime();
	}

	@Override
	public List getAllVisitorsDate() {
		// TODO Auto-generated method stub
		return dao.getAllVisitorsDate();
	}

	@Override
	public List getAllVisitorsStream() {
		// TODO Auto-generated method stub
		return dao.getAllVisitorsStream();
	}

	@Override
	public List getAllVisitorsName() {
		// TODO Auto-generated method stub
		return dao.getAllVisitorsName();
	}

	@Override
	public List getAllVisitorsClass() {
		// TODO Auto-generated method stub
		return dao.getAllVisitorsClass();
	}

	@Override
	public List getAllVisitorsStatus() {
		// TODO Auto-generated method stub
		return dao.getAllVisitorsStatus();
	}

	@Override
	public Visitors findVisitorBySeatNumber(String seatNumber) {
		// TODO Auto-generated method stub
		Visitors visitor = dao.findVisitorBySeatNumber(seatNumber); 
	    return visitor;
	}

	@Override
	public List getAllVisitorsRollNumber() {
		// TODO Auto-generated method stub
		return dao.getAllVisitorsRollNumber();
	}

	@Override
	public List getAllVisitorsSeatNumber() {
		// TODO Auto-generated method stub
		return dao.getAllVisitorsSeatNumber();
	}

	@Override
	public List getAllVisitorsDivision() {
		// TODO Auto-generated method stub
		return dao.getAllVisitorsDivision();
	}

	@Override
	public List getAllVisitorsLibraryCardValidUpto() {
		// TODO Auto-generated method stub
		return dao.getAllVisitorsLibraryCardValidUpto();
	}
}
