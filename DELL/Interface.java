import javax.swing.*;
import java.awt.*;

public class Interface extends JFrame {
    
    private JTabbedPane tab;
    private JPanel aposta;
    private GridBagConstraints gbc = new GridBagConstraints();
    private ImageIcon img;
    private JLabel nomeLabel, cpfLabel, imgLabel, confirmacaoLabel;
    private JTextField nomeTextField, cpfTextField;
    private JComboBox<String> n1, n2, n3, n4, n5;
    private JButton surpresinhaButton, limparButton, registrarButton;
    private static String[] valores = {"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31","32","33","34","35","36","37","38","39","40","41","42","43","44","45","46","47","48","49","50"};
    private Font font = new Font("SansSerif", Font.BOLD, 12);
    private static String confirmacaoString = "";

    public Interface() {
        super("Dell");

        tab = new JTabbedPane();

        aposta = new JPanel(new GridBagLayout());

        img = new ImageIcon(getClass().getResource("DellBet.png"));
        imgLabel = new JLabel(img);
        gbc.gridx = 9;
        gbc.gridy = 10;
        gbc.gridheight = 10;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.VERTICAL;
        aposta.add(imgLabel, gbc);

        nomeLabel = new JLabel("   Nome");
        nomeLabel.setFont(font);
        gbc.gridx = 11;
        gbc.gridy = 10;
        gbc.gridheight = 1;
        gbc.gridwidth = 1;
        aposta.add(nomeLabel, gbc);

        cpfLabel = new JLabel("     CPF");
        cpfLabel.setFont(font);
        gbc.gridx = 11;
        gbc.gridy = 11;
        gbc.gridheight = 1;
        gbc.gridwidth = 1;
        aposta.add(cpfLabel, gbc);

        nomeTextField = new JTextField();
        gbc.gridx = 10;
        gbc.gridy = 10;
        gbc.gridheight = 1;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        aposta.add(nomeTextField, gbc);
        
        cpfTextField = new JTextField();
        gbc.gridx = 10;
        gbc.gridy = 11;
        gbc.gridheight = 1;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        aposta.add(cpfTextField, gbc);

        n1 = new JComboBox<String>(valores);
        gbc.gridx = 10;
        gbc.gridy = 12;
        gbc.gridheight = 1;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        aposta.add(n1, gbc);

        n2 = new JComboBox<String>(valores);
        gbc.gridx = 10;
        gbc.gridy = 13;
        gbc.gridheight = 1;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        aposta.add(n2, gbc);

        n3 = new JComboBox<String>(valores);
        gbc.gridx = 10;
        gbc.gridy = 14;
        gbc.gridheight = 1;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        aposta.add(n3, gbc);

        n4 = new JComboBox<String>(valores);
        gbc.gridx = 10;
        gbc.gridy = 15;
        gbc.gridheight = 1;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        aposta.add(n4, gbc);

        n5 = new JComboBox<String>(valores);
        gbc.gridx = 10;
        gbc.gridy = 16;
        gbc.gridheight = 1;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        aposta.add(n5, gbc);

        surpresinhaButton = new JButton("Surpresinha");
        gbc.gridx = 10;
        gbc.gridy = 17;
        gbc.gridheight = 1;
        gbc.gridwidth = 1;
        aposta.add(surpresinhaButton, gbc);

        limparButton = new JButton("Limpar");
        gbc.gridx = 11;
        gbc.gridy = 17;
        gbc.gridheight = 1;
        gbc.gridwidth = 1;
        aposta.add(limparButton, gbc);

        registrarButton = new JButton("Registrar Aposta");
        gbc.gridx = 10;
        gbc.gridy = 18;
        gbc.gridheight = 1;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        aposta.add(registrarButton, gbc);

        confirmacaoLabel = new JLabel(confirmacaoString);
        gbc.gridx = 10;
        gbc.gridy = 19;
        gbc.gridheight = 1;
        gbc.gridwidth = 1;
        aposta.add(confirmacaoLabel);
        
        tab.addTab("Aposta", aposta);

        add(tab);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(550, 350);
        this.setLocationRelativeTo(null);
        this.setVisible(true);

    }
}
