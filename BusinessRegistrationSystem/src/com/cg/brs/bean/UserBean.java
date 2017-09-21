package com.cg.brs.bean;

public class UserBean {

		private int firmId;
		private String ownerName;
		private String bName;
		private String eMailId;
		private Long mobileNo;
		private String isActive;
		
	
		public UserBean() {
	
		}

		public UserBean(int firmId, String ownerName, String bName,
				String eMailId, Long mobileNo, String isActive) {
			super();
			this.firmId = firmId;
			this.ownerName = ownerName;
			this.bName = bName;
			this.eMailId = eMailId;
			this.mobileNo = mobileNo;
			this.isActive = isActive;
		}
		
		public UserBean(String ownerName, String bName, String eMailId,
				long mobileNo) {
			super();
			this.ownerName = ownerName;
			this.bName = bName;
			this.eMailId = eMailId;
			this.mobileNo = mobileNo;
			
		}
		public int getFirmId() {
			return firmId;
		}
		public void setFirmId(int firmId) {
			this.firmId = firmId;
		}
		public String getOwnerName() {
			return ownerName;
		}
		public void setOwnerName(String ownerName) {
			this.ownerName = ownerName;
		}
		public String getbName() {
			return bName;
		}
		public void setbName(String bName) {
			this.bName = bName;
		}
		public String geteMailId() {
			return eMailId;
		}
		public void seteMailId(String eMailId) {
			this.eMailId = eMailId;
		}
		public Long getMobileNo() {
			return mobileNo;
		}
		public void setMobileNo(long mobileNo) {
			this.mobileNo = mobileNo;
		}
		public String getIsActive() {
			return isActive;
		}
		public void setIsActive(String isActive) {
			this.isActive = isActive;
		}

		@Override
		public String toString() {
			return "UserBean [firmId=" + firmId + ", ownerName=" + ownerName
					+ ", bName=" + bName + ", eMailId=" + eMailId
					+ ", mobileNo=" + mobileNo + ", isActive=" + isActive + "]";
		}
		
		
		
		

}
