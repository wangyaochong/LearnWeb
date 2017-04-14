package test.changeDb;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Entity(name = "aliyunomsitem")
public class AliyunOmsItemEntity implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	private String omsItemId;
	
	private String omsItem;
	private String omsItemCfg;
	private String price;
	
	public String getOmsItemId() {
		return omsItemId;
	}
	public void setOmsItemId(String omsItemId) {
		this.omsItemId = omsItemId;
	}
	public String getOmsItem() {
		return omsItem;
	}
	public void setOmsItem(String omsItem) {
		this.omsItem = omsItem;
	}
	public String getOmsItemCfg() {
		return omsItemCfg;
	}
	public void setOmsItemCfg(String omsItemCfg) {
		this.omsItemCfg = omsItemCfg;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	
}
