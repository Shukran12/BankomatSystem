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



        public void updateUserBalance(String balance) throws IOException {
           BufferedReader bfr = new BufferedReader(new FileReader("users.txt"));
           String user = bfr.readLine();
           String[] users = user.split("-");
           users[2] = balance;
           String[] newUser = new String[users.length];
            for(int q=0; q<users.length; q++){
                newUser[q] = users[q];
            }
            String newUsers2 = Arrays.toString(newUser);
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("users.txt"));
            bufferedWriter.write(newUsers2.replace("[", "").replace("]", "").replace(", ", "-"));
            bufferedWriter.close();
        }

        public static void updateUserBlock() throws IOException {
            BufferedReader bfr = new BufferedReader(new FileReader("users.txt"));
            String user = bfr.readLine();
            String[] users = user.split("-");
            users[3] = "true";
            String[] newUser = new String[users.length];
            for(int q=0; q<users.length; q++){
                newUser[q] = users[q];
            }
            String newUsers2 = Arrays.toString(newUser);
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("users.txt"));
            bufferedWriter.write(newUsers2.replace("[", "").replace("]", "").replace(", ", "-"));
            bufferedWriter.close();
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

