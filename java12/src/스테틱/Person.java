package ½ºÅ×Æ½;

public class Person {
	int height;
	int weight;
	int proper;
	String secret;
	String address;
	
	public Person() {
	}
	public Person(int height, int weight, String secret, String address) {
		this.height = height;
		this.weight = weight;
		this.secret = secret;
		this.address = address;
		proper = (int) ((height-100)*0.9);
	}
	public int getWeight() {
		return weight;
	}
	public String getSecret() {
		return secret;
	}
	
	
}
