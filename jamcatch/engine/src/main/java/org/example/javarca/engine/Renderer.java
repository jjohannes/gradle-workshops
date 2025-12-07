package org.example.javarca.engine;

import java.util.ServiceLoader;

/**
 * Interface to be implemented on top of a library or framework that renders a running game.
 * The implementation should use {@link GameLoop} and {@link GameState},
 */
public interface Renderer {
    static void launch() {
        System.out.println("Welcome to Javarcade!");

        Thread.setDefaultUncaughtExceptionHandler((thread, throwable) -> {
            System.out.println("Unexpected crash!" + throwable.getMessage());
            throwable.printStackTrace();
            throw new RuntimeException(throwable);
        });

        var impl = ServiceLoader.load(Renderer.class).findFirst();
        impl.ifPresentOrElse(Renderer::run, () -> System.out.println("No renderer implementation available"));
    }

    void run();
}
