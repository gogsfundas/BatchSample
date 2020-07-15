package elk.extractor;

public interface ILogging {
	public void write(String component,String eventCode , String message , String detail);
}
