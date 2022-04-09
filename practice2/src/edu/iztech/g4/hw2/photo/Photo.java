package edu.iztech.g4.hw2.photo;

import edu.iztech.g4.hw2.utils.StringUtils;
import edu.iztech.g4.hw2.visa.IValidator;
import edu.iztech.g4.hw2.visa.Rejection;

public class Photo implements IValidator {
	private final int applicantID;
	private final String resolution;
	private final String position;

	public Photo(int applicantID, String resolution, String position) {
		this.applicantID = applicantID;
		this.resolution = resolution;
		this.position = position;
	}

	public Photo(Photo photo) { // Copy constructor
		this.applicantID = photo.applicantID;
		this.resolution = photo.resolution;
		this.position = photo.position;
	}

	/*
	 * The photo should be square Resolution should be between 600x600 and 1200x1200
	 * Accepted Positions are neutral face and natural smile
	 */
	@Override
	public Rejection checkValidity() {
		if (!isResolutionValid()) {
			return Rejection.PHOTO_BAD_RESOLUTION;
		}
		if (!isPositionValid()) {
			return Rejection.PHOTO_BAD_POSITION;
		}
		return null;
	}

	private boolean isPositionValid() {
		return position.equals(Position.NATURAL_SMILE.toString()) || position.equals(Position.NEUTRAL_FACE.toString());
	}

	private boolean isResolutionValid() {
		if (!isResolutionFormatValid() || !isResolutionSquare())
			return false;
		String[] resolutions = resolution.split("x");
		if (!StringUtils.isNumeric(resolutions[0]) || !StringUtils.isNumeric(resolutions[1]))
			return false;
		int resInt = Integer.parseInt(resolutions[0]);
		return resInt >= 600 && resInt <= 1200;
	}

	private boolean isResolutionSquare() {
		String[] resolutions = resolution.split("x");
		return resolutions[0].equals(resolutions[1]);
	}

	private boolean isResolutionFormatValid() {
		return !resolution.isBlank() && resolution.indexOf("x") != -1;
	}

	public int getApplicantID() {
		return applicantID;
	}

	@Override
	public Photo clone() {
		return new Photo(this);
	}
}
