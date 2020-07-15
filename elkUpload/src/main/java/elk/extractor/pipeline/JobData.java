package elk.extractor.pipeline;

import elk.extractor.EXTRACTORTYPE;

public class JobData {
  
  String jobId;
  String orgId;
  String domain;
  String platform;
  String client;
  public EXTRACTORTYPE Type ;
public String getJobId() {
	return jobId;
}
public String getOrgId() {
	return orgId;
}
public String getDomain() {
	return domain;
}
public String getPlatform() {
	return platform;
}
public String getClient() {
	return client;
}
public void setJobId(String jobId) {
	this.jobId = jobId;
}
public void setOrgId(String orgId) {
	this.orgId = orgId;
}
public void setDomain(String domain) {
	this.domain = domain;
}
public void setPlatform(String platform) {
	this.platform = platform;
}
public void setClient(String client) {
	this.client = client;
}
public EXTRACTORTYPE getType() {
	return Type;
}
public void setType(EXTRACTORTYPE type) {
	Type = type;
}
  
}
