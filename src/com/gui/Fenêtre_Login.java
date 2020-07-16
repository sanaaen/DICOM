package com.gui;


import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.dicom.Médecin;


public class Fenêtre_Login extends JFrame implements ActionListener, KeyListener {

	// Default serial version ID
	private static final long serialVersionUID = 1L;
	
	// Attributs de la fenêtre de connexion
	JPanel Champs, Login, Password, Boutons;
	JLabel L_Login, L_Password;
	JTextField TF_Login;
	JPasswordField TF_Password;
	JButton B_Login, B_Cancel;
	
	// Initialisateurs de l'interface graphique
	// Initialisateur des "Champs" de la fenêtre
	private void Init_Champs() {
		// Création des champs
	    TF_Login = new JTextField(10);
	    TF_Password = new JPasswordField(10);
	    // Ajout des KeyListener des champs
	    TF_Login.addKeyListener(this);
	    TF_Password.addKeyListener(this);
	}
	// Initialisateur des "Boutons" de la fenêtre
	private void Init_Boutons() {
		// Création des boutons
	    B_Login = new JButton("Connexion");
	    B_Cancel = new JButton("Annuler");
	    // Ajout des ActionListener des boutons
	    B_Login.addActionListener(this);
	    B_Cancel.addActionListener(this);
	}
	// Initialisateur des "Labels" de la fenêtre
	private void Init_Labels() {
		// Création des "Labels"
	    L_Login = new JLabel("Identifiant :");
	    L_Password = new JLabel("Mot de passe :");
	}
	// Initialisateur des "Panels" de la fenêtre
	private void Init_Panels() {
		// Création du panneau "Champs"
	    Champs = new JPanel();
	    Champs.setLayout(new BoxLayout(Champs, BoxLayout.PAGE_AXIS));
	    
	    
	    // "Login"
	    
	    // Création du panneau "Login"
	    Login = new JPanel();
	    Login.setLayout(new FlowLayout());
		
		// Inclusion des champs au panneau "Login"
	    Login.add(L_Login);
	    Login.add(TF_Login);
	    
	    
	    // "Password"
	    
	    // Création du panneau "Password"
	    Password = new JPanel();
	    Password.setLayout(new FlowLayout());
		
		// Inclusion des champs au panneau "Password"
	    Password.add(L_Password);
	    Password.add(TF_Password);
	    
	    
	    // Inclusion des panneaux "Login" et "Password" au panneau "Champs"
	    Champs.add(Login);
	    Champs.add(Password);
	    
	    
	    
	    // "Boutons"
	    
	    // Création du panneau "Boutons"
	    Boutons = new JPanel();
	    Boutons.setLayout(new GridLayout(1, 2, 10, 10));
	    
	    // Remplissage du panneau "Boutons"
	    Boutons.add(B_Login);
	    Boutons.add(B_Cancel);
	}
	// Initialisateur de la fenêtre
	private void Init_Frame() {
		// Définit un titre pour notre fenêtre
		this.setTitle("Connexion à DICOM_EMSI");
		// Définit la taille de notre fenêtre : 300 pixels de large et 200 pixels de haut
		this.setSize(300, 200);
		// Empêche de modifier les dimensions de la fenêtre
		this.setResizable(false);
		// Positionne la fenêtre au centre
		this.setLocationRelativeTo(null);
		// Termine le processus lorsqu'on clique sur la croix rouge
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// Remplissage du panneau de la fenêtre
	    this.setLayout(new BorderLayout());
	    this.add(Champs, BorderLayout.CENTER);
	    this.add(Boutons, BorderLayout.SOUTH);
	}
	
	// Constructeur de la fenêtre de connexion
	public Fenêtre_Login() {
		// Initialisation des "Champs" de la fenêtre
		Init_Champs();
		// Initialisation des "Boutons" de la fenêtre
		Init_Boutons();
		// Initialisation des "Labels" de la fenêtre
		Init_Labels();
		// Initialisation des "Panels" de la fenêtre
		Init_Panels();
		// Initialisation de la fenêtre
		Init_Frame();
		
	    // Rendre visible la fenêtre
	    this.setVisible(true);
	}

	// Actions liées aux boutons "Login" et "Cancel"
	@Override
	public void actionPerformed(ActionEvent e) {
		// Bouton "Connexion"
		if (e.getSource() == B_Login) {
			// Création du médecin
			Médecin Med = new Médecin();
			// Vérification du couple "Login" / "Password"
			if (Med.Login(TF_Login.getText(), String.valueOf(TF_Password.getPassword()) )) {
				// Fermeture de la fenêtre de connexion
				this.dispose();
				// Création d'une fenêtre de conversion dédiée à un médecin
				new Fenêtre_Convertion(Med);
			} else {
				// Affichage d'un message d'erreur suite à la connexion
				JOptionPane.showMessageDialog(this,
						"Erreur de connexion !\nVeuillez vérifier votre identifiant"
						+ " et votre mot de passe.",
						"ERREUR CONNEXION",JOptionPane.WARNING_MESSAGE);
			}
		}
		// Bouton "Annuler"
		else if (e.getSource() == B_Cancel) {
			// Sortie du programme avec confirmation
			int Valide = JOptionPane.showConfirmDialog(this, "Êtes-vous sûre?", "Quitter", JOptionPane.YES_OPTION);
			if (Valide == JOptionPane.YES_OPTION) System.exit(0);
		}
		
	}
	// Actions liées aux champs "Login" et "Password"
	@Override
	public void keyTyped(KeyEvent e) {
		// Champs "Login"
		if (e.getSource() == TF_Login) { if (e.getKeyChar() == '\n') TF_Password.requestFocus(); }
		// Champs "Password"
		else if (e.getSource() == TF_Password) { if (e.getKeyChar() == '\n') B_Login.doClick(); }	
	}
	
	// Auto-generated method stub
	@Override public void keyPressed(KeyEvent e) { /*TODO*/ }
	@Override public void keyReleased(KeyEvent e) { /*TODO*/ }
}
