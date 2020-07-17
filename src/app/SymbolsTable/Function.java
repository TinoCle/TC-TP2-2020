package app.SymbolsTable;

import java.util.ArrayList;

public class Function extends ID{
    private ArrayList<ID> params;

    public Function() {
        this.params = new ArrayList<ID>();
    }

    public Function(String type, String name) {
        super();
        this.setType(type);
        this.setName(name);
        this.params = new ArrayList<ID>();
    }


    @Override
    public String toString() {
        String function = getType() + " " + getName() + "(";
        int i = 0;
        for (ID id : params) {
            if (i++ != 0) {
                function += ", ";
            }
            function += id.getType();
            function += " = " + id.getValue();
            if (!id.getName().isEmpty()) {
                function += " " + id.getName();
            }
        }
        if (isUsed() || getName().equals("main")) {
            function += ") (used)";
        } else {
            function += ") (unused)";
        }
        return function;
    }

    @Override
    public boolean equals(Object obj) {
        Function prototype = (Function) obj;
        if (this.params.size() != prototype.getParams().size())
            return false;
        else{
            for (int i = 0; i < this.params.size(); i++) {
                if (!this.params.get(i).getType().equals(prototype.getParams().get(i).getType())){
                    return false;
                }
            }
            return true;
        }
        
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