package me.XxXYaJrAbXxX.Characters.DataCollect;

public enum Language {
	
	No_Permission("No_Permission", "You do not have permission to use this command!"),
	No_Race("No_Race", "This race does not exist!"),
	No_Class("No_Class", "This class does not exist!"),
	No_Magic("No_Magic", "This form of magix does not exist!"),
	;
	
	public String path;
	public String def;
	Language(String path, String def) {
        this.path = path;
        this.def = def;
    }
	 public String getDef() {
	        return this.def;
	    }
	 public String getPath() {
	        return this.path;
	    }
	 public void setDef(String def) {
	        this.def = def;
	 }
}
