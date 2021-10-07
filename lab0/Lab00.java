import java.lang.Math.*;

public class Lab00 
{
	public static void main(String[] args)
	{
		Liczby num = new Liczby(10, 9);
		System.out.println("tablica: ");
		for(int i = 0; i < 10; i++)
			System.out.println(num.tab[i]);
		System.out.println("srednia: ");
		System.out.println(num.Srednia());
		System.out.println("maks: ");
		System.out.println(num.Maks());
		System.out.println("min: ");
		System.out.println(num.Min());	
	}
}

class Liczby
{
	private int n;
	private int k;
	public double[] tab;

	public Liczby(int n, int k)
	{
		this.n = n;
		this.k = k;
		this.tab = new double[n];
		for(int i = 0; i < n; i++)
		{
			double sum = 0.0;
			for(int j = 0; j < k; j++)
			{
				sum = sum + Math.random();
			}
			this.tab[i] = sum;
		}
	}
	
	public double Srednia()
	{
		double sum = 0.0;
		for(int i = 0; i < this.n; i++)
		{
			sum = sum + this.tab[i];
		}
		return sum / this.n;
	}
	
	public double Maks()
	{
		double max = 0.0;
		for(int i = 0; i < this.n; i++)
			if(max < this.tab[i])
				max = this.tab[i];
		return max;	
	}

	public double Min()
	{
		double min = 9999.0;
		for(int i = 0; i < this.n; i++)
			if(min > this.tab[i])
				min = this.tab[i];
		return min;
	}
}
