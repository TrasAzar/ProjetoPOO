package projeto_6_vetores;
import java.util.ArrayList;
import java.util.Collections;

class Pass{
    public String name;
    public int idade;

    public Pass(String name,int idade){
        this.name = name;
        this.idade = idade;
        
    }

    public String toString() {
        String saida = "";
        saida += name + ":" + idade;
        return saida;
        
    }        
}

class Topik {
    public ArrayList<Pass> cadeiras;
    public int lugaresPreferenciais;
    public int lugaresTotais;

    public Topik(int lugaresTotais, int lugaresPreferenciais){ 
        this.lugaresPreferenciais = lugaresPreferenciais;
        this.lugaresTotais = lugaresTotais;
        cadeiras = new ArrayList<Pass>(Collections.nCopies(lugaresTotais, null));
        
    }

    boolean subir(Pass pass){
        if(pass.idade < 65) {
            for(int p = lugaresPreferenciais; p < lugaresTotais; p++) {
                if(cadeiras.get(p) == null){
                    cadeiras.set(p, pass);
                    return true;
                }
            }
        }else{
            for(int s = 0; s < lugaresPreferenciais; s++){
                if(cadeiras.get(s)== null){ 
                    cadeiras.set(s, pass);
                    return true;
                }
    
            }
        }
            return false;
    
    }
    public String toString() {
        String saida = "";
        saida += "[ ";
        for(int l = 0; l < lugaresPreferenciais; l++){

            if(cadeiras.get(l) == null)
                saida += "@ ";
            else
                saida += "@" + cadeiras.get(l) + " ";
                
        }


        for(int t = lugaresPreferenciais; t < lugaresTotais; t++){
            if(cadeiras.get(t) == null)
                saida += "= " ;
            else
                saida += "= " + cadeiras.get(t) + " ";

        }

        saida += " ]";
        
        return saida;
    
        }
    }


public class array{
    public static void main(String[] args){
        Topik topik = new Topik(5,2);
        System.out.println(topik);
        topik.subir(new Pass("Luana",18));
        topik.subir(new Pass("Doroteia",90));
        topik.subir(new Pass("Galileu",70));
        topik.subir(new Pass("Julinha",30));
        topik.subir(new Pass("Senhor Carlos", 39));
        System.out.println(topik);

    }
}