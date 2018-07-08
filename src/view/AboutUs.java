package view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import java.awt.Font;

public class AboutUs extends JInternalFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AboutUs frame = new AboutUs();
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
	public AboutUs() {
		setResizable(true);
		setTitle("关于我们");
		setIconifiable(true);
		setClosable(true);
		setBounds(100, 100, 663, 509);
		getContentPane().setLayout(null);
		
		JLabel CopyrightLabel = new JLabel("Copyright  ©  2018   WJLGH corporation .All rights reserved. ");
		CopyrightLabel.setBounds(117, 442, 496, 18);
		getContentPane().add(CopyrightLabel);
		
		JLabel makerLabel = new JLabel("制作人员：");
		makerLabel.setFont(new Font("黑体", Font.BOLD, 22));
		makerLabel.setBounds(70, 90, 115, 38);
		getContentPane().add(makerLabel);
		
		JLabel impleHeadLabel = new JLabel("功能实现：");
		impleHeadLabel.setFont(new Font("宋体", Font.PLAIN, 20));
		impleHeadLabel.setBounds(231, 251, 100, 29);
		getContentPane().add(impleHeadLabel);
		
		JLabel impleLabel2 = new JLabel("李东");
		impleLabel2.setFont(new Font("宋体", Font.PLAIN, 20));
		impleLabel2.setBounds(353, 294, 96, 29);
		getContentPane().add(impleLabel2);
		
		JLabel impleLabel3 = new JLabel("王京龙");
		impleLabel3.setFont(new Font("宋体", Font.PLAIN, 20));
		impleLabel3.setBounds(353, 333, 96, 29);
		getContentPane().add(impleLabel3);
		
		JLabel impleLabel1 = new JLabel("宋培培");
		impleLabel1.setFont(new Font("宋体", Font.PLAIN, 20));
		impleLabel1.setBounds(353, 252, 96, 29);
		getContentPane().add(impleLabel1);
		
		JLabel dbdesignHeadLabel = new JLabel("数据库设计：");
		dbdesignHeadLabel.setFont(new Font("宋体", Font.PLAIN, 20));
		dbdesignHeadLabel.setBounds(204, 167, 120, 29);
		getContentPane().add(dbdesignHeadLabel);
		
		JLabel dbdesignerLabel1 = new JLabel("李东");
		dbdesignerLabel1.setFont(new Font("宋体", Font.PLAIN, 20));
		dbdesignerLabel1.setBounds(350, 167, 96, 29);
		getContentPane().add(dbdesignerLabel1);
		
		JLabel dbdesignerLabel2 = new JLabel("王京龙");
		dbdesignerLabel2.setFont(new Font("宋体", Font.PLAIN, 20));
		dbdesignerLabel2.setBounds(348, 209, 96, 29);
		getContentPane().add(dbdesignerLabel2);
		
		JLabel artHeadLabel = new JLabel("美工：");
		artHeadLabel.setFont(new Font("宋体", Font.PLAIN, 20));
		artHeadLabel.setBounds(263, 125, 60, 29);
		getContentPane().add(artHeadLabel);
		
		JLabel artLabel = new JLabel("宋培培");
		artLabel.setFont(new Font("宋体", Font.PLAIN, 20));
		artLabel.setBounds(349, 125, 96, 29);
		getContentPane().add(artLabel);
		
		JLabel contactHead = new JLabel("联系我们：");
		contactHead.setBounds(204, 386, 81, 18);
		getContentPane().add(contactHead);
		
		JLabel qqMailLabel = new JLabel("1179315470@qq.com");
		qqMailLabel.setBounds(309, 386, 153, 18);
		getContentPane().add(qqMailLabel);
		
		JLabel gitHeadLabel = new JLabel("项目Git地址：");
		gitHeadLabel.setFont(new Font("黑体", Font.BOLD, 22));
		gitHeadLabel.setBounds(70, 39, 153, 38);
		getContentPane().add(gitHeadLabel);
		
		JLabel gitLinkLabel = new JLabel("https://github.com/WJLGH/studyEnglish");
		gitLinkLabel.setBounds(231, 52, 314, 25);
		getContentPane().add(gitLinkLabel);
		setVisible(true);
	}
}
