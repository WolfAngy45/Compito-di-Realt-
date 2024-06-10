
public class Reparto extends Ospedale{
    private Ospedale ospedaleAppartenenza;
    private String nomeReparto;
    private int nPostiLetto;

    Reparto(Ospedale nomeOspedale,String nomeReparto,int nPostiLetto,int nDegenti){
        this.ospedaleAppartenenza = nomeOspedale;
        this.nomeReparto = nomeReparto;
        this.nPostiLetto = nPostiLetto;
    }

    public void aggiungiPaziente(){
        nPostiLetto--;
    }
    //SET-----------------------------------------
    public void setOspedaleAppartenenza(Ospedale ospedaleAppartenenza) {
        this.ospedaleAppartenenza = ospedaleAppartenenza;
    }

    public void setNomeReparto(String nomeReparto) {
        this.nomeReparto = nomeReparto;
    }

    public void setnPostiLetto(int nPostiLetto) {
        this.nPostiLetto = nPostiLetto;
    }

    //GET-----------------------------------------
    public Ospedale getOspedaleAppartenenza() {
        return ospedaleAppartenenza;
    }

    public String getNomeReparto() {
        return nomeReparto;
    }

    public int getnPostiLetto() {
        return nPostiLetto;
    }

    //ToSting--------------------------
    public String toString(){
        return "Ospedale appartenenza: " + ospedaleAppartenenza.getNomeOspedale() + "\nNome reparto: " + nomeReparto + "\nnPostiLetto: " + nPostiLetto;
    }
}
