package View;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.*;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SpringLayout;

import Controle.ChamadoControle;
import Controle.LoginAcesso;
import Modelo.Chamado;
import Controle.ControleAcesso;


/**
 * 
 */
public class ViewGrafico extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = -9060450127341915612L;
	private ControleAcesso Controle;
	private LoginAcesso login;
	private ArrayList<Chamado> searchResults;
	private JTabbedPane mainPainel = new JTabbedPane();
	private JPanel loginPainel = new JPanel();
	private JPanel registrarPainel = new JPanel();
	private JPanel usuarioPainel = new JPanel();
	private JPanel ChamadoPainel = new JPanel();
	private final DefaultListModel<Chamado> modeloList = new DefaultListModel<Chamado>();
	private JList<Chamado> Chamadolistusuario = new JList<Chamado>(modeloList);
	private JList<Chamado> ChamadolistChamado = new JList<Chamado>(modeloList);
	private JScrollPane scrollableListaUsuario = new JScrollPane(Chamadolistusuario);
	private JScrollPane scrollableListaChamado = new JScrollPane(ChamadolistChamado);

	/**
	 * Default contrutor
	 * @throws IOException 
	 */
	public ViewGrafico() throws IOException {
		setSize(700, 500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		//---------------Login Painell----------------
		
		SpringLayout layout1 = new SpringLayout();
		loginPainel.setLayout(layout1);
		JButton loginBotao = new JButton("Login");
		JLabel usuarioTag = new JLabel("Usuário: ");
		JTextField usuarioField = new JTextField("", 15);
		JLabel	senhaTag = new JLabel("Senha: ");
		JPasswordField senhaField = new JPasswordField("", 15);
		loginPainel.add(usuarioField);
		loginPainel.add(usuarioTag);
		loginPainel.add(senhaTag);
		usuarioField.setSize(100, 100);
		loginPainel.add(senhaField);
		loginPainel.add(loginBotao);
		layout1.putConstraint(SpringLayout.WEST, usuarioTag, 180, SpringLayout.WEST, loginPainel);
		layout1.putConstraint(SpringLayout.NORTH, usuarioTag, 180, SpringLayout.NORTH, loginPainel);
		layout1.putConstraint(SpringLayout.WEST, usuarioField, 5, SpringLayout.EAST, usuarioTag);
		layout1.putConstraint(SpringLayout.NORTH, usuarioField, 180, SpringLayout.NORTH, loginPainel);
		layout1.putConstraint(SpringLayout.WEST, senhaTag, 0, SpringLayout.WEST, usuarioTag);
		layout1.putConstraint(SpringLayout.NORTH, senhaTag, 15, SpringLayout.SOUTH, usuarioField);
		layout1.putConstraint(SpringLayout.WEST, senhaField, 0, SpringLayout.WEST, usuarioField);
		layout1.putConstraint(SpringLayout.NORTH, senhaField, -15, SpringLayout.SOUTH, senhaTag);
		layout1.putConstraint(SpringLayout.WEST, loginBotao, 270, SpringLayout.WEST, loginPainel);
		layout1.putConstraint(SpringLayout.NORTH, loginBotao, 15, SpringLayout.SOUTH, senhaField);
		
		
		//---------------Cadastro Painell ----------------
		
		SpringLayout layout2 = new SpringLayout();
		registrarPainel.setLayout(layout2);
		JButton cadastrarBotao = new JButton("Cadastrar");
		JTextField usuarioFieldReg = new JTextField("Usuário", 15);
		JPasswordField senhaFieldReg = new JPasswordField("123", 15);
		JPasswordField resenhaFieldReg = new JPasswordField("123", 15);
		usuarioFieldReg.setSize(100, 100);
		registrarPainel.add(usuarioFieldReg);
		registrarPainel.add(senhaFieldReg);
		registrarPainel.add(cadastrarBotao);
		registrarPainel.add(resenhaFieldReg);
		layout2.putConstraint(SpringLayout.WEST, usuarioFieldReg, 250, SpringLayout.WEST, loginPainel);
		layout2.putConstraint(SpringLayout.NORTH, usuarioFieldReg, 150, SpringLayout.WEST, loginPainel);
		layout2.putConstraint(SpringLayout.WEST, senhaFieldReg, 250, SpringLayout.WEST, loginPainel);
		layout2.putConstraint(SpringLayout.WEST, resenhaFieldReg, 250, SpringLayout.WEST, loginPainel);
		layout2.putConstraint(SpringLayout.WEST, cadastrarBotao, 285, SpringLayout.WEST, loginPainel);
		layout2.putConstraint(SpringLayout.NORTH, senhaFieldReg, 10, SpringLayout.SOUTH, usuarioFieldReg);
		layout2.putConstraint(SpringLayout.NORTH, resenhaFieldReg, 10, SpringLayout.SOUTH, senhaFieldReg);
		layout2.putConstraint(SpringLayout.NORTH, cadastrarBotao, 10, SpringLayout.SOUTH, resenhaFieldReg);
		
		//---------------usuario Painell ---------------
		
		SpringLayout layout3 = new SpringLayout();
		usuarioPainel.setLayout(layout3);
		JTextField pesquisarField = new JTextField("", 20);
		JButton SairBotao = new JButton("Sair");
		JButton pesquisarBotao = new JButton("Pesquisar");
		JButton verChamado = new JButton("Ver Chamado");
		JLabel ChamadoNomeTag = new JLabel("Chamado nome: ");
		JLabel ChamadoNomeLabel = new JLabel("Nome do chamado");
		JLabel ChamadoTipoTag = new JLabel("Tipo do chamado: ");
		JLabel ChamadoTipoLabel = new JLabel("Tipo do chamado");
		JLabel ChamadoDescTag = new JLabel("Descrição do chamado: ");
		JLabel ChamadoDescLabel = new JLabel("Descrição");
		JLabel ChamadoStatusTag = new JLabel("Status: ");
		JLabel ChamadoStatusLabel= new JLabel("Concluido/Em andamento");
		JLabel ChamadoAtendenteTag = new JLabel("Atendente: ");
		JLabel ChamadoAtendenteLabel = new JLabel("Nome do atendente");
	    usuarioPainel.add(pesquisarField);
	    usuarioPainel.add(pesquisarBotao);
	    usuarioPainel.add(scrollableListaUsuario);
	    usuarioPainel.add(ChamadoDescTag);
	    usuarioPainel.add(ChamadoDescLabel);
	    usuarioPainel.add(ChamadoTipoLabel);
	    usuarioPainel.add(ChamadoTipoTag);
	    usuarioPainel.add(ChamadoNomeLabel);
	    usuarioPainel.add(ChamadoNomeTag);
	    usuarioPainel.add(ChamadoAtendenteLabel);
	    usuarioPainel.add(ChamadoAtendenteTag);
	    usuarioPainel.add(ChamadoStatusTag);
	    usuarioPainel.add(ChamadoStatusLabel);
	    usuarioPainel.add(SairBotao);
	    usuarioPainel.add(verChamado);
	    layout3.putConstraint(SpringLayout.WEST, pesquisarField, 40, SpringLayout.WEST, usuarioPainel);
	    layout3.putConstraint(SpringLayout.NORTH, pesquisarField, 60, SpringLayout.WEST, usuarioPainel);
	    layout3.putConstraint(SpringLayout.NORTH, pesquisarBotao, 57, SpringLayout.WEST, usuarioPainel);
	    layout3.putConstraint(SpringLayout.WEST, pesquisarBotao, 15, SpringLayout.EAST, pesquisarField);
	    layout3.putConstraint(SpringLayout.NORTH, scrollableListaUsuario, 15, SpringLayout.SOUTH, pesquisarField);
	    layout3.putConstraint(SpringLayout.WEST, scrollableListaUsuario, 40, SpringLayout.WEST, usuarioPainel);
	    layout3.putConstraint(SpringLayout.WEST, ChamadoNomeTag, 30, SpringLayout.EAST, scrollableListaUsuario);
	    layout3.putConstraint(SpringLayout.NORTH, ChamadoNomeTag, 15, SpringLayout.SOUTH, pesquisarField);
	    layout3.putConstraint(SpringLayout.WEST, ChamadoNomeLabel, 15, SpringLayout.EAST, ChamadoNomeTag);
	    layout3.putConstraint(SpringLayout.NORTH, ChamadoNomeLabel, 15, SpringLayout.SOUTH, pesquisarField);
	    
	    layout3.putConstraint(SpringLayout.WEST, ChamadoTipoTag, 30, SpringLayout.EAST, scrollableListaUsuario);
	    layout3.putConstraint(SpringLayout.NORTH, ChamadoTipoTag, 15, SpringLayout.SOUTH, ChamadoNomeTag);
	    layout3.putConstraint(SpringLayout.WEST, ChamadoTipoLabel, 15, SpringLayout.EAST, ChamadoTipoTag);
	    layout3.putConstraint(SpringLayout.NORTH, ChamadoTipoLabel, 15, SpringLayout.SOUTH, ChamadoNomeLabel);
	    
	    layout3.putConstraint(SpringLayout.WEST, ChamadoDescTag, 30, SpringLayout.EAST, scrollableListaUsuario);
	    layout3.putConstraint(SpringLayout.NORTH, ChamadoDescTag, 15, SpringLayout.SOUTH, ChamadoTipoTag);
	    layout3.putConstraint(SpringLayout.WEST, ChamadoDescLabel, 15, SpringLayout.EAST, ChamadoDescTag);
	    layout3.putConstraint(SpringLayout.NORTH, ChamadoDescLabel, 15, SpringLayout.SOUTH, ChamadoTipoLabel);
	    layout3.putConstraint(SpringLayout.WEST, ChamadoStatusTag, 30, SpringLayout.EAST, scrollableListaUsuario);
	    layout3.putConstraint(SpringLayout.NORTH, ChamadoStatusTag, 15, SpringLayout.SOUTH, ChamadoDescTag);
	    layout3.putConstraint(SpringLayout.WEST, ChamadoStatusLabel, 15, SpringLayout.EAST, ChamadoStatusTag);
	    layout3.putConstraint(SpringLayout.NORTH, ChamadoStatusLabel, 15, SpringLayout.SOUTH, ChamadoDescLabel);
	    layout3.putConstraint(SpringLayout.WEST, ChamadoAtendenteTag, 30, SpringLayout.EAST, scrollableListaUsuario);
	    layout3.putConstraint(SpringLayout.NORTH, ChamadoAtendenteTag, 15, SpringLayout.SOUTH, ChamadoStatusTag);
	    layout3.putConstraint(SpringLayout.WEST, ChamadoAtendenteLabel, 15, SpringLayout.EAST, ChamadoAtendenteTag);
	    layout3.putConstraint(SpringLayout.NORTH, ChamadoAtendenteLabel, 15, SpringLayout.SOUTH, ChamadoStatusLabel);
	    layout3.putConstraint(SpringLayout.WEST, verChamado, 40, SpringLayout.WEST, usuarioPainel);
	    layout3.putConstraint(SpringLayout.NORTH, verChamado, 15, SpringLayout.SOUTH, scrollableListaUsuario);
	    layout3.putConstraint(SpringLayout.EAST, SairBotao, -30, SpringLayout.EAST, usuarioPainel);
	    layout3.putConstraint(SpringLayout.SOUTH, SairBotao, -30, SpringLayout.SOUTH, usuarioPainel);
	    scrollableListaUsuario.setMinimumSize(new Dimension(120, 230));
	    scrollableListaUsuario.setPreferredSize(new Dimension(120, 230));
	    scrollableListaUsuario.setMaximumSize(new Dimension(120, 230));
	    
	    //---------------Chamado Painell ----------------
	    
	    SpringLayout layout4 = new SpringLayout();
	    ChamadoPainel.setLayout(layout4);
	    JTextField novoChamadoNomeField = new JTextField("", 20);
	    JLabel novoChamadoNomeTag = new JLabel("Escreva o nome do chamado:");
	    JTextField novoChamadoTipoField = new JTextField("", 20);
	    JLabel novoChamadoTipoTag = new JLabel("Tipo do chamado:");
	    JTextArea novoChamadoDescField = new JTextArea("", 3, 20);
	    JLabel novoChamadoDescTag = new JLabel("Escreva uma Descrição :");
	    JTextField novoChamadoStatusField = new JTextField("", 20);
	    JLabel novoChamadoStatusTag = new JLabel("Status :");
	    JTextField novoChamadoAtendenteField = new JTextField("", 20);
	    JLabel novoChamadoAtendenteTag = new JLabel("Escreva o Atendente :");
	    
	    JButton addChamado = new JButton("Adicionar Chamado");
	    JButton updateChamado = new JButton("Editar Chamado");
	    JButton	delChamado = new JButton("Deletar Chamado");
	    JButton SairBotaoChamado = new JButton("Sair");
	    
	    ChamadoPainel.add(novoChamadoNomeTag);
	    ChamadoPainel.add(novoChamadoNomeField);
	    ChamadoPainel.add(novoChamadoTipoTag);
	    ChamadoPainel.add(novoChamadoTipoField);
	    ChamadoPainel.add(novoChamadoDescField);
	    ChamadoPainel.add(novoChamadoDescTag);
	    ChamadoPainel.add(novoChamadoStatusTag);
	    ChamadoPainel.add(novoChamadoStatusField);
	    ChamadoPainel.add(novoChamadoAtendenteTag);
	    ChamadoPainel.add(novoChamadoAtendenteField);
	    ChamadoPainel.add(scrollableListaChamado);
	    ChamadoPainel.add(addChamado);
	    ChamadoPainel.add(updateChamado);
	    ChamadoPainel.add(delChamado);
	    ChamadoPainel.add(SairBotaoChamado);
	    scrollableListaChamado.setMinimumSize(new Dimension(120, 230));
	    scrollableListaChamado.setPreferredSize(new Dimension(120, 230));
	    scrollableListaChamado.setMaximumSize(new Dimension(120, 230));
	    
	    layout4.putConstraint(SpringLayout.WEST, novoChamadoNomeTag, 30, SpringLayout.WEST, ChamadoPainel);
	    layout4.putConstraint(SpringLayout.NORTH, novoChamadoNomeTag, 30, SpringLayout.NORTH, ChamadoPainel);
	    layout4.putConstraint(SpringLayout.WEST, novoChamadoNomeField, 100, SpringLayout.EAST, novoChamadoNomeTag);
	    layout4.putConstraint(SpringLayout.NORTH, novoChamadoNomeField, 30, SpringLayout.NORTH, ChamadoPainel);
	    
	    layout4.putConstraint(SpringLayout.WEST, novoChamadoTipoTag, 0, SpringLayout.WEST, novoChamadoNomeTag);
	    layout4.putConstraint(SpringLayout.NORTH, novoChamadoTipoTag, 15, SpringLayout.SOUTH, novoChamadoNomeField);
	    layout4.putConstraint(SpringLayout.WEST, novoChamadoTipoField, 0, SpringLayout.WEST, novoChamadoNomeField);
	    layout4.putConstraint(SpringLayout.NORTH, novoChamadoTipoField, 15, SpringLayout.SOUTH, novoChamadoTipoTag);
	    
	    layout4.putConstraint(SpringLayout.WEST, novoChamadoDescTag, 0, SpringLayout.WEST, novoChamadoTipoTag);
	    layout4.putConstraint(SpringLayout.NORTH, novoChamadoDescTag, 15, SpringLayout.SOUTH, novoChamadoTipoField);
	    layout4.putConstraint(SpringLayout.WEST, novoChamadoDescField, 0, SpringLayout.WEST, novoChamadoTipoField);
	    layout4.putConstraint(SpringLayout.NORTH, novoChamadoDescField, 15, SpringLayout.SOUTH, novoChamadoDescTag);
	    
	    layout4.putConstraint(SpringLayout.WEST, novoChamadoStatusTag, 0, SpringLayout.WEST, novoChamadoDescTag);
	    layout4.putConstraint(SpringLayout.NORTH, novoChamadoStatusTag, 15, SpringLayout.SOUTH, novoChamadoDescField);
	    layout4.putConstraint(SpringLayout.WEST, novoChamadoStatusField, 0, SpringLayout.WEST, novoChamadoDescField);
	    layout4.putConstraint(SpringLayout.NORTH, novoChamadoStatusField, 0, SpringLayout.NORTH, novoChamadoStatusTag);
	    
	    layout4.putConstraint(SpringLayout.WEST, novoChamadoAtendenteTag, 0, SpringLayout.WEST, novoChamadoStatusTag);
	    layout4.putConstraint(SpringLayout.NORTH, novoChamadoAtendenteTag, 15, SpringLayout.SOUTH, novoChamadoStatusField);
	    layout4.putConstraint(SpringLayout.WEST, novoChamadoAtendenteField, 0, SpringLayout.WEST, novoChamadoStatusField);
	    layout4.putConstraint(SpringLayout.NORTH, novoChamadoAtendenteField, 0, SpringLayout.NORTH, novoChamadoAtendenteTag);
	    
	    layout4.putConstraint(SpringLayout.WEST, addChamado, 0, SpringLayout.WEST, novoChamadoAtendenteTag);
	    layout4.putConstraint(SpringLayout.NORTH, addChamado, 40, SpringLayout.SOUTH, novoChamadoAtendenteTag);
	    

	    layout4.putConstraint(SpringLayout.WEST, updateChamado, 15, SpringLayout.EAST, addChamado);
	    layout4.putConstraint(SpringLayout.NORTH, updateChamado, 0, SpringLayout.NORTH, addChamado);
	    layout4.putConstraint(SpringLayout.WEST, updateChamado, 15, SpringLayout.EAST, addChamado);
	    layout4.putConstraint(SpringLayout.NORTH, updateChamado, 0, SpringLayout.NORTH, addChamado);
	    layout4.putConstraint(SpringLayout.WEST, delChamado, 15, SpringLayout.EAST, updateChamado);
	    layout4.putConstraint(SpringLayout.NORTH, delChamado, 0, SpringLayout.NORTH, updateChamado);
	    
	    
	    layout4.putConstraint(SpringLayout.EAST, scrollableListaChamado, -15, SpringLayout.EAST, ChamadoPainel);
	    layout4.putConstraint(SpringLayout.NORTH, scrollableListaChamado, 20, SpringLayout.NORTH, ChamadoPainel);
	    layout4.putConstraint(SpringLayout.EAST, SairBotaoChamado, -30, SpringLayout.EAST, ChamadoPainel);
	    layout4.putConstraint(SpringLayout.SOUTH, SairBotaoChamado, -30, SpringLayout.SOUTH, ChamadoPainel);
	    
	    
	    //---------------------------JLists configuration-----------------------------------------
	    
		Chamadolistusuario.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		ChamadolistChamado.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		Chamadolistusuario.setCellRenderer(new ChamadoRenderer());
		ChamadolistChamado.setCellRenderer(new ChamadoRenderer());
		
		
		
	    //----------------------------Botaos listeners configuration----------------------------
	    
	    loginBotao.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				login.acesso(usuarioField.getText(), senhaField.getPassword());
				modeloList.clear();
			}});
	    
	    cadastrarBotao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(Arrays.equals(senhaFieldReg.getPassword(), resenhaFieldReg.getPassword())){ //checks if the two senhawords are the same
					login.registrarNovoUsuario(usuarioFieldReg.getText(), senhaFieldReg.getPassword());
				}
				else showMessageError("Senhas não conferem!");
			}});
	    
	    SairBotao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Controle = null;
				mainPainel.removeAll();
				mainPainel.addTab("Login", loginPainel);
				mainPainel.addTab("Cadastro", registrarPainel);
				usuarioField.setText("");
				senhaField.setText("");
				pesquisarField.setText("Insira um nome");
			}});
	    
	    SairBotaoChamado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Controle = null;
				mainPainel.removeAll();
				mainPainel.addTab("Login", loginPainel);
				mainPainel.addTab("Cadastro", registrarPainel);
				usuarioField.setText("");
				senhaField.setText("");
				pesquisarField.setText("Insira um nome");
			}});
	    
	    pesquisarBotao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String search = pesquisarField.getText();
				Controle.PesquisarChamados(new Chamado(search, " ", " ", " "," "));
			}});
	    
	    verChamado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Chamado sel = Chamadolistusuario.getSelectedValue();
				ChamadoNomeLabel.setText(sel.getNome());
				ChamadoTipoLabel.setText(sel.getTipo());
				ChamadoStatusLabel.setText(String.valueOf(sel.getStatus()));
				ChamadoDescLabel.setText(sel.getDescricao());
				ChamadoAtendenteLabel.setText(String.valueOf(sel.getAtendente()));
				
			}});
	    
	    addChamado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String Nome = novoChamadoNomeField.getText();
				String tipo = novoChamadoTipoField.getText();
				String descricao = novoChamadoDescField.getText();
				String status = novoChamadoStatusField.getText();
				String atendente = novoChamadoAtendenteField.getText();
				
				if(Controle instanceof ChamadoControle){
					Chamado p = new Chamado(Nome,tipo, descricao,status,atendente);
					((ChamadoControle) Controle).addChamado(p);
				}
			}});
	    
	    delChamado.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
				if(ChamadolistChamado.isSelectionEmpty()){
					showMessageError("Nenhuma chamado selecionado");
					return;
				}
				if(Controle instanceof ChamadoControle){

					Chamado p = ChamadolistChamado.getSelectedValue();
					((ChamadoControle) Controle).removeChamado(p);;
					modeloList.removeElement(p);
				}
			}});
	    
	    updateChamado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(ChamadolistChamado.isSelectionEmpty()){
					showMessageError("Nenhuma chamado selecionado");
					return;
				}
				String Nome = novoChamadoNomeField.getText();
				String tipo = novoChamadoTipoField.getText();
				String descricao = novoChamadoDescField.getText();
				String status = novoChamadoStatusField.getText();
				String atendente = novoChamadoAtendenteField.getText();;
				
				if(Controle instanceof ChamadoControle){
					Chamado pnovo = new Chamado(Nome,tipo, descricao,status,atendente);
					Chamado pold = ChamadolistChamado.getSelectedValue();
					((ChamadoControle) Controle).updateChamado(pold, pnovo);
					modeloList.removeElement(pold);
					modeloList.addElement(pnovo);
				}
			}});
	    
	    

	    
    
		add(mainPainel);
		mainPainel.addTab("Login", loginPainel);
		mainPainel.addTab("Cadastro", registrarPainel);
		setVisible(true);
	}

	public ControleAcesso getControle() {
		return Controle;
	}

	public void setControle(ControleAcesso Controle) {
		this.Controle = Controle;
	}

	public LoginAcesso getLogin() {
		return login;
	}

	public void setLogin(LoginAcesso login) {
		this.login = login;
	}

	public List<Chamado> getSearchResults() {
		return searchResults;
	}

	public void setSearchResults(ArrayList<Chamado> searchResults) {
		this.searchResults = searchResults;
	}

	/**
	 * @param message
	 */
	public void showMessage(String message) {
		JOptionPane.showMessageDialog(this, message);
	}

	/**
	 * @param error
	 */
	public void showMessageError(String error) {
		JOptionPane.showMessageDialog(this, error, "Error", JOptionPane.ERROR_MESSAGE);
	}

	/**
	 * @param auth
	 */
	public void Permitido(ControleAcesso auth) {
		setControle(auth);
		mainPainel.addTab("Pesquisar Chamado", usuarioPainel);
		mainPainel.remove(loginPainel);
		mainPainel.remove(registrarPainel);
		if(auth instanceof ChamadoControle){
			mainPainel.addTab("Cadastrar Chamado", ChamadoPainel);
		}
		
	}
	
	public void resultadosAchados(ArrayList<Chamado> p) {
		if(!p.isEmpty()){
			searchResults = p;
			modeloList.clear();
			for (Chamado Chamado : p) {
				modeloList.addElement(Chamado);
			}
		}
	}
}