package dao;

import model.Person;

public class PersonDAO extends GenericDAO<Person> {

	private static PersonDAO dao;
	
	public PersonDAO() {
		super(Person.class);
	}
	
	public static PersonDAO instance() {
		if(dao==null) {
			return dao=new PersonDAO();
		}
		return dao;
	}

}
