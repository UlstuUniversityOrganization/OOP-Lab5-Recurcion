import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JSpinner;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JLabel;

public class Source {

	private JFrame frame;
	private RecurtionPattern recursion;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Source window = new Source();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		

	}

	/**
	 * Create the application.
	 */
	public Source() {
		initialize();	
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 520, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		recursion = new RecurtionPattern();
		recursion.setBackground(Color.WHITE);
		recursion.setForeground(Color.DARK_GRAY);
		recursion.setBounds(0, 0, 260, 261);
		recursion.setVisible(true);
		frame.getContentPane().add(recursion);
		recursion.setLayout(null);
		
		JSpinner virticesCountSpinner = new JSpinner();
		virticesCountSpinner.setBounds(396, 196, 83, 20);
		virticesCountSpinner.setValue(recursion.spikesCount);
		frame.getContentPane().add(virticesCountSpinner);

		

		
		JButton drawButton = new JButton("Draw");
		drawButton.setBounds(335, 227, 89, 23);


		frame.getContentPane().add(drawButton);
		
		JLabel verticesCountLabel = new JLabel("Vertices count");
		verticesCountLabel.setBounds(288, 199, 98, 14);
		frame.getContentPane().add(verticesCountLabel);
		
		JLabel depthLabel = new JLabel("Depth");
		depthLabel.setBounds(322, 168, 46, 14);
		frame.getContentPane().add(depthLabel);
		
		JSpinner depthSpinner = new JSpinner();
		depthSpinner.setBounds(396, 165, 83, 20);
		depthSpinner.setValue(recursion.depth);
		frame.getContentPane().add(depthSpinner);
		
		drawButton.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				recursion.spikesCount = (int)virticesCountSpinner.getValue();
				recursion.depth = (int)depthSpinner.getValue(); 
				recursion.repaint();
			}
			
		});
	}
}
