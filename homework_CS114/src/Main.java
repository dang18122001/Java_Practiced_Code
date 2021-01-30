import java.util.*;
public class Main
{
    public static void main(String[] args)//main function
    {
        Scanner sc = new Scanner(System.in);
        String s=sc.next();//taking the input of the given number as string
        Long sum=sc.nextLong();//taking the input of the number to be checked
        int n= s.length();//length of the given number
        int m=n-1;
        int maxx= 1;//this will store 2^(n-1);
        while(m!=0)//to calculate 2^(n-1)
        {
            maxx*=2;
            m--;
        }
        m=n-1;
        int ans=-1;//initially, will be set to 1 if the sum is found by placing the operator
        for(int mask=0;mask<maxx;mask++)//iterating the mask
        {
            Long tsum=0L;
            Long current=0L;
            current+=(s.charAt(0)-'0');
            for(int i=0;i<m;i++)//calculating the sum for this mask
            {
                Long calc=mask&(1L<<i);
                if(calc!=0L)//ith bit is set, operator is placed at ith position
                {
//bitset
                    tsum+=current;
                    current=0L;
                    current+=(s.charAt(i+1)-'0');
                }
                else //ith bit is off
                {
                    current=current*10;
                    current+=s.charAt(i+1)-'0';
                }
            }
            tsum+=current;
            if(tsum-sum==0)//if tsum and sum are equal
            {
                ans=1;//sum is found
            }
        }
        System.out.println(ans);//printing the answer
    }
}