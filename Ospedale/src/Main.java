import java.util.Scanner;

public class Main extends Arch{
    
    public static void main(String[] args) {
        Arch arch = new Arch();
        Scanner sc = new Scanner(System.in);
        Scanner sc1 = new Scanner(System.in);

        int opzione;//FOR SWITCH
        String scelta;//FOR DO-WHILE
        String nomeOsp, nomeRep, nomeLab;
        boolean result = false;
        System.out.println("\n\n\t\t\tBENVENUTO ALL'OSPEDALE");

        do{
        System.out.println("------------------------------------------------------------------------------------------");
        System.out.println("\tScegli quale operazione eseguire:");
        System.out.println("\t1)Crea l'ospedale annsesso dei sui reparti e laboratoi");
        System.out.println("\t2)Crea un reparto");
        System.out.println("\t3)Crea un laboratoio");
        System.out.println("\t4)Modifica dei dati di un Ospedale o rimozione dall'elenco");
        System.out.println("\t5)Modifica dei dati di un reparto o rimozione dall'elenco");
        System.out.println("\t6)Modifica dei dati di un laboratio o rimozione dall'elenco");
        System.out.println("\t7)Output dei dati di un Ospedale");
        System.out.println("\t8)Output dei dati di un Reparto di un Ospedale");
        System.out.println("\t9)Output dei dati di un Laboratoio di un Ospedale");
        System.out.println("------------------------------------------------------------------------------------------");

        opzione=sc.nextInt();

        switch (opzione){
//----------------------------------------------INPUT---------------------------------------------------
            case 1:
                result=arch.creaOspedale();
                if (result) {
                    System.out.println("Ospedale memorizzato");
                }else{
                    System.out.println("ERRORE Ospedale non memorizzato");
                }
            break;

            case 2:
                result=arch.creaRep();
                
                if (result) {
                    System.out.println("Reparto memorizzato");
                }else{
                    System.out.println("ERRORE Reparto non memorizzato");
                }
            break;

            case 3:
                arch.creaLab();
                if (result) {
                    System.out.println("Laboratorio memorizzato");
                }else{
                    System.out.println("ERRORE Laboratorio non memorizzato");
                }
            break;
//----------------------------------------------MODIFICHE---------------------------------------------------
            case 4:
                arch.ospedaleNameAll();
                System.out.println("Inserisci il nome dell'Ospedale da modificare o eliminare");
                nomeOsp = sc1.nextLine();
                if(arch.ospedaleExist(nomeOsp)){
                    arch.ospedaleOutput(nomeOsp);

                    arch.ospedaleEdit(nomeOsp);
                }else{
                    System.out.println("Non esiste alcun Ospedale chiamato " + nomeOsp);
                    arch.pausa();
                }

            break;

            case 5:

                arch.repartoNameAll();

                System.out.println("Inserisci il nome dell'Ospedale in cui appartiene il Reparto da modificare o eliminare");
                nomeOsp = sc1.nextLine();
                System.out.println("Inserisci il nome del Reparto da modificare o eliminare");
                nomeRep = sc1.nextLine();
                
                if (arch.repartoExist(nomeOsp, nomeRep)) {
                    arch.repartoEdit(nomeOsp, nomeRep);          

                }else if (arch.ospedaleExist(nomeOsp)) {
                    System.out.println("Nell'ospedale " + nomeOsp + " non esiste un reparto chiamato " + nomeRep);
                    arch.pausa();
                }else{
                    System.out.println("Non esiste alcun Reparto in tutti gli Ospedali memorizzati chiamato " + nomeRep);
                    arch.pausa();
                }

            break;

            case 6:
                System.out.println("Inserisci il nome dell'Ospedale in cui appartiene il Laboratorio da modificare o eliminare");
                nomeOsp = sc1.nextLine();
                System.out.println("Inserisci il nome del Laboratoio da modificare o eliminare");
                nomeLab = sc1.nextLine();

                if (arch.laboratorioExist(nomeOsp, nomeLab)) {
                    arch.repartoEdit(nomeOsp, nomeLab);          

                }else if (arch.ospedaleExist(nomeOsp)) {
                    System.out.println("Nell'ospedale " + nomeOsp + " non esiste un laboratorio chiamato " + nomeLab);
                    arch.pausa();
                }else{
                    System.out.println("Non esiste alcun Laboratorio in tutti gli Ospedali memorizzati chiamato " + nomeLab);
                    arch.pausa();
                }


            break;
//----------------------------------------------OUTPUT---------------------------------------------------
            case 7:
                System.out.println("Inserisci il nome dell'Ospedale, il quale vuoi visualizzarne i dati");
                nomeOsp = sc1.nextLine();
                if (arch.ospedaleExist(nomeOsp)) {
                    arch.ospedaleOutput(nomeOsp);

                }else{
                    System.out.println("Non esiste alcun Ospedale chiamato " + nomeOsp);
                    arch.pausa();
                }
                
            break;

            
            case 8:
                System.out.println("Inserisci il nome dell'Ospedale, il quale vuoi visualizzarne i dati");
                nomeOsp = sc1.nextLine();
                
                System.out.println("Inserisci il nome del Reparto, il quale vuoi visualizzarne i dati");
                nomeRep = sc1.nextLine();

                if (arch.repartoExist(nomeOsp, nomeRep)) {
                    arch.repartoOutput(nomeRep);           

                }else if (arch.ospedaleExist(nomeOsp)) {
                    System.out.println("Nell'ospedale " + nomeOsp + " non esiste un reparto chiamato " + nomeRep);
                    arch.pausa();
                }else{
                    System.out.println("Non esiste alcun Reparto in tutti gli Ospedali memorizzati chiamato " + nomeRep);
                    arch.pausa();
                }
                
            break;

            case 9:
                System.out.println("Inserisci il nome dell'Ospedale, il quale vuoi visualizzarne i dati");
                nomeOsp = sc1.nextLine();
                System.out.println("Inserisci il nome del Laboratoio, il quale vuoi visualizzarne i dati");
                nomeLab = sc1.nextLine();

                if (arch.laboratorioExist(nomeOsp, nomeLab)) {
                    arch.LaboratoioOutput(nomeLab);
                                 
                }else if (arch.ospedaleExist(nomeOsp)) {
                    System.out.println("Nell'ospedale " + nomeOsp + " non esiste un laboratoio chiamato " + nomeLab);
                    arch.pausa();

                }else{
                    System.out.println("Non esiste alcun Laboratoio in tutti gli Ospedali memorizzati chiamato " + nomeLab);
                    arch.pausa();

                }

            break;
            default:
                System.out.println("Opzione insistente");
                arch.pausa();
            break;
        }//SWITCH

        System.out.println("\nVuoi eseguire un'altra ozpione del menu?(Si - No)");
        scelta=sc1.nextLine();
    }while(scelta.equalsIgnoreCase("si"));
    sc.close();
    sc1.close();

    }//MAIN

}//CLASS
