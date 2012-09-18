import java.util.HashMap;
import java.lang.reflect.Array;

public class Automata{

	private int[] reglaBinario = new int[8];
	private int numeroRegla;
	private HashMap<Integer,Integer> valoresRegla = new HashMap<Integer,Integer>();

	public Automata(int numeroRegla){
		//Asignar el numero de regla al objeto Automata
		this.numeroRegla = numeroRegla;
		//Pasar el  entero al arreglo binario
		generacionReglaBinario();
		//Crear el hashmap de la regla
		generacionHashMapRegla();
	}

	public void generacionReglaBinario(){
		int i,j = 7,valorTemporalRegla = numeroRegla;
		//Temporal array
		int[] arrayTemporal = new int[8];
		//pasar el numero de regla a binario
		for(i = 0; i < 8; i++){
			arrayTemporal[i] = valorTemporalRegla % 2;
			valorTemporalRegla = valorTemporalRegla / 2;
		}
		//Acomodar el numero binario
		i = 0;
		do{
			reglaBinario[i] = arrayTemporal[j];
			i++;
			j--;
		}while( j >= 0);
	}


	public void generacionHashMapRegla(){
		//Crear el hashmap con la regla
		int i,j = 7;
		for(i = 0;i < 8;i++){
			valoresRegla.put(i,reglaBinario[j]);
			j--;
		}
	}

	public int busquedaEnHashMapRegla(int[] patronBusqueda){
		return valoresRegla.get(binarioADecimal(patronBusqueda));
	}

	public int binarioADecimal(int[] convertirValor){
		return (convertirValor[2]*1 + convertirValor[1]*2 + convertirValor[0]*4);
	}

}