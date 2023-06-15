package controlador;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import entidad.Alumno;

public class ArregloAlumno {
	//Atributos privados
	private ArrayList<Alumno> arAlu;
	
	//Constructor
	public ArregloAlumno() {
		arAlu = new ArrayList<Alumno>();
		//Crea un objeto
		//202110001
		/*arAlu.add(new Alumno(202110001, "Alan", "Tobar Suarez", "12345678", 22, 999999999, 0));
		arAlu.add(new Alumno(202110002, "Javier", "Condori Velazco", "12345688", 23, 999999988, 0));
		arAlu.add(new Alumno(202110003, "Fidel", "Gary Espejo", "12345677", 24, 999999977, 0));
		*/
		cargarAlumnos();
	}
	
	//Métodos básicos
	public void adicionar(Alumno al) {
		arAlu.add(al);
	}
	
	public int tamanio() {
		return arAlu.size();
	}
	
	public Alumno obtener(int i) {
		return arAlu.get(i);
	}
	
	//Método para generar el código del alumno
	public int generarCodigo() {
		//Posicion 0 = 202010001
		if(tamanio() == 0)
			return 202010001;
		else
			return obtener(tamanio() - 1).getCodAlumno() + 1;		
	}
	
	//Método buscarDni que va a recibir un parametro el DNI de un alumno, si existe retorna el alumno, caso contrario retorna null
	public Alumno buscarDni(String dni) {
		for (int i = 0; i < tamanio(); i++) {
			if(obtener(i).getDni().equals(dni))
				return obtener(i);
		}
		return null;
	}
	
	//Método buscar Alumno que va a recibir un parametro el codigo de un alumno, si existe retorna el alumno, caso contrario retorna null
	public Alumno buscar(int codigo) {
		for (int i = 0; i < tamanio(); i++) {
			if(obtener(i).getCodAlumno() == codigo)
				return obtener(i);
		}
		return null;
	}
	
	public void eliminar(Alumno a) {
		arAlu.remove(a);
	}
	
	//Crear un métoda que guarde los datos de los alumnos que se encuentre en el ArrayList(memoria)
	//en un archivo de texto
	public void guardarAlumno() {
		//Controlar errores
		try {
			PrintWriter pw;
			Alumno al;
			String linea;
			//Paso A: Obtener(Abri) el archivo "alumnos.txt" en modo escritura
			pw = new PrintWriter(new File("alumnos.txt"));
			//Blucle para realizar el recorrido
			for (int i = 0; i < arAlu.size(); i++) {
				al = arAlu.get(i);
				linea = al.getCodAlumno()+";"+
						al.getNombres()+";"+
						al.getApellidos()+";"+
						al.getDni()+";"+
						al.getEdad()+";"+
						al.getCelular()+";"+
						al.getEstado()+";";
				//Paso B: Adicionar la data al archivo de texto
				pw.println(linea);			
			}
			//Paso C: Cerrar el archivo
			pw.close();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}
	
	public void cargarAlumnos() {
		try {
			//Declarar VARIABLES y OBJETOS
			BufferedReader br;
			String linea, nomb, apell, dni;
			int codAl, edad, cel, estado;
			String [] sep;
			//Abrir el archivo "alumnos.txt" en modo lectura
			br = new BufferedReader(new FileReader("alumnos.txt"));
			//Bucle
			while ((linea = br.readLine()) != null) {
				//Separar la cadena en subcadenas
				sep = linea.split(";");
				codAl = Integer.parseInt(sep[0]);
				nomb = sep[1];
				apell = sep[2];
				dni = sep[3];
				edad = Integer.parseInt(sep[4]);
				cel = Integer.parseInt(sep[5]);
				estado = Integer.parseInt(sep[6]);
				//Adicionar los datos obtenidos en un nuevo objeto de tipo alumno
				arAlu.add(new Alumno(codAl, nomb, apell, dni, edad, cel, estado));
			}
			//Cerar el archivo
			br.close();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}
}
