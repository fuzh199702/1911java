package com.st.bean;

import java.util.List;

public class AnnoRe {

	private String annotation_id;
	private String annotationVisit_id;
	private String annotationUserPhone;
	private String annotationTime;
	private String annotationInfo;
	public String getAnnotation_id() {
		return annotation_id;
	}
	public void setAnnotation_id(String annotation_id) {
		this.annotation_id = annotation_id;
	}
	public String getAnnotationVisit_id() {
		return annotationVisit_id;
	}
	public void setAnnotationVisit_id(String annotationVisit_id) {
		this.annotationVisit_id = annotationVisit_id;
	}
	public String getAnnotationUserPhone() {
		return annotationUserPhone;
	}
	public void setAnnotationUserPhone(String annotationUserPhone) {
		this.annotationUserPhone = annotationUserPhone;
	}
	public String getAnnotationTime() {
		return annotationTime;
	}
	public void setAnnotationTime(String annotationTime) {
		this.annotationTime = annotationTime;
	}
	public String getAnnotationInfo() {
		return annotationInfo;
	}
	public void setAnnotationInfo(String annotationInfo) {
		this.annotationInfo = annotationInfo;
	}
	@Override
	public String toString() {
		return "AnnoRe [annotation_id=" + annotation_id + ", annotationVisit_id=" + annotationVisit_id
				+ ", annotationUserPhone=" + annotationUserPhone + ", annotationTime=" + annotationTime
				+ ", annotationInfo=" + annotationInfo + "]";
	}
}
