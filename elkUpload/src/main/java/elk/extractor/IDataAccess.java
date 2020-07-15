package elk.extractor;
//intraction with data base
public interface IDataAccess {
// reading from data base 
	public Object readData(String jobId);
	public String writeData(Object data);
	
}
