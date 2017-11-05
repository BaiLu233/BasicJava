package service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Baby {
	private String name;
	private Date birthday;
	private char gender;
	private ArrayList<Gift> gifts = new ArrayList<>();	
	
	public Baby() {
		
	}
	public Baby(Date birthday, String name, char gender) {
		this.setBirthday(birthday);
		this.setName(name);
		this.setGender(gender);
	}
	public Baby(String birthday, String name, char gender) {
		try {
			this.birthday = new SimpleDateFormat("dd/mm/yyyy HH:mm").parse(birthday);
		}catch(ParseException exception) {
			System.out.println(exception.toString());
		}catch(Exception e) {
			System.out.println(e.toString());
		}
		this.setName(name);
		this.setGender(gender);
	}
	public boolean isOlder(Baby baby) {
		return getBirthday().after(baby.getBirthday());
	}
	public int howOld() {
		Date days = new Date();
		return days.getYear() - birthday.getYear();
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public char getGender() {
		return gender;
	}
	public void setGender(char gender) {
		this.gender = gender;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public void setBirthday(String birthday) {
		DateFormat dateformat = new SimpleDateFormat("dd/mm/yyyy HH:mm");
		try {
			this.birthday = dateformat.parse(birthday);
		}catch(ParseException exception) {
			System.out.println(exception.toString());
		}catch(Exception e) {
			System.out.println(e.toString());
		}
	}
	public String getGifts() {
		String info ="";
		for(Gift gift:gifts) {
			info += gift.getGiftGiver() + " give " + gift.getDescriptionGift() + ",";
		}
		return info;
	}
	public ArrayList<Gift> getListGifts() {
		return gifts;
	}
	public void setGifts(ArrayList<Gift> gifts) {
		this.gifts = gifts;
	}
	public void addOneGift(Gift gift) {
		gifts.add(gift);
	}
	
	@Override
	public String toString() {
		return "Thus baby was born on " + birthday +", the gender is " + gender + ", name  is " + name;
	}
	
}
