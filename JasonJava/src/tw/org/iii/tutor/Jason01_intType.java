package tw.org.iii.tutor;

public class Jason01_intType {

	public static void main(String[] args) {
		//整數的型別
		// byte 2^8 => -128 ~ 127, 
		// short 2^16 => 65536 => -32768 ~ 32767, 
		// int 2^32 => 約42億(10位數)(4GB), long 2^64
		byte var1;
		byte var2, var3; //一次宣告兩個變數
		byte var4 = 123; //宣告同時給值
		// 變數曾經給值及完成初始化
		System.out.println(var4);
		
		// 運算結果型態為int
		int var5 = var4 + 1;
		short var6 = 321, var7 = 123;
		int var8 = var6 + var7;
		//--------------------------------------------
		// [a-zA-Z$_][a-zA-Z0-9$_]*
		byte $_$ = 100;
		System.out.println($_$);
		int 變數1 = 123 ;
		System.out.println(變數1);
	}

}
