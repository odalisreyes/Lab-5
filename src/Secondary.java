import java.text.DecimalFormat;

/**
 * PROPÓSITO: Es la clase que actúa como el modelo de los alumnos graduados de
 * secundaria. Es heredada de Aspirer y utiliza la interfaz Nota para establecer
 * la nota en el escalafón
 * 
 * @author Javier Anleu 17149
 * @author Odalis Reyes 17032
 * @version 1.0
 * @since November 2nd, 2017.
 *
 */
public class Secondary extends Aspirer implements Nota {

	private double NotaMatematica;
	private double NotaEspanol;
	private double NotaAptitud;

	/**
	 * Es el constructor de la clase. Tiene como atributos sus parámetros
	 * 
	 * @param name
	 *            Nombre del aspirante
	 * @param dPI
	 *            Número de DPI
	 * @param type
	 *            Tipo de aspirante. Todos son false, que equivale a graduados de
	 *            secundaria
	 * @param desvinculado
	 *            Si el alumno es desvinculado o no
	 * @param notaHistoria
	 *            Nota del examen de historia
	 * @param notaMatematica
	 *            Nota del examen de matematica
	 * @param notaEspanol
	 *            Nota del examen de español
	 * @param notaAptitud
	 *            Nota del examen de aptitud
	 */
	public Secondary(String name, String dPI, double average, boolean type, boolean desvinculado, double notaHistoria,
			double notaMatematica, double notaEspanol, double notaAptitud) {
		super(name, dPI, average, type, desvinculado, notaHistoria);
		NotaMatematica = notaMatematica;
		NotaEspanol = notaEspanol;
		NotaAptitud = notaAptitud;
	}

	/**
	 * Getter para la nota del examen de matemática
	 * 
	 * @return the notaMatematica
	 */
	public double getNotaMatematica() {
		return NotaMatematica;
	}

	/**
	 * Getter para la nota del examen de español
	 * 
	 * @return the notaEspanol
	 */
	public double getNotaEspanol() {
		return NotaEspanol;
	}

	/**
	 * Getter para la nota del examen de aptitud
	 * 
	 * @return the notaAptitud
	 */
	public double getNotaAptitud() {
		return NotaAptitud;
	}

	/**
	 * Setter para la nota del examen de matemática
	 * 
	 * @param notaMatematica
	 *            the notaMatematica to set
	 */
	public void setNotaMatematica(double notaMatematica) {
		NotaMatematica = notaMatematica;
	}

	/**
	 * Setter para la nota del examen de español
	 * 
	 * @param notaEspanol
	 *            the notaEspanol to set
	 */
	public void setNotaEspanol(double notaEspanol) {
		NotaEspanol = notaEspanol;
	}

	/**
	 * Setter para la nota del examen de aptitud
	 * 
	 * @param notaAptitud
	 *            the notaAptitud to set
	 */
	public void setNotaAptitud(double notaAptitud) {
		NotaAptitud = notaAptitud;
	}

	/**
	 * Método para calcular la nota del escalafón.
	 */
	@Override
	public void calcular() {
		if (Desvinculado == false) {
			double AverageTests = (NotaMatematica + NotaEspanol + NotaHistoria) / 3;
			double grade = AverageTests * 0.4 + Average * 0.6;
			DecimalFormat decimal = new DecimalFormat(".##");
			String Grade = decimal.format(grade);
			Escalafon = Double.parseDouble(Grade);
		} else {
			double AverageTests = (NotaMatematica + NotaEspanol + NotaHistoria) / 3;
			double grade = (AverageTests * 0.6 + Average * 0.4 + NotaAptitud) / 2;
			DecimalFormat decimal = new DecimalFormat(".##");
			String Grade = decimal.format(grade);
			Escalafon = Double.parseDouble(Grade);
		}

	}

}
