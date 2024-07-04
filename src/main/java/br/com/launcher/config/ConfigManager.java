package br.com.launcher.config;

import java.util.prefs.Preferences;

public class ConfigManager {
    private static final String PREF_PATH1 = "path1";
    private static final String PREF_DELAY1 = "delay1";
    private static final String PREF_PATH2 = "path2";
    private static final String PREF_DELAY2 = "delay2";
    private static final String PREF_PATH3 = "path3";
    private static final String PREF_DELAY3 = "delay3";
    private static final String PREF_SAVE_DATA = "saveData";
    private static final String PREF_AUTO_START = "autoStart";
    private static final String PREF_PATH1_CHECKBOX = "path1Checkbox";
    private static final String PREF_PATH2_CHECKBOX = "path2Checkbox";
    private static final String PREF_PATH3_CHECKBOX = "path3Checkbox";

    private final Preferences prefs;

    public ConfigManager() {
        prefs = Preferences.userNodeForPackage(ConfigManager.class);
    }

    public String getPath1() {
        return prefs.get(PREF_PATH1, "");
    }

    public void setPath1(String path) {
        prefs.put(PREF_PATH1, path);
    }

    public String getDelay1() {
        return prefs.get(PREF_DELAY1, "5");
    }

    public void setDelay1(String delay) {
        prefs.put(PREF_DELAY1, delay);
    }

    public String getPath2() {
        return prefs.get(PREF_PATH2, "");
    }

    public void setPath2(String path) {
        prefs.put(PREF_PATH2, path);
    }

    public String getDelay2() {
        return prefs.get(PREF_DELAY2, "5");
    }

    public void setDelay2(String delay) {
        prefs.put(PREF_DELAY2, delay);
    }

    public String getPath3() {
        return prefs.get(PREF_PATH3, "");
    }

    public void setPath3(String path) {
        prefs.put(PREF_PATH3, path);
    }

    public String getDelay3() {
        return prefs.get(PREF_DELAY3, "5");
    }

    public void setDelay3(String delay) {
        prefs.put(PREF_DELAY3, delay);
    }

    public boolean isSaveDataEnabled() {
        return prefs.getBoolean(PREF_SAVE_DATA, false);
    }

    public void setSaveDataEnabled(boolean enabled) {
        prefs.putBoolean(PREF_SAVE_DATA, enabled);
    }

    public boolean isAutoStartEnabled() {
        return prefs.getBoolean(PREF_AUTO_START, false);
    }

    public void setAutoStartEnabled(boolean enabled) {
        prefs.putBoolean(PREF_AUTO_START, enabled);
    }

    public boolean isPath1CheckboxSelected() {
        return prefs.getBoolean(PREF_PATH1_CHECKBOX, false);
    }

    public void setPath1CheckboxSelected(boolean selected) {
        prefs.putBoolean(PREF_PATH1_CHECKBOX, selected);
    }

    public boolean isPath2CheckboxSelected() {
        return prefs.getBoolean(PREF_PATH2_CHECKBOX, false);
    }

    public void setPath2CheckboxSelected(boolean selected) {
        prefs.putBoolean(PREF_PATH2_CHECKBOX, selected);
    }

    public boolean isPath3CheckboxSelected() {
        return prefs.getBoolean(PREF_PATH3_CHECKBOX, false);
    }

    public void setPath3CheckboxSelected(boolean selected) {
        prefs.putBoolean(PREF_PATH3_CHECKBOX, selected);
    }

    public void clear() {
        prefs.remove(PREF_PATH1);
        prefs.remove(PREF_DELAY1);
        prefs.remove(PREF_PATH2);
        prefs.remove(PREF_DELAY2);
        prefs.remove(PREF_PATH3);
        prefs.remove(PREF_DELAY3);
        prefs.remove(PREF_SAVE_DATA);
        prefs.remove(PREF_AUTO_START);
        prefs.remove(PREF_PATH1_CHECKBOX);
        prefs.remove(PREF_PATH2_CHECKBOX);
        prefs.remove(PREF_PATH3_CHECKBOX);
    }
}
