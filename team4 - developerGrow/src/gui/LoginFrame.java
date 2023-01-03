package gui;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.print.attribute.standard.Sides;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;

public class LoginFrame extends JFrame{

   private JFrame frame;
   private JTextField txtId;
private JButton signupbtn;
private JButton loginbtn;
private JPasswordField passwordField;
private JLabel lblNewLabel_1;

   public static void main(String[] args) {
      EventQueue.invokeLater(new Runnable() {
         public void run() {
            try {
               LoginFrame window = new LoginFrame();
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
   
   public LoginFrame() {
      frame = new JFrame();
      frame.setBounds(100, 100, 500, 500);
      frame.getContentPane().setLayout(null);
      
      JPanel panel = new JPanel();
      panel.setBounds(60, 200, 362, 115);
      frame.getContentPane().add(panel);
      panel.setLayout(null);
      
      txtId = new JTextField();
      txtId.setFont(new Font("굴림", Font.PLAIN, 24));
      txtId.setText("id");
      txtId.setBounds(12, 10, 338, 41);
      panel.add(txtId);
      txtId.setColumns(10);
      
      passwordField = new JPasswordField();
      passwordField.setBounds(12, 61, 338, 35);
      panel.add(passwordField);
      
      JLabel lblNewLabel = new JLabel("개발자 키우기");
      lblNewLabel.setFont(new Font("휴먼둥근헤드라인", Font.BOLD, 36));
      lblNewLabel.setBounds(39, 69, 267, 63);
      frame.getContentPane().add(lblNewLabel);
      
      signupbtn = new JButton("회원가입");
      signupbtn.setFont(new Font("맑은 고딕", Font.BOLD, 18));
      signupbtn.setBounds(94, 347, 139, 63);
      frame.getContentPane().add(signupbtn);
      signupbtn.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			SignUpFrame s1 = new SignUpFrame();
		}
	});
      
      loginbtn = new JButton("로그인");
      loginbtn.setFont(new Font("맑은 고딕", Font.BOLD, 18));
      loginbtn.setBounds(245, 347, 139, 63);
      frame.getContentPane().add(loginbtn);
      
      lblNewLabel_1 = new JLabel("");
      lblNewLabel_1.setIcon(new ImageIcon("로그인.png"));
      lblNewLabel_1.setBounds(299, 24, 161, 166);
      frame.getContentPane().add(lblNewLabel_1);
      loginbtn.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			MainFrame s1 = new MainFrame();
			s1.setVisible(true);
		}
	});
   }
}