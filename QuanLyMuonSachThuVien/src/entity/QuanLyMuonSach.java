package entity;

public class QuanLyMuonSach {

	 private BanDoc banDoc;
	 private ChiTietMuonSach[] chiTietMuonSachh;
	public BanDoc getBanDoc() {
		return banDoc;
	}
	public void setBanDoc(BanDoc banDoc) {
		this.banDoc = banDoc;
	}
	public ChiTietMuonSach[] getChiTietMuonSachh() {
		return chiTietMuonSachh;
	}
	public void setChiTietMuonSachh(ChiTietMuonSach[] chiTietMuonSachh) {
		this.chiTietMuonSachh = chiTietMuonSachh;
	}
	 
	
	public int tongSLSach() {
		int n = chiTietMuonSachh.length;
		int sum = 0;
		for (int i = 0; i < n; i++) {
			if (this.chiTietMuonSachh[i] != null) {
				sum += this.chiTietMuonSachh[i].getSoLuong();
			}
		}

		return sum;

	}
	 
}
