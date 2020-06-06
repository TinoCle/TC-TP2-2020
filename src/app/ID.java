package app;

public abstract class ID {
    private String type;
    private String name;
    private boolean used;
    private Integer value;

    public ID() {

    }

    public ID(String type, String name) {
        this.type = type;
        this.name = name;
        this.value = null;
        this.used = false;
    }

    @Override
    public String toString() {
        return "\n=== ID ===\nName:\t" + name + "\nType:\t" + type + "\nValue:\t" + value;
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

    public Integer getValue() {
        return this.value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

}