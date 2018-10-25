package dao;

import model.Reservation;

public class ReservationDAO extends GenericDAO<Reservation> {

	private static ReservationDAO dao;
	
	public ReservationDAO() {
		super(Reservation.class);
	}
	
	public static ReservationDAO instance() {
		if(dao==null) {
			return dao=new ReservationDAO();
		}
		return dao;
	}

}
