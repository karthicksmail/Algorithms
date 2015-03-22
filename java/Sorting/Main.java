import java.util.List;
import java.util.ArrayList;

public class Main {
	public static void main(String[] args) {
		Person p1 = new Person("Deepshika", 1);
		Person p2 = new Person("Darshan", 7);
		Person p3 = new Person("Soumiya", 30);
		Person p4 = new Person("Ramya", 32);
		Person p5 = new Person("Karthick", 34);
		Person p6 = new Person("Michelle", 35);
		Person p7 = new Person("Krishnan", 35);
		Person[] sortedArray = {p1, p2, p3, p4, p5, p6, p7};
		Person[] reverseSortedArray = {p7, p6, p5, p4, p3, p2, p1};
		Person[] randomlyOrderedArray = {p5, p1, p3, p2, p4, p7, p6};
		Person[] alternatelyReversedArray = {p2, p1, p4, p3, p6, p5, p7};

		Person[][] allArrays =	{
						sortedArray,
						reverseSortedArray,
						randomlyOrderedArray
					};

		List<Sort> sortArray = 	new ArrayList<Sort>();
		sortArray.add(new SelectionSort());
		sortArray.add(new InsertionSort());

		for (int s = 0; s < sortArray.size(); s++) {
			sortArray.get(s).title();
			for (int i = 0; i < allArrays.length; i++) {
				System.out.println("Before Sorting");
				for (int j = 0; j < allArrays[i].length; j++) {
					allArrays[i][j].display();
				}
				System.out.println("--------------------");

				sortArray.get(s).initialize(allArrays[i]);
				sortArray.get(s).sort();

				System.out.println("After Sorting");
				for (int j = 0; j < allArrays[i].length; j++) {
					allArrays[i][j].display();
				}
				sortArray.get(s).displayMetrics();
				System.out.println("*********************");
			}
		}
	}
}
