package amdocs;


public class Util {
    private static int cnt=0;
    public static int getCountOfSubArrays(int arr[], int k){
        //  {10, 2, -2, -20, 10}
        int sum=0; int i=0;
       for (int j=i;i<arr.length && j<arr.length;j++){
           sum+=arr[j];
           if (sum==k){
               cnt++;
               sum=0; i++; j=i-1;
           }
           if(arr.length-j==1 && sum!=k){
               sum=0; i++; j=i-1;
           }
           
       }
        return cnt;
    }

    public static void main(String[] args) {
        int arr[]={9, 4, 20, 3, 10, 5};//{10, 2, -2, -20, 10}; -10
        int i=getCountOfSubArrays(arr,33);
        System.out.println("finally count is "+i);
    }
}
