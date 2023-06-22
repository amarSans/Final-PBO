
abstract class hanyaTampilan implements tampilan{
    abstract void setup();
    abstract void gamePlay();
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
    public void tampilanMenu(){
         System.out.println(
                 "-----------------------------------------------------------\n"+
                 "--------------------GAME BATTLE SHIP-----------------------\n"+
                 "-----------------------------------------------------------\n"+
                 "|-----1. Mode single player vs computer-------------------|\n"+
                 "|-----2. Mode Multiplayer---------------------------------|\n"+
                 "|---------------------------------------------------------|\n"+
                 "|-----3. Setting------------------------------------------|\n"+
                 "|-----4. Close the game-----------------------------------|\n"+
                 "-----------------------------------------------------------\n"
         );
    }
    public void tampilanSetting(){
        System.out.println(
                "-----------------------------------------------------------\n"+
                "--------------------GAME BATTLE SHIP-----------------------\n"+
                "------SETTING Mode:----------------------------------------\n"+
                "|-----1. Atur luas arena----------------------------------|\n"+
                "|-----2. Atur jumlah kapal--------------------------------|\n"+
                "|-----3. Kembali------------------------------------------|\n"+
                "|---------------------------------------------------------|\n");
    }

    @Override
    public void tampilanNegara(){
        System.out.println(
                "-----------------------------------------------------------\n"+
                "----------------------Memilih Negara-----------------------\n"+
                "------Menu Negara:-----------------------------------------\n"+
                "|-----1. China--------------------------------------------|\n"+
                "|-----2. Amerika------------------------------------------|\n"+
                "|---------------------------------------------------------|\n");
    }

    @Override
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
}