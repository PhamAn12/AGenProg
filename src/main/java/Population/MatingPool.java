package Population;

import Fitness.Fitnesser;
import ObjectGenProg.ResultPopulation;
import Operation.CrossOver;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MatingPool {
    private List<Variant> listVariant;
    private ResultPopulation resultPopulation;
    public MatingPool (List<Variant> listVariant, ResultPopulation resultPopulation) {
        this.listVariant = listVariant;
        this.resultPopulation = resultPopulation;
    }
    public List<Variant> HandlePool() throws IOException {
        Random random = new Random();
        List<Variant> listOffspring  = new ArrayList<>();
        List<Variant> pool = new ArrayList<>();
        for(Variant variant : listVariant) {
            for(int i = 0; i < variant.getFinessScore() * 100; i++) {
                pool.add(variant);
            }
        }
        for(int i = 0; i< listVariant.size(); i++) {
            int a = random.nextInt(pool.size());
            int b = 0;
            do{
                b = random.nextInt(pool.size());
            }while(b == a);
            Variant parentA = pool.get(a);
            Variant parentB = pool.get(b);
            System.out.println("A : " + a + " B : " + b);
            CrossOver crossOver = new CrossOver(parentA,parentB);
            Variant childvariant = crossOver.DoCross();
            System.out.println("fitness score of child variant : " + childvariant.getFinessScore());
            System.out.println("fitness score of max point : " + resultPopulation.getMaxFitnessScore());
            System.out.println("fitness score of current variant : " + listVariant.get(i).getFinessScore());
            if(childvariant.getFinessScore() > listVariant.get(i).getFinessScore()
            && childvariant.getFinessScore() < resultPopulation.getMaxFitnessScore()) {
                listVariant.get(i).setContext(childvariant.getContext());
                listVariant.get(i).setWeightPath(childvariant.getWeightPath());
                listVariant.get(i).setFinessScore(childvariant.getFinessScore());
            }
            else if(childvariant.getFinessScore() == resultPopulation.getMaxFitnessScore()) {
                listVariant.get(i).setContext(childvariant.getContext());
                listVariant.get(i).setWeightPath(childvariant.getWeightPath());
                listVariant.get(i).setFinessScore(childvariant.getFinessScore());
                listVariant.get(i).setSOL(true);
            }

            if(listVariant.get(i).isSOL()) {
                System.out.println("solution found !");
            }else{
                System.out.println("solution not found !");
            }


        }
//        System.out.println("size pool : " + pool.size());
//        for(int i = 0; i < pool.size(); i++) {
//            int index = gen.nextInt();
//            if(!listOffspring.contains(pool.get(index))){
//                listOffspring.add(pool.get(index));
//            }
//            if(listOffspring.size() == 2)
//                break;
//        }
        return pool;
    }
}
