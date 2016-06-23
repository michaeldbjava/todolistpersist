package de.entity.todolist;

import de.entity.todolist.Todolist;
import de.entity.user.User;
import java.io.Serializable;
import java.lang.String;
import java.sql.Date;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: DocumentTodolist
 * @author michael
 * @version 0.1
 */
@Entity

public class DocumentTodolist implements Serializable {

	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int documentnrabsolut;
	private Date uploaddate;
	private String comment;
	private String documentname;
	@Lob
	private byte[] filedata;
	private int sizeoffile;
	private String fileextension;
	@ManyToOne(fetch=FetchType.EAGER,cascade=CascadeType.PERSIST)
	@JoinColumn(name="todolistnr")
	private Todolist todolist;
	private static final long serialVersionUID = 1L;

	public DocumentTodolist() {
		super();
	}   
	   
	public int getDocumentnrabsolut() {
		return this.documentnrabsolut;
	}

	public void setDocumentnrabsolut(int documentnrabsolut) {
		this.documentnrabsolut = documentnrabsolut;
	}   
	public Date getUploaddate() {
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
	
	
	  
	
	public Todolist getTodolist() {
		return this.todolist;
	}

	public void setTodolist(Todolist todolist) {
		this.todolist = todolist;
	}
   
}
