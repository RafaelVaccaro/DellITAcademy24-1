import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Interface extends JFrame {

    private JTabbedPane tab;
    private JPanel aposta, sorteio;
    private JScrollPane listaApostas;
    private GridBagConstraints gbc = new GridBagConstraints();
    private ImageIcon img;
    private JLabel nomeLabel, cpfLabel, imgLabel, confirmacaoLabel;
    private JTextArea listaTextArea;
    private JTextField nomeTextField, cpfTextField, textFieldVazio;
    private JComboBox<String> n1, n2, n3, n4, n5;
    private JButton surpresinhaButton, registrarButton, sortearButton;
    private static String[] valores = { "Selecione o nº de aposta", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10",
            "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28",
            "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46",
            "47", "48", "49", "50" };
    private Font font = new Font("SansSerif", Font.BOLD, 12);
    private static String nomeString, cpfString, n1String, n2String, n3String, n4String, n5String;
    private static String sorteadosString = "";
    private static String vencedorasString = "";
    private TratadorEventos tde;
    private boolean controleSorteio = true;
    private boolean controleSorteio2 = true;
    private static int rodadas, vencedoras = 0;

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

        nomeLabel = new JLabel("                        Nome");
        nomeLabel.setFont(font);
        gbc.gridx = 11;
        gbc.gridy = 10;
        gbc.gridheight = 1;
        gbc.gridwidth = 1;
        aposta.add(nomeLabel, gbc);

        cpfLabel = new JLabel("                            CPF");
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

        registrarButton = new JButton("Registrar Aposta");
        gbc.gridx = 11;
        gbc.gridy = 17;
        gbc.gridheight = 1;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        aposta.add(registrarButton, gbc);

        sortearButton = new JButton("Sortear");
        gbc.gridx = 10;
        gbc.gridy = 18;
        gbc.gridheight = 1;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        aposta.add(sortearButton, gbc);

        confirmacaoLabel = new JLabel("", SwingConstants.CENTER);
        gbc.gridx = 10;
        gbc.gridy = 19;
        gbc.gridheight = 1;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        aposta.add(confirmacaoLabel, gbc);

        textFieldVazio = new JTextField();
        //////////////////////////////////////////////////////////
        listaTextArea = new JTextArea("AGUARDANDO REGISTRO");
        listaApostas = new JScrollPane(listaTextArea);
        /////////////////////////////////////////////////////////////////////////
        sorteio = new JPanel(new GridBagLayout());

        /////////////////////////////////////////////////////////////////////////
        tab.addTab("REGISTRO APOSTA", aposta);
        tab.addTab("LISTA APOSTAS", listaApostas);
        tab.addTab("SORTEIO", sorteio);

        add(tab);

        tde = new TratadorEventos();
        registrarButton.addActionListener(tde);
        surpresinhaButton.addActionListener(tde);
        sortearButton.addActionListener(tde);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(550, 375);
        this.setLocationRelativeTo(null);
        this.getContentPane().setBackground(new java.awt.Color(153, 204, 255));
        this.setVisible(true);

    }

    private class TratadorEventos implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {

            if (controleSorteio) {

                if (e.getSource() == registrarButton) {

                    nomeString = nomeTextField.getText();
                    cpfString = cpfTextField.getText();
                    n1String = n1.getSelectedItem().toString();
                    n2String = n2.getSelectedItem().toString();
                    n3String = n3.getSelectedItem().toString();
                    n4String = n4.getSelectedItem().toString();
                    n5String = n5.getSelectedItem().toString();

                    if (n1String.equals("Selecione o nº de aposta") || n2String.equals("Selecione o nº de    aposta")
                            || n3String.equals("Selecione o nº de aposta")
                            || n4String.equals("Selecione o nº de aposta")
                            || n5String.equals("Selecione o nº de aposta")) {
                        confirmacaoLabel.setText("Selecione todos nº de aposta");
                        confirmacaoLabel.setForeground(Color.RED);
                    } else if (n1String.equals(n2String) || n1String.equals(n3String)
                            || n1String.equals(n4String) || n1String.equals(n5String)
                            || n2String.equals(n3String) || n2String.equals(n4String) || n2String.equals(n5String)
                            || n3String.equals(n4String) || n3String.equals(n5String)
                            || n4String.equals(n5String)) {
                        confirmacaoLabel.setText("Valores repetidos são inválidos");
                        confirmacaoLabel.setForeground(Color.RED);
                    } else if (nomeTextField.getText().equals(textFieldVazio.getText())
                            && cpfTextField.getText().equals(textFieldVazio.getText())) {
                        confirmacaoLabel.setText("Nome e CPF devem ser preenchidos");
                        confirmacaoLabel.setForeground(Color.RED);
                    } else if (nomeTextField.getText().equals(textFieldVazio.getText())) {
                        confirmacaoLabel.setText("Nome deve ser preenchido");
                        confirmacaoLabel.setForeground(Color.RED);
                    } else if (cpfTextField.getText().equals(textFieldVazio.getText())) {
                        confirmacaoLabel.setText("CPF deve ser preenchido");
                        confirmacaoLabel.setForeground(Color.RED);
                    } else {
                        Aposta.registrarAposta(nomeString, cpfString, n1String, n2String, n3String, n4String, n5String);
                        confirmacaoLabel.setText("Aposta registrada");
                        confirmacaoLabel.setForeground(Color.BLUE);
                        listaTextArea.setText(Reader.read());
                    }
                }

                if (e.getSource() == surpresinhaButton) {

                    nomeString = nomeTextField.getText();
                    cpfString = cpfTextField.getText();

                    if (nomeTextField.getText().equals(textFieldVazio.getText())
                            && cpfTextField.getText().equals(textFieldVazio.getText())) {
                        confirmacaoLabel.setText("Nome e CPF devem ser preenchidos");
                        confirmacaoLabel.setForeground(Color.RED);
                    } else if (nomeTextField.getText().equals(textFieldVazio.getText())) {
                        confirmacaoLabel.setText("Nome deve ser preenchido");
                        confirmacaoLabel.setForeground(Color.RED);
                    } else if (cpfTextField.getText().equals(textFieldVazio.getText())) {
                        confirmacaoLabel.setText("CPF deve ser preenchido");
                        confirmacaoLabel.setForeground(Color.RED);
                    } else {
                        Aposta.registrarApostaSurpresa(nomeString, cpfString, Aposta.surpresinha());
                        confirmacaoLabel.setText("Aposta surpresa registrada");
                        confirmacaoLabel.setForeground(Color.BLUE);
                        listaTextArea.setText(Reader.read());
                    }
                }
            }

            if (e.getSource() == sortearButton) {

                controleSorteio = false;
                confirmacaoLabel.setText("Apostas bloqueadas (seguir para aba SORTEIO)");
                confirmacaoLabel.setForeground(new java.awt.Color(76, 153, 0));

                while (controleSorteio2) {
                    {
                        String atual = Sorteio.sorteio();
                        for (String dados : Aposta.apostas) {
                            if (atual.equals(dados)) {
                                vencedoras++;
                                vencedorasString = vencedorasString + " " + dados;
                                sorteadosString = sorteadosString + " " + dados;
                                controleSorteio2 = false;
                            } else {
                                sorteadosString = sorteadosString + " " + dados;
                            }
                            if (rodadas == 24)
                            controleSorteio2 = false;
                        }
                        rodadas++;
                    }
                }
                System.out.println(rodadas);
                System.out.println(vencedoras);
                System.out.print(sorteadosString);
            }

        }
    }
}
