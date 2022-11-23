package com.nalitnyk.cw1;

import java.io.*;
import java.net.URL;

public class Game implements IGame {

    @Override
    public void downloadFromGithub(String version) {
        // URL, з якої завантажуємо файл
        final String FILE_URL = "https://github.com/Anuken/Mindustry/releases/download/" + version + "/Mindustry.jar";
        // шлях, де буде зберігатися гра
        final String baseFolder = "C:\\Users\\Danylo\\Desktop\\University\\5 term\\Informational system projecting\\src\\main\\resources\\static\\";
        final String FILE_NAME =  baseFolder + "Mindustry " + version + ".jar";
        // створюємо новий файл у форматі `Mindustry v111.jar`
        final File GAME_JAR = new File(FILE_NAME);
        try {
            boolean isFileCreated = GAME_JAR.createNewFile();
            if (!isFileCreated) throw new IOException();
        } catch (IOException e) {
            System.out.println("[Game] Сталася помилка введення-виведення. Не вдалося створити файл");
            e.printStackTrace();
        }

        // Відкриваємо з'єднання до нашої юрльки та завантажуємо дані звідти у файл
        System.out.println("[Game] Почалося завантаження версії " + version + "...");
        try (BufferedInputStream in = new BufferedInputStream(new URL(FILE_URL).openStream());
             FileOutputStream fileOutputStream = new FileOutputStream(GAME_JAR)) {
            byte[] dataBuffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = in.read(dataBuffer, 0, 1024)) != -1) {
                fileOutputStream.write(dataBuffer, 0, bytesRead);
            }
            System.out.println("[Game] Завантаження версії " + version + " пройшло успішно!");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("[Game] Сталася помилка введення-виведення. Можливо такої версії немає...");

        }
    }

}
