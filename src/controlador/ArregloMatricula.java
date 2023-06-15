package controlador;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import entidad.Matricula;

public class ArregloMatricula {
	//Atributo privado
	private ArrayList<Matricula> arMatricula;
	
	//Constructor
	public ArregloMatricula() {
		arMatricula = new ArrayList<Matricula>();
		//Agregar objetos
		cargarMatricula();
		
	}
	
	//Métodos básicos
	
	public int tamanio() {
		return arMatricula.size();
	}
	
	public Matricula obtener(int pos) {
		return arMatricula.get(pos);
	}
	
	public void adicionar(Matricula m) {
		arMatricula.add(m);
	}
	
	public void eliminar(Matricula m) {
		arMatricula.remove(m);
	}
	
	//Método para generar el código de matrícula
		public int generarCodigo() {
			//Posicion 0 = 100001
			if(tamanio() == 0)
				return 100001;
			else
				return obtener(tamanio() - 1).getNumMatricula() + 1;		
		}
		
	public void guardarMatricula() {
		try {
			PrintWriter pw;
			Matricula m;
			String linea;
			pw = new PrintWriter(new File("matricula.txt"));
			for (int i = 0; i < arMatricula.size(); i++) {
				m = arMatricula.get(i);
				linea = m.getNumMatricula()+";"+
						m.getCodAlumno()+";"+
						m.getCodCurso()+";"+
						m.getHora()+";"+
						m.getFecha()+";";
				pw.println(linea);
			}
			pw.close();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}
	
	public void cargarMatricula() {
		try {
			BufferedReader br;
			String linea, fecha, hora;
			int numMatri, codAlum, codCur;
			String [] sep;
			br = new BufferedReader(new FileReader("matricula.txt"));
			while ((linea = br.readLine()) != null) {
				sep = linea.split(";");
				numMatri = Integer.parseInt(sep[0]);
				codAlum = Integer.parseInt(sep[1]);
				codCur = Integer.parseInt(sep[2]);
				fecha = sep[3];
				hora = sep[4];
				arMatricula.add(new Matricula(numMatri, codAlum, codCur, fecha, hora));
			}
			br.close();
		} catch (Exception e) {
		JOptionPane.showMessageDialog(null, e.getMessage());
		}
	} 	
}
