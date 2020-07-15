package elk.extractor;

public interface INotification {

	//push notification to queue
	public void notifyCompletion ( String JobId);
	//receive notification
	public String receiveNotification();
	//other notification shared to queue 
	public String shareNotification(String JobId);
	
	//share matrix notification 
	public String shareMatrixNotification ( String JobId);
	
}
