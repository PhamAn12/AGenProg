package Fitness;

import Population.PopulationInit;
import Population.Variant;

import java.io.IOException;
import java.util.List;

public class FitnessControler {
    private PopulationInit populationIniter;
    public FitnessControler(PopulationInit populationInit) {
        this.populationIniter = populationInit;
    }
    public void GetFitnessScore() throws IOException {
        List<Variant> listVariant = populationIniter.GetVariantModel();
        for (Variant variant: listVariant) {
            System.out.println( "Context of variant : " + variant.getContext());

        }

    }
}
