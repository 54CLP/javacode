import java.util.Arrays;
public class Num2RMB{
	private String[] han={"零","壹","贰","叁","肆","伍","陆","柒","捌","玖"};
	private String[] unit={"角","分","十","百","千","万","十","百","千","亿",};
	/**
	*把一个浮点数分解成整数部分和小数部分字符串
	*@param num 需要被分解的浮点数
	* return 分解出来的整数部分和小数部分。第一个数组是整数部分，第二个数组是小数部分
	*/
	private String[] divide(double num){
		long zheng=(long)num;
		long xiao=Math.round((num-zheng)*100);
		return new String[]{zheng+"","."+String.valueOf(xiao)};
	}
	/**把数字字符串变成汉字字符串
	*@param numStr 需要被转换的数字字符串
	*@return  被转换的汉字字符串
	*/

	private String toHan(String numStr){
		String result="";
		int numLen=numStr.length();
		int t=0;
		for(int i=0;i<numLen;i++){
			if(numStr.charAt(i)=='.' && i==0) {
				t=i;
				i++;
			}else
				t=numLen-i;
			//char 变成int  ASCII-48
			int num=numStr.charAt(i)-48;
				int next=i+1;	
			if(i!=numLen-1 && (num!=0||(num==0 && han[num]=="万" )||(i==numLen-1 && numStr.charAt(0)=='.'))){
				result+=han[num]+unit[t];
			}
			else if((i!=numLen-1 && num==0 && numStr.charAt(next)-48!=0 )||(i==numLen-1 && num!=0)){
				result+=han[num];
			}

			else continue;
		}
		return result;

	}

	public static void main(String[]args){
		Num2RMB nr=new Num2RMB();
		System.out.println(nr.toHan(nr.divide(2112009.3456)[0])+nr.toHan(nr.divide(2112009.3456)[1]));
		System.out.println(Arrays.toString(nr.divide(1234.3456)));
		System.out.println(nr.toHan("2119"));

	}

}
