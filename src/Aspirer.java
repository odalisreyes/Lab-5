
/**
 * PROPÓSITO: Es una clase que actúa como la clase padre de los aspirantes.
 * 
 * @author Javier Anleu 17149
 * @author Odalis Reyes 17032
 * @version 1.0
 * @since November 2nd, 2017
 *
 */

import org.bson.types.ObjectId;

public class Aspirer {
	
	/* Atributos */
	protected ObjectId Id;
	protected String Name;
	protected String DPI;
	protected boolean Type;
	protected boolean Desvinculado;
	protected double NotaHistoria;
	protected double Escalafon;
	
	
	
	
	/**
	 * CONSTRUCTOR
	 * 
	 * @param id
	 * @param name
	 * @param dPI
	 * @param type
	 * @param desvinculado
	 * @param notaHistoria
	 */
	public Aspirer(String name, String dPI, boolean type, boolean desvinculado, double notaHistoria) {
		Name = name;
		DPI = dPI;
		Type = type;
		Desvinculado = desvinculado;
		NotaHistoria = notaHistoria;
		Escalafon = 0;
	}




	/**
	 * @return the name
	 */
	public String getName() {
		return Name;
	}




	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		Name = name;
	}




	/**
	 * @return the dPI
	 */
	public String getDPI() {
		return DPI;
	}




	/**
	 * @param dPI the dPI to set
	 */
	public void setDPI(String dPI) {
		DPI = dPI;
	}




	/**
	 * @return the type
	 */
	public boolean isType() {
		return Type;
	}




	/**
	 * @param type the type to set
	 */
	public void setType(boolean type) {
		Type = type;
	}




	/**
	 * @return the desvinculado
	 */
	public boolean isDesvinculado() {
		return Desvinculado;
	}




	/**
	 * @param desvinculado the desvinculado to set
	 */
	public void setDesvinculado(boolean desvinculado) {
		Desvinculado = desvinculado;
	}




	/**
	 * @return the notaHistoria
	 */
	public double getNotaHistoria() {
		return NotaHistoria;
	}




	/**
	 * @param notaHistoria the notaHistoria to set
	 */
	public void setNotaHistoria(double notaHistoria) {
		NotaHistoria = notaHistoria;
	}
	
	
	
	/**
	 * @return the Escalafon
	 */
	public double getEscalafon() {
		return Escalafon;
	}



	/**
	 * @param Escalafon the Escalafon to set
	 */
	public void setEscalafon(double Escalafon) {
		this.Escalafon = Escalafon;
	}
	
	
	
	/**
	 * @param 
	 * @return String con la información del objeto
	 */
	public String toString() {
		String texto;
		if (Type==false) {
			if (Desvinculado == false) {
				texto = "Nombre: " + Name + "\nNúmero de DPI: " + DPI + "\nTipo: Graduado de Secundaria" + "\nDesvinculado: No" + "\nNota de Historia: " + NotaHistoria + "\nNota del escalafón: " + Escalafon;
			} else {
				texto= "Nombre: " + Name + "\nNúmero de DPI: " + DPI + "\nTipo: Graduado de Secundaria" + "\nDesvinculado: Si" + "\nNota de Historia: " + NotaHistoria + "\nNota del escalafón: " + Escalafon;
			}
		} else {
			if (Desvinculado == false) {	
				texto = "Nombre: " + Name + "\nNúmero de DPI: " + DPI + "\nTipo: Graduado de Bachillerato" + "\nDesvinculado: No" + "\nNota de Historia: " + NotaHistoria + "\nNota del escalafón: " + Escalafon;
			} else {
				texto = "Nombre: " + Name + "\nNúmero de DPI: " + DPI + "\nTipo: Graduado de Bachillerato" + "\nDesvinculado: Si" + "\nNota de Historia: " + NotaHistoria + "\nNota del escalafón: " + Escalafon;
			}
		}
		return texto;
	}
	
	
	
	
	
	
	
	
}
