package model;

import java.util.ArrayList;

public class Province {
	private int ProvinceId;
	private String ProvinceName;

	public Province(int provinceId, String provinceName) {
		ProvinceId = provinceId;
		ProvinceName = provinceName;
	}

	public int getProvinceId() {
		return ProvinceId;
	}

	public void setProvinceId(int provinceId) {
		ProvinceId = provinceId;
	}

	public String getProvinceName() {
		return ProvinceName;
	}

	public void setProvinceName(String provinceName) {
		ProvinceName = provinceName;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ProvinceId;
		result = prime * result + ((ProvinceName == null) ? 0 : ProvinceName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Province other = (Province) obj;
		if (ProvinceId != other.ProvinceId)
			return false;
		if (ProvinceName == null) {
			if (other.ProvinceName != null)
				return false;
		} else if (!ProvinceName.equals(other.ProvinceName))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Province [ProvinceId=" + ProvinceId + ", ProvinceName=" + ProvinceName + ", getProvinceId()="
				+ getProvinceId() + ", getProvinceName()=" + getProvinceName() + ", hashCode()=" + hashCode()
				+ ", getClass()=" + getClass() + ", toString()=" + super.toString() + "]";
	}

	public static ArrayList<Province> getListProvince() {
		String[] arr_province = { "-Select Province-", "An Giang", "Bà Rịa-Vũng Tàu", "Bắc Giang", "Bắc Kạn",
				"Bạc Liêu", "Bắc Ninh", "Bến Tre", "Bình Định", "Bình Dương", "Bình Phước", "Bình Thuận", "Cà Mau",
				"Cần Thơ", "Cao Bằng", "Đà Nẵng", "Đắk Lắk", "Đắk Nông", "Điện Biên", "Đồng Nai", "Đồng Tháp",
				"Gia Lai", "Hà Giang", "Hà Nam", "Hà Nội", "Hà Tĩnh", "Hải Dương", "Hải Phòng", "Hậu Giang",
				"TP. Hồ Chí Minh", "Hòa Bình", "Hưng Yên", "Khánh Hòa", "Kiên Giang", "Kon Tum", "Lai Châu", "Lâm Đồng",
				"Lạng Sơn", "Lào Cai", "Long An", "Nam Định", "Nghệ An", "Ninh Bình", "Ninh Thuận", "Phú Thọ",
				"Phú Yên", "Quảng Bình", "Quảng Nam", "Quảng Ngãi", "Quảng Ninh", "Quảng Trị", "Sóc Trăng", "Sơn La",
				"Tây Ninh", "Thái Bình", "Thái Nguyên", "Thanh Hóa", "Thừa Thiên - Huế", "Tiền Giang", "Trà Vinh",
				"Tuyên Quang", "Vĩnh Long", "Vĩnh Phúc", "Yên Bái", };

		ArrayList<Province> listProvince = new ArrayList<Province>();
		for (int i = 0; i < arr_province.length; i++) {
			Province p = new Province(i, arr_province[i]);
			listProvince.add(p);
		}
		return listProvince;
	}

	public static Province getProvinceById(int idProvince) {
		return Province.getListProvince().get(idProvince);
	}

	public static Province getProvinceByName(String provinceName) {
		ArrayList<Province> listProvince = Province.getListProvince();
		for (Province province : listProvince) {
			if (province.getProvinceName().equals(provinceName)) {
				return province;
			}
		}
		return null;
	}

}
