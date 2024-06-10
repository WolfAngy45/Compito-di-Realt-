
public class Laboratorio extends Ospedale{
    private Ospedale ospedaleAppartenenza;
    private String nomeLaboratorio;
    private int nEsami;
    private double spese;
    private double incassi;

    Laboratorio(Ospedale ospedaleAppartenenza,String nomeLaboratorio, int nEsami, double spese, double incassi){
        this.ospedaleAppartenenza = ospedaleAppartenenza;
        this.nomeLaboratorio = nomeLaboratorio;
        this.nEsami = nEsami;
        this.spese = spese;
        this.incassi = incassi;
    }
    //Set-------------------------------------------------
    
    public void setOspedaleAppartenenza(Ospedale ospedaleAppartenenza) {
        this.ospedaleAppartenenza = ospedaleAppartenenza;
    }

    public void setNomeLaboratori(String nomeLaboratori) {
        this.nomeLaboratorio = nomeLaboratori;
    }

    public void setnEsami(int nEsami) {
        this.nEsami = nEsami;
    }

    public void setIncassi(double incassi) {
        this.incassi = incassi;
    }

    public void setSpese(double spese) {
        this.spese = spese;
    }

    //GET--------------------------------------------------
    
    public Ospedale getOspedaleAppartenenza() {
        return ospedaleAppartenenza;
    }

    public String getNomeLaboratorio() {
        return nomeLaboratorio;
    }

    public int getnEsami() {
        return nEsami;
    }

    public double getSpese() {
        return spese;
    }

    public double getIncassi() {
        return incassi;
    }

    public void aggiungiIncassi(double incasso){
        this.incassi += incasso;
    }

    public void aggiungiSpese(double spese){
        this.spese += spese;
    }
    //ToSting
    public String toString(){
        return "Dati del Laboratorio " + nomeLaboratorio + "\nIl numero degli esami è " + nEsami + "\n Le spese sono: " + spese + "\nGli incassi sono: " + incassi;
    }
}//CLASS