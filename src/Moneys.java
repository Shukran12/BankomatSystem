import java.io.*;
import java.util.Arrays;

public class Moneys {



    public  void updateMoney(String money, String qty){
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("moneys.txt"));
            String eskinaz = bufferedReader.readLine();
            String[] newEskinaz = new String[eskinaz.split(", ").length];
            for (int i = 0; i < eskinaz.split(", ").length ; i++) {
                newEskinaz[i] = eskinaz.split(", ")[i];
                if (eskinaz.split(", ")[i].split("-")[0].equals(money)) {
                    newEskinaz[i] = money + "-" + qty;
                }

            }
          String newMoney = Arrays.toString(newEskinaz);


            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("moneys.txt"));
            bufferedWriter.write(newMoney.replace("[", "").replace("]", ""));
            bufferedWriter.close();
       } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
       }
        }




        }

//    public void addMoney(String money, String qty){
//        try {
//            BufferedReader bufferedReader = new BufferedReader(new FileReader("moneys.txt"));
//            String eskinaz = bufferedReader.readLine();
//            String[] newEskinaz = new String[eskinaz.split(";").length];
//            for(int i=0; i<eskinaz.split(";").length; i++){
//                newEskinaz[i] = eskinaz.split(";")[i];
//                if(eskinaz.split(";")[i].split("-")[0].equals(money)){
//                    newEskinaz[i] = money+"-"+qty;
//                }
//            }
//            String newMoney = Arrays.toString(newEskinaz);
//
//            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("moneys.txt"));
//            bufferedWriter.write(newMoney);
//            bufferedWriter.close();
//        } catch (FileNotFoundException e) {
//            throw new RuntimeException(e);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//    }

