import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.*;

/**
 * PROPÓSITO: Es la clase que actúa como controlador del modelo. Hace la
 * conexión con la base de datos, organiza la información disponible, permite
 * agregar datos, modificarlos o eliminarlos, y realiza cálculos
 * 
 * @author Javier Anleu 17149
 * @author Odalis Reyes 17032
 * @version 1.0
 * @since November 5th, 2017
 */
public class Evaluate {

	private ArrayList<Aspirer> Aspirers;
	private EntityManagerFactory emf;
	private EntityManager em;

	/**
	 * Constructor de la clase
	 */
	public Evaluate() {
		emf = Persistence.createEntityManagerFactory("jdbc:mysql://localhost:3306/escalafon");
		em = emf.createEntityManager();
		Aspirers = new ArrayList<Aspirer>();
	}

	/**
	 * GET de los aspirantes
	 * 
	 * @return la lista de los aspirantes
	 */
	public ArrayList<Aspirer> getAspirers() {
		return Aspirers;
	}

	/**
	 * 
	 * @param aspirers
	 */
	public void setAspirers(ArrayList<Aspirer> aspirers) {
		Aspirers = aspirers;
	}

	public void CloseDB() {
		emf.close();
		em.close();
	}

	/**
	 * SET de los aspirantes
	 * 
	 * @param s
	 *            la lista de los estudiantes de secundaria
	 * @param b
	 *            la lista de los estudiantes de bachillerato
	 */
	public void setAspirers2(List<Secondary> s, List<Bachelor> b) {
		for (Secondary secondary : s) {
			Aspirers.add(secondary);
		}
		for (Bachelor bachelor : b) {
			Aspirers.add(bachelor);
		}
	}

	@SuppressWarnings("unchecked")
	/**
	 * Método para organizar la lista de los aspirantes
	 */
	public void Organize() {
		Query s = em.createQuery("select s from Secondary s");
		Query b = em.createQuery("select b from Bachelor b");

		Aspirers = new ArrayList<Aspirer>();
		setAspirers2(s.getResultList(), b.getResultList());

		// Bubble sort
		for (int m = Aspirers.size(); m >= 0; m--) {
			for (int i = 0; i < Aspirers.size() - 1; i++) {
				int k = i + 1;
				if (Aspirers.get(i).getEscalafon() > Aspirers.get(k).getEscalafon()) {
					Aspirer temp = Aspirers.get(i);
					Aspirers.set(i, Aspirers.get(k));
					Aspirers.set(k, temp);
				}
			}
		}
	}

	/**
	 * 
	 * Método para poder agregar un aspirante de secundaria al escalafon
	 * 
	 * @param name
	 *            nombre del estudiante
	 * @param dPI
	 *            número de DPI del estudiante
	 * @param Average
	 *            promedio de las notas de básico
	 * @param Type
	 *            si es de secundaria o bachillerato
	 * @param Desvinculado
	 *            si es desvinculado o no
	 * @param notaHistoria
	 *            nota del examen de historia
	 * @param notaMatematica
	 *            nota del examen de matematica
	 * @param notaEspanol
	 *            nota del examen de español
	 * @param notaAptitud
	 *            nota del examen de aptitud
	 */
	public void addSecondary(String name, String dPI, double Average, boolean Type, boolean Desvinculado,
			double notaHistoria, double notaMatematica, double notaEspanol, double notaAptitud) {
		Secondary secondary = new Secondary(name, dPI, Average, Type, Desvinculado, notaHistoria, notaMatematica,
				notaEspanol, notaAptitud);
		em.getTransaction().begin();
		em.persist(secondary);
		em.getTransaction().commit();
		Organize();
	}

	/**
	 * Método para poder agregar un aspirante de bachillerato al escalafon
	 * 
	 * @param name
	 *            nombre del estudiante de Bachillerato
	 * @param dPI
	 *            número de DPI del estudiante
	 * @param average
	 *            promedio de las notas de bachillerato
	 * @param type
	 *            si es de secundaria o de bachillerato
	 * @param desvinculado
	 *            si es desvinculado o no
	 * @param notaHistoria
	 *            nota del examen de historia
	 */
	public void addBachelor(String name, String dPI, double average, boolean type, boolean desvinculado,
			double notaHistoria) {
		Bachelor bachelor = new Bachelor(name, dPI, average, type, desvinculado, notaHistoria);
		em.getTransaction().begin();
		em.persist(bachelor);
		em.getTransaction().commit();
		Organize();
	}

	/**
	 * Método para desplegar los aspirantes ordenados según su nota del escalafon
	 * 
	 * @return text el texto para desplegar todos los aspirantes
	 */
	public String DisplayAspirers() {
		int cont = 1;
		String text = " ";
		for (int i = 0; i < Aspirers.size(); i++) {
			text = text + cont + ". " + Aspirers.get(i).getName() + " Nota: " + Aspirers.get(i).getEscalafon() + "\n";
		}
		return text;
	}

	/**
	 * Método para encontrar un aspirante según su posicion
	 * 
	 * @param posicion
	 *            Es la posicion del aspirante dentro del escalafon
	 * @return un aspirante de la lista
	 */
	public Aspirer FindAspirer(int posicion) {
		int index = posicion - 1;
		return Aspirers.get(index);
	}

	/**
	 * Método para modificar un aspirante de secundaria. Se puede modificar el
	 * nombre, DPI, promedio, tipo, desvinculado, nota de historia, nota de
	 * matematica, nota de español y nota de aptitud
	 * 
	 * @param posicion
	 *            posicion del aspirante
	 * @param dato
	 *            dato que se quiere cambiar
	 * @param name
	 *            nombre del aspirante
	 * @param dPI
	 *            numero de DPI del aspirante
	 * @param Average
	 *            promedio de secundaria del aspirante
	 * @param Type
	 *            si es de secundaria o de bachillerato
	 * @param Desvinculado
	 *            si es desvinculado o no
	 * @param notaHistoria
	 *            nota del examen de historia
	 * @param notaMatematica
	 *            nota del examen de matematica
	 * @param notaEspanol
	 *            nota del examen de español
	 * @param notaAptitud
	 *            nota del examen de aptitud
	 */
	public void ModifySecondary(int posicion, int dato, String name, String dPI, double Average, boolean Type,
			boolean Desvinculado, double notaHistoria, double notaMatematica, double notaEspanol, double notaAptitud) {
		switch (dato) {
		/* Inicia el caso. Busca la posicion y luego lo modifica. */

		/*
		 * Modifica según el parametro, el primer caso es nombre y asi se va
		 * sucesivamente
		 */
		case 1:
			Secondary aspirer = em.find(Secondary.class, FindAspirer(posicion).getId());
			em.getTransaction().begin();
			aspirer.setName(name);
			em.getTransaction().commit();
			break;

		case 2:
			aspirer = em.find(Secondary.class, FindAspirer(posicion).getId());
			em.getTransaction().begin();
			aspirer.setDPI(dPI);
			em.getTransaction().commit();
			break;

		case 3:
			aspirer = em.find(Secondary.class, FindAspirer(posicion).getId());
			em.getTransaction().begin();
			aspirer.setAverage(Average);
			em.getTransaction().commit();
			break;

		case 4:
			aspirer = em.find(Secondary.class, FindAspirer(posicion).getId());
			em.getTransaction().begin();
			aspirer.setType(Type);
			em.getTransaction().commit();
			break;

		case 5:
			aspirer = em.find(Secondary.class, FindAspirer(posicion).getId());
			em.getTransaction().begin();
			aspirer.setDesvinculado(Desvinculado);
			em.getTransaction().commit();
			break;

		case 6:
			aspirer = em.find(Secondary.class, FindAspirer(posicion).getId());
			em.getTransaction().begin();
			aspirer.setNotaHistoria(notaHistoria);
			em.getTransaction().commit();
			break;

		case 7:
			aspirer = em.find(Secondary.class, FindAspirer(posicion).getId());
			em.getTransaction().begin();
			aspirer.setNotaMatematica(notaMatematica);
			em.getTransaction().commit();
			break;

		case 8:
			aspirer = em.find(Secondary.class, FindAspirer(posicion).getId());
			em.getTransaction().begin();
			aspirer.setNotaEspanol(notaEspanol);
			em.getTransaction().commit();
			break;

		case 9:
			aspirer = em.find(Secondary.class, FindAspirer(posicion).getId());
			em.getTransaction().begin();
			aspirer.setNotaAptitud(notaAptitud);
			em.getTransaction().commit();
			break;
		}

		Organize();
	}

	/**
	 * Método para modificar un aspirante de bachillerato segun su posicion. Se
	 * puede modificar el nombre, DPI, promedio, tipo, desvinculado y la nota de
	 * historia
	 * 
	 * @param posicion
	 *            posicion del aspirante
	 * @param dato
	 *            dato a modificar
	 * @param name
	 *            nombre del aspirante
	 * @param dPI
	 *            numero de DPI del aspirante
	 * @param average
	 *            promedio del bachillerato del aspirante
	 * @param type
	 *            si es de secundaria o bachillerato
	 * @param desvinculado
	 *            si es devinculado o no
	 * @param notaHistoria
	 *            nota del examen de historia
	 */
	public void ModifyBachelor(int posicion, int dato, String name, String dPI, double average, boolean type,
			boolean desvinculado, double notaHistoria) {
		switch (dato) {
		case 1:
			/* Inicia el caso. Busca la posicion y luego lo modifica. */

			/*
			 * Modifica según el parametro, el primer caso es nombre y asi se va
			 * sucesivamente
			 */
			Bachelor aspirer = em.find(Bachelor.class, FindAspirer(posicion).getId());
			em.getTransaction().begin();
			aspirer.setName(name);
			em.getTransaction().commit();
			break;

		case 2:
			aspirer = em.find(Bachelor.class, FindAspirer(posicion).getId());
			em.getTransaction().begin();
			aspirer.setDPI(dPI);
			em.getTransaction().commit();
			break;

		case 3:
			aspirer = em.find(Bachelor.class, FindAspirer(posicion).getId());
			em.getTransaction().begin();
			aspirer.setAverage(average);
			em.getTransaction().commit();
			break;

		case 4:
			aspirer = em.find(Bachelor.class, FindAspirer(posicion).getId());
			em.getTransaction().begin();
			aspirer.setType(type);
			em.getTransaction().commit();
			break;

		case 5:
			aspirer = em.find(Bachelor.class, FindAspirer(posicion).getId());
			em.getTransaction().begin();
			aspirer.setDesvinculado(desvinculado);
			em.getTransaction().commit();
			break;

		case 6:
			aspirer = em.find(Bachelor.class, FindAspirer(posicion).getId());
			em.getTransaction().begin();
			aspirer.setNotaHistoria(notaHistoria);
			em.getTransaction().commit();
			break;
		}
		Organize();
	}

	/**
	 * Este metodo tiene como objetivo eliminar un aspirante dentro del escalafon
	 * 
	 * @param posicion
	 *            Es la posicion en la que esta el aspirante
	 */
	public void DeleteAspirer(int posicion) {
		Aspirer aspirer = em.find(Aspirer.class, FindAspirer(posicion).getId());
		em.getTransaction().begin();
		em.remove(aspirer);
		em.getTransaction().commit();
		Organize();
	}

	/**
	 * Método para saber si el dato ingresado por el usuario es mayor al promedio de
	 * los aspirantes desvinculados
	 * 
	 * @param Grade
	 *            Es la nota dentro dele scalafon del aspirante
	 * @return answer Retorna la respuesta de tipo String
	 */
	public String BetterThan(double Grade) {
		double number = 0;
		double wabble = 0;
		for (int i = 0; i < Aspirers.size(); i++) {
			if (Aspirers.get(i).Type == false && Aspirers.get(i).Desvinculado == true) {
				number++;
				wabble = wabble + Aspirers.get(i).Average;
			}
		}
		String answer = "";
		if (wabble / number > Grade) {
			answer = "Sí";
		} else {
			answer = "No";
		}
		return answer;
	}

	/**
	 * Método para saber si el 50% del promedio de los aspirantes desvinculados es
	 * mayor a 80
	 * 
	 * @return answer
	 */
	public String High80() {
		String answer = "";
		double number = 0;
		double wabble = 0;
		for (int i = 0; i < Aspirers.size(); i++) {
			if (Aspirers.get(i).Type == true && Aspirers.get(i).Desvinculado == true) {
				number++;
				if (Aspirers.get(i).Average > 80) {
					wabble++;
				}
			}
		}
		if (wabble / number > 0.5) {
			answer = "Sí";
		} else {
			answer = "No";
		}
		return answer;
	}
}