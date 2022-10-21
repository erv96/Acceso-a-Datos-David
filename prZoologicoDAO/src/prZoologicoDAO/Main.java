package prZoologicoDAO;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {

		// Animal a = new Animal("Expertosaurio", 269.43, "Prime Enterprise");
		// AnimalDAO.insertAnimal(a);
		// AnimalDAO.deleteAllAnimales();
		// AnimalDAO.deleteAnimalByNombre("Ardilla");
		Animal b = AnimalDAO.findById(6);
		// System.out.println(b);
		/*ArrayList<Animal> lista = AnimalDAO.findAllAnimales();

		for (byte i = 0; i < lista.size(); i++) {
			System.out.println(lista.get(i));
		}*/
		
		b.setPeso_aproximado(700);
		b.setNombre("ExpertoSaurio V2");
		AnimalDAO.updateAnimal(b);
		System.out.println(b);

	}

}
