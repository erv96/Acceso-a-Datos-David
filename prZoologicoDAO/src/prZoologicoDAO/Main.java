package prZoologicoDAO;

public class Main {

	public static void main(String[] args) {
		
		Animal a = new Animal("Ardilla", 0.1, "Bosque");
		//AnimalDAO.insertAnimal(a);
		//AnimalDAO.deleteAllAnimales();
		//AnimalDAO.deleteAnimalByNombre("Ardilla");
		Animal b = AnimalDAO.findById(6);
		System.out.println(b);
		
		
		

	}

}
