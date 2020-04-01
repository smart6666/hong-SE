package calculator;

import java.io.*;
import java.util.ArrayList;

public class Correcting {

	
	
    public static void correctAnswer(String expfile, String ansfile) throws Exception{
        String lineAns;
        String lineExe;
        int test = 1;
        ArrayList<Integer> listCorrect = new ArrayList<>();
        ArrayList<Integer> listWrong = new ArrayList<>();

        BufferedReader brExe = new BufferedReader(new FileReader(expfile));
        BufferedReader brAns = new BufferedReader(new FileReader(ansfile));
        //BufferedWriter bw = new BufferedWriter(new FileWriter("Grade.txt"));
        PrintStream bw = new PrintStream(new FileOutputStream("Grade.txt"));
        while ((lineAns = brAns.readLine()) != null){
            lineAns = lineAns.split(":")[1];

            lineExe = brExe.readLine();
            String [] exerSplit = lineExe.split(":");
            if(exerSplit.length == 3){
                lineExe = exerSplit[2];
            }

            if(lineAns.equals(lineExe)){
                listCorrect.add(test++);
            }else {
                listWrong.add(test++);
            }
        }


        bw.print("Correct:" + listCorrect.size() + "(");
        if(listCorrect.size() == 0){
            bw.print(")");
        }else{
            for(int i = 0; i < listCorrect.size(); i++){
                bw.print(listCorrect.get(i));
                if(i == listCorrect.size()-1){
                    bw.print(")");
                }else {
                    bw.print(",");
                }
            }
        }


        bw.println();
        bw.print("Wrong:" + listWrong.size() + "(");
        if(listWrong.size() == 0){
            bw.print(")");
        }else {
            for (int i = 0; i < listWrong.size(); i++) {
                bw.print(listWrong.get(i));
                if (i == listWrong.size() - 1) {
                    bw.print(")");
                } else {
                    bw.print(",");
                }
            }
        }

        bw.close();
        brAns.close();
        brExe.close();

    }
}
