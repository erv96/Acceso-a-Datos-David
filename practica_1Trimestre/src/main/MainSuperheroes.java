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

		byte opcion = -1;
		do {
			System.out.println(
					"Bienvenid@, en este programa podrás almacenar en una BBDD editoriales y superheroes que pertenezcan a ellas.");
			System.out.println("Elige lo que deseas hacer: " + "\n\t1 - Insertar Editorial"
					+ "\n\t2 - Insertar Superheroe" + "\n\t3 - Mostrar Editoriales" + "\n\t4 - Mostrar Superheroes"
					+ "\n\t5 - Borrar una editorial (si borras la editorial los superheores que haya en ella también desaparecerán)"
					+ "\n\t6 - Borrar un superheroe" + "\n\t7 - Modificar una Editorial"
					+ "\n\t8 - Modificar un Superheroe" + "\n\t9 - Borrar todos los superheroes"
					+ "\n\t10 - Borrar todas las editoriales"
					+ "\n\t11 - Resetear BBDD (Se borrarán todos los registros y el ID volverá a 0)"
					+ "\n\t12 - Salir");
			opcion = Byte.parseByte(sc.nextLine());

			switch (opcion) {
			case 1:
				Editorial editorial = new Editorial("Marvel", "Stan Lee", Date.valueOf("1939-09-22"));
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
					byte opcionEd = -1;
					do {
						for (byte i = 0; i < editoriales.size(); i++) {
							System.out.println("\t" + i + " - " + editoriales.get(i).getNombre());
						}
						opcionEd = Byte.parseByte(sc.nextLine());

					} while (opcionEd > editoriales.size() - 1 || opcionEd <= -1);

					Superheroe superhero = new Superheroe("Spiderman", "Peter Parker", "Poderes aracnidos",
							(short) 1977, editoriales.get(opcionEd));
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

					mostrarEditoriales.get(opcionModificar).setNombre("Editorial Modificada");
					mostrarEditoriales.get(opcionModificar).setFundador_fundadores("Fundador modificado");
					mostrarEditoriales.get(opcionModificar).setFecha_fundacion(Date.valueOf("2022-12-16"));

					funciones.modificar(mostrarEditoriales.get(opcionModificar));

					System.out.println("Editorial modificada correctamente");
					break;
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

					mostrarHeros.get(opcionSuper).setNombre("Superheroe modificado");
					mostrarHeros.get(opcionSuper).setIdentidad_secreta("Yo");
					mostrarHeros.get(opcionSuper).setPoderes("Poderes modificado");
					mostrarHeros.get(opcionSuper).setAño_primera_aparicion((short) 1999);

					funcionesHeroe.modificar(mostrarHeros.get(opcionSuper));
					break;
				}
			case 9:
				mostrarHeros = new ArrayList<Superheroe>();
				funcionesHeroe = new SuperheroeDao();
				mostrarHeros = funcionesHeroe.buscarTodos();
				if (mostrarHeros.isEmpty()) {
					System.out.println(
							"\nTodavía no hay ningun superheroe en la base de datos, debes introducir uno primero\n");
					break;
				} else {
					System.out.println("Borrando todos los superheroes...");
					funcionesHeroe = new SuperheroeDao();
					funcionesHeroe.borrarTodos();
					break;
				}

			case 10:
				funciones = new EditorialDao();
				mostrarEditoriales = funciones.buscarTodos();
				if (mostrarEditoriales.isEmpty()) {
					System.out.println(
							"\nTodavía no hay ninguna editorial en la base de datos, debes introducir una primero\n");
					break;
				} else {
					System.out.println("Borrando todas las editoriales...");
					funciones = new EditorialDao();
					funciones.borrarTodos();
					break;
				}

			case 11:
				System.out.println("Borrando todos los datos de la BBDD");
				SuperheroeDao truncate = new SuperheroeDao();
				EditorialDao truncateEd = new EditorialDao();
				truncate.truncateSuperheroe();
				truncateEd.truncateEditoriales();
				break;
			}

		} while (opcion != 12);

		System.out.println("Saliendo...");

	}

}
