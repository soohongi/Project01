package udtmulchat;

public class Udpchat {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Chat_Frame cf = new Chat_Frame();
		
		new MultiCastSender(cf).start(); 
		new MultiCastRecieverMain(cf).start();

	}
}