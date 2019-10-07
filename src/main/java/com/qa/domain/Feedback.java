package com.qa.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Feedback {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;

	private String whatHasGoneWellThisWeek;

	private String whatHasGonePoorlyThisWeek;

	private String whatIWillDoMoreOfNextWeek;

	private String whatIWillDoLessOfNextWeek;

	public Feedback() {

	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getWhatHasGoneWellThisWeek() {
		return whatHasGoneWellThisWeek;
	}


	public void setWhatHasGoneWellThisWeek(String whatHasGoneWellThisWeek) {
		this.whatHasGoneWellThisWeek = whatHasGoneWellThisWeek;
	}


	public String getWhatHasGonePoorlyThisWeek() {
		return whatHasGonePoorlyThisWeek;
	}


	public void setWhatHasGonePoorlyThisWeek(String whatHasGonePoorlyThisWeek) {
		this.whatHasGonePoorlyThisWeek = whatHasGonePoorlyThisWeek;
	}


	public String getWhatIWillDoMoreOfNextWeek() {
		return whatIWillDoMoreOfNextWeek;
	}


	public void setWhatIWillDoMoreOfNextWeek(String whatIWillDoMoreOfNextWeek) {
		this.whatIWillDoMoreOfNextWeek = whatIWillDoMoreOfNextWeek;
	}


	public String getWhatIWillDoLessOfNextWeek() {
		return whatIWillDoLessOfNextWeek;
	}


	public void setWhatIWillDoLessOfNextWeek(String whatIWillDoLessOfNextWeek) {
		this.whatIWillDoLessOfNextWeek = whatIWillDoLessOfNextWeek;
	}


	public Feedback(Long id, String name, String whatHasGoneWellThisWeek, String whatHasGonePoorlyThisWeek,
			String whatIWillDoMoreOfNextWeek, String whatIWillDoLessOfNextWeek) {
		super();
		this.id = id;
		this.name = name;
		this.whatHasGoneWellThisWeek = whatHasGoneWellThisWeek;
		this.whatHasGonePoorlyThisWeek = whatHasGonePoorlyThisWeek;
		this.whatIWillDoMoreOfNextWeek = whatIWillDoMoreOfNextWeek;
		this.whatIWillDoLessOfNextWeek = whatIWillDoLessOfNextWeek;
	}


	@Override
	public String toString() {

		return "id: " + id + ", name: " + name + ", questionResponse1: " + whatHasGoneWellThisWeek;
	}

}
