package projeto_04_a;



import java.util.Random;
import java.util.Scanner;

class Itens {
    int energia;
    int energiaMax;
    int bucho;
    int buchoMax;
    int limpeza;
    int limpezaMax; 
    boolean vivo;

    Itens (int energia, int bucho, int limpeza ){
        this.energia = energia;
        this.energiaMax = energia;
        this.bucho = bucho;
        this.buchoMax = bucho;
        this.limpeza = limpeza;
        this.limpezaMax = limpeza;
        this.vivo = true;

    }

    void morreu(){
        if(vivo == false){
        }
    }

    void barrasono(){
    if(energia < energiaMax){
            energia = energiaMax;
        }
    }
    
    public void brincar(){
        if(energia <= energiaMax){
            energia -= 4;
            limpeza -= 3;
            bucho -= 2;
        }
    }
    
    public void comida(){
        Random random = new Random();
        int multicomida = random.nextInt(5);

        if(bucho < buchoMax){
            bucho += multicomida;
            limpeza -= 2;
            energia -= 1;
        }
    }

    public void banhinho(){
        if(limpeza <= limpezaMax){
            energia -= 3;
            bucho -= 1;
            limpeza = limpezaMax;
        }
    }
    public String toString(){
        return "Energia: " + energia + "/" + energiaMax + " Fome: " + bucho + "/" + buchoMax +  " Limpo: " + limpeza + "/" + limpezaMax;
        
    }
}
public class tamagotchi {


    public static void main (String []args){
        Itens tamagotchi = new Itens(20,30,50);
        Scanner scanner = new Scanner (System.in);
        System.out.println("---Ola eu sou um bichinho fofinho de Whateagive---");
        System.out.println("---Venha cuidar de mim, sou indefeso---");
        System.out.println("---Eu preciso COMER, DORMIR, TOMAR BANHO e BRINCAR---");
        System.out.println("---Espero que eu não me machuque :3---");
        System.out.println("---Hoje tem gol do Ribamar---");

        while(true){
            String line = scanner.nextLine();
            String[] command = line.split(" ");

            if(command[0].equals("end")) {
                break;
            }else if(command[0].equals("comer")) {
                tamagotchi.comida();
                System.out.println(tamagotchi);
            }else if(command[0].equals("dormir")) {
                tamagotchi.barrasono();
                System.out.println(tamagotchi);
            }else if(command[0].equals("brincar")) {
                tamagotchi.brincar();
                System.out.println(tamagotchi);
            }else if(command[0].equals("banho")){
                tamagotchi.banhinho();
                System.out.println(tamagotchi);
            } 
        }    
         scanner.close(); 
    }
}