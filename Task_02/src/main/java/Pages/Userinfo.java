package Pages;

public class Userinfo {
	
	
	public Userinfo(String nameString, String currencyString) {
		super();
		this.nameString = nameString;
		this.currencyString = currencyString;
	}

	private String  nameString="Karthik";
	private String updateNameString="Manam RajKarthik";
	private String currencyString="USD - United States Dollar";
	private String currencyString2="AFN - Afghanistan Afghani";
	
	public Userinfo() {
//		super();
	}


	public Userinfo(String nameString, String currencyString, String updateNameString,String currencyString2) {
		super();
		this.nameString = nameString;
		this.currencyString = currencyString;
		this.updateNameString=updateNameString;
		this.setCurrencyString2(currencyString2);
	}

	
	public String getCurrencyString() {
		return currencyString;
	}


	public String getUpdateNameString() {
		return updateNameString;
	}


	public void setUpdateNameString(String updateNameString) {
		this.updateNameString = updateNameString;
	}


	public void setCurrencyString(String currencyString) {
		this.currencyString = currencyString;
	}


	public String getNameString() {
		return nameString;
	}

	public void setNameString(String nameString) {
		this.nameString = nameString;
	}


	public String getCurrencyString2() {
		return currencyString2;
	}


	public void setCurrencyString2(String currencyString2) {
		this.currencyString2 = currencyString2;
	}
	
	
	
}
