import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Map<Integer, Integer> map = new HashMap<>();
        System.out.println("Ad Daxil edin:");
        Scanner sc = new Scanner(System.in);
        BufferedReader bfr = new BufferedReader(new FileReader("users.txt"));
        String user = bfr.readLine();

        String[] users = user.split(", ");
        int totalCash = 0;
        try {


               BufferedReader bufferedReader = new BufferedReader(new FileReader("moneys.txt"));

            String eskinas = bufferedReader.readLine();

            for(int i=0; i<eskinas.split(", ").length; i++){
               int nom= Integer.parseInt(eskinas.split(", ")[i].split("-")[0]);
                int qty = Integer.parseInt(eskinas.split(", ")[i].split("-")[1]);
                map.put(nom, qty);
                totalCash+=nom*qty;
            }





        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }  catch (IOException e) {
            throw new RuntimeException(e);
        }

        int tryPass = 0;
        String name = sc.next();


        BufferedReader bfr2 = new BufferedReader(new FileReader("users.txt"));
        String user2 = bfr.readLine();
        String[] users2 = user.split("-");

      //  int pass = sc.nextInt();
        for(int i=0; i<users.length; i++) {

            if(users[i].split("-")[0].equals(name) && users2[3].equals("false")){
                System.out.println("Şifrəni Daxil Edin");



                boolean s = true;
                while (s){
                    String pass = sc.next();


                    if(users[i].split("-")[1].equals(pass)){
                        System.out.println("Balans: "+users[i].split("-")[2]+" Azn\n Məbləği daxil edin");

                        int money1 = sc.nextInt();
                        int money = money1;
                        if(money>Integer.parseInt(users[i].split("-")[2])){
                            System.out.println("Balansinizda Kifayet Qeder Mebleg Yoxdur!");
                        }else if(money > totalCash) {
                            System.out.println("Əskinaz Yoxdu!");
                        }else {
                            Moneys moneys = new Moneys();
                            int[] arr = {100, 50, 20, 10, 5,1};
                            for(int y=0; y<arr.length; y++){
                                if(money%arr[y]!=money){
                                    int qtye = money/arr[y];
                                    if(qtye < map.get(arr[y]) && map.get(arr[y])>0){
                                        money-=qtye*arr[y];
                                        System.out.print(" Nominal: "+arr[y]+" Say: "+qtye+", ");



                                        for(int r=0; r< map.size(); r++){
//
                                            moneys.updateMoney(String.valueOf(arr[y]), String.valueOf(map.get(arr[y]) - qtye));

                                            break;
                                        }
                                    }else{
                                        System.out.println("Eskisaz azdir");
                                    }







                                }


                            }
                            moneys.updateUserBalance(String.valueOf(Integer.parseInt(users[i].split("-")[2]) -  money1));



                        }
                        s=false;

                    }else{
                       tryPass++;
                        System.out.println("Yanlış Şifrə: Cəhd Sayı "+tryPass);
                        if(tryPass == 3){
                            Moneys.updateUserBlock();
                            System.out.println("Istifadeci Bloklandi!");
                            s=false;
                        }

                    }
                }
                break;

            }else if(!users[i].split("-")[0].equals(name)){
                System.out.println("Bele Istifadeci Yoxdur!");
                break;
            }else{
                System.out.println("Istifadeci Bloklanib!");
                break;
            }
        }




    }
}