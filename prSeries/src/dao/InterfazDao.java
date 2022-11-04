package dao;

import java.util.ArrayList;

import pojo.Serie;

public interface InterfazDao<T> {
	
	/**
	 * Inserta un objeto T en la bbdd
	 * 
	 * @param t un objeto T
	 */
	public void insertar(T t);
	
	/**
	 * Actualiza el objeto T de la bbdd
	 * @param t un objeto T
	 */
	public void modificar(T t);
	
	/**
	 * Elimina el objeto T de la bbdd
	 * @param t
	 */
	public void borrar(T t);
	/**
	 * Muestra todos los objetos 'T' de la base de datos
	 * 
	 * @return un ArrayList de objetos T
	 */
	public ArrayList<T> buscarTodos();
	
	/**
	 * Muestra el objeto T con el id especificado
	 * 
	 * @param i el id del objeto T
	 * @return un objeto T
	 */
	public T buscarPorId(int i);
}
