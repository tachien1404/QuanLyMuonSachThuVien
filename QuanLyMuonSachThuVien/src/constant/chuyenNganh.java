package constant;

public enum chuyenNganh {
KHTN("khoa học tự nhiên"),
VH_NT("văn học nghệ thuật"),
ĐTVT("điện tử viễn thông"),
CNTT("công nghệ thông tin");
	
	public final String value;
	private chuyenNganh(String value) {
	this.value = value;
}
}
