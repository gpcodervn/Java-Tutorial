package com.gpcoder.objectcloning;

class PersonDeepClone implements Cloneable {
	int id;
	String name;
	AddressDeepClone address;

	public PersonDeepClone(int id, String name, AddressDeepClone address) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
	}

	public PersonDeepClone clone() throws CloneNotSupportedException {
		PersonDeepClone personCloned = (PersonDeepClone) super.clone();
		personCloned.address = this.address.clone();
		return personCloned;
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", address=" + address + "]";
	}
}

class AddressDeepClone implements Cloneable {
	String province;
	String district;

	public AddressDeepClone(String province, String district) {
		super();
		this.province = province;
		this.district = district;
	}

	public AddressDeepClone clone() throws CloneNotSupportedException {
		return (AddressDeepClone) super.clone();
	}

	@Override
	public String toString() {
		return "Address [province=" + province + ", district=" + district + "]";
	}
}

public class ObjectCloningExample3 {

	public static void main(String[] args) throws CloneNotSupportedException {
		AddressDeepClone address = new AddressDeepClone("Can Tho", "Ninh Kieu");
		PersonDeepClone person1 = new PersonDeepClone(1, "gpcoder", address);
		PersonDeepClone person2 = person1.clone();

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
