package misClases.teoria;

public class CGrados {

	private float gradosC; //grados centígrados
	
	public void CentigradosAsignar(float gC)
	{
		// Establecer el atributo grados centigrados
		gradosC = gC;
	}
	
	public float FahrenheitObtener()
	{
		//Retornar los grados fahrenheit equivalentes a gradosC
		return 9F/5F * gradosC + 32;  // retornar los grados centigrados
	}
	
	public float CentigradosObtener()
	{
		return gradosC; // retornar los grados centigrados
	}
}
