package AtividadePratica25_HeranÃ§aEConversaoObjetosDeClasseESobescritaMetodos;

public class Computador{
    public String marca;
    public String memoriaRam;
    public String processador;
    public String discoRigido;

    @Override
    public String toString() {
        return "\n|---------- Computador ----------|" + 
               "\n\tMarca: " + this.marca + 
               "\n\tMemÃ³ria Ram: " + this.memoriaRam + 
               "\n\tProcessador: " + this.processador + 
               "\n\tDisco rÃ­gido: " + this.discoRigido;
    }
}