package Modul_11.Task_2;

import java.io.*;
import java.util.LinkedHashMap;
import java.util.Map;

public class Main {
    static Map<String, String> mapOfWords = new LinkedHashMap<>();
    public static void main(String[] args) {

        mapOfWords.put("You","if ");
        mapOfWords.put("should","you ");
        mapOfWords.put("create","can ");
        mapOfWords.put("method","keep ");
        mapOfWords.put("which","your ");
        mapOfWords.put("replace","head ");
        mapOfWords.put("words","when ");
        mapOfWords.put("in","all ");
        mapOfWords.put("the","about ");
        mapOfWords.put("File","you ");
        mapOfWords.put("and","are ");
        mapOfWords.put("returns","losing ");
        mapOfWords.put("String","theirs ");
        mapOfWords.put("with","and blaming ");
        mapOfWords.put("replaced","it on you... ");
        mapOfWords.put("values","Rudyard Kipling ");

        replacer(mapOfWords);
    }

    public static String replacer(Map<String, String> map) {
        BufferedReader br=null;
        BufferedWriter bw = null;
        String wholeString="";
        try {
            br = new BufferedReader(new FileReader("D:\\Documents\\Programming\\Homework2.txt"));
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
            if (!wholeString.endsWith(" ")){
                wholeString += " ";
            }
            wholeString = deletingSpaces(wholeString);

            int i = 0;
            int index = 0;
            String newWholeString = "";

            while (i< wholeString.length() && index >=0) {
                index = wholeString.indexOf(" ",i);
                String tempString = wholeString.substring(i,index);
                System.out.println(""+tempString);
                if (mapOfWords.containsKey(tempString)){
                    newWholeString = newWholeString.concat(mapOfWords.get(tempString));
//                    System.out.println("changed "+newWholeString);
                } else newWholeString = newWholeString.concat(Integer.toString(i));
                i=index+1;
                System.out.println("index is " + (index));
            }

            System.out.println("Changed string  " + newWholeString);
            bw = new BufferedWriter(new FileWriter("D:\\Documents\\Programming\\Homework2.txt"));
            bw.flush();
            bw.write(newWholeString);
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
        return wholeString;
    }
    public static String deletingSpaces (String wholeString){
        while (wholeString.contains("  ")) {
            wholeString = wholeString.replaceAll("  "," ");
        }
        return wholeString;
    }
}
