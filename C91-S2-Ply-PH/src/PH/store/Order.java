package PH.store;

public class Order {
		//订单号
		public Integer oid;
		 //用户名
		public String name;
		//手机序号
		private Integer pid;
		//下单数量
		public Integer qty;
		//电话
		public String phone;
		//地址
		public String addr;
		//用户下单状态
		public String state;
		public Integer getOid() {
			return oid;
		}
		public void setOid(Integer oid) {
			this.oid = oid;
		}
		
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public void setPid(Integer pid) {
			this.pid = pid;
		}
		public Integer getQty() {
			return qty;
		}
		public void setQty(Integer qty) {
			this.qty = qty;
		}
		public String getPhone() {
			return phone;
		}
		public void setPhone(String phone) {
			this.phone = phone;
		}
		public String getAddr() {
			return addr;
		}
		public void setAddr(String addr) {
			this.addr = addr;
		}
		public String getState() {
			return state;
		}
		public void setState(String state) {
			this.state = state;
		}
		
		
}
