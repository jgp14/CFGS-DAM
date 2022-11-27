package teoria.capitulo07;

public class CStringBuffer {

	public static void main(String[] args) {
		StringBuffer strb0 = new StringBuffer();
		StringBuffer strb1 = new StringBuffer(80);
		StringBuffer strb2 = new StringBuffer("abc");
		
		System.out.println(strb0 + " " + strb0.length() + " " + strb0.capacity());
		System.out.println(strb1 + " " + strb1.length() + " " + strb1.capacity());
		System.out.println(strb2 + " " + strb2.length() + " " + strb2.capacity());
		
		strb2.append("ghfahfdhkjhdfsjhdkshkdsjhdfkjhkhdfskjhdskjshffgfdg");
		System.out.println(strb2 + " " + strb2.length() + " " + strb2.capacity());

/////////////////
		
		System.out.println();
		StringBuffer strb3 = new StringBuffer("Mes de del año ");
		strb3.insert(7, "Abril ");
		strb3.append(2021);
		System.out.println(strb3 + " " + strb3.length() + " " + strb3.capacity());


	}
}
