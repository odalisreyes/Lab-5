import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.DecimalFormat;
import java.util.InputMismatchException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JScrollBar;
import java.awt.Color;

public class GUI extends JFrame {

	private Evaluate hallelujah;
	private JPanel contentPane;
	private JTextField NameTF;
	private JTextField AverageTF;
	private JTextField NHistoriaTF;
	private JTextField NMatematicaTF;
	private JTextField NEspanolTF;
	private JTextField NAptitudTF;
	private JComboBox<String> TipoCB;
	private JButton AddB;
	private JRadioButton SiRB;
	private JRadioButton NoRB;
	private JTextField DPITF;
	private JTextField ModifyPositionTF;
	private JTextField NewAspirerTF;
	private JTextField PositionTF;
	private JTextField Answer1TF;
	private JButton MostrarB;
	private JButton MostrarATF;
	private JTextArea AspirantesTA;
	private JButton ModifyB;
	private JComboBox ModifyCB;
	private JComboBox<String> TypeDesCB;
	private JTextArea ShowAspirerTA;
	private JButton Calculate1B;
	private JButton Calculate2B;
	private JLabel Answer1;
	private JLabel Answer2TF;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI frame = new GUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public GUI() {
		// Llamada al constructor de la clase controladora
		hallelujah = new Evaluate();
		hallelujah.Organize();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 928, 705);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JPanel panel = new JPanel();

		JPanel panel_1 = new JPanel();

		JPanel panel_2 = new JPanel();
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(
				Alignment.TRAILING,
				gl_contentPane.createSequentialGroup().addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(panel_2, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 912, Short.MAX_VALUE)
						.addGroup(gl_contentPane.createSequentialGroup()
								.addComponent(panel, GroupLayout.PREFERRED_SIZE, 474, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 426, Short.MAX_VALUE)))
						.addContainerGap()));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
						.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(panel_1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE,
										GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(panel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 337, Short.MAX_VALUE))
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(panel_2, GroupLayout.DEFAULT_SIZE, 257, Short.MAX_VALUE).addContainerGap()));
		panel_2.setLayout(null);

		JLabel lblMostrarAspirante = new JLabel("Mostrar aspirante");
		lblMostrarAspirante.setBounds(202, 6, 127, 16);
		panel_2.add(lblMostrarAspirante);

		JLabel lblPosicinEnEl_1 = new JLabel("Posición en el escalafón:");
		lblPosicinEnEl_1.setBounds(37, 43, 155, 16);
		panel_2.add(lblPosicinEnEl_1);

		PositionTF = new JTextField();
		PositionTF.setBounds(199, 34, 78, 26);
		panel_2.add(PositionTF);
		PositionTF.setColumns(10);

		JButton ShowB = new JButton("Mostrar");
		ShowB.setBounds(289, 34, 117, 29);
		panel_2.add(ShowB);

		ShowAspirerTA = new JTextArea();
		ShowAspirerTA.setBounds(19, 71, 451, 99);
		panel_2.add(ShowAspirerTA);

		JButton AgainB = new JButton("Reiniciar programa");
		AgainB.setBounds(643, 100, 155, 29);
		panel_2.add(AgainB);

		JLabel lblelDe = new JLabel(
				"¿El 50% de los alumnos desvinculados graduados de bachillerato tienen un promedio mayor a 80 pts?");
		lblelDe.setBounds(19, 187, 651, 16);
		panel_2.add(lblelDe);

		JButton Calculate1B = new JButton("Calcular");
		Calculate1B.setBounds(669, 182, 95, 29);
		panel_2.add(Calculate1B);

		JLabel Answer1 = new JLabel("Respuesta");
		Answer1.setForeground(new Color(178, 34, 34));
		Answer1.setBounds(776, 187, 89, 16);
		panel_2.add(Answer1);

		JLabel lblelPromedioDe = new JLabel(
				"¿El promedio de los aspirantes desvinculados graduados de secundario es mayor a ");
		lblelPromedioDe.setBounds(19, 217, 523, 16);
		panel_2.add(lblelPromedioDe);

		Answer1TF = new JTextField();
		Answer1TF.setBounds(548, 212, 65, 26);
		panel_2.add(Answer1TF);
		Answer1TF.setColumns(10);

		JLabel label = new JLabel("?");
		label.setBounds(617, 217, 14, 16);
		panel_2.add(label);

		JButton Calculate2B = new JButton("Calcular");
		Calculate2B.setBounds(634, 212, 95, 29);
		panel_2.add(Calculate2B);

		JLabel Answer2TF = new JLabel("Respuesta");
		Answer2TF.setForeground(new Color(178, 34, 34));
		Answer2TF.setBounds(741, 217, 78, 16);
		panel_2.add(Answer2TF);
		panel_1.setLayout(null);

		JButton MostrarATF = new JButton("Mostrar aspirantes");
		MostrarATF.setBounds(141, 6, 161, 29);
		panel_1.add(MostrarATF);

		JTextArea AspirantesTA = new JTextArea();
		AspirantesTA.setBounds(22, 47, 384, 130);
		panel_1.add(AspirantesTA);

		JLabel lblModificarLosDatos = new JLabel("Modificar los datos de un aspirante");
		lblModificarLosDatos.setBounds(113, 203, 236, 16);
		panel_1.add(lblModificarLosDatos);

		JLabel lblPosicinEnEl = new JLabel("Posición en el escalafon:");
		lblPosicinEnEl.setBounds(6, 231, 161, 16);
		panel_1.add(lblPosicinEnEl);

		ModifyPositionTF = new JTextField();
		ModifyPositionTF.setBounds(167, 226, 91, 26);
		panel_1.add(ModifyPositionTF);
		ModifyPositionTF.setColumns(10);

		JLabel lblNuevoDato = new JLabel("Nuevo dato:");
		lblNuevoDato.setBounds(280, 231, 106, 16);
		panel_1.add(lblNuevoDato);

		JLabel lblDatoAModiciar = new JLabel("Dato a modificar:");
		lblDatoAModiciar.setBounds(16, 263, 112, 16);
		panel_1.add(lblDatoAModiciar);

		JComboBox<String> ModifyCB = new JComboBox<String>();
		ModifyCB.setModel(new DefaultComboBoxModel<String>(new String[] { "-dato-", "Nombre", "DPI", "Promedio", "Tipo",
				"Desvinculado", "Nota de historia", "Nota de matemática", "Nota de español", "Nota de aptitud" }));
		ModifyCB.setBounds(125, 259, 138, 27);
		panel_1.add(ModifyCB);

		NewAspirerTF = new JTextField();
		NewAspirerTF.setBounds(280, 258, 126, 26);
		panel_1.add(NewAspirerTF);
		NewAspirerTF.setColumns(10);

		JButton ModifyB = new JButton("Modificar");
		ModifyB.setBounds(269, 297, 117, 29);
		panel_1.add(ModifyB);

		TypeDesCB = new JComboBox<String>();
		TypeDesCB.setModel(new DefaultComboBoxModel<String>(new String[] { "-seleccione un dato-" }));
		TypeDesCB.setBounds(22, 301, 145, 20);
		panel_1.add(TypeDesCB);
		
		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setBounds(389, 47, 17, 130);
		panel_1.add(scrollBar);

		JLabel ANameL = new JLabel("Nombre del aspirante:");

		NameTF = new JTextField();
		NameTF.setColumns(10);

		JLabel TipoL = new JLabel("Tipo:");

		JComboBox<String> TipoCB = new JComboBox<String>();
		TipoCB.setModel(new DefaultComboBoxModel<String>(
				new String[] { "-seleccione un tipo-", "Secundaria", "Bachillerato" }));

		JLabel lblDesvinculado = new JLabel("Desvinculado:");

		JRadioButton SiRB = new JRadioButton("Si");

		JRadioButton NoRB = new JRadioButton("No");

		JLabel lblPromedioEnSus = new JLabel("Promedio en sus últimos años de estudio:");

		AverageTF = new JTextField();
		AverageTF.setColumns(10);

		JLabel lblNotasEnLos = new JLabel("Notas en los Exámenes:");

		JLabel lblHistoria = new JLabel("Historia: ");

		NHistoriaTF = new JTextField();
		NHistoriaTF.setColumns(10);

		JLabel lblMatemtica = new JLabel("Matemática:");

		NMatematicaTF = new JTextField();
		NMatematicaTF.setEditable(false);
		NMatematicaTF.setEnabled(false);
		NMatematicaTF.setColumns(10);

		JLabel lblEspaol = new JLabel("Español:");

		NEspanolTF = new JTextField();
		NEspanolTF.setEditable(false);
		NEspanolTF.setEnabled(false);
		NEspanolTF.setColumns(10);

		JLabel lblAptitud = new JLabel("Aptitud:");

		NAptitudTF = new JTextField();
		NAptitudTF.setEditable(false);
		NAptitudTF.setEnabled(false);
		NAptitudTF.setColumns(10);

		AddB = new JButton("Agregar aspirante");

		JLabel lblDpi = new JLabel("DPI:");

		DPITF = new JTextField();
		DPITF.setColumns(10);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
				gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup().addContainerGap().addGroup(gl_panel
								.createParallelGroup(Alignment.LEADING).addGroup(gl_panel
										.createSequentialGroup().addComponent(ANameL).addGap(18).addComponent(NameTF,
												GroupLayout.PREFERRED_SIZE, 220, GroupLayout.PREFERRED_SIZE))
								.addComponent(lblNotasEnLos)
								.addGroup(gl_panel.createSequentialGroup().addGroup(gl_panel
										.createParallelGroup(Alignment.LEADING).addComponent(lblPromedioEnSus)
										.addGroup(gl_panel.createSequentialGroup().addGap(10).addGroup(gl_panel
												.createParallelGroup(Alignment.LEADING, false).addGroup(gl_panel
														.createSequentialGroup().addComponent(lblHistoria)
														.addPreferredGap(ComponentPlacement.RELATED,
																GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
														.addComponent(
																NHistoriaTF, GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
												.addGroup(gl_panel.createSequentialGroup()
														.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
																.addComponent(lblMatemtica).addComponent(lblEspaol)
																.addComponent(lblAptitud))
														.addPreferredGap(ComponentPlacement.RELATED)
														.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
																.addComponent(NAptitudTF, GroupLayout.PREFERRED_SIZE,
																		GroupLayout.DEFAULT_SIZE,
																		GroupLayout.PREFERRED_SIZE)
																.addComponent(NEspanolTF, GroupLayout.PREFERRED_SIZE,
																		GroupLayout.DEFAULT_SIZE,
																		GroupLayout.PREFERRED_SIZE)
																.addComponent(NMatematicaTF, GroupLayout.PREFERRED_SIZE,
																		GroupLayout.DEFAULT_SIZE,
																		GroupLayout.PREFERRED_SIZE))))))
										.addPreferredGap(ComponentPlacement.UNRELATED)
										.addGroup(gl_panel.createParallelGroup(Alignment.LEADING).addComponent(AddB)
												.addComponent(AverageTF, GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
								.addGroup(gl_panel.createSequentialGroup()
										.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING, false)
												.addGroup(gl_panel.createSequentialGroup().addComponent(lblDpi)
														.addPreferredGap(ComponentPlacement.UNRELATED)
														.addComponent(DPITF, 0, 0, Short.MAX_VALUE))
												.addGroup(Alignment.LEADING,
														gl_panel.createSequentialGroup().addComponent(lblDesvinculado)
																.addGap(34).addComponent(SiRB)))
										.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
												.addGroup(
														gl_panel.createSequentialGroup().addGap(28).addComponent(NoRB))
												.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
														.addGap(36).addComponent(TipoL).addGap(18).addComponent(TipoCB,
																GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE)))))
								.addGap(29)));
		gl_panel.setVerticalGroup(gl_panel.createParallelGroup(Alignment.LEADING).addGroup(gl_panel
				.createSequentialGroup().addContainerGap()
				.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE).addComponent(ANameL).addComponent(NameTF,
						GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(ComponentPlacement.UNRELATED)
				.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(TipoCB, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addComponent(TipoL).addComponent(lblDpi).addComponent(DPITF, GroupLayout.PREFERRED_SIZE,
								GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(ComponentPlacement.UNRELATED)
				.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE).addComponent(lblDesvinculado)
						.addComponent(SiRB).addComponent(NoRB))
				.addPreferredGap(ComponentPlacement.UNRELATED)
				.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE).addComponent(lblPromedioEnSus).addComponent(
						AverageTF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(ComponentPlacement.UNRELATED).addComponent(lblNotasEnLos)
				.addPreferredGap(ComponentPlacement.RELATED)
				.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE).addComponent(lblHistoria).addComponent(
						NHistoriaTF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(ComponentPlacement.UNRELATED)
				.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE).addComponent(lblMatemtica)
						.addComponent(NMatematicaTF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addComponent(AddB))
				.addPreferredGap(ComponentPlacement.UNRELATED)
				.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE).addComponent(lblEspaol).addComponent(
						NEspanolTF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(ComponentPlacement.UNRELATED)
				.addGroup(gl_panel.createParallelGroup(Alignment.LEADING).addComponent(lblAptitud).addComponent(
						NAptitudTF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addContainerGap(15, Short.MAX_VALUE)));
		panel.setLayout(gl_panel);
		contentPane.setLayout(gl_contentPane);
	}

	@SuppressWarnings("unused")
	private class Gatsby implements ActionListener, ItemListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == AddB) {
				String name = "";
				String DPI = "";
				boolean type = false;
				boolean desvinculado = false;
				double average = 0;
				double historia = 0;
				double mate = 0;
				double espanol = 0;
				double aptitud = 0;
				DecimalFormat decimal = new DecimalFormat(".##");

				// Nombre
				if (NameTF.getText() == "") {
					JOptionPane.showMessageDialog(null, "No ha ingresado un nombre", "Falta nombre",
							JOptionPane.WARNING_MESSAGE);
					return;
				}
				name = NameTF.getText();

				// DPI
				String tutu = DPITF.getText().trim();
				if (tutu.length() != 13) {
					JOptionPane.showMessageDialog(null, "El número de DPI no tiene 13 caracteres", "DPI no válido",
							JOptionPane.WARNING_MESSAGE);
					return;
				}
				try {
					@SuppressWarnings("unused")
					long wabble = Long.parseLong(DPITF.getText().trim());
				} catch (InputMismatchException e1) {
					JOptionPane.showMessageDialog(null, "El DPI no puede tener letras", "DPI no válido",
							JOptionPane.WARNING_MESSAGE);
				} finally {
					DPI = DPITF.getText().trim();
				}

				// Tipo
				if (TipoCB.getSelectedIndex() == 0) {
					JOptionPane.showMessageDialog(null, "No ha seleccionado un tipo", "Tipo no seleccionado",
							JOptionPane.WARNING_MESSAGE);
				} else if (TipoCB.getSelectedIndex() == 1) {
					type = false;
				} else if (TipoCB.getSelectedIndex() == 2) {
					type = true;
				}

				// Desvinculado
				if (SiRB.isSelected() == false && NoRB.isSelected() == false) {
					JOptionPane.showMessageDialog(null, "No ha definido si es desvinculado o no", "Desvinculado",
							JOptionPane.WARNING_MESSAGE);
				} else if (SiRB.isSelected() == true) {
					desvinculado = true;
				} else if (NoRB.isSelected() == true) {
					desvinculado = false;
				}

				// Promedio
				try {
					@SuppressWarnings("unused")
					double wabble = Double.parseDouble(DPITF.getText());
				} catch (InputMismatchException e1) {
					if (AverageTF.getText() == "") {
						JOptionPane.showMessageDialog(null, "No ha ingresado un promedio", "No hay promedio",
								JOptionPane.WARNING_MESSAGE);
					} else {
						JOptionPane.showMessageDialog(null, "No ha ingresado un promedio válido", "Promedio no válido",
								JOptionPane.WARNING_MESSAGE);
					}
					return;
				} finally {
					double num = Double.parseDouble(AverageTF.getText());
					average = Double.parseDouble(decimal.format(num));
				}

				// Historia
				try {
					@SuppressWarnings("unused")
					double wabble = Double.parseDouble(NHistoriaTF.getText());
				} catch (InputMismatchException e1) {
					if (NHistoriaTF.getText() == "") {
						JOptionPane.showMessageDialog(null, "No ha ingresado una nota de historia", "No hay nota",
								JOptionPane.WARNING_MESSAGE);
					} else {
						JOptionPane.showMessageDialog(null, "No ha ingresado una nota de historia válida",
								"Nota no válida", JOptionPane.WARNING_MESSAGE);
					}
					return;
				} finally {
					double num = Double.parseDouble(NHistoriaTF.getText());
					historia = Double.parseDouble(decimal.format(num));
				}

				// Matematica
				try {
					@SuppressWarnings("unused")
					double wabble = Double.parseDouble(NMatematicaTF.getText());
				} catch (InputMismatchException e1) {
					if (NMatematicaTF.getText() == "") {
						JOptionPane.showMessageDialog(null, "No ha ingresado una nota de matemática", "No hay nota",
								JOptionPane.WARNING_MESSAGE);
					} else {
						JOptionPane.showMessageDialog(null, "No ha ingresado una nota de matemática válida",
								"Nota no válida", JOptionPane.WARNING_MESSAGE);
					}
					return;
				} finally {
					double num = Double.parseDouble(NMatematicaTF.getText());
					mate = Double.parseDouble(decimal.format(num));
				}

				// Español
				try {
					@SuppressWarnings("unused")
					double wabble = Double.parseDouble(NEspanolTF.getText());
				} catch (InputMismatchException e1) {
					if (NEspanolTF.getText() == "") {
						JOptionPane.showMessageDialog(null, "No ha ingresado una nota de español", "No hay nota",
								JOptionPane.WARNING_MESSAGE);
					} else {
						JOptionPane.showMessageDialog(null, "No ha ingresado una nota de español válida",
								"Nota no válida", JOptionPane.WARNING_MESSAGE);
					}
					return;
				} finally {
					double num = Double.parseDouble(NEspanolTF.getText());
					espanol = Double.parseDouble(decimal.format(num));
				}

				// Aptitud
				try {
					@SuppressWarnings("unused")
					double wabble = Double.parseDouble(NAptitudTF.getText());
				} catch (InputMismatchException e1) {
					if (NAptitudTF.getText() == "") {
						JOptionPane.showMessageDialog(null, "No ha ingresado una nota para la prueba de aptitud",
								"No hay nota", JOptionPane.WARNING_MESSAGE);
					} else {
						JOptionPane.showMessageDialog(null, "No ha ingresado una nota para la prueba de aptitud válida",
								"Nota no válida", JOptionPane.WARNING_MESSAGE);
					}
					return;
				} finally {
					double num = Double.parseDouble(NAptitudTF.getText());
					aptitud = Double.parseDouble(decimal.format(num));
				}

				// Agrega a la base de datos
				if (type == false) {
					hallelujah.addSecondary(name, DPI, average, type, desvinculado, historia, mate, espanol, aptitud);
				} else if (type == true) {
					hallelujah.addBachelor(name, DPI, average, type, desvinculado, historia);
				}
			}

			// Mostrar aspirantes
			else if (e.getSource() == MostrarB) {
				AspirantesTA.setText(hallelujah.DisplayAspirers());
			}

			// Modificar un dato
			else if (e.getSource() == ModifyB) {
				try {
					hallelujah.FindAspirer(Integer.parseInt(ModifyPositionTF.getText()));
				} catch (IndexOutOfBoundsException e1) {
					JOptionPane.showMessageDialog(null, "No ha ingresado una posición válida", "Posición no válida",
							JOptionPane.WARNING_MESSAGE);
					return;
				} finally {
					if (hallelujah.FindAspirer(Integer.parseInt(ModifyPositionTF.getText())).Type == false) {
						switch (ModifyCB.getSelectedIndex()) {
						case 1:
							hallelujah.ModifySecondary(Integer.parseInt(ModifyPositionTF.getText()),
									ModifyCB.getSelectedIndex(), NewAspirerTF.getText(), "", 0, false, false, 0, 0, 0,
									0);
							break;
						case 2:
							hallelujah.ModifySecondary(Integer.parseInt(ModifyPositionTF.getText()),
									ModifyCB.getSelectedIndex(), "", NewAspirerTF.getText(), 0, false, false, 0, 0, 0,
									0);
							break;
						case 3:
							hallelujah.ModifySecondary(Integer.parseInt(ModifyPositionTF.getText()),
									ModifyCB.getSelectedIndex(), "", "", Double.parseDouble(NewAspirerTF.getText()),
									false, false, 0, 0, 0, 0);
							break;
						case 4:
							hallelujah.ModifySecondary(Integer.parseInt(ModifyPositionTF.getText()),
									ModifyCB.getSelectedIndex(), "", "", Double.parseDouble(NewAspirerTF.getText()),
									false, false, 0, 0, 0, 0);
							break;
						case 5:
							if (TypeDesCB.getSelectedIndex() == 1) {
								hallelujah.ModifySecondary(Integer.parseInt(ModifyPositionTF.getText()),
										ModifyCB.getSelectedIndex(), "", "", 0, false, false, 0, 0, 0, 0);
							} else if (TypeDesCB.getSelectedIndex() == 2) {
								hallelujah.ModifySecondary(Integer.parseInt(ModifyPositionTF.getText()),
										ModifyCB.getSelectedIndex(), "", "", 0, true, false, 0, 0, 0, 0);
							}
							break;
						case 6:
							if (TypeDesCB.getSelectedIndex() == 1) {
								hallelujah.ModifySecondary(Integer.parseInt(ModifyPositionTF.getText()),
										ModifyCB.getSelectedIndex(), "", "", 0, false, true, 0, 0, 0, 0);
							} else if (TypeDesCB.getSelectedIndex() == 2) {
								hallelujah.ModifySecondary(Integer.parseInt(ModifyPositionTF.getText()),
										ModifyCB.getSelectedIndex(), "", "", 0, true, false, 0, 0, 0, 0);
							}
							break;
						case 7:
							hallelujah.ModifySecondary(Integer.parseInt(ModifyPositionTF.getText()),
									ModifyCB.getSelectedIndex(), "", "", 0, false, false,
									Double.parseDouble(NewAspirerTF.getText()), 0, 0, 0);
							break;
						case 8:
							hallelujah.ModifySecondary(Integer.parseInt(ModifyPositionTF.getText()),
									ModifyCB.getSelectedIndex(), "", "", 0, false, false, 0,
									Double.parseDouble(NewAspirerTF.getText()), 0, 0);
							break;
						case 9:
							hallelujah.ModifySecondary(Integer.parseInt(ModifyPositionTF.getText()),
									ModifyCB.getSelectedIndex(), "", "", 0, false, false, 0, 0,
									Double.parseDouble(NewAspirerTF.getText()), 0);
							break;
						case 10:
							hallelujah.ModifySecondary(Integer.parseInt(ModifyPositionTF.getText()),
									ModifyCB.getSelectedIndex(), "", "", 0, false, false, 0, 0, 0,
									Double.parseDouble(NewAspirerTF.getText()));
							break;
						}
					} else {
						switch (ModifyCB.getSelectedIndex()) {
						case 1:
							hallelujah.ModifyBachelor(Integer.parseInt(ModifyPositionTF.getText()),
									ModifyCB.getSelectedIndex(), NewAspirerTF.getText(), "", 0, false, false,
									0);
							break;
						case 2:
							hallelujah.ModifyBachelor(Integer.parseInt(ModifyPositionTF.getText()),
									ModifyCB.getSelectedIndex(), "", NewAspirerTF.getText(), 0, false, false,
									0);
							break;
						case 3:
							hallelujah.ModifyBachelor(Integer.parseInt(ModifyPositionTF.getText()),
									ModifyCB.getSelectedIndex(), "", "", Double.parseDouble(NewAspirerTF.getText()),
									false, false, 0);
							break;
						case 4:
							hallelujah.ModifyBachelor(Integer.parseInt(ModifyPositionTF.getText()),
									ModifyCB.getSelectedIndex(), "", "", Double.parseDouble(NewAspirerTF.getText()),
									false, false, 0);
							break;
						case 5:
							if (TypeDesCB.getSelectedIndex() == 1) {
								hallelujah.ModifyBachelor(Integer.parseInt(ModifyPositionTF.getText()),
										ModifyCB.getSelectedIndex(), "", "", 0, false, false, 0);
							} else if (TypeDesCB.getSelectedIndex() == 2) {
								hallelujah.ModifyBachelor(Integer.parseInt(ModifyPositionTF.getText()),
										ModifyCB.getSelectedIndex(), "", "", 0, true, false, 0);
							}
							break;
						case 6:
							if (TypeDesCB.getSelectedIndex() == 1) {
								hallelujah.ModifyBachelor(Integer.parseInt(ModifyPositionTF.getText()),
										ModifyCB.getSelectedIndex(), "", "", 0, false, true, 0);
							} else if (TypeDesCB.getSelectedIndex() == 2) {
								hallelujah.ModifyBachelor(Integer.parseInt(ModifyPositionTF.getText()),
										ModifyCB.getSelectedIndex(), "", "", 0, true, false, 0);
							}
							break;
						case 7:
							hallelujah.ModifyBachelor(Integer.parseInt(ModifyPositionTF.getText()),
									ModifyCB.getSelectedIndex(), "", "", 0, false, false,
									Double.parseDouble(NewAspirerTF.getText()));
							break;
						}
					}
				}
			}
			
			//Mostrar un aspirante 
			else if (e.getSource()==MostrarATF) {
				try {
					hallelujah.FindAspirer(Integer.parseInt(ModifyPositionTF.getText()));
				} catch (IndexOutOfBoundsException e1) {
					JOptionPane.showMessageDialog(null, "No ha ingresado una posición válida", "Posición no válida",
							JOptionPane.WARNING_MESSAGE);
					return;
				} finally {
					ShowAspirerTA.setText(hallelujah.FindAspirer(Integer.parseInt(PositionTF.getText())).toString());
				}
			}
			
			//Calcular si el 50% de graduados desvinculados de bachillerato tiene un promedio mayor a 80
			else if (e.getSource()==Calculate1B) {
				Answer1.setText(hallelujah.High80());
			}
			
			//Calcular si el promedio de los alumnos desvinculados graduados de secundaria es mayor a uno establecido por el usuario
			else if (e.getSource()==Calculate2B) {
				try {
					Double.parseDouble(Answer1TF.getText());
				} catch (IndexOutOfBoundsException e1) {
					JOptionPane.showMessageDialog(null, "No ha ingresado un número válido", "Número no válido",
							JOptionPane.WARNING_MESSAGE);
					return;
				} finally {
					Answer2TF.setText(hallelujah.BetterThan(Double.parseDouble(Answer1TF.getText())));
				}
			}
		}

		@Override
		public void itemStateChanged(ItemEvent e) {
			if (e.getSource() == TipoCB) {
				if (TipoCB.getSelectedIndex() == 1) {
					NMatematicaTF.setEditable(true);
					NMatematicaTF.setEnabled(true);
					NEspanolTF.setEditable(true);
					NEspanolTF.setEnabled(true);
					NAptitudTF.setEditable(true);
					NAptitudTF.setEnabled(true);
				} else if (TipoCB.getSelectedIndex() == 0) {
					NMatematicaTF.setEditable(false);
					NMatematicaTF.setEnabled(false);
					NEspanolTF.setEditable(false);
					NEspanolTF.setEnabled(false);
					NAptitudTF.setEditable(false);
					NAptitudTF.setEnabled(false);
				} else if (TipoCB.getSelectedIndex() == 2) {
					NMatematicaTF.setEditable(false);
					NMatematicaTF.setEnabled(false);
					NEspanolTF.setEditable(false);
					NEspanolTF.setEnabled(false);
					NAptitudTF.setEditable(false);
					NAptitudTF.setEnabled(false);
				}
			} else if (e.getSource() == SiRB) {
				NoRB.setEnabled(false);
				NoRB.setSelected(false);
			} else if (e.getSource() == NoRB) {
				SiRB.setEnabled(false);
				SiRB.setEnabled(false);
			} else if (e.getSource() == ModifyCB) {
				if (ModifyCB.getSelectedIndex() == 5) {
					TypeDesCB.setModel(new DefaultComboBoxModel<String>(
							new String[] { "-seleccione un tipo-", "Secundaria", "Bachillerato" }));
				} else if (ModifyCB.getSelectedIndex() == 6) {
					TypeDesCB.setModel(new DefaultComboBoxModel<String>(
							new String[] { "-seleccione un tipo-", "Desvinculado", "No desvinculado" }));
				}

				if (ModifyCB.getSelectedIndex() == 5 || ModifyCB.getSelectedIndex() == 6) {
					NewAspirerTF.setEnabled(false);
					NewAspirerTF.setEditable(false);
				} else {
					NewAspirerTF.setEnabled(true);
					NewAspirerTF.setEditable(true);
				}
			}
		}

	}
}
