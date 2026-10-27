
package br.edu.ifgoiano.hanoi;

public class EdTorresDeHanoi {

    private static long movimentos;

    public static void resolver(
            int discos,
            char origem,
            char destino,
            char auxiliar) {

        if (discos <= 0) {
            return;
        }

        if (discos == 1) {
            movimentos++;
            return;
        }

        resolver(discos - 1, origem, auxiliar, destino);

        movimentos++;

        resolver(discos - 1, auxiliar, destino, origem);
    }

    public static void executarTeste(int discos) {
        movimentos = 0;

        System.out.println("\n================================");
        System.out.println("TORRES DE HANOI");
        System.out.println("Quantidade de discos: " + discos);
        System.out.println("Execucao iniciada...");

        long inicio = System.nanoTime();

        resolver(discos, 'A', 'C', 'B');

        long fim = System.nanoTime();

        long tempoNs = fim - inicio;
        long tempoMs = tempoNs / 1_000_000;

        long horas = tempoMs / 3_600_000;
        long minutos = (tempoMs % 3_600_000) / 60_000;
        long segundos = (tempoMs % 60_000) / 1_000;
        long milissegundos = tempoMs % 1_000;

        System.out.println("Execucao concluida.");
        System.out.println("Quantidade de movimentos: " + movimentos);

        System.out.printf(
                "Tempo de execucao (HH:MM:SS:mm): %02d:%02d:%02d:%03d%n",
                horas, minutos, segundos, milissegundos
        );

        System.out.println("Tempo em nanossegundos: " + tempoNs);
        System.out.println("================================");
    }

    public static void main(String[] args) {
        int discos = 10;

        if (args.length > 0) {
            try {
                discos = Integer.parseInt(args[0]);
            } catch (NumberFormatException e) {
                System.out.println("Informe um numero inteiro de discos.");
                return;
            }
        }

        if (discos < 1 || discos > 41) {
            System.out.println("Informe uma quantidade entre 1 e 41 discos.");
            return;
        }

        executarTeste(discos);
    }
}
