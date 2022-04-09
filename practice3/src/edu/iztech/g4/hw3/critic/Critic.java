package edu.iztech.g4.hw3.critic;

import edu.iztech.g4.hw3.content.Content;

public abstract class Critic implements ICritic {
	private final double opinion;
	private final int ID;
	private int occupation;
	private Content currentWork;

	public Critic(double opinion, int ID) {
		this.opinion = opinion;
		this.ID = ID;
	}

	public abstract int startWorking(Content currentWork);

	public void workOneHour() {
		if (this.occupation > 0)
			this.occupation -= 1;
	}

	public boolean isOccupied() {
		return this.occupation > 0;
	}

	@Override
	public String toString() {
		return String.valueOf(ID);
	}

	public double getOpinion() {
		return opinion;
	}

	public int getOccupation() {
		return occupation;
	}

	public void setOccupation(int occupation) {
		this.occupation = occupation;
	}

	public Content getCurrentWork() {
		return currentWork.clone();
	}

	public void setCurrentWork(Content currentWork) {
		this.currentWork = currentWork;

		if (currentWork != null)
			setOccupation(this.startWorking(currentWork));
	}

	public int getID() {
		return ID;
	}
}