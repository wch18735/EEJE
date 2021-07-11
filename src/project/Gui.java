package project;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import KwangMat.KGradeDao;
import KwangMat.KGradeService;
import KwangMat.KMemberDao;
import KwangMat.KMemberDaoTest;
import KwangMat.KService;
import KwangMat.Member;
import KwangMat.Menu;
import KwangMat.MenuDao;
import KwangMat.PMember;
import KwangMat.PMemberDao;
import KwangMat.PMemberDaoTest;
import KwangMat.PService;
import KwangMat.RandPDao;
import KwangMat.Restaurant;
import KwangMat.RestaurantDao;
import KwangMat.RestaurantService;
import project.ImageTest.ImageBackGround;

public class Gui extends JFrame implements ActionListener, MouseListener {
	KService k = new KService();
	PService p = new PService();
	PMemberDao pd = PMemberDao.getInstance();
	RestaurantDao r = RestaurantDao.getInstance();
	MenuDao m = MenuDao.getInstance();
	RandPDao rpd = RandPDao.getInstance();

	ImageIcon cover = new ImageIcon("image/cover.PNG");
	ImageIcon rname = new ImageIcon("image/rname.PNG");
	ImageIcon signin = new ImageIcon("image/signin.PNG");
	ImageIcon map = new ImageIcon("image/map.png");
	ImageIcon icon;

	String stremail, pstremail;
	int count = 0;

	Font font1 = new Font("���ʷҵ���", Font.BOLD, 50);
	
	JTextField id, password;
	JButton bt1, bt2;
	JPanel cp, sp;
	JPanel p1, p2, p3, p4, p5, p6, p7, p8, cardP;
	JComboBox<String> cb1;

	JTextField email, pw, pwcheck, nickname;
	JButton emailcheck, nicknamecheck, complete, backbt1;
	JLabel emaillabel, pwlabel, pwchecklabel, nicknamelabel;
	JPanel emailp, pwp, pwcheckp, nicknamep, completep;
	JComboBox<String> cb2;

	JPanel searchP, mapP, rtitleP, stitleP, mtitleP;
	JTextField search;
	JTable table;
	JButton backbt2;

	JLabel location, telnum, score;
	JComboBox<String> rate;
	JPanel rateP, infoP;
	JButton ratebt, backbt3;
	JScrollPane inScrollPane;
	String rwname[], rhpnum[];

	JTable sctable;
	JButton backbt5, createbt, editbt, removebt;
	JPanel sbtP;
	JScrollPane scscrollPane;

	JTextField seditrname, seditloc, sedittel;
	JLabel slabrname, slabloc, slabtel;
	JButton seditcombt, bbt1;
	JPanel se1, se2, se21, se22, se3, se4;

	JTextField editloc, edittel, editrname, deletem;
	JLabel img, labloc, labtel, labscore, labrname;
	JTable editTable;
	JButton addbt, delbt, editcombt, bbt2;
	JPanel e1, e2, e21, e22, e3, e31, e32, e322, e4, titleP, deleteP;
	JScrollPane editScroll;

	CardLayout card = new CardLayout();

	Object rnamestr, rnamestr2, dnamestr;
	JLabel slocation, stelnum, sscore;
	JPanel p31, p41;
	JTextField ssearch, delrname;
	JTable inTable;
	JPanel ssearchP, smapP;
	JButton sbackbt2, backbt;
	JTable stable, sinTable;

	JPanel addmP, removemP;

	public void setUIFont(javax.swing.plaf.FontUIResource f) {
		java.util.Enumeration keys = UIManager.getDefaults().keys();
		while (keys.hasMoreElements()) {
			Object key = keys.nextElement();
			Object value = UIManager.get(key);
			if (value instanceof javax.swing.plaf.FontUIResource)
				UIManager.put(key, f);
		}
	}

	public Gui() {
		setUIFont(new javax.swing.plaf.FontUIResource("���ʷҵ���", Font.PLAIN, 14));
		icon = new ImageIcon("background.png");
		JPanel background1 = new JPanel() {
			public void paintComponent(Graphics g) {
				g.drawImage(icon.getImage(), 0, 0, this.getWidth(), this.getHeight(), this);
				setOpaque(false);
				super.paintComponent(g);
			}
		};
		background1.setLayout(null);

		JPanel background2 = new JPanel() {
			public void paintComponent(Graphics g) {
				g.drawImage(icon.getImage(), 0, 0, this.getWidth(), this.getHeight(), this);
				setOpaque(false);
				super.paintComponent(g);
			}
		};
		background2.setLayout(null);

		JPanel background3 = new JPanel() {
			public void paintComponent(Graphics g) {
				g.drawImage(icon.getImage(), 0, 0, this.getWidth(), this.getHeight(), this);
				setOpaque(false);
				super.paintComponent(g);
			}
		};
		background3.setLayout(null);

		JPanel background4 = new JPanel() {
			public void paintComponent(Graphics g) {
				g.drawImage(icon.getImage(), 0, 0, this.getWidth(), this.getHeight(), this);
				setOpaque(false);
				super.paintComponent(g);
			}
		};
		background4.setLayout(null);

		JPanel background5 = new JPanel() {
			public void paintComponent(Graphics g) {
				g.drawImage(icon.getImage(), 0, 0, this.getWidth(), this.getHeight(), this);
				setOpaque(false);
				super.paintComponent(g);
			}
		};
		background5.setLayout(null);

		JPanel background6 = new JPanel() {
			public void paintComponent(Graphics g) {
				g.drawImage(icon.getImage(), 0, 0, this.getWidth(), this.getHeight(), this);
				setOpaque(false);
				super.paintComponent(g);
			}
		};
		background6.setLayout(null);

		JPanel background7 = new JPanel() {
			public void paintComponent(Graphics g) {
				g.drawImage(icon.getImage(), 0, 0, this.getWidth(), this.getHeight(), this);
				setOpaque(false);
				super.paintComponent(g);
			}
		};
		background7.setLayout(null);

		JPanel background8 = new JPanel() {
			public void paintComponent(Graphics g) {
				g.drawImage(icon.getImage(), 0, 0, this.getWidth(), this.getHeight(), this);
				setOpaque(false);
				super.paintComponent(g);
			}
		};
		background8.setLayout(null);

		JPanel background9 = new JPanel() {
			public void paintComponent(Graphics g) {
				g.drawImage(icon.getImage(), 0, 0, this.getWidth(), this.getHeight(), this);
				setOpaque(false);
				super.paintComponent(g);
			}
		};
		background9.setLayout(null);
//--------------------------------------------------   
		id = new JTextField("ID");
		password = new JTextField("Password");
		bt1 = new JButton("�α���");
		bt2 = new JButton("ȸ������");
		cb1 = new JComboBox<String>();
		cb1.addItem("�Һ���");
		cb1.addItem("�Ǹ���");

		cp = new JPanel();
		cp.setLayout(new GridLayout(2, 1));
		cp.setBackground(Color.WHITE);
		cp.add(id);
		cp.add(password);

		sp = new JPanel();
		sp.setLayout(new GridLayout(1, 3));
		sp.setBackground(Color.WHITE);
		sp.add(cb1);
		sp.add(bt1);
		sp.add(bt2);

		p1 = new JPanel();
		p1.setLayout(new GridLayout(3, 1));
		p1.setBounds(200, 60, 600, 600);
		p1.add(new JLabel());
		p1.add(cp);
		p1.add(sp);
		background1.add(p1);
//---------------------------------------------------------------------------      
		email = new JTextField();
		pw = new JTextField();
		pwcheck = new JTextField();
		nickname = new JTextField();
		emailcheck = new JButton("�ߺ�Ȯ��");
		nicknamecheck = new JButton("�ߺ�Ȯ��");
		complete = new JButton("���ԿϷ�");
		backbt1 = new JButton("��");

		emaillabel = new JLabel("�̸���");
		pwlabel = new JLabel("��й�ȣ");
		pwchecklabel = new JLabel("��й�ȣ Ȯ��");
		nicknamelabel = new JLabel("�г���");

		cb2 = new JComboBox<String>();
		cb2.addItem("�Һ���");
		cb2.addItem("�Ǹ���");

		emailp = new JPanel();
		emailp.setLayout(new BorderLayout());
		emailp.add("West", emaillabel);
		emailp.add("Center", email);
		emailp.add("East", emailcheck);

		pwp = new JPanel();
		pwp.setLayout(new BorderLayout());
		pwp.add("West", pwlabel);
		pwp.add("Center", pw);

		pwcheckp = new JPanel();
		pwcheckp.setLayout(new BorderLayout());
		pwcheckp.add("West", pwchecklabel);
		pwcheckp.add("Center", pwcheck);

		nicknamep = new JPanel();
		nicknamep.setLayout(new BorderLayout());
		nicknamep.add("West", nicknamelabel);
		nicknamep.add("Center", nickname);
		nicknamep.add("East", nicknamecheck);

		completep = new JPanel();
		completep.setLayout(new GridLayout(1, 3));
		completep.add(backbt1);
		completep.add(complete);
		completep.add(cb2);

		p2 = new JPanel();
		p2.setLayout(new GridLayout(6, 1));
		p2.setBounds(200, 130, 600, 800);
		p2.add(new JLabel());
		p2.add(emailp);
		p2.add(pwp);
		p2.add(pwcheckp);
		p2.add(nicknamep);
		p2.add(completep);
		background2.add(p2);
//-------------------------------------------------------------------------
		search = new JTextField("Search");
		backbt2 = new JButton("��");

		String columnNames[] = { "�Ĵ��̸�", "��ġ", "��ȭ��ȣ", "����" };
		List<Restaurant> rlist = new ArrayList<Restaurant>();
		rlist = r.selectAllRestaurant();
		String grname[] = new String[rlist.size()];
		String gwname[] = new String[rlist.size()];
		String ghpnum[] = new String[rlist.size()];
		double ggrade[] = new double[rlist.size()];
		for (int i = 0; i < rlist.size(); i++) {
			rlist.get(i).setGrade(KGradeDao.getInstance().averageKGrade(rlist.get(i).getRname()));
		}
		for (int i = 0; i < rlist.size(); i++) {
			grname[i] = rlist.get(i).getRname();
			gwname[i] = rlist.get(i).getWname();
			ghpnum[i] = rlist.get(i).getHpnum();
			ggrade[i] = rlist.get(i).getGrade();
		}
		Object rowData[][] = new Object[rlist.size()][4];
		for (int i = 0; i < rlist.size(); i++) {
			for (int j = 0; j < 4; j++) {
				switch (j) {
				case 0:
					rowData[i][j] = grname[i];
					break;
				case 1:
					rowData[i][j] = gwname[i];
					break;
				case 2:
					rowData[i][j] = ghpnum[i];
					break;
				case 3:
					ggrade[i] = Math.round(ggrade[i] * 10);
					rowData[i][j] = ggrade[i] / 10;
				}
			}
		}
		table = new JTable(rowData, columnNames);
		JScrollPane scrollPane = new JScrollPane(table);

		searchP = new JPanel();
		searchP.setLayout(new BorderLayout());
		searchP.setBackground(Color.WHITE);
		searchP.add("North", search);
		searchP.add("Center", scrollPane);

		mapP = new JPanel();
		mapP.setLayout(new GridLayout(1, 2));
		mapP.add(backbt2);
		mapP.add(new JLabel(map));

		p3 = new JPanel();
		p3.setLayout(new GridLayout(3, 1));
		p3.setBounds(200, 60, 600, 600);
		p3.add(new JLabel());
		p3.add(searchP);
		p3.add(mapP);
		background3.add(p3);
//--------------------------------------------------------------------
		backbt3 = new JButton("��");

		rate = new JComboBox<String>();
		rate.addItem("5.0");
		rate.addItem("4.0");
		rate.addItem("3.0");
		rate.addItem("2.0");
		rate.addItem("1.0");
		ratebt = new JButton("���ϱ�");

		rateP = new JPanel();
		rateP.setLayout(new GridLayout(1, 3));
		rateP.setBackground(Color.WHITE);
		rateP.add(backbt3);
		rateP.add(rate);
		rateP.add(ratebt);

		p4 = new JPanel();
		p4.setLayout(new GridLayout(4, 1));
		p4.setBounds(200, 260, 600, 600);
		background4.add(p4);
//-------------------------------------------------------------------
		backbt5 = new JButton("��");
		createbt = new JButton("�߰�");
		editbt = new JButton("����");
		removebt = new JButton("����");
		editrname = new JTextField("������ �Ĵ��");
		delrname = new JTextField("������ �Ĵ��");

		JPanel editP = new JPanel();
		editP.setLayout(new BorderLayout());
		editP.add("North", editrname);
		editP.add("Center", editbt);

		JPanel delP = new JPanel();
		delP.setLayout(new BorderLayout());
		delP.add("North", delrname);
		delP.add("Center", removebt);
		sctable = new JTable();

		sbtP = new JPanel();
		sbtP.setLayout(new GridLayout(1, 4));
		sbtP.add(backbt5);
		sbtP.add(editP);
		sbtP.add(createbt);
		sbtP.add(delP);

		p5 = new JPanel();
		p5.setLayout(new GridLayout(3, 1));
		p5.setBounds(200, 60, 600, 600);
		background5.add(p5);
//--------------------------------------------------------------------
		slabrname = new JLabel("���� : ");
		slabloc = new JLabel("��ġ : ");
		slabtel = new JLabel("��ȭ��ȣ : ");
		seditrname = new JTextField();
		seditloc = new JTextField();
		sedittel = new JTextField();
		seditcombt = new JButton("�߰� �Ϸ�");
		bbt1 = new JButton("��");

		se1 = new JPanel();
		se1.setLayout(new GridLayout());
		se1.setBackground(Color.WHITE);
		se1.add(slabrname);
		se1.add(seditrname);

		se21 = new JPanel();
		se21.setLayout(new GridLayout());
		se21.setBackground(Color.WHITE);
		se21.add(slabloc);
		se21.add(seditloc);

		se22 = new JPanel();
		se22.setLayout(new GridLayout());
		se22.setBackground(Color.WHITE);
		se22.add(slabtel);
		se22.add(sedittel);

		se2 = new JPanel();
		se2.setLayout(new GridLayout(3, 1));
		se2.setBackground(Color.WHITE);
		se2.add(se21);
		se2.add(se22);

		se3 = new JPanel();
		se3.setBackground(Color.WHITE);

		JPanel se4 = new JPanel();
		se4.setLayout(new GridLayout(1, 2));
		se4.add(bbt1);
		se4.add(seditcombt);

		p7 = new JPanel();
		p7.setLayout(new GridLayout(4, 1));
		p7.setBounds(200, 260, 600, 400);
		p7.add(se1);
		p7.add(se2);
		p7.add(se3);
		p7.add(se4);
		background6.add(p7);
//-------------------------------------------------------------------------
		labloc = new JLabel("��ġ : ");
		labtel = new JLabel("��ȭ��ȣ : ");
		editloc = new JTextField();
		edittel = new JTextField();
		deletem = new JTextField();
		addbt = new JButton("+");
		delbt = new JButton("-");
		editcombt = new JButton("���� �Ϸ�");
		bbt2 = new JButton("��");

		e21 = new JPanel();
		e21.setLayout(new GridLayout());
		e21.setBackground(Color.WHITE);
		e21.add(labloc);
		e21.add(editloc);

		e22 = new JPanel();
		e22.setLayout(new GridLayout());
		e22.setBackground(Color.WHITE);
		e22.add(labtel);
		e22.add(edittel);

		e2 = new JPanel();
		e2.setLayout(new GridLayout(2, 1));
		e2.setBackground(Color.WHITE);
		e2.add(e21);
		e2.add(e22);

		e31 = new JPanel();
		e31.setLayout(new GridLayout());

		deleteP = new JPanel();
		deleteP.setLayout(new GridLayout(2, 1));
		deleteP.add(deletem);
		deleteP.add(delbt);

		e32 = new JPanel();
		e32.setLayout(new GridLayout(1, 2));
		e32.add(addbt);
		e32.add(deleteP);

		e3 = new JPanel();

		e4 = new JPanel();
		e4.setLayout(new GridLayout(1, 2));
		e4.add(bbt2);
		e4.add(editcombt);

		p8 = new JPanel();
		p8.setLayout(new GridLayout(4, 1));
		p8.setBounds(200, 260, 600, 600);
		background7.add(p8);
//--------------------------------------------------------------------   
		sbackbt2 = new JButton("��");
		ssearch = new JTextField("Search");

		smapP = new JPanel();
		smapP.setLayout(new GridLayout(1, 2));
		smapP.add(sbackbt2);
		smapP.add(new JLabel(map));

		p31 = new JPanel(new GridLayout(3, 1));
		p31.setBounds(200, 60, 600, 600);
		background8.add(p31);
//----------------------------------------------------------------------
		backbt = new JButton("��");
		p41 = new JPanel();
		p41.setLayout(new GridLayout(4, 1));
		p41.setBounds(200, 260, 600, 600);
		background9.add(p41);
//------------------------------------------------------------------------
		cardP = new JPanel(card);
		p1.setOpaque(false);
		p2.setOpaque(false);
		p3.setOpaque(false);
		p4.setOpaque(false);
		p5.setOpaque(false);
		p7.setOpaque(false);
		p8.setOpaque(false);
		p31.setOpaque(false);
		p41.setOpaque(false);
		cardP.add("a1", background1);
		cardP.add("a2", background2);
		cardP.add("a3", background3);
		cardP.add("a4", background4);
		cardP.add("a5", background5);
		cardP.add("a7", background6);
		cardP.add("a8", background7);
		cardP.add("a31", background8);
		cardP.add("a41", background9);

		setTitle("����� ����");
		add(cardP);

		setBackground(Color.WHITE);
		setSize(1000, 1000);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		eventUp();
	}

	private void eventUp() {
		id.addMouseListener(this);
		password.addMouseListener(this);
		bt1.addActionListener(this);
		bt2.addActionListener(this);
		complete.addActionListener(this);
		emailcheck.addActionListener(this);
		nicknamecheck.addActionListener(this);
		table.addMouseListener(this);
		sctable.addMouseListener(this);
		backbt1.addActionListener(this);
		backbt2.addActionListener(this);
		backbt3.addActionListener(this);
		backbt5.addActionListener(this);
		sbackbt2.addActionListener(this);
		ratebt.addActionListener(this);
		search.addActionListener(this);
		search.addMouseListener(this);
		ssearch.addMouseListener(this);
		editbt.addActionListener(this);
		createbt.addActionListener(this);
		sctable.addMouseListener(this);
		seditcombt.addActionListener(this);
		editcombt.addActionListener(this);
		removebt.addActionListener(this);
		backbt.addActionListener(this);
		delrname.addMouseListener(this);
		editrname.addMouseListener(this);
		bbt1.addActionListener(this);
		bbt2.addActionListener(this);
		addbt.addActionListener(this);
		delbt.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object ob = e.getSource();
		if (ob == bt1 && cb1.getSelectedIndex() == 0) {
			stremail = id.getText();
			String strpw = password.getText();
			if (k.login(stremail, strpw) == 2) {
				card.show(cardP, "a3");
			} else if (k.login(stremail, strpw) == 0) {
				JOptionPane.showMessageDialog(this, "��й�ȣ�� �ùٸ��� �ʽ��ϴ�.");
				password.setText("");
			} else if (k.login(stremail, strpw) == 1) {
				JOptionPane.showMessageDialog(this, "���̵� �ùٸ��� �ʽ��ϴ�.");
				id.setText("");
				password.setText("");
			}
		} else if (ob == bt1 && cb1.getSelectedIndex() == 1) {
			pstremail = id.getText();
			String strpw = password.getText();
			if (p.login(pstremail, strpw) == 2) {
				String scNames[] = { "�Ĵ��̸�", "��ġ", "��ȭ��ȣ", "����" };
				ArrayList<Restaurant> sclist = new ArrayList<Restaurant>();
				sclist = rpd.RestaurantSelect(rpd.RnameSelect(pstremail));
				String scrname[] = new String[sclist.size()];
				String scwname[] = new String[sclist.size()];
				String schpnum[] = new String[sclist.size()];
				double scgrade[] = new double[sclist.size()];
				for (int i = 0; i < sclist.size(); i++) {
					sclist.get(i).setGrade(KGradeDao.getInstance().averageKGrade(sclist.get(i).getRname()));
				}
				for (int i = 0; i < sclist.size(); i++) {
					scrname[i] = sclist.get(i).getRname();
					scwname[i] = sclist.get(i).getWname();
					schpnum[i] = sclist.get(i).getHpnum();
					scgrade[i] = sclist.get(i).getGrade();
				}
				Object scData[][] = new Object[sclist.size()][4];
				for (int i = 0; i < sclist.size(); i++) {
					for (int j = 0; j < 4; j++) {
						switch (j) {
						case 0:
							scData[i][j] = scrname[i];
							break;
						case 1:
							scData[i][j] = scwname[i];
							break;
						case 2:
							scData[i][j] = schpnum[i];
							break;
						case 3:
							scgrade[i] = Math.round(scgrade[i]);
							scData[i][j] = scgrade[i];
						}
					}
				}
				sctable = new JTable(scData, scNames);
				scscrollPane = new JScrollPane(sctable);

				p5.add(new JLabel());
				p5.add(scscrollPane);
				p5.add(sbtP);
				editrname.setText("������ �Ĵ��");
				delrname.setText("������ �Ĵ��");
				card.show(cardP, "a5");
				sctable.addMouseListener(this);
			} else if (p.login(pstremail, strpw) == 0) {
				JOptionPane.showMessageDialog(this, "��й�ȣ�� �ùٸ��� �ʽ��ϴ�.");
				password.setText("");
			} else if (p.login(pstremail, strpw) == 1) {
				JOptionPane.showMessageDialog(this, "���̵� �ùٸ��� �ʽ��ϴ�.");
				id.setText("");
				password.setText("");
			}
		} else if (ob == bt2) {
			card.show(cardP, "a2");
		} else if (ob == emailcheck) {
			String stremail = email.getText();
			if (!k.DupliEmailCheck(stremail) && !p.DupliEmailCheck(stremail))
				JOptionPane.showMessageDialog(this, "��밡���� email�Դϴ�.");
			else
				JOptionPane.showMessageDialog(this, "�ߺ��� email�� �ֽ��ϴ�.");
		} else if (ob == nicknamecheck) {
			String strnickname = nickname.getText();
			if (!k.DupliNickCheck(strnickname) && !p.DupliEmailCheck(strnickname))
				JOptionPane.showMessageDialog(this, "��밡����nickname�Դϴ�.");
			else
				JOptionPane.showMessageDialog(this, "�ߺ��� nickname�� �ֽ��ϴ�.");
		} else if (ob == complete && cb2.getSelectedIndex() == 0) {
			String stremail = email.getText();
			String strpw = pw.getText();
			String strpwcheck = pwcheck.getText();
			String strnickname = nickname.getText();
			if (strnickname.length() != 0) {
				if (!k.DupliEmailCheck(stremail) && !k.DupliNickCheck(strnickname)) {
					if (strpw.equals(strpwcheck)) {
						// DB�� ���� �Է�
						Member member = new Member(stremail, strnickname, strpw);
						k.join(member);
						JOptionPane.showMessageDialog(this, "���ԿϷ�");
						email.setText("");
						pw.setText("");
						pwcheck.setText("");
						nickname.setText("");
						id.setText("ID");
						password.setText("Password");
						card.show(cardP, "a1");
					} else {
						JOptionPane.showMessageDialog(this, "��й�ȣ�� �ٸ��ϴ�.");
					}
				} else {
					JOptionPane.showMessageDialog(this, "�ߺ�Ȯ���� ���ּ���.");
				}
			} else {
				JOptionPane.showMessageDialog(this, "�г����� �Է����ּ���.");
			}
		} else if (ob == complete && cb2.getSelectedIndex() == 1) {
			String stremail = email.getText();
			String strpw = pw.getText();
			String strpwcheck = pwcheck.getText();
			String strnickname = nickname.getText();
			if (!p.DupliEmailCheck(stremail) && !p.DupliNickCheck(strnickname)) {
				if (strpw.equals(strpwcheck)) {
					// DB�� ���� �Է�
					PMember member = new PMember(stremail, strnickname, strpw, null);
					p.join(member);
					JOptionPane.showMessageDialog(this, "���ԿϷ�");
					email.setText("");
					pw.setText("");
					pwcheck.setText("");
					nickname.setText("");
					id.setText("ID");
					password.setText("Password");
					card.show(cardP, "a1");
				} else {
					JOptionPane.showMessageDialog(this, "��й�ȣ�� �ٸ��ϴ�.");
				}
			} else {
				JOptionPane.showMessageDialog(this, "�ߺ�Ȯ���� ���ּ���.");
			}
		} else if (ob == backbt1) {
			id.setText("ID");
			password.setText("Password");
			card.show(cardP, "a1");
		} else if (ob == backbt2) {
			id.setText("ID");
			password.setText("Password");
			card.show(cardP, "a1");
		} else if (ob == backbt3) {
			p4.removeAll();
			p31.removeAll();
			search.setText("Search");
			card.show(cardP, "a3");
		} else if (ob == backbt5) {
			id.setText("ID");
			password.setText("Password");
			p5.removeAll();
			card.show(cardP, "a1");
		} else if (ob == addbt) {
			String fname = JOptionPane.showInputDialog("�޴��� �Է��ϼ���");
			String price = JOptionPane.showInputDialog("���� �Է��ϼ���");

			m.menuInsert(new Menu(editrname.getText(), fname, Integer.parseInt(price)));

			String a[] = { "�޴�", "����" };
			List<Menu> mlist = new ArrayList<Menu>();
			mlist = m.selectAllMenu(editrname.getText());
			String gfname[] = new String[mlist.size()];
			int gprice[] = new int[mlist.size()];
			for (int i = 0; i < mlist.size(); i++) {
				gfname[i] = mlist.get(i).getFname();
				gprice[i] = mlist.get(i).getPrice();
			}
			Object b[][] = new Object[mlist.size()][2];
			for (int i = 0; i < mlist.size(); i++) {
				for (int j = 0; j < 2; j++) {
					switch (j) {
					case 0:
						b[i][j] = gfname[i];
						break;
					case 1:
						b[i][j] = gprice[i];
					}
				}
			}

			// 1. �𵨰� �����͸� ����
			DefaultTableModel model = new DefaultTableModel(b, a);

			// 2. Model�� �Ű������� ����, new JTable(b,a)�� ����������
			// ���� ������ �ϱ� ���� �ش� ����� ����մϴ�
			JTable table = new JTable(model); //

			// 3. ��������δ� JScrollPane�� �߰��մϴ�.
			JScrollPane sc = new JScrollPane(table);

			// 4. ������Ʈ�� Table �߰�

			// ���̺� ������ �߰��ϱ�
			// ���������͸� �ǵ��� �ʰ� table�� �Ű������� model�� �ִ� �����͸� �����մϴ�
			DefaultTableModel m = (DefaultTableModel) table.getModel();
			// �𵨿� ������ �߰� , 1��° �⿡ ���ο� �����͸� �߰��մϴ�
			m.insertRow(0, new Object[] { fname, price });
			// �߰��� ��ġ�� ������ ������ �˸��ϴ�.
			table.updateUI();
			p8.removeAll();
			e3.removeAll();
			card.show(cardP, "a5");
		} else if (ob == editbt) {
			String rname = editrname.getText();
			if (!rpd.CheckRname(pstremail, rname)) {
				JOptionPane.showMessageDialog(this, "�Ǹ��ڰ� ������ �ִ� �Ĵ��� �ƴմϴ�");
			} else if ((!rname.equals("������ �Ĵ��")) && (rname.length() != 0)) {

				String a[] = { "�޴�", "����" };
				List<Menu> mlist = new ArrayList<Menu>();
				mlist = m.selectAllMenu(editrname.getText());
				String gfname[] = new String[mlist.size()];
				int gprice[] = new int[mlist.size()];
				for (int i = 0; i < mlist.size(); i++) {
					gfname[i] = mlist.get(i).getFname();
					gprice[i] = mlist.get(i).getPrice();
				}
				Object b[][] = new Object[mlist.size()][2];
				for (int i = 0; i < mlist.size(); i++) {
					for (int j = 0; j < 2; j++) {
						switch (j) {
						case 0:
							b[i][j] = gfname[i];
							break;
						case 1:
							b[i][j] = gprice[i];
						}
					}
				}
				JTable editTable = new JTable(b, a);
				JScrollPane editScroll = new JScrollPane(editTable);
				e31 = new JPanel(new BorderLayout());
				e31.add(editScroll);

				JLabel title = new JLabel("" + rname, SwingConstants.CENTER);
				title.setFont(font1);
				titleP = new JPanel();
				titleP.setBackground(Color.WHITE);
				titleP.add(title);
				p8.add(titleP);
				p8.add(e2);
				e3.setLayout(new GridLayout(2, 1));
				e3.add(e31);
				e3.add(e32);
				p8.add(e3);
				p8.add(e4);
				card.show(cardP, "a8");
			} else {
				JOptionPane.showMessageDialog(this, "������ �Ĵ���� �Է��ϼ���");
			}
		} else if (ob == sbackbt2) {
			p31.removeAll();
			search.setText("Search");
			ssearch.setText("Search");
			card.show(cardP, "a3");
		} else if (ob == createbt) {
			card.show(cardP, "a7");
		} else if (ob == ratebt) {
			KGradeService kgservice = new KGradeService();
			if (kgservice.DupliEmailCheck(rnamestr.toString(), stremail.toString())) {
				JOptionPane.showMessageDialog(this, "�̹� �򰡸� �Ϸ��߽��ϴ�");
			} else {
				double[] result = { 5.0, 4.0, 3.0, 2.0, 1.0 };
				KGradeDao kgradedao = KGradeDao.getInstance();
				kgradedao.setGrade(rnamestr.toString(), stremail.toString(), result[rate.getSelectedIndex()]);
				JOptionPane.showMessageDialog(this, "�� �Ϸ�!");
			}
			p4.removeAll();
			search.setText("Search");
			card.show(cardP, "a3");
		} else if (ob == search) {
			String str = search.getText().trim();
			if (str.length() == 0) {
				JOptionPane.showMessageDialog(this, "�˻��� �����͸� �Է��ϼ���.");
				return;
			} else {
				List<Restaurant> slist = new ArrayList<Restaurant>();
				slist = r.selectAllRestaurant(str);
				String sNames[] = { "�Ĵ��̸�", "��ġ", "��ȭ��ȣ", "����" };
				String scrname[] = new String[slist.size()];
				String scwname[] = new String[slist.size()];
				String schpnum[] = new String[slist.size()];
				double scgrade[] = new double[slist.size()];
				for (int i = 0; i < slist.size(); i++) {
					slist.get(i).setGrade(KGradeDao.getInstance().averageKGrade(slist.get(i).getRname()));
				}
				for (int i = 0; i < slist.size(); i++) {
					scrname[i] = slist.get(i).getRname();
					scwname[i] = slist.get(i).getWname();
					schpnum[i] = slist.get(i).getHpnum();
					scgrade[i] = slist.get(i).getGrade();
				}
				Object sData[][] = new Object[slist.size()][4];
				for (int i = 0; i < slist.size(); i++) {
					for (int j = 0; j < 4; j++) {
						switch (j) {
						case 0:
							sData[i][j] = scrname[i];
							break;
						case 1:
							sData[i][j] = scwname[i];
							break;
						case 2:
							sData[i][j] = schpnum[i];
							break;
						case 3:
							scgrade[i] = Math.round(scgrade[i]);
							sData[i][j] = scgrade[i];
						}
					}
				}
				stable = new JTable(sData, sNames);
				JScrollPane sscrollPane = new JScrollPane(stable);

				ssearchP = new JPanel();
				ssearchP.setLayout(new BorderLayout());
				ssearchP.setBackground(Color.WHITE);
				ssearchP.add("North", ssearch);
				ssearchP.add("Center", sscrollPane);
				p31.add(new JLabel());
				p31.add(ssearchP);
				p31.add(smapP);
				card.show(cardP, "a31");
				stable.addMouseListener(this);
			}
		} else if (ob == seditcombt) {
			if (seditrname.getText().length() != 0) {
				String addrname = seditrname.getText();
				rpd.Insert(pstremail, addrname);
				r.restaurantInsert(new Restaurant(seditrname.getText(), seditloc.getText(), sedittel.getText(), 0.0));
				seditrname.setText("");
				seditloc.setText("");
				sedittel.setText("");
				p5.removeAll();
				card.show(cardP, "a1");
			} else {
				JOptionPane.showMessageDialog(this, "�߰��� �Ĵ������� �Է��ϼ���.");
			}
		} else if (ob == backbt) {
			p41.removeAll();
			card.show(cardP, "a5");
		} else if (ob == editcombt) {
			r.updateRestaurant(new Restaurant(editrname.getText(), editloc.getText(), edittel.getText()));
			editrname.setText("������ �Ĵ��");
			p8.removeAll();
			e3.removeAll();
			card.show(cardP, "a1");
		} else if (ob == removebt) {
			String delRname = delrname.getText();
			rpd.Delete(pstremail, delRname);
			r.deleteRestaurant(delRname);
			p5.removeAll();
			card.show(cardP, "a1");
		} else if (ob == delbt) {
			String fname = deletem.getText();
			m.deleteMenu(fname);
			p8.removeAll();
			e3.removeAll();
			deletem.setText("");
			card.show(cardP, "a5");
		} else if (ob == bbt1) {
			seditrname.setText("");
			seditloc.setText("");
			sedittel.setText("");
			card.show(cardP, "a5");
		} else if (ob == bbt2) {
			p8.removeAll();
			e3.removeAll();
			editrname.setText("������ �Ĵ��");
			card.show(cardP, "a5");
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		Object ob = e.getSource();
		if (ob == id) {
			id.setText("");
		} else if (ob == password) {
			password.setText("");
		} else if (ob == search) {
			search.setText("");
		} else if (ob == ssearch) {
			ssearch.setText("");
		} else if (ob == editrname) {
			editrname.setText("");
		} else if (ob == delrname) {
			delrname.setText("");
		} else if (ob == table) {
			int row = table.getSelectedRow();
			rnamestr = table.getValueAt(row, 0);
			Restaurant r1 = r.selectOneRestaurant(rnamestr.toString());
			r1.setGrade(KGradeDao.getInstance().averageKGrade(rnamestr.toString()));
			location = new JLabel("��ġ : " + r1.getWname());
			telnum = new JLabel("��ȭ��ȣ : " + r1.getHpnum());
			score = new JLabel("���� : " + r1.getGrade());
			String inColunm[] = { "�޴�", "����" };
			List<Menu> mlist = new ArrayList<Menu>();
			mlist = m.selectAllMenu(rnamestr.toString());
			String gfname[] = new String[mlist.size()];
			int gprice[] = new int[mlist.size()];
			for (int i = 0; i < mlist.size(); i++) {
				gfname[i] = mlist.get(i).getFname();
				gprice[i] = mlist.get(i).getPrice();
			}
			Object inRow[][] = new Object[mlist.size()][2];
			for (int i = 0; i < mlist.size(); i++) {
				for (int j = 0; j < 2; j++) {
					switch (j) {
					case 0:
						inRow[i][j] = gfname[i];
						break;
					case 1:
						inRow[i][j] = gprice[i];
					}
				}
			}
			inTable = new JTable(inRow, inColunm);
			inScrollPane = new JScrollPane(inTable);

			JPanel infoP = new JPanel();
			infoP.setLayout(new GridLayout(3, 1));
			infoP.setBackground(Color.WHITE);
			infoP.add(location);
			infoP.add(telnum);
			infoP.add(score);

			JLabel title = new JLabel("" + rnamestr, SwingConstants.CENTER);
			title.setBackground(Color.white);
			title.setFont(font1);
			rtitleP = new JPanel();
			rtitleP.setBackground(Color.WHITE);
			rtitleP.add(title);
			p4.add(rtitleP);
			p4.add(infoP);
			p4.add(inScrollPane);
			p4.add(rateP);
			card.show(cardP, "a4");
		} else if (ob == stable) {
			int row = stable.getSelectedRow();
			rnamestr = stable.getValueAt(row, 0);
			Restaurant r1 = r.selectOneRestaurant(rnamestr.toString());
			r1.setGrade(KGradeDao.getInstance().averageKGrade(rnamestr.toString()));
			location = new JLabel("��ġ : " + r1.getWname());
			telnum = new JLabel("��ȭ��ȣ : " + r1.getHpnum());
			score = new JLabel("���� : " + r1.getGrade());
			String inColunm[] = { "�޴�", "����" };
			List<Menu> mlist = new ArrayList<Menu>();
			mlist = m.selectAllMenu(rnamestr.toString());
			String gfname[] = new String[mlist.size()];
			int gprice[] = new int[mlist.size()];
			for (int i = 0; i < mlist.size(); i++) {
				gfname[i] = mlist.get(i).getFname();
				gprice[i] = mlist.get(i).getPrice();
			}
			Object inRow[][] = new Object[mlist.size()][2];
			for (int i = 0; i < mlist.size(); i++) {
				for (int j = 0; j < 2; j++) {
					switch (j) {
					case 0:
						inRow[i][j] = gfname[i];
						break;
					case 1:
						inRow[i][j] = gprice[i];
					}
				}
			}
			inTable = new JTable(inRow, inColunm);
			inScrollPane = new JScrollPane(inTable);

			JPanel infoP = new JPanel();
			infoP.setLayout(new GridLayout(3, 1));
			infoP.setBackground(Color.WHITE);
			infoP.add(location);
			infoP.add(telnum);
			infoP.add(score);

			JLabel title = new JLabel("" + rnamestr, SwingConstants.CENTER);
			title.setBackground(Color.WHITE);
			title.setFont(font1);
			stitleP = new JPanel();
			stitleP.setBackground(Color.WHITE);
			stitleP.add(title);
			p4.add(stitleP);
			p4.add(infoP);
			p4.add(inScrollPane);
			p4.add(rateP);
			card.show(cardP, "a4");
		} else if (ob == sctable) {
			int row = sctable.getSelectedRow();
			rnamestr = sctable.getValueAt(row, 0);
			Restaurant r1 = r.selectOneRestaurant(rnamestr.toString());
			r1.setGrade(KGradeDao.getInstance().averageKGrade(rnamestr.toString()));
			location = new JLabel("��ġ : " + r1.getWname());
			telnum = new JLabel("��ȭ��ȣ : " + r1.getHpnum());
			score = new JLabel("���� : " + r1.getGrade());
			r1.setGrade(KGradeDao.getInstance().averageKGrade(rnamestr.toString()));
			String inColunm[] = { "�޴�", "����" };
			List<Menu> mlist = new ArrayList<Menu>();
			mlist = m.selectAllMenu(rnamestr.toString());
			String gfname[] = new String[mlist.size()];
			int gprice[] = new int[mlist.size()];
			for (int i = 0; i < mlist.size(); i++) {
				gfname[i] = mlist.get(i).getFname();
				gprice[i] = mlist.get(i).getPrice();
			}
			Object inRow[][] = new Object[mlist.size()][2];
			for (int i = 0; i < mlist.size(); i++) {
				for (int j = 0; j < 2; j++) {
					switch (j) {
					case 0:
						inRow[i][j] = gfname[i];
						break;
					case 1:
						inRow[i][j] = gprice[i];
					}
				}
			}
			sinTable = new JTable(inRow, inColunm);
			JScrollPane inScrollPane = new JScrollPane(sinTable);

			JPanel infoP = new JPanel();
			infoP.setLayout(new GridLayout(3, 1));
			infoP.setBackground(Color.WHITE);
			infoP.add(location);
			infoP.add(telnum);
			infoP.add(score);

			JLabel title = new JLabel("" + rnamestr, SwingConstants.CENTER);
			title.setFont(font1);
			mtitleP = new JPanel();
			mtitleP.setBackground(Color.WHITE);
			mtitleP.add(title);
			p41.add(mtitleP);
			p41.add(infoP);
			p41.add(inScrollPane);
			p41.add(backbt);

			removebt.addActionListener(this);
			card.show(cardP, "a41");
		}
	}

	public static void main(String[] args) {
		new Gui();
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}
}