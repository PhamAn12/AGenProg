package GzFaulocalization;

import java.util.Dictionary;
import java.util.List;

public class SuspiciousCode {
    private String className;
    private String functionName;
    private int lineNo;

    public String getClassName() {
        return className;
    }

    public String getFunctionName() {
        return functionName;
    }

    public List<Integer> getLineOfCodeExcute() {
        return lineOfCodeExcute;
    }

    public Dictionary<Integer, Double> getMapLineToPoint() {
        return mapLineToPoint;
    }

    public int getLineNo() {
        return lineNo;
    }

    public double getSuspiciousScore() {
        return suspiciousScore;
    }

    private double suspiciousScore;
    private List<Integer> lineOfCodeExcute;
    private Dictionary<Integer,Double> mapLineToPoint;
    public void addLineToListLineExcute(int lineNo){
        this.lineOfCodeExcute.add(lineNo);
    }
    public void setClassName(String className){
        this.className = className;
    }
    public void setMethodName(String functionName){
        this.functionName = functionName;
    }
    public void setLineNo(int lineNo){
        this.lineNo = lineNo;
    }
    public void setSuspiciousScore(double score){
        this.suspiciousScore = score;
    }
    public void printDataSuspicious(){
        System.out.println("CN : " + className + " MN : " + functionName + " liNo : " + lineNo + "sC : " + suspiciousScore);

    }

}
