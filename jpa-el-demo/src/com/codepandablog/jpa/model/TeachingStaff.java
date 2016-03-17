package com.codepandablog.jpa.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
//@DiscriminatorValue(value = "TS")
@PrimaryKeyJoinColumn(referencedColumnName="sid")
public class TeachingStaff extends Staff {
	private String qualification;
	private String subjectexpertise;

	public String getQualification() {
		return qualification;
	}

	public void setQualification(String qualification) {
		this.qualification = qualification;
	}

	public String getSubjectexpertise() {
		return subjectexpertise;
	}

	public TeachingStaff() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TeachingStaff(int sid, String sname,
			String qualification, String subjectexpertise) {
		super(sid, sname);
		this.qualification = qualification;
		this.subjectexpertise = subjectexpertise;
	}

	public void setSubjectexpertise(String subjectexpertise) {
		this.subjectexpertise = subjectexpertise;
	}

}
