package controlador;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import entidad.Curso;

public class ArregloCurso {

	//Atributo privado
	private ArrayList<Curso> arCurso;
	
	//Constructor
	public ArregloCurso() {
		arCurso = new ArrayList<Curso>();
		//Agregar datos
		/*adicionar(new Curso(1001, "Introducción a la Algoritmia", 0, 5, 4));
		adicionar(new Curso(1002, "Tecnologías de la Información", 0, 5, 4));
		adicionar(new Curso(1003, "Matemática I", 0, 3, 2));
		adicionar(new Curso(1004, "Desarrollo Personal", 0, 2, 2));
		adicionar(new Curso(1005, "Algoritmos y Estructura de Datos", 1, 5, 4));
		adicionar(new Curso(1006, "Base de Datos", 1, 5, 5));
		adicionar(new Curso(1007, "Desarrollo de Entornos Web", 1, 5, 5));
		adicionar(new Curso(1008, "Matemática II", 1, 3, 3));
		adicionar(new Curso(1009, "Lenguaje de Programación", 2, 5, 5));
		adicionar(new Curso(1010, "Análisis de Diseño de Sistemas", 2, 5, 5));
		adicionar(new Curso(1011, "Base de Datos II", 2, 5, 5));
		*/
		cargarCursos();
	}
	
	//Métodos básicos
	public int tamanio() {
		return arCurso.size();
	}
	
	public Curso obtener(int pos) {
		return arCurso.get(pos);
	}
	
	public void adicionar(Curso c) {
		arCurso.add(c);
	}
	
	public Curso buscar(int codigo) {
		for (int i = 0; i < tamanio(); i++) {
			if(obtener(i).getCodCurso() == codigo)
				return obtener(i);
		}
		return null;
	}
	
	public void eliminar(Curso c) {
		arCurso.remove(c);
	}
	
	public void guardarCurso() {
		try {
			PrintWriter pw;
			Curso cur;
			String linea;
			pw = new PrintWriter(new File("cursos.txt"));
			for (int i = 0; i < arCurso.size(); i++) {
				cur = arCurso.get(i);
				linea = cur.getCodCurso()+";"+
						cur.getAsignatura()+";"+
						cur.getCiclo()+";"+
						cur.getCreditos()+";"+
						cur.getHoras()+";";
				pw.println(linea);
			}
			pw.close();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}
	
	public void cargarCursos() {
		try {
			BufferedReader br;
			String linea, asig;
			int codCur, cred, horas, ciclo;
			String [] sep;
			br = new BufferedReader(new FileReader("cursos.txt"));
			while ((linea = br.readLine()) != null) {
				sep = linea.split(";");
				codCur = Integer.parseInt(sep[0]);
				asig = sep[1];
				ciclo = Integer.parseInt(sep[2]);
				cred = Integer.parseInt(sep[3]);
				horas = Integer.parseInt(sep[4]);			
				arCurso.add(new Curso(codCur, asig, ciclo, cred, horas));				
			}
			br.close();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}
}
