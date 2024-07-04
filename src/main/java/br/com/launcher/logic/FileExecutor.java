package br.com.launcher.logic;

import java.io.File;
import java.io.IOException;

public class FileExecutor {
    public Process executeFile(String path, int delayInSeconds) throws InterruptedException, IOException {
        if (path == null || path.isEmpty() || !new File(path).exists()) {
            throw new IllegalArgumentException("Caminho do arquivo é inválido: " + path);
        }
        long delayInMillis = delayInSeconds * 1000L;
        Thread.sleep(delayInMillis);
        return Runtime.getRuntime().exec(path);
    }
}