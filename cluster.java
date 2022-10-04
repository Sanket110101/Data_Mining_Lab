import java.util.*;

public class cluster {
    public static double findDistance(double[] p1,double[] p2,int n){
        double[] ans=new double[n];
        double dist=0.0;
        for(int j=0;j<3;j++){
            dist=dist+(p1[j]-p2[j])*(p1[j]-p2[j]);
        }
        dist=Math.sqrt(dist);
        dist=(double)Math.round(dist*1000)/(double)1000;
        return dist;
    }
    public static void main(String[] args){
        System.out.print("Enter number of points:");
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        double[][] que=new double[n][3];
        for(int i=0;i<n;i++){
            System.out.println("Give Coordinates for"+(i+1));
            for(int j=0;j<3;j++){
                switch(j){
                    case 0:System.out.print(" x :");
                        break;
                    case 1:System.out.print(" y :");
                        break;
                    case 2:System.out.print(" z :");
                        break;
                }
                que[i][j]=sc.nextDouble();
            }
        }
        
        double[] c=new double[3];
        for(int i=0;i<n;i++){
            c[0]+=que[i][0];
            c[1]+=que[i][1];
            c[2]+=que[i][2];
        }
        c[0]/=n;
        c[1]/=n;
        c[2]/=n;
        c[0]=(double)Math.round(c[0]*100)/(double)100;
        c[1]=(double)Math.round(c[1]*100)/(double)100;
        c[2]=(double)Math.round(c[2]*100)/(double)100;
        System.out.println("Center's Cooidinates : ("+c[0]+","+c[1]+","+c[2]+")");
        
        double[][] ans=new double[n][n];
        for(int i=0;i<n;i++){
            double dist=0.0;
            for(int j=i+1;j<n;j++){
                ans[i][j]=findDistance(que[i],que[j],n);
            }
        }
        for(double[] d1:ans){
            for(double d2:d1){
                System.out.print(d2+"     ");
            }
            System.out.println();
        }
        System.out.println("Distance between point and Center :");
        for(int i=0;i<n;i++){
            System.out.print("Point "+ (i+1) + " ");
        }
        System.out.println();
        for(double[] d:ans){
            System.out.print(findDistance(c, d, n)+"  ");
        }
    }
}