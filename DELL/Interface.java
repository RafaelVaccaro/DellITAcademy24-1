import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Interface extends JFrame {

    private JTabbedPane tab;
    private JPanel aposta, sorteio, tabelaPanel;
    private JScrollPane listaApostas, tabelaValores;
    private GridBagConstraints gbc = new GridBagConstraints();
    private ImageIcon img;
    private JLabel nomeLabel, cpfLabel, imgLabel, confirmacaoLabel, sorteadosLabel, rodadasLabel, qtdVencedorasLabel,
            resultadoLabel;
    private JTextArea listaTextArea;
    private JTextField nomeTextField, cpfTextField, textFieldVazio;
    private JComboBox<String> n1, n2, n3, n4, n5;
    private JButton surpresinhaButton, registrarButton, sortearButton;
    private JTable tabela;

    private static String[] valores = { "Selecione o nº de aposta", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10",
            "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28",
            "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46",
            "47", "48", "49", "50" };
    private static String nomeString, cpfString, n1String, n2String, n3String, n4String, n5String, rodadasString;
    private static String sorteadosString = "";
    private static String qtdVencedorasString = "";
    private static String dadoTemp = "";
    private TratadorEventos tde;
    private boolean controleSorteio = true;
    private boolean controleSorteio2 = true;
    private static int rodadas = 0;
    private static int vencedoras = 0;
    private static double premio = 1000000;
    private Font font = new Font("SansSerif", Font.BOLD, 12);
    private Font font2 = new Font("SansSerif", Font.BOLD, 18);

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

        surpresinhaButton = new JButton("SURPRESINHA");
        gbc.gridx = 10;
        gbc.gridy = 17;
        gbc.gridheight = 1;
        gbc.gridwidth = 1;
        aposta.add(surpresinhaButton, gbc);

        registrarButton = new JButton("REGISTRAR APOSTA");
        gbc.gridx = 11;
        gbc.gridy = 17;
        gbc.gridheight = 1;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        aposta.add(registrarButton, gbc);

        sortearButton = new JButton("EXECUTAR SORTEIO");
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
        tab.addTab("REGISTRO APOSTA", aposta);
        tab.addTab("LISTA APOSTAS", listaApostas);

        add(tab);

        tde = new TratadorEventos();
        registrarButton.addActionListener(tde);
        surpresinhaButton.addActionListener(tde);
        sortearButton.addActionListener(tde);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(575, 375);
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
                confirmacaoLabel.setText("Apostas bloqueadas (seguir para aba APURAÇÃO)");
                confirmacaoLabel.setForeground(new java.awt.Color(76, 153, 0));
                /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
                String[] colunas = { "Nro apostado", "Qtd de apostas" };
                Object[][] dados = {
                        { "1", Tabela.c1 }, { "2", Tabela.c2 }, { "3", Tabela.c3 }, { "4", Tabela.c4 },
                        { "5", Tabela.c5 },
                        { "6", Tabela.c6 }, { "7", Tabela.c7 }, { "8", Tabela.c8 }, { "9", Tabela.c9 },
                        { "10", Tabela.c10 },
                        { "11", Tabela.c11 }, { "12", Tabela.c12 }, { "13", Tabela.c13 }, { "14", Tabela.c14 },
                        { "15", Tabela.c15 }, { "16", Tabela.c16 }, { "17", Tabela.c17 }, { "18", Tabela.c18 },
                        { "19", Tabela.c19 }, { "20", Tabela.c20 }, { "21", Tabela.c21 }, { "22", Tabela.c22 },
                        { "23", Tabela.c23 }, { "24", Tabela.c24 }, { "25", Tabela.c25 }, { "26", Tabela.c26 },
                        { "27", Tabela.c27 }, { "28", Tabela.c28 }, { "29", Tabela.c29 }, { "30", Tabela.c30 },
                        { "31", Tabela.c31 }, { "32", Tabela.c32 }, { "33", Tabela.c33 }, { "34", Tabela.c34 },
                        { "35", Tabela.c35 }, { "36", Tabela.c36 }, { "37", Tabela.c37 }, { "38", Tabela.c38 },
                        { "39", Tabela.c39 }, { "40", Tabela.c40 }, { "41", Tabela.c41 }, { "42", Tabela.c42 },
                        { "43", Tabela.c43 }, { "44", Tabela.c44 }, { "45", Tabela.c45 }, { "46", Tabela.c46 },
                        { "47", Tabela.c47 }, { "48", Tabela.c48 }, { "49", Tabela.c49 }, { "50", Tabela.c50 } };
                tabelaPanel = new JPanel(new GridLayout(1, 1));
                tabela = new JTable(dados, colunas);
                tabelaValores = new JScrollPane(tabela);
                tabelaPanel.add(tabelaValores);
                tab.addTab("TABELA VALORES", tabelaPanel);
                /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
                sorteio = new JPanel(new GridBagLayout());

                sorteadosLabel = new JLabel("", SwingConstants.CENTER);
                gbc.gridx = 10;
                gbc.gridy = 10;
                gbc.gridheight = 1;
                gbc.gridwidth = 1;
                gbc.fill = GridBagConstraints.HORIZONTAL;
                sorteio.add(sorteadosLabel, gbc);

                rodadasLabel = new JLabel("", SwingConstants.CENTER);
                gbc.gridx = 10;
                gbc.gridy = 11;
                gbc.gridheight = 1;
                gbc.gridwidth = 1;
                gbc.fill = GridBagConstraints.HORIZONTAL;
                sorteio.add(rodadasLabel, gbc);

                qtdVencedorasLabel = new JLabel("", SwingConstants.CENTER);
                gbc.gridx = 10;
                gbc.gridy = 12;
                gbc.gridheight = 1;
                gbc.gridwidth = 1;
                gbc.fill = GridBagConstraints.HORIZONTAL;
                sorteio.add(qtdVencedorasLabel, gbc);

                resultadoLabel = new JLabel("", SwingConstants.CENTER);
                resultadoLabel.setFont(font2);
                gbc.gridx = 10;
                gbc.gridy = 13;
                gbc.gridheight = 1;
                gbc.gridwidth = 1;
                gbc.fill = GridBagConstraints.HORIZONTAL;
                sorteio.add(resultadoLabel, gbc);

                tab.addTab("APURACAÇÃO", sorteio);
                /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

                while (controleSorteio2) {
                    {
                        String atual = Sorteio.sorteio();
                        for (String dado : Aposta.apostas) {
                            dadoTemp = dado;
                            if (atual.contains(dado)) {
                                vencedoras++;
                                controleSorteio2 = false;
                                if (vencedoras == 1) {
                                    resultadoLabel.setText(sorteadosString + "\n A PREMIAÇÃO É DE R$ " + premio + " PARA O VENCEDOR");
                                } else if (vencedoras > 1) {
                                    resultadoLabel.setText(sorteadosString + "\n A PREMIAÇÃO É DE R$ " + premio / vencedoras + " PARA CADA VENCEDOR");
                                } else if (vencedoras == 0) {

                                }
                            } else {
                                sorteadosString = sorteadosString + " " + dados;
                                resultadoLabel.setText("NÃO HOUVERAM VENCEDORES");
                            }

                        }
                        if (rodadas == 24)
                            controleSorteio2 = false;
                        rodadas++;
                    }
                }
                qtdVencedorasString = vencedoras + "";
                rodadasString = rodadas + "";
                sorteadosLabel.setText("Números sorteados: " + dadoTemp);
                rodadasLabel.setText("Rodadas realizadas: " + rodadasString);
                qtdVencedorasLabel.setText("Quantidade de apostas vencedoras: " + qtdVencedorasString);

            }

        }
    }
}
