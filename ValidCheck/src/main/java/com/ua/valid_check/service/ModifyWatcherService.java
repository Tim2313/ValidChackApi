package com.ua.valid_check.service;

import com.ua.valid_check.Main;

import java.io.IOException;
import java.nio.file.*;

public class ModifyWatcherService {
    public static void fileWatcher() {
        final Path path = FileSystems.getDefault().getPath(System.getProperty("user.home"), "Desktop");
        try (final WatchService watchService = FileSystems.getDefault().newWatchService()) {
            final WatchKey watchKey = path.register(watchService, StandardWatchEventKinds.ENTRY_MODIFY);
            while (true) {
                final WatchKey wk = watchService.take();
                for (WatchEvent<?> event : wk.pollEvents()) {
                    //we only register "ENTRY_MODIFY" so the context is always a Path.
                    final Path changed = (Path) event.context();
                    System.out.println(changed);
                    if (changed.endsWith(Main.BLOCKED_IPS_FILEPATH)) {
                        System.out.println("My file has changed");
                    }
                }
                // reset the key
                boolean valid = wk.reset();
                if (!valid) {
                    System.out.println("Key has been unregisterede");
                }
            }
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);

        }

    }
}
