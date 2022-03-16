import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextPane;

public class Source {

	private JFrame frame;
	private JLabel inputLabel;
	private JTextField accuracy;
	private JTextPane answerTextPane;
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
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JTextField inputTextField = new JTextField();
		inputTextField.setBounds(100, 54, 86, 20);
		frame.getContentPane().add(inputTextField);
		inputTextField.setColumns(10);
		
		answerTextPane = new JTextPane();
		answerTextPane.setBounds(150, 141, 112, 20);
		frame.getContentPane().add(answerTextPane);
		
		inputLabel = new JLabel("Input");
		inputLabel.setBounds(122, 39, 86, 14);
		frame.getContentPane().add(inputLabel);
		
		accuracy = new JTextField();
		accuracy.setBounds(238, 54, 86, 20);
		frame.getContentPane().add(accuracy);
		accuracy.setColumns(10);
		
		JLabel accuracyLabel = new JLabel("Accuracy");
		accuracyLabel.setBounds(258, 39, 82, 14);
		frame.getContentPane().add(accuracyLabel);
		
		
		JButton calculateButton = new JButton("Calculate");
		calculateButton.setBounds(164, 98, 89, 23);

		calculateButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				double input = Double.parseDouble(inputTextField.getText());
				double accuracyValue = Double.parseDouble(accuracy.getText());
				double answer = recurciveFunction(input, accuracyValue);
				answerTextPane.setText(Double.toString(answer));
			}	
		});
		frame.getContentPane().add(calculateButton);
		
	}
	
	public double function(double x, double m) {
		return Math.pow(x, 2 * m - 1) / (2 * m - 1);
	}
	
	public double recurciveFunction(double x, double accuracy) {
		if(accuracy <= 1)
		{
			return function(x, accuracy) * 2;
		}
		return recurciveFunction(x, accuracy - 1) + function(x, accuracy) * 2;
	}

}
