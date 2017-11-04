
/**
 * PROPÓSITO: Es una clase que actúa como la clase padre de los aspirantes.
 * 
 * @author Javier Anleu 17149
 * @author Odalis Reyes 17032
 * @version 1.0
 * @since November 2nd, 2017
 *
 */

import java.io.Serializable;

import javax.persistence.Entity;

import org.bson.types.ObjectId;


@Entity
public class Aspirer implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8864168665622995215L;
	/* Atributos */
	protected ObjectId Id;
	protected String Name;
	protected String DPI;
	protected double Average;
	protected boolean Type;
	protected boolean Desvinculado;
	protected double NotaHistoria;
	protected double Escalafon;

	/**
	 * Constructor vacío para la clase
	 */
	public Aspirer() {}
	
	/**
	 * CONSTRUCTOR
	 * 
	 * @param name
	 *            Nombre del aspirante
	 * @param dPI
	 *            Número de DPI
	 * @param type
	 *            Tipo de aspirante. True es graduado de bachillerato, false es
	 *            graduado de secundaria
	 * @param desvinculado
	 *            Si el alumno es desvinculado (true) o no (false)
	 * @param notaHistoria
	 *            Nota del examen de historia
	 */
	public Aspirer(String name, String dPI, double average, boolean type, boolean desvinculado, double notaHistoria) {
		Name = name;
		DPI = dPI;
		Average = average;
		Type = type;
		Desvinculado = desvinculado;
		NotaHistoria = notaHistoria;
		Escalafon = 0;
	}

	/**
	 * Getter para el nombre
	 * 
	 * @return the name
	 */
	public String getName() {
		return Name;
	}

	/**
	 * Setter para el nombre
	 * 
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		Name = name;
	}

	/**
	 * Getter para el DPI
	 * 
	 * @return the dPI
	 */
	public String getDPI() {
		return DPI;
	}

	/**
	 * Setter para el DPI
	 * 
	 * @param dPI
	 *            the dPI to set
	 */
	public void setDPI(String dPI) {
		DPI = dPI;
	}

	/**
	 * Getter para el tipo de aspirante
	 * 
	 * @return the type
	 */
	public boolean isType() {
		return Type;
	}

	/**
	 * Setter para el tipo de aspirante
	 * 
	 * @param type
	 *            the type to set
	 */
	public void setType(boolean type) {
		Type = type;
	}

	/**
	 * Getter para saber si el aspirante es desvinculado
	 * 
	 * @return the desvinculado
	 */
	public boolean isDesvinculado() {
		return Desvinculado;
	}

	/**
	 * Setter para determinar si el alumno es desvinculado
	 * 
	 * @param desvinculado
	 *            the desvinculado to set
	 */
	public void setDesvinculado(boolean desvinculado) {
		Desvinculado = desvinculado;
	}

	/**
	 * Getter para la nota de historia
	 * 
	 * @return the notaHistoria
	 */
	public double getNotaHistoria() {
		return NotaHistoria;
	}

	/**
	 * Setter para la nota de historia
	 * 
	 * @param notaHistoria
	 *            the notaHistoria to set
	 */
	public void setNotaHistoria(double notaHistoria) {
		NotaHistoria = notaHistoria;
	}

	/**
	 * Getter para el promedio
	 * 
	 * @return the average
	 */
	public double getAverage() {
		return Average;
	}

	/**
	 * Setter para el promedio
	 * 
	 * @param average
	 *            the average to set
	 */
	public void setAverage(double average) {
		Average = average;
	}

	/**
	 * @return the Escalafon
	 */
	public double getEscalafon() {
		return Escalafon;
	}

	/**
	 * @param Escalafon
	 *            the Escalafon to set
	 */
	public void setEscalafon(double Escalafon) {
		this.Escalafon = Escalafon;
	}

	/**
	 * toString de la clase
	 * 
	 * @return String con la información del objeto
	 */
	public String toString() {
		String texto;
		if (Type == false) {
			if (Desvinculado == false) {
				texto = "Nombre: " + Name + "\nNúmero de DPI: " + DPI + "\nTipo: Graduado de Secundaria"
						+ "\nDesvinculado: No" + "\nNota de Historia: " + NotaHistoria + "\nNota del escalafón: "
						+ Escalafon;
			} else {
				texto = "Nombre: " + Name + "\nNúmero de DPI: " + DPI + "\nTipo: Graduado de Secundaria"
						+ "\nDesvinculado: Si" + "\nNota de Historia: " + NotaHistoria + "\nNota del escalafón: "
						+ Escalafon;
			}
		} else {
			if (Desvinculado == false) {
				texto = "Nombre: " + Name + "\nNúmero de DPI: " + DPI + "\nTipo: Graduado de Bachillerato"
						+ "\nDesvinculado: No" + "\nNota de Historia: " + NotaHistoria + "\nNota del escalafón: "
						+ Escalafon;
			} else {
				texto = "Nombre: " + Name + "\nNúmero de DPI: " + DPI + "\nTipo: Graduado de Bachillerato"
						+ "\nDesvinculado: Si" + "\nNota de Historia: " + NotaHistoria + "\nNota del escalafón: "
						+ Escalafon;
			}
		}
		return texto;
	}

}
