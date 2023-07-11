
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Pertempuran extends hanyaTampilan{
    private int UKURAN_ARENA=10;
    private  int JUMLAH_KAPAL=5;
    private Scanner input;
    private Pemain netral;
    private Pemain pemain1;
    private Pemain pemain2;
    private Pemain pemainSingle;
    private Pemain computer;
    protected Random random;
    public Pertempuran(){
        random=new Random();
        netral=null;
        pemain1=null;
        pemain2=null;
        pemainSingle=null;
        computer=null;
        input=new Scanner(System.in);
    }

    char mode;
    String negaraPilihan;
    public void kembaliMenu(){
        char pilih;
        System.out.print("apakah ingin ke menu utama: ");pilih=input.next().charAt(0);
        if(pilih=='y'||pilih=='Y'){
            setup();gamePlay();
        }else if(pilih=='n'||pilih=='N'){
            System.out.println("permainan berakhir");
        }else{
            System.out.println("inputan salah");
            kembaliMenu();
        }
    }
    public void gamePlay(){
        while(true){
            if(mode=='1'){
                System.out.println("======================");
                System.out.println(pemainSingle.getnama()+" arena:");
                pemainSingle.getArea().tampilanArena();

                System.out.println("giliran "+pemainSingle.getnama()+":");
                playTurn(pemainSingle,computer,netral);
                if(computer.saatKalah(JUMLAH_KAPAL)){
                    System.out.println(pemainSingle.getnama()+" memenangkan permainan!!");
                    Menang();
                    kembaliMenu();
                break;
                }
                System.out.println("giliran "+computer.getnama()+":");
                playTurncomputer(pemainSingle,computer);
                if(pemainSingle.saatKalah(JUMLAH_KAPAL)){
                    System.out.println(computer.getnama()+" memenangkan permainan");
                    kalah();
                kembaliMenu();
                break;
                }
            }
            if(mode=='2'){
                System.out.println("====================");
                System.out.println(pemain1.getnama()+"turn:");
                netral.getArea().tampilanArena();

                playTurn(pemain1,pemain2,netral);
                if(pemain1.saatKalah(JUMLAH_KAPAL)){
                    System.out.println(pemain2.getnama()+" memenangkan permainan");Menang();kembaliMenu();
                break;
                }
                System.out.println(pemain2.getnama()+"turn:");
                playTurn(pemain2,pemain1,netral);
                if(pemain2.saatKalah(JUMLAH_KAPAL)){
                    System.out.println(pemain1.getnama()+" memenangkan permainan");Menang();kembaliMenu();
                    break;
                }

            }
        }
    }
    public String pilihNegara(){
        char i;
        tampilanNegara();
        System.out.print("silahkan pilih negara mana:");
        i= input.next().charAt(0);
        switch (i){
            case '1'->negaraPilihan="China";
            case '2'->negaraPilihan="Amerika";
            default -> {
                System.out.println("inputan anda keliru");
                for(int clear=0;clear<100;clear++){System.out.println("\b");}pilihNegara();
            }
        }
        return negaraPilihan;
    }
    public String negaraLawan() {
        if (negaraPilihan == "China") {
            negaraPilihan = "amerika";

        } else{
            negaraPilihan="china";
        }
        return negaraPilihan;
    }
    public void setup(){
        tampilanMenu();
        System.out.print("Select game mode:");mode=input.next().charAt(0);
        switch (mode){
            case '1'->{
                pilihNegara();
                pemainSingle=new Pemain(negaraPilihan,new Arena(UKURAN_ARENA));
                computer=new Pemain(negaraLawan(),new Arena(UKURAN_ARENA));
                netral=new Pemain("arena:\n",new Arena(UKURAN_ARENA));
                posisiKapal(pemainSingle);
                posisiKapalPC(computer);}
            case '2'->{
                pilihNegara();
                pemain1=new Pemain(negaraPilihan,new Arena(UKURAN_ARENA));
                pemain2=new Pemain(negaraLawan(),new Arena(UKURAN_ARENA));
                netral=new Pemain("arena:\n",new Arena(UKURAN_ARENA));
                System.out.println("pemain "+(negaraPilihan)+" menempatkan kapal:");
                posisiKapal(pemain1);
                System.out.println("pemain "+(negaraLawan())+" menempatkan kapal: ");
                posisiKapal(pemain2);}
            case '3'->settingGame();
            case '4'->{System.out.println("berhasil keluar");System.exit(0);}
            default->{
                System.out.println("inputan salah silahkan ulang");for(int clear=0;clear<100;clear++){System.out.println("\b");}setup();}
        }
    }
    public void settingGame(){
        tampilanSetting();

         char a;
        System.out.print("pilih setting: ");a=input.next().charAt(0);
        switch(a){
            case '1'->{System.out.print("masukkan luas arena yang di inginkan:");UKURAN_ARENA=input.nextInt();
                    System.out.println("luas arena tersimpan!!!!");settingGame();
                        }
            case '2'->{System.out.print("masukkan jumlah kapal yang bertempur: ");JUMLAH_KAPAL=input.nextInt();
                        System.out.println("jumlah kapal tersimpan!!!!");settingGame();
                        }
            case '3'->setup();
            default->{System.out.println("tidak ada dalam menu ");settingGame();}
        }
    }

    public void posisiKapal(Pemain pemain){
        Arena arena=pemain.getArea();
        int row,col;
        System.out.println(pemain.getnama()+", silahkan input kapal:");
        for(int i=0;i<JUMLAH_KAPAL;i++){
            do{
                try{
            System.out.println("kapal "+(i+1)+":");
            System.out.print("\tkordinat x:"+"(0-"+(UKURAN_ARENA-1)+") :");row=input.nextInt();
            System.out.print("\tkordinat y:"+"(0-"+(UKURAN_ARENA-1)+") :");col=input.nextInt();
            }catch (InputMismatchException e){
                    input.nextLine();
                    closeGame();
                    continue;
                }break;
            }while(true);
            if(row<0||row>=UKURAN_ARENA||col<0||col>=UKURAN_ARENA){
                System.out.println("inputan melebihi batas yang telah ditentukan!coba lagi");
                i--;continue;
            }
            if(arena.ditempati(row,col)){
                System.out.println("posisi ditempati kapal lain!pilih posisi lain");
                i--;continue;
            }
            arena.arenaPerahu(row,col);

        }
    }
    public void posisiKapalPC(Pemain computer){
        Arena arena=computer.getArea();
        System.out.println(computer.getnama()+" siap bertempur");
        for(int i = 0; i<JUMLAH_KAPAL; i++){
            int row= random.nextInt(UKURAN_ARENA);
            int col= random.nextInt(UKURAN_ARENA);
            if(arena.ditempati(row,col)){
                i--;continue;
            }
            arena.arenaPerahu(row,col);
        }
    }
    public void closeGame(){
        char pilih ;
        tampilanCloseGame();
        System.out.print("pilih:");
        pilih=input.next().charAt(0);
        switch(pilih){
            case '1'->setup();
            case '2'->System.exit(0);
            case '3'->System.out.println("memuat game:");
            default -> closeGame();
        }}

    public void playTurn(Pemain playerAwal,Pemain lawan,Pemain pemain){
        int row,col;
        Arena arenaPlayerAwal=playerAwal.getArea();
        Arena arenaLawan=lawan.getArea();
        Arena arenaPemain=pemain.getArea();
        System.out.println("sisa kapal "+playerAwal.getnama()+" masih bertahan: "+(JUMLAH_KAPAL-playerAwal.getTengelam()));
        System.out.println("sisa kapal "+lawan.getnama()+" masih bertahan: "+(JUMLAH_KAPAL-lawan.getTengelam()));
        do{
        try {
            System.out.print("\tkordinat x:" + "(0-" + (UKURAN_ARENA - 1) + ") :");
            row = input.nextInt();
            System.out.print("\tkordinat y:" + "(0-" + (UKURAN_ARENA - 1) + ") :");
            col = input.nextInt();
        }catch (InputMismatchException e){
            input.nextLine();
                closeGame();
            continue;
        }break;
        }while(true);
        if(row<0||row>=UKURAN_ARENA||col<0||col>=UKURAN_ARENA){
            System.out.println("inputan kordinat ("+row+","+col+") melebih luas arena! silahkan ulang!!");
            playTurn(playerAwal,lawan,pemain);return;
        }
        if(arenaPlayerAwal.kena(row,col)||arenaLawan.kena(row,col)){
            System.out.println("kapal sudah di bom di posisi ("+row+","+col+")!!");
            playTurn(playerAwal,lawan,pemain);return;
        }
        if(arenaPlayerAwal.meleset(row,col)||arenaLawan.meleset(row,col)){
            System.out.print("posisi kordinat: ("+row+","+col+") sudah diinput oleh salah satu pihak \n");
            playTurn(playerAwal,lawan,pemain);return;
        }
        if(arenaLawan.ditempati(row,col)){
            System.out.println("berhasil mengenai kapal musuh kordinat:("+row+","+col+")");
            arenaPlayerAwal.terbom(row,col);
            arenaLawan.terbom(row,col);arenaPemain.terbom(row,col);
            lawan.KapalTenggelam();
        }else if(arenaPlayerAwal.ditempati(row,col)) {
            System.out.println("pemain menembak kapal sendiri kordinat (" + row + "," + col + ")");
            arenaPlayerAwal.terbom(row, col);
            arenaPemain.terbom(row, col);
            arenaLawan.terbom(row, col);
            playerAwal.KapalTenggelam();
        }else if(arenaLawan.ditempati(row,col)&& arenaPlayerAwal.ditempati(row,col)){
            System.out.println("pemain menembak kapal musuh dan menengelamkan kapal sendiri kordinat (" + row + "," + col + ")");
            arenaPlayerAwal.terbom(row, col);
            arenaPemain.terbom(row, col);
            arenaLawan.terbom(row, col);
            playerAwal.KapalTenggelam();
            lawan.KapalTenggelam();
        } else{
            System.out.println("tembakan meleset!kordinat: ("+row+","+col+")");
            arenaPlayerAwal.tandaiMeleset(row,col);arenaPemain.tandaiMeleset(row,col);
        }
    }
    public void playTurncomputer(Pemain pemain,Pemain computer){
        Arena arenaPlayer=pemain.getArea();
        Arena arenaComputer=computer.getArea();

        int row= random.nextInt(UKURAN_ARENA);
        int col= random.nextInt(UKURAN_ARENA);

        if(arenaPlayer.kena(row,col)||arenaPlayer.meleset(row,col)){
           playTurncomputer(pemain,computer);return;
        }

        if(arenaPlayer.ditempati(row,col)){
            System.out.println("computer menengelamkan kapal anda kordinat:("+row+","+col+")");
            arenaPlayer.terbom(row,col);
            arenaComputer.terbom(row,col);
            //computer.KapalTenggelam();
            pemain.KapalTenggelam();
        }else if(arenaComputer.ditempati(row,col)) {
            System.out.println("computer menengelamkan kapal sendiri kordinat:(" + row + "," + col + ")");
            arenaComputer.terbom(row, col);
            arenaPlayer.terbom(row, col);
            computer.KapalTenggelam();
            //pemain.KapalTenggelam();
        }else if(arenaPlayer.ditempati(row,col)&& arenaComputer.ditempati(row,col)){
            System.out.println("computer menengelamkan kapal sendiri dan kapal musuh bersamaan,kordinat:(" + row + "," + col + ")");
            arenaComputer.terbom(row, col);
            arenaPlayer.terbom(row, col);
            computer.KapalTenggelam();
            pemain.KapalTenggelam();
        }else{
            System.out.println("computer meleset kordinat :("+row+","+col+")");
            arenaPlayer.tandaiMeleset(row,col);
            arenaComputer.tandaiMeleset(row,col);
        }
    }
}
