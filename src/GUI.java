import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JRadioButton;
import javax.swing.JButton;

public class GUI extends JFrame {

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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 836, 644);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JPanel panel = new JPanel();
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 430, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(380, Short.MAX_VALUE)));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 297, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(298, Short.MAX_VALUE)));

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
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(gl_panel.createParallelGroup(Alignment.LEADING).addGroup(gl_panel
				.createSequentialGroup().addContainerGap()
				.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup().addComponent(ANameL).addGap(18).addComponent(NameTF,
								GroupLayout.PREFERRED_SIZE, 220, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup().addComponent(TipoL).addGap(18).addComponent(TipoCB,
								GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup().addComponent(lblDesvinculado).addGap(34)
								.addComponent(SiRB).addGap(28).addComponent(NoRB))
						.addComponent(lblNotasEnLos)
						.addGroup(gl_panel.createSequentialGroup()
								.addGroup(gl_panel.createParallelGroup(Alignment.LEADING).addComponent(lblPromedioEnSus)
										.addGroup(gl_panel.createSequentialGroup().addGap(10).addGroup(gl_panel
												.createParallelGroup(Alignment.LEADING, false).addGroup(
														gl_panel.createSequentialGroup().addComponent(lblHistoria)
																.addPreferredGap(ComponentPlacement.RELATED,
																		GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
																.addComponent(
																		NHistoriaTF, GroupLayout.PREFERRED_SIZE,
																		GroupLayout.DEFAULT_SIZE,
																		GroupLayout.PREFERRED_SIZE))
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
								.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_panel.createSequentialGroup()
												.addPreferredGap(ComponentPlacement.UNRELATED).addComponent(AverageTF,
														GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
														GroupLayout.PREFERRED_SIZE))
										.addGroup(gl_panel.createSequentialGroup().addGap(40).addComponent(AddB)))))
				.addContainerGap(64, Short.MAX_VALUE)));
		gl_panel.setVerticalGroup(gl_panel.createParallelGroup(Alignment.LEADING).addGroup(gl_panel
				.createSequentialGroup().addContainerGap()
				.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE).addComponent(ANameL).addComponent(NameTF,
						GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(ComponentPlacement.UNRELATED)
				.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE).addComponent(TipoL).addComponent(TipoCB,
						GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
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
				.addContainerGap(78, Short.MAX_VALUE)));
		panel.setLayout(gl_panel);
		contentPane.setLayout(gl_contentPane);
	}

	private class Gatsby implements ActionListener, ItemListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource()==AddB) {
				String name;
				String DPI;
				boolean type;
				boolean desvinculado;
				double average;
				
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
				} else if (TipoCB.getSelectedIndex()==0) {
					NMatematicaTF.setEditable(false);
					NMatematicaTF.setEnabled(false);
					NEspanolTF.setEditable(false);
					NEspanolTF.setEnabled(false);
					NAptitudTF.setEditable(false);
					NAptitudTF.setEnabled(false);
				} else if (TipoCB.getSelectedIndex()==2) {
					NMatematicaTF.setEditable(false);
					NMatematicaTF.setEnabled(false);
					NEspanolTF.setEditable(false);
					NEspanolTF.setEnabled(false);
					NAptitudTF.setEditable(false);
					NAptitudTF.setEnabled(false);
				}
			}
		}

	}
}
