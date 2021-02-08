package test;

import java.util.StringTokenizer;

public class StringCal_sub {

	public static void main(String[] args) {
		String[][] str = new String[4][2];
		StringTokenizer st = new StringTokenizer(args[0],".");
		int i=0;
		while(st.hasMoreTokens()) {
			str[0][i] = st.nextToken();
			i++;
		}
		i=0;
		str[1][0] = args[1];
		st = new StringTokenizer(args[2],".");
		while(st.hasMoreTokens()) {
			str[2][i] = st.nextToken();
			i++;
		}
		i=0;	

		int le1I = str[0][0].length();
		int le1F =0;
		int le2I = str[2][0].length();
		int le2F =0;
		String m = "";
		
		if(args[0].contains(".")) {
			le1F = str[0][1].length();
		}
		if(args[2].contains(".")) {
			le2F = str[2][1].length();
		}
		
		if (le1I > le2I) {
			for (int j = 0; j < le1I - le2I; j++) {
				m += "0";
			}
			str[2][0] = m + str[2][0];
		} else if (le2I > le1I) {
			for (int j = 0; j < le2I - le1I; j++) {
				m += "0";
			}
			str[0][0] = m + str[0][0];
		}
		le1I = str[0][0].length();
		le2I = str[2][0].length();
		m = "";
		
		if(args[0].contains(".") || args[2].contains(".")) {
			str[1][1] =".";
			if(str[0][1] == null) {
				str[0][1] = "";
			}
			if(str[2][1] == null) {
				str[2][1] = "";
			}
				
			if (le1F > le2F) {
				for (int j = 0; j < le1F - le2F; j++) {
					m += "0";
				}
				str[2][1] = str[2][1] + m;
			} else if (le2F > le1F) {
				for (int j = 0; j < le2F - le1F; j++) {
					m += "0";
				}
				str[0][1] = str[0][1] + m;
			}
				le1F = str[0][1].length();
				le2F = str[2][1].length();
				m = "";
		}else {
			str[0][1] = "";
			str[2][1] = "";
		}
		//자릿수맞춤
		char[] intnum1 = str[0][0].toCharArray();
		char[] intnum2 = str[2][0].toCharArray();
		char[] fnum1 = str[0][1].toCharArray();
		char[] fnum2 = str[2][1].toCharArray();
		String maxinum = "";
		String maxfnum = "";
		String mininum = "";
		String minfnum = "";
		String p = "";
		while(true) {
			if(intnum1[i]>intnum2[i]) {
				maxinum = str[0][0];
				maxfnum = str[0][1];
				mininum = str[2][0];
				minfnum = str[2][1];
				break;
			}else if(intnum1[i]<intnum2[i]) {
				maxinum = str[2][0];
				maxfnum = str[2][1];
				mininum = str[0][0];
				minfnum = str[0][1];
				p = "-";
				break;
			}else if(i == str[0][0].length()-1){
				break;
			}
			i++;
		}
		i=0;
		while(true) {
			if(fnum1[i]>fnum2[i]) {
				maxinum = str[0][0];
				maxfnum = str[0][1];
				mininum = str[2][0];
				minfnum = str[2][1];
				break;
			}else if(fnum1[i]<fnum2[i]) {
				maxinum = str[2][0];
				maxfnum = str[2][1];
				mininum = str[0][0];
				minfnum = str[0][1];
				p = "-";
				break;
			}else if(i == str[0][0].length()-1){
				break;
			}
			i++;
		}
		i=0;
		int s = 0;

		if(str[1][0].equals("sub") && (args[0].contains(".") || args[2].contains("."))) {
			str[3][1] = "";
			int l = le1F-1;
			char[] maxfnumc = maxfnum.toCharArray();
			char[] minfnumc = minfnum.toCharArray();
			for(int j=0; j<le1F; j++) {
				m = Integer.toString(Character.getNumericValue(maxfnumc[l]) - Character.getNumericValue(minfnumc[l])+s);
				if(m.length() > 1) {
					str[3][1] = Integer.toString(Integer.parseInt(m) + 10) + str[3][1];
					l--;
					s = -1;
				}else {
					str[3][1] = m + str[3][1];
					l--;
					s = 0;
				}
			}
		}
		if(str[1][0].equals("sub")){
			str[3][0] = "";
			int l = le1I-1;
			char[] maxinumc = maxinum.toCharArray();
			char[] mininumc = mininum.toCharArray();
			for(int j=0; j<le1I; j++) {
				m = Integer.toString(Character.getNumericValue(maxinumc[l]) - Character.getNumericValue(mininumc[l])+s);
				if(m.length() > 1) {
					str[3][0] = Integer.toString(Integer.parseInt(m) + 10) + str[3][0];
					l--;
					s = -1;
				}else {
					str[3][0] = m + str[3][0];
					l--;
					s = 0;
				}
			}
		}
		int k=0;
		char[] zero = str[3][0].toCharArray();
		while(true) {
			if(zero[k] != '0' || k==le1I-1) {
				break;
			}
			if(zero[k] == '0') {
				str[3][0] = str[3][0].substring(1);
			}
			k++;
		}
		if(p.equals("-")) {
			str[3][0] = p + str[3][0];
		}
		if(str[3][1] == null) {
			str[3][1] = "";
		}
		if(str[1][1] == null) {
			str[1][1] = "";
		}
		int dash = Math.max(args[0].length(), args[2].length())*2+1; 
		System.out.println("  " + str[0][0] + str[1][1] + str[0][1]);
		System.out.println("- " + str[2][0] + str[1][1] + str[2][1]);
		for(int j=0; j<dash; j++) {
			System.out.print("-");
		}
		System.out.println();
		if(p.equals("-")) {
			System.out.print(" ");
		}else {
			System.out.print("   ");
		}
		System.out.println(str[3][0]+str[1][1]+str[3][1]);
	}
	
}