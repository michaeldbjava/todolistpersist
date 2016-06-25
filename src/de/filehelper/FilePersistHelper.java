package de.filehelper;

import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * 
 * @author michael
 * @version 0.1
 */
public class FilePersistHelper {
	private long fileSize = 0;
	private String fileExtension;
	private byte[] fileDate;

	public FilePersistHelper(String path) {
		super();
		try {
			this.fileSize = Files.size(Paths.get(path));
		} catch (Exception e) {
			e.printStackTrace();
		}
		this.fileExtension = FileExtensionExtractor.getFileExtension(path);
		this.fileDate = PathToByteArray.getByteArrayOfFile(path);
	}

	public long getFileSize() {
		return fileSize;
	}

	public void setFileSize(long fileSize) {
		this.fileSize = fileSize;
	}

	public String getFileExtension() {
		return fileExtension;
	}

	public void setFileExtension(String fileExtension) {
		this.fileExtension = fileExtension;
	}

	public byte[] getFileDate() {
		return fileDate;
	}

	public void setFileDate(byte[] fileDate) {
		this.fileDate = fileDate;
	}
	
	

}
