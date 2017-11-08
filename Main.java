import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import service.Baby;
import service.Gift;

public class Main {
	private ArrayList<Baby> babies;
	private Scanner scanner = new Scanner(System.in);
	private ArrayList<Gift> gifts;
	public Date dateFormate(SimpleDateFormat myFormat) {
		Date day = new Date();
		boolean validDate = false;
		while(!validDate) {
			String date = scanner.nextLine();
			try {
				day = myFormat.parse(date);
				validDate = true;
			}catch(ParseException e) {
				System.out.println("Invalid date,dd/mm/yyyy pls");
				validDate = false;
			}
		}
		return day;
	}
	private void addBaby() {
		SimpleDateFormat myFormat = new SimpleDateFormat("dd/mm/yyyy HH:mm");
		System.out.println("What is the name of the Baby");
		String name = scanner.nextLine();
		System.out.println("Type of the gender(m/f):");
		String gender = scanner.nextLine();
		while(gender.charAt(0)!='m' && gender.charAt(0)!='f') {
			System.out.println("'m' or 'f' ???????,type again");
			gender = scanner.next();
		}
		System.out.println("The birthday of this baby is (dd/mm/yyyy HH:mm) :");
		Date day = dateFormate(myFormat);
		Baby baby = new Baby(day, name,gender.charAt(0));
		System.out.println("Add gift type Y Else finish");
		String gift = scanner.nextLine();
		if(gift.equals("y")||gift.equals("Y")) {
			baby.setGifts(addGiftEachBaby());
		}
		babies.add(baby);
		System.out.println("Finish to add this baby.");
	}
	public Gift addGift() {
		SimpleDateFormat myFormat = new SimpleDateFormat("dd/mm/yyyy");
		System.out.println("name of the gift giver");
		String giftGiver = scanner.nextLine();
		System.out.println("what is that :");
		String descriptionGift = scanner.nextLine();
		System.out.println("date of the gift(dd/mm/yyyy) :" );
		Date day = dateFormate(myFormat);
		Gift gift = new Gift(giftGiver,descriptionGift,day);
		return gift;
	}
	public void addGiftSingle() {
		System.out.println("Whom do you want to give this gift?");
		String name = scanner.nextLine();
		int i=0;
		for(i=0;i<babies.size();i++) {
			if(babies.get(i).getName().equals(name)) {
				break;
			}
		}
		if(i!=babies.size()) {
			System.out.println("here it is~");
			babies.get(i).addOneGift(addGift());
		}else {
			System.out.println("Unknow Name,gift for everyone");
			gifts.add(addGift());
		}
	}
	public ArrayList<Gift> addGiftEachBaby(){
		ArrayList <Gift> gifts = new ArrayList<>();
		String gift = "";
		do {
			gifts.add(addGift());
			System.out.println("to Finish type 'exit', to continue press Enter");
			gift = scanner.nextLine();
		}
		while(!gift.equals("exit"));
		return gifts;
		
	}
	public void printBaby() {
		for(Baby baby: babies) {
			System.out.println(baby.getName() + " is " + baby.howOld() + "years old");
		}
	}
	public void listBabyAge() {
		for(int i=0;i< babies.size() ;i++) {
			for(int j=0;j<babies.size()-i-1;j++) {
				if(babies.get(j).howOld()>babies.get(i).howOld()) {
					Baby tmpbaby = babies.get(j);
					babies.set(j, babies.get(j+1));
					babies.set(j+1, tmpbaby);
				}
			}
		}
		printBaby();
	}
	public void listBabyName() {
		for(int i=0;i< babies.size() ;i++) {
			for(int j=0;j<babies.size()-i-1;j++) {
				if(babies.get(j).getName().toLowerCase().compareTo(babies.get(j).getName().toLowerCase())>0) {
					Baby tmpbaby = babies.get(j);
					babies.set(j, babies.get(j+1));
					babies.set(j+1, tmpbaby);
				}
			}
		}
		printBaby();
	}
	public void listGift() {
		for(Baby baby:babies) {
			System.out.println("[name]: "+baby.getName()+"[Gifts] :" + baby.getGifts() );
		}
		if(gifts.size()>0) {
			System.out.println("Gift for every babies!");
			for(Gift gift: gifts) {
				System.out.println(gift);
			}
		}
	}
	public void pregnantSyetem() {
		String userCommand;
		//Here begin to test
		babies = new ArrayList<>();
		gifts = new ArrayList<>();
		
		Baby baby1 = new Baby("02/04/1998 06:20", "Lily",'f');
		Baby baby2 = new Baby("04/02/1998 03:10", "Wang Ziyan",'m');
		Baby baby3 = new Baby("25/12/1997 10:22", "Wang Yuchen",'m');
		babies.add(baby1);
		babies.add(baby2);
		babies.add(baby3);
		Gift gift1 = new Gift ("john cina","WEE golden bet","22/4/2000");
		Gift gift2 = new Gift ("Wang Hao","Iphone X","2/11/2017");
		Gift gift3 = new Gift ("Zhang Yan","Ipad 12.9","12/2/2016");
		Gift gift4 = new Gift ("Da ge","Synology icloud","22/4/2015");
		baby1.addOneGift(gift1);
		baby2.addOneGift(gift2);
		baby2.addOneGift(gift3);
		baby3.addOneGift(gift4);
		
		do {
			System.out.println("Command have:'exit','add_gift','list_gift','add_baby','list_babyName','list_babyAge'");
			userCommand = scanner.nextLine();
			switch(userCommand){
				case "add_baby":
					addBaby();
					break;
				case "add_gift":
					addGiftSingle();
					break;
				case "list_gift":
					listGift();
					break;
				case "list_babyName":
					listBabyName();
					break;
				case "list_babyAge":
					listBabyAge();
					break;
			}
			
		}while(!userCommand.equals("exit"));
		
	}
	public static void main(String args[]) {
		System.out.println("-------------------------------------------------------------");
		System.out.println("-------Welcom to Pregnant System-----------------------------");
		System.out.println("-------------------------------------------------------------");
		Main TestSystem = new Main();
		TestSystem.pregnantSyetem();
	}
	
	
}
