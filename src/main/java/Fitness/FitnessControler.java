package Fitness;

import Population.PopulationInit;
import Population.Variant;

import java.util.List;

public class FitnessControler {
    private PopulationInit populationIniter;
    public FitnessControler(PopulationInit populationInit) {
        this.populationIniter = populationInit;
    }
    public void GetFitnessScore() {
        List<Variant> listVariant = populationIniter.GetVariantModel();
        for (Variant variant: listVariant) {
            System.out.println( "Context of variant : " + variant.getContext());

        }

    }
}
