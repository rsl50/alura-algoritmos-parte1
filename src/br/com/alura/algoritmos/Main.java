package br.com.alura.algoritmos;

public class Main {

    private static int buscaMenor(Produto[] produtos, int inicio, int termino) {

        int maisBarato = inicio;

        for (int i = inicio; i <= termino; i++) {
            if (produtos[i].getPreco() < produtos[maisBarato].getPreco()) {
                maisBarato = i;
            }
        }

        return maisBarato;
    }

    private static int buscaMaior(Produto[] produtos) {
        int maisCaro = 0;

        for (int i = 0; i < produtos.length; i++) {
            if (produtos[i].getPreco() > produtos[maisCaro].getPreco()) {
                maisCaro = i;
            }
        }

        return maisCaro;
    }

    private static void imprime(Produto[] produtos) {
        for (Produto produto : produtos) {
            System.out.println("O carro " + produto.getNome() + " custa R$ " + produto.getPreco());
        }
    }

    private static void troca(Produto[] produtos, int primeiro, int segundo) {
        Produto primeiroProduto = produtos[primeiro];
        Produto segundoProduto = produtos[segundo];
        System.out.println("Estou trocando " + primeiro + " com " + segundo);

        System.out.println("Estou trocando " + primeiroProduto.getNome() + " com " + segundoProduto.getNome());

        produtos[primeiro] = segundoProduto;
        produtos[segundo] = primeiroProduto;
    }

    private static void selectionSort(Produto[] produtos, int quantidadeDeElementos) {
        for (int i = 0; i < quantidadeDeElementos - 1; i++) {
            System.out.println("Estou na casinha " + i);

            int menor = buscaMenor(produtos, i, quantidadeDeElementos - 1);

            troca(produtos, i, menor);
            //Produto produtoMenor = produtos[menor];
            //Produto produtoAtual = produtos[i];
            //produtos[i] = produtoMenor;
            //produtos[menor] = produtoAtual;
        }
    }

    private static void insertionSort(Produto[] produtos, int quantidadeDeElementos) {

        for (int i = 1; i < quantidadeDeElementos; i++) {
            int analise = i;
            System.out.println("Estou na casinha " + analise);

            while ((analise > 0) && (produtos[analise].getPreco() < produtos[analise - 1].getPreco())) {
                troca(produtos, analise, analise - 1);
                analise--;
            }

            imprime(produtos);
        }
    }


    public static void main(String[] args) {
        Produto[] produtos = {
                new Produto("Lamborghini", 1000000),
                new Produto("Jipe", 46000),
                new Produto("Brasilia", 16000),
                new Produto("Smart", 46000),
                new Produto("Fusca", 17000)
        };

        int carroMaisBarato = buscaMenor(produtos, 0, 4);
        System.out.println("O carro mais barato é: " + produtos[carroMaisBarato].getNome() + " no valor de R$ " + produtos[carroMaisBarato].getPreco());

        int carroMaisCaro = buscaMaior(produtos);
        System.out.println("O carro mais caro é: " + produtos[carroMaisCaro].getNome() + " no valor de R$ " + produtos[carroMaisCaro].getPreco());

        System.out.println("========================================");
        System.out.println("SELECTION SORT");
        selectionSort(produtos, produtos.length);
        System.out.println();
        imprime(produtos);

        System.out.println("========================================");
        System.out.println("INSERTION SORT");
        insertionSort(produtos, produtos.length);
        System.out.println();
        imprime(produtos);
    }
}
