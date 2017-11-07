import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

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
		emf = javax.persistence.Persistence.createEntityManagerFactory("escalafon");
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
	 * 
	 * @param posicion
	 * @return un aspirante de la lista
	 */
	public Aspirer FindAspirer(int posicion) {
		int index = posicion - 1;
		return Aspirers.get(index);
	}

	/**
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

	public void DeleteAspirer(int posicion) {
		Aspirer aspirer = em.find(Aspirer.class, FindAspirer(posicion).getId());
		em.getTransaction().begin();
		em.remove(aspirer);
		em.getTransaction().commit();
		Organize();
	}

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
