package app.SymbolsTable;

public abstract class ID {
    private String type;
    private String name;
    private boolean used;
    private String value;

    public ID() {

    }

    public ID(String type, String name) {
        this.type = type;
        this.name = name;
        this.value = null;
        this.used = false;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isInitialized() {
        return this.value != null;
    }

    public boolean isUsed() {
        return this.used;
    }

    public void setUsed(boolean used) {
        this.used = used;
    }

    public String getValue() {
        return this.value;
    }

    public void setValue(String value) {
        this.value = value;
    }

}