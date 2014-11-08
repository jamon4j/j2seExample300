package j2seExample300.Chapter8StringAndWrapper;

import java.text.*;
import java.util.Scanner;

/*
 * �����ҽ��ת��Ϊ��д��ʽ
 */
public class ConvertMoney {
	
	private static final String[] STR_NUMBER = {"��","Ҽ","��","��","��","��","½"
												,"��","��","��"};
	private static final String[] STR_UNIT = {"","ʰ","��","Ǫ","��","ʰ","��"
		,"Ǫ","��","ʰ","��","Ǫ"};
	private static final String[] STR_UNIT2 = {"��","��","��"};
	public static void main(String[] args) {
		System.out.println("������һ����");
		Scanner s = new Scanner(System.in);
		String money = convert(s.nextDouble());
		System.out.println("ת����"+money);
	}
	
	public static String convert(double money)
	{
		String num;
		DecimalFormat df = new DecimalFormat("#0.###");//�ƶ����ָ�ʽ	
		String strNum = df.format(money);
		System.out.println("��ʽ�������"+strNum);
		if(strNum.indexOf(".")!=-1) 
		{
			num = strNum.substring(0,strNum.indexOf("."));
			if(num.length()>12)
			{
				System.out.println("����̫�󣬲������ת����");
				return "";
			}
		}else
		{
			if(strNum.length()>12)
			{
				System.out.println("����̫�󣬲������ת����");
				return "";
			}
		}
			
		String point = "";
		if(strNum.indexOf(".")!=-1){
			point = "Ԫ";
		}else{
			point = "Ԫ��";
		}
		String result = getInteger(strNum) + point + getDecimal(strNum);//�ֱ������ֵ�������С������
		if(result.startsWith("Ԫ")){	// �ж����ַ����Ƿ���"Ԫ"��ͷ
			result = result.substring(1,result.length());
		}
		return result;
	}
	
	/*
	 * ��ȡ��������
	 * @param num ת��ǰ���ֽ��
	 * @return num ת�����д���
	 */
	public static String getInteger(String num)
	{
		if(num.indexOf(".")!=-1)
		{
			num = num.substring(0,num.indexOf("."));
		}
		
		num = new StringBuffer(num).reverse().toString();//ʹ��StringBuffer��reverse����
		StringBuffer temp = new StringBuffer();
		for(int i=0;i<num.length();i++)
		{
			temp.append(STR_UNIT[i]);
			temp.append(STR_NUMBER[num.charAt(i)-48]);
		}
		num = temp.reverse().toString();
		num = numReplace(num,"��ʰ","��");
		num = numReplace(num,"���","��");
		num = numReplace(num,"��Ǫ","��");
		num = numReplace(num,"����","��");
		num = numReplace(num,"����","��");
		num = numReplace(num,"����","��");
		num = numReplace(num,"����","��");
		if(num.lastIndexOf("��")==num.length()-1){
			num = num.substring(0,num.length()-1);
		}
		return num;
	}
	
	/*
	 * ��ȡС������
	 * @param num ת��ǰ���ֽ��
	 * @return ת�����д���
	 */
	public static String getDecimal(String num)
	{
		if(num.indexOf(".")==-1)
		{
			return "";
		}
		num = num.substring(num.indexOf(".")+1);
		num = new StringBuffer(num).reverse().toString();//ʹ��StringBuffer��reverse����
		StringBuffer temp = new StringBuffer();
		for(int i=0;i<num.length();i++)
		{
			temp.append(STR_UNIT2[i]);
			temp.append(STR_NUMBER[num.charAt(i)-48]);
		}
		num = temp.reverse().toString();
		num = numReplace(num,"���","��");
		num = numReplace(num,"���","��");
		num = numReplace(num,"����","��");
		num = numReplace(num,"����","��");
		if(num.lastIndexOf("��")==num.length()-1){
			num = num.substring(0,num.length()-1);
		}
		return num;
	}
	
	/*
	 * �滻�ַ���������
	 * @param num �ַ���
	 * @param oldStr ���滻������ 
	 * @param newStr ������
	 * @return �滻����ַ���
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
