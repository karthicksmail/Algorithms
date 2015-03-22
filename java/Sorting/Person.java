public class Person implements Comparable<Person> {
	private String name;
	private int age;

	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public int compareTo(Person that) {
		if (this.age < that.age) {
			return -1;
		} else if (this.age == that.age) {
			return 0;
		} else {
			return 1;
		}
	}

	public void display() {
		System.out.println("\t" + name + " " + age);
	}
}

