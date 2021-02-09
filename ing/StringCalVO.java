package test;

public class StringCalVO {
	private String inum1;
	private String inum2;
	private String fnum1;
	private String fnum2;
	private String result;
	private boolean hasdot1;
	private boolean hasdot2;

	
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
	public String getFnum1() {
		return fnum1;
	}
	public void setFnum1(String args) {
		if(hasdot1) {
			fnum1 = args.substring(args.indexOf(".") + 1 , args.length());
		}else{
			fnum1 = "";
		}
	}
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
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}

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
		}
		
	}
	
	public void zeroset() {
		if(inum1.length() > inum2.length()) {
			for (int i = 0; i < inum1.length() - inum2.length(); i++) {
			inum2 = "0" + inum2;
			}
		} else if (inum2.length() > inum1.length()) {
			for (int i = 0; i < inum2.length() - inum1.length(); i++) {
			inum1 = "0" + inum1;
			}
		}
		if(hasdot1 == true || hasdot2 == true) {
			if(fnum1.length() > fnum2.length()) {
				for (int i = 0; i < fnum1.length() - fnum2.length(); i++) {
				fnum2 = fnum2 + "0";
				}
			} else if (fnum2.length() > fnum1.length()) {
				for (int i = 0; i < fnum2.length() - fnum1.length(); i++) {
				fnum1 = fnum1 + "0";
				}
			}
		}
	}
}