package edu.iztech.g4.hw2.document;

public abstract class Document {
	private final int applicantId;

	public Document(int applicantId) {
		this.applicantId = applicantId;
	}

	public Document(Document document) {
		this(document.applicantId);
	}

	@Override
	public abstract Document clone();

	public int getApplicantId() {
		return applicantId;
	}

}
