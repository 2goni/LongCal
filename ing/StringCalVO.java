package test;

public class StringCalVO {
	private String inum1;
	private String inum2;
	private String fnum1;
	private String fnum2;
	private boolean hasdot1;
	private boolean hasdot2;
	private boolean minus;
	private String result = "";
	
	StringCalVO(String[] args){
		this.setHasdot1(args[0]);
		this.setHasdot2(args[2]);
		this.zeroset();
	}
	
	public String getInum1() {
		return inum1;
	}
	public void setInum1(String args) {
		if(hasdot1) {
			inum1 = args.substring(0 , args.indexOf("."));
		}else {
			inum1 = args;
		}
	}
	// 숫자1 정수 담기
	public String getInum2() {
		return inum2;
	}
	public void setInum2(String args) {
		if(hasdot2) {
			inum2 = args.substring(0 , args.indexOf("."));
		}else {
			inum2 = args;
		}
	}
	// 숫자2 정수 담기
	public String getFnum1() {
		return fnum1;
	}
	public void setFnum1(String args) {
		if(hasdot1) {
			fnum1 = args.substring(args.indexOf(".") +1 , args.length());
		}else{
			fnum1 = "";
		}
	}
	// 숫자1 소수 담기
	public String getFnum2() {
		return fnum2;
	}
	public void setFnum2(String args) {
		if(hasdot2) {
			fnum2 = args.substring(args.indexOf(".") + 1 , args.length());
		}else {
			fnum2 = "";
		}
	}
	// 숫자2 소수 담기
	public String getResult() {
		return result;
	}
	public void setResult(char ch) {
		result = ch + result;
	}
	// 계산값 담기
	public void delResultI(int i) {
		result = result.substring(i);
	}
	public void delResultF(int i) {
		result = result.substring(0, i);
	}
	// 정수 소수 앞뒤 0지우기
	public boolean getHasdot1() {
		return hasdot1;
	}
	public boolean getHasdot2() {
		return hasdot2;
	}
	public void setHasdot1(String args) {
		if(args.contains(".")) {
			hasdot1 = true;
			this.setInum1(args);
			this.setFnum1(args);
		}else {
			hasdot1 = false;
			this.setInum1(args);
			this.setFnum1(args);
		}
		
	}
	
	public void setHasdot2(String args) {
		if(args.contains(".")) {
			hasdot2 = true;
			this.setInum2(args);
			this.setFnum2(args);
		}else {
			hasdot2 = false;
			this.setInum2(args);
			this.setFnum2(args);
		}
		
	}
	// 숫자1 숫자2 소수확인
	public void setminus(boolean b) {
		minus = b;
	}
	public boolean getminus() {
		return minus;
	}
	// 결과값 음수인지 확인
	public void zeroset() {
		int linum1 = inum1.length();
		int linum2 = inum2.length();
		int lfnum1 = fnum1.length();
		int lfnum2 = fnum2.length();
		if(linum1 > linum2) {
			for (int i = 0; i < linum1 - linum2; i++) {
			inum2 = "0" + inum2;
			}
		} else if (linum2 > linum1) {
			for (int i = 0; i < linum2 - linum1; i++) {
			inum1 = "0" + inum1;
			}
		}
		if(hasdot1 == true || hasdot2 == true) {
			if(lfnum1 > lfnum2) {
				for (int i = 0; i < lfnum1 - lfnum2; i++) {
				fnum2 = fnum2 + "0";
				}
			} else if (lfnum2 > lfnum1) {
				for (int i = 0; i < lfnum2 - lfnum1; i++) {
				fnum1 = fnum1 + "0";
				}
			}
			fnum1 = "." + fnum1;
			fnum2 = "." + fnum2;
		}
	}
	// 숫자1 숫자2 자릿수 맞추기
}