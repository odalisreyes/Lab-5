import java.text.DecimalFormat;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * PROPOSITO:
 * 
 * @author Javier Anleu 17149
 * @author Odalis Reyes 17032
 * @version 1.0
 * @since November 2nd, 2017
 *
 */
public class Bachelor extends Aspirer implements Nota {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	/**
	 * Constructor de la clase. Hereda los atributos de la clase padre.
	 * 
	 * @param name
	 *            Nombre del aspirante
	 * @param dPI
	 *            Número de DPI
	 * @param average
	 *            Promedio de las clases de 4to y 5to Bachillerato
	 * @param type
	 *            Tipo de aspirante
	 * @param desvinculado
	 *            El aspirante es desvinculado de Bachillerato o no
	 * @param notaHistoria
	 *            Nota del examen de historia
	 */
	public Bachelor(String name, String dPI, double average, boolean type, boolean desvinculado, double notaHistoria) {
		super(name, dPI, average, type, desvinculado, notaHistoria);
	}

	/*
	 * MÉTODO: Tiene como objetivo calcular el promedio del escalafon
	 */
	@Override
	public void calcular() {
		if (Desvinculado == false) {
			double Promedio = (Average * 0.6) + (NotaHistoria * 0.4);
			DecimalFormat decimal = new DecimalFormat(".##");
			String NotaEscalafon = decimal.format(Promedio);
			Escalafon = Double.parseDouble(NotaEscalafon);
		}

		else {
			double Promedio = (Average * 0.4) + (NotaHistoria * 0.6);
			DecimalFormat decimal = new DecimalFormat(".##");
			String NotaEscalafon = decimal.format(Promedio);
			Escalafon = Double.parseDouble(NotaEscalafon);
		}

	}
}