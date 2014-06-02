package hibernate.example.app;

import hibernate.example.domain.Event;
import hibernate.example.util.HibernateUtil;

import java.util.*;

import org.hibernate.Session;

public class EventManager {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		EventManager mgr = new EventManager();

        if (args[0].equals("store")) {
            mgr.createAndStoreEvent("My Event", new Date());
        }

        HibernateUtil.getSessionFactory().close();

	}

	
	private void createAndStoreEvent(String title, Date theDate) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();

        Event theEvent = new Event();
        theEvent.setTitle(title);
        theEvent.setDate(theDate);
        session.save(theEvent);

        session.getTransaction().commit();
    }
}
