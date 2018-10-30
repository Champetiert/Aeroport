package main;

import java.time.LocalDate;
import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import dao.PersonDAO;
import dao.ReservationDAO;
import dao.VolDAO;
import model.TypeAvion;
import model.Vol;

public class Main {

	private final Logger logger = LoggerFactory.getLogger(Main.class);

	public static void main(String[] args) {
		Main main = new Main();
		main.run();

	}

	public void run() {
		logger.info("main start");
		VolDAO voldao = VolDAO.instance();
		PersonDAO personDAO = PersonDAO.instance();
		ReservationDAO reservationDAO = ReservationDAO.instance();

		Vol v1 = new Vol("0001", TypeAvion.A380, 600, "Montpellier", "Paris", LocalDate.of(2018, 10, 30),
				new ArrayList<>());
		Vol v2 = new Vol("0001", TypeAvion.A330, 208, "Marseille", "Paris", LocalDate.of(2018, 10, 28),
				new ArrayList<>());

		v1 = voldao.persist(v1);
		voldao.persist(v2);
		System.out.println(voldao.findAll());
		v2.setVilleArrivee("Montreal");
		voldao.merge(v2);
		System.out.println(voldao.find(2));
		v1 = voldao.merge(v1);
		voldao.remove(v1);
		System.out.println(voldao.findAll());
		logger.info("main end");
	}

}
