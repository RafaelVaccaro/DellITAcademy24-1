import javax.swing.*;
import java.awt.*;

public class Interface extends JFrame {
    
    private JTabbedPane tab;
    private JPanel aposta;
    private JLabel nomeLabel, cpfLabel, confirmacaoLabel;
    private JTextField nomeTextField, cpfTextField;
    private JComboBox<String> n1, n2, n3, n4, n5;
    private JButton surpresinhaButton, limparButton, registrarButton;
    private static String[] valores = {"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31","32","33","34","35","36","37","38","39","40","41","42","43","44","45","46","47","48","49","50"};
    Font font = new Font("SansSerif", Font.BOLD, 15);

    public Interface() {
        super("Dell");

        tab = new JTabbedPane();

        aposta = new JPanel(new GridBagLayout());

        nomeLabel = new JLabel("Nome:");
        nomeLabel.setFont(font);


        tab.addTab("Aposta", aposta);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500, 300);
        this.setLocationRelativeTo(null);
        this.setVisible(true);

    }
}
