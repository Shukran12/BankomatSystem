public class test {
    public static void main(String[] args) {
        int[] arr = {100, 50, 20, 10, 5,1};
        int a=177;

        for (int i=0; i<arr.length; i++){
            if(a%arr[i] !=a){

                int say = a/arr[i];
                a-= say*arr[i];
                System.out.println("Mebleg:"+arr[i]+ " Say: "+say);
            }
        }


    }
}
