package main;

import java.math.BigDecimal;
import java.util.Iterator;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;

import pojo.Animal;
import util.HibernateUtil;

public class Main {

	public static void main(String[] args) {

		// EN CONSOLA SALE MUCHO TEXTO EN ROJO, NO SON ERRORES SOLO SON ADVERTENCIAS E
		// INFORMACIÓN DEL PROCESO
		Session session = HibernateUtil.getSessionFactory().openSession();

		/*Animal a1 = new Animal("Yorkshire", "Casa", new BigDecimal(1));

		session.save(a1);*/
		
		/*int id = 8;
		
		Animal a = (Animal) session.get(Animal.class, id);
		
		System.out.println(a.getNombre());*/
		
		/*Animal a1 = new Animal("Kuokka","Jungla",new BigDecimal(2));
		session.save(a1);*/
		
		
		//EN LA QUERY SE PONE EL FROM Y EL NOMBRE DEL POJO, EN ESTE CASO ES ANIMAL
		String hql = "FROM Animal WHERE habitat = :habitat";
		Query query = session.createQuery(hql);
		query.setParameter("habitat", "españita");
		//List animales = session.createQuery(hql).getResultList();
		List animales = query.getResultList();
		for(Iterator i = animales.iterator(); i.hasNext(); ) {
			Animal a = (Animal) i.next();
			System.out.println(a.getNombre());
		}
		
		
			
		session.close();
	}

}
