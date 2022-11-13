package entities;

import java.util.Objects;

public class Sale {
	
	private Integer month;
	private Integer year;
	private String seller;
	private Integer items;
	private Double total;
	
	public Sale() {
	}

	public Sale(Integer month, Integer year, String seller, Integer items, Double total) {
		this.month = month;
		this.year = year;
		this.seller = seller;
		this.items = items;
		this.total = total;
	}

	public Integer getMonth() {
		return month;
	}

	public void setMonth(Integer month) {
		this.month = month;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public String getSeller() {
		return seller;
	}

	public void setSeller(String seller) {
		this.seller = seller;
	}

	public Integer getItems() {
		return items;
	}

	public void setItems(Integer items) {
		this.items = items;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}
	
	public Double averagePrice() {
		return getTotal() / getItems();
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(month, seller);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Sale other = (Sale) obj;
		return Objects.equals(month, other.month) && Objects.equals(seller, other.seller);
	}

	@Override
	public String toString(){
		return getMonth()
				+ "/"
				+ getYear()
				+ ", "
				+ getSeller()
				+ ", "
				+ getItems()
				+ ", "
				+ String.format("%.2f", getTotal())
				+ ", pm = "
				+ String.format("%.2f", averagePrice());
	}

}
