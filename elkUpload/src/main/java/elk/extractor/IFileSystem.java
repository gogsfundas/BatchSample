package elk.extractor;
// intraction with file system 
public interface IFileSystem {

	public String writeData (Object fileData);
	public String fileCount () ; // manage file count 
	public Object readData ( ); // reading from file 
	
}
