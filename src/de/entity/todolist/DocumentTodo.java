package de.entity.todolist;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: DocumentTodo
 * @author michael
 * @version 0.1
 */
@Entity

public class DocumentTodo implements Serializable {

	

	public DocumentTodo() {
		super();
	}
	
	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int documentnrabsolut;
	@Temporal(TemporalType.DATE)
	private java.util.Date uploaddate;
	private String comment;
	private String documentname;
	@Lob
	private byte[] filedata;
	private int sizeoffile;
	private String fileextension;
	@ManyToOne
	@JoinColumn(name="todonrabsolut")
	private Todo todo;
	private static final long serialVersionUID = 1L;

	/**
	 * Creates a new DocumentTodo object.
	 * @param documentname The document name
	 * @param comment A optional comment
	 * @param filedata The filedata
	 * @param fileextension The extension of file
	 * @param sizeoffile Size of file which is stored
	 * @param uploaddate Date of upload
	 * @param todo Todo object which contains this DocumentTodo object
	 */
	
	public DocumentTodo(String documentname, String comment, byte[] filedata, String fileextension, int sizeoffile,
			java.util.Date uploaddate, Todo todo) {
		super();
		this.documentname = documentname;
		this.comment = comment;
		this.filedata = filedata;
		this.fileextension = fileextension;
		this.sizeoffile = sizeoffile;
		this.uploaddate = uploaddate;
		this.todo = todo;
	}

	public int getDocumentnrabsolut() {
		return this.documentnrabsolut;
	}

	public void setDocumentnrabsolut(int documentnrabsolut) {
		this.documentnrabsolut = documentnrabsolut;
	}   
	public java.util.Date getUploaddate() {
		return this.uploaddate;
	}

	public void setUploaddate(Date uploaddate) {
		this.uploaddate = uploaddate;
	}   
	public String getComment() {
		return this.comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}   
	public String getDocumentname() {
		return this.documentname;
	}

	public void setDocumentname(String documentname) {
		this.documentname = documentname;
	}   
	public byte[] getFiledata() {
		return this.filedata;
	}

	public void setFiledata(byte[] filedata) {
		this.filedata = filedata;
	}   
	public int getSizeoffile() {
		return this.sizeoffile;
	}

	public void setSizeoffile(int sizeoffile) {
		this.sizeoffile = sizeoffile;
	}   
	public String getFileextension() {
		return this.fileextension;
	}

	public void setFileextension(String fileextension) {
		this.fileextension = fileextension;
	}   
	
	
	  
	
	public Todo getTodo() {
		return this.todo;
	}

	public void setTodo(Todo todo) {
		this.todo= todo;
	}
   
   
}
