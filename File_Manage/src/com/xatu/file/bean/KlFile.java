package com.xatu.file.bean;

import java.sql.Date;
import java.sql.Timestamp;

/**
 * нд╪Ч
 * 
 * @author zpp
 * 
 */
public class KlFile {

	private int klFile_ID;
	private String klFile_fileName;
	private String klFile_author;
	private int klFile_visitTimes;
	private int klFile_downloads;
	private String klFile_fileType;
	private double klFile_fileSize;
	private String klFile_documentClassification;
	private String klfile_savepath;
	private String klfile_describtion;
	private String klfile_uuid;
	private Timestamp klfile_uploadingTime;




	public Timestamp getKlfile_uploadingTime() {
		return klfile_uploadingTime;
	}

	public void setKlfile_uploadingTime(Timestamp klfile_uploadingTime) {
		this.klfile_uploadingTime = klfile_uploadingTime;
	}

	public String getKlfile_uuid() {
		return klfile_uuid;
	}

	public void setKlfile_uuid(String klfile_uuid) {
		this.klfile_uuid = klfile_uuid;
	}

	public String getKlfile_describtion() {
		return klfile_describtion;
	}

	public void setKlfile_describtion(String klfile_describtion) {
		this.klfile_describtion = klfile_describtion;
	}

	public String getKlfile_savepath() {
		return klfile_savepath;
	}

	public void setKlfile_savepath(String klfile_savepath) {
		this.klfile_savepath = klfile_savepath;
	}

	public int getKlFile_ID() {
		return klFile_ID;
	}

	public void setKlFile_ID(int klFile_ID) {
		this.klFile_ID = klFile_ID;
	}

	public String getKlFile_fileName() {
		return klFile_fileName;
	}

	public void setKlFile_fileName(String klFile_fileName) {
		this.klFile_fileName = klFile_fileName;
	}

	public String getKlFile_author() {
		return klFile_author;
	}

	public void setKlFile_author(String klFile_author) {
		this.klFile_author = klFile_author;
	}



	public int getKlFile_visitTimes() {
		return klFile_visitTimes;
	}

	public void setKlFile_visitTimes(int klFile_visitTimes) {
		this.klFile_visitTimes = klFile_visitTimes;
	}

	public int getKlFile_downloads() {
		return klFile_downloads;
	}

	public void setKlFile_downloads(int klFile_downloads) {
		this.klFile_downloads = klFile_downloads;
	}

	public String getKlFile_fileType() {
		return klFile_fileType;
	}

	public void setKlFile_fileType(String klFile_fileType) {
		this.klFile_fileType = klFile_fileType;
	}

	public double getKlFile_fileSize() {
		return klFile_fileSize;
	}

	public void setKlFile_fileSize(double klFile_fileSize) {
		this.klFile_fileSize = klFile_fileSize;
	}

	public String getKlFile_documentClassification() {
		return klFile_documentClassification;
	}

	public void setKlFile_documentClassification(
			String klFile_documentClassification) {
		this.klFile_documentClassification = klFile_documentClassification;
	}

}
