package nmfc.services;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import net.sourceforge.jdatepicker.impl.JDatePickerImpl;
import nmfc.entities.Visitors;

public class VisitorsDaoImpl implements VisitorsDao{
	
private EntityManager entityManager; 
	
	public VisitorsDaoImpl() { 
	    entityManager = JPAUtil.getEntityManager(); 
	}	

	@Override
	public Long getAllVisitorsCount() {
		// TODO Auto-generated method stub
		String qStr = "SELECT COUNT(visitors.visitor_seat_number) FROM Visitors visitors";
		TypedQuery<Long> query = entityManager.createQuery(qStr,Long.class);
		Long count = query.getSingleResult();
		return count;
	} 
	
	public Long getStreamCountByTDAte(String fdate) {
		String qStr = "SELECT COUNT(visitors) FROM Visitors visitors WHERE visitors.visit_date = :pstream AND visit_status ='come'";
		TypedQuery<Long> query = entityManager.createQuery(qStr,Long.class);
		query.setParameter("pstream", fdate);
		Long countStream = query.getSingleResult();
		return countStream;
	}
	
	public String getStreamCountByTCurrent(String fdate) {
		String qStr = "SELECT COUNT(visitors) FROM Visitors visitors WHERE visitors.visit_date = :pstream AND visit_status ='come'";
		TypedQuery<Long> query = entityManager.createQuery(qStr,Long.class);
		query.setParameter("pstream", fdate);
		Long countStream = query.getSingleResult();
		
		String qStr1 = "SELECT COUNT(visitors) FROM Visitors visitors WHERE visitors.visit_date = :pstream AND visit_status ='gone'";
		TypedQuery<Long> query1 = entityManager.createQuery(qStr1,Long.class);
		query1.setParameter("pstream", fdate);
		Long countStream1 = query1.getSingleResult();
		
		return countStream-countStream1+"";
	}
	
	
	public Long getAllVisitorsCountBYCome() {
		// TODO Auto-generated method stub
		String qStr = "SELECT COUNT(visitors.visitor_seat_number) FROM Visitors visitors WHERE visit_status = 'come'";
		TypedQuery<Long> query = entityManager.createQuery(qStr,Long.class);
		Long count = query.getSingleResult();
		return count;
	}
	public List getAllVisitorsTimeBYCome() {
		EntityManager entityManager1 = JPAUtil.getEntityManager1();
		Query query4 = entityManager1.createQuery("SELECT visitors.time_spent FROM Visitors visitors WHERE time_spent IS NOT NULL");
		@SuppressWarnings("unchecked")
		List<Visitors> timeList = query4.getResultList();
		return timeList;
	}
	public Long getParticularVisitorCountBYCome(String seatNumber) {
		// TODO Auto-generated method stub
		String qStr = "SELECT COUNT(visitors.visitor_seat_number) FROM Visitors visitors WHERE visitor_seat_number = :pid AND visit_status = 'come'";
		TypedQuery<Long> query = entityManager.createQuery(qStr,Long.class);
		query.setParameter("pid", seatNumber);
		Long count = query.getSingleResult();
		return count;
	}
	public Long getParticularVisitorCountBYCome(String seatNumber,String date1 ,String date2) {
		// TODO Auto-generated method stub
		String qStr = "SELECT COUNT(visitors.visitor_seat_number) FROM Visitors visitors WHERE visitor_seat_number = :pid AND visit_status = 'come' AND visit_date BETWEEN :pdate1 AND :pdate2";
		TypedQuery<Long> query = entityManager.createQuery(qStr,Long.class);
		query.setParameter("pid", seatNumber).setParameter("pdate1", date1).setParameter("pdate2", date2);
		Long count = query.getSingleResult();
		return count;
	}
	
	@Override
	public void addVisitors(Visitors visitors) {
		// TODO Auto-generated method stub
		entityManager.getTransaction().begin();
		entityManager.persist(visitors); 
	    entityManager.getTransaction().commit();
	    entityManager.close();
	    entityManager = JPAUtil.getEntityManager(); 
	    entityManager.getTransaction().begin();
	    entityManager.getTransaction().commit();
	}
	
	@Override
	public Visitors findVisitorBySeatNumber(String seatNumber) {
		// TODO Auto-generated method stub
		Visitors visitor = entityManager.find(Visitors.class, seatNumber); 
	    return visitor;
	}
	
	@Override
	public List getAllVisitorsRollNumber() {
		// TODO Auto-generated method stub
		EntityManager entityManager1 = JPAUtil.getEntityManager1();
		Query query = entityManager1.createNamedQuery("getAllVisitorsRollNumber");
		@SuppressWarnings("unchecked")
		List<Visitors> countList = query.getResultList();
		return countList;
	}
	
	@Override
	public List getAllVisitorsName() {
		// TODO Auto-generated method stub
		EntityManager entityManager1 = JPAUtil.getEntityManager1();
		Query query = entityManager1.createNamedQuery("getAllVisitorsName");
		@SuppressWarnings("unchecked")
		List<Visitors> countList = query.getResultList();
		return countList;
	}
	
	@Override
	public List getAllVisitorsClass() {
		// TODO Auto-generated method stub
		EntityManager entityManager1 = JPAUtil.getEntityManager1();
		Query query = entityManager1.createNamedQuery("getAllVisitorsClass");
		@SuppressWarnings("unchecked")
		List<Visitors> countList = query.getResultList();
		return countList;
	}
	public List getAllVisitorsTimeSpent() {
		// TODO Auto-generated method stub
		EntityManager entityManager1 = JPAUtil.getEntityManager1();
		Query query = entityManager1.createNamedQuery("getAllVisitorsTimeSpent");
		@SuppressWarnings("unchecked")
		List<Visitors> countList = query.getResultList();
		return countList;
	}
	@Override
	public List getAllVisitorsStream() {
		// TODO Auto-generated method stub
		EntityManager entityManager1 = JPAUtil.getEntityManager1();
		Query query = entityManager1.createNamedQuery("getAllVisitorsStream");
		@SuppressWarnings("unchecked")
		List<Visitors> countList = query.getResultList();
		return countList;
	}
	
	@Override
	public List getAllVisitorsTime() {
		// TODO Auto-generated method stub
		Visitors visitors = new Visitors();
		EntityManager entityManager1 = JPAUtil.getEntityManager1();
		Query query = entityManager1.createNamedQuery("getAllVisitorsTime");
		@SuppressWarnings("unchecked")
		List<Visitors> countList = query.getResultList();
		return countList;
	}

	@Override
	public List getAllVisitorsDate() {
		// TODO Auto-generated method stub
		EntityManager entityManager1 = JPAUtil.getEntityManager1();
		Query query = entityManager1.createNamedQuery("getAllVisitorsDate");
		@SuppressWarnings("unchecked")
		List<Visitors> countList = query.getResultList();
		return countList;
	}
	
	@Override
	public List getAllVisitorsStatus() {
		// TODO Auto-generated method stub
		EntityManager entityManager1 = JPAUtil.getEntityManager1();
		Query query = entityManager1.createNamedQuery("getAllVisitorsStatus");
		@SuppressWarnings("unchecked")
		List<Visitors> countList = query.getResultList();
		return countList;
	}
	
	@Override
	public List getAllVisitorsSeatNumber() {
		// TODO Auto-generated method stub
		EntityManager entityManager1 = JPAUtil.getEntityManager1();
		Query query = entityManager1.createNamedQuery("getAllVisitorsSeatNumber");
		@SuppressWarnings("unchecked")
		List<Visitors> countList = query.getResultList();
		return countList;
	}

	@Override
	public List getAllVisitorsDivision() {
		// TODO Auto-generated method stub
		EntityManager entityManager1 = JPAUtil.getEntityManager1();
		Query query = entityManager1.createNamedQuery("getAllVisitorsDivision");
		@SuppressWarnings("unchecked")
		List<Visitors> countList = query.getResultList();
		return countList;
	}

	@Override
	public List getAllVisitorsLibraryCardValidUpto() {
		// TODO Auto-generated method stub
		EntityManager entityManager1 = JPAUtil.getEntityManager1();
		Query query = entityManager1.createNamedQuery("getAllVisitorsLibraryCardValidUpto");
		@SuppressWarnings("unchecked")
		List<Visitors> countList = query.getResultList();
		return countList;
	}
	
	
	public List getVisitorNameRecordBySeatNumber(String seatNumber) {
		EntityManager entityManager1 = JPAUtil.getEntityManager1();
		Query query = entityManager1.createQuery("SELECT visitors.visitor_name FROM Visitors visitors WHERE visitor_seat_number = :pid");
		query.setParameter("pid", seatNumber);
		@SuppressWarnings("unchecked")
		List<Visitors> dateList = query.getResultList();
		return dateList;
	}
	
	public List getVisitorStreamRecordBySeatNumber(String seatNumber) {
		EntityManager entityManager1 = JPAUtil.getEntityManager1();
		Query query = entityManager1.createQuery("SELECT visitors.visitor_stream FROM Visitors visitors WHERE visitor_seat_number = :pid");
		query.setParameter("pid", seatNumber);
		@SuppressWarnings("unchecked")
		List<Visitors> dateList = query.getResultList();
		return dateList;
	}
	
	public List getVisitorClassRecordBySeatNumber(String seatNumber) {
		EntityManager entityManager1 = JPAUtil.getEntityManager1();
		Query query = entityManager1.createQuery("SELECT visitors.visitor_class FROM Visitors visitors WHERE visitor_seat_number = :pid");
		query.setParameter("pid", seatNumber);
		@SuppressWarnings("unchecked")
		List<Visitors> dateList = query.getResultList();
		return dateList;
	}
	
	public List getVisitorDateRecordBySeatNumber(String seatNumber) {
		EntityManager entityManager1 = JPAUtil.getEntityManager1();
		Query query = entityManager1.createQuery("SELECT visitors.visit_date FROM Visitors visitors WHERE visitor_seat_number = :pid");
		query.setParameter("pid",seatNumber);
		@SuppressWarnings("unchecked")
		List<Visitors> dateList = query.getResultList();
		return dateList;
	}
	
	public List getVisitorTimeRecordBySeatNumber(String seatNumber) {
		EntityManager entityManager1 = JPAUtil.getEntityManager1();
		Query query2 = entityManager1.createQuery("SELECT visitors.visit_time FROM Visitors visitors WHERE visitor_seat_number = :pid");
		query2.setParameter("pid", seatNumber);
		@SuppressWarnings("unchecked")
		List<Visitors> timeList = query2.getResultList();
		return timeList;
	}
	public List getVisitorTimeRecordByDateSeatNumber(String seatNumber,String sdate) {
		EntityManager entityManager1 = JPAUtil.getEntityManager1();
		Query query2 = entityManager1.createQuery("SELECT visitors.visit_time FROM Visitors visitors WHERE visitor_seat_number = :pid AND visit_date = :pdate");
		query2.setParameter("pid", seatNumber).setParameter("pdate", sdate);
		@SuppressWarnings("unchecked")
		List<Visitors> timeList = query2.getResultList();
		return timeList;
	}
	public List getVisitorStatusRecordBySeatNumber(String seatNumber) {
		EntityManager entityManager1 = JPAUtil.getEntityManager1();
		Query query3 = entityManager1.createQuery("SELECT visitors.visit_status FROM Visitors visitors WHERE visitor_seat_number = :pid");
		query3.setParameter("pid", seatNumber);
		@SuppressWarnings("unchecked")
		List<Visitors> timeList = query3.getResultList();
		return timeList;
	}
	
	
	public List getVisitorTimeSpentRecordBySeatNumber(String seatNumber) {
		EntityManager entityManager1 = JPAUtil.getEntityManager1();
		Query query4 = entityManager1.createQuery("SELECT visitors.time_spent FROM Visitors visitors WHERE visitor_seat_number = :pid AND time_spent IS NOT NULL");
		query4.setParameter("pid", seatNumber);
		@SuppressWarnings("unchecked")
		List<Visitors> timeList = query4.getResultList();
		return timeList;
	}
	public List getVisitorTimeSpentRecordBySeatNumber(String seatNumber, String date1, String date2) {
		EntityManager entityManager1 = JPAUtil.getEntityManager1();
		Query query4 = entityManager1.createQuery("SELECT visitors.time_spent FROM Visitors visitors WHERE visitor_seat_number = :pid AND time_spent IS NOT NULL AND visit_date BETWEEN :pdate1 AND :pdate2");
		query4.setParameter("pid", seatNumber).setParameter("pdate1", date1).setParameter("pdate2", date2);
		@SuppressWarnings("unchecked")
		List<Visitors> timeList = query4.getResultList();
		return timeList;
	}
	public List getVisitorTimeSpentRecordBySeatNumberYear(String seatNumber,int year) {
		EntityManager entityManager1 = JPAUtil.getEntityManager1();
		Query query4 = entityManager1.createQuery("SELECT visitors.time_spent FROM Visitors visitors WHERE visitor_seat_number = :pid AND YEAR(visit_date) = :pyear AND time_spent IS NOT NULL");
		query4.setParameter("pid", seatNumber).setParameter("pyear", year);
		@SuppressWarnings("unchecked")
		List<Visitors> timeList = query4.getResultList();
		return timeList;
	}
	public List getVisitorTimeSpentRecordBySeatNumberYearMonth(String seatNumber,int year,String month) {
		EntityManager entityManager1 = JPAUtil.getEntityManager1();
		Query query4 = entityManager1.createQuery("SELECT visitors.time_spent FROM Visitors visitors WHERE visitor_seat_number = :pid AND YEAR(visit_date) = :pyear AND MONTHNAME(visit_date) = :pmonth AND time_spent IS NOT NULL");
		query4.setParameter("pid", seatNumber).setParameter("pyear", year).setParameter("pmonth", month);
		@SuppressWarnings("unchecked")
		List<Visitors> timeList = query4.getResultList();
		return timeList;
	}
	
	public List getStreams() {
		Visitors visitors = new Visitors();
		EntityManager entityManager1 = JPAUtil.getEntityManager1();
		Query query = entityManager1.createQuery("SELECT DISTINCT visitor_stream FROM Visitors visitors WHERE visit_status ='come'");
		@SuppressWarnings("unchecked")
		List<Visitors> streamList = query.getResultList();
		return streamList;
	}
	
	public List getGroupBY() {
		Visitors visitors = new Visitors();
		EntityManager entityManager1 = JPAUtil.getEntityManager1();
		Query query = entityManager1.createQuery("SELECT visitor_stream, COUNT(visitor_stream) FROM Visitors visitors WHERE visit_status ='come' GROUP BY visitor_stream");
		@SuppressWarnings("unchecked")
		List<Visitors> streamList = query.getResultList();
		return streamList;
	}
	public List getGroupBYDates(String fdate,String sdate) {
		Visitors visitors = new Visitors();
		EntityManager entityManager1 = JPAUtil.getEntityManager1();
		Query query = entityManager1.createQuery("SELECT visitor_stream, COUNT(visitor_stream) FROM Visitors visitors WHERE visit_status ='come' AND visit_date BETWEEN :fdate AND :sdate GROUP BY visitor_stream");
		query.setParameter("fdate", fdate).setParameter("sdate", sdate);
		@SuppressWarnings("unchecked")
		List<Visitors> streamList = query.getResultList();
		return streamList;
	}
	public List getRecordsGroupBYDates(String fdate,String sdate) {
		Visitors visitors = new Visitors();
		EntityManager entityManager1 = JPAUtil.getEntityManager1();
		Query query = entityManager1.createQuery("SELECT visitor_stream, visitor_class, COUNT(visitor_class),visitor_div FROM Visitors visitors WHERE visit_status ='come' AND visit_date BETWEEN :fdate AND :sdate GROUP BY visitor_stream, visitor_class, visitor_div");
		query.setParameter("fdate", fdate).setParameter("sdate", sdate);
		@SuppressWarnings("unchecked")
		List<Visitors> streamList = query.getResultList();
		return streamList;
	}
	public Long getStreamCountBystreams(String stream) {
		String qStr = "SELECT COUNT(visitors) FROM Visitors visitors WHERE visitors.visitor_stream = :pstream AND visit_status ='come'";
		TypedQuery<Long> query = entityManager.createQuery(qStr,Long.class);
		query.setParameter("pstream", stream);
		Long countStream = query.getSingleResult();
		return countStream;
	}
	
	public List getStudentMonthlyGrouply(String seatNumber) {
		Visitors visitors = new Visitors();
		EntityManager entityManager1 = JPAUtil.getEntityManager1();
		Query query = entityManager1.createQuery("SELECT YEAR(visit_date),COUNT(visitor_stream),MONTHNAME(visit_date),COUNT(visitor_stream) FROM Visitors visitors WHERE visitors.visitor_seat_number = :pseatNumber AND visit_status ='come' GROUP BY YEAR(visit_date),MONTHNAME(visit_date),visitor_stream,visitor_class,visitor_div");
		query.setParameter("pseatNumber", seatNumber);
		@SuppressWarnings("unchecked")
		List<Visitors> grouplylist = query.getResultList();
		return grouplylist;
	}
	public List getYearsStreamsGroupBY() {
		Visitors visitors = new Visitors();
		EntityManager entityManager1 = JPAUtil.getEntityManager1();
		Query query = entityManager1.createQuery("SELECT visitor_stream,YEAR(visit_date), COUNT(visitor_stream) FROM Visitors visitors WHERE visit_status ='come' GROUP BY YEAR(visit_date),visitor_stream");
		@SuppressWarnings("unchecked")
		List<Visitors> streamList = query.getResultList();
		return streamList;
	}
	public List getYearsMonthsStreamsGroupBY() {
		Visitors visitors = new Visitors();
		EntityManager entityManager1 = JPAUtil.getEntityManager1();
		Query query = entityManager1.createQuery("SELECT MONTHNAME(visit_date),YEAR(visit_date), COUNT(visitor_stream) FROM Visitors visitors WHERE visit_status ='come' GROUP BY YEAR(visit_date), MONTHNAME(visit_date) ORDER BY MONTH(visit_date)");
		@SuppressWarnings("unchecked")
		List<Visitors> streamList = query.getResultList();
		return streamList;
	}
	
	
	
	
	
	
	
	
	/*************************************************************************************************************************/
	public List getAllRecordGroupBY() {
		Visitors visitors = new Visitors();
		EntityManager entityManager1 = JPAUtil.getEntityManager1();
		Query query = entityManager1.createQuery("SELECT visit_date, COUNT(visitor_seat_number) FROM Visitors visitors WHERE visit_status ='come' GROUP BY visit_date ORDER BY visit_date");
		@SuppressWarnings("unchecked")
		List<Visitors> streamList = query.getResultList();
		return streamList;
	}
	public List getAllMonthsRecordGroupBY() {
		Visitors visitors = new Visitors();
		EntityManager entityManager1 = JPAUtil.getEntityManager1();
		Query query = entityManager1.createQuery("SELECT YEAR(visit_date),MONTHNAME(visit_date), COUNT(visitor_seat_number) FROM Visitors visitors WHERE visit_status ='come' GROUP BY YEAR(visit_date), MONTHNAME(visit_date) ORDER BY visit_date");
		@SuppressWarnings("unchecked")
		List<Visitors> streamList = query.getResultList();
		return streamList;
	}
	/*************************************************************************************************************************/
	/*************************************************************************************************************************/
	
	/*************************************************************************************************************************/
	/*************************************************************************************************************************/
	public List getAllDayWiseVisitorRecord(String seatNumber) {
		Visitors visitors = new Visitors();
		EntityManager entityManager1 = JPAUtil.getEntityManager1();
		Query query = entityManager1.createQuery("SELECT visit_date, COUNT(visitor_seat_number) FROM Visitors visitors WHERE visitors.visitor_seat_number = :pseatNumber AND visit_status ='come' GROUP BY visit_date ORDER BY visit_date");
		query.setParameter("pseatNumber", seatNumber);
		@SuppressWarnings("unchecked")
		List<Visitors> streamList = query.getResultList();
		return streamList;
	}
	public List getAllDayWiseVisitorRecord() {
		Visitors visitors = new Visitors();
		EntityManager entityManager1 = JPAUtil.getEntityManager1();
		Query query = entityManager1.createQuery("SELECT visit_date, COUNT(visitor_seat_number) FROM Visitors visitors WHERE visit_status ='come' GROUP BY visit_date ORDER BY visit_date");
		@SuppressWarnings("unchecked")
		List<Visitors> streamList = query.getResultList();
		return streamList;
	}
	public List getAllDayWiseVisitorRecord(String seatNumber, String datePicker, String datePicker1) {
		Visitors visitors = new Visitors();
		EntityManager entityManager1 = JPAUtil.getEntityManager1();
		Query query = entityManager1.createQuery("SELECT visit_date, COUNT(visitor_seat_number) FROM Visitors visitors WHERE visitors.visitor_seat_number = :pseatNumber AND visit_status ='come' AND visit_date BETWEEN :pdate1 AND :pdate2 GROUP BY visit_date ORDER BY visit_date");
		query.setParameter("pseatNumber", seatNumber).setParameter("pdate1", datePicker).setParameter("pdate2", datePicker1);
		@SuppressWarnings("unchecked")
		List<Visitors> streamList = query.getResultList();
		return streamList;
	}
	public List getAllDayWiseVisitorRecord(String datePicker, String datePicker1) {
		Visitors visitors = new Visitors();
		EntityManager entityManager1 = JPAUtil.getEntityManager1();
		Query query = entityManager1.createQuery("SELECT visit_date, COUNT(visitor_seat_number) FROM Visitors visitors WHERE visit_status ='come' AND visit_date BETWEEN :pdate1 AND :pdate2 GROUP BY visit_date ORDER BY visit_date");
		query.setParameter("pdate1", datePicker).setParameter("pdate2", datePicker1);
		@SuppressWarnings("unchecked")
		List<Visitors> streamList = query.getResultList();
		return streamList;
	}
	public List getAllMonthlyVisitorRecord() {
		Visitors visitors = new Visitors();
		EntityManager entityManager1 = JPAUtil.getEntityManager1();
		Query query = entityManager1.createQuery("SELECT YEAR(visit_date),MONTHNAME(visit_date), COUNT(visitor_seat_number) FROM Visitors visitors WHERE visit_status ='come' GROUP BY YEAR(visit_date), MONTHNAME(visit_date) ORDER BY visit_date");
		@SuppressWarnings("unchecked")
		List<Visitors> streamList = query.getResultList();
		return streamList;
	}
	public List getAllMonthlyVisitorRecord(String seatNumber) {
		Visitors visitors = new Visitors();
		EntityManager entityManager1 = JPAUtil.getEntityManager1();
		Query query = entityManager1.createQuery("SELECT YEAR(visit_date),MONTHNAME(visit_date), COUNT(visitor_seat_number) FROM Visitors visitors WHERE visitors.visitor_seat_number = :pseatNumber AND visit_status ='come' GROUP BY YEAR(visit_date), MONTHNAME(visit_date) ORDER BY visit_date");
		query.setParameter("pseatNumber", seatNumber);
		@SuppressWarnings("unchecked")
		List<Visitors> streamList = query.getResultList();
		return streamList;
	}
	public List getAllMonthlyVisitorRecord(String datePicker, String datePicker1) {
		Visitors visitors = new Visitors();
		EntityManager entityManager1 = JPAUtil.getEntityManager1();
		Query query = entityManager1.createQuery("SELECT YEAR(visit_date),MONTHNAME(visit_date), COUNT(visitor_seat_number) FROM Visitors visitors WHERE visit_status ='come' AND visit_date BETWEEN :pdate1 AND :pdate2 GROUP BY YEAR(visit_date), MONTHNAME(visit_date) ORDER BY visit_date");
		query.setParameter("pdate1", datePicker).setParameter("pdate2", datePicker1);
		@SuppressWarnings("unchecked")
		List<Visitors> streamList = query.getResultList();
		return streamList;
	}
	public List getAllMonthlyVisitorRecord(String seatNumber, String datePicker, String datePicker1) {
		Visitors visitors = new Visitors();
		EntityManager entityManager1 = JPAUtil.getEntityManager1();
		Query query = entityManager1.createQuery("SELECT YEAR(visit_date),MONTHNAME(visit_date), COUNT(visitor_seat_number) FROM Visitors visitors WHERE visitors.visitor_seat_number = :pseatNumber AND visit_status ='come' AND visit_date BETWEEN :pdate1 AND :pdate2 GROUP BY YEAR(visit_date), MONTHNAME(visit_date) ORDER BY visit_date");
		query.setParameter("pseatNumber", seatNumber).setParameter("pdate1", datePicker).setParameter("pdate2", datePicker1);
		@SuppressWarnings("unchecked")
		List<Visitors> streamList = query.getResultList();
		return streamList;
	}
	public List getCombinedMonthlyVisitorRecord() {
		Visitors visitors = new Visitors();
		EntityManager entityManager1 = JPAUtil.getEntityManager1();
		Query query = entityManager1.createQuery("SELECT MONTHNAME(visit_date), COUNT(visitor_seat_number) FROM Visitors visitors WHERE visit_status ='come' GROUP BY MONTHNAME(visit_date) ORDER BY visit_date");
		@SuppressWarnings("unchecked")
		List<Visitors> streamList = query.getResultList();
		return streamList;
	}
	public List getCombinedMonthlyVisitorRecord(String seatNumber) {
		Visitors visitors = new Visitors();
		EntityManager entityManager1 = JPAUtil.getEntityManager1();
		Query query = entityManager1.createQuery("SELECT MONTHNAME(visit_date), COUNT(visitor_seat_number) FROM Visitors visitors WHERE visitors.visitor_seat_number = :pseatNumber AND visit_status ='come' GROUP BY MONTHNAME(visit_date) ORDER BY visit_date");
		query.setParameter("pseatNumber", seatNumber);
		@SuppressWarnings("unchecked")
		List<Visitors> streamList = query.getResultList();
		return streamList;
	}
	public List getCombinedMonthlyVisitorRecord(String datePicker, String datePicker1) {
		Visitors visitors = new Visitors();
		EntityManager entityManager1 = JPAUtil.getEntityManager1();
		Query query = entityManager1.createQuery("SELECT MONTHNAME(visit_date), COUNT(visitor_seat_number) FROM Visitors visitors WHERE visit_status ='come' AND visit_date BETWEEN :pdate1 AND :pdate2 GROUP BY MONTHNAME(visit_date) ORDER BY visit_date");
		query.setParameter("pdate1", datePicker).setParameter("pdate2", datePicker1);
		@SuppressWarnings("unchecked")
		List<Visitors> streamList = query.getResultList();
		return streamList;
	}
	public List getCombinedMonthlyVisitorRecord(String seatNumber, String datePicker, String datePicker1) {
		Visitors visitors = new Visitors();
		EntityManager entityManager1 = JPAUtil.getEntityManager1();
		Query query = entityManager1.createQuery("SELECT MONTHNAME(visit_date), COUNT(visitor_seat_number) FROM Visitors visitors WHERE visitors.visitor_seat_number = :pseatNumber AND visit_status ='come' AND visit_date BETWEEN :pdate1 AND :pdate2 GROUP BY MONTHNAME(visit_date) ORDER BY visit_date");
		query.setParameter("pseatNumber", seatNumber).setParameter("pdate1", datePicker).setParameter("pdate2", datePicker1);
		@SuppressWarnings("unchecked")
		List<Visitors> streamList = query.getResultList();
		return streamList;
	}
	public List getStudentGrouply(String seatNumber, String datePicker, String datePicker1) {
		Visitors visitors = new Visitors();
		EntityManager entityManager1 = JPAUtil.getEntityManager1();
		Query query = entityManager1.createQuery("SELECT YEAR(visit_date),COUNT(visitor_stream) FROM Visitors visitors WHERE visitors.visitor_seat_number = :pseatNumber AND visit_status ='come' AND visit_date BETWEEN :pdate1 AND :pdate2 GROUP BY YEAR(visit_date) ORDER BY visit_date");
		query.setParameter("pseatNumber", seatNumber).setParameter("pdate1", datePicker).setParameter("pdate2", datePicker1);
		@SuppressWarnings("unchecked")
		List<Visitors> grouplylist = query.getResultList();
		return grouplylist;
	}
	public List getStudentGrouply(String datePicker, String datePicker1) {
		Visitors visitors = new Visitors();
		EntityManager entityManager1 = JPAUtil.getEntityManager1();
		Query query = entityManager1.createQuery("SELECT YEAR(visit_date),COUNT(visitor_stream) FROM Visitors visitors WHERE visit_status ='come' AND visit_date BETWEEN :pdate1 AND :pdate2 GROUP BY YEAR(visit_date) ORDER BY visit_date");
		query.setParameter("pdate1", datePicker).setParameter("pdate2", datePicker1);
		@SuppressWarnings("unchecked")
		List<Visitors> grouplylist = query.getResultList();
		return grouplylist;
	}
	public List getStudentGrouply(String seatNumber) {
		Visitors visitors = new Visitors();
		EntityManager entityManager1 = JPAUtil.getEntityManager1();
		Query query = entityManager1.createQuery("SELECT YEAR(visit_date),COUNT(visitor_stream) FROM Visitors visitors WHERE visitors.visitor_seat_number = :pseatNumber AND visit_status ='come' GROUP BY YEAR(visit_date) ORDER BY visit_date");
		query.setParameter("pseatNumber", seatNumber);
		@SuppressWarnings("unchecked")
		List<Visitors> grouplylist = query.getResultList();
		return grouplylist;
	}
	public List getStudentGrouply() {
		Visitors visitors = new Visitors();
		EntityManager entityManager1 = JPAUtil.getEntityManager1();
		Query query = entityManager1.createQuery("SELECT YEAR(visit_date),COUNT(visitor_stream) FROM Visitors visitors WHERE visit_status ='come' GROUP BY YEAR(visit_date) ORDER BY visit_date");
		@SuppressWarnings("unchecked")
		List<Visitors> grouplylist = query.getResultList();
		return grouplylist;
	}
	public List getStudentWeekly(String seatNumber, String datePicker, String datePicker1) {
		Visitors visitors = new Visitors();
		EntityManager entityManager1 = JPAUtil.getEntityManager1();
		Query query = entityManager1.createQuery("SELECT DAYNAME(visit_date), COUNT(visitor_seat_number) FROM Visitors visitors WHERE visitors.visitor_seat_number = :pseatNumber AND visit_status ='come' AND visit_date BETWEEN :pdate1 AND :pdate2 GROUP BY DAYNAME(visit_date) ORDER BY visit_date");
		query.setParameter("pseatNumber", seatNumber).setParameter("pdate1", datePicker).setParameter("pdate2", datePicker1);
		@SuppressWarnings("unchecked")
		List<Visitors> grouplylist = query.getResultList();
		return grouplylist;
	}
	public List getStudentWeekly(String datePicker, String datePicker1) {
		Visitors visitors = new Visitors();
		EntityManager entityManager1 = JPAUtil.getEntityManager1();
		Query query = entityManager1.createQuery("SELECT DAYNAME(visit_date), COUNT(visitor_seat_number) FROM Visitors visitors WHERE visit_status ='come' AND visit_date BETWEEN :pdate1 AND :pdate2 GROUP BY DAYNAME(visit_date) ORDER BY visit_date");
		query.setParameter("pdate1", datePicker).setParameter("pdate2", datePicker1);
		@SuppressWarnings("unchecked")
		List<Visitors> grouplylist = query.getResultList();
		return grouplylist;
	}
	public List getStudentWeekly() {
		Visitors visitors = new Visitors();
		EntityManager entityManager1 = JPAUtil.getEntityManager1();
		Query query = entityManager1.createQuery("SELECT DAYNAME(visit_date), COUNT(visitor_seat_number) FROM Visitors visitors WHERE visit_status ='come' GROUP BY DAYNAME(visit_date) ORDER BY visit_date");
		@SuppressWarnings("unchecked")
		List<Visitors> grouplylist = query.getResultList();
		return grouplylist;
	}
	public List getStudentWeekly(String seatNumber) {
		Visitors visitors = new Visitors();
		EntityManager entityManager1 = JPAUtil.getEntityManager1();
		Query query = entityManager1.createQuery("SELECT DAYNAME(visit_date), COUNT(visitor_seat_number) FROM Visitors visitors WHERE visitors.visitor_seat_number = :pseatNumber AND visit_status ='come' GROUP BY DAYNAME(visit_date) ORDER BY visit_date");
		query.setParameter("pseatNumber", seatNumber);
		@SuppressWarnings("unchecked")
		List<Visitors> grouplylist = query.getResultList();
		return grouplylist;
	}
	public List getStudentMonthly(String seatNumber) {
		Visitors visitors = new Visitors();
		EntityManager entityManager1 = JPAUtil.getEntityManager1();
		Query query = entityManager1.createQuery("SELECT MONTHNAME(visit_date), COUNT(visitor_seat_number) FROM Visitors visitors WHERE visitors.visitor_seat_number = :pseatNumber AND visit_status ='come' GROUP BY MONTHNAME(visit_date) ORDER BY visit_date");
		query.setParameter("pseatNumber", seatNumber);
		@SuppressWarnings("unchecked")
		List<Visitors> grouplylist = query.getResultList();
		return grouplylist;
	}
	public List getStudentHourly(String seatNumber, String datePicker, String datePicker1) {
		Visitors visitors = new Visitors();
		EntityManager entityManager1 = JPAUtil.getEntityManager1();
		Query query = entityManager1.createQuery("SELECT HOUR(visit_time), COUNT(visitor_seat_number) FROM Visitors visitors WHERE visitors.visitor_seat_number = :pseatNumber AND visit_status ='come' AND visit_date BETWEEN :pdate1 AND :pdate2 GROUP BY HOUR(visit_time) ORDER BY visit_time");
		query.setParameter("pseatNumber", seatNumber).setParameter("pdate1", datePicker).setParameter("pdate2", datePicker1);
		@SuppressWarnings("unchecked")
		List<Visitors> grouplylist = query.getResultList();
		return grouplylist;
	}
	public List getStudentHourly(String datePicker, String datePicker1) {
		Visitors visitors = new Visitors();
		EntityManager entityManager1 = JPAUtil.getEntityManager1();
		Query query = entityManager1.createQuery("SELECT HOUR(visit_time), COUNT(visitor_seat_number) FROM Visitors visitors WHERE visit_status ='come' AND visit_date BETWEEN :pdate1 AND :pdate2 GROUP BY HOUR(visit_time) ORDER BY visit_time");
		query.setParameter("pdate1", datePicker).setParameter("pdate2", datePicker1);
		@SuppressWarnings("unchecked")
		List<Visitors> grouplylist = query.getResultList();
		return grouplylist;
	}
	public List getStudentHourly() {
		Visitors visitors = new Visitors();
		EntityManager entityManager1 = JPAUtil.getEntityManager1();
		Query query = entityManager1.createQuery("SELECT HOUR(visit_time), COUNT(visitor_seat_number) FROM Visitors visitors WHERE visit_status ='come' GROUP BY HOUR(visit_time) ORDER BY visit_time");
		@SuppressWarnings("unchecked")
		List<Visitors> grouplylist = query.getResultList();
		return grouplylist;
	}
	public List getStudentHourly(String seatNumber) {
		Visitors visitors = new Visitors();
		EntityManager entityManager1 = JPAUtil.getEntityManager1();
		Query query = entityManager1.createQuery("SELECT HOUR(visit_time), COUNT(visitor_seat_number) FROM Visitors visitors WHERE visitors.visitor_seat_number = :pseatNumber AND visit_status ='come' GROUP BY HOUR(visit_time) ORDER BY visit_time");
		query.setParameter("pseatNumber", seatNumber);
		@SuppressWarnings("unchecked")
		List<Visitors> grouplylist = query.getResultList();
		return grouplylist;
	}
	public List getAllTimelyVisitorRecord(String seatNumber, String datePicker, String datePicker1) {
		Visitors visitors = new Visitors();
		EntityManager entityManager1 = JPAUtil.getEntityManager1();
		Query query = entityManager1.createQuery("SELECT visit_date, visit_time, HOUR(visit_time) FROM Visitors visitors WHERE visitors.visitor_seat_number = :pseatNumber AND visit_status ='come' AND visit_date BETWEEN :pdate1 AND :pdate2 GROUP BY visit_date, visit_time ORDER BY visit_date, visit_time");
		query.setParameter("pseatNumber", seatNumber).setParameter("pdate1", datePicker).setParameter("pdate2", datePicker1);
		@SuppressWarnings("unchecked")
		List<Visitors> streamList = query.getResultList();
		return streamList;
	}
	public List getAllTimelyVisitorRecord(String datePicker, String datePicker1) {
		Visitors visitors = new Visitors();
		EntityManager entityManager1 = JPAUtil.getEntityManager1();
		Query query = entityManager1.createQuery("SELECT visit_date, visit_time, HOUR(visit_time) FROM Visitors visitors WHERE visit_status ='come' AND visit_date BETWEEN :pdate1 AND :pdate2 GROUP BY visit_date, visit_time ORDER BY visit_date, visit_time");
		query.setParameter("pdate1", datePicker).setParameter("pdate2", datePicker1);
		@SuppressWarnings("unchecked")
		List<Visitors> streamList = query.getResultList();
		return streamList;
	}
	public List getAllTimelyVisitorRecord(String seatNumber) {
		Visitors visitors = new Visitors();
		EntityManager entityManager1 = JPAUtil.getEntityManager1();
		Query query = entityManager1.createQuery("SELECT visit_date, visit_time, HOUR(visit_time) FROM Visitors visitors WHERE visitors.visitor_seat_number = :pseatNumber AND visit_status ='come' GROUP BY visit_date, visit_time ORDER BY visit_date, visit_time");
		query.setParameter("pseatNumber", seatNumber);
		@SuppressWarnings("unchecked")
		List<Visitors> streamList = query.getResultList();
		return streamList;
	}
	public List getAllTimelyVisitorRecord() {
		Visitors visitors = new Visitors();
		EntityManager entityManager1 = JPAUtil.getEntityManager1();
		Query query = entityManager1.createQuery("SELECT visit_date, visit_time, HOUR(visit_time) FROM Visitors visitors WHERE visit_status ='come' GROUP BY visit_date, visit_time ORDER BY visit_date, visit_time");
		@SuppressWarnings("unchecked")
		List<Visitors> streamList = query.getResultList();
		return streamList;
	}
	public Long getAllVisitorsCountBYComeDate(String datePicker, String datePicker1) {
		// TODO Auto-generated method stub
		String qStr = "SELECT COUNT(visitors.visitor_seat_number) FROM Visitors visitors WHERE visit_status = 'come' AND visit_date BETWEEN :pdate1 AND :pdate2";
		TypedQuery<Long> query = entityManager.createQuery(qStr,Long.class);
		query.setParameter("pdate1", datePicker).setParameter("pdate2", datePicker1);
		Long count = query.getSingleResult();
		return count;
	}
	public List getAllVisitorsTimeBYComeDate(String datePicker, String datePicker1) {
		EntityManager entityManager1 = JPAUtil.getEntityManager1();
		Query query4 = entityManager1.createQuery("SELECT visitors.time_spent FROM Visitors visitors WHERE time_spent IS NOT NULL AND visit_date BETWEEN :pdate1 AND :pdate2");
		query4.setParameter("pdate1", datePicker).setParameter("pdate2", datePicker1);
		@SuppressWarnings("unchecked")
		List<Visitors> timeList = query4.getResultList();
		return timeList;
	}
	public List getAllDayTimelyVisitorRecord(String seatNumber, String datePicker, String datePicker1) {
		Visitors visitors = new Visitors();
		EntityManager entityManager1 = JPAUtil.getEntityManager1();
		Query query = entityManager1.createQuery("SELECT visit_date, HOUR(visit_time), COUNT(visitor_seat_number) FROM Visitors visitors WHERE visitors.visitor_seat_number = :pseatNumber AND visit_status ='come' AND visit_date BETWEEN :pdate1 AND :pdate2 GROUP BY visit_time ORDER BY visit_date, visit_time");
		query.setParameter("pseatNumber", seatNumber).setParameter("pdate1", datePicker).setParameter("pdate2", datePicker1);
		@SuppressWarnings("unchecked")
		List<Visitors> streamList = query.getResultList();
		return streamList;
	}
	public List getAllDayTimelyVisitorRecord(String seatNumber) {
		Visitors visitors = new Visitors();
		EntityManager entityManager1 = JPAUtil.getEntityManager1();
		Query query = entityManager1.createQuery("SELECT visit_date, HOUR(visit_time), COUNT(visitor_seat_number) FROM Visitors visitors WHERE visitors.visitor_seat_number = :pseatNumber AND visit_status ='come' GROUP BY visit_time ORDER BY visit_date, visit_time");
		query.setParameter("pseatNumber", seatNumber);
		@SuppressWarnings("unchecked")
		List<Visitors> streamList = query.getResultList();
		return streamList;
	}
	
	public List getInOut1() {
		Visitors visitors = new Visitors();
		EntityManager entityManager1 = JPAUtil.getEntityManager1();
		Query query = entityManager1.createQuery("SELECT visit_date FROM Visitors visitors WHERE visit_status ='come'");
//		query.setParameter("pseatNumber", seatNumber);
		@SuppressWarnings("unchecked")
		List<Visitors> streamList = query.getResultList();
		return streamList;
	}
	/*************************************************************************************************************************/
//	public List getYearsMonthsStreamsGroupBY() {
//		Visitors visitors = new Visitors();
//		EntityManager entityManager1 = JPAUtil.getEntityManager1();
//		Query query = entityManager1.createQuery("SELECT DATE(visit_date),MONTHNAME(visit_date), COUNT(visitor_stream) FROM Visitors visitors WHERE visit_status ='come' GROUP BY DATE(visit_date) ORDER BY DATE(visit_date)");
//		@SuppressWarnings("unchecked")
//		List<Visitors> streamList = query.getResultList();
//		return streamList;
//	}
	
}