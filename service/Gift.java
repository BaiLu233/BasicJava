package service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Gift {
	private String giftGiver;
	private String descriptionGift;
	private Date giftDate;
	public Gift() {
		
	}
	public Gift(String giftGiver,String descriptionGift,Date giftDate) {
		this.setGiftGiver(giftGiver);
		this.setDescriptionGift(descriptionGift);
		this.setGiftDate(giftDate);
	}
	public Gift(String giftGiver,String descriptionGift,String giftDate) {
		this.setGiftGiver(giftGiver);
		this.setDescriptionGift(descriptionGift);
		DateFormat dateformat = new SimpleDateFormat("dd/mm/yyyy");
		try {
			this.giftDate = dateformat.parse(giftDate);
		}catch (ParseException exception) {
			System.out.println(exception.toString());
		}catch (Exception e) {
			System.out.println(e.toString());
		}
	}
	public String getGiftGiver() {
		return giftGiver;
	}
	public void setGiftGiver(String giftGiver) {
		this.giftGiver = giftGiver;
	}
	public String getDescriptionGift() {
		return descriptionGift;
	}
	public void setDescriptionGift(String descriptionGift) {
		this.descriptionGift = descriptionGift;
	}
	public Date getGiftDate() {
		return giftDate;
	}
	public void setGiftDate(Date giftDate) {
		this.giftDate = giftDate;
	}
	public void setGiftDate(String giftDate) {
		DateFormat dateformat = new SimpleDateFormat("dd/mm/yyyy");
		try {
			this.giftDate = dateformat.parse(giftDate);
		}catch (ParseException exception) {
			System.out.println(exception.toString());
		}catch (Exception e) {
			System.out.println(e.toString());
		}
	}
	@Override
	public String toString() {
		return giftGiver + " gave " + descriptionGift + " on " + giftDate;
	}
	
	
}
