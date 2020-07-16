package com.gui;

import java.awt.BorderLayout;
//import java.awt.FlowLayout;
import java.awt.GridLayout;
//import java.awt.Image;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.Toolkit;

//import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
//import java.awt.BorderLayout;
//import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Container;
//import java.awt.Dimension;
//import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
//import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.swing.BorderFactory;
//import javax.swing.Icon;
import javax.swing.ImageIcon;
//import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JFileChooser;
//import javax.swing.JFrame;
//import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
//import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
//import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;

import com.dicom.Médecin;
import com.pixelmed.dicom.AttributeList;
import com.pixelmed.display.SourceImage;

public class Fenêtre_Convertion extends JFrame implements ActionListener {

	// Default serial version ID
	private static final long serialVersionUID = 1L;
	
	// Médecin dédié à cette fenêtre
	Médecin Med;
	
	// Attributs de la fenêtre de convertion
	JPanel NPanel, WPanel, CPanel,AreasPanel, TitlesPanel;
	JLabel LBL_Titre, LBL_A,label;
	JButton  BT_Quit, BT_Import, BT_LogOut , BT_Convert, BT_SAVE ,BT_RESET;
	JTextArea TXTA_I,TXTA_Info;
	JScrollPane S_I,S_Info;
	JTextField textField ,textField_1, textField_2 , textField_3, textField_4, textField_5;
	//JTextField OccupationField;
	JEditorPane editor;
	JFileChooser chooser;
	JMenuItem menuitem;
	JMenuBar menubar;
	JMenu menu;
	
	//
	void initButtons() {
		BT_Quit = new JButton("Quit");
		BT_Quit.setFont(new Font("Candara", Font.BOLD, 35));
		BT_Quit.setForeground(Color.gray);
		BT_Quit.setHorizontalAlignment(JLabel.CENTER);
		BT_Quit.setBackground(new Color(240,215, 215));
		BT_Quit.addActionListener(this);

		BT_Import = new JButton("Import");
		BT_Import.setFont(new Font("Candara", Font.BOLD, 35));
		BT_Import.setForeground(Color.gray);
		BT_Import.setHorizontalAlignment(JLabel.CENTER);
		BT_Import.setBackground(new Color(240,215, 215));
		BT_Import.addActionListener(this);
		
		BT_LogOut = new JButton("Log Out ");
		BT_LogOut.setFont(new Font("Candara", Font.BOLD, 35));
		BT_LogOut.setForeground(Color.gray);
		BT_LogOut.setHorizontalAlignment(JLabel.CENTER);
		BT_LogOut.setBackground(new Color(240,215, 215));
		BT_LogOut.addActionListener(this);
		
		BT_Convert = new JButton("Convert");
		BT_Convert.setFont(new Font("Candara", Font.BOLD, 35));
		BT_Convert.setForeground(Color.gray);
		BT_Convert.setHorizontalAlignment(JLabel.CENTER);
		BT_Convert.setBackground(new Color(240,215, 215));
		BT_Convert.addActionListener(this);
		
		BT_RESET = new JButton("RESET");
		BT_RESET.setBounds(328, 550, 89, 23);
		BT_RESET.setBackground(new Color(240,215, 215));
		BT_RESET.addActionListener(this);
		
		BT_SAVE = new JButton("SAVE");
		BT_SAVE.setBounds(194, 550, 89, 23);
		BT_SAVE.setBackground(new Color(240,215, 215));
		BT_SAVE.addActionListener(this);
	}
	void initAreas() {
		TXTA_Info = new JTextArea();
		S_Info = new JScrollPane();
		S_Info.getViewport().add(TXTA_Info);
		TXTA_Info.setFont(new Font("Candara", Font.BOLD | Font.ITALIC, 50));
		TXTA_Info.setForeground(Color.DARK_GRAY);
		TXTA_Info.setBackground(Color.gray);
		TXTA_Info.setEnabled(true);
		TXTA_Info.setBorder(BorderFactory.createLineBorder(new Color(240,215, 215), 2));
		
		TXTA_I = new JTextArea();
		S_I = new JScrollPane();
		S_I.getViewport().add(TXTA_I);
		TXTA_I.setFont(new Font("Candara", Font.BOLD | Font.ITALIC, 50));
		TXTA_I.setForeground(Color.gray);
		TXTA_I.setBackground(Color.gray);
		TXTA_I.setEnabled(true);
		TXTA_I.setBorder(BorderFactory.createLineBorder(new Color(240,215, 215),2));
		//TXTA_I.setBounds(0,900 , 300, 100);
		
		textField = new JTextField();
		textField.setBounds(194, 90, 300, 25);
		TXTA_I.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(194, 170, 300, 25);
		TXTA_I.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(194, 250, 300, 25);
		TXTA_I.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(194, 330, 300, 25);
		TXTA_I.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(194, 410, 300, 25);
		TXTA_I.add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setBounds(194, 490, 300, 25);
		TXTA_I.add(textField_5);
		textField_5.setColumns(10);
	}
	void initLabels(String T) {
		LBL_Titre = new JLabel("Bienvenue Dr. " + T);
		LBL_Titre.setFont(new Font("Candara", Font.BOLD | Font.ITALIC, 39));
		LBL_Titre.setForeground(Color.GRAY);
		LBL_Titre.setHorizontalAlignment(JLabel.CENTER);
		
		JLabel lblNewLabel = new JLabel("Patient Name:");
		lblNewLabel.setForeground(new Color(240,215, 215));
		lblNewLabel.setBounds(10, 90, 100, 14);
		TXTA_I.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Patient ID:");
		lblNewLabel_1.setBounds(10, 170, 100, 14);
		lblNewLabel_1.setForeground(new Color(240,215, 215));
		TXTA_I.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Study ID:");
		lblNewLabel_2.setBounds(10, 250, 100, 14);
		lblNewLabel_2.setForeground(new Color(240,215, 215));
		TXTA_I.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Instance ID:");
		lblNewLabel_3.setBounds(10, 330, 100, 17);
		lblNewLabel_3.setForeground(new Color(240,215, 215));
		TXTA_I.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Series ID:");
		lblNewLabel_4.setBounds(10, 410, 100, 17);
		lblNewLabel_4.setForeground(new Color(240,215, 215));
		TXTA_I.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("DICOM file name:");
		lblNewLabel_5.setBounds(10, 490, 100, 17);
		lblNewLabel_5.setForeground(new Color(240,215, 215));
		TXTA_I.add(lblNewLabel_5);
		
		LBL_A = new JLabel("Patient information:");
		LBL_A.setBounds(10, 25, 500, 50);
		LBL_A.setFont(new Font("Candara", Font.BOLD | Font.ITALIC, 39));
		LBL_A.setForeground(new Color(240,215, 215));
		//LBL_A.setHorizontalAlignment(JLabel.CENTER);
		TXTA_I.add(LBL_A);

		//ImageViewer
		label = new JLabel();
		//label.setBounds(600, 100, 800, 300);
		label.setForeground(Color.black);
		
		label.setSize(900, 600);
		chooser = new JFileChooser();
		chooser.setCurrentDirectory(new File("."));
					
		menubar = new JMenuBar();
		setJMenuBar(menubar);
					
		menu = new JMenu("Ouvrir");
		menubar.add(menu);
					
		menuitem = new JMenuItem("Image");
		menu.add(menuitem);
					
		menuitem.addActionListener(new ActionListener(){
			@Override
		public void actionPerformed(ActionEvent event) {
							
			int result = chooser.showOpenDialog(null);
			if(result == JFileChooser.APPROVE_OPTION) {
				String name = chooser.getSelectedFile().getPath();
				Image image = Toolkit.getDefaultToolkit().getImage(name);
				Image resizedImage = image.getScaledInstance(TXTA_Info.getWidth(), TXTA_Info.getHeight(), Image.SCALE_SMOOTH); 
				label.setIcon(new ImageIcon(resizedImage));
				MediaTracker tracker = new MediaTracker(new java.awt.Container());
				tracker.addImage(image, 0);
				try {
					   tracker.waitForAll();
					} catch (InterruptedException ex) {
					    throw new RuntimeException("Image loading interrupted", ex);
					}
					Graphics g =label.getGraphics();
					  g.drawImage(resizedImage, 0, 0, null);
				}
			}
		});
	}
	void initPanels() {
		NPanel = new JPanel();
		NPanel.setBackground(Color.DARK_GRAY);
		NPanel.setLayout(new GridLayout(1,1));
		NPanel.setBorder(new BevelBorder(30));
		NPanel.add(LBL_Titre);
		NPanel.setBorder(BorderFactory.createLineBorder(new Color(99,0,90), 2));
		
		WPanel = new JPanel();
		WPanel.setBackground(Color.DARK_GRAY);
		WPanel.setLayout(new GridLayout(4,1,10,10));
		WPanel.setBorder(new EmptyBorder(30, 10, 350, 10));
		//WPanel.add(BT_Import);
		WPanel.add(BT_Import);
		WPanel.add(BT_Convert);
		WPanel.add(BT_LogOut);
		WPanel.add(BT_Quit);
		WPanel.setBorder(BorderFactory.createRaisedBevelBorder());
		WPanel.setBorder(BorderFactory.createMatteBorder(50, 1, 60, 1, Color.DARK_GRAY));
				
				
				
		//TitlesPanel = new JPanel();
		//TitlesPanel.setBackground(new Color(0,0,255));
		//TitlesPanel.setLayout(new GridLayout(1,3,10,10));
		//TitlesPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
		//TitlesPanel.add(LBL_S);
		//TitlesPanel.add(LBL_P);
		//TitlesPanel.add(LBL_A);
		
		
		
		AreasPanel = new JPanel();
		AreasPanel.setBackground(new Color(240,215, 215));
		AreasPanel.setLayout(new GridLayout(1,3,10,10));
		AreasPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
		AreasPanel.add(S_I);
		AreasPanel.add(S_Info);
		
		
		TXTA_I.add(BT_RESET);
		TXTA_I.add(BT_SAVE);
		
		
		TXTA_Info.add(menubar);
		TXTA_Info.add(chooser);
		TXTA_Info.add(label);
		
		CPanel = new JPanel();
		CPanel.setBackground(Color.DARK_GRAY);
		CPanel.setLayout(new BorderLayout());
		CPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
		CPanel.add(AreasPanel, BorderLayout.CENTER);
	}
	
	// Constructeur de la classe "Fenêtre_Convertion"	
	public Fenêtre_Convertion(Médecin M) {
		Med = M;
		// Définit un titre pour notre fenêtre		
		this.setTitle("DICOM_EMSI");
		// Définit la taille de notre fenêtre : 800 pixels de large et 600 pixels de haut
	    //this.setSize(800, 600);
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
	    // Positionne la fenêtre au centre
	    this.setLocationRelativeTo(null);
	    // Termine le processus lorsqu'on clique sur la croix rouge
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	    //
	    initAreas();
		initButtons();
		initLabels(Med.Nom);
		initPanels();
		Container cp = this.getContentPane();
		
		cp.setLayout(new BorderLayout());
		cp.setBackground(new Color(255,255,190));
		cp.add(NPanel, BorderLayout.NORTH);
		cp.add(WPanel, BorderLayout.EAST);
		cp.add(CPanel, BorderLayout.CENTER);
		//cp.setLayout(new SpringLayout());
			    
	    // Rendre visible la fenêtre
	    this.setVisible(true);
	}
	
	// Actions liées aux boutons
	@Override
	public void actionPerformed(ActionEvent e) {
		// Bouton "Log Out"
		if (e.getSource() == BT_LogOut) {
			// Log Out avec confirmation
			int Valide = JOptionPane.showConfirmDialog(this, "Êtes-vous sûre?", "Log Out", JOptionPane.YES_OPTION);
			if (Valide == JOptionPane.YES_OPTION) {
				// Fermeture de la fenêtre de convertion
				this.dispose();
				// Création d'une fenêtre de connexion
				new Fenêtre_Login();
			}
		}
		// Bouton "Quit"
		else if (e.getSource() == BT_Quit) {
			// Sortie du programme avec confirmation
			int Valide = JOptionPane.showConfirmDialog(this, "Êtes-vous sûre?", "Quitter", JOptionPane.YES_OPTION);
			if (Valide == JOptionPane.YES_OPTION) System.exit(0);
		}
		// Bouton "Save"
		else if (e.getSource() == BT_SAVE) {
			Med.Save();
		}
		// Bouton "Reset"
		else if (e.getSource() == BT_RESET) {
			Reset();
		}
		// Bouton "Import"
		else if (e.getSource() == BT_Import) {
			Import();
		}
		// Bouton "Convert"
		else if (e.getSource() == BT_Convert) {
			Med.Convert();
		}
		
	}
	
	// Fonction de réinitialisation des champs du formulaire
	private void Reset() {
		// Remplacemant des champs par des chaînes vides
		textField.setText("");
		textField_1.setText("");
		textField_2.setText("");
		textField_3.setText("");
		textField_4.setText("");
		textField_5.setText("");
	}
	
	// Fonction d'importation des données depuis un fichier DICOM
	private void Import() {
		//
		//chooser.setCurrentDirectory(new File("."));
		int result = chooser.showOpenDialog(null);
		if(result == JFileChooser.APPROVE_OPTION) {
			String dicomFile = chooser.getSelectedFile().getPath();
			
			//
			AttributeList list = new AttributeList();
			BufferedImage Bimg;
			Graphics Gimg;
			Image image = null;
			try {
				list.read(dicomFile);
				SourceImage img = new SourceImage(list);
				Bimg = img.getBufferedImage();
				Gimg = Bimg.getGraphics();
				Gimg.drawImage(image, 0, 0, this);
				Image resizedImage = image.getScaledInstance(TXTA_Info.getWidth(), TXTA_Info.getHeight(), Image.SCALE_SMOOTH); 
				label.setIcon(new ImageIcon(resizedImage));
				MediaTracker tracker = new MediaTracker(new java.awt.Container());
				tracker.addImage(image, 0);
				try {
					tracker.waitForAll();
				} catch (InterruptedException ex) {
				    throw new RuntimeException("Image loading interrupted", ex);
				}
				Graphics g =label.getGraphics();
				g.drawImage(resizedImage, 0, 0, null);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
