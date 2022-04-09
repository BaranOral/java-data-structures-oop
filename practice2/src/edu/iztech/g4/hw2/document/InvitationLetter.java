package edu.iztech.g4.hw2.document;

public class InvitationLetter extends Document {

	public InvitationLetter(int applicantId) {
		super(applicantId);
	}

	public InvitationLetter(InvitationLetter invitationLetter) {
		super(invitationLetter);
	}

	@Override
	public InvitationLetter clone() {
		return new InvitationLetter(this);
	}
}
