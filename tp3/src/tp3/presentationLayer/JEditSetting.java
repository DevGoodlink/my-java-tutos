package tp3.presentationLayer;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.util.Properties;

import javax.swing.*;

import tp3.persistenceLayer.ConnectionMySQL;

public class JEditSetting extends JInternalFrame {
	JTextField txtDriver, txtUrl, txtUser, txtPwd;
	public Connection con;

	public JEditSetting() {
		super("Paramètres de Connexion");

		getContentPane().setLayout(null);
		JLabel lblInternalJframe = new JLabel("MODIFICATION DES PARAMETRES");
		lblInternalJframe.setHorizontalAlignment(SwingConstants.CENTER);
		lblInternalJframe.setForeground(new Color(128, 0, 0));
		lblInternalJframe.setFont(new Font("Arial", Font.BOLD, 22));
		lblInternalJframe.setBounds(0, 0, 984, 39);
		getContentPane().add(lblInternalJframe);

		JLabel lblDriver = new JLabel("Driver : ");
		lblDriver.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblDriver.setBounds(20, 45, 200, 14);
		getContentPane().add(lblDriver);

		JLabel lblUrl = new JLabel("URL :");
		lblUrl.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblUrl.setBounds(20, 94, 200, 14);
		getContentPane().add(lblUrl);

		JLabel lblUser = new JLabel("Utilisateur : ");
		lblUser.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblUser.setBounds(20, 150, 200, 14);
		getContentPane().add(lblUser);

		JLabel lblPwd = new JLabel("Mot de passe :");
		lblPwd.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPwd.setBounds(20, 206, 200, 14);
		getContentPane().add(lblPwd);

		txtDriver = new JTextField();
		txtDriver.setBounds(30, 70, 400, 20);
		getContentPane().add(txtDriver);
		txtDriver.setColumns(10);
		txtDriver.setText(valeurConnexion()[0]);

		txtUrl = new JTextField();
		txtUrl.setBounds(30, 120, 400, 20);
		getContentPane().add(txtUrl);
		txtUrl.setColumns(10);
		txtUrl.setText(valeurConnexion()[1]);

		txtUser = new JTextField();
		txtUser.setBounds(30, 170, 400, 20);
		getContentPane().add(txtUser);
		txtUser.setColumns(10);
		txtUser.setText(valeurConnexion()[2]);

		txtPwd = new JTextField();
		txtPwd.setBounds(30, 230, 400, 20);
		getContentPane().add(txtPwd);
		txtPwd.setColumns(10);
		txtPwd.setText(valeurConnexion()[3]);

		JLabel lblFailSuccess = new JLabel("");

		lblFailSuccess.setFont(new Font("Arial", Font.PLAIN, 16));
		lblFailSuccess.setBounds(514, 186, 324, 30);
		getContentPane().add(lblFailSuccess);

		JButton btnConTest = new JButton("Tester la connexion");
		btnConTest.setBounds(433, 455, 150, 23);
		getContentPane().add(btnConTest);
		btnConTest.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (testConnexion()) {
					lblFailSuccess.setText("Connexion réussie");
					lblFailSuccess.setForeground(new Color(0, 255, 0));
				} else {
					lblFailSuccess.setText("Connexion échouée");
					lblFailSuccess.setForeground(new Color(255, 0, 0));
				}

			}
		});
		JButton btnSave = new JButton("Enregistrer");
		getContentPane().add(btnSave);
		btnSave.setBounds(200, 455, 150, 23);
		getContentPane().add(btnSave);
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Properties props = new Properties();
				try {
					FileInputStream in = new FileInputStream("res/databaseInfo.properties");
					props.load(in);
					in.close();
					props.setProperty("jdbc.driver", txtDriver.getText());
					props.setProperty("jdbc.url", txtUrl.getText());
					props.setProperty("jdbc.user", txtUser.getText());
					props.setProperty("jdbc.passwd", txtPwd.getText());
					saveSetting(props);
				} catch (Exception ex) {
					ex.printStackTrace();
				}
				saveSetting(props);
			}
		});

		setTitle("Paramètres de connexion");
		setLocation(0, 70);
		setResizable(true);
		setClosable(true);
		setMaximizable(true);
		setIconifiable(true);
		pack();
		setSize(1325, 724);
		setVisible(true);
	}

	private String[] valeurConnexion() {
		try {
			String[] valeur = new String[4];
			Properties props = new Properties();
			FileInputStream in = new FileInputStream("res/databaseInfo.properties");
			props.load(in);
			in.close();
			valeur[0] = props.getProperty("jdbc.driver");
			valeur[1] = props.getProperty("jdbc.url");
			valeur[2] = props.getProperty("jdbc.user");
			valeur[3] = props.getProperty("jdbc.passwd");
			return valeur;
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	private boolean testConnexion() {
		Connection con = ConnectionMySQL.getConnection();
		if (con != null)
			return true;
		return false;
	}

	private void saveSetting(Properties p) {
		try {
			FileOutputStream file = new FileOutputStream("res/databaseInfo.properties");
			p.store(file, null);
			file.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
