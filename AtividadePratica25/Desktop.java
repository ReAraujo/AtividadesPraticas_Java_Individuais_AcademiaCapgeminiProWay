package AtividadePratica25_HeranÃ§aEConversaoObjetosDeClasseESobescritaMetodos;

public class Desktop extends Computador {
    public String tamanhoGabinete;
    public String monitorExterno;
    public String fonte;

    @Override
    public String toString() {
        return "\n|---------- Computador: Desktop ----------|" + 
               "\n\tMarca: " + this.marca + 
               "\n\tMemÃ³ria Ram: " + this.memoriaRam + 
               "\n\tProcessador: " + this.processador + 
               "\n\tDisco rÃ­gido: " + this.discoRigido +
               "\n\tTamanho gabinete: " + this.tamanhoGabinete + 
               "\n\tMonitor externo: " + this.monitorExterno + 
               "\n\tFonte: " + this.fonte;               
    }
}
