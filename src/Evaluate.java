import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

/**
 * PROPÓSITO: Es la clase que actúa como controlador del modelo. Hace la conexión con la base de datos, organiza la información disponible, permite agregar datos, modificarlos o eliminarlos, y realiza cálculos
 * @author Javier Anleu 17149
 * @author Odalis Reyes 17032
 * @version 1.0
 * @since November 5th, 2017
 */
public class Evaluate {
	
	private ArrayList<Aspirer> Aspirers;
	private EntityManagerFactory emf;
	private EntityManager em;
	
	public Evaluate() {
		emf = javax.persistence.Persistence.createEntityManagerFactory("escalafon");
        em = emf.createEntityManager();
        Aspirers = new ArrayList<Aspirer>();
	}
	
	public ArrayList<Aspirer> getAspirers(){
		return Aspirers;
	}
	
	public void setAspirers(ArrayList<Aspirer> aspirers) {
		Aspirers = aspirers;
	}
	
	public void CloseDB() {
		emf.close();
		em.close();
	}
	
	public void setAspirers2(List<Secondary> s, List<Bachelor> b) {
		for (Secondary secondary:s) {
			Aspirers.add(secondary);
		}
		
		for (Bachelor bachelor:b) {
			Aspirers.add(bachelor);
		}
	}
	
	
	@SuppressWarnings("unchecked")
	public void Organize() {
		Query s = em.createQuery("select s from Secondary s");
		Query b = em.createQuery("select b from Bachelor b");
		setAspirers2(s.getResultList(),b.getResultList());
		//Bubble sort
		for (int i=0; i<Aspirers.size()-1;i++) {
			int k= i+1;
			if (Aspirers.get(i).getEscalafon()>Aspirers.get(k).getEscalafon()) {
				Aspirer temp = Aspirers.get(i);
				Aspirers.set(i, Aspirers.get(k));
				Aspirers.set(k, temp);
			}
		}
	}
	
	
}
