import java.text.DecimalFormat;

/**
 * @author Javier Anleu 
 *
 */
public class Secondary extends Aspirer implements Nota{

	private double NotaMatematica;
	private double NotaEspanol;
	private double NotaAptitud;
	
	
	/**
	 * @param name
	 * @param dPI
	 * @param type
	 * @param desvinculado
	 * @param notaHistoria
	 * @param notaMatematica
	 * @param notaEspanol
	 * @param notaAptitud
	 */
	public Secondary(String name, String dPI, double average,boolean type, boolean desvinculado, double notaHistoria,
			double notaMatematica, double notaEspanol, double notaAptitud) {
		super(name, dPI, average, type, desvinculado, notaHistoria);
		NotaMatematica = notaMatematica;
		NotaEspanol = notaEspanol;
		NotaAptitud = notaAptitud;
	}
	
	


	/**
	 * @return the notaMatematica
	 */
	public double getNotaMatematica() {
		return NotaMatematica;
	}




	/**
	 * @return the notaEspanol
	 */
	public double getNotaEspanol() {
		return NotaEspanol;
	}




	/**
	 * @return the notaAptitud
	 */
	public double getNotaAptitud() {
		return NotaAptitud;
	}




	/**
	 * @param notaMatematica the notaMatematica to set
	 */
	public void setNotaMatematica(double notaMatematica) {
		NotaMatematica = notaMatematica;
	}




	/**
	 * @param notaEspanol the notaEspanol to set
	 */
	public void setNotaEspanol(double notaEspanol) {
		NotaEspanol = notaEspanol;
	}




	/**
	 * @param notaAptitud the notaAptitud to set
	 */
	public void setNotaAptitud(double notaAptitud) {
		NotaAptitud = notaAptitud;
	}




	@Override
	public void calcular() {
		if (Desvinculado==false) {
			double AverageTests = (NotaMatematica+NotaEspanol+NotaHistoria)/3;
			double grade = AverageTests*0.4+Average*0.6;
			DecimalFormat decimal = new DecimalFormat(".##");
			String Grade = decimal.format(grade);
			Escalafon = Double.parseDouble(Grade);
		} else {
			double AverageTests = (NotaMatematica+NotaEspanol+NotaHistoria)/3;
			double grade = (AverageTests*0.6+Average*0.4+NotaAptitud)/2;
			DecimalFormat decimal = new DecimalFormat(".##");
			String Grade = decimal.format(grade);
			Escalafon = Double.parseDouble(Grade);
		}
		
	}

}
