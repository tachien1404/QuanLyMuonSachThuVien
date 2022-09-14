package constant;

public enum loaiBanDoc {
	 SV("sinh viên"),
	 SVCH("sinh viên cao học"),
	 GV("giáo viên");
	
	public final String value;
	private loaiBanDoc(String value) {
		this.value = value;
	}
	
}