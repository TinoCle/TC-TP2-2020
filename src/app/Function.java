package app;

import java.util.ArrayList;

public class Function {
    private String type;
    private String name;
    private boolean used;
    private ArrayList<ID> params;

    public Function() {
        this.params = new ArrayList<ID>();
    }

    public Function(String type, String name) {
        this.params = new ArrayList<ID>();
        this.type = type;
        this.name = name;
        this.used = false;
    }

    @Override
    public String toString() {
        String function = "\n=== Function ===\nName:\t" + name + "\nType:\t" + type;
        for (ID id : params) {
            function += "\nParam:\n\tName: "+ id.getName() + "\n\tType: " + id.getType();
        }
        return function;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isUsed() {
        return used;
    }

    public void setUsed(boolean used) {
        this.used = used;
    }

    public ArrayList<ID> getParams() {
        return params;
    }

    public void setParams(ArrayList<ID> params) {
        this.params = params;
    }

    public void addParam(ID id) {
        this.params.add(id);
    }

    

    

}