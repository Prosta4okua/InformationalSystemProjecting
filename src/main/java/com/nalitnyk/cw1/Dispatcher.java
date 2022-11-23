package com.nalitnyk.cw1;

public class Dispatcher {
    public static void main(String[] args) {
        IGame game = new ProxyGame();

        game.downloadFromGithub("v140.4");
        game.downloadFromGithub("v137");
        game.downloadFromGithub("v140.4");
        game.downloadFromGithub("v111");
    }
}
