import java.util.*;

public class Main {

    public static int turnCounter = 0;
    public static Map<String, String> boardMap;
    public static Map<String, Piece> deadPieces;
    public static Scanner scan = new Scanner(System.in);
    public static String[][] boardArr = new String[8][8];
    public static List<Piece> livingPiecesList = new LinkedList<Piece>();
    public static Map<String, Piece> livingPieces = new HashMap<String, Piece>();
    public static List<String> letterToNumber = new ArrayList<String>(){{ add("");add("A"); add("B"); add("C"); add("D"); add("E"); add("F"); add("G"); add("H"); }};

    public static void main(String[] args) {

       oyun();

    }

    public static void oyun() {

        update();
        hareket();

    }

    public static String hareket() {
        System.out.println("\nWhat is your move ?");
        String movement = scan.next();
        String[] move = movement.split("");
        switch (movement.length()){

            case 2: // piyon hareketi : e4 c3 vb
                int[] coords = getCoords(move[0], move[1]);
                for(int i=0; i<livingPiecesList.size(); i++){
                    if (livingPiecesList.get(i).type.equals("Pawn  ") && livingPiecesList.get(i).x == coords[0]){
                        System.out.println(livingPiecesList.get(i).move(coords[0], coords[1]));
                    }
                }
                oyun();
                break;
            case 3: // normal hareketler : Bc4, Nc3 vs || Rook : O-O o-o || piyon taş alma :

                break;
            case 4: // taş alma : Nxe5 ||Şah : Bb5+, Ng6+ ||Mat : Nf3# ||piyon yükseltme : a8=Q, f8=N vb

                break;
            case 5: // Mat : Nf3++, Bb5++, Ng6++ vb

                break;

        }

        return movement;
    }

    public static int[] getCoords(String letter, String number){
        int[] coords = new int[2];
        coords[0] = letterToNumber.indexOf(letter.toUpperCase());
        coords[1] = Integer.valueOf(number);
        return coords;
    }

    public static void update() {
        String[] letters = {"A","B","C","D","E","F","G","H"};
        if (turnCounter == 0) {

            for (int i = 1; i <= 8; i++) {
                livingPiecesList.add(new Piece("Pawn  ", "White", i, 2));
                livingPiecesList.add(new Piece("Pawn  ", "Black", i, 7));
                switch (i) {
                    case 1:
                    case 8:
                        livingPiecesList.add(new Piece("Rook  ", "White", i, 1));
                        livingPiecesList.add(new Piece("Rook  ", "Black", i, 8));
                        break;
                    case 2:
                    case 7:
                        livingPiecesList.add(new Piece("Knight", "White", i, 1));
                        livingPiecesList.add(new Piece("Knight", "Black", i, 8));
                        break;
                    case 3:
                    case 6:
                        livingPiecesList.add(new Piece("Bishop", "White", i, 1));
                        livingPiecesList.add(new Piece("Bishop", "Black", i, 8));
                        break;
                    case 4:
                        livingPiecesList.add(new Piece("King  ", "Black", i, 8));
                        livingPiecesList.add(new Piece("Queen ", "White", i, 1));
                        break;
                    case 5:
                        livingPiecesList.add(new Piece("King  ", "White", i, 1));
                        livingPiecesList.add(new Piece("Queen ", "Black", i, 8));
                        break;
                }
            }

            for (int i = 1; i < 33; i++) {
                if (i < 9) {
                    String name = "pawn_w_"+i;
                    livingPieces.put(name,new Piece("Pawn","White",(i-1),2));
                } else if (i > 16 && i < 25) {
                    String name = "pawn_b_"+i;
                    livingPieces.put(name,new Piece("Pawn","Black",(i-16),7));
                }
            }
        } else {
        }
        turnCounter++;
        System.out.print("\n\n\n\n\n\n\n\n\n\n ");
        boolean pieceFind = false;
        for(int i=0; i<8; i++){System.out.print("      "+letters[i]+"     ");}
        System.out.println("\n");
        for(int i = 1; i<=8; i++){
            System.out.print("\n   ");
            for(int j = 1; j<=8; j++){System.out.print("╔═════════╗ ");}
            for(int k = 0; k<3; k++){
                if(k==1){
                    System.out.print("\n "+i+" ");
                    for(int j = 1; j<=8; j++){
                        pieceFind=false;
                        for(Piece e : livingPiecesList){
                            if (e.x == j && e.y == i){
                                System.out.printf("%s%1.1S %4s %s ","║",e.color,e.type,"║");
                                pieceFind = true;
                            }
                        }
                        if(!pieceFind){
                            System.out.print("║         ║ ");
                        }
                    }
                }
                else{
                    System.out.print("\n   ");
                    for(int j = 0; j<8; j++){
                        System.out.print("║         ║ ");
                    }
                }
            }
            System.out.print("\n   ");
            for(int j = 0; j<8; j++){
                System.out.print("╚═════════╝ ");
            }
        }
    }
}
