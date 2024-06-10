public class Ospedale {
    protected String nomeOspedale;
    private int nReparti;
    private int nLaboratori;

    Ospedale(){

    }
    Ospedale(String nomeOspedale,int nReparti,int nLaboratori){
        this.nomeOspedale = nomeOspedale;
        this.nReparti=nReparti;
        this.nLaboratori=nLaboratori;
    }

    //set
    void setNomeOspedale(String nomeOspedale) {
        this.nomeOspedale = nomeOspedale;
    }


    void setNReparti(int nReparti) {
        this.nReparti = nReparti;
    }


    void setNLaboratori(int nLaboratori) {
        this.nLaboratori = nLaboratori;
    }

    //get
    public String getNomeOspedale() {
        return nomeOspedale;
    }

    int getNReparti() {
        return nReparti;
    }

    int getNLaboratori() {
        return nLaboratori;
    }
    //fine set get

    public String toString(){
        return "\nNell'ospedale " + nomeOspedale + " ci sono " + nReparti + " Reparti e "  + nLaboratori + " Laboratori";
    }
}
