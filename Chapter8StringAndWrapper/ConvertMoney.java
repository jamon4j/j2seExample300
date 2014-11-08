package j2seExample300.Chapter8StringAndWrapper;

import java.text.*;
import java.util.Scanner;

/*
 * 将货币金额转化为大写格式
 */
public class ConvertMoney {
	
	private static final String[] STR_NUMBER = {"零","壹","贰","叄","肆","伍","陆"
												,"柒","捌","玖"};
	private static final String[] STR_UNIT = {"","拾","佰","仟","万","拾","佰"
		,"仟","亿","拾","佰","仟"};
	private static final String[] STR_UNIT2 = {"厘","分","角"};
	public static void main(String[] args) {
		System.out.println("请输入一个金额：");
		Scanner s = new Scanner(System.in);
		String money = convert(s.nextDouble());
		System.out.println("转换后："+money);
	}
	
	public static String convert(double money)
	{
		String num;
		DecimalFormat df = new DecimalFormat("#0.###");//制定数字格式	
		String strNum = df.format(money);
		System.out.println("格式化结果："+strNum);
		if(strNum.indexOf(".")!=-1) 
		{
			num = strNum.substring(0,strNum.indexOf("."));
			if(num.length()>12)
			{
				System.out.println("数字太大，不能完成转换！");
				return "";
			}
		}else
		{
			if(strNum.length()>12)
			{
				System.out.println("数字太大，不能完成转换！");
				return "";
			}
		}
			
		String point = "";
		if(strNum.indexOf(".")!=-1){
			point = "元";
		}else{
			point = "元整";
		}
		String result = getInteger(strNum) + point + getDecimal(strNum);//分别处理数字的整数和小数部分
		if(result.startsWith("元")){	// 判断是字符串是否已"元"开头
			result = result.substring(1,result.length());
		}
		return result;
	}
	
	/*
	 * 获取整数部分
	 * @param num 转化前数字金额
	 * @return num 转化后大写金额
	 */
	public static String getInteger(String num)
	{
		if(num.indexOf(".")!=-1)
		{
			num = num.substring(0,num.indexOf("."));
		}
		
		num = new StringBuffer(num).reverse().toString();//使用StringBuffer的reverse方法
		StringBuffer temp = new StringBuffer();
		for(int i=0;i<num.length();i++)
		{
			temp.append(STR_UNIT[i]);
			temp.append(STR_NUMBER[num.charAt(i)-48]);
		}
		num = temp.reverse().toString();
		num = numReplace(num,"零拾","零");
		num = numReplace(num,"零佰","零");
		num = numReplace(num,"零仟","零");
		num = numReplace(num,"零万","万");
		num = numReplace(num,"零亿","亿");
		num = numReplace(num,"零零","零");
		num = numReplace(num,"亿万","亿");
		if(num.lastIndexOf("零")==num.length()-1){
			num = num.substring(0,num.length()-1);
		}
		return num;
	}
	
	/*
	 * 获取小数部分
	 * @param num 转化前数字金额
	 * @return 转化后大写金额
	 */
	public static String getDecimal(String num)
	{
		if(num.indexOf(".")==-1)
		{
			return "";
		}
		num = num.substring(num.indexOf(".")+1);
		num = new StringBuffer(num).reverse().toString();//使用StringBuffer的reverse方法
		StringBuffer temp = new StringBuffer();
		for(int i=0;i<num.length();i++)
		{
			temp.append(STR_UNIT2[i]);
			temp.append(STR_NUMBER[num.charAt(i)-48]);
		}
		num = temp.reverse().toString();
		num = numReplace(num,"零角","零");
		num = numReplace(num,"零分","零");
		num = numReplace(num,"零厘","零");
		num = numReplace(num,"零零","零");
		if(num.lastIndexOf("零")==num.length()-1){
			num = num.substring(0,num.length()-1);
		}
		return num;
	}
	
	/*
	 * 替换字符串中内容
	 * @param num 字符串
	 * @param oldStr 被替换的内容 
	 * @param newStr 新内容
	 * @return 替换后的字符串
	 */
	public static String numReplace(String num,String oldStr,String newStr)
	{
		while(true)
		{
			if(num.indexOf(oldStr)==-1) break;
			
			num = num.replaceAll(oldStr, newStr);
		}
		return num;
	}
}
