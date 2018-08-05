package com.antoniosj.challanges;

import java.util.Arrays;

public class BoatsCounter {

    // oreencher os barcos com até 2 pessoas não passando do limite
    //ex [1 3 2 2] e limit = 3
    public int numRescueBoats(int[] people, int limit) {

        int p = people.length;
        int res = 0;
        int boats = 0;

        //1, 2, 2, 3
        Arrays.sort(people);

        //conta de trás pra frente e verifica se precisa andar dos dois lados do array
        //tenta somar sempre o maior com o menor e depois anda o index até se encontrar
        for (int i = p - 1; i >= res; i--) {
            if (res < i && people[i] + people[res] <= limit) {
                res++;
            }
            boats++;
        }
        return boats;
    }


}
