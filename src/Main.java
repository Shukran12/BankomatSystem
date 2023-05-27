import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Map<Integer, Integer> map = new HashMap<>();
        List<Users> users = new ArrayList<>();
        users.add(new Users("Sukran", "1", 3450));
        users.add(new Users("Test", "2", 345));
        users.add(new Users("Ceyhun", "2", 345));
        System.out.println("Ad Daxil edin:");
        Scanner sc = new Scanner(System.in);
        String name = sc.next();
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

      //  int pass = sc.nextInt();
        for(int i=0; i<users.size(); i++){
            if(users.get(i).getName().equals(name)){
                System.out.println("Şifrəni Daxil Edin");

                boolean s = true;
                while (s){
                    String pass = sc.next();
                    if(users.get(i).getPass().equals(pass)){
                        System.out.println("Balans: "+users.get(i).getBalance()+" Azn\n Məbləği daxil edin");
                        int money = sc.nextInt();
                        if(money>users.get(i).getBalance()){
                            System.out.println("Balansinizda Kifayet Qeder Mebleg Yoxdur!");
                        }else if(money > totalCash) {
                            System.out.println("Əskinaz Yoxdu");
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


                        }
                        s=false;

                    }else{
                       tryPass++;
                        System.out.println("Yanlış Şifrə: Cəhd Sayı "+tryPass);
                        if(tryPass == 3){

                            System.out.println("Istifadeci Bloklandi!");
                            s=false;
                        }

                    }
                }
                break;

            }else{
                System.out.println("Bele Istifadeci Yoxdur!");
                break;
            }
        }














    }
}