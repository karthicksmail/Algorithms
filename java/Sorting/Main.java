public class Main {
	public static void main(String[] args) {
		Person p1 = new Person("Karthick", 34);
		Person p2 = new Person("Soumiya", 30);
		Person p3 = new Person("Darshan", 7);
		Person p4 = new Person("Deepshika", 1);
		Person p5 = new Person("Michelle", 35);
		Person p6 = new Person("Krishnan", 35);
		Person p7 = new Person("Ramya", 32);
		Person[] personArray = {p1, p2, p3, p4, p5, p6, p7};

		System.out.println("Before Sorting");
		for (int i = 0; i < personArray.length; i++) {
			personArray[i].display();
		}
		System.out.println("--------------------");

		Sort personSort = new SelectionSort(personArray);
		personSort.sort();

		System.out.println("After Sorting");
		for (int i = 0; i < personArray.length; i++) {
			personArray[i].display();
		}
		personSort.displayMetrics();
	}
}
