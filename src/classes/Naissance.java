package classes;

import java.time.LocalDate;

/** Représente une naissance
 * @author Xavier CALLOCH
 * Date: 2020-03-20
 *
 */
public class Naissance {
	
	/** année de naissance */
	private long annee;
	
	/** date de naissance */
	private LocalDate dateEvenement;
	
	/** nombre de naissances */
	private Long nombre;
	
	/** Constructeur
	 * @param annee			année de naissance
	 * @param dateEvenement	date de naissance
	 * @param nombre		nombre de naissances
	 */
	public Naissance(long annee, LocalDate dateEvenement, Long nombre) {
		this.annee = annee;
		this.dateEvenement = dateEvenement;
		this.nombre = nombre;
	}
	
	@Override
	public String toString() {
		return "Année: " + getAnnee() + " - Date événement: " + getDateEvenement() + " - Nombre de naissances: " +
				getNombre();
	}

	/** Getter
	 * @return the annee
	 */
	public long getAnnee() {
		return annee;
	}

	/** Setter
	 * @param annee the annee to set
	 */
	public void setAnnee(long annee) {
		this.annee = annee;
	}

	/** Getter
	 * @return the dateEvenement
	 */
	public LocalDate getDateEvenement() {
		return dateEvenement;
	}

	/** Setter
	 * @param dateEvenement the dateEvenement to set
	 */
	public void setDateEvenement(LocalDate dateEvenement) {
		this.dateEvenement = dateEvenement;
	}

	/** Getter
	 * @return the nombre
	 */
	public Long getNombre() {
		return nombre;
	}

	/** Setter
	 * @param nombre the nombre to set
	 */
	public void setNombre(Long nombre) {
		this.nombre = nombre;
	}
	
}
