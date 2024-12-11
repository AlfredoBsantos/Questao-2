import java.util.Scanner;

class Robo {
    private int linha;
    private int coluna;
    private int passo;

    // Construtor
    public Robo(int linha, int coluna, int passo) {
        this.linha = linha;
        this.coluna = coluna;
        this.passo = passo;
    }

    // Métodos
    public void mostrarPosicaoAtual() {
        System.out.println("Posição atual do robô: (" + linha + ", " + coluna + ")");
    }

    public void andarFrente() {
        if (linha + passo < 20) {
            linha += passo;
        } else {
            linha = 19; // Limita à borda inferior
        }
    }

    public void andarTras() {
        if (linha - passo >= 0) {
            linha -= passo;
        } else {
            linha = 0; // Limita à borda superior
        }
    }

    public void andarDireita() {
        if (coluna + passo < 40) {
            coluna += passo;
        } else {
            coluna = 39; // Limita à borda direita
        }
    }

    public void andarEsquerda() {
        if (coluna - passo >= 0) {
            coluna -= passo;
        } else {
            coluna = 0; // Limita à borda esquerda
        }
    }

    // Método para representar a sala com o robô
    public void mostrarSala() {
        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 40; j++) {
                if (i == linha && j == coluna) {
                    System.out.print("1 "); // Representa o robô
                } else {
                    System.out.print(". "); // Espaços vazios
                }
            }
            System.out.println();
        }
    }
}

public class SalaRobo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Robo robo = new Robo(0, 0, 1); // Instancia o robô na posição (0, 0)

        System.out.println("Bem-vindo ao sistema do Robô!");
        robo.mostrarSala();

        while (true) {
            System.out.println("\nEscolha uma aça11o para o robô:");
            System.out.println("1 - Andar para Frente");
            System.out.println("2 - Andar para Trás");
            System.out.println("3 - Andar para Direita");
            System.out.println("4 - Andar para Esquerda");
            System.out.println("0 - Sair");
            int opcao = scanner.nextInt();

            if (opcao == 0) {
                System.out.println("Saindo do sistema. Até mais!");
                break;
            }

            switch (opcao) {
                case 1:
                    robo.andarFrente();
                    break;
                case 2:
                    robo.andarTras();
                    break;
                case 3:
                    robo.andarDireita();
                    break;
                case 4:
                    robo.andarEsquerda();
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }

            robo.mostrarPosicaoAtual();
            robo.mostrarSala();
        }

        scanner.close();
    }
}
