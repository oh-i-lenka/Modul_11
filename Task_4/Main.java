package Modul_11.Task_4;

import java.io.*;

public class Main {
    public static void main(String[] args) {
        checkWord("should");
    }

    public  static int checkWord(String word){
        int count = 0;
        BufferedReader br=null;
        BufferedWriter bw = null;
        String wholeString="";
        try {
            br = new BufferedReader(new FileReader("D:\\Documents\\Programming\\Homework4.txt"));
        } catch (FileNotFoundException e) {
            System.out.println("FileNotFound");
        }
        try {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();

            while (line != null) {
                sb.append(line);
                line = br.readLine();
            }
            wholeString = sb.toString();
//            System.out.println(wholeString);
            int i =0;
            int index =0;
            while (i< wholeString.length() && index>=0){
                index = wholeString.indexOf(word,i);
                if (index>0){
                    count++;
                    i=index+1;
                }
            }
            System.out.println("The word \""+word+"\"  are founded "+count + " times in the file.");
        } catch (IOException e) {
            System.out.println("read failed");
        }finally {
            try {
                if (br != null)
                    br.close();
                if (bw != null)
                    bw.close();
            } catch (IOException e) {
                System.out.println("can't close reade");
            }
        }
        return count;
    }
}
