package analizador.lexico;

import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Lexico2 {

    static ArrayList tokenList = new ArrayList();

    public Lexico2(String f) {
        try {
            DataInputStream in = new DataInputStream(new FileInputStream(f));
            try {
                File archivo = new File("CodigoLexico.txt");
                try ( BufferedWriter bufferedWriter = new BufferedWriter(
                        new FileWriter(archivo))) {
                    String bufferIn;
                    while ((bufferIn = in.readLine()) != null) {
                        int i = 0;
                        String cad = bufferIn.trim();
                        while (i < cad.length()) {
                            char t = cad.charAt(i);
                            if (Character.isDigit(t)) {
                                String ora = "";
                                ora = ora + t;
                                int j = i + 1;
                                if (j < cad.length()) {
                                    while (Character.isDigit(cad.charAt(j))) {
                                        ora = ora + cad.charAt(j);
                                        j++;
                                        if (j == cad.length()) {
                                            break;
                                        }
                                    }
                                }
                                i = j;

                                bufferedWriter.write("det ");
                            } else if (iscoment(t)) {
                                String ora = "";
                                ora = ora + t;
                                int j = i + 1;
                                while (!iscoment(cad.charAt(j))) {
                                    ora = ora + cad.charAt(j);
                                    j++;
                                    if (j == cad.length()) {
                                        break;
                                    }
                                }
                                ora = ora + cad.charAt(j);
                                i = j + 1;
                                bufferedWriter.write(" COMENTARIO ");
                            } else if (Character.isLetter(t)) {
                                String ora = "";
                                ora = ora + t;
                                int j = i + 1;
                                while (Character.isLetterOrDigit(cad.charAt(j))) {
                                    ora = ora + cad.charAt(j);
                                    j++;
                                    if (j == cad.length()) {
                                        break;
                                    }
                                }
                                i = j;
                                if (!"".equals(palabraReservada(ora))) {
                                    bufferedWriter.write(palabraReservada(ora)
                                            + " ");
                                } else {
                                    insertaId(ora);
                                    bufferedWriter.write("sust ");
                                }
                            } else if (Character.isLetter(t)) {
                                String ora = "";
                                ora = ora + t;
                                int j = i + 1;
                                while (Character.isLetterOrDigit(cad.charAt(j))) {
                                    ora = ora + cad.charAt(j);
                                    j++;
                                    if (j == cad.length()) {
                                        break;
                                    }
                                }
                                i = j;
                                if (!"".equals(palabraReservada(ora))) {
                                    bufferedWriter.write(palabraReservada(ora)
                                            + " ");
                                } else {
                                    insertaId(ora);
                                    bufferedWriter.write("sust ");
                                }
                            } else if (!Character.isLetterOrDigit(t)) {
                                String m_ora = "";
                                m_ora = m_ora + t;
                                if (t == ' ') {
                                    bufferedWriter.write(" ");
                                } else if (!"".equals(palabraReservada(m_ora
                                        + cad.charAt(i + 1)))) {
                                    bufferedWriter
                                            .write(palabraReservada(new StringBuilder(
                                                    String.valueOf(m_ora)).append(
                                                    cad.charAt(i + 1)).toString())
                                                    + " ");
                                    i++;
                                } else if (evaluarCaracter(t)) {
                                    bufferedWriter.write(evaluarSeparador(t) + " ");
                                } else if (!"".equals(palabraReservada(m_ora))) {
                                    bufferedWriter.write(palabraReservada(m_ora)
                                            + " ");
                                } else {
                                    bufferedWriter.write(evaluarOperador(t) + " ");
                                }
                                i++;
                            }
                        }
                        bufferedWriter.newLine();
                    }
                }
            } catch (IOException localIOException) {
            }
        } catch (FileNotFoundException localFileNotFoundException) {
        }
    }

    public static boolean evaluarCaracter(char c) {
        if (c == '(') {
            return true;
        }
        if (c == ')') {
            return true;
        }
        if (c == '{') {
            return true;
        }
        if (c == '}') {
            return true;
        }
        if (c == '<') {
            return false;
        }
        if (c == '>') {
            return false;
        }
        return false;
    }

    public static boolean iscoment(char c) {
        if (c == '"') {
            return true;
        }
        return false;
    }

    public static char evaluarOperador(char c) {
        char car = '\000';
        switch (c) {
            case '<' ->
                car = '<';
            case '>' ->
                car = '>';
            case ',' ->
                car = ',';
            case ';' ->
                car = ';';
            default -> {
            }
        }
        return car;
    }

    public static char evaluarSeparador(char c) {
        char car = '\000';
        switch (c) {
            case '(' ->
                car = '(';
            case ')' ->
                car = ')';
            case '{' ->
                car = '{';
            case '}' ->
                car = '}';
            default -> {
            }
        }
        return car;
    }

    public static String palabraReservada(String cad) {
        String token = "";
        for (int i = 0; i < tokenList.size(); i++) {
            ArrayList datos = (ArrayList) tokenList.get(i);
            int id = ((Integer) datos.get(2));
            if ((id == 1) && (cad.equalsIgnoreCase((String) datos.get(0)))) {
                token = (String) datos.get(1);
            }
        }
        return token;
    }

    public static void palabraReservadaIni() {
        ArrayList lexemas = new ArrayList();
        ArrayList reservadas = new ArrayList();
        reservadas.add("Amalia");
        reservadas.add("le");
        reservadas.add("compro");
        reservadas.add("a");
        reservadas.add("su");
        reservadas.add("padre");
        reservadas.add("2");
        reservadas.add("regalos");
        reservadas.add("?");
        reservadas.add("Cuanto");
        reservadas.add("valen");
        reservadas.add("2");
        reservadas.add("libras");
        reservadas.add("de");
        reservadas.add("cafe");
        reservadas.add("Aguila Roja");
        reservadas.add("?");
        reservadas.add("<=");
        reservadas.add("=>");
        reservadas.add("==");
        reservadas.add("<>");

        lexemas.add("sust");
        lexemas.add("pronom");
        lexemas.add("verbo");
        lexemas.add("prep");
        lexemas.add("sust");
        lexemas.add("sust");
        lexemas.add("det");
        lexemas.add("sust");
        lexemas.add("sust");
        lexemas.add("adj");
        lexemas.add("verbo");
        lexemas.add("det");
        lexemas.add("sust");
        lexemas.add("prep");
        lexemas.add("sust");
        lexemas.add("sust");
        lexemas.add("?");
        lexemas.add("<=");
        lexemas.add("=>");
        lexemas.add("==");
        lexemas.add("<>");
        for (int i = 0; i < reservadas.size(); i++) {
            ArrayList datos = new ArrayList();
            datos.add(reservadas.get(i));
            datos.add(lexemas.get(i));
            datos.add(1);
            tokenList.add(datos);
        }
    }

    public static void addId(String lexema) {
        ArrayList datos = new ArrayList();
        datos.add(lexema);
        datos.add("id");
        datos.add(0);
        tokenList.add(datos);
    }

    public static void addToken(String lexema, String token) {
        ArrayList datos = new ArrayList();
        datos.add(lexema);
        datos.add(token);
        datos.add(1);
        tokenList.add(datos);
    }

    public void insertaId(String ID) {
        int encontro = 0;
        for (int i = 0; i < tokenList.size(); i++) {
            ArrayList datos = new ArrayList();
            datos = (ArrayList) tokenList.get(i);
            if (ID.equalsIgnoreCase((String) datos.get(0))) {
                encontro = 1;
            }
        }
        if (encontro == 0) {
            addId(ID);
        }
    }
}
