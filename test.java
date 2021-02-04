public class test {

	public static void main(String[] args) {
		String[][] str = new String[4][2];
		str[0][1] = "0";
		str[0] = args[0].split("\\.");
		str[1][0] = args[1];
		str[2][1] = "0";
		str[2] = args[2].split("\\.");
		int le1I = str[0][0].length();
		int le1F = 0;
		int le2I = str[2][0].length();
		int le2F = 0;
		String m = "";
		
		if(args[0].contains(".")) {
			le1F = str[0][1].length();
		}
		if(args[2].contains(".")) {
			le1F = str[2][1].length();
		}
		//소수점 자리 구하기
		if (le1I > le2I) {
			for (int i = 0; i < le1I - le2I; i++) {
				m += "0";
			}
			str[2][0] = m + str[2][0];
		} else if (le2I > le1I) {
			for (int i = 0; i < le2I - le1I; i++) {
				m += "0";
			}
			str[0][0] = m + str[0][0];
		}
		le1I = str[0][0].length();
		le2I = str[2][0].length();
		//정수 자릿수 맞추기
		if (le1F > le2F) {
			for (int i = 0; i < le1F - le2F; i++) {
				m += "0";
			}
			str[2][0] = m + str[2][0];
		} else if (le2F > le1F) {
			for (int i = 0; i < le2F - le1F; i++) {
				m += "0";
			}
			str[0][0] = m + str[0][0];
		}
		//le1F = str[0][1].length();
		//le2F = str[2][1].length();
		//소수점 자릿수 맞추기
		if (str[1][0].equals("add")) {
			str[3][0] = Integer.toString(Character.getNumericValue(str[0][0].charAt(0)) + Character.getNumericValue(str[2][0].charAt(0)));
			for(int i=1; i<str[0][0].length();i++){
				m = Integer.toString(Character.getNumericValue(str[0][0].charAt(i)) + Character.getNumericValue(str[2][0].charAt(i)));
				if( m.length() == 2) {
					int j = i;
					if((Character.getNumericValue(str[3][0].charAt(i-1)) + 1) == 10) {
						while((Character.getNumericValue(str[3][0].charAt(j-1)) + 1) == 10){
							char n = Integer.toString(Character.getNumericValue(str[3][0].charAt(j-1)) + 1).charAt(1);
							String n2 = str[3][0].substring(j,str[3][0].length());
							str[3][0] = str[3][0].substring(0,j-1);
							str[3][0] = str[3][0] + n2 + n;
							//str[3][0] = str[3][0].replace(str[3][0].charAt(j-1),Integer.toString(Character.getNumericValue(str[3][0].charAt(j-1)) + 1).charAt(1));
							if(j == 0) {
								str[3][0] = "1" + str[3][0];
								break;
							}
							j--;
						}
						char n = Integer.toString(Character.getNumericValue(str[3][0].charAt(j-1)) + 1).charAt(0);
						String n2 = str[3][0].substring(j,str[3][0].length());
						str[3][0] = str[3][0].substring(0,j-1);
						str[3][0] = str[3][0] + n + n2;;
						j--;
						//str[3][0] = str[3][0].replace(str[3][0].charAt(j-1),Integer.toString(Character.getNumericValue(str[3][0].charAt(j-1)) + 1).charAt(0));
					}/*else {
					char n = Integer.toString(Character.getNumericValue(str[3][0].charAt(j-1))).charAt(0);
					str[3][0] = str[3][0].substring(0,j);
					str[3][0] = str[3][0] + n;
					//str[3][0] = str[3][0].replace(str[3][0].charAt(i-1),Integer.toString(Character.getNumericValue(str[3][0].charAt(i-1)) + 1).charAt(0));
					}*/
				}
				if((m.length() == 2) && (str[3][0].length() == i+1)) {
					str[3][0] = str[3][0] + m.charAt(1);
				}else if(str[3][0].length() == i) {
					str[3][0] = str[3][0] + m.charAt(0);	
				}
				if((m.length() == 2) && str[3][0].length() == i+1){
					str[3][0] = str[3][0] + m.charAt(0);
				}else if(str[3][0].length() == i){
					str[3][0] = str[3][0] + m.charAt(0);
				}
			}
			System.out.println(str[3][0]);
			//정수계산 안됨
			
			
			
			
			if(args[0].contains("."))
				str[3][1] = Integer.toString(Character.getNumericValue(str[0][1].charAt(0)) + Character.getNumericValue(str[2][1].charAt(0)));
				for(int i=1; i<str[0][1].length();i++){
					m = Integer.toString(Character.getNumericValue(str[0][1].charAt(i)) + Character.getNumericValue(str[2][1].charAt(i)));
					if( m.length() == 2) {
						int j = i;
						if((Character.getNumericValue(str[3][1].charAt(i-1)) + 1) == 10) {
							while((Character.getNumericValue(str[3][1].charAt(j-1)) + 1) == 10){
								char n = Integer.toString(Character.getNumericValue(str[3][1].charAt(j-1)) + 1).charAt(1);
								String n2 = str[3][1].substring(j,str[3][1].length());
								str[3][1] = str[3][1].substring(0,j-1);
								str[3][1] = str[3][1] + n2 + n;
								//str[3][0] = str[3][0].replace(str[3][0].charAt(j-1),Integer.toString(Character.getNumericValue(str[3][0].charAt(j-1)) + 1).charAt(1));
								if(j == 0) {
									str[3][1] = "1" + str[3][1];
									break;
								}
								j--;
							}
							char n = Integer.toString(Character.getNumericValue(str[3][1].charAt(j-1)) + 1).charAt(0);
							String n2 = str[3][1].substring(j,str[3][1].length());
							str[3][1] = str[3][1].substring(0,j-1);
							str[3][1] = str[3][1] + n + n2;;
							j--;
						//	str[3][0] = str[3][0].replace(str[3][0].charAt(j-1),Integer.toString(Character.getNumericValue(str[3][0].charAt(j-1)) + 1).charAt(0));
						}else {
							char n = Integer.toString(Character.getNumericValue(str[3][1].charAt(i-1)) + 1).charAt(0);
							str[3][1] = str[3][1].substring(0,i-1);
							str[3][1] = str[3][1] + n;
					//	str[3][0] = str[3][0].replace(str[3][0].charAt(i-1),Integer.toString(Character.getNumericValue(str[3][0].charAt(i-1)) + 1).charAt(0));
						}
					}
					if(m.length() == 2) {
						str[3][1] = str[3][1] + m.charAt(1);
					}else {
						str[3][1] = str[3][1] + m.charAt(0);
					}
				}
			
				
				
		}
		System.out.println(str[3][0]+ "." + str[3][1]);
	}
}