package model;

public class Currency {
    private final String name;
    private final String fullname;
    private final Character symbol;

    public Currency(String name, String fullname, Character sign) {
        this.name = name;
        this.symbol = sign;
        this.fullname = fullname;
    }

    public String getName() {
        return name;
    }

    public String getFullname() {
        return fullname;
    }

    public Character getSymbol() {
        return symbol;
    }

    @Override
    public String toString(){
        return name + ", " + fullname + (symbol == null? "" : " (" + symbol + ")");
    }
}
