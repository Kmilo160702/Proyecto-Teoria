package compilador.simbolos;

import java.util.ArrayList;

public class TablaSimboloBase {

    private static TablaSimboloBase INSTANCE;

    public static TablaSimboloBase getInstance() {
        if (null == INSTANCE) {
            INSTANCE = new TablaSimboloBase();
        }
        return INSTANCE;
    }

    private ArrayList<Simbolo> simbolosInicial;

    public TablaSimboloBase() {
        simbolosInicial = new ArrayList<>();

        /*Arrays.asList(new Simbolo("pro", "programa", true), new Simbolo("int", "int", true),
                        new Simbolo("char", "char", true), new Simbolo("float", "float", true),
                        new Simbolo("leer", "leer", true), new Simbolo("imp", "imprimir", true),
                        new Simbolo("+", "+", true), new Simbolo("-", "-", true), new Simbolo("*", "*", true),
                        new Simbolo("/", "/", true), new Simbolo("=", "=", true), new Simbolo("ter", "terminar", true),
                        new Simbolo("min", "mientras", true), new Simbolo("si", "si", true),
                        new Simbolo("sino", "sino", true), new Simbolo("\"", "\"", true), new Simbolo(",", ",", true),
                        new Simbolo(";", ";", true), new Simbolo("(", "(", true), new Simbolo(")", ")", true),
                        new Simbolo("{", "{", true), new Simbolo("}", "}", true), new Simbolo("&", "&", true),
                        new Simbolo("&&", "&&", true), new Simbolo("|", "|", true), new Simbolo("||", "||", true))*/
    }

    public ArrayList<Simbolo> getSimbolosInicial() {
        return simbolosInicial;
    }

    public void setSimbolosInicial(ArrayList<Simbolo> simbolosInicial) {
        this.simbolosInicial = simbolosInicial;
    }

    public Simbolo getSimboloByLexema(String lexema) {
        for (Simbolo simbolo : this.simbolosInicial) {
            if (simbolo.getLexema().equalsIgnoreCase(lexema)) {
                return simbolo;
            }
        }
        return null;
    }

    public boolean isLexemaSimbolo(String lexema) {
        for (Simbolo simbolo : this.simbolosInicial) {
            if (simbolo.getLexema().equalsIgnoreCase(lexema) && simbolo.isPalabraReservada()) {
                return true;
            }
        }
        return false;
    }

    public boolean existLexemaId(String lexema) {
        for (Simbolo simbolo : this.simbolosInicial) {
            if ((lexema.equalsIgnoreCase(simbolo.getLexema())) && (!simbolo.isPalabraReservada())) {
                return true;
            }
        }
        return false;
    }
}
