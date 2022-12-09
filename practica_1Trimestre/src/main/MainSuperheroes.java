package main;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import dao.EditorialDao;
import dao.SuperheroeDao;
import pojo.Editorial;
import pojo.Superheroe;

public class MainSuperheroes {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		SuperheroeDao truncate = new SuperheroeDao();
		EditorialDao truncateEd = new EditorialDao();
		truncate.truncateSuperheroe();
		truncateEd.truncateEditoriales();

		byte opcion = -1;
		do {
			System.out.println(
					"Bienvenid@, en este programa podrás almacenar en una BBDD editoriales y superheroes que pertenezcan a ellas.");
			System.out.println("Elige lo que deseas hacer: " + "\n\t1 - Insertar Editorial"
					+ "\n\t2 - Insertar Superheroe" + "\n\t3 - Mostrar Editoriales" + "\n\t4 - Mostrar Superheroes"
					+ "\n\t5 - Borrar una editorial (si borras la editorial los superheores que haya en ella también desaparecerán)"
					+ "\n\t6 - Borrar un superheroe" + "\n\t7 - Modificar una Editorial"
					+ "\n\t8 - Modificar un Superheroe" + "\n\t9 - Borrar todos los superheroes" + "\n\t10 - Salir");
			opcion = Byte.parseByte(sc.nextLine());

			switch (opcion) {
			case 1:
				System.out.println("Inserta el nombre de la editorial");
				String nombre = sc.nextLine();
				System.out.println("Inserta su fundador o fundadora");
				String fundador = sc.nextLine();
				System.out.println("Inserta la fecha de su fundación en el siguiente formato YYYY-MM-DD");
				String fecha = sc.nextLine();
				Date fechita = Date.valueOf(fecha);

				Editorial editorial = new Editorial(nombre, fundador, fechita);
				EditorialDao funciones = new EditorialDao();
				funciones.insertar(editorial);
				System.out.println("Tu editorial se ha insertado correctamente");
				break;
			case 2:
				ArrayList<Editorial> editoriales = new ArrayList<Editorial>();
				SuperheroeDao funcionesHeroe = new SuperheroeDao();
				funciones = new EditorialDao();
				editoriales = funciones.buscarTodos();

				if (editoriales.isEmpty()) {
					System.out.println(
							"\nTodavía no hay ninguna editorial en la base de datos, debes introducir una primero\n");
					break;
				} else {
					System.out.println("Inserta el nombre del superheroe");
					String nombreSuper = sc.nextLine();
					System.out.println("Inserta su identidad secreta");
					String identidad = sc.nextLine();
					System.out.println("Inserta sus poderes");
					String poderes = sc.nextLine();
					System.out.println("Inserta el año de su primera aparición");
					Short año = Short.parseShort(sc.nextLine());
					System.out.println("Elige la editorial a la que pertenece tu superheroe:");
					byte opcionEd = -1;
					do {
						for (byte i = 0; i < editoriales.size(); i++) {
							System.out.println("\t" + i + " - " + editoriales.get(i).getNombre());
						}
						opcionEd = Byte.parseByte(sc.nextLine());

					} while (opcionEd > editoriales.size() - 1 || opcionEd <= -1);

					Superheroe superhero = new Superheroe(nombreSuper, identidad, poderes, (short) año,
							editoriales.get(opcionEd));
					funcionesHeroe.insertar(superhero);
				}
				System.out.println("Tu superheroe se ha introducido correctamente");
				break;

			case 3:
				ArrayList<Editorial> mostrarEditoriales = new ArrayList<Editorial>();
				funciones = new EditorialDao();
				mostrarEditoriales = funciones.buscarTodos();

				if (mostrarEditoriales.isEmpty()) {
					System.out.println("\nNo se ha encontrado a ninguna editorial en la BBDD\n");

				} else {
					for (Editorial editorial2 : mostrarEditoriales) {
						System.out.println(editorial2);
					}
				}

				break;
			case 4:
				ArrayList<Superheroe> mostrarHeros = new ArrayList<Superheroe>();
				funcionesHeroe = new SuperheroeDao();
				mostrarHeros = funcionesHeroe.buscarTodos();

				if (mostrarHeros.isEmpty()) {
					System.out.println("\nNo se ha encontrado a ningún superheroe en la BBDD\n");
					break;
				} else {
					for (Superheroe superheroe : mostrarHeros) {
						System.out.println(superheroe);
					}
				}
				break;

			case 5:
				funciones = new EditorialDao();
				mostrarEditoriales = funciones.buscarTodos();

				if (mostrarEditoriales.isEmpty()) {
					System.out.println(
							"\nTodavía no hay ninguna editorial en la base de datos, debes introducir una primero\n");
					break;
				} else {
					System.out.println("Elige la editorial que deseas borrar:");

					byte opcionBorrar = -1;
					do {
						for (byte i = 0; i < mostrarEditoriales.size(); i++) {
							System.out.println("\t" + i + " - " + mostrarEditoriales.get(i).getNombre());
						}
						opcionBorrar = Byte.parseByte(sc.nextLine());

					} while (opcionBorrar > mostrarEditoriales.size() - 1 || opcionBorrar <= -1);

					funciones.borrar(mostrarEditoriales.get(opcionBorrar));
				}

				break;

			case 6:
				funcionesHeroe = new SuperheroeDao();
				mostrarHeros = funcionesHeroe.buscarTodos();

				if (mostrarHeros.isEmpty()) {
					System.out.println(
							"\nTodavía no hay ningun superheroe en la base de datos, debes introducir uno primero\n");
					break;
				} else {
					System.out.println("Elige el superheroe que deseas borrar:");

					byte opcionBorrar = -1;
					do {
						for (byte i = 0; i < mostrarHeros.size(); i++) {
							System.out.println("\t" + i + " - " + mostrarHeros.get(i).getNombre());
						}
						opcionBorrar = Byte.parseByte(sc.nextLine());

					} while (opcionBorrar > mostrarHeros.size() - 1 || opcionBorrar <= -1);

					funcionesHeroe.borrar(mostrarHeros.get(opcionBorrar));
				}

				break;
			case 7:
				funciones = new EditorialDao();
				mostrarEditoriales = funciones.buscarTodos();
				if (mostrarEditoriales.isEmpty()) {
					System.out.println(
							"\nTodavía no hay ninguna editorial en la base de datos, debes introducir una primero\n");
					break;
				} else {
					System.out.println("Elige la editorial que deseas modificar:");
					byte opcionModificar = -1;

					do {
						for (byte i = 0; i < mostrarEditoriales.size(); i++) {
							System.out.println("\t" + i + " - " + mostrarEditoriales.get(i).getNombre());
						}
						opcionModificar = Byte.parseByte(sc.nextLine());

					} while (opcionModificar > mostrarEditoriales.size() - 1 || opcionModificar <= -1);

					byte opcionNombre = -1;

					do {
						System.out.println("¿Quieres modificar su nombre?\n" + "1 - Si" + "\n2 - No");
						opcionNombre = Byte.parseByte(sc.nextLine());
					} while (opcionNombre != 1 && opcionNombre != 2);

					if (opcionNombre == 1) {
						System.out.println("Introduce el nuevo nombre de la editorial: ");
						String nuevoNombre = sc.nextLine();
						mostrarEditoriales.get(opcionModificar).setNombre(nuevoNombre);
						funciones.modificar(mostrarEditoriales.get(opcionModificar));
					} else {
						System.out.println("El nombre no se modificará");
					}

					do {
						System.out.println("¿Quieres modificar su fundador/a?\n" + "1 - Si" + "\n2 - No");
						opcionNombre = Byte.parseByte(sc.nextLine());
					} while (opcionNombre != 1 && opcionNombre != 2);

					if (opcionNombre == 1) {
						System.out.println("Introduce el nuevo nombre de el/la fundadora/a: ");
						String nuevoFundador = sc.nextLine();
						mostrarEditoriales.get(opcionModificar).setFundador_fundadores(nuevoFundador);
						;
						funciones.modificar(mostrarEditoriales.get(opcionModificar));
					} else {
						System.out.println("El fundador/a no se modificará");
					}

					do {
						System.out.println("¿Quieres modificar su fecha de fundación?\n" + "1 - Si" + "\n2 - No");
						opcionNombre = Byte.parseByte(sc.nextLine());
					} while (opcionNombre != 1 && opcionNombre != 2);

					if (opcionNombre == 1) {
						System.out.println("Introduce la nueva fecha: ");
						String nuevoFecha = sc.nextLine();
						Date fechitaMod = Date.valueOf(nuevoFecha);
						mostrarEditoriales.get(opcionModificar).setFecha_fundacion(fechitaMod);
						funciones.modificar(mostrarEditoriales.get(opcionModificar));
					} else {
						System.out.println("La fecha no se modificará");
					}

					System.out.println("Editorial modificada correctamente");

				}

			case 8:
				funcionesHeroe = new SuperheroeDao();
				mostrarHeros = funcionesHeroe.buscarTodos();
				if (mostrarHeros.isEmpty()) {
					System.out.println(
							"\nTodavía no hay ningun superheroe en la base de datos, debes introducir uno primero\n");
					break;
				} else {
					System.out.println("Elige el superheroe que deseas modificar:");
					byte opcionSuper = -1;
					do {
						for (byte i = 0; i < mostrarHeros.size(); i++) {
							System.out.println("\t" + i + " - " + mostrarHeros.get(i).getNombre());
						}
						opcionSuper = Byte.parseByte(sc.nextLine());

					} while (opcionSuper > mostrarHeros.size() - 1 || opcionSuper <= -1);

					byte opcionNombre = -1;
					do {
						System.out.println("¿Quieres modificar su nombre?\n" + "1 - Si" + "\n2 - No");
						opcionNombre = Byte.parseByte(sc.nextLine());

					} while (opcionNombre != 1 && opcionNombre != 2);

					if (opcionNombre == 1) {
						System.out.println("Introduce el nuevo nombre del superheroe:");
						String nombreHero = sc.nextLine();
						mostrarHeros.get(opcionSuper).setNombre(nombreHero);
						funcionesHeroe.modificar(mostrarHeros.get(opcionSuper));
					} else {
						System.out.println("El nombre no se cambiará");
					}

					do {
						System.out.println("¿Quieres modificar su identidad?\n" + "1 - Si" + "\n2 - No");
						opcionNombre = Byte.parseByte(sc.nextLine());

					} while (opcionNombre != 1 && opcionNombre != 2);

					if (opcionNombre == 1) {
						System.out.println("Introduce la nueva identidad del superheroe:");
						String nombreIdentidad = sc.nextLine();
						mostrarHeros.get(opcionSuper).setIdentidad_secreta(nombreIdentidad);
						funcionesHeroe.modificar(mostrarHeros.get(opcionSuper));
					} else {
						System.out.println("La identidad no se cambiará");
					}

					do {
						System.out.println("¿Quieres modificar sus poderes?\n" + "1 - Si" + "\n2 - No");
						opcionNombre = Byte.parseByte(sc.nextLine());

					} while (opcionNombre != 1 && opcionNombre != 2);

					if (opcionNombre == 1) {
						System.out.println("Introduce los nuevos poderes del superheroe:");
						String poderes = sc.nextLine();
						mostrarHeros.get(opcionSuper).setPoderes(poderes);
						funcionesHeroe.modificar(mostrarHeros.get(opcionSuper));
					} else {
						System.out.println("Los poderes no se cambiarán");
					}

					do {
						System.out.println("¿Quieres modificar su fecha de aparición?\n" + "1 - Si" + "\n2 - No");
						opcionNombre = Byte.parseByte(sc.nextLine());

					} while (opcionNombre != 1 && opcionNombre != 2);

					if (opcionNombre == 1) {
						System.out.println("Introduce la nueva fecha:");
						Short primeraAp = Short.parseShort(sc.nextLine());
						mostrarHeros.get(opcionSuper).setAño_primera_aparicion(primeraAp);
						funcionesHeroe.modificar(mostrarHeros.get(opcionSuper));
					} else {
						System.out.println("La fecha no se cambiará");
					}

				}
			case 9:
				System.out.println("Borrando todos los superheroes...");
				funcionesHeroe = new SuperheroeDao();
				funcionesHeroe.borrarTodos();

			}

		} while (opcion != 10);
		
		System.out.println("Saliendo...");

	}

}
