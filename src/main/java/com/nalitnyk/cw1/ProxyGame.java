package com.nalitnyk.cw1;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class ProxyGame implements IGame {
    private IGame game;
    private final List<String> cache;

    public ProxyGame() {
        this.cache = new ArrayList<>(1);
        getDownloadedVersionsFromDisk();
    }

    @Override
    public void downloadFromGithub(String version) {
        if (game == null) game = new Game();


        if (cache.contains(version)) {
            System.out.println("[Proxy]Версія " + version + " знайдена в кеші, тому її не завантажуємо\n");
        } else {
            System.out.println("[Proxy] Починаємо завантаження гри. Версія гри: " + version);
            game.downloadFromGithub(version);
            cache.add(version);
            System.out.println("[Proxy] Завантаження версії " + version + " минуло успішно, якщо не вивелося повідомлення про помилку. Вітаю!\n");
        }
    }

    private void getDownloadedVersionsFromDisk() {
        final String baseFolder = "C:\\Users\\Danylo\\Desktop\\University\\5 term\\Informational system projecting\\src\\main\\resources\\static\\";
        File[] fileList = new File(baseFolder).listFiles();
        if (fileList != null) for (File file : fileList) {
            String name = file.getName().replace(".jar", "").replace("Mindustry ", "");
            cache.add(name);

        }
    }
}
