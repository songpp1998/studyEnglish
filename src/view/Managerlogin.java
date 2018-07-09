package view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

import dao.ManagerDao;
import model.ManagerBean;
import util.CharacterUtil;
import util.stringutil;

public class Managerlogin extends JFrame {

	private JPanel contentPane;
	private JTextField usernametext;
	private JPasswordField passwordtext;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Managerlogin frame = new Managerlogin();
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
	public Managerlogin() {
		setResizable(false);
		setTitle("\u7BA1\u7406\u5458\u767B\u9646");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(600, 320, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("\u5927\u5B66\u82F1\u8BED\u8BCD\u6C47\u5B66\u4E60\u7CFB\u7EDF");
		lblNewLabel.setIcon(new ImageIcon(Managerlogin.class.getResource("/image/logo.png")));
		lblNewLabel.setFont(new Font("����", Font.BOLD, 24));
		
		JLabel lblNewLabel_1 = new JLabel("管理员名");
		lblNewLabel_1.setIcon(new ImageIcon(Managerlogin.class.getResource("/image/modify.png")));
		lblNewLabel_1.setFont(new Font("����", Font.BOLD, 14));
		
		JLabel label = new JLabel("\u5BC6  \u7801");
		label.setIcon(new ImageIcon(Managerlogin.class.getResource("/image/password.png")));
		label.setFont(new Font("����", Font.BOLD, 14));
		
		usernametext = new JTextField();
		usernametext.setColumns(10);
		
		passwordtext = new JPasswordField();
		
		JButton btnNewButton = new JButton("\u767B\u9646");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loginActionPerformed(e);
			}
		});
		
		JButton btnNewButton_1 = new JButton("\u91CD\u7F6E");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetValueActionPerformed(e);
			}
		});
		
		JButton backBtn = new JButton("返回");
		backBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				backActionPerformed(e);
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(74, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
							.addGroup(gl_contentPane.createSequentialGroup()
								.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE)
								.addGap(18)
								.addComponent(usernametext, GroupLayout.PREFERRED_SIZE, 178, GroupLayout.PREFERRED_SIZE))
							.addGroup(gl_contentPane.createSequentialGroup()
								.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
									.addComponent(btnNewButton)
									.addComponent(label, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
									.addGroup(gl_contentPane.createSequentialGroup()
										.addGap(18)
										.addComponent(passwordtext))
									.addGroup(gl_contentPane.createSequentialGroup()
										.addGap(46)
										.addComponent(btnNewButton_1)
										.addPreferredGap(ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
										.addComponent(backBtn, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE))))))
					.addGap(42))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(19)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
					.addGap(45)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
						.addComponent(usernametext, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(26)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(label, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
						.addComponent(passwordtext, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton)
						.addComponent(btnNewButton_1)
						.addComponent(backBtn))
					.addGap(26))
		);
		contentPane.setLayout(gl_contentPane);
		this.setVisible(true);
	}

	private void backActionPerformed(ActionEvent e) {
		dispose();
		new Logonform();
	}

	private void loginActionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String userName = this.usernametext.getText();
		String password = new String(this.passwordtext.getPassword());
		if(CharacterUtil.isEmpty(userName)) {
			JOptionPane.showMessageDialog(null, "管理员名不能为空");
			return;
		}
		if(CharacterUtil.isEmpty(password)) {
			JOptionPane.showMessageDialog(null, "密码不能为空");
			return;
		}
		
		ManagerBean manager = null;
		try {
			manager = ManagerDao.checkLogin(userName, password);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		if(manager == null) {
			JOptionPane.showMessageDialog(null, "管理员名或密码错误");
		}
		else {
			this.dispose();
			new Managermainfrm(manager);
		}
	}

	private void resetValueActionPerformed(ActionEvent evt) {
		// TODO Auto-generated method stub
		this.usernametext.setText("");
		this.passwordtext.setText("");
		
	}
}
