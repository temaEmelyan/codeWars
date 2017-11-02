package kyu7.PangramChecker;

public class PangramChecker {
    public boolean check(String sentence){
        //code

        for (int c = 'a'; c <= 'z'; c++) {
            if (sentence.toLowerCase().indexOf(c)==-1){
                return false;
            }
        }
        return true;
    }
}
