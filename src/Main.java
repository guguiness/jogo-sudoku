import tabuleiro.Tabuleiro;

public class Main {
    public static void main(String[] args) {
        String valoresIniciais =
            "0,0,9;0,1,5;0,2,8;0,7,2;" +
            "1,3,2;1,4,5;1,5,6;1,7,4;" +
            "2,2,6;2,6,5;2,7,1;2,8,7;" +
            "3,0,6;3,3,3;3,4,7;3,5,8;" +
            "4,0,7;4,1,8;4,2,4;4,6,9;4,7,3;4,8,2;" +
            "5,3,4;5,4,2;5,5,9;5,8,8;" +
            "6,0,4;6,1,9;6,2,2;6,6,1;" +
            "7,1,6;7,3,5;7,4,8;7,5,1;" +
            "8,1,1;8,6,7;8,7,6;8,8,3";

        Tabuleiro tabuleiro = new Tabuleiro(valoresIniciais);

        tabuleiro.visualizar();
    }
}
