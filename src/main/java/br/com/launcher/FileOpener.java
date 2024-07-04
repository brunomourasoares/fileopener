package br.com.launcher;

import br.com.launcher.ui.FileOpenerUI;

import javax.swing.*;

public class FileOpener {
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }

        SwingUtilities.invokeLater(() -> {
            FileOpenerUI fileOpenerUI = new FileOpenerUI();
            fileOpenerUI.setVisible(true);
        });
    }
}
