import java.util.InputMismatchException;
import java.util.Scanner;
public class AplikasiOpsi2 {
    public static void main(String[] args) {
        gamePlay oke=new gamePlay();
        oke.layarAwal();
    }
}

interface tampilan {
    void pilihMonster(Monster moster1,Monster moster2,Monster moster3);
    void pilihHero(Hero hero1,Hero hero2,Hero hero3,Hero Mod);
    void tampilanCloseGame();
    void akhirPermainan();
    void awal();
    void MOD();
    void detail(int health, int damage);
    void Menang();
    void kalah();
    void detailHP(int health);
    void detailDMG(int damage);
}
abstract class hanyaTampilan implements tampilan{
    public boolean special=false;
    abstract void turnTrio(Hero hero0,Hero hero1, Hero hero2,Hero hero3, Monster lawan);
    abstract void turnDuo(Hero hero1, Hero hero2,Hero hero3, Monster lawan);
    abstract void turnSingle(Hero awal, Monster lawan);
    public void pilihMonster(Monster moster1,Monster moster2,Monster moster3){
        System.out.println("silahkan pilih monster untuk dilawan:");
        System.out.println("1. " + moster1.getName());
        detail(moster1.getHealth(), moster1.getDamage());
        System.out.println("2. " + moster2.getName());
        detail(moster2.getHealth(), moster2.getDamage());
        System.out.println("3. " + moster3.getName());
        detail(moster3.getHealth(), moster3.getDamage());
        System.out.print("pilih:");
    }
    public void pilihHero(Hero hero1,Hero hero2,Hero hero3,Hero Mod){
        System.out.println("silahkan pilih hero: ");
        System.out.println("1." + hero1.getName() + "\t");
        detail(hero1.getHealth(), hero1.getDamage());
        System.out.println("\n2." + hero2.getName() + "\t");
        detail(hero2.getHealth(), hero2.getDamage());
        System.out.println("\n3." + hero3.getName() + "\t");
        detail(hero3.getHealth(), hero3.getDamage());
        if(special==true){
            System.out.println("\n4." + Mod.getName() + "\t");
            detail(Mod.getHealth(), Mod.getDamage());
        }
        System.out.println("pilih:");
    }
    public void tampilanCloseGame() {
        System.out.println(
                "-----------------------------------------------------------\n"+
                        "--------------------INPUTAN SALAH--------------------------\n"+
                        "------Menu:------------------------------------------------\n"+
                        "|-----1. Kembali ke Menu----------------------------------|\n"+
                        "|-----2. Akhiri Battle------------------------------------|\n"+
                        "|-----3. Lanjutkan Permainan------------------------------|\n"+
                        "|---------------------------------------------------------|\n");
    }
    public void akhirPermainan(){
        System.out.println(
                "-----------------------------------------------------------\n"+
                        "------ingin bermain lagi??---------------------------------\n"+
                        "------Menu:------------------------------------------------\n"+
                        "|-----1. Kembali ke layar awal----------------------------|\n"+
                        "|-----2. Akhiri program-----------------------------------|\n"+
                        "|---------------------------------------------------------|\n");
    }
    public void awal() {
        System.out.println(
                "-----------------------------------------------------------\n"+
                        "---------------------MONSTER ATTACK------------------------\n"+
                        "------ Mod:------------------------------------------------\n"+
                        "|----- klik apa saja untuk memulai -----------------------|\n"+
                        "|----- Z: Mode MOD----------------------------------------|\n"+
                        "|---------------------------------------------------------|\n");
    }
    public void MOD() {
        System.out.println(
                "-----------------------------------------------------------\n"+
                        "---------------------MONSTER ATTACK------------------------\n"+
                        "------ Mode:-----------------------------------------------\n"+
                        "|----- Z:Membuat karakter sendiri ------------------------|\n"+
                        "|----- 0. kembali ----------------------------------------|\n"+
                        "|---------------------------------------------------------|\n");
    }
    public void detail(int health, int damage){
        System.out.print("\tHP(\t" + health + " )\t\t:");
        for (int i = 0; i < health; i++) {
            System.out.print('|');
        }
        System.out.print("\n\tDAMAGE(" + damage + ")\t\t:");
        for (int i = 0; i < damage; i++) {
            System.out.print('|');
        }
        System.out.println();
    }
    public void Menang(){
        System.out.println("                                                               \n" +
                "I8,        8        ,8I 88                                                \n" +
                "`8b       d8b       d8' ^^                                                \n" +
                " ^8,     ,8^8,     ,8^                                                    \n" +
                "  Y8     8P Y8     8P   88 8b,dPPYba,  8b,dPPYba,   ,adPPYba, 8b,dPPYba,  \n" +
                "  `8b   d8' `8b   d8'   88 88P'   `^8a 88P'   `^8a a8P_____88 88P'   ^Y8  \n" +
                "   `8a a8'   `8a a8'    88 88       88 88       88 8PP^^^^^^^ 88          \n" +
                "    `8a8'     `8a8'     88 88       88 88       88 ^8b,   ,aa 88          \n" +
                "     `8'       `8'      88 88       88 88       88  `^Ybbd8^' 88          \n" +
                "                                                                          \n");
    }
    public void kalah(){
        System.out.println("                                                                                                 \n" +
                "  ,ad8888ba,                                                ,ad8888ba,                                      \n" +
                " d8^'    `^8b                                              d8^'    `^8b                                     \n" +
                "d8'                                                       d8'        `8b                                    \n" +
                "88            ,adPPYYba, 88,dPYba,,adPYba,   ,adPPYba,    88          88 8b       d8  ,adPPYba, 8b,dPPYba,  \n" +
                "88      88888 ^^     `Y8 88P'   ^88^    ^8a a8P_____88    88          88 `8b     d8' a8P_____88 88P'   ^Y8  \n" +
                "Y8,        88 ,adPPPPP88 88      88      88 8PP^^^^^^^    ^^^         Y8, ,8P   8b   8PP^^^^^^^ 88          \n" +
                " Y8a.    .a88 88,    ,88 88      88      88 ^8b,   ,aa     Y8a.    .a8P    `8b,d8'   ^8b,   ,aa 88          \n" +
                "  `^Y88888P^  `^8bbdP^Y8 88      88      88  `^Ybbd8^'      `^Y8888Y^'       ^8^      `^Ybbd8^' 88          \n" +
                "                                                                                                            \n" +
                "                                                                                                            \n");
    }
    public void detailHP(int health){
        System.out.print("\tHP(" + health + ")\t\t:");
        for (int i = 0; i < health; i++) {

            System.out.print('|');
        }

    }
    public void detailDMG(int damage){
        System.out.print("\n\tDAMAGE(" + damage + ")\t:");
        for (int i = 0; i < damage; i++) {
            System.out.print('|');
        }

    }
}
class Hero {
    private String name;
    private int health;
    private int damage;
    private int nilaiTampung;
    public void reset(){
        health=nilaiTampung;
    }

    public Hero(String name, int health, int damage) {
        this.name = name;
        this.health = health;
       this.nilaiTampung=health;
        this.damage = damage;
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health=health;
    }

    public int getDamage() {
        return damage;
    }
    public void setName(String name) {
        this.name = name;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }


    public void attack(Monster monster) {
        System.out.println(name + " menyerang " + monster.getName() + "!");
        monster.takeDamage(damage);
    }
}
class Monster  {
    private String name;
    private int nilaiTampung;
    private int health;
    private int damage;

    public Monster(String name, int health, int damage) {
        this.name = name;
        this.health = health;
        this.damage = damage;
        this.nilaiTampung=health;
    }
    public void reset(){
        health=nilaiTampung;
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getDamage() {
        return damage;
    }

    public void takeDamage(int damage) {
        health -= damage;
        if (health < 0) {
            health = 0;
        }
        System.out.println(name + " menerima " + damage + " damage!");
        if (health == 0) {
            System.out.println(name + " dikalahkan!");
        }
    }

    public void attack(Hero hero) {
        System.out.println("\n");
        System.out.println(name + " menyerang!!!!");
        hero.setHealth(hero.getHealth() - damage);

    }

}

class gamePlay extends hanyaTampilan {
    int choice;
    static Scanner scanner = new Scanner(System.in);

    Hero warior = new Hero("warior", 100, 20);
    Hero wisard = new Hero("wisard", 90, 30);
    Hero tank = new Hero("Guardian", 150, 10);
    Monster dragon = new Monster("dragon", 300, 30);
    Monster goblin = new Monster("goblin", 100, 10);
    Monster Maou=new Monster("raja Iblis",1000,100);
   // String nama;

    Hero mod=new Hero(" ",0,0);
    char pilih;
    void layarAwal(){
        awal();
        pilih=scanner.next().charAt(0);
        if(pilih=='z'&&special==true){
            MOD();
            pilih=scanner.next().charAt(0);
            if(pilih=='z'){
                scanner.nextLine();
            System.out.print("masukkan nama karakter: ");mod.setName(scanner.nextLine());
            System.out.print("masukkan jumlah damage: ");mod.setHealth(scanner.nextInt());
            System.out.print("masukkan jumlah darah : ");mod.setDamage(scanner.nextInt());
            System.out.println("karakter tersimpan!!!!!");
            tampilanCloseGame();pilih=scanner.next().charAt(0);
            switch (pilih){
                case'1'->layarAwal();
                case'2'->System.exit(0);
                case'3'->Play();
            }
            }
        }
        Play();
    }
    void turnTrio(Hero hero0,Hero hero1, Hero hero2,Hero hero3, Monster lawan) {

        int combinasi=hero1.getHealth() + hero2.getHealth()+hero0.getHealth();
        hero3.setHealth(combinasi);

        while (true) {
            if(lawan.getHealth()<=0||hero3.getHealth()<=0){
                break;
            }else{
                macth(hero0,lawan,hero3);
                if (lawan.getHealth() <= 0) {
                    System.out.println(lawan.getName()+" telah dikalahkan!");lawan.reset();
                    clearMatch();
                    Menang();
                    return;
                }

                macth(hero1,lawan,hero3);
                if (lawan.getHealth() <= 0) {
                    System.out.println(lawan.getName()+" telah dikalahkan!");lawan.reset();
                    clearMatch();
                    Menang();
                    return;
                }
                macth(hero2,lawan,hero3);
                if (lawan.getHealth() <= 0) {
                    System.out.println(lawan.getName()+" telah dikalahkan!");lawan.reset();
                    clearMatch();
                    Menang();
                    return;
                }

                lawan.attack(hero3);
                if (hero3.getHealth() <= 0) {
                    System.out.println("Hero1,Hero2 dan hero 3 dikalahkan!");
                    clearMatch();
                    kalah();lawan.reset();
                    return;
                }
                System.out.println("hp combinasi: ");detailHP(hero3.getHealth());
                System.out.print("\nKondisi Hero1:");
                detailDMG( hero1.getDamage());
                System.out.print("\nKondisi Hero2:");
                detailDMG(hero2.getDamage());
                System.out.print("\nKondisi Hero2:");
                detailDMG(hero0.getDamage());
            }
        }}
    void turnDuo(Hero hero1, Hero hero2,Hero hero3, Monster lawan) {

        int combinasi=hero1.getHealth() + hero2.getHealth();
        hero3.setHealth(combinasi);
        while (true) {
            if(lawan.getHealth()<=0||hero3.getHealth()<=0) {
                break;
            }else{
                macth(hero1,lawan,hero3);

                if (lawan.getHealth() <= 0) {
                    System.out.println("Monster telah dikalahkan!");Menang();lawan.reset();
                    clearMatch();
                    break;
                }
                macth(hero2,lawan,hero3);
                if (lawan.getHealth() <= 0) {
                    System.out.println("Monster telah dikalahkan!");Menang();lawan.reset();
                    clearMatch();
                    break;
                }
                lawan.attack(hero3);
                if (hero3.getHealth() <= 0) {
                    System.out.println("Hero1 dan Hero2 dikalahkan!");
                    kalah();lawan.reset();
                    clearMatch();
                    return;
                }
                System.out.println("hp combinasi: ");detailHP(hero3.getHealth());
                System.out.print("\nKondisi Hero1:");
                detailDMG( hero1.getDamage());
                System.out.print("\nKondisi Hero2:");
                detailDMG(hero2.getDamage());
            }}
    }
    void turnSingle(Hero awal, Monster lawan) {

        while (true) {
            int choice;
            if(lawan.getHealth()<=0||awal.getHealth()<=0){
                break;
            }else{
                do{
                    try {
                        System.out.println("\n--- Giliran " + awal.getName() + " ---");
                        System.out.println("1. Serang monster");
                        System.out.println("2. Mode pertahanan");
                        do {
                            System.out.print("Pilihan: ");
                            choice = scanner.nextInt();
                        } while (choice < 1 || choice > 2);
                    }catch (InputMismatchException a){
                        scanner.nextLine();
                        System.out.print("kesalahan inputan!!!!");
                        continue;
                    }break;
                }while(true);
                if (choice == 1) {
                    awal.attack(lawan);
                    System.out.println(lawan.getName() + ":");
                    detail(lawan.getHealth(), lawan.getDamage());
                } else {
                    System.out.println(awal.getName() + " memasuki mode pertahanan.");
                    int prevHealth = awal.getHealth();
                    awal.setHealth(prevHealth + 20);
                    System.out.println(awal.getName() + " memulihkan 10 poin darah.");
                    System.out.println(awal.getName() + ":");
                    detail(awal.getHealth(), awal.getDamage());
                }

                if (lawan.getHealth() <= 0) {
                    System.out.println("Monster telah dikalahkan!");Menang();
                    if(Maou.getHealth()<=0){
                        special=true;
                    }
                    lawan.reset();awal.reset();
                    clearMatch();
                    break;
                }

                lawan.attack(awal);
                if (awal.getHealth() <= 0) {
                    System.out.println(awal.getName() + " dikalahkan!");kalah();awal.reset();lawan.reset();
                    clearMatch();
                    return;
                }
                System.out.println("kondisi " + awal.getName() + " :");
                detail(awal.getHealth(), awal.getDamage());

            }}

    }
    void clearMatch(){
        akhirPermainan();
        do{try {
            System.out.print("pilih:");
            pilih = scanner.next().charAt(0);
        }catch (InputMismatchException a){
            scanner.nextLine();
            System.out.println("kesalahan inputan");
            continue;
        }break;
        }while(true);
        if(pilih=='1')layarAwal();
        else if(pilih=='2') System.exit(0);
        else clearMatch();
    }
    public void Play() {
        char pilih;
        Monster moster=selecMonster(Maou,dragon,goblin);
        System.out.println("silahkan pilih mode:\n1.singgle hero\n2.dua hero\n3.tiga hero\npilih:");
        pilih = scanner.next().charAt(0);
        switch (pilih) {
            case '1' -> {Hero hero1=selectHero(warior,wisard, tank,mod);
                        turnSingle(hero1,moster);
                        }
            case '2'-> {
                Hero hero1=selectHero(warior,wisard, tank,mod);
                Hero hero2=selectHero(warior,wisard, tank,mod);

                Hero hero=new Hero("Combinasi",0,0);
                turnDuo(hero1,hero2,hero,moster);
                }
            case '3'->{Hero hero0=selectHero(warior,wisard, tank,mod);
                Hero hero1=selectHero(warior,wisard, tank,mod);
                Hero hero2=selectHero(warior,wisard, tank,mod);

                Hero hero=new Hero("Combinasi",0,0);
                turnTrio(hero0,hero1,hero2,hero,moster);
                }
            default -> {System.out.println("tidak ada dalam pilihan:");Play();}
        }
    }
    public Monster selecMonster(Monster moster1, Monster moster2, Monster moster3){
        Monster selectedMoster =null;int mosterPilih;
        do{try {
            pilihMonster(moster1, moster2, moster3);
            mosterPilih = scanner.nextInt();
        }catch (InputMismatchException a){
            scanner.nextLine();
            continue;
        }break;
        }while(true);
        if (mosterPilih == 1) {
            selectedMoster = moster1;
        } else if (mosterPilih == 2) {
            selectedMoster = moster2;
        } else if (mosterPilih == 3) {
            selectedMoster = moster3;
        } else{
            System.out.println("tidak ada dalam pilihan!!!");selecMonster(moster1,moster2,moster3);
        }
        return selectedMoster;
    }
    public Hero selectHero(Hero hero1, Hero hero2, Hero hero3,Hero MOD) {
        Hero selectedHero = null;int heroPilih;
        do{try {
            pilihHero(hero1, hero2, hero3, MOD);
            heroPilih = scanner.nextInt();
        }catch (InputMismatchException a){
            scanner.nextLine();
            continue;
        }break;
        }while(true);
        if (heroPilih == 1) {
            selectedHero = hero1;
        } else if (heroPilih == 2) {
            selectedHero = hero2;
        } else if (heroPilih == 3) {
            selectedHero = hero3;
        }else if (heroPilih == 4&&special==true) {
                selectedHero = MOD;
        }else{
            System.out.println("tidak ada dalam pilihan!!");selectHero(hero1,hero2,hero3,MOD);
        }
        return selectedHero;
    }
    void macth(Hero pemain,Monster lawan,Hero hero3){
        do {
            try {
                System.out.println("\n--- Giliran " + pemain.getName() + " ---");
                System.out.println("1. Serang monster");
                System.out.println("2. Mode pertahanan");
                do {
                    System.out.print("Pilihan: ");
                    choice = scanner.nextInt();
                } while (choice < 1 || choice > 2);
            } catch (InputMismatchException a) {
                scanner.nextLine();
                continue;
            }
            break;
        }while(true);
        if (choice == 1) {
            pemain.attack(lawan);
            System.out.println(lawan.getName() + ":");
            detail(lawan.getHealth(), lawan.getDamage());
        } else {
            System.out.println(pemain.getName() + " memasuki mode pertahanan.");
            int prevHealth = hero3.getHealth();
            hero3.setHealth(prevHealth + 20);
            System.out.println(pemain.getName() + " memulihkan 20 poin darah.");
            System.out.println("hp combinasi: ");detailHP(hero3.getHealth());
            detailDMG( pemain.getDamage());
        }

    }
}
