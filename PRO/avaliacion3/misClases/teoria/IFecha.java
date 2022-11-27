package misClases.teoria;

import java.util.Calendar;

public interface IFecha {
	
	  public static final int DIA_DEL_MES = Calendar.DAY_OF_MONTH;;
	  
	  public static final int MES_DEL_ANHO = Calendar.MONTH;
	  
	  public static final int ANHO = Calendar.YEAR;
	  
	  int dia();
	  
	  int mes();
	  
	  int anho();
}
