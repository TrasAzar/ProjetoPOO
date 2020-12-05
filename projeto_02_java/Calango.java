package projeto_02_java;

public class Calango{
    int energia; //atributo -> estado
    int maxEnergia;
    int nPatas;
    int poder;
    boolean escondido;
    boolean estaVivo;
    boolean temRabo;

    //parametros
    Calango(int energia, int nPatas){
        this.energia = energia;
        this.maxEnergia = energia;
        this.nPatas = nPatas;
        this.estaVivo = true;
        this.temRabo = true;
        this.escondido = false;
        this.poder = 0;
    }


    void correr(){ //métodos -> comportamento
        if(nPatas < 2){
            System.out.println("Aleijado");
            return;
        }
        if(energia > 0){
            System.out.println("corri");
            energia -= 1;
        }else{
            System.out.println("estou exausto");
        }
    }
    
    void brigar(){
        if(nPatas > 0 || escondido == false){
            nPatas -= 1;
            System.out.println("menos uma pata");
        }else{
            System.out.println("puxa meu rabo");
        }
    }

    void regenerar(){
        if(nPatas <= 4){
            nPatas += 1;
            poder += 2;
            System.out.println("vishi");
            if(poder == 6) {
                poder_terremoto();
            }
        }else{
            System.out.println("to inteiro");
        }
        
    }

    void descansar(int turnos){
        System.out.println("hora do suquinho");
        energia += turnos;

        if(energia > maxEnergia)
            energia = maxEnergia;
    }

    //metodo que informa como o meu objeto deve ser convertido para Texto
    public String toString() {
        return "Calango:\nenergia: " + energia + "\npatas:" + nPatas + "\npoder: " + poder + "\n";
    }
    
    void escondidinho(){
        if(nPatas > 0 && nPatas <= 3){
            escondido = true;
            System.out.println("me escondi");
            regenerar();
        }else{
            escondido = false;
            System.out.println("to pronto");
        }
    }

    void poder_terremoto(){
        System.out.println("Treme treme");
    }


    public static void main(String[] args) { 
        //tipo nome_da_referencia;
        Calango Terraseca = new Calango(10, 4);
        System.out.println(Terraseca);

        for(int i = 0; i < 4; i++) {
            Terraseca.correr();
        }

        System.out.println(Terraseca);
        Terraseca.descansar(2);
        System.out.println(Terraseca);
        
        for(int i = 0; i < 3; i++){
            Terraseca.brigar();
            System.out.println(Terraseca);
        }
        for(int i = 0; i < 3; i++){
            Terraseca.escondidinho();
            System.out.println(Terraseca);
        }

        System.out.println(Terraseca);
    }
}
