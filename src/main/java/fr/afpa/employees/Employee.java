package fr.afpa.employees;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/*
Objectif :
L’objectif de ce TP est de concevoir un programme en console basé sur une approche objet et
permettant de gérer (vraiment très basiquement) des salariés d’une entreprise.

Vous allez écrire une classe représentant les salariés d'une entreprise.
Vous pourrez vous aider du PDF disponible sur pour obtenir des informations sur la façon de faire.
*/

class Employee {
	/**
	 * Matricule de l'employé
	 * Permet de stock les informations a rentré
	 */
	private String registrationNumber;
	private String lastName;
	private String firstName;
	private double salary;
	private LocalDate birthDate;
	private final int socialRate = 30;
	private static final Logger logger = LoggerFactory.getLogger(Employee.class);

	// Permet d'attribué les données de la fonction aux variables dessous (les
	// variables sont instancies afin d'être initialiser dans un autre code)

	// GETTERS : Permet de récupéréss les données d'un objet.

	public Employee(String registrationNumber, String lastName, String firstName, double salary, String birthDate)
			throws Exception {

		boolean isRegistrationNumber = checkRegistrationNumber(registrationNumber);
		if (isRegistrationNumber == true) {
			this.registrationNumber = registrationNumber;
		} else {
			IllegalArgumentException e = new IllegalArgumentException("Error - constructeur Registration Number.");
			logger.error(e.getMessage(), e);
			throw e;
		}

		boolean isLastName = checkFirstLastName(lastName);
		if (isLastName == true) {
			this.lastName = lastName;
		} else {
			throw new Exception("Error - contructeur Last Name.");
		}

		boolean isFirstName = checkFirstLastName(firstName);
		if (isFirstName == true) {
			this.firstName = firstName;
		} else {
			throw new Exception("Error - contructeur First Name.");
		}

		this.salary = salary;

		this.birthDate = LocalDate.parse(birthDate);
	}

	public String getRegistrationNumber() {
		return this.registrationNumber;
	}

	public String getLastName() {
		return this.lastName;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public double getSalary() {
		return this.salary;
	}

	public LocalDate getBirthdatDate() {
		return this.birthDate;
	}

	// Effectue une action sur des objets de la classe (déjà instancier)
	public void setRegistrationNumber(String registrationNumber) throws Exception {
		// A ce niveau, tentative de modification du matricule
		// Nous devons VERIFIER le matricule !
		// -----> PROGRAMMATION DEFENSIVE = vérification des paramètres d'entrée ->
		// registrationNumber
		boolean isRegistrationNumber = checkRegistrationNumber(registrationNumber);
		if (isRegistrationNumber == true) {
			// VRAI donc c'est bien un matricule correct :)
			// Modification du matricule
			this.registrationNumber = registrationNumber;
		} else {
			// Faux
			throw new Exception("ERROR - setter Registration Number.");
		}
	}

	public void setLastName(String lastName) throws Exception {

		boolean isLastName = checkFirstLastName(lastName);
		if (isLastName == true) {

			this.lastName = lastName;
		} else {

			throw new Exception("ERROR - setter Last Name.");
		}
	}

	public void setFirstName(String firstName) throws Exception {

		boolean isFirstName = checkFirstLastName(firstName);
		if (isFirstName == true) {

			this.firstName = firstName;
		} else {

			throw new Exception("ERROR - setter First Name.");
		}
	}

	public void setSalary(double salary) {
		
		this.salary = salary;
	}

	public void setLocalDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}

	@Override

	public String toString() {

		return "Employee {"
				+ " \nMatricule " + getRegistrationNumber()
				+ " \nNom " + getLastName()
				+ " \nPrénom " + getFirstName()
				+ " \nSalaire " + getSalary()
				+ " \nBirthday " + getBirthdatDate()
				+ " \nDays before Birthday " + daysBeforeBirthdate()
				+ " \nSalary " + netSalary()
				+ '}';
	}

	public double netSalary() {

		return this.salary - this.salary * (this.socialRate / 100.0);
	}

	public long daysBeforeBirthdate() {
		LocalDate currentDate = LocalDate.now();
		LocalDate nextBirthDate = this.birthDate.withYear(currentDate.getYear());// .withYear permet de set l'année de
																					// birthyear sur l'année actuelle >
																					// Prochain Anniversaire

		// Si l'anniversaire de cette année est déjà passé, on prend l'année prochaine
		if (nextBirthDate.isBefore(currentDate) || nextBirthDate.isEqual(currentDate)) {
			nextBirthDate = nextBirthDate.plusYears(1); // .plusYear rajoute une valeur à l'année, pareil avec
														// .plusMonths / .plusDays
		}

		return ChronoUnit.DAYS.between(currentDate, nextBirthDate);
	}

	/**
	 * Vérifie une chaîne de caractères et indique s'il s'agit d'un matricuel
	 * correctement formaté ou non
	 * 
	 * @param inputToCheck La chaîne de caractère à vérifier
	 * @return VRAI s'il s'agit d'un matricule, FAUX sinon
	 */
	private boolean checkRegistrationNumber(String inputToCheck) {

		// Vérification de la taille de la chaîne de caractères
		if (inputToCheck.length() != 7) {
			return false;
		}

		// déclaration du booléen qui va stocker le résultat de la vérification
		// VRAI -> la chaîne de caractères passée en paramètre est un matricule
		// correctement formaté
		// FAUX -> la chaîne de caractères passée en paramètre est un matricule pas bien
		// formaté
		boolean isRegistrationNumber = false;

		// Cette première boucle permet de passer en revue TOUS les caractères de la
		// chaîne
		for (int index = 0; index < inputToCheck.length(); index++) {
			// index = longueur de intupToCheck - 1 = 6
			char ch = inputToCheck.charAt(index);
			if (index == 0 || index == 1 || index == 5 || index == 6) {

				// vérification du caractère, s'agit-il d'un chiffre ?
				if (Character.isDigit(ch) == true) {
					isRegistrationNumber = true;
				} else { // attention, ce n'est pas un chiffre
					return false;
				}

			} else { // cas de la position 2, 3 ou 4 -> vérification de letter

				// Quelle opération dois-je faire ?
				if (Character.isLetter(ch)) {
					isRegistrationNumber = true;
				} else {
					return false;
				}
			}
		} // fin du FOR, BRAVO !

		return isRegistrationNumber;
	}

	/**
	 * Vérifie qu'une chaîne de caractères passée en paramètre est un prénom
	 * 
	 * Règles de vérification :
	 * Un prénom ne doit pas comporter de chiffres, ni de caractère spéciale tel que
	 * '#', '$', '%', '/, '\'
	 * 
	 * @param inputToCheck La chaîne de caractère à vérifier
	 * @return VRAI s'il s'agit d'un prénom correctement formaté, FAUX sinon
	 */
	private boolean checkFirstLastName(String inputToCheck) {

		// déclaration du booléen qui va stocker le résultat de la vérification
		// VRAI -> la chaîne de caractères passée en paramètre est un matricule
		// correctement formaté
		// FAUX -> la chaîne de caractères passée en paramètre est un matricule pas bien
		// formaté
		boolean isFirstName = false;
		// boolean isLastName = false;

		for (int index = 0; index < inputToCheck.length(); index++) {

			char ch = inputToCheck.charAt(index);
			if (index < inputToCheck.length()) {

				if (Character.isLetter(ch) == true || ch == '-') {
					isFirstName = true;
				} else {
					return false;
				}
			}
		}
		return true;
	}

	// si la methode est fausse alors retourner en fonction de l'input

	// Implémenter la méthode "toString()" qui renvoie une chaîne de caractère
	// qui représente un objet de la classe employé
	// plus d'information sur la méthode "toString()" ->
	// https://codegym.cc/fr/groups/posts/fr.986.mthode-java-tostring
}
