package prZoologicoDAO;

public class Main {

	public static void main(String[] args) {
		
		Animal a = new Animal("Ardilla", 0.1, "Bosque");
		AnimalDAO.insertAnimal(a);

	}

}
