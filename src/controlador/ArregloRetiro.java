package controlador;

import java.util.ArrayList;

import entidad.Retiro;

public class ArregloRetiro {
	//Atributo privado
	private ArrayList<Retiro> arRetiro;
	
	//Constructor
	public ArregloRetiro() {
		arRetiro = new ArrayList<Retiro>();
	}
	
	//Métodos básicos
	public int tamanio() {
		return arRetiro.size();
	}
	
	public Retiro obtener(int pos) {
		return arRetiro.get(pos);
	}
	
	public void adicionar(Retiro r) {
		arRetiro.add(r);
	}
	
	//Método para generar el código de retiro
	public int generarCodigo() {
		//Posicion 0 = 200001
		if(tamanio() == 0)
			return 200001;
		else
			return obtener(tamanio() - 1).getNumRetiro() + 1;		
	}
}
