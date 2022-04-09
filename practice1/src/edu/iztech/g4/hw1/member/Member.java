package edu.iztech.g4.hw1.member;

public class Member {
	private final int ID;
	private String name;
	private String email;

	public Member(int id, String name, String email) {
		this.ID = id;
		setName(name);
		setEmail(email);
	}

	public Member(Member member) {
		this.ID = member.ID;
		setName(member.name);
		setEmail(member.email);
	}
	
	/* 
	*  We would not use setters in this situation because it has not used anywhere else.
	*  But we wanted to use this anyway because it is part of the homework.
	*/
	
	public void setName(String name) {
		this.name = name;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getID() {
		return ID;
	}

	public String getName() {
		return name;
	}

	public boolean hasSameId(int id) {
		return this.ID == id;
	}

	@Override
	public String toString() {
		return "Member [ID=" + ID + ", name=" + name + ", email=" + email + "]";
	}

}
