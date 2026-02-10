package config;

import java.io.InputStream;
import java.util.Properties;

public final class ConfigLoader {
    private static final Properties props = new Properties();
    private static boolean loaded = false;

    public static synchronized void load() {
        if (loaded) return;

        String env = System.getProperty("env", "qa");
        String file = "config/" + env + ".properties";

        try (InputStream is = ConfigLoader.class.getClassLoader().getResourceAsStream(file)) {
            if (is == null) throw new RuntimeException("Config file not found: " + file);
            props.load(is);
            loaded = true;
        } catch (Exception e) {
            throw new RuntimeException("Failed to load config: " + file, e);
        }
    }

    public static String get(String key) {
        String override = System.getProperty(key);
        if (override != null && !override.isBlank()) return override;

        String val = props.getProperty(key);
        if (val == null) throw new RuntimeException("Missing config key: " + key);
        return val;
    }

    public static int getInt(String key) {
        return Integer.parseInt(get(key));
    }

    private ConfigLoader() {}
}
