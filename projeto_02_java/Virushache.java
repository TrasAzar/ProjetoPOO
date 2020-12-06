package projeto_02_java;

import java.util.Random;

class Virushache{
    int infectados;
    int maxInfectados;
    int saudaveis;
    int maxsaudaveis;
    int morto;
    int chance;
    int vivos;
    int multiInfecta;
    boolean doente = false;
    boolean parar = false;

    //parametros//
    Virushache(int Infectados, int saudaveis){
        this.infectados = Infectados;
        this.maxInfectados = maxsaudaveis;
        this.saudaveis = saudaveis;
        this.maxsaudaveis = saudaveis;
        this.vivos = saudaveis;
    }

    void infectar(){//contagem
        Random random = new Random();
        chance = random.nextInt((10-1)+1)+1;
        multiInfecta = random.nextInt((3-1)+1)+1;


        // System.out.println(chance);
        
        if(vivos >= 0) {
        
            if(infectados >= 1){
                if(chance%2 == 0){
                    int x = multiInfecta;
                    infectados *= x;
                    saudaveis = vivos - infectados;
                    if(saudaveis <= 0){
                        infectados = vivos;
                        saudaveis = 0;
                        parar = true;
                    }
                    doente = true;
                    morre();
                    System.out.println("Mais infectados");
                }else if(chance%2 !=0){
                    doente = false;
                    System.out.println("Contido");
                }
            }
        }else if(vivos == infectados){
            System.out.println("A papUlacao de Whatteagive esta morta");
        }
   }
void morre(){
    Random random = new Random();
    morto = random.nextInt((2 - 1)+ 1) +1;

    if(vivos >= 0 && saudaveis >= 0) {
        if(doente && morto == 2){
            infectados -= multiInfecta;
            vivos -= multiInfecta;
            System.out.println("Mais um falecido");
        }
    }
}

 public String toString() {
    return "Virushache :\nInfectados: " + infectados + " \nsaudaveis:" + saudaveis + "\nvivos:" + vivos + "\n";
}

    public static void main(String[] args) { 
        //referencial main//
        Virushache VirusH = new Virushache(2, 31);
        System.out.println(VirusH);

        for(int i = 0; i < 32; i++) {
            VirusH.infectar();
            System.out.println(VirusH);
            if(VirusH.parar == true) {
                break;
            }
        }
    }
}