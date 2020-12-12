package projeto_03_cofre;

import java.util.Scanner;

import java.util.Random;

class Trevas {
    int demonios;
    int power;

    Trevas(int demonios, int power){
        this.demonios = demonios;
        this.power = power;
    }

    void criaturas(int demons){
        demonios += demons;
        System.out.println("Criaturas do barulho invadiram a terra");
    }
}


public class Deus {
    Trevas bixo;
    int floresta;
    int chance;
    int humanos;
    int multiHumanos;
    int mortos;
    int casas = 0;
    int multiCasas;
    boolean armas = false;
    int arvores;
    int pedras;
    int meteoros;
    boolean chuvinha = true;
    boolean terremoto = true;


    boolean verificaBixo(Trevas target) {
        if(bixo != null) {
            return false;
        }
        this.bixo = target;
        return true;
    }   
    
    //parametros//
    Deus(int Humanos, int Arvores, int Pedras){
        this.humanos = Humanos;
        this.arvores = Arvores;
        this.pedras = Pedras;
    }
        // criar humanidade e destruição // 
        void humanidade(int homis){
            Random random = new Random();
            multiHumanos = random.nextInt((8-1)+1)+1;

                humanos += homis;
                System.out.println("---nasceu mais humanos---");
            
            if(humanos > 10){
                casinhas();
            }
                if(chance%2 == 0){
                    int x = multiHumanos;
                    humanos += x;
                    humanos = humanos - mortos;
                System.out.println( + humanos);
                }            
            else {
                humanos = 0;
                System.out.println("---a humanidade acabou---");
            }
        }
        void morte(){
            Random random = new Random();
            mortos = random.nextInt((2 - 1)+ 1) +1;

            if(mortos > 0 && humanos > 10){
                humanos -= mortos;
                
            }
            if(humanos >= 50 && mortos >= 0){
                    armas = true;
                    humanos -= humanos/8;
                    if(casas < humanos/2){
                    humanos -= humanos/4;
                    }
                    if(casas < humanos/4){
                        humanos -= humanos/2;
                        }
                }
            }
        
         // criar natureza //
        void florestas(int floresta){
                arvores += floresta;
                System.out.println("---criar arvores---");
        }
        
        void rochas(int predas){
             pedras += predas;
                System.out.println("---criar pedras---");
        }

        void chuvas(){
            if(chuvinha){
                humanos *= 3;
                arvores *= 10;
                casas -= 10;
                System.out.println("---Eba chuva!!!---");
            }
        }
        // criação humana// 
        void casinhas(){

            // Random random = new Random();
            // multiCasas = random.nextInt((2-1)+1)+1;

            if(casas >= 0 && arvores > 0 && pedras > 0){
                ++casas;
                --arvores;
                --pedras;

                if(casas >= 1){
                    casas += humanos/8;
                }

                System.out.println("---casinhas---");
            }else if(humanos/casas > 5){
                casas += 0;
                humanos -= humanos/2;
                if(humanos < 0) {
                    humanos = 0;
                } 
            }
        }       
    
        // destruição
        void meteoros(){
            meteoros = 10;
            if(meteoros > 0){
                arvores -= 10000;
                casas -= 3000;
                humanos -= 10000;
                if(arvores < 0){
                    arvores = 0;
                }
                if(humanos < 0){
                    humanos = 0;
                }
                if(casas < 0){
                    casas = 0;
                }
                System.out.println("---OLHA A PEDRA!!!!---\n");
            }   
        }
        void terremoto(){
            if(terremoto = true ){
                arvores -= 1000;
                casas -= 100;
                humanos -= 1000;
                pedras += 100;
                if(arvores < 0){
                    arvores = 0;
                }
                if(humanos < 0){
                    humanos = 0;
                }
                if(casas < 0){
                    casas = 0;
                }
                System.out.println("---TREME TREME---");
            }   
        }
        // demonios //
        void batalha(){
            Random random = new Random();
            int forca = random.nextInt(100);
            if(humanos >= 3){
                if(forca > bixo.power){
                    bixo.demonios--;
                }
                else if(forca < bixo.power){
                    humanos -= 3;
                }else{
                    humanos += 0; 
                    bixo.demonios += 0;
                }
            }
        }


    public String toString(){
        return "Como está o seu mundo\n" + "Árvores no mundo: " + arvores + "\nPedras no mundo:" + pedras + "\nHumanos no mundo:" + humanos + "\nCasas no mundo:" + casas + "\n";
    }

     
    public static void main(String[] args) { 
        //referencial main//
        Scanner scanner = new Scanner(System.in);
        Deus Barsaw = new Deus(10, 10, 10);
        
        System.out.println("Ola!Você é a entidade que acordou neste novo planeta, nomeada de Barsaw!");
        System.out.println("Brinque por ae como quiser, seu leque de poder é vasto");
        System.out.println("Há algumas coisas que eu tenho que lhe informar");
        System.out.println("Você pode criar FLORESTAS e ROCHAS para a natureza do seu mundo");
        System.out.println("você pode criar a HUMANIDADE vão se procriar na terra e criar coisas");
        System.out.println("A HUMANIDADE pode criar coisas novas");
        System.out.println("destruir e ajudar faz parte ao enviar METEORO, CHUVA, TERREMOTO");
        System.out.println("Não esqueça que há o lorde das trevas Squee, ele cria DEMONIOS que vão matar seus humanos");
        System.out.println("---------------------se divirta---------------------");


        System.out.println("Bixo: " + Barsaw.bixo);

        while(true){
            String line = scanner.nextLine();
            String input[] = line.split(" ");

            if(input[0].equals("end")){
                System.out.println("Mundo apagado");
                break;
            }
            if(input[0].equals("humanidade")){
                Barsaw.humanidade(Integer.parseInt(input[1]));
                System.out.println(Barsaw);
            }
            else if(input[0].equals("florestas")) {
                Barsaw.florestas(Integer.parseInt(input[1]));
                System.out.println(Barsaw);
            }
            else if(input[0].equals("rochas")){
                Barsaw.rochas(Integer.parseInt(input[1]));
                System.out.println(Barsaw);
            }
            else if(input[0].equals("meteoro")){
                Barsaw.meteoros();
                System.out.println(Barsaw);
            }
            else if(input[0].equals("chuva")){
                Barsaw.chuvas();
                System.out.println(Barsaw);
            }
            else if(input[0].equals("terremoto")){
                Barsaw.terremoto();
                System.out.println(Barsaw);
            }
            else if(input[0].equals("demonios")){
                int qtdbixo = Integer.parseInt(input[1]);
                int power = Integer.parseInt(input[2]);
                Trevas Squee = new Trevas(qtdbixo, power);
                Barsaw.verificaBixo(Squee);
                Barsaw.batalha();
                System.out.println(Barsaw);
                System.out.println("Demonios no mundo:" + Barsaw.bixo.demonios + "\n");
            };
        }
        scanner.close();
    }
}
