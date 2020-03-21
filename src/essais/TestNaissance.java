package essais;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;

import classes.Naissance;

public class TestNaissance {
	
	private static List<Naissance> listeN = new ArrayList<Naissance>();

	public static void main(String[] args) {
		
		try {
			// On charge le contenu du fichier dans une liste de type Naissance
			File file = new File("C:/Users/xavie/Documents/naissances_depuis_1900.csv");
			List<String> lignes = FileUtils.readLines(file, "UTF-8");

			for (String ligne : lignes) {
				System.out.println(ligne);
			}

			System.out.println("Nombre de lignes :" + lignes.size());
			
			for (int i = 1; i < lignes.size(); i++) {
				String ligne = lignes.get(i);
				String[] morceaux = ligne.split(";");
				Long annee = Long.parseLong(morceaux[1].trim());
				String stringDate = morceaux[2].trim().substring(0, 4) + "/" + morceaux[2].substring(4, 6) + "/"
						+ morceaux[2].substring(6, 8);
				LocalDate date = LocalDate.parse(stringDate, DateTimeFormatter.ofPattern("yyyy/MM/dd"));
				Long naissance = Long.parseLong(morceaux[3].trim());
				
				listeN.add(new Naissance(annee, date, naissance));
			}
			
			// On affiche le contenu de la liste
			listeN.stream().forEach(System.out::println);
			
			// On affiche toutes les données pour l'année 1900
			System.out.println("");
			listeN.stream().filter(n -> n.getAnnee() == 1900).forEach(System.out::println);
			
			// On affiche le nombre de naissances correspondant à l'année 1900
			System.out.println("\nNombre de naissances de l'année 1900: " + listeN.stream()
				.filter(n -> n.getAnnee() == 1900)
				.map(n -> n.getNombre())
				.reduce(0L, (n1, n2) -> n1 + n2)
			);
			
			// On affiche la moyenne de naissances correspondant à l'année 1971
			Double moyNaiss = listeN.stream()
					.filter(n -> n.getAnnee() == 1971)
					.mapToLong(Naissance::getNombre)
					.average()
					.getAsDouble()
			;
			int moyNaissInt = moyNaiss.intValue();
			System.out.println("\nMoyenne journalière du nombre de naissances de l'année 1971: " + moyNaissInt);

		} catch (IOException e) {
			System.out.println(e.getMessage());
		}

	}

}
