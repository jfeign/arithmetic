package d_linklist;


public class Linklist {
	private int data;
	private String address;
	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Linklist(int data, Linklist lastlist) {
		this.data = data;
		this.address = lastlist.getAddress();
	}
	
	public Linklist(int data) {
		this.data = data;
	}

}
