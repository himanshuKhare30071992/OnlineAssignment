package roughWork;

public class Test3
{
	public static void main(String[] args) {
		String confirmationText = "Your order on My Store is complete.";
		
		if(confirmationText.contains("complete"))
		{
			System.out.println("SUCCESS");
		}
		else
		{
			System.out.println("FAILED");
		}
		
	}

}
