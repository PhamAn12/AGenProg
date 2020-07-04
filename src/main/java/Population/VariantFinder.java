package Population;

import GzFaulocalization.FaulResult;
import GzFaulocalization.SuspiciousCode;
import ObjectGenProg.GetBuggyPathFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class VariantFinder {
     private FaulResult faulResultofFaultLocalization;
     public VariantFinder(FaulResult faulResultofFaultLocalization) {
         this.faulResultofFaultLocalization = faulResultofFaultLocalization;
     }
     public List<Variant> InitFirstVariant() throws IOException {
         List<Variant> listFirstVariant = new ArrayList<Variant>();
         List<SuspiciousCode> suspiciousCodeList = faulResultofFaultLocalization.getListSuspiciousCode();
         List<String> buggyClassName = new ArrayList<>();
         Map<Integer,Double> dictWeightPath = null;
         for(SuspiciousCode sc : suspiciousCodeList) {
             if(sc.getSuspiciousScore() > 0) {
                 Variant variant = new Variant();
                 String className = sc.getClassName();// class buggy name
                //System.out.println("Class name" + className);
                 if(!buggyClassName.contains(className)) {
                     buggyClassName.add(className);

                     variant.setClassName(className);
                     variant.setFunctionName(sc.getFunctionName());
                     variant.setWeightPath(GetWeightPath(className));
                     variant.setContext(GetContextOfVariant(GetBuggyPathFile.GetAbsolutePath(className)));
                     variant.setPathToVariant(GetBuggyPathFile.GetAbsolutePath(className));
                     listFirstVariant.add(variant);


                 }

             }
             //sc.printDataSuspicious();
         }
         return listFirstVariant;
     }
    public void AddWeightPath(Variant variant) throws IOException {
        List<SuspiciousCode> suspiciousCodeList = faulResultofFaultLocalization.getListSuspiciousCode();

        List<String> buggyClassName = new ArrayList<>();
        for(SuspiciousCode sc : suspiciousCodeList) {
            if(sc.getSuspiciousScore() > 0) {
                String className = sc.getClassName();// class buggy name
                if(!buggyClassName.contains(className)) {
                    buggyClassName.add(className);
                    variant.setWeightPath(GetWeightPath(className));
                }

            }
        }

    }
     public Map<Integer,Double> GetWeightPath(String classBuggyName) {
         Map<Integer,Double> weightPathDic = new HashMap<>();
         List<SuspiciousCode> suspiciousCodeList = faulResultofFaultLocalization.getListSuspiciousCode();
         for (SuspiciousCode sc : suspiciousCodeList) {
             if(sc.getClassName().equals(classBuggyName)) {
                 weightPathDic.put(sc.getLineNo(),sc.getSuspiciousScore());
             }
         }
         //System.out.println(weightPathDic);
         return weightPathDic;
     }
     public String GetContextOfVariant(String pathToBuggyFile) throws IOException {
         System.out.println(pathToBuggyFile);
         Path path = Paths.get(pathToBuggyFile);
         List<String> listStsms = Files.readAllLines(path);
         return listStsms.toString();

     }
}
