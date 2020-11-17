package com.company;
import java.lang.reflect.Array;
import java.util.*;

class Vector
{
    public static double[] Vector_makyr()
    {
        double[] Vect=new double[3];

        Random rnd=new Random();
        for(int i=0; i<3; i++)
        {
            Vect[i]=rnd.nextInt(20);
        }

        return Vect;
    }
}

class Vector_meth
{
    public static double[][] VecMaker(int num)
    {
        Vector vector=new Vector();
        double[][] cont=new double[num][3];
        for (int i=0; i<num; i++)
        {
            cont[i]=vector.Vector_makyr();
        }
        return cont;
    }

    private static double[] vector1;
    private static double[] vector2;
    private static double[] Rez;
    private static double[] rez;

    public Vector_meth(double[] vector1, double[] vector2)//, double[] Rez)
    {
        this.vector1=vector1;
        this.vector2=vector2;

        this.Rez=new double[3];
        this.rez=new double[2];
    }

    public static double[] Len_calc()
    {

        rez[0]=Math.sqrt(Math.pow(vector1[0],2)+Math.pow(vector1[1],2)+Math.pow(vector1[2],2));
        rez[1]=Math.sqrt(Math.pow(vector2[0],2)+Math.pow(vector2[1],2)+Math.pow(vector2[2],2));
        return rez;
    }

    public static double[] ScalMnoj()
    {
        rez[0]=0;
        rez[1]=-1;


        for(int i=0; i<3; i++)
        {


            rez[0]+=vector1[i]*vector2[i];
        }

        return rez;
    }
    public static double[] VECxVEC()
    {
        Rez[0]=vector1[1]*vector2[2]-vector1[2]*vector2[1];
        Rez[1]=vector1[2]*vector2[0]-vector1[0]*vector2[2];
        Rez[2]=vector1[0]*vector2[1]-vector1[1]*vector2[0];
        return Rez;
    }

    public static double[] VECvVEC()
    {
        rez[0]= Math.acos((vector1[0]*vector2[0]+vector1[1]*vector2[1]+vector1[2]*vector2[2])/(Len_calc()[0]*Len_calc()[1]));
        return rez;
    }

    public static double[] SumVEC()
    {
        for (int i=0;i<3;i++)
        {
            Rez[i]=vector1[i]+vector2[i];
        }
        return Rez;
    }

    public static double[] SubVEC()
    {
        for (int i=0;i<3;i++)
        {
            Rez[i]=vector1[i]-vector2[i];
        }
        return Rez;
    }
}

public class Main2
{
    public static void main(String[] args)
    {
        Vector vec=new Vector();

        double[] vector1=vec.Vector_makyr();
        double[] vector2=vec.Vector_makyr();
        Vector_meth meth=new Vector_meth(vector1,vector2);


        System.out.println("Вектор 1: ");
        output(vector1,0);
        System.out.println("Вектор 2: ");
        output(vector2,0);
        System.out.println("Длина векторов: ");
        output(meth.Len_calc(),0);
        System.out.println("Скалярное произведение: ");
        output(meth.ScalMnoj(),1);
        System.out.println("Векторное произведение: ");
        output(meth.VECxVEC(),0);
        System.out.println("Угол между векторами: ");
        output(meth.VECvVEC(),1);
        System.out.println("Сумма векторов: ");
        output(meth.SumVEC(),0);
        System.out.println("Разность векторов: ");
        output(meth.SubVEC(),0);
        System.out.println("Введите количество нужных вам векторов: ");

        Scanner sc=new Scanner(System.in);
        int a=0;
        int m=0;
        while (a==0)
        {
            m=sc.nextInt();
            if(m>0)
            {
                a=1;
            }
            else
            {
                System.out.println("Число должно быть больше нуля");
            }
        }

        double[][] cont=meth.VecMaker(m);
        for (int i=0; i<m; i++)
        {
            for (int j=0; j<3; j++)
            {
                System.out.print(cont[i][j]+" ");
            }
            System.out.println();
        }
    }
    public static void output(double[] vector,int ch)
    {
        for(int i=0; i<vector.length-ch; i++)
        {
            System.out.print(vector[i]+" ");
        }
        System.out.println();

    }
}
