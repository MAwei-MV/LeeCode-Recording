package LiKouPractice;

public class Pro1603 {
	int big;
	int medium;
	int small;

	public Pro1603(int big, int medium, int small) {
		this.big = big;
		this.medium = medium;
		this.small = small;
	}

	public boolean addCar(int carType) {
		switch (carType) {
		case 1:
			return --big >= 0 ? true : false;
		case 2:
			return --medium >= 0 ? true : false;
		case 3:
			return --small >= 0 ? true : false;
		}
		return false;
	}
}
