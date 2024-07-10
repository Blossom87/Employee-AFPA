package fr.afpa.employees;

// import java.time.LocalDate;
// import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
// import java.util.Arrays;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Classe principale du projet, contient la fonction "main"
 */
class EmployeeMain {

	private static final Logger logger = LoggerFactory.getLogger(Employee.class);
	public static void main(String[] args) {
		System.out.println("\n----- Exercice de programmation objet - classe \"Employee\" -----");

		// Implémentation de try pour TOUTE les méthodes afin de les vérifiers
		// catch permet d'obtenir l'erreur trouver dans les fonctions java et renvoie un
		// message en fonction de l'erreur.
		// e.getMessage() hérite du message d'Exception en fonction de l'erreur.
		try {

			Employee employee1 = new Employee("11AA33", "Shazam", "Samantha", 1800.0, "1994-12-12");
			Employee employee2 = new Employee("22BBB44", "Troy", "Roger", 1450.0, "2000-07-29");
			Employee employee3 = new Employee("33CCC66", "Lmao", "Didier", 2500.0, "1968-01-10");

			// listing des classes "wrapper"
			// Character c = 'c';
			// Double d = 120.2;
			// Integer i = 120;
			// Float f = 12.2f;
			// Byte byteTest = 1;
			// Short s = 5;
			// Boolean b = true;

			// Test de conversion
			// String stringConvert = Double.toString(employee1.netSalary());

			// UTILISATION DE SETTERS : Choisir la variable cible de la modification, ajouter la méthode a appeller après un point, le code fait le reste dans la ().
			employee1.setRegistrationNumber("44DDD88");
			
			// création d'un ArrayList
			ArrayList<Employee> employees = new ArrayList<Employee>();

			employees.add(employee1);
			employees.add(employee2);
			employees.add(employee3);

			// ici insérer une boucle qui affiche successivement les informations des
			// employés
			// for (Employee > Class de ArrayList / employee variable abritant les données : 
			// employees instancie chaque employee avec les données mises en dur utiliser dans le tableau.)
			// la boucle for parcours le tableau employees pour le nombre de donné entrer dans cette derniere.
			for (Employee employee : employees) {
				System.out.println(employee);
			}

		} catch (Exception e) {

			System.out.println(e.getMessage());
		}

		// Appelle de methode a partir de l'objet employee1 de la classe Employee (le
		// "." demande accès à une donnée spécifique ici registrationNumber)
		// System.out.println(employee1.getRegistrationNumber());

		// Modification de la variable registrationNumber graçe au Setter de la classe
		// Employee, nouvelle donnée attribuer a registrationNumber

		// Afficher les informations des employés avec System.out.println
	}

	
}
