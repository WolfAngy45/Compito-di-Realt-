import java.util.ArrayList;
import java.util.Scanner;

public class Arch{
    Scanner sc = new Scanner(System.in);
    Scanner sc1 = new Scanner(System.in);

    ArrayList<Ospedale> ospedale = new ArrayList<>();
    ArrayList<Reparto> reparto = new ArrayList<>();
    ArrayList<Laboratorio> laboratorio = new ArrayList<>();
    
    //CREATE THE OBJECT FOR OSPEDALE || REPARTO || LABORATORIO
    public boolean creaOspedale(){
        int nrep, nlab;

        System.out.println("Inserisci il nomde dell'ospedale: ");
        String nome = sc1.nextLine();

        do {
            System.out.println("Inserisci il numero dei reparti presenti nell'ospedale: ");
            nrep = sc.nextInt();   
        } while (nrep>30);

        do {
            System.out.println("Inserisci il numero dei laboratori");
            nlab = sc.nextInt();
        } while (nlab>10);

        if (nrep<=30 && nlab<=10) {
            ospedale.add(new Ospedale(nome,nrep,nlab));
            return true;
        }
        
        return false;

    }

    public boolean creaRep(){
        System.out.println("Inserisci il nome dell'ospedale d'appartenenza");
        String nome = sc1.nextLine();
        for (Ospedale value : ospedale) {
            String nomeosp = value.getNomeOspedale();
            if (nome.equals(nomeosp)) {
                System.out.println("Inserisci il nome del reparto");
                String nomerep = sc1.nextLine();
                System.out.println("Inserisci il numero dei posti letto");
                int npostiletto = sc.nextInt();
                System.out.println("Inserisci il numero dei degenti");
                int ndeg = sc.nextInt();
                reparto.add(new Reparto(value,nomerep,npostiletto,ndeg));
                return true;
            }
        }
        return false;
        
    }

    public boolean creaLab(){
        System.out.println("Inserisci il nome dell'ospedale d'appartenenza");
        String nome = sc1.nextLine();
        for (Ospedale value : ospedale) {
            String nomeosp = value.getNomeOspedale();
            if (nome.equals(nomeosp)) {
                System.out.println("Inserisci il nome del laboratorio");
                String nomelab = sc1.nextLine();
                System.out.println("Inserisci il numero degli esami");
                int nesami = sc.nextInt();
                System.out.println("Inserisci il numero delle spese");
                double spese = sc.nextDouble();
                System.out.println("Inserisci il numero degli incassi");
                double incassi = sc.nextDouble();
                laboratorio.add(new Laboratorio(value,nomelab,nesami,spese,incassi));   
                return true;
            }
        }
        return false;
    }

    //OUTPUT BOOLEAN IF EXIST OSPEDALE || REPARTO || LABORATORIO
    boolean ospedaleExist(String nomeospedale){
        for(Ospedale value: ospedale){
            String nome = value.getNomeOspedale();
            if(nomeospedale.equals(nome)){
                return true;
            }
        }
        return false;
    }

    boolean repartoExist(String nomeospedale,String nomereparto){
        for(Reparto value:reparto){
            String nomeosp = value.getOspedaleAppartenenza().getNomeOspedale();
            String nomerep = value.getNomeReparto();
            if(nomeospedale.equals(nomeosp) && nomereparto.equals(nomerep)){
                return true;
            }
        }
        return false;
    }

    boolean laboratorioExist(String nomeospedale,String nomelaboratorio){
        for(Laboratorio value:laboratorio){
            String nomeosp = value.getOspedaleAppartenenza().getNomeOspedale();
            String nomelab = value.getNomeLaboratorio();
            if(nomeospedale.equals(nomeosp) && nomelaboratorio.equals(nomelab)){
                return true;
            }
        }
        return false;
    }

    //EDITING WITH ELEMENTS AND ARRAYLIST
    public void ospedaleEdit(String nomeOsp){
        
        System.out.println("------------------------------------------------------------------------------------------");
        System.out.println("\n\n\t\t\t\tMODIFICA DATI LABORATORIO");
        System.out.println("\t\tQuale dato vuoi modificare?");
        System.out.println("\t\tt1)Nome Ospedale");
        System.out.println("\t\t2)Numero Reparti");
        System.out.println("\t\t3)Numero Laboratori");
        System.out.println("\t\t4)Eliminare tutti i dati memorizzati");
        System.out.println("------------------------------------------------------------------------------------------");

        switch (sc.nextInt()) {             
            case 1:
            for(Ospedale value: ospedale){
                if(value.getNomeOspedale().equals(nomeOsp)){
                    value.setNomeOspedale(nomeOsp);
                    }//IF
                }//FOR
            break;
                    
        
            case 2:
            System.out.println("Nell'Ospedale " + nomeOsp + " i reparti sono: ");
            int numRep=sc.nextInt();

            for(Ospedale value: ospedale){
                if(value.getNomeOspedale().equals(nomeOsp)){
                    value.setNReparti(numRep);
                }//IF
            }//FOR
            break;
            
            case 3:
            System.out.println("Nell'Ospedale " + nomeOsp + " i laboratori sono: " );
            int numLab=sc.nextInt();
                    
            for(Ospedale value: ospedale){
                if(value.getNomeOspedale().equals(nomeOsp)){
                    value.setNReparti(numLab);
                }//IF
            }//FOR
            break;

            case 4:

            do {
                for(Ospedale value: ospedale){
                    for (Reparto element : reparto) {
                        if(element.getNomeOspedale().equals(value.getNomeOspedale())){
                            reparto.remove(element);
                        }//IF
                    }//FOR-REP

                    for (Laboratorio element : laboratorio) {
                        if(element.getNomeOspedale().equals(value.getNomeOspedale())){
                            laboratorio.remove(element);
                        }//IF
                    }//FOR-REP

                    if(value.getNomeOspedale().equals(nomeOsp)){
                        ospedale.remove(value);
                    }//IF

                }//FOR
                
                System.out.println("Sei sicuro di voler eliminare tutti i dati?\nNOTA QUESTA é LA LAST CHANCE\t (Si || No)");
                pausa();
            }while(sc1.nextLine().equalsIgnoreCase("si"));
            
            break;

            default:
                System.out.println("Opzione insistente");
                pausa();
            break;
        }//SWITCH
    }//EDIT

    public void repartoEdit(String nomeOsp, String nomeRep){
        
        System.out.println("------------------------------------------------------------------------------------------");
        System.out.println("\n\n\t\t\t\t\tMODIFICA DATI REPARTO");

        System.out.println("Quale dato vuoi modificare?");
        System.out.println("1)Nome Reparto");
        System.out.println("2)Numero Posti Letto");
        System.out.println("3)Eliminare i dati salvati");
        switch (sc.nextInt()) {    
           
            case 1:
            for(Reparto element: reparto){
                if (element.getNomeReparto().equals(nomeRep)) {                            
                    element.setNomeReparto(nomeRep);
                    }//IF
                }//FOR    
            break;
        
            case 2:
            System.out.println("Qual è il nuovo valore per i posti letto?");
            int nPostiLetto = sc.nextInt();

            for(Reparto element: reparto){
                if (element.getNomeReparto().equals(nomeRep)) {                            
                        element.setnPostiLetto(nPostiLetto);
                    }//IF
            }//FOR
            break;

            case 3:
            do {
                for (Reparto element : reparto) {
                    if(element.getNomeOspedale().equals(nomeOsp)){
                        reparto.remove(element);
                    }//IF
                }//FOR-REP

                System.out.println("Sei sicuro di voler eliminare tutti i dati?\nNOTA QUESTA é LA LAST CHANCE\t (Si || si)");
                pausa();
            }while(sc1.nextLine().equalsIgnoreCase("si"));
            break;
            
            default:
                System.out.println("Opzione insistente");
                pausa();
            break;
        }//SWITCH
    }//EDIT
    
    public void laboratorioEdit(String nomeOsp, String nomeLab){
        System.out.println("------------------------------------------------------------------------------------------");
        System.out.println("\n\n\t\t\t\t\tMODIFICA DATI LABORATORIO");
        System.out.println("\t\t\tQuale dato vuoi modificare?");
        System.out.println("\t\t\t1)Nome Laboratorio");
        System.out.println("\t\t\t2)Numero degli Esami");
        System.out.println("\t\t\t3)Spese");
        System.out.println("\t\t\t4)Incassi");
        System.out.println("\t\t\t5)Eliminare i  dati salvati");
        System.out.println("------------------------------------------------------------------------------------------");

        switch (sc.nextInt()) {
           
            case 1:
            for(Reparto element: reparto){
                if (element.getNomeReparto().equals(nomeLab)) {                            
                    element.setNomeReparto(nomeLab);
                    }//IF
                }//FOR    
            break;
        
            case 2:
            System.out.println("Qual è il nuovo valore degli esami?");
            int esemi = sc.nextInt();

            for(Laboratorio element: laboratorio){
                if (element.getNomeLaboratorio().equals(nomeLab)) {                            
                        element.setnEsami(esemi);
                    }//IF
            }//FOR
            break;
            
            case 3:
            System.out.println("Qual è il nuovo valore delle spese?");
            double spese = sc.nextDouble();

            for(Laboratorio element: laboratorio){
                if (element.getNomeLaboratorio().equals(nomeLab)) {                             
                        element.setSpese(spese);
                    }//IF
            }//FOR
            break;
             
            case 4:
            System.out.println("Qual è il nuovo valore degli incassi?");
            double incassi = sc.nextDouble();

            for(Laboratorio element: laboratorio){
                if (element.getNomeLaboratorio().equals(nomeLab)) {                             
                        element.setIncassi(incassi);
                    }//IF
            }//FOR
            break;

            case 5:
            do {
                for (Reparto element : reparto) {
                    if(element.getNomeOspedale().equals(nomeOsp)){
                        reparto.remove(element);
                    }//IF
                }//FOR-REP

                System.out.println("Sei sicuro di voler eliminare tutti i dati?\nNOTA QUESTA é LA LAST CHANCE\t (Si || si)");
                pausa();
            }while(sc1.nextLine().equalsIgnoreCase("si"));
            break;

            default:
                System.out.println("Opzione insistente");
                pausa();
            break;
        }//SWITCH

    }//EDIT

    //OUTPUT OF ALL THE ELEMNTS OF AN OSPEDALE || REPARTO || LABORATORIO 
    public void ospedaleOutput(String nomeOsp){
        for(Ospedale value: ospedale){
            String nome = value.getNomeOspedale();
                if(nomeOsp.equals(nome)){
                    int index = ospedale.indexOf(value);
                    System.out.print(ospedale.get(index));
            }
        }
        pausa();

    }

    public void repartoOutput(String nomeRep){

        for(Reparto element: reparto){
            if (element.getNomeReparto().equals(nomeRep)) {
                int index = reparto.indexOf(element);
                System.out.println(reparto.get(index));
            }//IF
        }//FOR
        pausa();
     
    }
    
    public void LaboratoioOutput(String nomeLab){

        for(Laboratorio element: laboratorio){
            if (element.getNomeLaboratorio().equals(nomeLab)) {
                int index = laboratorio.indexOf(element);
                System.out.println(laboratorio.get(index));
            }//IF
        }//FOR
        pausa();
 
    }
    
    //OUTPUT ALL STORED OSPEDALI || REPARTI || LABORATORI
    public void ospedaleNameAll(){
        System.out.print("Gli ospedali memorizzati sono: ");
            for(Ospedale value: ospedale){
                System.out.println("\t" + value.getNomeOspedale() + "\t");
            }
        pausa();
    }

    public void repartoNameAll(){
        System.out.println("I reparti memorizzati sono: ");
        for (Ospedale element : ospedale) {
            System.out.println("\t" + element.getNomeOspedale());
            for(Reparto value: reparto){
                System.out.println( "\t\t" + value.getNomeReparto());
            }
        }
           
    }

    public void laboratoioNameAll(){
        System.out.print("I laboratoi memorizzati sono: ");
        for (Ospedale element : ospedale) {
            System.out.println("\t" + element.getNomeOspedale()); 

            for(Laboratorio value: laboratorio){
                System.out.println( "\t\t" + value.getNomeLaboratorio());
            }
        }
        pausa();
    }

    public void pausa(){
        System.out.println("\nPremi un tasto per continuare------->>>");
        sc.nextLine();
        
    }
}//CLASS
