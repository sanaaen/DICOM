package com.dicom;

import java.io.File;
import java.io.FileNotFoundException;

import java.util.HashMap;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Médecin extends JFrame {
	
	// Default serial version ID
	private static final long serialVersionUID = 1L;
	
	// Attributs
	@SuppressWarnings("unused")
	private String Login, Password;
	@SuppressWarnings("unused")
	private int Id;
	public String Nom, Prénom, Mail, Adresse, Adresse_1;

	public Médecin() {
		// TODO Auto-generated constructor stub
	}
	
	// Fonction de connexion
	// La fonction retourne "true" si l'identifiant et le mot de passe sont bon
	// et retourne "false" sinon
	public Boolean Login(String Log, String Pass) {
		HashMap<String, String> Liste_Login = new HashMap<String, String>();
		// Vérification de la présence d'un fichier de connexion
		try {
			// Ouverture du fichier
			File Login = new File("Login.txt");
			// Création d'un scanner pour lire dans le fichier
		    Scanner FileReader = new Scanner(Login);
		    // Lecture dans le fichier
		    while (FileReader.hasNextLine()) {
		    	String L = FileReader.next();
		    	String P = FileReader.next();
		        Liste_Login.put(L, P);
			}
		    // Fermeture du scanner de fichier
		    FileReader.close();
		    // Vérification de l'identifiant et du mot de passe
			if (Pass.equals(Liste_Login.get(Log))) {
				Init(Log);
				return true;
			}
			else  return false;
		} catch (FileNotFoundException e) {
			// Affichage d'un message d'erreur "FileNotFound"
			JOptionPane.showMessageDialog(this,
					"Erreur de fichier !\nLe fichier de connexion est introuvable.",
					"ERREUR FICHIER",JOptionPane.WARNING_MESSAGE);
			// Forcer à quitter le programme suite à l'erreur
			System.exit(0);
			// Retour de la fonction Login()
			return false;
		}
	}
	
	private void Init(String L) {
		// Vérification de la présence d'un fichier de connexion
		try {
			// Variable
			String Log;
			// Ouverture du fichier
			File Médecins = new File("Médecins.txt");
			// Création d'un scanner pour lire dans le fichier
		    Scanner FileReader = new Scanner(Médecins);
		    // Lecture dans le fichier
		    while (FileReader.hasNextLine()) {
		    	Log = FileReader.next();
		    	if (L.equals(Log)) {
		    		Login = Log;
		    		Password = FileReader.next();
					Id = FileReader.nextInt();
					FileReader.nextLine();
		    		Nom = FileReader.nextLine();
		    		Prénom = FileReader.nextLine();
					Mail = FileReader.nextLine();
					Adresse = FileReader.nextLine();
					Adresse_1 = FileReader.nextLine();
				} else {
					FileReader.nextLine();	// Id
					FileReader.nextLine();	// Nom
					FileReader.nextLine();	// Prénom
					FileReader.nextLine();	// Mail
					FileReader.nextLine();	// Adresse
					FileReader.nextLine();	// Adresse_1
				}
			}
		    // Fermeture du scanner de fichier
		    FileReader.close();
		} catch (FileNotFoundException e) {
			// Affichage d'un message d'erreur "FileNotFound"
			JOptionPane.showMessageDialog(this,
					"Erreur de fichier !\nLe fichier des médecins est introuvable.",
					"ERREUR FICHIER",JOptionPane.WARNING_MESSAGE);
			// Forcer à quitter le programme suite à l'erreur
			System.exit(0);
		}
	}
	
	// Fonction de création d'une image et d'un fichier texte
	// de sauvegarde des données importées du fichier DICOM
	@SuppressWarnings("static-access")
	public void Save() {
		//
		JOptionPane d = new JOptionPane();
		// les textes figurant
		// sur les boutons
		String Formats[]={ "TIFF", "PNG", "TXT", "JPEG"};
		// indice du bouton qui a été
		// cliqué ou CLOSED_OPTION
		int retour = d.showOptionDialog(this, "Quel format voulez-vous?", "Save",
				JOptionPane.INFORMATION_MESSAGE, JOptionPane.QUESTION_MESSAGE, null,
				// icone
				//ImageIcon(getClass().getResource("...")),
				// les textes de boutons
				Formats,
				// le bouton par défaut
				Formats[3]);
		if( retour!=JOptionPane.CLOSED_OPTION) {
			// un bouton cliqué
		}
	}
	
	// Fonction de création d'un fichier DICOM
	public void Convert() {
		//
	}
}
