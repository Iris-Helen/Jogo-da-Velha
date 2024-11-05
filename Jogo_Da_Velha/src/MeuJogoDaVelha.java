import java.util.Scanner;
public class MeuJogoDaVelha {
    public static void main(String[] args) {
        /* Variaveis do jogo. */
        Scanner scanner = new Scanner(System.in);
        char[][] tabuleiro = new char[3][3];
        char jogadorAtual = 'X';
        boolean jogoAtivo = true;
        int jogadas = 0;
        
        // Tabuleiro vazio
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                tabuleiro[i][j] = ' ';
            }
        }

        System.out.println("Bem-vindo ao jogo da velha!");
        while (jogoAtivo && jogadas < 9) {
            imprimeTabuleiro(tabuleiro);
            
            System.out.println("\nJogador " + jogadorAtual + ", é sua vez!");
            boolean jogadaValida = false;
            
            while (!jogadaValida) {
                System.out.print("Linha (1-3): ");
                int linha = scanner.nextInt() - 1;
                System.out.print("Coluna (1-3): ");
                int coluna = scanner.nextInt() - 1;
                
                if (linha >= 0 && linha < 3 && coluna >= 0 && coluna < 3 && tabuleiro[linha][coluna] == ' ') {
                    tabuleiro[linha][coluna] = jogadorAtual;
                    jogadaValida = true;
                    jogadas++;
                } else {
                    System.out.println("Jogada inválida! Tente novamente.");
                }
            }
            
            if (conferirGanhador(tabuleiro)) {
                imprimeTabuleiro(tabuleiro);
                System.out.println("Jogador " + jogadorAtual + " ganhou!!!");
                jogoAtivo = false;
            } else if (jogadas == 9) {
                imprimeTabuleiro(tabuleiro);
                System.out.println("Empatou!!!");
            } else {
                jogadorAtual = (jogadorAtual == 'X') ? 'O' : 'X';
            }
        }
        
        System.out.println("Fim de jogo.");
        scanner.close();
    }
    
    static void imprimeTabuleiro(char[][] tab) {
        System.out.println("\n-------------");
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(tab[i][j] + " | ");
            }
            System.out.println("\n-------------");
        }
    }
    
    static boolean conferirGanhador(char[][] tab) {
        for (int i = 0; i < 3; i++) {
            if (tab[i][0] != ' ' && tab[i][0] == tab[i][1] && tab[i][1] == tab[i][2]) {
                return true;
            }
        }
        
        for (int j = 0; j < 3; j++) {
            if (tab[0][j] != ' ' && tab[0][j] == tab[1][j] && tab[1][j] == tab[2][j]) {
                return true;
            }
        }
        
        if (tab[0][0] != ' ' && tab[0][0] == tab[1][1] && tab[1][1] == tab[2][2]) {
            return true;
        }
        if (tab[0][2] != ' ' && tab[0][2] == tab[1][1] && tab[1][1] == tab[2][0]) {
            return true;
        }
            return false;}
}
