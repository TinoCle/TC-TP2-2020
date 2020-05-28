package app;

public class ID {
    private String data_type;
    private String name;
    private boolean used;
    private boolean initialized;

    public ID(String data_type, String name, Boolean initialized) {
        this.data_type = data_type;
        this.name = name;
        this.initialized = initialized;
        this.used = false;
    }

    public void setInitialized(boolean initialized) {
        this.initialized = initialized;
    }

    @Override
    public String toString() {
        return "\nID Found\nName: " + name + "\nType: " + data_type + "\nInitialized: " + initialized;
    }
}