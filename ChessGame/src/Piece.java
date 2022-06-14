public class Piece {

    int x,y;
    String type;
    String color;

    public Piece(String type, String color, int x, int y){
        this.x    = x;
        this.y    = y;
        this.type = type;
        this.color= color;
    }

    public String move(int x, int y){
        String oldPos = Main.letterToNumber.get(this.x)+this.y;
        String newPos = Main.letterToNumber.get(x)+y;
        String reason ="invalid movement \n->default error";
        Boolean isValid=false;
        String type = this.type.toLowerCase();
        switch (type){
            case "pawn  ":
                if(color.equals("White")){
                    if ((y-this.y)<=2 && (y-this.y)>0){
                        this.x = x; this.y = y;
                        isValid = true;
                    }
                }
                if(color.equals("Black")){
                    if ((this.y-y)<=2 && (this.y-y)>0){
                        this.x = x; this.y = y;
                        isValid = true;
                    }
                }
                break;
            case "rook  ":

                break;
            case "king  ":

                break;
            case "queen ":

                break;
            case "knight":

                break;
            case "bishop":

                break;
        }

        if(isValid){
            return "from "+oldPos+" to "+newPos;
        }
        else{
            return "from" +oldPos+" to "+newPos+"\nThis movement is invalid\nReason : "+reason;
        }
    }

}
