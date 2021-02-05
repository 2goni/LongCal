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
		int s = 0;
		if(str[1][0].equals("sub") && (args[0].contains(".") || args[2].contains("."))) {
			str[3][1] = "";
			int l = le1F-1;
			char[] floatnum1 = Integer.toString(Math.max(Integer.parseInt(str[0][1]),Integer.parseInt(str[2][1]))).toCharArray();
			char[] floatnum2 = Integer.toString(Math.min(Integer.parseInt(str[0][1]),Integer.parseInt(str[2][1]))).toCharArray();
			for(int j=0; j<le1F; j++) {
				m = Integer.toString(Character.getNumericValue(floatnum1[l]) - Character.getNumericValue(floatnum2[l])+s);
				if(m.length() > 1) {
					str[3][1] = m.charAt(0) + str[3][1];
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
			char[] intnum1 = Integer.toString(Math.max(Integer.parseInt(str[0][0]),Integer.parseInt(str[2][0]))).toCharArray();
			char[] intnum2 = Integer.toString(Math.min(Integer.parseInt(str[0][0]),Integer.parseInt(str[2][0]))).toCharArray();
			for(int j=0; j<le1I; j++) {
				m = Integer.toString(Character.getNumericValue(intnum1[l]) - Character.getNumericValue(intnum2[l])+s);
				if(m.length() > 1) {
					str[3][0] = m.charAt(0) + str[3][0];
					l--;
					s = -1;
				}else {
					str[3][0] = m + str[3][0];
					l--;
					s = 0;
				}
			}
			int j=0;
			while(true) {
				if(j==le1I || intnum1[j] > intnum2[j]) {
					break;
				}else if(intnum1[j] < intnum2[j]){
					str[3][0] = "-" + str[3][0];
					break;
				}
				j++;
			}
		}
	
		if(str[3][1] == null) {
			str[3][1] = "";
		}
		if(str[1][1] == null) {
			str[1][1] = "";
		}
		int dash = Math.max(args[0].length(), args[2].length())+3; 
		System.out.println("  " + str[0][0] + str[1][1] + str[0][1]);
		System.out.println("- " + str[2][0] + str[1][1] + str[2][1]);
		for(int j=0; j<dash; j++) {
			System.out.print("-");
		}
		System.out.println();
		if(str[0].length < str[1].length) {
			System.out.print(" ");
		}else {
			System.out.print("  ");
		}
		System.out.println(str[3][0]+str[1][1]+str[3][1]);
	}
	
	// s -1
}