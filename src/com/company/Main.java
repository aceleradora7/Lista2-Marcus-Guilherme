package com.company;

import java.util.ArrayList;
import java.util.BitSet;

public class Main {

    public static void main(String[] args){

        ArrayList<String> listadeNomes= new ArrayList<>();
        ArrayList<Integer> listadeInteiros= new ArrayList<>();

        ArrayList<Integer> listadeIntA= new ArrayList<>();
        listadeIntA.add(1);
        listadeIntA.add(2);
        listadeIntA.add(3);
        listadeIntA.add(4);
        listadeIntA.add(5);
        ArrayList<Integer> listadeIntB= new ArrayList<>();
        listadeIntB.add(0);
        listadeIntB.add(2);
        listadeIntB.add(5);
        listadeIntB.add(8);
        listadeIntB.add(10);
        ArrayList<Boolean> listadeIntC= new ArrayList<>();
        ArrayList<Integer> intersecao= new ArrayList<>();
        ArrayList<Integer> uniao= new ArrayList<>();


        System.out.println("lISTA DE NOMES adicionados");
        for (int i = 0; i < 5 ; i++) {
          listadeNomes.add("Marcus" + (i+1));
            System.out.println("Nome: " + (listadeNomes.get(i)));
        }

        System.out.println("\nlISTA DE NOMES removido");
        delete(listadeNomes, 2);
        for (int i = 0; i < listadeNomes.size() ; i++) {
            System.out.println("Nome: " + listadeNomes.get(i));
        }

        System.out.println("\nVERIFICA NOMES");
        System.out.println("Verificando Marcus3: " + verificaNome(listadeNomes, "Marcus3"));
        System.out.println("Verificando Marcus5: " + verificaNome(listadeNomes, "Marcus5"));
        System.out.println("\nTAMANHO LISTA");
        System.out.println("Tamanho atual: "+ listadeNomes.size());

        System.out.println("\nlISTA DE INTEIROS");
        for (int i = 0; i < 5 ; i++) {
            listadeInteiros.add(i+50);
            System.out.println("Soma: " + (listadeInteiros.get(i)));
        }


        System.out.println("\nSoma elementos: " + somaElementos(listadeInteiros));
        System.out.println("\nCOMPARA ARRAY 1");
        listadeIntC = listaC(listadeIntA, listadeIntB, listadeIntC);
        for (int i = 0; i <listadeIntC.size() ; i++) {
            System.out.println(listadeIntC.get(i));
        }

        System.out.println("\n7) Interseção");
        intersecao = criaGrupoIntersecaoDosArrays(listadeIntA, listadeIntB, intersecao);
        for (int i = 0; i < intersecao.size(); i++) {
            System.out.println("conteudo produzido pela interseção de A e B: " + intersecao.get(i));
        }

        System.out.println("\n 8) CONJUNTO UNIÃO");
        uniao = criaConjuntoUniaoDeAeB(listadeIntA, listadeIntB, uniao);
        for (int i = 0; i < uniao.size(); i++) {
            System.out.println("conteudo produzido pela uniao de A e B: " + uniao.get(i));
        }



    }//Fim main

    public static ArrayList<Boolean> listaC(ArrayList<Integer> A, ArrayList<Integer> B, ArrayList<Boolean> C){
        for (int i = 0; i < A.size() ; i++) {
            if (A.get(i) == B.get(i)) {
                C.add(i, true);

            }
            else{
                C.add(i, false);
            }
        }
        return C;
    }

    public static void delete(ArrayList<String> nomes, int indice){
        
        nomes.remove(indice);
    }

    public static boolean verificaNome(ArrayList<String> nomes, String nome){

        boolean contem = false;
        for (int i = 0; i < nomes.size(); i++) {

            if(nomes.get(i).equalsIgnoreCase(nome)){
                return true;
            }
        }
        return false;
    }

    public static int somaElementos(ArrayList<Integer> seila){
        int soma=0;

        for (int i = 0; i < seila.size() ; i++) {

            soma= soma+seila.get(i);
        }
        return soma;
    }

    public static ArrayList<Integer> criaGrupoIntersecaoDosArrays(ArrayList<Integer> listaA, ArrayList<Integer> listaB, ArrayList<Integer> intersecaoList){

        for (int i = 0; i < listaA.size(); i++) {
            for (int j = 0; j < listaA.size(); j++) {

                if (listaA.get(j) == listaB.get(i)){
                    intersecaoList.add(listaA.get(j));
                }
            }
        }
        return intersecaoList;
    }

    public static ArrayList<Integer> criaConjuntoUniaoDeAeB(ArrayList<Integer> listaA, ArrayList<Integer> listaB, ArrayList<Integer> uniao){

        uniao.addAll(listaA);
        for (int i = 0; i < listaB.size(); i++) {
            if(!listaA.contains(listaB.get(i))) {
                uniao.add(listaB.get(i));
            }
        }

        return uniao;
    }
}
