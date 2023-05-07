package nmfc.services;

import java.util.List;

import nmfc.entities.Visitors;

public interface VisitorsDao {
	
	public abstract void addVisitors(Visitors visitors);
	
	public abstract Long getAllVisitorsCount();

	public abstract Visitors findVisitorBySeatNumber(String seatNumber);

    public abstract List getAllVisitorsRollNumber();
	
	public abstract List getAllVisitorsSeatNumber();
	
	public abstract List getAllVisitorsName();
	
    public abstract List getAllVisitorsStream();
	
	public abstract List getAllVisitorsClass();
	
	public abstract List getAllVisitorsDivision();
	
	public abstract List getAllVisitorsLibraryCardValidUpto();
	
	public abstract List getAllVisitorsStatus();
	
    public abstract List getAllVisitorsTime();
	
	public abstract List getAllVisitorsDate();

}
