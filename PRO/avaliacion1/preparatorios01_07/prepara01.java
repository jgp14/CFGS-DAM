package preparatorios01_07;

public class prepara01 {

	public static void main(String[] args) {
		byte a, c, e;
		short b, d, f;
		double x, y, z; 
		
		x=72345;
		a=(byte)x; 
		b=(short)x;
		System.out.print("\n a: "+a+" b: "+b);
		
		y=87643;
		c=(byte)y;
		d=(short)y;
		System.out.print("\n c: "+c+" d: "+d);
		
		z=92654;
		e=(byte)z;
		f=(short)z;
		System.out.print("\n e: "+e+" f: "+f);
	}
}

/*package preparatorios01_07;
 *	public static void main(String[] args){
 *		byte a, c, e; 
 *		short b, d, f;
 *		double x, y, z;
 *
 *		x=72345;	//65536 + 6809 = 
 *		a=(byte)x;
 *		b=(short)x;
 *		System.out.print("\n a: "+a+" b: "+b);
 *
 *		y=87643;	//65536 + 22107 = 87643
 *		c=(byte)y;
 *		d=(short)y;
 *		System.out.print("\n c: "+c+" d: "+d);
 *
 *		z=92654		//65536 + 27118 = 92654
 *		e=(byte)z;
 *		f=(short)z;
 *		System.out.print("\n e: "+e+" f: "+f);
 *	} 
 */
