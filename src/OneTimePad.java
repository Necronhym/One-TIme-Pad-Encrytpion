package OneTimePad;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class OneTimePad
	{
		public static void main(String args[])
			{
				Window Win = new Window();
			}
	}
class Window extends JFrame
	{
		JTextField Input;
		JTextField Cypher;
		JTextField Output;
		String InputText;
		String CypherText;
		String OutputText;

		ButtonGroup Group;
		JRadioButton RadioEncrypt;	
		JRadioButton RadioDecrypt;	
		class WindowHandler implements ActionListener
			{
				public void actionPerformed(ActionEvent e)
					{
						InputText = Input.getText().toLowerCase();
						CypherText = Cypher.getText().toLowerCase();
						String ToOutput = "";
						if(CypherText.length() < InputText.length())
							{
								Output.setText("Error cypher must be longer then input");
							}
						else if(RadioEncrypt.isSelected() == true)
							{
								for(int i = 0; i < InputText.length(); i++)
									{
										ToOutput = ToOutput + (char)((((int)InputText.charAt(i)-97) + ((int)CypherText.charAt(i)-97))+97);
									}
								Output.setText(ToOutput);
							}
						else
							{
								for(int i = 0; i < InputText.length(); i++)
									{
										ToOutput = ToOutput + (char)((((int)InputText.charAt(i)-97) - ((int)CypherText.charAt(i)-97))+97);
									}
								Output.setText(ToOutput);
							}
					}
			}
		Window()
			{
				setTitle("Cypher");
				setSize(600, 270);
				setLayout(null);
				JLabel InputLabel = new JLabel("Input:");
				JLabel CypherLabel = new JLabel("Cypher:");
				JLabel OutputLabel = new JLabel("Output:");
				
				Input = new JTextField("");
				Cypher = new JTextField("");
				Output = new JTextField("");
				
				InputText = "";
				CypherText = "";
				OutputText = "";
				
				Input.setBounds(120, 50, 300, 30);
				InputLabel.setBounds(50, 48, 80, 30);
				add(Input);
				add(InputLabel);

				Cypher.setBounds(120, 100, 300, 30);
				CypherLabel.setBounds(50, 98, 80, 30);
				add(Cypher);
				add(CypherLabel);

				Output.setBounds(120, 150, 300, 30);
				OutputLabel.setBounds(50, 148, 80, 30);
				add(Output);
				add(OutputLabel);
				Output.setEditable(false);
				
				Group = new ButtonGroup();
				RadioEncrypt = new JRadioButton("Encrypt");
				RadioDecrypt = new JRadioButton("Decrypt");
				RadioEncrypt.setSelected(true);
				RadioDecrypt.setSelected(false);
				Group.add(RadioEncrypt);
				Group.add(RadioDecrypt);
				RadioEncrypt.setBounds(440, 48, 80, 30);
				RadioDecrypt.setBounds(440, 98, 80, 30);
				add(RadioEncrypt);
				add(RadioDecrypt);
			
				Input.addActionListener(new WindowHandler());
				Cypher.addActionListener(new WindowHandler());
				setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				setVisible(true);
			}
	}
