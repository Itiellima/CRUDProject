package CONTROLLER;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

//https://www.youtube.com/watch?v=I54DuySunz8
public class Limitador_caracteres extends PlainDocument{
    
    public enum Tipo_dado_Entrada{
        CPF, NOME, DIA, MES, ANO, EMAIL, POSICAO_TAB;
    };
    
    private int Qtd_Caracteres;
    private Tipo_dado_Entrada Tipo_Entrada;

    public Limitador_caracteres(int Qtd_Caracteres, Tipo_dado_Entrada Tipo_Entrada) {
        this.Qtd_Caracteres = Qtd_Caracteres;
        this.Tipo_Entrada = Tipo_Entrada;
    }

    @Override
    public void insertString(int offs, String str, AttributeSet a) throws BadLocationException {
        if(str == null || getLength() == Qtd_Caracteres){ //getLength() pega a quantidade de caracteres q já há no TextField
            return;
        }
        int totalCaracteres = getLength() + str.length(); //pega o total de caracteres
        //Filtro de Caracteres para limitar, e aceitar os caracteres, de acordo com o tipo
        String Regex = "";
        switch(Tipo_Entrada){
            case CPF -> Regex = "[^0-9]";
            case NOME -> Regex = "[^\\p{IsLatin} ]";
            case DIA -> Regex = "[^0-9]";
            case MES -> Regex = "[^0-9]";
            case ANO -> Regex = "[^0-9]";
            case EMAIL -> Regex = "[^\\p{IsLatin}@.\\-_][^0-9]";
            case POSICAO_TAB -> Regex = "[^0-9]";
        }
        str = str.replaceAll(Regex, "");
        
        if(totalCaracteres <= Qtd_Caracteres){
            super.insertString(offs, str, a);
        } else{
            String nova_str = str.substring(0, Qtd_Caracteres);
            super.insertString(offs, nova_str, a);
        }
    }
       
}
