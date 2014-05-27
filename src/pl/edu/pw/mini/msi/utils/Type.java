package pl.edu.pw.mini.msi.utils;

public enum Type {
	BULLISH("Buy!"), 
	BEARISH("Sell!"), 
	NEUTRAL("Wait!");
	
	private String action;
	
	Type(String action){
		this.action = action;
	}
	
	public String getAction()
	{
		return this.action;
	}
}
