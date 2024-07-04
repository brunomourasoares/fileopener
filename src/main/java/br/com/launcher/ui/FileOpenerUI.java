package br.com.launcher.ui;

import br.com.launcher.config.ConfigManager;
import br.com.launcher.logic.FileExecutor;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.text.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class FileOpenerUI extends JFrame {
    private final JTextField path1Field, delay1Field, path2Field, delay2Field, path3Field, delay3Field;
    private final JButton startButton, path1BrowseButton, path2BrowseButton, path3BrowseButton;
    private final JCheckBox saveDataCheckBox, autoStartCheckBox;
    private final JCheckBox path1CheckBox, path2CheckBox, path3CheckBox;
    private JSeparator separator;
    private final JLabel status1Label, status2Label, status3Label;

    private final ConfigManager configManager;
    private final FileExecutor fileExecutor;

    public FileOpenerUI() {
        configManager = new ConfigManager();
        fileExecutor = new FileExecutor();
        status1Label = new JLabel("Exe 1: Não Iniciado");
        status2Label = new JLabel("Exe 2: Não Iniciado");
        status3Label = new JLabel("Exe 3: Não Iniciado");

        setTitle("File Opener");
        setIconImage(Toolkit.getDefaultToolkit().getImage(FileOpenerUI.class.getResource("/icon.png")));
        setSize(550, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.insets = new Insets(5, 10, 5, 10);
        constraints.fill = GridBagConstraints.HORIZONTAL;

        JLabel path1Label = new JLabel("Caminho do executável 1:");
        constraints.gridx = 0;
        constraints.gridy = 0;
        panel.add(path1Label, constraints);

        path1Field = new JTextField(20);
        constraints.gridx = 1;
        constraints.gridwidth = 1;
        panel.add(path1Field, constraints);

        path1BrowseButton = new JButton("Localizar");
        constraints.gridx = 2;
        path1BrowseButton.setToolTipText("Localizar o executável 1");
        panel.add(path1BrowseButton, constraints);

        path1CheckBox = new JCheckBox("Desativar");
        constraints.gridx = 2;
        constraints.gridy = 1;
        path1CheckBox.setToolTipText("Desativar o executável 1");
        panel.add(path1CheckBox, constraints);

        path1BrowseButton.addActionListener(e -> selectExe(path1Field));

        JLabel delay1Label = new JLabel("Atraso em segundos:");
        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.gridwidth = 1;
        panel.add(delay1Label, constraints);

        delay1Field = new JTextField("5", 10);
        ((AbstractDocument) delay1Field.getDocument()).setDocumentFilter(new NumberFilter());
        constraints.gridx = 1;
        constraints.gridwidth = 1;
        panel.add(delay1Field, constraints);

        path1CheckBox.addActionListener(e -> setFieldsEnabled(path1CheckBox, path1Field, delay1Field, path1BrowseButton));

        separator = new JSeparator(JSeparator.HORIZONTAL);
        constraints.gridx = 0;
        constraints.gridy = 2;
        constraints.gridwidth = 4;
        panel.add(separator, constraints);

        JLabel path2Label = new JLabel("Caminho do executável 2:");
        constraints.gridx = 0;
        constraints.gridy = 3;
        panel.add(path2Label, constraints);

        path2Field = new JTextField(20);
        constraints.gridx = 1;
        constraints.gridwidth = 1;
        panel.add(path2Field, constraints);

        path2BrowseButton = new JButton("Localizar");
        constraints.gridx = 2;
        path2BrowseButton.setToolTipText("Localizar o executável 2");
        panel.add(path2BrowseButton, constraints);

        path2CheckBox = new JCheckBox("Desativar");
        constraints.gridx = 2;
        constraints.gridy = 4;
        path2CheckBox.setToolTipText("Desativar o executável 2");
        panel.add(path2CheckBox, constraints);

        path2BrowseButton.addActionListener(e -> selectExe(path2Field));

        JLabel delay2Label = new JLabel("Atraso em segundos:");
        constraints.gridx = 0;
        constraints.gridy = 4;
        constraints.gridwidth = 1;
        panel.add(delay2Label, constraints);

        delay2Field = new JTextField("5", 10);
        ((AbstractDocument) delay2Field.getDocument()).setDocumentFilter(new NumberFilter());
        constraints.gridx = 1;
        constraints.gridwidth = 1;
        panel.add(delay2Field, constraints);

        path2CheckBox.addActionListener(e -> setFieldsEnabled(path2CheckBox, path2Field, delay2Field, path2BrowseButton));

        separator = new JSeparator(JSeparator.HORIZONTAL);
        constraints.gridx = 0;
        constraints.gridy = 5;
        constraints.gridwidth = 4;
        panel.add(separator, constraints);

        JLabel path3Label = new JLabel("Caminho do executável 3:");
        constraints.gridx = 0;
        constraints.gridy = 6;
        panel.add(path3Label, constraints);

        path3Field = new JTextField(20);
        constraints.gridx = 1;
        constraints.gridwidth = 1;
        panel.add(path3Field, constraints);

        path3BrowseButton = new JButton("Localizar");
        constraints.gridx = 2;
        path3BrowseButton.setToolTipText("Localizar o executável 3");
        panel.add(path3BrowseButton, constraints);

        path3CheckBox = new JCheckBox("Desativar");
        constraints.gridx = 2;
        constraints.gridy = 7;
        path3CheckBox.setToolTipText("Desativar o executável 3");
        panel.add(path3CheckBox, constraints);

        path3BrowseButton.addActionListener(e -> selectExe(path3Field));

        JLabel delay3Label = new JLabel("Atraso em segundos:");
        constraints.gridx = 0;
        constraints.gridy = 7;
        constraints.gridwidth = 1;
        panel.add(delay3Label, constraints);

        delay3Field = new JTextField("5", 10);
        ((AbstractDocument) delay3Field.getDocument()).setDocumentFilter(new NumberFilter());
        constraints.gridx = 1;
        constraints.gridwidth = 1;
        panel.add(delay3Field, constraints);

        path3CheckBox.addActionListener(e -> setFieldsEnabled(path3CheckBox, path3Field, delay3Field, path3BrowseButton));

        separator = new JSeparator(JSeparator.HORIZONTAL);
        constraints.gridx = 0;
        constraints.gridy = 8;
        constraints.gridwidth = 4;
        panel.add(separator, constraints);

        saveDataCheckBox = new JCheckBox("Salvar Configurações");
        constraints.gridx = 0;
        constraints.gridy = 9;
        constraints.gridwidth = 1;
        panel.add(saveDataCheckBox, constraints);

        autoStartCheckBox = new JCheckBox("Iniciar Executáveis ao Abrir");
        constraints.gridx = 0;
        constraints.gridy = 10;
        panel.add(autoStartCheckBox, constraints);

        JLabel contact = new JLabel("<html><a href=''>CONTATO</a></html>");
        constraints.gridx = 2;
        constraints.gridy = 9;
        contact.setCursor(new Cursor(Cursor.HAND_CURSOR));
        contact.setToolTipText("Contato do Desenvolvedor");
        panel.add(contact, constraints);

        startButton = new JButton("Iniciar Executáveis");
        constraints.gridx = 0;
        constraints.gridy = 12;
        constraints.gridwidth = 4;
        constraints.ipady = 10;
        startButton.addActionListener(e -> startExecutables());
        panel.add(startButton, constraints);

        constraints.gridx = 0;
        constraints.gridy = 11;
        panel.add(status1Label, constraints);
        constraints.gridx = 1;
        constraints.gridy = 11;
        panel.add(status2Label, constraints);
        constraints.gridx = 2;
        constraints.gridy = 11;
        panel.add(status3Label, constraints);

        setContentPane(panel);

        saveDataCheckBox.addActionListener(e -> {
            if (saveDataCheckBox.isSelected()) {
                saveConfig();
            } else {
                cleanConfig();
            }
        });

        autoStartCheckBox.addActionListener(e -> {
            if (autoStartCheckBox.isSelected()) {
                saveDataCheckBox.setSelected(true);
            }
        });

        contact.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                showDialog();
            }
        });

        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                if (saveDataCheckBox.isSelected()) {
                    saveConfig();
                } else {
                    cleanConfig();
                }
            }
        });

        loadConfig();

        if (autoStartCheckBox.isSelected()) {
            Timer timer = new Timer(2000, e -> startExecutables());
            timer.setRepeats(false);
            timer.start();
        }
    }

    private void showDialog() {
        String nome = "Bruno M. S.";
        String email = "brunomourasoares@gmail.com";
        JOptionPane.showMessageDialog(null, "Nome: " + nome + "\nEmail: " + email, "Desenvolvedor", JOptionPane.INFORMATION_MESSAGE);
    }

    private void selectExe(JTextField pathField) {
        JFileChooser fileChooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Arquivos Executáveis (*.exe)", "exe");
        fileChooser.setFileFilter(filter);
        int result = fileChooser.showOpenDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            pathField.setText(selectedFile.getAbsolutePath());
        }
    }

    private void setFieldsEnabled(JCheckBox checkBox, JTextField pathField, JTextField delayField, JButton browseButton) {
        boolean enabled = !checkBox.isSelected();
        pathField.setEnabled(enabled);
        delayField.setEnabled(enabled);
        browseButton.setEnabled(enabled);
    }

    private void startExecutables() {
        SwingWorker<Void, Void> worker = new SwingWorker<>() {
            @Override
            protected Void doInBackground() {
                try {
                    Process process1 = null, process2 = null, process3 = null;
                    if (!path1CheckBox.isSelected() && !path1Field.getText().isEmpty()) {
                        int delay1InSeconds = Integer.parseInt(delay1Field.getText().trim());
                        process1 = fileExecutor.executeFile(path1Field.getText(), delay1InSeconds);
                        monitorProcess(process1, status1Label);
                    }

                    if (!path2CheckBox.isSelected() && !path2Field.getText().isEmpty()) {
                        int delay2InSeconds = Integer.parseInt(delay2Field.getText().trim());
                        process2 = fileExecutor.executeFile(path2Field.getText(), delay2InSeconds);
                        monitorProcess(process2, status2Label);
                    }

                    if (!path3CheckBox.isSelected() && !path3Field.getText().isEmpty()) {
                        int delay3InSeconds = Integer.parseInt(delay3Field.getText().trim());
                        process3 = fileExecutor.executeFile(path3Field.getText(), delay3InSeconds);
                        monitorProcess(process3, status3Label);
                    }
                } catch (NumberFormatException | InterruptedException | IOException e) {
                    JOptionPane.showMessageDialog(FileOpenerUI.this, "Erro ao iniciar os executáveis: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
                }
                return null;
            }
        };

        worker.execute();
    }

    private void cleanConfig() {
        configManager.clear();
    }

    private void loadConfig() {
        path1Field.setText(configManager.getPath1());
        delay1Field.setText(configManager.getDelay1());
        path2Field.setText(configManager.getPath2());
        delay2Field.setText(configManager.getDelay2());
        path3Field.setText(configManager.getPath3());
        delay3Field.setText(configManager.getDelay3());

        saveDataCheckBox.setSelected(configManager.isSaveDataEnabled());
        autoStartCheckBox.setSelected(configManager.isAutoStartEnabled());

        path1CheckBox.setSelected(configManager.isPath1CheckboxSelected());
        path2CheckBox.setSelected(configManager.isPath2CheckboxSelected());
        path3CheckBox.setSelected(configManager.isPath3CheckboxSelected());

        setFieldsEnabled(path1CheckBox, path1Field, delay1Field, path1BrowseButton);
        setFieldsEnabled(path2CheckBox, path2Field, delay2Field, path2BrowseButton);
        setFieldsEnabled(path3CheckBox, path3Field, delay3Field, path3BrowseButton);
    }

    private void saveConfig() {
        configManager.setPath1(path1Field.getText());
        configManager.setDelay1(delay1Field.getText());
        configManager.setPath2(path2Field.getText());
        configManager.setDelay2(delay2Field.getText());
        configManager.setPath3(path3Field.getText());
        configManager.setDelay3(delay3Field.getText());

        configManager.setSaveDataEnabled(saveDataCheckBox.isSelected());
        configManager.setAutoStartEnabled(autoStartCheckBox.isSelected());

        configManager.setPath1CheckboxSelected(path1CheckBox.isSelected());
        configManager.setPath2CheckboxSelected(path2CheckBox.isSelected());
        configManager.setPath3CheckboxSelected(path3CheckBox.isSelected());
    }

    private void monitorProcess(Process process, JLabel statusLabel) {
        new Thread(() -> {
            try {
                process.waitFor();
                SwingUtilities.invokeLater(() -> statusLabel.setText("Status: Fechado"));
            } catch (InterruptedException e) {
                SwingUtilities.invokeLater(() -> statusLabel.setText("Status: Erro"));
            }
        }).start();
        statusLabel.setText("Status: Aberto");
    }

    static class NumberFilter extends DocumentFilter {
        @Override
        public void insertString(FilterBypass fb, int offset, String string, AttributeSet attr) throws BadLocationException {
            if (string.matches("\\d*")) {
                super.insertString(fb, offset, string, attr);
            }
        }

        @Override
        public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
            if (text.matches("\\d*")) {
                super.replace(fb, offset, length, text, attrs);
            }
        }
    }
}
