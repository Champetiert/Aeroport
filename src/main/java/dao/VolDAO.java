package dao;

import model.Vol;

public class VolDAO extends GenericDAO<Vol> {

	
	private static VolDAO dao;
	
	public VolDAO() {
		super(Vol.class);
	}
	
	public static VolDAO instance() {
		if(dao==null) {
			return dao=new VolDAO();
		}
		return dao;
	}

}
