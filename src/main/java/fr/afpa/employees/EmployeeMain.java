package fr.afpa.employees;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/**
 * Classe principale du projet, contient la fonction "main"
 */
class EmployeeMain {
	public static void main(String[] args) {
		System.out.println("\n----- Exercice de programmation objet - classe \"Employee\" -----");

		// Implémentation de try pour TOUTE les méthodes afin de les vérifiers
		// catch permet d'obtenir l'erreur trouver dans les fonctions java et renvoie un message en fonction de l'erreur.
		// e.getMessage() hérite du message d'Exception en fonction de l'erreur.
		try {
			Employee employee1 = new Employee("11AAA33", "Shazam", "Samantha", 1800.0, "1994-12-12");
			
			employee1.setRegistrationNumber("11AAA33");

			System.out.println(employee1.getRegistrationNumber());

			System.out.println(employee1.toString());
		
		} catch (Exception e) {

			System.out.println(e.getMessage());
		
		}
		// Appelle de methode a partir de l'objet employee1 de la classe Employee (le
		// "." demande accès à une donnée spécifique ici registrationNumber)
		// System.out.println(employee1.getRegistrationNumber());

		// Modification de la variable registrationNumber graçe au Setter de la classe
		// Employee, nouvelle donnée attribuer a registrationNumber

	


		// TODO afficher les informations des employés avec System.out.println
	}
}
