package edu.iztech.g4.hw3.content;

import java.util.Comparator;

public class RatedContent {
	private Content content;
	private double rate;

	public RatedContent(Content content, double rate) {
		this.content = content;
		this.rate = rate;
	}
	
	public RatedContent(RatedContent ratedContent) {
		this(ratedContent.content.clone(), ratedContent.rate);
	}

	@Override
	public String toString() {
		return String.format("%s, %.2f", content, rate);
	}
	
	@Override
	public RatedContent clone(){
		return new RatedContent(this);
	}

	public Content getContent() {
		return content;
	}

	/**
	 * Comparator function. Compares RatedContent's Content by Type and Name
	 * @return -1 for Movie instances or Alphabetically first names
	 */
	public static Comparator<RatedContent> TYPE_NAME = new Comparator<RatedContent>() {
		@Override
		public int compare(RatedContent c1, RatedContent c2) {
			Content c1Content = c1.getContent();
			Content c2Content = c2.getContent();

			if (c1Content instanceof Game && c2Content instanceof Game) {
				return compareNames(c1Content, c2Content);
			} else if (c1Content instanceof Movie && c2Content instanceof Movie) {
				return compareNames(c1Content, c2Content);
			} else {
				return c1Content instanceof Movie ? -1 : 1;
			}
		}

		private int compareNames(Content c1, Content c2) {
			return c1.getName().compareTo(c2.getName());
		}
	};

}
