package com.gpcoder.objectcloning;

class Person implements Cloneable {
	int id;
	String name;
	Address address;

	public Person(int id, String name, Address address) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
	}

	public Person clone() throws CloneNotSupportedException {
		return (Person) super.clone();
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", address=" + address + "]";
	}
}

class Address {
	String province;
	String district;

	public Address(String province, String district) {
		super();
		this.province = province;
		this.district = district;
	}

	@Override
	public String toString() {
		return "Address [province=" + province + ", district=" + district + "]";
	}
}

public class ObjectCloningExample2 {

	public static void main(String[] args) throws CloneNotSupportedException {
		Address address = new Address("Can Tho", "Ninh Kieu");
		Person person1 = new Person(1, "gpcoder", address);
		Person person2 = person1.clone();

		System.out.println(person1);
		System.out.println(person2);

		System.out.println("\nPerson1.Address and Person2.Address are the same reference: ");
		System.out.println("Person1: " + getObjectAddress(person1));
		System.out.println("Person1.Address: " + getObjectAddress(person1.address));
		System.out.println("Person2: " + getObjectAddress(person2));
		System.out.println("Person2.Address: " + getObjectAddress(person2.address));

		System.out.println("\nAfter changed: ");
		person1.id = 4;
		person1.address.district = "Binh Thuy";

		System.out.println(person1);
		System.out.println(person2);
	}

	public static String getObjectAddress(Object obj) {
		return obj.getClass().getName() + "@" + Integer.toHexString(obj.hashCode());
	}
}
