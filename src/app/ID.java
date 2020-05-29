package app;

public class ID {
    private String type;
    private String name;
    private boolean used;
    private boolean initialized;

    public ID(String type, String name, Boolean initialized) {
        this.type = type;
        this.name = name;
        this.initialized = initialized;
        this.used = false;
    }

    public void setInitialized(boolean initialized) {
        this.initialized = initialized;
    }

    @Override
    public String toString() {
        return "\nID Found\nName: " + name + "\nType: " + type + "\nInitialized: " + initialized;
    }

    public String getType(){
        return this.type;
    }

    public String getName(){
        return this.name;
    }

    public boolean isInitialized(){
        return this.initialized;
    }

    public boolean isUsed(){
        return this.used;
    }


}