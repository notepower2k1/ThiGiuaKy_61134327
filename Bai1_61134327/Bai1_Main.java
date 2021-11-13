package Bai1_61134327;

import java.util.Scanner;

public class Bai1_Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// ax + b;
		double a,b;
		try {
			
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Nhập số 2 số: ");
		System.out.print("Nhập số a: ");
		a = sc.nextDouble();
		System.out.print("Nhập số b: ");
		b = sc.nextDouble();
		if(a ==0) {
			
			if(b == 0)
			{
				System.out.println("Phương trình có vô số nghiệm");
			}
			else {
				System.out.println("Phương trình vô nghiệm");
			}
			
		}
		else {
			System.out.println("Phương trình có nghiệm duy nhất là: " + (-b/a) );
		}
		}
		catch(Exception ex) {
			System.out.println("Kiểu dữ liệu a , b không hợp lệ");
		}
	}

}
