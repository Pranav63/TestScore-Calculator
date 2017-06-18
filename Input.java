import java.io.*;
import java.util.*;

class SimpleRead
{
  public static final int n=3;
  public static final int q=3;
  public static String s[][]=new String[q][n];
  public static String c[]=new String[q];
  public static Double marks[][]=new Double[q][n];
   public static void main(String args[]){
     input();
     fillc();
     calculate_marks();
     print_marks();
}

public static void print_marks()
{
  for(int i=0;i<q;++i)
    {
      for(int j=0;j<n;++j)
        {
          System.out.printf("%.2f\t",marks[i][j]);
        }
        System.out.println();
    }
}
public static void calculate_marks()
 {
  for(int i=0;i<q;++i)
  { String k=c[i];
    for (int j=0;j<n ;++j ) {
      if(k.length()>1)
      marks[i][j]=cal_marks_multiple(s[i][j],k);
      else
       {
         if(s[i][j].compareTo(k)==0)
         {marks[i][j]=1.0;System.out.println(marks[i][j]);}
         else
         marks[i][j]=0.0;
       }
    }
  }
 }

 public static double cal_marks_multiple(String a,String b)
  { int l=b.length();
    float mm=(float)1.0/(l/2+1);
    int  p=0;
    double marks1=0;
    for(int i=0;i<a.length();++i)
     {  int j;
       if(a.charAt(i)==',')
       continue;
       for ( j=0;j<b.length() ;++j ) {
         if(a.charAt(i)==b.charAt(j) )
             {marks1+=mm;++p;break;}
       }
       if(j==l)
       marks1-=mm;
     }
     if(p<l)
     marks1-=((l/2+1)-p)*mm;

     if(marks1<0)
     marks1=0;
     return marks1;
  }

public static void fillc()
 {
  File file1= new File("ans.txt");
  try{
  Scanner bb=new Scanner(file1);
   for (int i=0;i<q ;++i ) {
    c[i]=bb.nextLine();
   }
  }
 catch (FileNotFoundException e) {
     e.printStackTrace();
  }
}
public static void input()
{
   File file = new File("Student_ans.txt");
   try{
  Scanner aa=new Scanner(file);

   for (int i=0;i<q ;++i ) {
     String k=aa.nextLine();
     Scanner a=new Scanner(k);
     int j=0;
     while(a.hasNext())
     {
      s[i][j++]=a.next();
     }
   }

  }
  catch (FileNotFoundException e) {
    e.printStackTrace();
 }
 }
}
