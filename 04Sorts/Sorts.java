public class Sorts{

    public static String name(){
	return "01.Yue.Min";
    }
    
    public static void selectionSort(int[] data){
	for (int location = 0; location < data.length; location ++){
	    int lookat = location;
	    int current = location;
	    int tempspot =  data[location];
	    lookat ++;
	    while (lookat < data.length){
		if (data[lookat] < tempspot){
		    tempspot = data[lookat];
		    current = lookat;
		}
		lookat ++;
	    }
	    data[current] = data[location];
	    data[location] = tempspot;
	}
    }

    public static void insertionSort(int[] data){
	for (int location = 0; location < data.length; location ++){
	    int tempspot = data[location];
	    int locup = location;
	    while(locup >= 1 && tempspot < data[locup - 1]){
		data[locup] = data[locup - 1];
		locup --;
	    }
	    data[locup] = tempspot;
	}
    }

    public static void bubbleSort(int[] data){
	int swaps = 5;
	while (swaps != 0){
	    swaps = 0;
	    for (int place = 0; place < data.length - 1; place ++){
		if (data[place] > data[place+1]){
		    int tempspot = 0;
		    tempspot = data[place + 1];
		    data[place + 1] = data[place];
		    data[place] = tempspot;
		    swaps += 1;
		}
	    }
	}
    }
	    
    
    public static void main(String[] args){
    	int[] hos = {1,0,8,4,9,6,7,2,6,3,4,7,2};
        bubbleSort(hos);
    	for (int i : hos) {
    	    System.out.println(i);
    	}
    }
}
